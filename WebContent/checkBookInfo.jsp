<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>資料全情報確認画面</title>
</head>
<body>
ISBN番号：${BookInfo.isbn}<br>
題名：${BookInfo.title}<br>
著者:${BookInfo.author}<br>
分類コード：${BookInfo.category}<br>
出版社：${BookInfo.publisher}<br>
出版年月日：${BookInfo.publishedY}年${BookInfo.publishedM}月${BookInfo.publishedD}日<br>
入荷年月日：${BookInfo.stockY}年${BookInfo.stockM}月${BookInfo.stockD}日<br>
廃棄年月日：${BookInfo.throwoutY}年${BookInfo.throwoutM}月${BookInfo.throwoutD}日<br>
備考欄：${BookInfo.memo}<br>
<form action="/LibrarySystem/RegisterBookInfoServlet" method="post">
<input type="hidden" name="action" value="complete">
<input type="submit"  value="登録する"><br>
</form>
<a href="RegisterBookInfoServlet?action=reInput">入力をやり直す</a>
</body>
</html>