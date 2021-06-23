<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員検索結果表示画面</title>
<jsp:include page="importLayout.jsp"/>
</head>
<body>

<jsp:include page="header.jsp"/>

<article>

	<h2>会員検索結果</h2>

	<div class="center-form">
		<dl>
			<dt>名前</dt>
			<dd>${member.userId }</dd>
			<dt>住所</dt>
			<dd>${member.address }</dd>
			<dt>電話番号</dt>
			<dd>${member.tel }</dd>
			<dt>E-Mail</dt>
			<dd>${member.email }</dd>
			<dt>生年月日</dt>
			<dd>：${member.birth.toLocalDate().getYear() }年
			${member.birth.toLocalDate().getMonthValue() }月$
			{member.birth.toLocalDate().getDayOfMonth() }日</dd>
			<dt>入会年月日</dt>
			<dd>${member.enterDay.toLocalDate().getYear() }年
			${member.enterDay.toLocalDate().getMonthValue() }月
			${member.enterDay.toLocalDate().getDayOfMonth() }日</dd>
		</dl>

		<%--検索をやり直すならココに --%>
	</div>

</article>

<jsp:include page="footer.jsp"/>

</body>
</html>