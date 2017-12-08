package com.mofan.springboot_vue.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mofan.springboot_vue.dao.FactoryDao;
import com.mofan.springboot_vue.model.Factory;
import com.mofan.springboot_vue.persistence.Page;
import com.mofan.springboot_vue.service.FactoryService;
import com.mofan.springboot_vue.vo.FactoryVO;

@Service("factoryService")
public class FactoryServiceImpl implements FactoryService {
	
	@Autowired
	private FactoryDao factoryDao;
	
	@Override
	public Factory getById(Integer id) {
		return factoryDao.getById(id);
	}

	@Override
	public Page<FactoryVO> findPage(Page<FactoryVO> page, FactoryVO factory) {
		factory.setPage(page);
		page.setList(factoryDao.findList(factory));
		return page;
	}

	@Override
	public Factory getByName(String name) {
		return factoryDao.getByName(name);
	}

	@Override
	public boolean save(Factory factory) {
		if (null != factory.getId() && factory.getId().intValue() > 0) {
			return factoryDao.update(factory) > 0;
		} else {
			return factoryDao.insert(factory) > 0;
		}
	}

	@Override
	public boolean delete(int id) {
		return factoryDao.delete(id) > 0;
	}
}
