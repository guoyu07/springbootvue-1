package com.mofan.springboot_vue.persistence.interceptor;

import java.io.Serializable;
import java.util.Properties;

import org.apache.ibatis.plugin.Interceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mofan.springboot_vue.persistence.Page;
import com.mofan.springboot_vue.persistence.dialect.Dialect;
import com.mofan.springboot_vue.persistence.dialect.db.MySQLDialect;
import com.mofan.springboot_vue.utils.Reflections;



/**
 * mybatis分页拦截器
 * 
 * @author  fan_mo
 *
 * @version 2017年4月27日
 *
 */
public abstract class BaseInterceptor implements Interceptor, Serializable {
	
	private static final long serialVersionUID = 1L;

    protected static final String PAGE = "page";
    
    protected static final String DELEGATE = "delegate";

    protected static final String MAPPED_STATEMENT = "mappedStatement";

    protected Logger log = LoggerFactory.getLogger(this.getClass());

    protected Dialect DIALECT;

//    /**
//     * 拦截的ID，在mapper中的id，可以匹配正�?
//     */
//    protected String _SQL_PATTERN = "";

    /**
     * 对参数进行转换和�?�?
     * @param parameterObject 参数对象
     * @param page            分页对象
     * @return 分页对象
     * @throws NoSuchFieldException 无法找到参数
     */
    @SuppressWarnings("unchecked")
	protected static Page<Object> convertParameter(Object parameterObject, Page<Object> page) {
    	try{
            if (parameterObject instanceof Page) {
                return (Page<Object>) parameterObject;
            } else {
                return (Page<Object>)Reflections.getFieldValue(parameterObject, PAGE);
            }
    	}catch (Exception e) {
			return null;
		}
    }

    /**
     * 设置属�?�，支持自定义方�?类和制定数据库的方式
     * <code>dialectClass</code>,自定义方�?类�?�可以不配置这项
     * <ode>dbms</ode> 数据库类型，插件支持的数据库
     * <code>sqlPattern</code> �?要拦截的SQL ID
     * @param p 属�??
     */
    protected void initProperties(Properties p) {
        DIALECT = new MySQLDialect();;
    }
}
