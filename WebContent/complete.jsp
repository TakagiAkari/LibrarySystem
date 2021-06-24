<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>完了画面</title>
<jsp:include page="importLayout.jsp"/>
<style>
p{font-size:200%}
</style>
</head>
<body>

<jsp:include page="header.jsp"/>

	<article>
		<p>${message}が完了しました。</p>
	</article>

<%--貸出 --%>
<c:if test="${act eq 'lend'}">
<article>
<a href="/LibrarySystem/LendingBookServlet?action=continue">続けて貸出をする</a>
<form action="/LibrarySystem/LendingBookServlet" method="post">
<input type="hidden" name="lendingAct" value="finish">
<input type="submit" value="終了">
</form>
</article>
</c:if>

<%--返却 --%>
<c:if test="${act eq 'return'}">
<article>
<a href="/LibrarySystem/ReturnBookServlet?action=continue">続けて返却をする</a>
<form action="/LibrarySystem/ReturnBookServlet" method="post">
<input type="hidden" name="returnAct" value="finish">
<input type="submit" value="終了">
</form>
</article>
</c:if>

<jsp:include page="footer.jsp"/>

</body>
</html>