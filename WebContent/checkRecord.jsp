<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>資料台帳確認画面</title>
</head>
<body>
ISBN番号：${BookInfo.name}<br>
題名：${BookInfo.address}<br>
入荷年月日：${BookInfo.stockY}年${BookInfo.stockM}月${BookInfo.stockD}日<br>
廃棄年月日：${BookInfo.throwoutY}年${BookInfo.throwoutM}月${BookInfo.throwoutD}日<br>
備考：${BookInfo.memo}<br>
<form action="/LibrarySystem/RegisterBookInfoServlet" method="post">
<input type="hidden" name="action" value="complete">
<input type="submit"  value="登録する"><br>
</form>
<a href="RegisterBookInfoServlet?action=reInput">入力をやり直す</a>


</body>
</html>