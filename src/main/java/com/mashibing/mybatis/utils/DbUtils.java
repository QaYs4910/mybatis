package com.mashibing.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class DbUtils {

    private static SqlSessionFactory factory;

    public static SqlSessionFactory getInstance(){
        if(factory == null){
            InputStream in = null;
            try{
                in = Resources.getResourceAsStream("mybatis-cfg.xml");
            }catch (Exception e){
                e.printStackTrace();
            }
            synchronized (DbUtils.class){
                if(factory == null){
                    factory = new SqlSessionFactoryBuilder().build(in);
                }
            }
        }
        return factory;
    }


}
