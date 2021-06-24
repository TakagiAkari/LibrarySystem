<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>貸出確認画面</title>
<jsp:include page="importLayout.jsp"/>
</head>
<body>

<jsp:include page="header.jsp"/>

<article>

	<h2>貸出情報確認</h2>

	<div class="center-form">
		<dl>
			<dt>会員ID</dt>
			<dd>${displayInfo.userId}</dd>
			<dt>会員名</dt>
			<dd>${displayInfo.userName}</dd>
			<dt>書籍ID</dt>
			<dd>${displayInfo.bookId}</dd>
			<dt>書籍名</dt>
			<dd>${displayInfo.bookName}</dd>
		</dl>

		<form action="/LibrarySystem/LendingBookServlet" method="post">
			<div class="container next-button-placement">
				<div class="button next-button">
					<input type="submit" value="貸出する">
					<input type="hidden" name="action" value="complete">
				</div>
			</div>
		</form>
	</div>

</article>

<jsp:include page="footer.jsp"/>

</body>
</html>