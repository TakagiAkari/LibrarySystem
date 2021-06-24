<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
	<h1>新宿図書館 図書管理システム</h1>
	<c:if test="${session eq null or session.isLogin eq 'true'}">
	<%
		String isLogin = (String)session.getAttribute("isLogin");
		if(isLogin == null || isLogin.equals("false")){
			isLogin = "false";
		}

	%>
	<div class="logout-button">
		<div>
			<a href="/LibrarySystem/LoginServlet?action=logout" >ログアウト</a>
		</div>
	</div>
	</c:if>
</header>