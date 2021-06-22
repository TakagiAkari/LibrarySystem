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


会員ID：${displayInfo1.userId}
会員名：${USERNAME}
書籍ID：${displayInfo1.bookId}
書籍名：${BOOKNAME}
返却期限：${displayInfo1.returnLimit}
返却日：${displayInfo1.returnDay}
備考：${displayInfo1.memo}

<form action="/LibrarySystem/ReturnBookInfoServlet" method="post">
<p style="text-align:center">
<input type="submit" value="返却する">
<input type="hidden" name="action" value="complete">
</p><br>
</form>

</body>

<jsp:include page="footer.jsp"/>

</html>