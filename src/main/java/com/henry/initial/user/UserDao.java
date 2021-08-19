package com.henry.initial.user;

import lombok.AllArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class UserDao {

    private SqlSession sqlSession;

    public void makeUserEnabled(String userId) {
        sqlSession.update("user.makeUserEnabled", userId);
    }

    public void delUser(int no) {
        sqlSession.delete("user.delUser", no);
    }

}
