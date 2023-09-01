package com.home.service;

import java.util.List;

import com.home.vo.UserInfoVO;

public interface UserInfoService {
List<UserInfoVO> selectUserInfoList (UserInfoVO user);
UserInfoVO selectOne( int uiNum);
int insertUserInfo(UserInfoVO userInfo);
int updateUserInfo(UserInfoVO userInfo);
int deleteUserInfo( int uiNum);
}
