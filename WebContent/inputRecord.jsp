<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>資料台帳入力画面</title>
</head>
<body>

<jsp:include page="header.jsp"/>

<h1>資料台帳情報入力</h1>

<form action="/LibrarySystem/RegisterBookInfoServlet" method="post">
ISBN番号：<input type="text" name="isbn"><br>
備考：<input type="text" name="memo">
<p style="text-align:center">
<input type="submit" value="登録する">
<input type="hidden" name="action" value="checkIsbn">
</p><br>
</form>

<jsp:include page="footer.jsp"/>

</body>
</html>