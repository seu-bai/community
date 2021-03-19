package com.bai.community.exception;

/**
 * @Auther: Bai
 * Description: community
 * Created in 2021/03/10 11:12
 */
public class CustomizeException extends  RuntimeException {
    private String message;
    private Integer code;

    public CustomizeException(ICustomizeErrorCode errorCode){
        this.code=errorCode.getCode();
        this.message=errorCode.getMessage();
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }
}
