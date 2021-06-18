<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索結果表示</title>
</head>
<body>

<jsp:include page="header.jsp"/>
<br>
<h1>資料検索結果</h1>

<h3>資料ID：${record.bookId }</h3>

ISBN番号：${record.isbn }
<br>資料名：${catalog.bookName }
<br>分類コード：${catalog.category }
<br>著者：${catalog.author }
<br>出版社：${catalog.publisher }
<br>出版日：${catalog.publishDay }
<br>入荷年月日：${record.stockDay }
<br>備考：${record.memo }
<%-- 実装する...? --%>
<br>貸出状況：
<br>
<br>
<jsp:include page="footer.jsp"/>

</body>
</html>