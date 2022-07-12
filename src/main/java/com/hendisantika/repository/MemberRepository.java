package com.hendisantika.repository;

import com.hendisantika.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-rest-api-jwt-authentication-sample1
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 7/12/22
 * Time: 23:22
 * To change this template use File | Settings | File Templates.
 */
public interface MemberRepository extends JpaRepository<Member, Long> {
}
