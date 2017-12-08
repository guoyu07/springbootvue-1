package com.mofan.springboot_vue.persistence;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlTransient;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.alibaba.fastjson.annotation.JSONField;


/**
 * Entity
 * @author  fan_mo
 *
 * @version 2017年4月27日
 *
 * @param <T>
 */
public abstract class BaseVO<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 实体编号
	 */
	protected int id;

	/**
	 * 当前实体分页对象
	 */
	@JSONField(serialize = false)
	protected Page<T> page;
	
	/**
	 * 自定义SQL
	 */
	protected Map<String, String> sqlMap;
	
	public BaseVO() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@XmlTransient
	@JSONField(serialize = false)
	public Page<T> getPage() {
		if (page == null){
			page = new Page<T>();
		}
		return page;
	}
	
	public Page<T> setPage(Page<T> page) {
		this.page = page;
		return page;
	}

	@XmlTransient
	@JSONField(serialize = false)
	public Map<String, String> getSqlMap() {
		if (sqlMap == null){
			sqlMap = new HashMap<String,String>();
		}
		return sqlMap;
	}

	public void setSqlMap(Map<String, String> sqlMap) {
		this.sqlMap = sqlMap;
	}
	
	
    @Override
    public boolean equals(Object obj) {
        if (null == obj) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!getClass().equals(obj.getClass())) {
            return false;
        }
        BaseVO<?> that = (BaseVO<?>) obj;
        return 0 == this.getId() ? false : this.getId() == that.getId();
    }
    
    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
	
}
