<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.member.model.*"%>

<%
MemberVO memberVO = (MemberVO) request.getAttribute("memberVO");
%>

<%-- --<%= memberVO==null %>--${empVO.deptno}-- <!-- line 100 --> --%>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>���u��Ʒs�W - addMember.jsp</title>

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
				<h3>���u��Ʒs�W - addMember.jsp</h3>
			</td>
			<td>
				<h4>
					<a href="select_page.jsp"><img src="/TIA102G5/images/tomcat.png"
						width="100" height="100" border="0">�^����</a>
				</h4>
			</td>
		</tr>
	</table>

	<h3>�|����Ʒs�W:</h3>

	<%-- ���~��C --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">�Эץ��H�U���~:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>

	<FORM METHOD="Get" 
		enctype="multipart/form-data"
		ACTION="${pageContext.request.contextPath}/member/member.do"
		name="form1">
		<table>
			<tr>
				<td>�b��(E-mail):</td>
				<td><input type="TEXT" name="memberAccount"
					value="<%=(memberVO == null) ? "test123@gmail.com" : memberVO.getMemberAccount()%>"
					size="45" /></td>
			</tr>
			<tr>
				<td>�K�X:</td>
				<td><input type="TEXT" name="memberPassword"
					value="<%=(memberVO == null) ? "QAZWSX123123" : memberVO.getMemberPassword()%>"
					size="45" /></td>
			</tr>
			<tr>
				<td>���u�m�W:</td>
				<td><input type="TEXT" name="memberName"
					value="<%=(memberVO == null) ? "���L" : memberVO.getMemberName()%>"
					size="45" /></td>
			</tr>
			<tr>
				<td>�q��:</td>
				<td><input type="TEXT" name="memberPhone"
					value="<%=(memberVO == null) ? "0921223333" : memberVO.getMemberPhone()%>"
					size="45" /></td>
			</tr>
			<tr>
				<td>�ʺ�:</td>
				<td><input type="TEXT" name="memberNickName"
					value="<%=(memberVO == null) ? "�L��" : memberVO.getMemberNickName()%>"
					size="45" /></td>
			</tr>
			<tr style="display: none;">
				<td>�|�����A:</td>
				<td><input type="TEXT" name="memberStatus"
					value="<%=(memberVO == null) ? 1 : memberVO.getMemberStatus()%>"
					size="45" /></td>
			</tr>
			<tr style="display: none;">
				<td>�|���Ыخɶ�:</td>
				<td><input name="memberCreateTime" id="f_date1" type="text"></td>
			</tr>
			<tr>
				<td>�j�Y�K:</td>
				<td><input type="file" name="memberPicture" /></td>
			</tr>
			<tr>
				<td>�ͤ�:</td>
				<td><input type="date" name="birthday" type="text" /></td>
			</tr>
			<tr>
				<td>�a�}:</td>
				<td><input type="TEXT" name="memberAddress"
					value="<%=(memberVO == null) ? "�s�_�����Ѱϱs�v��1��59��" : memberVO.getMemberAddress()%>"
					size="45" /></td>
			</tr>
			<tr>
				<td>�ʧO:</td>
				<td><select name="gender">
						<option value="Male">�k</option>
						<option value="Female">�k</option>
				</select></td>
			</tr>
			<tr>
				<td>�����Ҧr��:</td>
				<td><input type="TEXT" name="nationalID"
					value="<%=(memberVO == null) ? "sxxxxxxxxx" : memberVO.getNationalID()%>"
					size="45" /></td>
			</tr>

		</table>
		<br> <input type="hidden" name="action" value="insert"> <input
			type="submit" value="�e�X�s�W">
	</FORM>

</body>
</html>