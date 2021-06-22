<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>完了画面</title>
</head>
<body>

	<jsp:include page="header.jsp"/>
		<h1>${message}が完了しました。</h1>
	<jsp:include page="footer.jsp"/>

<c:if test="${act eq 'lend'}">


<%-- submitとhrefが他と逆 --%>
<a href="/LibrarySystem/LendingBookServlet?action=continue">続けて貸出をする</a>
<p style="text-align:center">
<form action="/LibrarySystem/LendingBookServlet" method="post">
<input type="hidden" name="lendingAct" value="finish">
<input type="submit" value="終了">
</p><br>
</form>

</c:if>

<c:if test="${act eq 'return'}">

<a href="/LibrarySystem/ReturnBookServlet?action=continue">続けて返却をする</a>
<p style="text-align:center">
<form action="/LibrarySystem/ReturnBookServlet" method="post">
<input type="hidden" name="returnAct" value="finish">
<input type="submit" value="終了">
</p><br>
</form>

</c:if>
</body>
</html>