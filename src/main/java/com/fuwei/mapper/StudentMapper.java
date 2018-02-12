package com.fuwei.mapper;

import com.fuwei.pojo.Student;

import java.util.List;

public interface StudentMapper {

    public List<Student> list();

    public int count(int state);


}