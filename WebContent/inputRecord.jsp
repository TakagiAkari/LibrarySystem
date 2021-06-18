<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>資料台帳</title>
</head>
<body>
<form action="/LibrarySystem/RegisterBookInfoServlet" method="post">
ISBN番号：<input type="text" name="isbn"><br>
題名：<input type="text" name="title"><br>
入荷年月日：<input type="text" name="stockY">年<input type="text" name="stockM">月<input type="text" name="stockD">日<br>
廃棄年月日：<input type="text" name="throwoutY">年<input type="text" name="throwoutM">月<input type="text" name="throwoutD">日<br>
備考：<input type="text" name="memo">
<input type="submit" value="確認画面へ">
<input type="hidden" name="action" value="next">
</form>
</body>
</html>