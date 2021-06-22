<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>資料ID入力画面</title>
</head>

<jsp:include page="header.jsp"/>

<body>

<h1>資料情報入力</h1>

<form method="post">
資料ID：<input type="text" name="bookId" required>
<input type="hidden" name="action" value="work">
<p style="text-align:center">
<input type="submit" formaction="/LibrarySystem/ChangeBookInfoServlet" value="変更">
<input type="submit" formaction="/LibrarySystem/SearchBookInfoServlet" value="検索">
<input type="submit" formaction="/LibrarySystem/DeleteBookInfoServlet" value="削除">
</p><br>
</form>

</body>

<jsp:include page="footer.jsp"/>

</html>