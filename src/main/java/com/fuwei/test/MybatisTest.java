package com.fuwei.test;

import com.fuwei.mapper.CarrerDetailMapper;
import com.fuwei.mapper.StudentMapper;
import com.fuwei.pojo.CarrerDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MybatisTest {

	@Autowired
	private CarrerDetailMapper carrerDetailMapper;
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
		List<CarrerDetail> cs=carrerDetailMapper.list1("前端开发方向");
		for (CarrerDetail s : cs) {
			System.out.println(s.getName());
		}
	}

}
