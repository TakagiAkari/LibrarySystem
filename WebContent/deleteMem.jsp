<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>会員退会確認画面</title>
<jsp:include page="importLayout.jsp"/>
</head>
<body>

<jsp:include page="header.jsp"/>

<article>

	<h2>退会会員情報確認</h2>

	<div class="center-form">

			<dl>
				<dt>名前</dt>
				<dd>${member.userId }</dd>
				<dt>住所</dt>
				<dd>${member.userName }</dd>
				<dt>E-Mail</dt>
				<dd>${member.email }</dd>
				<dt>生年月日</dt>
				<dd>${member.birth }</dd>
				<dt>入会年月日</dt>
				<dd>${member.enterDay }</dd>
			</dl>

			<h3>貸出状況</h3>
				<dl>
					<dt>貸出中資料</dt>
					<dd>
						<c:if test="${lending eq true}">
						あり<form action="/LibrarySystem/DeleteMemberInfoServlet" method="post">
							<div class="container next-button-placement">
								<div class="button next-button">
									<input type="submit" value="削除する">
									<input type="hidden" name="action" value="cannot">
									<input type="hidden" name="MemID" value="${member.userId }">
								</div>
							</div>
							</form>
						</c:if>

						<c:if test="${lending eq false}">
						なし<form action="/LibrarySystem/DeleteMemberInfoServlet" method="post">
						<div class="container next-button-placement">
							<div class="button next-button">
								<input type="submit" value="削除する">
								<input type="hidden" name="action" value="complete">
								<input type="hidden" name="MemID" value="${member.userId }">
							</div>
						</div>
						</form>
						</c:if>
					</dd>
				</dl>

		</form>
	</div>

<%--
<c:if test="${lending eq true}">

<h1>退会会員情報確認</h1>
<form action="/LibrarySystem/DeleteMemberInfoServlet" method="post">

会員ID：${member.userId }
<br>氏名：${member.userName }
<br>住所：${member.address }
<br>E-Mail：${member.email }
<br>生年月日：${member.birth }
<br>入会年月日：${member.enterDay }
<br>
<br>
<h1>貸出状況</h1>
貸出中の資料：あり

<input type="submit" value="削除する">
<input type="hidden" name="action" value="cannot">
<input type="hidden" name="MemID" value="${member.userId }">

</form>
</c:if>

<c:if test="${lending eq false}">
<form action="/LibrarySystem/DeleteMemberInfoServlet" method="post">

<h1>退会会員情報確認</h1>

会員ID：${member.userId }
<br>氏名：${member.userName }
<br>住所：${member.address }
<br>E-Mail：${member.email }
<br>生年月日：${member.birth }
<br>入会年月日：${member.enterDay }
<br>
<br>
<h1>貸出状況</h1>
貸出中の資料：なし

<input type="submit" value="削除する">
<input type="hidden" name="action" value="complete">
<input type="hidden" name="MemID" value="${member.userId }">

</form>
</c:if>
--%>

</article>

<jsp:include page="footer.jsp"/>

</body>
</html>