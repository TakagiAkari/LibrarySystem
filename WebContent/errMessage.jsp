<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<header>
	<h1>新宿図書館 図書管理システム</h1>
	<div style="text-align:right;">
		<a href="/LibrarySystem/LoginServlet?action=logout" style="text-align:right;">ログアウト</a>
	</div>
</header>
<body>


<jsp:include page="header.jsp"/>

<h1>${message }</h1>

<jsp:include page="footer.jsp"/>

</body>
<footer>
	<hr>
	<a href="/LibrarySystem/LoginServlet">トップページへ戻る</a>
</footer>
</html>