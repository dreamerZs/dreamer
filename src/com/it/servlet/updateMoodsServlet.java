package com.it.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.it.entity.shoe;
import com.it.service.shoeService;
import com.it.serviceImpl.shoeServiceImpl;

@WebServlet("/updateMoodsServlet")
public class updateMoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int moods = Integer.parseInt(request.getParameter("moods"));
		String name = request.getParameter("name");
		shoe s = new shoe();
		s.setMoods(moods);
		s.setName(name);
		shoeService ss = new shoeServiceImpl();		
		ss.update(s);
		List<shoe> list = new ArrayList<shoe>();		
		list = ss.selectMoods(s);		
		String liii = JSON.toJSONString(list);
		PrintWriter out = response.getWriter();
		out.println(liii);		
	}

}
