package com.hendisantika.filter;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-rest-api-jwt-authentication-sample1
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 7/13/22
 * Time: 05:34
 * To change this template use File | Settings | File Templates.
 */
public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

    public JWTAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }
}
