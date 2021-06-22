<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>貸出入力画面</title>
</head>

<jsp:include page="header.jsp"/>

<body>

<h1>貸出情報入力</h1>

<form action="/LibrarySystem/LendingBookServlet" method="post">
会員ID：<input type="text" name="userId" ><br>
資料ID：<input type="text" name="bookId" ><br>
備考：<input type="text" name="memo" ><br>
<p style="text-align:center">
<input type="submit" value="確認画面へ">
<input type="hidden" name="action" value="check">
</p><br>
</form>

</body>

<jsp:include page="footer.jsp"/>

</html>