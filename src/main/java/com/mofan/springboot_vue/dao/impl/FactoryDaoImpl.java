package com.mofan.springboot_vue.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.google.common.collect.Maps;
import com.mofan.springboot_vue.dao.FactoryDao;
import com.mofan.springboot_vue.mapper.FactoryMapper;
import com.mofan.springboot_vue.model.Factory;
import com.mofan.springboot_vue.persistence.BaseDao;
import com.mofan.springboot_vue.vo.FactoryVO;

@Repository("factoryDao")
public class FactoryDaoImpl extends BaseDao implements FactoryDao {

	@Override
	public Factory getByName(String name) {
		Map<String, Object> params = Maps.newHashMap();
		params.put("name", name);
		return this.getMapper(FactoryMapper.class).selectByMap(params);
	}

	@Override
	public Factory getById(int id) {
		return this.getMapper(FactoryMapper.class).selectByPrimaryKey(id);
	}

	@Override
	public List<FactoryVO> findList(FactoryVO factoryVO) {
		return this.getMapper(FactoryMapper.class).findList(factoryVO);
	}

	@Override
	public int insert(Factory factory) {
		return this.getMapper(FactoryMapper.class).insert(factory);
	}

	@Override
	public int update(Factory factory) {
		return this.getMapper(FactoryMapper.class).updateByPrimaryKey(factory);
	}

	@Override
	public int delete(int id) {
		return this.getMapper(FactoryMapper.class).deleteByPrimaryKey(id);
	}

}
