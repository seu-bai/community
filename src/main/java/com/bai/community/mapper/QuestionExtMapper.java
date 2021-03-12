package com.bai.community.mapper;

import com.bai.community.model.Question;
import org.apache.ibatis.annotations.Param;

public interface QuestionExtMapper {
    int addViewCount(Question record);
}