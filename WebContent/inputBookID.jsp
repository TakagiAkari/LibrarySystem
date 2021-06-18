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

<form>
書籍ID：<input type="text" name="bookID" required>
<input type="submit" formaction="/ChangeBookInfoServlet" value="変更">
<input type="submit" formaction="/SearchBookInfoServlet" value="検索">
<input type="submit" formaction="/DeleteBookInfoServlet" value="削除">
</form>

</body>

<jsp:include page="footer.jsp"/>

</html>