package com.bai.community.dto;

import lombok.Data;

/**
 * @Auther: Bai
 * Description: community
 * Created in 2021/01/20 19:23
 */
@Data
public class GithubUserDto {
    private String name;
    private Long id;
    private String bio;
    private String avatar_url;
}
