<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>資料目録情報入力画面</title>
</head>
<body>

<jsp:include page="header.jsp"/>

<h1>資料目録情報入力</h1>

<form action="/LibrarySystem/RegisterBookInfoServlet" method="post">
題名：<input type="text" name="title"><br>
分類コード：<input type="text" name="category"><br>
著者:<input type="text" name="author"><br>
出版社：<input type="text" name="publisher"><br>
出版年月日：<input type="text" name="publishedY">年<input type="text" name="publishedM">月<input type="text" name="publishedD">日<br>

<p style="text-align:center">
<input type="hidden" name="action" value="registerCatalog">
<input type="submit" value="登録する">
<p><br>
</form>

<jsp:include page="footer.jsp"/>

</body>
</html>