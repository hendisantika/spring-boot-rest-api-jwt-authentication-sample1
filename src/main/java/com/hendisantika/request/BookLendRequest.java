package com.hendisantika.request;

import lombok.Data;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-rest-api-jwt-authentication-sample1
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 7/12/22
 * Time: 23:19
 * To change this template use File | Settings | File Templates.
 */
@Data
public class BookLendRequest {
    private List<Long> bookIds;
    private Long memberId;
}
