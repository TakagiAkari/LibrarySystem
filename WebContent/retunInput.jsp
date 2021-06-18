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

<form action="/LibrarySystem/ReturnBookInfoServlet" method="post">

書籍ID：<input type="text" name="bookId" >
<input type="submit" value="返却する">
<input type="hidden" name="action" value="return">

</form>

</body>

<jsp:include page="footer.jsp"/>

</html>