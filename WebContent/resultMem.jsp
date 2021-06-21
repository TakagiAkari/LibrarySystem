<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員検索結果表示</title>
</head>
<body>

<jsp:include page="header.jsp"/>
<br>
<h1>会員検索結果</h1>

<br>会員ID：${member.userId }
<br>会員名：${member.userName }
<br>住所：${member.address }
<br>電話番号：${member.tel }
<br>メールアドレス：${member.email }
<br>生年月日：${member.birth }
<br>入会日：${member.enterDay }
<br>
<br>
<jsp:include page="footer.jsp"/>

</body>
</html>