package com.mashibing.mybatis;

import com.mashibing.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.io.InputStream;

@SpringBootTest
class MybatisApplicationTests {

    @Test
    void contextLoads() throws IOException {


        InputStream in = Resources.getResourceAsStream("mybatis-cfg.xml");

        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sessionFactory.openSession();
        User user = new User("张明","山东","男");
        int count = sqlSession.insert("com.mashibing.mybatis.pojo.User.addUser", user);
        System.out.println(count+":影响的行数");
        //mybatis默认不会进行数据的提交
        sqlSession.commit();
        sqlSession.close();
    }

}
