<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.member.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
	MemberJDBCDAO dao = new MemberJDBCDAO();
    List<MemberVO> list = dao.getAll();       // 此行的list變數(物件)將提供page1.file的第11行取得查詢到的總筆數，再由page1.file進行分頁的需要
    pageContext.setAttribute("list",list); // 將上一行的list變數(物件)存入當前頁面pageContext，再由底下的第73行由JSTL的forEach列印出結果
%>


<html>
<head>
<title>所有會員資料 - listAllMember_byDAO.jsp</title>

<style>
  table#table-1 {
	background-color: #CCCCFF;
    border: 2px solid black;
    text-align: center;
  }
  table#table-1 h4 {
    color: red;
    display: block;
    margin-bottom: 1px;
  }
  h4 {
    color: blue;
    display: inline;
  }
</style>

<style>
  table {
	width: 800px;
	background-color: white;
	margin-top: 5px;
	margin-bottom: 5px;
  }
  table, th, td {
    border: 1px solid #CCCCFF;
  }
  th, td {
    padding: 5px;
    text-align: center;
  }
</style>

</head>
<body bgcolor='white'>

<h4>此頁練習採用 EL 的寫法取值:</h4>
<table id="table-1">
	<tr><td>
		 <h3>所有員工資料 - listAllEmp1_byDAO.jsp</h3>
<%-- 		 <h4><img src="<%=request.getContextPath()%>/back-end/emp/images/back1.gif" width="100" height="32" border="0"></h4> --%>
	</td></tr>
</table>

<table>
	<tr>
		<th>會員編號</th>
		<th>會員姓名</th>
		<th>大頭貼</th>
		<th>電話</th>
		<th>身分證字號</th>
		<th>暱稱</th>
		<th>地址</th>
		<th>性別</th>
	</tr>
	<%@ include file="page1.file" %> 
	<c:forEach var="memberVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
		<tr>
			<td>${empVO.memberID}</td>
			<td>${empVO.memberName}</td>
			<td>${empVO.memberPicture}</td>
			<td>${empVO.memberPhone}</td>
			<td>${empVO.memberCreateTime}</td>
			<td>${empVO.memberNickName}</td>
			<td>${empVO.memberAddress}</td>
			<td>${empVO.gender}</td>
		</tr>
	</c:forEach>
</table>
<%@ include file="page2.file" %>

</body>
</html>