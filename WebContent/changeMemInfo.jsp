<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員変更入力画面</title>
<jsp:include page="importLayout.jsp"/>
</head>
<body>

<jsp:include page="header.jsp"/>

<article>

	<h2>会員変更情報入力</h2>

	<div class="center-form">
		<form action="/LibrarySystem/ChangeMemberInfoServlet" method="post">
			<dl>
				<dt>名前</dt>
				<dd><input type="text" name="name" value= "${PreviousMemberInfo.userName}"  required></dd>
				<dt>住所</dt>
				<dd><input type="text" name="address" value= "${PreviousMemberInfo.address}" required></dd>
				<dt>E-Mail</dt>
				<dd><input type="email" name="email" value= "${PreviousMemberInfo.email}" required></dd>
				<dt>電話番号</dt>
				<dd><input type="text" name="tel" value= "${PreviousMemberInfo.tel}" required></dd>
				<dt>生年月日</dt>
				<dd><input type="number" name="birthY" min="1900" max="2100" value= "${PreviousMemberInfo.birth.toLocalDate().getYear()}" required>年
				<input type="number" name="birthM" min="1" max="12" value= "${PreviousMemberInfo.birth.toLocalDate().getMonthValue()}" required>月
				<input type="number" name="birthD" min="1" max="31" value= "${PreviousMemberInfo.birth.toLocalDate().getDayOfMonth()}" required>日</dd>
			</dl>

			<div class="container next-button-placement">
				<div class="button next-button">
					<input type="submit" value="確認画面へ">
					<input type="hidden" name = "action" value="show">
				</div>
			</div>
		</form>
	</div>

</article>

<jsp:include page="footer.jsp"/>

</body>
</html>