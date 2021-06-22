<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員ID入力画面</title>
</head>
<body>

<jsp:include page="header.jsp"/>

<h3>会員管理</h3>

<c:if test="${mode eq 'change'}">
<form action="/LibrarySystem/ChangeMemberInfoServlet?action=input" method="post">
会員ID：<input type="text" name="MemID"><br>
<input type="submit" value="変更">
<input type="hidden" name="action" value="change">
</form>
</c:if>

<c:if test="${mode eq 'delete'}">
<form action="/LibrarySystem/DeleteMemberInfoServlet" method="post">
会員ID：<input type="text" name="MemID"><br>
<input type="submit" value="退会">
<input type="hidden" name="action" value="delete">
</form>
</c:if>

<jsp:include page="footer.jsp"/>

</body>
</html>