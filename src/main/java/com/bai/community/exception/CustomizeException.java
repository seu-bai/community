package com.bai.community.exception;

/**
 * @Auther: Bai
 * Description: community
 * Created in 2021/03/10 11:12
 */
public class CustomizeException extends  RuntimeException {
    private String message;

    public CustomizeException(ICustomizeErrorCode errorCode){
        this.message=errorCode.getMessage();
    }

    public CustomizeException(String message){
        this.message=message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
