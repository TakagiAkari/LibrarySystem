<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>資料削除確認画面</title>
</head>
<body>

<jsp:include page="header.jsp"/>

<h1>資料削除情報確認</h1>

<form action="/LibrarySystem/DeleteBookInfoServlet" method="post">

ISBN番号：${catalog.isbn }
<br>題名：${catalog.bookName }
<br>作者：${catalog.author }
<br>出版社：${catalog.publisher }
<br>出版年月日：${catalog.publishDay }
<br>
<p style="text-align:center">
<input type="submit" value="削除">
<input type="hidden" name="action" value="complete">
<input type="hidden" name="bookId" value="${record.bookId}">
</p><br>
</form>

<jsp:include page="footer.jsp"/>

</body>
</html>