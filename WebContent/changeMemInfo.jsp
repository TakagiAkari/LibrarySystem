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

<form action="/LibrarySystem/ChangeMemberInfoServlet" method="post">
名前：<input type="text" name="name" value= "${PreviousMemberInfo.userName}"  required><br>
住所:<input type="text" name="address" value= "${PreviousMemberInfo.address}" required><br>
e-mail:<input type="text" name="email" value= "${PreviousMemberInfo.email}" required><br>
電話番号:<input type="text" name="tel" value= "${PreviousMemberInfo.tel}" required><br>
生年月日:
	<input type="text" name="birthY" value= "${PreviousMemberInfo.birth.getYear()+1900}" required>年
	<input type="text" name="birthM" value= "${PreviousMemberInfo.birth.getMonth()+1}" required>月
	<input type="text" name="birthD" value= "${PreviousMemberInfo.birth.getDay()}" required>日<br>

<p style="text-align:center"><input type="submit" value="確認画面へ"></p>
<input type="hidden" name = "action" value="show">
</form>

<jsp:include page="footer.jsp"/>
</body>
</html>