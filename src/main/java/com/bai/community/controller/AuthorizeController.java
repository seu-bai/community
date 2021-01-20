package com.bai.community.controller;

import com.bai.community.dto.AccessTokenDto;
import com.bai.community.dto.GithubUserDto;
import com.bai.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Auther: Bai
 * Description: 向github授权访问
 * Created in 2021/01/20 16:00
 */
@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state) {
        AccessTokenDto accessTokenDto = new AccessTokenDto();
        accessTokenDto.setCode(code);
        accessTokenDto.setClient_id("88309a30533087fa3ad9");
        accessTokenDto.setClient_secret("84db99ce9e02af0792d37383237fe77080828a37");
        accessTokenDto.setState(state);
        accessTokenDto.setRedirect_uri("http://localhost:8887/callback");
        String accessToken=githubProvider.getAccessToken(accessTokenDto);
        GithubUserDto user=githubProvider.getUser(accessToken);
        System.out.println(user.getName());
        return "index";
    }
}
