package com.hendisantika.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-rest-api-jwt-authentication-sample1
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 7/12/22
 * Time: 23:23
 * To change this template use File | Settings | File Templates.
 */
@Service
@RequiredArgsConstructor
public class AuthenticationUserDetailService implements UserDetailsService {

    private final UserService userService;
}
