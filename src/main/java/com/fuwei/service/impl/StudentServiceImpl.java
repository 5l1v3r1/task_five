package com.fuwei.service.impl;

import com.fuwei.mapper.StudentMapper;
import com.fuwei.pojo.Student;
import com.fuwei.service.StudentService;
import com.fuwei.util.MemcachedUtil;
import com.fuwei.util.RedisUtil;
import com.google.gson.Gson;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Service
/*@ContextConfiguration("classpath:memcachedContext.xml")*/ //memcached的缓存
@ContextConfiguration("classpath:applicationContext.xml")        //redis的缓存
public class StudentServiceImpl implements StudentService {
	private Logger logger=Logger.getLogger(StudentServiceImpl.class);
	@Autowired
	StudentMapper studentMapper;
	@Autowired
	RedisUtil redisUtil;

	
	/*public List<Student> list(){
		*//*List<Student> ls=studentMapper.list();
		MemcachedUtil.put("Student", ls, 60);
		Object obj = MemcachedUtil.get("Student".toString() );
		System.out.println(obj);*//*
		return studentMapper.list();
	}*/

	public List<Student> list1() {
		List<Student> students;
	if(redisUtil.exists("student2")){
			students= (List<Student>) redisUtil.get("student2");
			logger.info("从缓存里面取移动端"+students+"-----+----");
			System.out.println("从缓存里面取移动端"+students+"-----+----");
			return students;
		}else {
			students=studentMapper.list();
			redisUtil.set("student2",students);
		System.out.println("存储在缓存"+students+"123-----+----");
			return students;
		}

	}


	@Override
	public int count(int state) {
		return studentMapper.count(state);

	}
}
