<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>資料目録入力画面</title>
<jsp:include page="importLayout.jsp"/>
</head>
<body>

<jsp:include page="header.jsp"/>

<article>

	<h2>資料目録情報入力</h2>

	<div class="center-form">
		<form action="/LibrarySystem/RegisterBookInfoServlet" method="post">
			<dl>
				<dt>題名</dt>
				<dd><input type="text" name="title" required></dd>
				<dt>分類コード</dt>
				<dd><input type="number" maxlength="1" name="category" required></dd>
				<dt>著者</dt>
				<dd><input type="text" name="author" required></dd>
				<dt>出版社</dt>
				<dd><input type="text" name="publisher" required></dd>
				<dt>出版年月日</dt>
				<dd><input type="number"  maxlength="4" name="publishedY" required>年
				<input type="number"  maxlength="2" name="publishedM" required>月
				<input type="number"  maxlength="2" name="publishedD" required>日</dd>
			</dl>

			<div class="container next-button-placement">
				<div class="button next-button">
					<input type="hidden" name="action" value="registerCatalog">
					<input type="submit" value="登録する">
				</div>
			</div>
		</form>
	</div>


</article>

<jsp:include page="footer.jsp"/>

</body>
</html>