<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員情報入力画面</title>
</head>
<body>

<jsp:include page="header.jsp"/>

<h1>会員情報入力</h1>

<form action="/LibrarySystem/ChangeMemberInfoServlet?action=input" method="post">
会員ID：<input type="text" name="MemID"><br>
<p style="text-align:center">
<input type="submit" value="変更">
</p><br>
</form>
<form action="/LibrarySystem/DeleteMemberInfoServlet" method="post">
会員ID：<input type="text" name="MemID"><br>
<p style="text-align:center">
<input type="submit" value="削除">
<input type="hidden" name="action" value="delete">
</p><br>
</form>

<jsp:include page="footer.jsp"/>

</body>
</html>