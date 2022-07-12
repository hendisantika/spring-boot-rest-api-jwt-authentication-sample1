package com.hendisantika.service;

import com.hendisantika.repository.AuthorRepository;
import com.hendisantika.repository.BookRepository;
import com.hendisantika.repository.LendRepository;
import com.hendisantika.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-rest-api-jwt-authentication-sample1
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 7/12/22
 * Time: 23:24
 * To change this template use File | Settings | File Templates.
 */
@Service
@RequiredArgsConstructor
public class LibraryService {

    private final AuthorRepository authorRepository;
    private final MemberRepository memberRepository;
    private final LendRepository lendRepository;
    private final BookRepository bookRepository;
}
