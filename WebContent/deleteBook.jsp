<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>削除確認画面</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<form action="/LibrarySystem/DeleteBookInfoServlet" method="post">
<h2>削除資料情報</h2>
</body>
<br>ISBN番号：${catalog.isbn }
<br>題名：${catalog.bookName }
<br>作者：${catalog.author }
<br>出版社：${catalog.publisher }
<br>出版年月日：${catalog.publishDay }
<br>
<input type="submit" value="削除">
<input type="hidden" name="action" value="complete">
<input type="hidden" name="bookId" value="${record.bookId}">
<jsp:include page="footer.jsp"/>
</form>
</html>