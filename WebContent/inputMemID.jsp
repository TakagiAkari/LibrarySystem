<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員情報入力画面</title>
<jsp:include page="importLayout.jsp"/>
</head>
<body>

<jsp:include page="header.jsp"/>

<article>

<h2>会員管理</h2>

<%--変更 --%>
<c:if test="${mode eq 'change'}">
	<div class="center-form">
		<form action="/LibrarySystem/ChangeMemberInfoServlet" method="post">
			<dl>
				<dt>会員ID</dt>
				<dd><input type="number" name="MemID" required></dd>
			</dl>
			<div class="container next-button-placement">
				<div class="button next-button">
					<input type="submit" value="変更">
					<input type="hidden" name="action" value="input">
				</div>
			</div>
		</form>
	</div>
</c:if>

<%--削除 --%>
<c:if test="${mode eq 'delete'}">
	<div class="center-form">
		<form action="/LibrarySystem/DeleteMemberInfoServlet" method="post">
			<dl>
				<dt>会員ID</dt>
				<dd><input type="number" name="MemID" required></dd>
			</dl>
			<div class="container next-button-placement">
				<div class="button next-button">
					<input type="submit" value="削除">
					<input type="hidden" name="action" value="delete">
				</div>
			</div>
		</form>
	</div>
</c:if>

</article>

<jsp:include page="footer.jsp"/>

</body>
</html>