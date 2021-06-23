<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員登録確認画面</title>
<jsp:include page="importLayout.jsp"/>
</head>
<body>
	<jsp:include page="header.jsp"/>

	<h2>会員登録情報確認</h2>
	<div class="center-form">
		<dl>
			<dt>氏名</dt>
			<dd>${InputMemberInfo.name}</dd>
			<dt>住所</dt>
			<dd>${InputMemberInfo.address}</dd>
			<dt>電話番号</dt>
			<dd>${InputMemberInfo.tel}</dd>
			<dt>e-mail</dt>
			<dd>${InputMemberInfo.email}</dd>
			<dt>生年月日</dt>
			<dd>${InputMemberInfo.birthY}年${InputMemberInfo.birthM}月${InputMemberInfo.birthD}日</dd>
		</dl>
		<form action="/LibrarySystem/RegisterMemberInfoServlet" method="post">
			<input type="hidden" name="action" value="complete">
			<div class="container next-button-placement">
				<div class="button next-button">
					<input type="submit"  value="登録する">
				</div>
			</div>
			<br>
			<div class="container previous-button-placement">
				<div class="button previous-button like-input">
					<a href="RegisterMemberInfoServlet?action=reInput">入力をやり直す</a><br>
				</div>
			</div>
		</form>
	</div>

	<jsp:include page="footer.jsp"/>

</body>
</html>