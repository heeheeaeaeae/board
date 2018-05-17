<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@ include file="/layout/left.jsp"%>
		<table border="1px" style="border-collapse: collapse;">
			<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>글쓴이</th>
				<th>날짜</th>
			</tr>
			</thead>
			<tbody>
				<c:forEach items="${boardList }" var="vo">
					<tr>
						<td>${vo.board_seq}</td>
						<td>${vo.title}</td>
						<td>${vo.mem_id}</td>
						<td><fmt:formatDate value="${vo.reg_dt}" pattern="yyyy-MM-dd"/></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	${pageNav }
		<form action="<%=request.getContextPath() %>/board/boardWrite.jsp">
			<input type ="hidden" name="bp_seq" value="${bp_seq}">
			<input type="submit" value="글쓰기">
		</form>
	
</body>
</html>