<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>退会会員情報確認画面</title>
</head>
<body>
<form action="/LibrarySystem/DeleteMemberInfoServlet" method="post">
<h1>新宿図書館 図書管理システム</h1>
<h1>退会会員情報</h1>
<br>会員ID：${member.userId }
<br>氏名：${member.userName }
<br>住所：${member.address }
<br>E-Mail：${member.email }
<br>生年月日：${member.birth }
<br>入会年月日：${member.enterDay }
<br>
<br>
<input type="submit" value="削除">
<input type="hidden" name="action" value="delete">
<input type="hidden" name="userId" value="${member.userId }">

</form>
<h1>貸出中</h1>
貸出状況：
</body>
</html>