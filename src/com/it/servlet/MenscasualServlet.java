package com.it.servlet;

import java.io.*;
import java.sql.*;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.it.entity.*;
import com.it.service.*;
import com.it.serviceImpl.*;
import com.it.util.DatabaseUtil;

@WebServlet("/MenscasualServlet")
public class MenscasualServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//String name = java.net.URLDecoder.decode(request.getParameter("name"), "utf-8");
		String name = request.getParameter("name");
		PrintWriter out = response.getWriter();
		shoe_type shoe_t = new shoe_type();
		shoe_t.setName(name);
		shoe_typeService shoe_ts = new shoe_typeServiceImpl();
		List<shoe> list = shoe_ts.select(shoe_t);
		shoe s = new shoe();
		for(int i =0;i<list.size();i++){
			s.setTtypeid(list.get(i).getTtypeid());
		}
		shoeService ss = new shoeServiceImpl();
		List<shoe> li = new ArrayList<shoe>();
		li = ss.select(s);
		String lii = JSON.toJSONString(li);
		out.print(lii);
	}

}
