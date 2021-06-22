<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<body>
	<jsp:include page="header.jsp"/><%--ログイン画面にログアウト要るか問題 --%>

	<h1>職員情報入力</h1>

	<form action="/LibrarySystem/LoginServlet" method="post">
		ユーザ名:<input type="text" name="userName"><br>
		パスワード：<input type="password" name="password"><br>
		<p style="text-align:center">
		<input type="submit" value="ログイン">
		</p><br>
	</form>
</body>
</html>