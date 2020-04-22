package hospital.common.filter;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.filter.OncePerRequestFilter;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class CsrfFilterConfig {
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Bean
    public FilterRegistrationBean filterRegist() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new OncePerRequestFilter() {
            @Override
            protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
                //把从授权服务器传递过来的csrfToken设定到cookie中发送到前台（客户端）
                CsrfToken csrf = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
                if (csrf != null) {
                    //Cookie cookie = WebUtils.getCookie(request, "CSRF-TOKEN");
                    String token = csrf.getToken();
                    Cookie cookie = new Cookie("X-CSRF-TOKEN", token);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                }
                filterChain.doFilter(request, response);
            }
        });
        filterRegistrationBean.addUrlPatterns("/*");
        log.debug("注册CSRF-COOKIE过滤器");
        return filterRegistrationBean;
    }
}