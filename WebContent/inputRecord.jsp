<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>資料台帳</title>
</head>
<body>

<jsp:include page="header.jsp"/>

<form action="/LibrarySystem/RegisterBookInfoServlet" method="post">
ISBN番号：<input type="text" name="isbn"><br>
備考：<input type="text" name="memo">
<input type="submit" value="確認画面へ">
<input type="hidden" name="action" value="checkIsbn">
</form>

<jsp:include page="footer.jsp"/>

</body>
</html>