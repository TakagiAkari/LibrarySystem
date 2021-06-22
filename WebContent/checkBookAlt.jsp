<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>資料変更情認画面</title>
</head>

<jsp:include page="header.jsp"/>

<body>
<h1>変更情報</h1>

<h1>資料変更情報確認</h1>

書籍ID:${PreviousRecordInfo.bookId}<br>
ISBN番号:${LaterCatalogInfo.isbn}<br>
資料名:${LaterCatalogInfo.bookName}<br>
入荷年月日:${LaterCatalogInfo.publishDay}<br>
<form action="/LibrarySystem/ChangeBookInfoServlet" method="post">
<input type="submit" value="変更する">
<input type="hidden" name = "action" value="complete">
</form>
</body>

<jsp:include page="footer.jsp"/>

</html>