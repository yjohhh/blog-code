package com.github.momentjin.sociallogin.oauth;

import com.github.momentjin.sociallogin.domain.Member;
import com.github.momentjin.sociallogin.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.LinkedHashMap;

/**
 * Created by momentjin@gmail.com on 2019-12-11
 * Github : http://github.com/momentjin
 */

@Service
public class MyOAuth2AuthorizedClientService implements OAuth2AuthorizedClientService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public void saveAuthorizedClient(OAuth2AuthorizedClient oAuth2AuthorizedClient, Authentication authentication) {
        String providerType = oAuth2AuthorizedClient.getClientRegistration().getRegistrationId();
        OAuth2AccessToken accessToken = oAuth2AuthorizedClient.getAccessToken();

        OAuth2User oauth2User = (OAuth2User) authentication.getPrincipal();
        String id = oauth2User.getName();
        String name = oauth2User.getAttribute("name");

        Member member = new Member(id, name, providerType, accessToken.getTokenValue());
        memberRepository.save(member);
    }

    @Override
    public <T extends OAuth2AuthorizedClient> T loadAuthorizedClient(String s, String s1) {
        throw new NotImplementedException();
    }

    @Override
    public void removeAuthorizedClient(String s, String s1) {
        throw new NotImplementedException();
    }

}
