<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>書籍IDの入力</title>
</head>

<jsp:include page="header.jsp"/>

<body>

<form method="post">
資料ID：<input type="text" name="bookId" required>
<input type="hidden" name="action" value="work">
<input type="submit" formaction="/LibrarySystem/ChangeBookInfoServlet" value="変更">
<input type="submit" formaction="/LibrarySystem/SearchBookInfoServlet" value="検索">
<input type="submit" formaction="/LibrarySystem/DeleteBookInfoServlet" value="削除">
</form>

</body>

<jsp:include page="footer.jsp"/>

</html>