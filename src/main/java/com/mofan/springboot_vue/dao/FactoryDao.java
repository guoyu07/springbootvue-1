package com.mofan.springboot_vue.dao;

import java.util.List;

import com.mofan.springboot_vue.model.Factory;
import com.mofan.springboot_vue.vo.FactoryVO;

public interface FactoryDao {

	public Factory getByName(String name);
	
	public Factory getById(int id);
	
	public List<FactoryVO> findList(FactoryVO factoryVO);
	
	public int insert(Factory factory);
	
	public int update(Factory factory);
	
	public int delete(int id);
}
