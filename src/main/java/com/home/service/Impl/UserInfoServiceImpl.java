package com.home.service.Impl;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.home.common.MybatisConfig;
import com.home.service.UserInfoService;
import com.home.vo.UserInfoVO;
import com.home.dao.UserInfoDAO;
import com.home.dao.Impl.UserInfoDAOImpl;

public class UserInfoServiceImpl implements UserInfoService {
private UserInfoDAO uiDAO =new UserInfoDAOImpl();
	@Override
	public List<UserInfoVO> selectUserInfoList(UserInfoVO user) {
		// TODO Auto-generated method stub
		
	try(SqlSession session =MybatisConfig.getSqlSessionFactory().openSession()){
		return uiDAO.selectUserInfoList(session,user);
	}
	}

	@Override
	public UserInfoVO selectOne(int uiNum) {
		try(SqlSession session =MybatisConfig.getSqlSessionFactory().openSession()){
			return uiDAO.selectOne(session,uiNum);
		}
		}
	@Override
	public int insertUserInfo(UserInfoVO userInfo) {
		try(SqlSession session =MybatisConfig.getSqlSessionFactory().openSession()){
			return uiDAO.insertUserInfo(session,userInfo);
		}
		}
	@Override
	public int updateUserInfo(UserInfoVO userInfo) {
		try(SqlSession session =MybatisConfig.getSqlSessionFactory().openSession()){
			return uiDAO.updatetUserInfo(session,userInfo);
		}
		}

	@Override
	public int deleteUserInfo(int uiNum) {
		try(SqlSession session =MybatisConfig.getSqlSessionFactory().openSession()){
			return uiDAO.deleteUserInfo(session,uiNum);
		}
		}

}
