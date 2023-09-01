package com.home.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.home.common.CommonView;
import com.home.service.UserInfoService;
import com.home.service.Impl.UserInfoServiceImpl;
import com.home.vo.UserInfoVO;


import com.google.gson.Gson;

@WebServlet("/user-info/*")
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserInfoService uiService = new UserInfoServiceImpl();
	private Gson gson = new Gson();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String json = "";
		String cmd = CommonView.getCmd(request);
		if ("list".equals(cmd)) {
			UserInfoVO user= new UserInfoVO();
			json = gson.toJson(uiService.selectUserInfoList(user));
		} else if ("one".equals(cmd)) {
			String uiNum = request.getParameter("uiNum");
		}

// response.setHeader("Access-Control-Allow-Headers", "Content-Type");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(json);
	}

	private final static Gson GSON = new Gson();

	public static <T> T casting(HttpServletRequest request, Class<T> clazz) throws IOException {
		BufferedReader br = request.getReader();
		String str = null;
		StringBuffer sb = new StringBuffer();
		while ((str = br.readLine()) != null) {
			sb.append(str);
		}
		return GSON.fromJson(sb.toString(), clazz);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String cmd = CommonView.getCmd(request);
		
		UserInfoVO userInfo = casting(request, UserInfoVO.class);
		System.out.println(userInfo);
	}

}
