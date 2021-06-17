<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>トップページ</title>
</head>
<body>

<jsp:include page="header.jsp"/>

<ul>
	<li><a>貸出</a></li>
	<li><a>返却</a></li>
</ul>
<h2>会員管理</h2>
<ul>
	<li><a href="/LibrarySystem/SearchMemberInfoServlet">検索</a></li>
	<li><a href="/LibrarySystem/RegisterMemberInfoServlet">登録</a></li>
	<li><a href="/LibrarySystem/ChangeMemberInfoServlet">変更</a></li>
	<li><a href="/LibrarySystem/DeleteMemberInfoServlet">退会</a></li>
</ul>
<h2>資料管理</h2>
<ul>
	<li><a>検索</a></li>
	<li><a>登録</a></li>
	<li><a>変更</a></li>
	<li><a>退会</a></li>
</ul>

<jsp:include page="footer.jsp"/>

</body>
</html>