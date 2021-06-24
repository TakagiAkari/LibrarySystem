<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>資料削除確認画面</title>
<jsp:include page="importLayout.jsp"/>
</head>
<body>

<jsp:include page="header.jsp"/>

<article>

	<h2>資料削除情報確認</h2>

	<div class="center-form">
		<form action="/LibrarySystem/DeleteBookInfoServlet" method="post">
			<dl>
				<dt>ISBN番号</dt>
				<dd>${catalog.isbn }</dd>
				<dt>資料名</dt>
				<dd>${catalog.bookName }</dd>
				<dt>著者</dt>
				<dd>${catalog.author }</dd>
				<dt>出版社</dt>
				<dd>${catalog.publisher }</dd>
				<dt>出版年月日</dt>
				<dd>${catalog.publishDay }</dd>
			</dl>

			<div class="container next-button-placement">
				<div class="button next-button">
					<input type="submit" value="削除">
					<input type="hidden" name="action" value="complete">
					<input type="hidden" name="bookId" value="${record.bookId}">
				</div>
			</div>
		</form>
	</div>

</article>

<jsp:include page="footer.jsp"/>

</body>
</html>