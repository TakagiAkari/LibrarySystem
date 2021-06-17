<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>資料目録</title>
</head>
<body>
<form action="/LibrarySystem/RegisterBookInfoServlet" method="post">
ISBN番号：<input type="text" name="isbn"><br>
題名：<input type="text" name="title"><br>
分類コード：<input type="text" name="category"><br>
著者:<input type="text" name="author"><br>
出版社：<input type="text" name="publisher"><br>
出版年月日：<input type="text" name="publishedY">年<input type="text" name="publishedM">月<input type="text" name="publishedD">日<br>
</form>
</body>
</html>