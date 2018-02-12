package com.fuwei.controller;


import com.fuwei.pojo.Student;
import com.fuwei.service.StudentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

// 告诉spring mvc这是一个控制器类
@Controller
@RequestMapping("")
public class StudentController {
	@Autowired
	StudentService studentService;

	@RequestMapping(value="/index",method= RequestMethod.GET)
	public ModelAndView listCategory(){
	
		ModelAndView mav = new ModelAndView();
		List<Student> cs= studentService.list();
		int count= studentService.count(1);
		int count2= studentService.count(2);
		// 放入转发参数
		mav.addObject("cs", cs);
		mav.addObject("cs1", count);
		mav.addObject("cs2", count2);
		// 放入jsp路径

		mav.setViewName("index");
		return mav;
	}



}
