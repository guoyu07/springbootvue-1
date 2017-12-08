package com.mofan.springboot_vue.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.annotation.JSONField;
import com.mofan.springboot_vue.utils.CookieUtils;

/**
 * 分页实体
 * @author  fan_mo
 *
 * @version 2017年4月27日
 *
 * @param <T>
 */
public class Page<T> {

	private int pageNo = 1; // 当前页码
	private int pageSize = 15; // 页面大小，设置为“-1”表示不进行分页（分页无效）

	private long total;// 总记录数，设置为“-1”表示不查询总数

	private List<T> rows = new ArrayList<T>();

	public Page() {
		this.pageSize = -1;
	}

	/**
	 * 构造方法
	 * 
	 * @param request
	 *            传参数 repage 参数，来记住页码
	 * @param response
	 *            用于设置 Cookie，记住页码
	 */
	public Page(HttpServletRequest request, HttpServletResponse response) {
		this(request, response, -2);
	}

	/**
	 * 构造方法
	 * 
	 * @param request
	 *            传递page 参数，来记住页码
	 * @param response
	 *            用于设置 Cookie，记住页码
	 * @param defaultPageSize
	 *            默认分页大小，如果传递 -1 则为不分页
	 */
	public Page(HttpServletRequest request, HttpServletResponse response, int defaultPageSize) {
		// 设置页码参数（传递repage参数，来记住页码�?
		String no = request.getParameter("pageNo");
		if (StringUtils.isNumeric(no)) {
			CookieUtils.setCookie(response, "pageNo", no);
			this.setPageNo(Integer.parseInt(no));
		} else if (request.getParameter("repage") != null) {
			no = CookieUtils.getCookie(request, "pageNo");
			if (StringUtils.isNumeric(no)) {
				this.setPageNo(Integer.parseInt(no));
			}
		}
		// 设置页面大小参数（传递repage参数，来记住页码大小�?
		String size = request.getParameter("pageSize");
		if (StringUtils.isNumeric(size)) {
			CookieUtils.setCookie(response, "pageSize", size);
			this.setPageSize(Integer.parseInt(size));
		} else if (request.getParameter("repage") != null) {
			size = CookieUtils.getCookie(request, "pageSize");
			if (StringUtils.isNumeric(size)) {
				this.setPageSize(Integer.parseInt(size));
			}
		} else if (defaultPageSize != -2) {
			this.pageSize = defaultPageSize;
		}
	}

	/**
	 * 构�?�方�?
	 * 
	 * @param pageNo
	 *            当前页码
	 * @param pageSize
	 *            分页大小
	 */
	public Page(int pageNo, int pageSize) {
		this(pageNo, pageSize, 0);
	}

	/**
	 * 构�?�方�?
	 * 
	 * @param pageNo
	 *            当前页码
	 * @param pageSize
	 *            分页大小
	 * @param count
	 *            数据条数
	 */
	public Page(int pageNo, int pageSize, long total) {
		this(pageNo, pageSize, total, new ArrayList<T>());
	}

	/**
	 * 构�?�方�?
	 * 
	 * @param pageNo
	 *            当前页码
	 * @param pageSize
	 *            分页大小
	 * @param count
	 *            数据条数
	 * @param list
	 *            本页数据对象列表
	 */
	public Page(int pageNo, int pageSize, long total, List<T> list) {
		this.setTotal(total);
		this.setPageNo(pageNo);
		this.pageSize = pageSize;
		this.rows = list;
	}

	/**
	 * 获取设置总数
	 * 
	 * @return
	 */
	public long getTotal() {
		return total;
	}

	/**
	 * 设置数据总数
	 * 
	 * @param count
	 */
	public void setTotal(long total) {
		this.total = total;
		if (pageSize >= total) {
			pageNo = 1;
		}
	}

	/**
	 * 获取当前页码
	 * 
	 * @return
	 */
	public int getPageNo() {
		return pageNo;
	}

	/**
	 * 设置当前页码
	 * 
	 * @param pageNo
	 */
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	/**
	 * 获取页面大小
	 * 
	 * @return
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * 设置页面大小（最�?500�?
	 * 
	 * @param pageSize
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize <= 0 ? 10 : pageSize;// > 500 ? 500 : pageSize;
	}


	/**
	 * 获取本页数据对象列表
	 * 
	 * @return List<T>
	 */
	public List<T> getRows() {
		return rows;
	}

	/**
	 * 设置本页数据对象列表
	 * 
	 * @param list
	 */
	public Page<T> setList(List<T> rows) {
		this.rows = rows;
		return this;
	}


	/**
	 * 获取 Hibernate FirstResult
	 */
	@JSONField(serialize = false)
	public int getFirstResult() {
		int firstResult = (getPageNo() - 1) * getPageSize();
		if (firstResult >= getTotal()) {
			firstResult = 0;
		}
		return firstResult;
	}

	/**
	 * 获取 Hibernate MaxResults
	 */
	@JSONField(serialize = false)
	public int getMaxResults() {
		return getPageSize();
	}

}
