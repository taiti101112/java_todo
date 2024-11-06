<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>確認画面</title>
    </head>
    <body>
        <h2>入力情報を確認して登録ボタンを押してください</h2>
        名前：<strong><%= request.getParameter("name") %></strong><br/>
        メールアドレス：<strong><%= request.getParameter("email") %></strong>
    </body>
</html>
