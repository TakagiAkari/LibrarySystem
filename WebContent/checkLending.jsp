<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>貸出確認画面</title>
</head>

<jsp:include page="header.jsp"/>

<body>

会員ID：${lendBook.userId}
会員名：${lendBook.userName}
書籍ID：${lendBook.bookId}
書籍名：${lendBook.bookName}
<form action="/LibrarySystem/LendingBookInfoServlet" method="post">
<input type="submit" value="貸出">
<input type="hidden" name="action" value="complete">
</form>

</body>

<jsp:include page="footer.jsp"/>

</html>