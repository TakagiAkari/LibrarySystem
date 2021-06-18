<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Complete message</title>
</head>
<body>
	<jsp:include page="header.jsp"/>
		<h1>${message}が完了しました。</h1>
	<jsp:include page="footer.jsp"/>
</body>
</html>