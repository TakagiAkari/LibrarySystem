<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>E-mail入力画面</title>
</head>
<body>

<jsp:include page="header.jsp"/>

<form action="/LibrarySystem/SearchMemberInfoServlet" method="post">
E-mail：<input type="email" name="email" size="50">
<br>
<input type="submit" value="検索">
<input type="hidden" name="action" value="search">
</form>

<jsp:include page="footer.jsp"/>

</body>
</html>