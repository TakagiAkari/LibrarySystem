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

	<h2>資料変更情報確認</h2>

	<div class="center-form">
	<div class="container prepare-placement">
		<div class="change-item">
		<h3>変更前</h3>
		<dl>
			<dt>資料ID</dt>
			<dd>${PreviousRecordInfo.bookId}</dd>
			<dt>ISBN番号</dt>
			<dd>${PreviousCatalogInfo.isbn}</dd>
			<dt>題名</dt>
			<dd>${PreviousCatalogInfo.bookName}</dd>
			<dt>著者</dt>
			<dd>${PreviousCatalogInfo.author}</dd>
			<dt>分類コード</dt>
			<dd>${PreviousCatalogInfo.category}</dd>
			<dt>出版社</dt>
			<dd>${PreviousCatalogInfo.publisher}</dd>
			<dt>出版年月日</dt>
			<dd>${PreviousCatalogInfo.publishDay.toLocalDate().getYear()}年
				${PreviousCatalogInfo.publishDay.toLocalDate().getMonthValue()}月
				${PreviousCatalogInfo.publishDay.toLocalDate().getDayOfMonth()}日</dd>
			<dt>入荷年月日</dt>
			<dd>${PreviousRecordInfo.stockDay.toLocalDate().getYear()}年
				${PreviousRecordInfo.stockDay.toLocalDate().getMonthValue()}月
				${PreviousRecordInfo.stockDay.toLocalDate().getDayOfMonth()}日</dd>
			<dt>備考</dt>
			<dd>${PreviousRecordInfo.memo}</dd>
		</dl>
	<br>
	</div>
	<div class="change-item">
		<h3>変更後</h3>
			<dl>
				<dt>資料ID</dt>
				<dd>${PreviousRecordInfo.bookId}</dd>
				<dt>ISBN番号</dt>
				<dd>${LaterCatalogInfo.isbn}</dd>
				<dt>題名</dt>
				<dd>${LaterCatalogInfo.bookName}</dd>
				<dt>著者</dt>
				<dd>${LaterCatalogInfo.author}</dd>
				<dt>分類コード</dt>
				<dd>${LaterCatalogInfo.category}</dd>
				<dt>出版社</dt>
				<dd>${LaterCatalogInfo.publisher}</dd>
				<dt>出版年月日</dt>
				<dd>${LaterCatalogInfo.publishDay.toLocalDate().getYear() }年
					${LaterCatalogInfo.publishDay.toLocalDate().getMonthValue() }月
					${LaterCatalogInfo.publishDay.toLocalDate().getDayOfMonth() }日</dd>
				<dt>入荷年月日</dt>
				<dd>${LaterRecordInfo.stockDay.toLocalDate().getYear() }年
					${LaterRecordInfo.stockDay.toLocalDate().getMonthValue() }月
					${LaterRecordInfo.stockDay.toLocalDate().getDayOfMonth() }日</dd>
				<dt>備考</dt>
				<dd>${LaterRecordInfo.memo}</dd>
			</dl>
			</div>
		</div>

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