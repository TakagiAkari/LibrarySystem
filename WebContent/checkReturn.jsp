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


会員ID：
会員名：
//書籍じゃばすくでループ
書籍ID：
書籍名：
<form action="/LibrarySystem/ReturnBookInfoServlet" method="post">
<input type="submit" value="確認画面へ">
<input type="hidden" name="action" value="complete">
</form>

</body>

<jsp:include page="footer.jsp"/>

</html>