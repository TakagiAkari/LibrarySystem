<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>返却確認画面</title>
</head>

<jsp:include page="header.jsp"/>

<body>

<h1>返却情報確認</h1>

会員ID：${lendingBeanForReturnBook.userId}
会員名：${userNameForReturnBook}
書籍ID：${lendingBeanForReturnBook.bookId}
書籍名：${bookNameForReturnBook}
返却期限：${lendingBeanForReturnBook.returnLimit}
返却日：${lendingBeanForReturnBook.returnDay}
備考：${lendingBeanForReturnBook.memo}

<form action="/LibrarySystem/ReturnBookServlet" method="post">
<p style="text-align:center">
<input type="submit" value="返却する">
<input type="hidden" name="action" value="complete">
</p><br>
</form>

</body>

<jsp:include page="footer.jsp"/>

</html>