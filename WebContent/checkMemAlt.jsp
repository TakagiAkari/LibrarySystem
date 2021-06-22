<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員変更確認画面</title>
</head>
<body>
<jsp:include page="header.jsp"/>

<h1>会員変更情報確認</h1>

名前:${PreviousMemberInfo.userName}<br>
住所:${PreviousMemberInfo.address}<br>
e-mail:${PreviousMemberInfo.email}<br>
電話番号:${PreviousMemberInfo.tel}<br>
生年月日:${PreviousMemberInfo.birth.getYear()+1900}年${PreviousMemberInfo.birth.getMonth()+1}月${PreviousMemberInfo.birth.getDay()}日<br>
<br>
<p style="text-align:center">↓</p><br>
<br>
氏名：${LaterMemberInfo.userName}<br>
住所：${LaterMemberInfo.address}<br>
電話番号：${LaterMemberInfo.tel}<br>
e-mail:${LaterMemberInfo.email}<br>
生年月日：${LaterMemberInfo.birth.getYear()+1900}年
	${LaterMemberInfo.birth.getMonth()+1}月
	${LaterMemberInfo.birth.getDay()}日<br>
<%-- ↓ボタンにする--%>
<%-- ボタンにした　<p style="text-align:center"><a href="/LibrarySystem/ChangeMemberInfoServlet?action=change">変更する</a></p><br>--%>
<input type="submit" value="変更する"><br>
<input type="hidden" name="action" value="change">

<jsp:include page="footer.jsp"/>
</body>
</html>