package com.bai.community.dto;

/**
 * @Auther: Bai
 * Description: community
 * Created in 2021/03/17 16:03
 */
public class CommentDTO {
    private Long parentId;
    private String content;
    private int type;

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
