<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員退会確認画面</title>
</head>
<body>

<c:if test="${lending eq true}">

<h1>退会会員情報確認</h1>

会員ID：${member.userId }
<br>氏名：${member.userName }
<br>住所：${member.address }
<br>E-Mail：${member.email }
<br>生年月日：${member.birth }
<br>入会年月日：${member.enterDay }
<br>
<br>
<h1>貸出状況</h1>
貸出状況：あり
</c:if>

<c:if test="${lending eq false}">
<form action="/LibrarySystem/DeleteMemberInfoServlet" method="post">

<h1>退会会員情報確認</h1>

会員ID：${member.userId }
<br>氏名：${member.userName }
<br>住所：${member.address }
<br>E-Mail：${member.email }
<br>生年月日：${member.birth }
<br>入会年月日：${member.enterDay }
<br>
<br>
<h1>貸出状況</h1>
貸出状況：なし
<p style="text-align:center">
<input type="submit" value="削除する">
<input type="hidden" name="action" value="complete">
<input type="hidden" name="MemID" value="${member.userId }">
</p><br>
</form>
</c:if>


</body>
</html>