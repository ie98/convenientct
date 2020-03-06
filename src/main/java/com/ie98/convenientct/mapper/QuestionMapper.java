package com.exmaple.Demo.mapper;

import com.exmaple.Demo.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface QuestionMapper {
    @Insert("insert into question (title , description , gmt_create ,gmt_modified , comment_count , view_count , like_count , tag )values(#{title},#{description},#{gmtcreate},#{gmtmodified},#{commentcount},#{viewcount},#{likecount},#{tag}) ")
    void Insert(Question question);

}
