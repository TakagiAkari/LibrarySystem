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

会員ID：${displayInfo.userId}
会員名：${displayInfo.userName}
書籍ID：${displayInfo.bookId}
書籍名：${displayInfo.bookName}
返却期限：${displayInfo.returnLimit}
返却日：${displayInfo.returnDay}
備考：${displayInfo.memo}
<form action="/LibrarySystem/ReturnBookInfoServlet" method="post">
<input type="submit" value="返却する">
<input type="hidden" name="action" value="complete">
</form>

</body>

<jsp:include page="footer.jsp"/>

</html>