package com.bai.community.dto;

import lombok.Data;

/**
 * @Auther: Bai
 * Description: community
 * Created in 2021/01/20 16:06
 */
@Data
public class AccessTokenDto {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;

}
