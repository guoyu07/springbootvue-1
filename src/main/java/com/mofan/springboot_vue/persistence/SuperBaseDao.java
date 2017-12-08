package com.mofan.springboot_vue.persistence;

import java.util.List;
import java.util.Map;


public interface SuperBaseDao<T> {
	public List<T> list();
	
	public T getBeanByKeyId(int keyId);
	
	public int insertBean(T t);

	public int deleteBean(int keyId);

	public int updateBean(T t);
	
	public List<T> list(Map<String,Object> param);
	
	 public int count(Map<String,Object> param);
}
