<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>返却確認画面</title>
</head>

<jsp:include page="header.jsp"/>

<body>

<h1>返却情報</h1>

会員ID：${ReturnMember.userId}<br>
会員名：${ReturnMember.userName}<br>
書籍ID：${ReturnBook.bookId}<br>
書籍名：${ReturnBook.bookName}<br>
<form action="/LibrarySystem/ReturnBookInfoServlet" method="post">
<p style="text-align:center">
<input type="submit" value="返却する">
<input type="hidden" name="action" value="complete">
</p><br>
</form>

</body>

<jsp:include page="footer.jsp"/>

</html>