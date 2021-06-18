<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索結果表示</title>
</head>
<body>
<jsp:include page="header.jsp"/>

<h1>会員情報確認画面</h1>
名前:${member.user_name }<br>
住所:${member.user_address}<br>
e-mail:${member.user_e-mail}<br>
電話番号:${member.user_tel}<br>
生年月日:${member.user_birthday}<br>

↓<br>

氏名：${InputMemberInfo.name}<br>
住所：${InputMemberInfo.address}<br>
電話番号：${InputMemberInfo.tel}<br>
e-mail:${InputMemberInfo.email}<br>
生年月日：${InputMemberInfo.birthY}年${InputMemberInfo.birthM}月${InputMemberInfo.birthD}日<br><br>

<p style="text-align:center"><a href="/LibrarySystem/ChangeMemberInfoServlet?action=change">変更する</a></p>

<jsp:include page="footer.jsp"/>
</body>
</html>