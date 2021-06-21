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

<h1>貸出情報確認</h1>

会員ID：${displayInfo.userId}<br>
会員名：${displayInfo.userName}<br>
書籍ID：${displayInfo.bookId}<br>
書籍名：${displayInfo.bookName}<br>
<form action="/LibrarySystem/LendingBookServlet" method="post">
<p style="text-align:center">
<input type="submit" value="貸出する">

<input type="hidden" name="action" value="complete">
</p><br>
</form>

</body>

<jsp:include page="footer.jsp"/>

</html>