package com.bai.community.exception;

/**
 * @Auther: Bai
 * Description: community
 * Created in 2021/03/10 11:23
 */
public enum CustomizeErrorCode implements ICustomizeErrorCode {
    QUESTION_NOT_FOUND("你找的问题不在了，换一个试试吧！");

    @Override
    public String getMessage() {
        return message;
    }

    private String  message;

    CustomizeErrorCode(String message) {
        this.message = message;
    }
}
