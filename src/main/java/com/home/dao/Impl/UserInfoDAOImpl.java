package com.home.dao.Impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.home.dao.UserInfoDAO;
import com.home.vo.UserInfoVO;
import com.home.common.MybatisConfig;

import com.home.dao.Impl.UserInfoDAOImpl;

public class UserInfoDAOImpl implements UserInfoDAO {

	@Override
	public List<UserInfoVO> selectUserInfoList(SqlSession session, UserInfoVO user) {
		// TODO Auto-generated method stub
		return session.selectList("com.home.mapper.UserInfoMapper.selectUserInfoList",user);
	}

	@Override
	public UserInfoVO selectOne(SqlSession session, int uiNum) {
		// TODO Auto-generated method stub
		return session.selectOne("com.home.mapper.UserInfoMapper.selectUserInfo",uiNum);
	}

	@Override
	public int insertUserInfo(SqlSession session, UserInfoVO userInfo) {
		// TODO Auto-generated method stub
		return session.insert("com.home.mapper.UserInfoMapper.insertUserInfo",userInfo);
	}

	@Override
	public int updatetUserInfo(SqlSession session, UserInfoVO userInfo) {
		// TODO Auto-generated method stub
		return session.update("com.home.mapper.UserInfoMapper.updateUserInfo",userInfo);
	}

	@Override
	public int deleteUserInfo(SqlSession session, int uiNum) {
		// TODO Auto-generated method stub
		return session.delete("com.home.mapper.UserInfoMapper.deleteUserInfo",uiNum);
	}
	public static void main(String[] args) {
		try(SqlSession session =MybatisConfig.getSqlSessionFactory().openSession()){
			UserInfoDAO uiDAO =new UserInfoDAOImpl();
			List<UserInfoVO> userList =uiDAO.selectUserInfoList(session, null);
			for(UserInfoVO user: userList) {
				System.out.println(user);
			}
		}
	}
}
