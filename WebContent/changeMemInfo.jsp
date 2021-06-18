<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員情報変更入力</title>
</head>
<body>

<jsp:include page="header.jsp"/>
<h1>会員情報変更</h1>

名前：<input type="text" name="name"><br>
住所:<input type="text" name="address"><br>
e-mail:<input type="text" name="e-mail"><br>
電話番号:<input type="text" name="tel"><br>
生年月日:<input type="text" name="birthY">年<input type="text" name="birthM">月<input type="text" name="birthD">日<br>

<p style="text-align:center"><a href="/LibrarySystem/ChangeMemberInfoServlet?action=show">確認画面へ</a></p>

<jsp:include page="footer.jsp"/>
</body>
</html>