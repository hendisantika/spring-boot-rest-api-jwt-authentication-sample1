package com.hendisantika.request;

import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-rest-api-jwt-authentication-sample1
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 7/12/22
 * Time: 23:18
 * To change this template use File | Settings | File Templates.
 */
@Data
public class BookCreationRequest {
    private String name;
    private String isbn;
    private Long authorId;
}
