package com.home.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.home.vo.UserInfoVO;

public interface UserInfoDAO {
List<UserInfoVO> selectUserInfoList(SqlSession session ,UserInfoVO user);
UserInfoVO selectOne(SqlSession session,int uiNum);
int insertUserInfo(SqlSession session,UserInfoVO userInfo);
int updatetUserInfo(SqlSession session,UserInfoVO userInfo);
int deleteUserInfo(SqlSession session, int uiNum);
}
