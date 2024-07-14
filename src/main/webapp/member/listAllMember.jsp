<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.member.model.*"%>
<%-- �����m�߱ĥ� EL ���g�k���� --%>

<%
	MemberJDBCDAO dao = new MemberJDBCDAO();
    List<MemberVO> list = dao.getAll();
    pageContext.setAttribute("list",list);
%>


<html>
<head>
<title>�Ҧ��|����� - listAllMember.jsp</title>

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

<h4>�����m�߱ĥ� EL ���g�k����:</h4>
<table id="table-1">
	<tr><td>
		 <h3>�Ҧ����u��� - listAllMember.jsp</h3>
		 <h4><a href="select_page.jsp"><img src="/TIA102G5/images/back1.gif" width="100" height="32" border="0">�^����</a></h4>
		 
	</td></tr>
</table>

<table>
	<tr>
		<th>�|���s��</th>
		<th>�b��(E-mail)</th>
		<th>�K�X</th>
		<th>�|���m�W</th>
		<th>�q��</th>
		<th>�ʺ�</th>
		<th>�|�����A</th>
		<th>�Ыخɶ�</th>
		<th>�j�Y�K</th>
		<th>�ͤ�</th>
		<th>�a�}</th>
		<th>�ʧO</th>
		<th>�����Ҧr��</th>
		<th>�ק�</th>
		<th>�R��</th>
	</tr>
	<%@ include file="page1.file" %> 
	<c:forEach var="memberVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
		
		<tr>
			<td>${memberVO.memberID}</td>
			<td>${memberVO.memberAccount}</td>
			<td>${memberVO.memberPassword}</td>
			<td>${memberVO.memberName}</td>
			<td>${memberVO.memberPhone}</td>
			<td>${memberVO.memberNickName}</td>
			<td>${memberVO.memberStatus}</td>
			<td>${memberVO.memberCreateTime}</td>
			<td><img src="<%=request.getContextPath()%>/DBGifReader4?memberID=${memberVO.memberID}" width="100" height="100"></td>
<%-- 			<td>${memberVO.memberPicture}</td> --%>
			<td>${memberVO.birthday}</td>
			<td>${memberVO.memberAddress}</td>
			<td>${memberVO.gender}</td>
			<td>${memberVO.nationalID}</td>
			<td>
			  <FORM METHOD="post" enctype="multipart/form-data" ACTION="<%=request.getContextPath()%>/member/member.do" style="margin-bottom: 0px;">
			     <input type="submit" value="�ק�">
			     <input type="hidden" name="memberID"  value="${memberVO.memberID}">
			     <input type="hidden" name="action"	value="getOne_For_Update"></FORM>
			</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/member/member.do" style="margin-bottom: 0px;">
			     <input type="submit" value="�R��">
			     <input type="hidden" name="memberID"  value="${memberVO.memberID}">
			     <input type="hidden" name="action" value="delete"></FORM>
			</td>
		</tr>
	</c:forEach>
</table>
<%@ include file="page2.file" %>

</body>
</html>