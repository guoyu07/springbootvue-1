package com.mofan.springboot_vue.persistence;

import java.util.List;
import java.util.Map;

public abstract class BaseDaoImpl<T,M extends IBaseMapper<T>> extends BaseDao implements SuperBaseDao<T>{

	protected abstract Class<M> getMappgerClass();

	protected M getMapperByClass() {
        return getSqlSession().getMapper(getMappgerClass());
    }

	@Override
	public List<T> list() {
		return getMapperByClass().selectAll();
	}

	@Override
	public int insertBean(T t) {
		return getMapperByClass().insertSelective(t);
	}

	@Override
	public int deleteBean(int keyId) {
		return getMapperByClass().deleteByPrimaryKey(keyId);
	}

	@Override
	public int updateBean(T t) {
		return getMapperByClass().updateByPrimaryKeySelective(t);
	}
	
	@Override
	public T getBeanByKeyId(int keyId) {
		return getMapperByClass().selectByPrimaryKey(keyId);
	}
	@Override
	public int count(Map<String,Object> param){
		return getMapperByClass().count(param);
	}
}
