<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員検索入力画面</title>
<jsp:include page="importLayout.jsp"/>
</head>
<body>

<jsp:include page="header.jsp"/>

<article>

	<h2>会員検索情報入力</h2>

	<div class="center-form">

		<form action="/LibrarySystem/SearchMemberInfoServlet" method="post">

			<dl>
				<dt>E-Mail</dt>
				<dd><input type="email" name="email" required></dd>
			</dl>

			<div class="container next-button-placement">
				<div class="button next-button">
					<input type="submit" value="検索する">
					<input type="hidden" name="action" value="search">
				</div>
			</div>
		</form>
	</div>
</article>

<jsp:include page="footer.jsp"/>

</body>
</html>