<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員ID入力画面</title>
</head>
<body>
<h1>新宿図書館 図書管理システム</h1>
<h3>会員管理</h3>
<form action="/LibrarySystem/ChangeMemberInfoServlet" method="post">
会員ID：<input type="text" name="userID"><br>
<input type="submit" value="変更">
</form>
<form action="/LibrarySystem/DeleteMemberInfoServlet" method="post">
会員ID：<input type="text" name="userID"><br>
<input type="submit" value="削除">
<input type="hidden" name="action" value="delete">
</form>


</body>
</html>