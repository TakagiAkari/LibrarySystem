<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>貸出履歴一覧表示画面</title>
<jsp:include page="importLayout.jsp"/>
</head>
<body>

<jsp:include page="header.jsp"/>

<article>

	<h2>貸出履歴一覧</h2>

	<div class="center-form">
		<table border="1">

			<tr>
			<td>貸出番号</td>
			<td>資料ID</td>
			<td>会員ID</td>
			<td>貸出日</td>
			<td>返却予定日</td>
			<td>返却日</td>
			<td>備考</td></tr>

		<c:forEach items="${lending}" var="lending">
			<tr>
			<td>${lending.lendId }</td>
			<td>${lending.bookId }</td>
			<td>${lending.userId }</td>
			<td>${lending.lendDay.toLocalDate().getYear() }年${lending.lendDay.toLocalDate().getMonthValue() }月${lending.lendDay.toLocalDate().getDayOfMonth() }日</td>
			<td>${lending.returnLimit.toLocalDate().getYear() }年${lending.returnLimit.toLocalDate().getMonthValue() }月${lending.returnLimit.toLocalDate().getDayOfMonth() }日</td>
			<td>${lending.returnDay.toLocalDate().getYear() }年${lending.returnDay.toLocalDate().getMonthValue() }月${lending.returnDay.toLocalDate().getDayOfMonth() }日</td>
			<td>${lending.memo }</td>
			</tr>
		</c:forEach>

		</table>
	</div>

</article>

<jsp:include page="footer.jsp"/>

</body>
</html>