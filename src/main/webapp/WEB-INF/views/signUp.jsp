<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <title>ȸ������ ������</title>
</head>
<body>
    <h1>ȸ�� ����</h1>
    <hr>

    <form th:action="@{/signup}" method="post">
        <input type="text" name="name" placeholder="�̸��� �Է����ּ���">
        <input type="password" name="password" placeholder="��й�ȣ">
        <button type="submit">�����ϱ�</button>
    </form>
</body>
</html>