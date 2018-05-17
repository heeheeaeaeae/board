<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
<script>

</script>


</head>
<body>
<div class="col-sm-3 col-md-2 sidebar">
	
	
	<ul class="nav nav-sidebar">
	<c:forEach items="${boardPanlist }" var="list">
		<li><a href = "${pageContext.request.contextPath }/boardServlet?bp_seq=${list.bp_seq}">
		${list.bp_name}
		<input type= "button" value="on/off">
		</a>
		</li>	
	</c:forEach>
	</ul>
	
	<form action="${pageContext.request.contextPath }/newBoardServlet" method="post">
		<input type="text" name="bp_name"> 
		<input type ="submit" value="게시판 추가">
	</form>	
</div>
</body>
</html> 