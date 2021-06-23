<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員変更確認画面</title>
<jsp:include page="importLayout.jsp"/>
</head>
<body>
<jsp:include page="header.jsp"/>
<article>

	<h2>会員変更情報確認</h2>


	<div class="center-form">

	<form action="/LibrarySystem/ChangeMemberInfoServlet" method="post">

	<h3>変更前</h3>
		<dl>
			<dt>名前</dt>
			<dd>${PreviousMemberInfo.userName}</dd>
			<dt>住所</dt>
			<dd>${PreviousMemberInfo.address}</dd>
			<dt>E-Mail</dt>
			<dd>${PreviousMemberInfo.email}</dd>
			<dt>電話番号</dt>
			<dd>${PreviousMemberInfo.tel}</dd>
			<dt>生年月日</dt>
			<dd>${PreviousMemberInfo.birth.getYear()+1900}年
			${PreviousMemberInfo.birth.getMonth()+1}月
			${PreviousMemberInfo.birth.getDay()}日</dd>
		</dl>

	<h3>変更後</h3>
		<dl>
			<dt>名前</dt>
			<dd>${LaterMemberInfo.userName}</dd>
			<dt>住所</dt>
			<dd>${LaterMemberInfo.address}</dd>
			<dt>E-Mail</dt>
			<dd>${LaterMemberInfo.tel}</dd>
			<dt>電話番号</dt>
			<dd>${LaterMemberInfo.email}</dd>
			<dt>生年月日</dt>
			<dd>${LaterMemberInfo.birth.getYear()+1900}年
			${LaterMemberInfo.birth.getMonth()+1}月
			${LaterMemberInfo.birth.getDay()}日</dd>
		</dl>

		<div class="container next-button-placement">
			<div class="button next-button">
				<input type="submit" value="変更する">
				<input type="hidden" name="action" value="change">
			</div>
		</div>
	</form>
	</div>

</article>
<jsp:include page="footer.jsp"/>
</body>
</html>