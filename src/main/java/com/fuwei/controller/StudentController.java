package com.fuwei.controller;


import com.fuwei.pojo.Student;
import com.fuwei.service.StudentService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

// 告诉spring mvc这是一个控制器类
@Controller
/*@ContextConfiguration("classpath:memcachedContext.xml")*/
@RequestMapping("")
public class StudentController {
	@Autowired
	StudentService studentService;
	/*@Autowired
	RedisUtil redisUtil;*/

	/*@RequestMapping(value="/index",method= RequestMethod.GET)
	public ModelAndView listCategory(){

		ModelAndView mav = new ModelAndView();
		//List<Student> cs= studentService.list();
		List<Student> cs1= studentService.list1();
		int count= studentService.count(1);
		int count2= studentService.count(2);
		// 放入转发参数
		mav.addObject("cs", cs1);
		mav.addObject("cs1", count);
		mav.addObject("cs2", count2);
		// 放入jsp路径

		mav.setViewName("index");
		return mav;
	}*/

	/*@RequestMapping(value="/ajax",method=RequestMethod.GET)
	public String get(HttpServletResponse response) throws IOException {
		Gson gson = new Gson();
		List<Student> cs1= studentService.list1();
		//添加memcached缓存(在list1函数调用哪里添加)
		for (Student c : cs1) {
			MemcachedUtil.put("hello", c.toString(), 60);
			//System.out.println(c.toString());
		}
		String str = gson.toJson(cs1);
		//MemcachedUtil.put("hello", , 60);
		System.out.println(str);
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().println(str.toString());
		return null;
	}*/
	@RequestMapping(value="/ajax",method=RequestMethod.GET)
	public String get(HttpServletResponse response) throws IOException {
		Gson gson = new Gson();
		List<Student> cs1= studentService.list1();
		//添加memcached缓存(在list1函数调用哪里添加)
	/*for (Student c : cs1) {
		MemcachedUtil.put("Student",c.toString(),60);
			System.out.println(c.toString());
		}*/
		String str = gson.toJson(cs1);

		//MemcachedUtil.put("hello", , 60);
		System.out.println(str+"+++++");
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().println(str.toString());
		return null;
	}

@RequestMapping(value = "/ajax1",method=RequestMethod.GET)
	public String ajax1(){
	System.out.println("json请求");
	int count= studentService.count(1);
	return String.valueOf(count);
}

}
