<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>貸出画面</title>
</head>

<jsp:include page="header.jsp"/>

<body>

<form action="/LibrarySystem/LendingBookInfoServlet" method="post">
会員ID：<input type="text" name="userId" >
書籍ID：<input type="text" name="bookId" >
<input type="submit" value="貸し出す">
<input type="hidden" name="action" value="lending">
</form>

</body>

<jsp:include page="footer.jsp"/>

</html>