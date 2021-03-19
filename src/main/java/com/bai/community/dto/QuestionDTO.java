package com.bai.community.dto;

import com.bai.community.model.User;
import lombok.Data;

/**
 * @Auther: Bai
 * Description: community
 * Created in 2021/03/03 9:49
 */
@Data
public class QuestionDTO {
    private Long id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer viewCount;
    private Integer commentCount;
    private User user;
}
