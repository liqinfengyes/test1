package com.example.domain;

public class sage {
    private Student student;//当前学生身高对应的学生信息
    private int age;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "sage{" +
                "student=" + student +
                ", age=" + age +
                '}';
    }

}
