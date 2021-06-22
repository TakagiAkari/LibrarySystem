<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>変更画面</title>
</head>

<jsp:include page="header.jsp"/>

<body>

<form action="/LibrarySystem/ChangeBookInfoServlet" method="post">
<input type="hidden" name="bookId" value="${PreviousRecordInfo.bookId}">
ISBN番号：<input type="text" name="isbn" value = "${PreviousCatalogInfo.isbn}"><br>
題名：<input type="text" name="bookName" value = "${PreviousCatalogInfo.bookName}"><br>
著者:<input type="text" name="author" value= "${PreviousCatalogInfo.author}"><br>
出版社：<input type="text" name="publisher" value= "${PreviousCatalogInfo.publisher}"><br>
出版年月日：<input type="text" name="publishedY" value =  "${PreviousCatalogInfo.publishDay.getYear()+1900}">年<input type="text" name="publishedM" value = "${PreviousCatalogInfo.publishDay.getMonth()+1}">月<input type="text" name="publishedD" value = "${PreviousCatalogInfo.publishDay.getDay()}">日<br>


<input type="submit" value="確認画面へ">
<input type="hidden" name="action" value="show">
</form>

</body>

<jsp:include page="footer.jsp"/>

</html>