<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>資料検索結果表示画面</title>
<jsp:include page="importLayout.jsp"/>
</head>
<body>

<jsp:include page="header.jsp"/>

<article>

	<h2>資料検索結果</h2>

	<div class="center-form">
		<form action="/LibrarySystem/ChangeMemberInfoServlet" method="post">
			<dl>
				<dt>資料ID</dt>
				<dd>${record.bookId }</dd>
				<dt>ISBN番号</dt>
				<dd>${record.isbn }</dd>
				<dt>資料名</dt>
				<dd>${catalog.bookName }</dd>
				<dt>分類コード</dt>
				<dd>${catalog.category }</dd>
				<dt>著者</dt>
				<dd>${catalog.author }</dd>
				<dt>出版社</dt>
				<dd>${catalog.publisher }</dd>
				<dt>出版日</dt>
				<dd>${catalog.publishDay.toLocalDate().getYear() }年${catalog.publishDay.toLocalDate().getMonthValue() }月${catalog.publishDay.toLocalDate().getDayOfMonth() }日</dd>
				<dt>入荷年月日</dt>
				<dd>${record.stockDay.toLocalDate().getYear() }年${record.stockDay.toLocalDate().getMonthValue() }月${record.stockDay.toLocalDate().getDayOfMonth() }日</dd>
				<dt>備考</dt>
				<dd>${record.memo }</dd>
			</dl>
		</form>
	</div>

</article>

<jsp:include page="footer.jsp"/>

</body>
</html>