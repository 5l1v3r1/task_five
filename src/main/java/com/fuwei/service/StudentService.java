package com.fuwei.service;

import com.fuwei.pojo.Student;

import java.util.List;

public interface StudentService {

	List<Student> list();
	int count(int state);

}
