package com.mofan.springboot_vue.persistence;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @Author  mofan
 * @Since  2017/12/8
 */
public abstract class BaseDao extends SqlSessionDaoSupport {
	
	@Autowired
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }
	
	protected <T> T getMapper(Class<T> clazz) {
        return getSqlSession().getMapper(clazz);
    }
}
