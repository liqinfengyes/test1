package com.example;

import com.example.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.List;

public class MybatisTest {
    @Test
    public void test_() throws IOException {
        //获取核心配置文件
       // InputStream resour= Resources.class.getResourceAsStream("sqlMapconfig.xml");
        //获得session工厂对象
        Reader reader=Resources.getResourceAsReader("sqlMapconfig.xml");
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
        //获得回话
        SqlSession sqlSession=sqlSessionFactory.openSession();
        //执行操作   参数：namespace+id
        List<Student> studentList = sqlSession.selectList("studentMapper.findAll");
        //打印
        System.out.println(studentList);
        //释放资源
        sqlSession.close();
    }
    @Test
    public void test1() throws IOException {
        Student student=new Student();
        student.setId(15);
        student.setName("Alice");
        student.setAddress("宁波");
        student.setGrade(77);
        //获取核心配置文件
        // InputStream resour= Resources.class.getResourceAsStream("sqlMapconfig.xml");
        //获得session工厂对象
        Reader reader=Resources.getResourceAsReader("sqlMapconfig.xml");
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
        //获得回话
        SqlSession sqlSession=sqlSessionFactory.openSession(true);
        //执行操作   参数：namespace+id
        sqlSession.insert("studentMapper.save",student);
        //提交事务
        //sqlSession.commit();
        //关闭事务
        sqlSession.close();
    }
    @Test
    public void test2() throws IOException {
        Student student=new Student();
        student.setId(4);
        student.setName("Ad");
        student.setAddress("宁波");
        student.setGrade(67);
        //获取核心配置文件
        // InputStream resour= Resources.class.getResourceAsStream("sqlMapconfig.xml");
        //获得session工厂对象
        Reader reader=Resources.getResourceAsReader("sqlMapconfig.xml");
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
        //获得回话
        SqlSession sqlSession=sqlSessionFactory.openSession();
        //执行操作   参数：namespace+id
        sqlSession.update("studentMapper.update",student);
        //提交事务
        sqlSession.commit();
        //关闭事务
        sqlSession.close();
    }
    @Test
    public void test3() throws IOException {
        //获取核心配置文件
        // InputStream resour= Resources.class.getResourceAsStream("sqlMapconfig.xml");
        //获得session工厂对象
        Reader reader=Resources.getResourceAsReader("sqlMapconfig.xml");
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
        //获得回话
        SqlSession sqlSession=sqlSessionFactory.openSession();
        //执行操作   参数：namespace+id
        sqlSession.delete("studentMapper.delete",3);
        //提交事务
        sqlSession.commit();
        //关闭事务
        sqlSession.close();
    }
}
