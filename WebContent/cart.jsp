<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String[] items = (String[])session.getAttribute("item");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ショッピングカート</title>
</head>
<body>
	<h1>ショッピングカート</h1>
	<ul>
		<li><a href="/w10exercise/itemList.jsp">買い物を続ける</a></li>
	</ul>
	<% if(items == null || items[0] == null) { %>
	<p>カートは空です</p>
	<% }else{ %>
	<table>
		<tr>
			<td>商品</td>
			<td>&nbsp;</td>
		</tr>
	<% for(int i = 0; items[i] != null; i ++){	%>
		<tr>
			<td><%=items[i] %></td>
			<td><a href="/w10exercise/RemoveItem?item=<%=items[i]%>">削除</a></td>
		</tr>
	<%}
	}%>
	</table>

</body>
</html>