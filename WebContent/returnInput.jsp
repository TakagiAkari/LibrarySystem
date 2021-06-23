<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>返却入力画面</title>
</head>

<body>

<jsp:include page="header.jsp"/>

<h1>返却情報入力</h1>
<form action="/LibrarySystem/ReturnBookServlet" method="post">

資料ID：<input type="number" name="bookId" >
<p style="text-align:center">
<input type="submit" value="返却する">
<input type="hidden" name="action" value="check">
</p><br>
</form>

<jsp:include page="footer.jsp"/>

</body>

</html>