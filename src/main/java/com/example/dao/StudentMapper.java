package com.example.dao;

import com.example.domain.Student;

import java.io.IOException;
import java.util.List;

public interface StudentMapper {

    public List<Student> findAll() throws IOException;


    public Student findById(int i) throws IOException;

    public List<Student> findByCondition(Student student);

    public List<Student> findlds(List<Integer> ids);

}
