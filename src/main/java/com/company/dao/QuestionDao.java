package com.company.dao;

import com.company.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface QuestionDao {
    String TABLE_NAME = " Question ";
    String INSERT_FIELD = " title,content,user_id,create_date,comment_count ";
    String SELECT_FIELD = "id, " + INSERT_FIELD;

    @Insert({"insert into", TABLE_NAME, "(", INSERT_FIELD,
            ") values(#{title},#{content},#{userId},#{createDate},#{commentCount})"})
     int addQuestion(Question question);

    List<Question> findLatestQuestions(@Param("userId") int userId,
                                      @Param("offset") int offset,
                                      @Param("limit") int limit);
}
