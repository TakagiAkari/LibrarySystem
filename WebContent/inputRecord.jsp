<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>資料台帳入力画面</title>
<jsp:include page="importLayout.jsp"/>
</head>
<body>

<jsp:include page="header.jsp"/>

<article>

<h2>資料台帳情報入力</h2>

<div class="center-form">
	<form action="/LibrarySystem/RegisterBookInfoServlet" method="post">
		<dl>
			<dt>ISBN番号</dt>
			<dd><input type="number"  maxlength="13" name="isbn" required></dd>
			<dt>備考</dt>
			<dd><input type="text" name="memo"></dd>
		</dl>

		<div class="container next-button-placement">
			<div class="button next-button">
				<input type="submit" value="登録する">
				<input type="hidden" name="action" value="checkIsbn">
			</div>
		</div>
	</form>
</div>

</article>

<jsp:include page="footer.jsp"/>

</body>
</html>