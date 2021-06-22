<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員登録入力画面</title>
</head>
<body>
	<jsp:include page="header.jsp"/>

	<h1>会員登録情報入力</h1>

	<form action="/LibrarySystem/RegisterMemberInfoServlet" method="post">
		氏名：<input type="text" name="name" required><br>
		住所：<input type="text" name="address" required><br>
		電話番号：<input type="text" name="tel" required><br>
		e-mail:<input type="text" name="email" required><br>
		生年月日：<input type="text" name="birthY" required>年
			<input type="text" name="birthM" required>月
			<input type="text" name="birthD" required>日<br>
		<p style="text-align:center">
		<input type="submit" value="確認画面へ">
		<input type="hidden" name="action" value="next">
		</p><br>
	</form>

	<jsp:include page="footer.jsp"/>
</body>

</html>