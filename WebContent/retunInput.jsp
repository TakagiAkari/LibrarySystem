<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>返却画面</title>
</head>

<jsp:include page="header.jsp"/>

<body>

<h1>返却情報入力</h1>

<form action="/LibrarySystem/ReturnBookInfoServlet" method="post">
資料ID：<input type="text" name="bookId" >
<p style="text-align:center">
<input type="submit" value="返却する">
<input type="hidden" name="action" value="return">
</p><br>
</form>

</body>

<jsp:include page="footer.jsp"/>

</html>