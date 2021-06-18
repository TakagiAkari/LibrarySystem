<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<jsp:include page="header.jsp"/>
<br>

<form action="/LibrarySystem/SearchBookInfoServlet" method="post">
資料ID：<input type="number" name="bookId" required>
<br>
<input type="submit" value="検索">
<input type="hidden" name="action" value="search">
</form>

<br>
<jsp:include page="footer.jsp"/>

</body>
</html>