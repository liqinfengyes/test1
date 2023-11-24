package com.example.service;

import com.example.dao.StudentMapper;
import com.example.domain.Student;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class ServiceDemo {

    public static void main(String[] args) throws IOException {

//        Reader reader= Resources.getResourceAsReader("sqlMapConfig.xml");
//        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
//        //获得回话
//        SqlSession sqlSession=sqlSessionFactory.openSession();
//
//        StudentMapper studentMapper=sqlSession.getMapper(StudentMapper.class);
//        //执行操作   参数：namespace+id
//        List<Student> studentList = studentMapper.findAll();
//        //打印
//        System.out.println(studentList);
        //Student student=new Student();
        //student.setId(15);
        //student.setName("asd");
        //student.setAddress("宁波");
        //student.setGrade(77);
        Reader reader= Resources.getResourceAsReader("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
        //获得回话
        SqlSession sqlSession=sqlSessionFactory.openSession();

        StudentMapper studentMapper=sqlSession.getMapper(StudentMapper.class);
        //执行操作   参数：namespace+id

        //设置分页设置，当前页和每页显示个数
        //PageHelper.startPage(1,1);



        List<Student> studentList=studentMapper.findAll();
        for(Student student : studentList){
            System.out.println(student);
        }
        System.out.println("1");
        System.out.println("211");
        System.out.println("2111");
        System.out.println("hit-fix");
        System.out.println("push-fix");
        System.out.println("pull-commit");


        //github更新
        sqlSession.close();
//        System.out.println(studentList);
//        List<Student> studentList = studentMapper.findByCondition(student);
        //打印
//        System.out.println(studentList);

    }
}
