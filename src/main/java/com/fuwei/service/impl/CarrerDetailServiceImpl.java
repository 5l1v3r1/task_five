package com.fuwei.service.impl;

import com.fuwei.mapper.CarrerDetailMapper;
import com.fuwei.pojo.CarrerDetail;
import com.fuwei.service.CarrerDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarrerDetailServiceImpl implements CarrerDetailService {
	@Autowired
    CarrerDetailMapper carrerDetailMapper;
	
	
	public List<CarrerDetail> list1(String carrerDetail){
		return carrerDetailMapper.list1(carrerDetail);
	}


}
