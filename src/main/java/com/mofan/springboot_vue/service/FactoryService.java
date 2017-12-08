package com.mofan.springboot_vue.service;

import com.mofan.springboot_vue.model.Factory;
import com.mofan.springboot_vue.persistence.Page;
import com.mofan.springboot_vue.vo.FactoryVO;

/**
 * 厂家service接口
 * @author fan_mo
 *
 */
public interface FactoryService {

	public Factory getById(Integer id);
	
	public Page<FactoryVO> findPage(Page<FactoryVO> page,FactoryVO factory);
	
	public Factory getByName(String name);
	
	public boolean save(Factory factory);
	
	public boolean delete(int id);
}
