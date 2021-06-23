<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>資料変更入力画面</title>
</head>

<jsp:include page="header.jsp"/>

<body>

<h1>資料変更情報入力</h1>

<form action="/LibrarySystem/ChangeBookInfoServlet" method="post">
ISBN番号：<input type="number" name="isbn" size="13"  value="${PreviousCatalogInfo.isbn}" required><br>
題名：<input type="text" name="title" value="${PreviousCatalogInfo.bookName }" required><br>
分類コード：<input type="number" name="category" value="${PreviousCatalogInfo.category}" required><br>
著者：<input type="text" name="author" value="${ PreviousCatalogInfo.author}" required><br>
出版社：<input type="text" name="publisher"  value="${PreviousCatalogInfo.publisher}" required><br>
出版年月日：
	<input type="number" name="publishedY" value="${PreviousCatalogInfo.publishDay.toLocalDate().getYear() }" required>年
	<input type="number" name="publishedM"  value="${PreviousCatalogInfo.publishDay.toLocalDate().getMonthValue() }"  required>月
	<input type="number" name="publishedD"  value="${PreviousCatalogInfo.publishDay.toLocalDate().getDayOfMonth() }"  required>日<br>
入荷年月日：
	<input type="number" name="stockY"  value="${PreviousRecordInfo.stockDay.toLocalDate().getYear() }" required>年
	<input type="number" name="stockM"  value="${PreviousRecordInfo.stockDay.toLocalDate().getMonthValue() }" required>月
	<input type="number" name="stockD"  value="${PreviousRecordInfo.stockDay.toLocalDate().getDayOfMonth() }" required>日<br>
備考：<input type="text" name="memo" value="${PreviousRecordInfo.memo }"><br>

<p style="text-align:center">
<input type="submit" value="確認画面へ">
<input type="hidden" name="action" value="show">
</p>

</form>

</body>

<jsp:include page="footer.jsp"/>

</html>