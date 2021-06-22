<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>書籍IDの入力</title>
</head>

<jsp:include page="header.jsp"/>

<body>


<c:if test="${mode eq 'change'}">
<form method="post">
資料ID：<input type="text" name="bookId" required>
<input type="submit" formaction="/LibrarySystem/ChangeBookInfoServlet" value="変更">
<input type="hidden" name="action" value="work">
</form>
</c:if>

<c:if test="${mode eq 'search'}">
<form method="post">
資料ID：<input type="text" name="bookId" required>
<input type="submit" formaction="/LibrarySystem/SearchBookInfoServlet" value="検索">
<input type="hidden" name="action" value="work">
</form>
</c:if>

<c:if test="${mode eq 'delete'}">
資料ID：<input type="text" name="bookId" required>
<form method="post">
<input type="submit" formaction="/LibrarySystem/DeleteBookInfoServlet" value="削除">
<input type="hidden" name="action" value="work">
</form>
</c:if>



</body>

<jsp:include page="footer.jsp"/>

</html>