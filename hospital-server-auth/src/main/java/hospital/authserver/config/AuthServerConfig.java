package hospital.authserver.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

@Configuration
//开启认证服务
@EnableAuthorizationServer
public class AuthServerConfig extends AuthorizationServerConfigurerAdapter { //进行认证配置

    @Autowired
    public DataSource dataSource;

    @Bean
    public TokenStore tokenStore() {
        return new JdbcTokenStore(dataSource);
    }
//    @Bean
//    public JwtTokenStore jwtTokenStore() {
//        return new JwtTokenStore(jwtAccessTokenConverter());
//    }
//
//    @Bean
//    public JwtAccessTokenConverter jwtAccessTokenConverter() {
//        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
//        jwtAccessTokenConverter.setSigningKey("cjs");   //  Sets the JWT signing key
//        return jwtAccessTokenConverter;
//    }
    @Bean
    public ClientDetailsService jdbcClientDetailsService() {
        return new JdbcClientDetailsService(dataSource);
    }

    /**
     * 配置客户端
     *
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
    	//从数据库中的第三方应用信息表中查询对应的记录，如果不是已经登记在数据中应用，不允许使用oauth授权登录
        clients.withClientDetails(jdbcClientDetailsService());
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
    	//把access_token保存到数据库，也可以保存到内存，或者是redis
        endpoints.tokenStore(tokenStore());
//        endpoints.allowedTokenEndpointRequestMethods(HttpMethod.GET,HttpMethod.POST);
//    	endpoints.accessTokenConverter(jwtAccessTokenConverter());
//    	endpoints.tokenStore(jwtTokenStore());
    }
    
    @Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
    	
		security
			// 开启/oauth/token_key验证端口无权限访问
	        .tokenKeyAccess("permitAll()")
//	        // 开启/oauth/check_token验证端口认证权限访问
//	        .checkTokenAccess("isAuthenticated()")
	        //允许第三方应用通过表单传递client_id,client_secret来登录
			.allowFormAuthenticationForClients();
	}
}
