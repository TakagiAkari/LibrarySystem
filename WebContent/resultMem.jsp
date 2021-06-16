<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索結果表示</title>
</head>
<body>

<h1>検索結果</h1>

<br>会員ID：${member.user_id }
<br>会員名：${member.user_name }
<br>住所：${member.address }
<br>電話番号：${member.tel }
<br>メールアドレス：${member.email }
<br>生年月日：${member.birth }
<br>入会日：${member.enter_day }
<br>退会日：${member.leave_day }
<br>
<p style="text-align:center"><a href="/LibrarySystem/top.jsp">トップページ画面に戻る</a></p>

</body>
</html>