package com.fuwei.test;

import com.fuwei.mapper.StudentMapper;
import com.fuwei.pojo.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MybatisTest1 {

	@Autowired
	private StudentMapper studentMapper;

	/*//	@Test
	public void testAdd() {
		for (int i = 0; i < 100; i++) {
			Category category = new Category();
			category.setName("new Category");
			categoryMapper.add(category);
		}

	}*/


	@Test
	public void testList() {
		List<Student> cs=studentMapper.list();
		for (Student s : cs) {
			System.out.println(s.getName());
		}
	}

	/*在线人数统计测试*/
	@Test
	public void testconut() {
		int cs=studentMapper.count(1);

			System.out.println(cs);
	}

}
