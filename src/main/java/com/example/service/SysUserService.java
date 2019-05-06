package com.example.service;

import java.util.List;

import com.example.pojo.SysUser;


public interface SysUserService {
	
	/**
	 * 保存
	 * @param user
	 * @throws Exception
	 */
	public void saveUser(SysUser user);

	/**
	 * 更新
	 * @param user
	 */
	public void updateUser(SysUser user);

	/**
	 * 删除
	 * @param userId
	 */
	public void deleteUser(String userId);

	/**
	 * 根据userID获取user
	 * @param userId
	 * @return
	 */
	public SysUser queryUserById(String userId);

	/**
	 * list
	 * @param user
	 * @return
	 */
	public List<SysUser> queryUserList(SysUser user);

	/**
	 * list page
	 * @param user
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public List<SysUser> queryUserListPaged(SysUser user, Integer page, Integer pageSize);

	/**
	 * 自定义
	 * @param userId
	 * @return
	 */
	public SysUser querySysUserById(String userId);
	
	/**
	 * 保存 事务
	 * @param user
	 */
//	public void saveUserTransactional(SysUser user);
	
	
}
