package com.fuwei.controller;


import com.fuwei.pojo.CarrerDetail;
import com.fuwei.service.CarrerDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

// 告诉spring mvc这是一个控制器类
@Controller
@RequestMapping("")
public class CarrerDetailController {
	@Autowired
    CarrerDetailService studentService;

	@RequestMapping(value="/detail",method= RequestMethod.GET)
	public ModelAndView DetailList(){
	
		ModelAndView mav = new ModelAndView();
		List<CarrerDetail> html= studentService.list1("前端开发方向");
		List<CarrerDetail> java= studentService.list1("后端开发方向");
		List<CarrerDetail> move= studentService.list1("移动开发方向");
		List<CarrerDetail> whole= studentService.list1("整站开发方向");
		List<CarrerDetail> run= studentService.list1("运维开发方向");

		Long date = System.currentTimeMillis();//这个不能除以1000
		// 放入转发参数
		mav.addObject("html", html);
		mav.addObject("java", java);
		mav.addObject("move", move);
		mav.addObject("whole", whole);
		mav.addObject("run", run);
		mav.addObject("date",date);
		// 放入jsp路径
		mav.setViewName("/detail");
		return mav;
	}

	@RequestMapping(value="/templet",method= RequestMethod.GET)
	public ModelAndView DetailTiles() {

		ModelAndView mav1 = new ModelAndView();
		List<CarrerDetail> html = studentService.list1("前端开发方向");
		List<CarrerDetail> java = studentService.list1("后端开发方向");
		List<CarrerDetail> move = studentService.list1("移动开发方向");
		List<CarrerDetail> whole = studentService.list1("整站开发方向");
		List<CarrerDetail> run = studentService.list1("运维开发方向");

		// 放入转发参数
		mav1.addObject("html", html);
		mav1.addObject("java", java);
		mav1.addObject("move", move);
		mav1.addObject("whole", whole);
		mav1.addObject("run", run);
		// 放入jsp路径
		mav1.setViewName("CustomerDetail");
		return mav1;
	}


}


/* //保存到cookies
            Cookie cookie=new Cookie("Pwd1",Pwd1);
            Cookie cookie1=new Cookie("Name",loginResult.getName());
            //对cookies进行设置
            cookie.setMaxAge(60);
            cookie1.setMaxAge(60);
            cookie.setPath("/");
            cookie1.setPath("/");
            //添加到请求
            response.addCookie(cookie);
            response.addCookie(cookie1);*/