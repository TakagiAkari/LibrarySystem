<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>資料ID入力画面</title>
<jsp:include page="importLayout.jsp"/>
</head>

<body>

<jsp:include page="header.jsp"/>

<article>

<h2>資料情報入力</h2>

<div class="center-form">

	<c:if test="${mode eq 'change'}">
	<form method="post">
		<dl>
			<dt>資料ID</dt>
			<dd><input type="number" maxlength="6" name="bookId" required></dd>
		</dl>
		<div class="container next-button-placement">
			<div class="button next-button">
				<input type="submit" formaction="/LibrarySystem/ChangeBookInfoServlet" value="変更">
				<input type="hidden" name="action" value="work">
			</div>
		</div>
	</form>
	</c:if>

	<c:if test="${mode eq 'search'}">
	<form method="post">
		<dl>
			<dt>資料ID</dt>
			<dd><input type="number" maxlength="6" name="bookId" required></dd>
		</dl>

		<div class="container next-button-placement">
			<div class="button next-button">
				<input type="submit" formaction="/LibrarySystem/SearchBookInfoServlet" value="検索">
				<input type="hidden" name="action" value="work">
			</div>
		</div>
	</form>
	</c:if>

	<c:if test="${mode eq 'delete'}">
	<form method="post">
		<dl>
			<dt>資料ID</dt>
			<dd><input type="number" maxlength="6" name="bookId" required></dd>
		</dl>
		<div class="container next-button-placement">
			<div class="button next-button">
				<input type="submit" formaction="/LibrarySystem/DeleteBookInfoServlet" value="削除">
				<input type="hidden" name="action" value="work">
			</div>
		</div>
	</form>
	</c:if>

</div>

</article>

<jsp:include page="footer.jsp"/>

</body>
</html>