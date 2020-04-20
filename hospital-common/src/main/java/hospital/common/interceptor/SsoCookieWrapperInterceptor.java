package hospital.common.interceptor;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
/**
 * 单点登录后使用httpclient调用其他客户端的api需要传递cookie
 * 该拦截器统一保存ssocookie到request，方便调用是获取后设置到请求头来维持登录
 * 应该有更好的解决方案，以后再优化
 * @author Administrator
 *
 */
public class SsoCookieWrapperInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		StringBuffer ssoCookies = new StringBuffer();
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			ssoCookies
				.append(cookie.getName())
				.append("=")
				.append(cookie.getValue())
				.append(";");
		}
		ssoCookies.deleteCharAt(ssoCookies.length() - 1);
		request.setAttribute("ssoCookies", ssoCookies.toString());
		return true;
	}
}
