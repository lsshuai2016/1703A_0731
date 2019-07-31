package com.liushaoshuai.cms.domain;

import java.io.Serializable;
/**
 * @ClassName: Channel 
 * @Description: 栏目
 * @author:鄙人：刘某 
 * @date: 2019年7月17日 下午3:13:41
 */
public class Channel implements Serializable {

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;

    private String name;

    private String description;//描述

    private String icon;//图标

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon == null ? null : icon.trim();
	}
	
	
	
	
	

}
