package com.bai.community.enums;

import com.bai.community.model.Comment;
import com.bai.community.model.Question;

/**
 * @Auther: Bai
 * Description: community
 * Created in 2021/03/19 10:37
 */
public enum CommentTypeEnum {
    Question(1),
    Comment(2);
    private Integer type;

    public static boolean isExist(Integer type) {
        for (CommentTypeEnum value : CommentTypeEnum.values()) {
            if (value.getType()==type)
                return true;
        }
        return false;
    }

    public Integer getType() {
        return type;
    }

    CommentTypeEnum(Integer type) {
        this.type = type;
    }
}
