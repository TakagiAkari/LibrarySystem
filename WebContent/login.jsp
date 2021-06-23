<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
<jsp:include page="importLayout.jsp"/>
</head>
<body>
<jsp:include page="header.jsp"/>
<%--ログイン画面にログアウト要るか問題 --%>
<article>

	<h2>職員情報入力</h2>

	<div class="center-form">
		<form action="/LibrarySystem/LoginServlet" method="post">
			<dl>
				<dt>ユーザー名</dt>
				<dd><input type="text" name="userName" required></dd>
				<dt>パスワード</dt>
				<dd><input type="password" name="password" required></dd>
			</dl>

			<div class="container next-button-placement">
				<div class="button next-button">
					<input type="submit" value="ログイン">
				</div>
			</div>
		</form>
	</div>

</article>

</body>
</html>