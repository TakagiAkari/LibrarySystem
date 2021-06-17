<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録内容の確認</title>
</head>
<body>
氏名：${InputMemberInfo.name}<br>
住所：${InputMemberInfo.address}<br>
電話番号：${InputMemberInfo.tel}<br>
e-mail:${InputMemberInfo.email}<br>
生年月日：${InputMemberInfo.birthY}年${InputMemberInfo.birthM}月${InputMemberInfo.birthD}日<br><br>
<form action="/LibrarySystem/RegisterMemberServlet" method="post">
<input type="hidden" name="action" value="complete">
<input type="submit"  value="登録する"><br>
</form>
<a href="RegisterMemberServlet?action=reInput">入力をやり直す</a>

</body>
</html>