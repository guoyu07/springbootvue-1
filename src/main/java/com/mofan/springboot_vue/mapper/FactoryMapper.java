package com.mofan.springboot_vue.mapper;

import java.util.List;
import java.util.Map;

import com.mofan.springboot_vue.model.Factory;
import com.mofan.springboot_vue.vo.FactoryVO;

public interface FactoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Factory record);

    int insertSelective(Factory record);

    Factory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Factory record);

    int updateByPrimaryKey(Factory record);
    
    Factory selectByMap(Map<String, Object> map);
    
    List<FactoryVO> findList(FactoryVO factory);
}