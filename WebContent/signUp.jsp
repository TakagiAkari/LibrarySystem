<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員登録入力画面</title>
<jsp:include page="importLayout.jsp"/>
</head>
<body>
<jsp:include page="header.jsp"/>
<article>
<!-- 小見出しがh2以外になってたら、h2に統一 -->
	<h2>会員登録情報入力</h2>
	<!--  center-formを使うといいよ -->
	<div class="center-form">
		<form action="/LibrarySystem/RegisterMemberInfoServlet" method="post">
			<dl>
				<dt>氏名</dt>
				<dd><input type="text" name="name" required></dd>
				<dt>住所</dt>
				<dd><input type="text" name="address" required></dd>
				<dt>電話番号</dt>
				<dd><input type="text" name="tel" required></dd>
				<dt>e-mail</dt>
				<dd><input type="text" name="email" required></dd>
				<dt>生年月日</dt>
				<dd><input type="text" name="birthY" required>年
				<input type="text" name="birthM" required>月
				<input type="text" name="birthD" required>日</dd>
			</dl>
			<!-- buttonは配置と色とか変えたいので、flexbox使う -->
				<div class="container next-button-placement">
					<div class="button next-button">
						<input type="submit" value="確認画面へ">
					</div>
				</div>
				<input type="hidden" name="action" value="next">
				<br>
		</form>
	</div>
</article>
<jsp:include page="footer.jsp"/>
</body>

</html>