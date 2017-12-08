package com.mofan.springboot_vue.persistence;

import java.util.List;
import java.util.Map;

public interface IBaseMapper<T>{
	public int deleteByPrimaryKey(Integer productId);

    public int insert(T record);

    public int insertSelective(T record);

    public T selectByPrimaryKey(Integer productId);

    public int updateByPrimaryKeySelective(T record);

    public int updateByPrimaryKey(T record);
    
    public List<T> selectAll();
    
    public List<T> list(Map<String,Object> param);
    
    public int count(Map<String,Object> param);
}
