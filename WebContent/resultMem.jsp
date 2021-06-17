<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索結果表示</title>
</head>
<body>

<h1>検索結果</h1>

<br>会員ID：${member.userId }
<br>会員名：${member.userName }
<br>住所：${member.address }
<br>電話番号：${member.tel }
<br>メールアドレス：${member.email }
<br>生年月日：${member.birth }
<br>入会日：${member.enterDay }
<br>
<br>
<p style="text-align:center"><a href="/LibrarySystem/top.jsp">トップページ画面に戻る</a></p>

</body>
</html>