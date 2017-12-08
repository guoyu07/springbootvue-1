package com.mofan.springboot_vue.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mofan.springboot_vue.model.Factory;
import com.mofan.springboot_vue.persistence.Page;
import com.mofan.springboot_vue.service.FactoryService;
import com.mofan.springboot_vue.vo.FactoryVO;

/**
 * 厂家Controller
 * @author fan_mo
 *
 */
@RestController
@RequestMapping(value = "/factory")
public class FactoryController {
	@Autowired
	private FactoryService factoryService;
	

	@RequestMapping(value = "list")
	public Page<FactoryVO> list(FactoryVO factoryVO,HttpServletRequest request,HttpServletResponse response) {
		Page<FactoryVO> page = factoryService.findPage(new Page<FactoryVO>(request,response),factoryVO);
		return page;
	}

	@RequestMapping(value = "form/{itemId}")
	public Factory form(@PathVariable(value="itemId",name="itemId",required=false)int id) {
		Factory factory = null;
		if (id > 0) {
			factory= factoryService.getById(id);
		}
		if (factory == null) {
			factory = new Factory();
		}
		return factory;
	}

	/**
	 * 验证角色名是否有效
	 * 
	 * @param oldName
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "checkName")
	public boolean checkName(String oldName, String name) {
		if (StringUtils.isNotBlank(name) && name.equals(oldName)) {
			return true;
		} else if (StringUtils.isNotBlank(name) && null == factoryService.getByName(name)) {
			return true;
		}
		return false;
	}

}
