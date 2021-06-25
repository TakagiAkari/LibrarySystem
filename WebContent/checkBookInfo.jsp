<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>資料登録確認画面</title>
<jsp:include page="importLayout.jsp"/>
</head>

<body>

<jsp:include page="header.jsp"/>

<article>

<h2>資料登録情報確認</h2>

<div class="center-form">
	<dl>
		<dt>資料ID</dt>
		<dd>${bookIdForRegisterBook}</dd>
		<dt>ISBN番号</dt>
		<dd>${recordBeanForRegisterBook.isbn}</dd>
		<dt>題名</dt>
		<dd>${catalogBeanForRegisterBook.bookName}</dd>
		<dt>著者</dt>
		<dd>${catalogBeanForRegisterBook.author}</dd>
		<dt>分類コード</dt>
		<dd>${catalogBeanForRegisterBook.category}</dd>
		<dt>出版社</dt>
		<dd>${catalogBeanForRegisterBook.publisher}</dd>
		<dt>出版年月日</dt>
		<dd>${catalogBeanForRegisterBook.publishDay.toLocalDate().getYear()}年
			${catalogBeanForRegisterBook.publishDay.toLocalDate().getMonthValue()}月
			${catalogBeanForRegisterBook.publishDay.toLocalDate().getDayOfMonth()}日</dd>
		<dt>入荷年月日</dt>
		<dd>${recordBeanForRegisterBook.stockDay.toLocalDate().getYear()}年
			${recordBeanForRegisterBook.stockDay.toLocalDate().getMonthValue()}月
			${recordBeanForRegisterBook.stockDay.toLocalDate().getDayOfMonth()}日</dd>
		<dt>備考</dt>
		<dd>${recordBeanForRegisterBook.memo}</dd>
	</dl>

	<form action="/LibrarySystem/RegisterBookInfoServlet" method="post">
		<div class="container next-button-placement">
			<div class="button next-button">
				<input type="hidden" name="action" value="complete">
				<input type="submit"  value="登録する">
			</div>
		</div>

		<div class="container previous-button-placement">
			<div class="button previous-button like-input">
				<a href="RegisterBookInfoServlet?action=reInput">入力をやり直す</a>
			</div>
		</div>


	</form>
</div>

</article>

<jsp:include page="footer.jsp"/>

</body>
</html>