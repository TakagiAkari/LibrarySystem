<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員検索入力画面</title>
</head>
<body>

<jsp:include page="header.jsp"/>

<h1>会員検索情報入力</h1>

<form action="/LibrarySystem/SearchMemberInfoServlet" method="post">
メールアドレス：<input type="email" name="email" size="50" required>
<br>
<p style="text-align:center">
<input type="submit" value="検索する">
<input type="hidden" name="action" value="search">
</p><br>
</form>
<br>
<jsp:include page="footer.jsp"/>

</body>
</html>