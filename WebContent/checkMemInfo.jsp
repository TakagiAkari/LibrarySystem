<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員登録確認画面</title>
</head>
<body>
	<jsp:include page="header.jsp"/>

	<h1>会員登録情報確認</h1>

	氏名：${InputMemberInfo.name}<br>
	住所：${InputMemberInfo.address}<br>
	電話番号：${InputMemberInfo.tel}<br>
	e-mail:${InputMemberInfo.email}<br>
	生年月日：${InputMemberInfo.birthY}年${InputMemberInfo.birthM}月${InputMemberInfo.birthD}日<br>
	<form action="/LibrarySystem/RegisterMemberInfoServlet" method="post">
	<input type="hidden" name="action" value="complete">
	<p style="text-align:center">
	<input type="submit"  value="登録する">
	</p><br>
	</form>
	<a href="RegisterMemberInfoServlet?action=reInput">入力をやり直す</a><br>

	<jsp:include page="footer.jsp"/>

</body>
</html>