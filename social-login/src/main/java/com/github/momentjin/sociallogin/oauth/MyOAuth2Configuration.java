package com.github.momentjin.sociallogin.oauth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;

import java.util.Collections;

/**
 * Created by momentjin@gmail.com on 2019-12-21
 * Github : http://github.com/momentjin
 */

@Configuration
public class MyOAuth2Configuration {

    @Bean
    public OAuth2AuthorizedClientService authorizedClientService(MyOAuth2AuthorizedClientService myOAuth2AuthorizedClientService) {
        return myOAuth2AuthorizedClientService;
    }

    @Bean
    public ClientRegistrationRepository clientRegistrationRepository() {
        final ClientRegistration clientRegistration = CustomOAuthProvider.KAKAO
                .getBuilder()
                .build();

        return new InMemoryClientRegistrationRepository(Collections.singletonList(
                clientRegistration
        ));
    }

}
