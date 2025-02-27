<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.member.model.*"%>

<%
//見com.member.controller.MemberServlet.java第163行存入req的memberVO物件 (此為從資料庫取出的memberVO, 也可以是輸入格式有錯誤時的memberVO物件)
MemberVO memberVO = (MemberVO) request.getAttribute("memberVO");
%>
<%-- --<%= memberVO==null %>--${empVO.deptno}-- <!-- line 100 --> --%>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>員工資料修改 - update_emp_input.jsp</title>

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
	width: 450px;
	background-color: white;
	margin-top: 1px;
	margin-bottom: 1px;
}

table, th, td {
	border: 0px solid #CCCCFF;
}

th, td {
	padding: 1px;
}
</style>

</head>
<body bgcolor='white'>

	<table id="table-1">
		<tr>
			<td>
				<h3>會員資料修改 - update_member_input.jsp</h3>
				<h4>
					<a href="select_page.jsp"><img src="images/back1.gif"
						width="100" height="32" border="0">回首頁</a>
				</h4>
			</td>
		</tr>
	</table>

	<h3>資料修改:</h3>

	<%-- 錯誤表列 --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">請修正以下錯誤:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>

	<FORM METHOD="post"
		enctype="multipart/form-data" 
		ACTION="${pageContext.request.contextPath}/member/member.do"
		name="form1">
		<table>
			<tr>
				<td>會員編號:<font color=red><b>*</b></font></td>
				<td><%=memberVO.getMemberID()%></td>
			</tr>
			<tr>
				<td>員工姓名:</td>
				<td><input type="TEXT" name="memberName"
					value="<%=memberVO.getMemberName()%>" size="45" /></td>
			</tr>
			<tr>
				<td>電話:</td>
				<td><input type="TEXT" name="memberPhone"
					value="<%=memberVO.getMemberPhone()%>" size="45" /></td>
			</tr>
			<tr>
				<td>大頭貼:</td>
				<td><input type="file" name="memberPicture" /></td>
			</tr>
		</table>
		<br> <input type="hidden" name="action" value="update"> <input
			type="hidden" name="memberID" value="<%=memberVO.getMemberID()%>">
		<input type="submit" value="送出修改">
	</FORM>
</body>
</html>