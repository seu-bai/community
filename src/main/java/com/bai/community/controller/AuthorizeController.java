package com.bai.community.controller;

import com.bai.community.dto.AccessTokenDto;
import com.bai.community.dto.GithubUserDto;
import com.bai.community.mapper.UserMapper;
import com.bai.community.model.User;
import com.bai.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @Auther: Bai
 * Description: 向github授权访问
 * Created in 2021/01/20 16:00
 */
@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @Value("${github.client.id}")
    private String ClientId;
    @Value("${github.client.secret}")
    private String ClientSecret;
    @Value("${github.redirect.uri}")
    private String RedirectUri;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletResponse response) {
        AccessTokenDto accessTokenDto = new AccessTokenDto();
        accessTokenDto.setCode(code);
        accessTokenDto.setClient_id(ClientId);
        accessTokenDto.setClient_secret(ClientSecret);
        accessTokenDto.setState(state);
        accessTokenDto.setRedirect_uri(RedirectUri);
        String accessToken = githubProvider.getAccessToken(accessTokenDto);
        GithubUserDto githubUserDto = githubProvider.getUser(accessToken);
        if (githubUserDto != null && githubUserDto.getId()!=null) {
            //登陆成功，写session
            User user = new User();
            user.setAccountId(String.valueOf(githubUserDto.getId()));
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            user.setName(githubUserDto.getName());
            userMapper.insert(user);
            response.addCookie(new Cookie("token",token));
            return "redirect:/";
        } else {
            //登录失败，重新登陆
            return "redirect:/";
        }
    }
}
