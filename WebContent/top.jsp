<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>トップ画面</title>
<!-- 1.cssを読み込む -->
<jsp:include page="importLayout.jsp"/>
</head>
<body>
<jsp:include page="header.jsp"/>
<!-- 2.article -->
<article>
<!-- 3.flexboxを使って横並びにする -->
<div class="container top-placement">
	<div class="item">
		<h2 class="center-title">会員管理</h2>
		<ul>
			<li><a href="/LibrarySystem/SearchMemberInfoServlet">検索</a></li>
			<li><a href="/LibrarySystem/RegisterMemberInfoServlet">登録</a></li>
			<li><a href="/LibrarySystem/ChangeMemberInfoServlet">変更</a></li>
			<li><a href="/LibrarySystem/DeleteMemberInfoServlet">退会</a></li>
		</ul>
	</div>
	<div class="item">
	<h2 class="center-title">資料管理</h2>
	<ul>
		<li><a href="/LibrarySystem/SearchBookInfoServlet">検索</a></li>
		<li><a href="/LibrarySystem/RegisterBookInfoServlet">登録</a></li>
		<li><a href="/LibrarySystem/ChangeBookInfoServlet">変更</a></li>
		<li><a href="/LibrarySystem/DeleteBookInfoServlet">削除</a></li>
	</ul>
	</div>
	<div class="item">
	<h2 class="center-title">貸出管理</h2>
	<ul>
		<li><a href="/LibrarySystem/LendingBookServlet">貸出</a></li>
		<li><a href="/LibrarySystem/ReturnBookServlet">返却</a></li>
		<li><a href="/LibrarySystem/ShowLendingServlet">貸出履歴</a></li>
	</ul>
	</div>
</div>
</article>

<jsp:include page="footer.jsp"/>

</body>
</html>