<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>資料変更情認画面</title>
<jsp:include page="importLayout.jsp"/>
</head>
<body>

<jsp:include page="header.jsp"/>

<article>

	<h2>変更情報</h2>

	<div class="center-form">
		<dl>
			<dt>資料ID</dt>
			<dd>${PreviousRecordInfo.bookId}</dd>
			<dt>ISBN番号</dt>
			<dd>${LaterCatalogInfo.isbn}</dd>
			<dt>資料名</dt>
			<dd>${LaterCatalogInfo.bookName}</dd>
			<dt>入荷年月日</dt>
			<dd>${LaterCatalogInfo.publishDay.toLocalDate().getYear() }年${LaterCatalogInfo.publishDay.toLocalDate().getMonthValue() }月${LaterCatalogInfo.publishDay.toLocalDate().getDayOfMonth() }日</dd>
		</dl>

		<div class="container next-button-placement">
			<div class="button next-button">
				<form action="/LibrarySystem/ChangeBookInfoServlet" method="post">
					<input type="submit" value="変更する">
					<input type="hidden" name = "action" value="complete">
				</form>
			</div>
		</div>

	</div>

</article>

<jsp:include page="footer.jsp"/>

</body>
</html>