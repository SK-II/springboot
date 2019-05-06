package com.example.service.ipml;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.mapper.SysUserMapper;
import com.example.mapper.SysUserMapperCustom;
import com.example.pojo.SysUser;
import com.example.service.SysUserService;
import com.github.pagehelper.PageHelper;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

@Service
public class SysUserServiceImpl implements SysUserService {
	
	
	@Resource
	private SysUserMapper sysUserMapper;
	
	
	@Resource
	private SysUserMapperCustom sysUserMapperCustom;
	
	

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void saveUser(SysUser user) {
		// TODO Auto-generated method stub
		sysUserMapper.insert(user);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateUser(SysUser user) {
		// TODO Auto-generated method stub
		sysUserMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteUser(String userId) {
		// TODO Auto-generated method stub
		sysUserMapper.deleteByPrimaryKey(userId);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public SysUser queryUserById(String userId) {
		// TODO Auto-generated method stub
		return sysUserMapper.selectByPrimaryKey(userId);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<SysUser> queryUserList(SysUser user) {
		// TODO Auto-generated method stub
		return sysUserMapper.select(user);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<SysUser> queryUserListPaged(SysUser user, Integer page, Integer pageSize) {
		PageHelper.startPage(page, pageSize);
		
		Example example = new Example(SysUser.class);
		Criteria criteria = example.createCriteria();
		example.orderBy("registTime").desc();
		return sysUserMapper.selectByExample(example);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public SysUser querySysUserById(String userId) {
		// TODO Auto-generated method stub
		return sysUserMapperCustom.querySysUserById(userId);
	}


}
