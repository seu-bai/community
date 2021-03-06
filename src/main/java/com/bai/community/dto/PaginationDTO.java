package com.bai.community.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Bai
 * Description: community
 * Created in 2021/03/03 15:50
 */
@Data
public class PaginationDTO {
    private List<QuestionDTO> questions;
    private boolean showPrevious;
    private boolean showFirstPage;
    private boolean showNext;
    private boolean showEndPage;
    private Integer page;
    private List<Integer> pages = new ArrayList<>();
    private Integer totalPage;

    public void setPagination(Integer totalPage, Integer page) {
        this.totalPage=totalPage;
        this.page = page;
        pages.add(page);
        for (int i = 1; i <= 3; i++) {
            if (page - i > 0) {
                pages.add(0, page - i);
            }
            if (page + i <= totalPage) {
                pages.add(page + i);
            }
        }

        //是否展示上一页下一页
        if (page == 1) showPrevious = false;
        else showPrevious = true;
        if (page == totalPage) showNext = false;
        else showNext = true;

        //是否展示第一页最后一页
        if (pages.contains(1)) showFirstPage = false;
        else showFirstPage = true;
        if (pages.contains(totalPage)) showEndPage = false;
        else showEndPage = true;


    }
}
