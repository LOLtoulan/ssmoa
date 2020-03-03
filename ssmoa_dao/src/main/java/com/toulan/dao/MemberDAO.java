package com.toulan.dao;

import com.toulan.domain.Member;
import org.apache.ibatis.annotations.Select;

/**
 * @Author LOL_toulan
 * @Time 2020/2/29 10:16
 * @Message
 */
public interface MemberDAO {

    @Select("select * from member where id=#{id}")
    Member findById(String id);
}
