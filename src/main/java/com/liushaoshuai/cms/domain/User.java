package com.liushaoshuai.cms.domain;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
/**
 * @ClassName: User 
 * @Description: 用户
 * @author:鄙人：刘某 
 * @date: 2019年7月17日 下午3:14:50
 */
public class User implements Serializable{

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotNull(message="用户名不能为空")
	@Size(min=2,max=6,message="用户名长度在2-6之间")
    private String username;
	
	@NotNull(message="密码不能为空")
	@Size(min=6,max=10,message="密码长度在6-10之间")
    private String password;

    private String nickname;

    private Date birthday;

    private Integer gender;//性别  0为男  1为女

    private Integer locked;//用户状态:0为正常   1为禁用

    private Date createTime;

    private Date updateTime;

    private String role;//角色  1为管理员  0为普通用户

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username ==null ? null : username.trim() ;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname == null ? null : nickname.trim();
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Integer getLocked() {
		return locked;
	}

	public void setLocked(Integer locked) {
		this.locked = locked;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role == null ? null : role.trim();
	}
	
	
	
	
	
	
	
	
	
}