package com.bai.community.model;

import lombok.Data;

/**
 * @Auther: Bai
 * Description: community
 * Created in 2021/01/21 16:24
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
    private String avatarUrl;

}
