<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>資料登録全情報確認画面</title>
</head>

<jsp:include page="header.jsp"/>

<body>

<h1>資料登録情報確認</h1>

ISBN番号：${recordBeanForRegisterBook.isbn}<br>
題名：${catalogBeanForRegisterBook.bookName}<br>
著者:${catalogBeanForRegisterBook.author}<br>
分類コード：${catalogBeanForRegisterBook.category}<br>
出版社：${catalogBeanForRegisterBook.publisher}<br>
出版年月日：${catalogBeanForRegisterBook.publishDay}<br>
入荷年月日：${recordBeanForRegisterBook.stockDay}<br>
備考欄：${recordBeanForRegisterBook.memo}<br>
<form action="/LibrarySystem/RegisterBookInfoServlet" method="post">
<p style="text-align:center">
<input type="hidden" name="action" value="complete">
<input type="submit"  value="登録する"><br>
</p>
</form>
<a href="RegisterBookInfoServlet?action=reInput">入力をやり直す</a>
</body>

<jsp:include page="footer.jsp"/>

</html>