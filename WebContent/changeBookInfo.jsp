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
<<<<<<< HEAD
ISBN番号：<input type="text" name="isbn" size="13" required><br>
題名：<input type="text" name="title" required><br>
分類コード：<input type="text" name="category" required><br>
著者：<input type="text" name="author" required><br>
出版社：<input type="text" name="publisher" required><br>
出版年月日：
	<input type="text" name="publishedY" required>年
	<input type="text" name="publishedM" required>月
	<input type="text" name="publishedD" required>日<br>
入荷年月日：
	<input type="text" name="stockY" required>年
	<input type="text" name="stockM" required>月
	<input type="text" name="stockD" required>日<br>
廃棄年月日：<input type="text" name="throwoutY" required>年<input type="text" name="throwoutM" required>月<input type="text" name="throwoutD" required>日<br>
備考：<textarea name="memo"></textarea><br>

<p style="text-align:center">
<input type="submit" value="確認画面へ">
<input type="hidden" name="action" value="next">
</p>

=======
<input type="hidden" name="bookId" value="${PreviousRecordInfo.bookId}">
ISBN番号：<input type="text" name="isbn" value = "${PreviousCatalogInfo.isbn}"><br>
題名：<input type="text" name="bookName" value = "${PreviousCatalogInfo.bookName}"><br>
著者:<input type="text" name="author" value= "${PreviousCatalogInfo.author}"><br>
出版社：<input type="text" name="publisher" value= "${PreviousCatalogInfo.publisher}"><br>
出版年月日：<input type="text" name="publishedY" value =  "${PreviousCatalogInfo.publishDay.getYear()+1900}">年<input type="text" name="publishedM" value = "${PreviousCatalogInfo.publishDay.getMonth()+1}">月<input type="text" name="publishedD" value = "${PreviousCatalogInfo.publishDay.getDay()}">日<br>


<input type="submit" value="確認画面へ">
<input type="hidden" name="action" value="show">
>>>>>>> dec8421780c3dcb51ca3bf7d723e2d8f186ad17b
</form>

</body>

<jsp:include page="footer.jsp"/>

</html>