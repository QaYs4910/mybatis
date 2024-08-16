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
import java.util.List;

@SpringBootTest
class MybatisApplicationTests {

    @Test
    void contextLoads() throws IOException {

        //添加
        InputStream in = Resources.getResourceAsStream("mybatis-cfg.xml");

        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sessionFactory.openSession();
        User user = new User("张慧","湖州","女");
        int count = sqlSession.insert("com.mashibing.mybatis.pojo.User.addUser", user);
        System.out.println(count+":影响的行数");
        //mybatis默认不会进行数据的提交
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    void test() throws IOException {

        //修改
        InputStream in = Resources.getResourceAsStream("mybatis-cfg.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sessionFactory.openSession();
        User user = new User(3,"张帆","湖北","男");
        int count = sqlSession.insert("com.mashibing.mybatis.pojo.User.updateUser", user);
        System.out.println(count+":影响的行数");
        //mybatis默认不会进行数据的提交
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    void test2() throws IOException {
        //根据id删除
        InputStream in = Resources.getResourceAsStream("mybatis-cfg.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sessionFactory.openSession();
        int count = sqlSession.delete("com.mashibing.mybatis.pojo.User.deleteUser", 2);
        System.out.println(count+":影响的行数");
        //mybatis默认不会进行数据的提交
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    void test03() throws IOException {
        //查询所有
        InputStream in = Resources.getResourceAsStream("mybatis-cfg.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sessionFactory.openSession();
        List<Object> list = sqlSession.selectList("com.mashibing.mybatis.pojo.User.allUser");
        System.out.println(list.toString());
        //mybatis默认不会进行数据的提交
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    void test04() throws IOException {
        //查询所有
        InputStream in = Resources.getResourceAsStream("mybatis-cfg.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sessionFactory.openSession();
        List<Object> list = sqlSession.selectList("com.mashibing.mybatis.pojo.User.queryById", 5);
        System.out.println(list.toString());
        //mybatis默认不会进行数据的提交
        sqlSession.commit();
        sqlSession.close();
    }
}
