package com.fuwei.service.impl;

import com.fuwei.mapper.StudentMapper;
import com.fuwei.pojo.Student;
import com.fuwei.service.StudentService;
import com.fuwei.util.MemcachedUtil;
import com.fuwei.util.RedisUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import java.util.List;

@Service
/*@ContextConfiguration("classpath:memcachedContext.xml")*/ //memcached的缓存
@ContextConfiguration("classpath:spring-redis.xml")        //redis的缓存
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
	if(redisUtil.get("Student") !=null){
			students= (List<Student>) redisUtil.get("Student");
			logger.info("从缓存里面取移动端"+students+"-----+----");
			System.out.println("从缓存里面取移动端"+students+"-----+----");
			return students;
		}else {
			students=studentMapper.list();
		redisUtil.set("Student",students);
			System.out.println("存储在缓存"+students+"123-----+----");
			return students;
		}

	}


	@Override
	public int count(int state) {
		return studentMapper.count(state);

	}
}
