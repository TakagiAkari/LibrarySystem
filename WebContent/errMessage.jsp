<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>エラー画面</title>
<jsp:include page="importLayout.jsp"/>
</head>
<body>
	<jsp:include page="header.jsp"/>

	<p>${message }</p>

	<jsp:include page="footer.jsp"/>
</body>
</html>