package hospital.common.http;
import javax.servlet.http.HttpServletRequest;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import hospital.common.response.Response;
import hospital.common.response.ResponseEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Component
@Slf4j
public class HttpClientHelper {
	@Autowired
	private HttpServletRequest request;
	private ObjectMapper objectMapper = new ObjectMapper();
	public HttpClientHelper(HttpServletRequest request) {
		this.request = request;
	}
	/**
	 * 访问单点登录的其他模块的api
	 * @param uri
	 * @return
	 */
	public Response getForResponse(String uri) {
		CloseableHttpClient  httpClient = HttpClientBuilder.create().build();
		CloseableHttpResponse  response = null;
		try {
			String ssoCookies = (String) request.getAttribute("ssoCookies");
			HttpGet httpGet = new HttpGet(uri);
			httpGet.addHeader("Cookie", ssoCookies);
			response = httpClient.execute(httpGet);
			HttpEntity httpEntity = response.getEntity();
			//授权过期,需要用户重新授权
			Header contentType = (Header) response.headerIterator("Content-Type").next();
			if(contentType.getValue().startsWith("text/html")) {//请求授权页面
				return new Response(ResponseEnum.ERROR).setResponseBody("调用目标的授权已经失效，请先重新获取授权<a href='"+uri+"'>授权</a>");
			}
			String result = null;
			if(httpEntity != null) {
				result = EntityUtils.toString(httpEntity);
				System.out.println(result);
				if(log.isDebugEnabled()) {
					log.debug("响应内容：{}",result);
				}
				if(response.getStatusLine().getStatusCode() == 200) {
					return objectMapper.readValue(result,Response.class);
				}
			}
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
		} finally {
			HttpClientUtils.closeQuietly(httpClient);
			HttpClientUtils.closeQuietly(response);
		}
		return new Response(ResponseEnum.ERROR).setResponseBody("出错了");
	}
	/**
	 * 访问单点登录的其他模块的api
	 * @param uri
	 * @return
	 */
	public Response postForResponse(String uri, Map<String, Object> params) {
		CloseableHttpClient  httpClient = HttpClientBuilder.create().build();
		CloseableHttpResponse  response = null;
		try {
			String ssoCookies = (String) request.getAttribute("ssoCookies");
			HttpPost httpPost = new HttpPost(uri);
			httpPost.addHeader("Cookie", ssoCookies);
			//
			List<NameValuePair> nameValuePairs = new ArrayList<>();
			params.forEach((k,v) -> {
				if(v != null) {
					nameValuePairs.add(new BasicNameValuePair(k, v.toString()));
				}
			});
			httpPost.setHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:75.0) Gecko/20100101 Firefox/75.0");
			httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			response = httpClient.execute(httpPost);
			HttpEntity httpEntity = response.getEntity();
			//授权过期,需要用户重新授权
			Header contentType = (Header) response.headerIterator("Content-Type").next();
			if(contentType.getValue().startsWith("text/html")) {//请求授权页面
				return new Response(ResponseEnum.ERROR).setResponseBody("调用目标的授权已经失效，请先重新获取授权<a href='"+uri+"'>授权</a>");
			}

			String result = null;
			if(httpEntity != null) {
				result = EntityUtils.toString(httpEntity);

				if(log.isDebugEnabled()) {
					log.debug("响应内容：{}",result);
				}
				if(response.getStatusLine().getStatusCode() == 200) {
					return objectMapper.readValue(result,Response.class);
				}
			}
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
		} finally {
			HttpClientUtils.closeQuietly(httpClient);
			HttpClientUtils.closeQuietly(response);
		}
		return new Response(ResponseEnum.ERROR).setResponseBody("出错了");
	}
	/**
	 * 普通http请求
	 * @param uri
	 * @return
	 */
	public String get(String uri) {
		CloseableHttpClient  httpClient = HttpClientBuilder.create().build();
		CloseableHttpResponse  response = null;
		String result = null;
		try {
			HttpGet httpGet = new HttpGet(uri);
			response = httpClient.execute(httpGet);
			result = EntityUtils.toString(response.getEntity());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
		} finally {
			HttpClientUtils.closeQuietly(httpClient);
			HttpClientUtils.closeQuietly(response);
		}
		return result;
	}
	/**
	 * 普通http请求
	 * @param uri
	 * @return
	 */
	public String post(String uri) {
		CloseableHttpClient  httpClient = HttpClientBuilder.create().build();
		CloseableHttpResponse  response = null;
		String result = null;
		try {
			HttpPost httpPost = new HttpPost(uri);
			response = httpClient.execute(httpPost);
			result = EntityUtils.toString(response.getEntity());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
		} finally {
			HttpClientUtils.closeQuietly(httpClient);
			HttpClientUtils.closeQuietly(response);
		}
		return result;
	}
}
