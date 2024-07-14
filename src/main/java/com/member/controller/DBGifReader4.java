package com.member.controller;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
@WebServlet("/DBGifReader4")
public class DBGifReader4 extends HttpServlet {

	Connection con;

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		res.setContentType("image/gif");
		ServletOutputStream out = res.getOutputStream();

		try {
			Statement stmt = con.createStatement();
			String id = req.getParameter("memberID").trim();
			ResultSet rs = stmt.executeQuery(
//				"SELECT IMAGE FROM PICTURES WHERE PID = " + req.getParameter("PID")
				"SELECT memberPicture FROM PartnerMember WHERE memberID = " + id);
			if (rs.next()) {
				BufferedInputStream in = new BufferedInputStream(rs.getBinaryStream("memberPicture"));
				byte[] buf = new byte[4 * 1024]; // 4K buffer
				int len;
				while ((len = in.read(buf)) != -1) {
					out.write(buf, 0, len);
				}
				in.close();
			} else {
				//res.sendError(HttpServletResponse.SC_NOT_FOUND);
				// /NoData/none2.jpg 最前面的/是指專案地址
				InputStream in = getServletContext().getResourceAsStream("/NoData/none2.jpg"); // p110
				byte[] b = new byte[in.available()]; //資料超過2G時就不建議使用  available()-->資料的大小
				in.read(b);
				out.write(b);
				in.close();
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			//System.out.println(e);
			InputStream in = getServletContext().getResourceAsStream("/NoData/null.jpg"); // p110
//			byte[] b = new byte[in.available()]; 
//			in.read(b);
			byte[] b = in.readAllBytes();  // Java 9 的新方法 環境太舊無法使用  readAllBytes()
			out.write(b);
			in.close();
		}
	}

	public void init() throws ServletException {
		
			try {
				Context ctx = new javax.naming.InitialContext();
				DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TIA102G5");
				con = ds.getConnection();
			} catch (NamingException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}

	public void destroy() {
		try {
			if (con != null) con.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

}