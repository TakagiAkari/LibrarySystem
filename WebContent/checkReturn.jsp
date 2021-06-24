<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>返却確認画面</title>
<jsp:include page="importLayout.jsp"/>
</head>
<body>

<jsp:include page="header.jsp"/>

<article>

	<h1>返却情報確認</h1>

	<div class="center-form">
		<dl>
			<dt>会員ID</dt>
			<dd>${lendingBeanForReturnBook.userId}</dd>
			<dt>会員名</dt>
			<dd>${userNameForReturnBook}</dd>
			<dt>資料ID</dt>
			<dd>${lendingBeanForReturnBook.bookId}</dd>
			<dt>資料名</dt>
			<dd>${bookNameForReturnBook}</dd>
			<dt>返却期限</dt>
			<dd>${lendingBeanForReturnBook.returnLimit.publishDay.toLocalDate().getYear()}年
				${lendingBeanForReturnBook.returnLimit.publishDay.toLocalDate().getMonthValue()}月
				${lendingBeanForReturnBook.returnLimit.publishDay.toLocalDate().getDayOfMonth()}日</dd>
			<dt>返却日</dt>
			<dd>${lendingBeanForReturnBook.returnDay.publishDay.toLocalDate().getYear()}
				${lendingBeanForReturnBook.returnDaypublishDay.toLocalDate().getMonthValue()}
				${lendingBeanForReturnBook.returnDay.publishDay.toLocalDate().getDayOfMonth()}</dd>
			<dt>備考</dt>
			<dd>${lendingBeanForReturnBook.memo}</dd>
		</dl>

		<form action="/LibrarySystem/ReturnBookServlet" method="post">
			<div class="container next-button-placement">
				<div class="button next-button">
					<input type="submit" value="返却する">
					<input type="hidden" name="action" value="complete">
				</div>
			</div>
		</form>
	</div>

</article>

<jsp:include page="footer.jsp"/>

</body>

</html>