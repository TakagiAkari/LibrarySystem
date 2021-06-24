<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>資料変更入力画面</title>
<jsp:include page="importLayout.jsp"/>
</head>
<body>

<jsp:include page="header.jsp"/>

<article>

<h2>資料変更情報入力</h2>

<div class="center-form">
	<form action="/LibrarySystem/ChangeBookInfoServlet" method="post">
		<dl>
			<%-- <dt>資料ID</dt>
				<dd>資料ID入力画面から持ってくる</dd>--%>
			<dt>ISBN番号</dt>
			<dd><input type="number" name="isbn" min="1" max="9999999999999" value="${PreviousCatalogInfo.isbn}" required></dd>
			<dt>題名</dt>
			<dd><input type="text" name="title" value="${PreviousCatalogInfo.bookName }" required></dd>
			<dt>分類コード</dt>
			<dd><input type="number" name="category" min="0" max="9" value="${PreviousCatalogInfo.category}" required></dd>
			<dt>著者</dt>
			<dd><input type="text" name="author" value="${ PreviousCatalogInfo.author}" required></dd>
			<dt>出版社</dt>
			<dd><input type="text" name="publisher"  value="${PreviousCatalogInfo.publisher}" required></dd>
			<dt>出版年月日</dt>
			<dd><input type="number" name="publishedY" min="1800" max="2100" value="${PreviousCatalogInfo.publishDay.toLocalDate().getYear() }" required>年
				<input type="number" name="publishedM" min="1" max="12" value="${PreviousCatalogInfo.publishDay.toLocalDate().getMonthValue() }"  required>月
				<input type="number" name="publishedD" min="1" max="31" value="${PreviousCatalogInfo.publishDay.toLocalDate().getDayOfMonth() }"  required>日</dd>
			<dt>入荷年月日</dt>
			<dd><input type="number" name="stockY" min="1800" max="2100" value="${PreviousRecordInfo.stockDay.toLocalDate().getYear() }" required>年
				<input type="number" name="stockM" min="1" max="12" value="${PreviousRecordInfo.stockDay.toLocalDate().getMonthValue() }" required>月
				<input type="number" name="stockD" min="1" max="31" value="${PreviousRecordInfo.stockDay.toLocalDate().getDayOfMonth() }" required>日</dd>
			<dt>備考</dt>
			<dd><input type="text" name="memo" value="${PreviousRecordInfo.memo }"></dd>
		</dl>

		<div class="container next-button-placement">
			<div class="button next-button">
				<input type="submit" value="確認画面へ">
				<input type="hidden" name="action" value="show">
			</div>
		</div>

	</form>
</div>

</article>

<jsp:include page="footer.jsp"/>

</body>
</html>