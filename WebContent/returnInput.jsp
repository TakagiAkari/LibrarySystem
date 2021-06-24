<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>返却入力画面</title>
<jsp:include page="importLayout.jsp"/>
</head>
<body>

<jsp:include page="header.jsp"/>

<article>

	<h2>返却情報入力</h2>

	<div class="center-form">
		<form action="/LibrarySystem/ReturnBookServlet" method="post">
			<dl>
				<dt>資料ID</dt>
				<dd><input type="number" name="bookId" ></dd>
			</dl>

			<div class="container next-button-placement">
				<div class="button next-button">
					<input type="submit" value="返却する">
					<input type="hidden" name="action" value="check">
				</div>
			</div>
		</form>
	</div>

</article>

<jsp:include page="footer.jsp"/>

</body>

</html>