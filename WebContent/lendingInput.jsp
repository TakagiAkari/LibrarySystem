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

<form action="/LibrarySystem/LendingBookServlet" method="post">
会員ID：<input type="text" name="userId" >
書籍ID：<input type="text" name="bookId" >
備考欄：<input type="text" name="memo" >
<input type="submit" value="確認画面へ">
<input type="hidden" name="action" value="check">
</form>

</body>

<jsp:include page="footer.jsp"/>

</html>