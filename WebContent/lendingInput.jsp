<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>貸出入力画面</title>
<jsp:include page="importLayout.jsp"/>
</head>

<body>

<jsp:include page="header.jsp"/>

<article>

	<h2>貸出情報入力</h2>

		<div class="center-form">
			<form action="/LibrarySystem/LendingBookServlet" method="post">
				<dl>
					<dt>会員ID</dt>

					<dd><input type="number" maxlength="5" name="userId" required></dd>
					<dt>資料ID</dt>
					<dd><input type="number" maxlength="6" name="bookId" required></dd>

					<dt>備考</dt>
					<dd><input type="text" name="memo"d></dd>
				</dl>

				<div class="container next-button-placement">
					<div class="button next-button">
						<input type="submit" value="確認画面へ">
						<input type="hidden" name="action" value="check">
					</div>
				</div>
			</form>
		</div>

</article>

<jsp:include page="footer.jsp"/>

</body>

</html>