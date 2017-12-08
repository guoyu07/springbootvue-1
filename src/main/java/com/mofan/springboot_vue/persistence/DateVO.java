package com.mofan.springboot_vue.persistence;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 数据Entity
 * 
 * @author fan_mo
 *
 * @version 2017年4月27日
 *
 * @param <T>
 */
public abstract class DateVO<T> extends BaseVO<T> {

	private static final long serialVersionUID = 1L;

	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	protected Date createTime; // 创建日期
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	protected Date updateTime; // 更新日期

	public DateVO() {

	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
