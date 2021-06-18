<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員登録</title>
</head>
<body>
	<jsp:include page="header.jsp"/>

	<h2>会員登録</h2>

	<form action="/LibrarySystem/RegisterMemberInfoServlet" method="post">
		氏名：<input type="text" name="name"><br>
		住所：<input type="text" name="address"><br>
		電話番号：<input type="text" name="tel"><br>
		e-mail:<input type="text" name="email"><br>
		生年月日：<input type="text" name="birthY">年<input type="text" name="birthM">月<input type="text" name="birthD">日<br>
		<input type="submit" value="確認画面へ">
		<input type="hidden" name="action" value="next">
	</form>

	<jsp:include page="footer.jsp"/>
</body>

</html>