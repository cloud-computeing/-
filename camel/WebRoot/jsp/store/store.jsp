<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改商铺</title>

</head>
<body> 

<form id="itemForm" action="${pageContext.request.contextPath }/StoreUsesrControl/updateStoreSubmit.action" method="post" >
<input type="hidden" name="id" value="${StoreCustom.id }"/>
修改商品信息：
<table width="100%" border=1>
<tr>
	<td>店铺名</td>
	<td><input type="text" name="sname" value="${StoreCustom.sname }"/></td>
</tr>
<tr>
	<td>电话号码</td>
	<td><input type="text" name="sphone" value="${StoreCustom.sphone }"/></td>
</tr>
	

<tr>
<td colspan="2" align="center"><input type="submit" value="提交"/>
</td>
</tr>
</table>

</form>
</body>

</html>