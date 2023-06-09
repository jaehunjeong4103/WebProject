<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin="crossorigin">
	<link href="https://fonts.googleapis.com/css2?family=Gowun+Dodum&family=Song+Myung&display=swap" rel="stylesheet">
	<link href="../../css/calendar.css?after" type="text/css" rel="stylesheet" />
	<title>Insert title here</title>
</head>
<body>
	<div id="calendar">
		<section class="calendar left">
			<table>
				<tr>
					<td>
						<a href="/WEB-INF/view/calendar?c_year=${pre_year}&c_month=${pre_month}">◀</a>
					</td>
					<td colspan="6">${year}년 ${month}월</td>
				</tr>
				<tr>
					<td>일</td>
					<td>월</td>
					<td>화</td>
					<td>수</td>
					<td>목</td>
					<td>금</td>
					<td>토</td>
				</tr>
				<tr>
					<c:forEach var="list" items="${calendar_list}" varStatus="status">
						<c:choose>
							<c:when test="${status.index%7==6}">
								<td class="sat">${list.day}</td>
							</c:when>
							<c:when test="${status.index%7==0}">
				</tr>
				<tr>
								<td class="sun">${list.day}</td>
							</c:when>
							<c:otherwise>
								<td class="weekday">${list.day}</td>
							</c:otherwise>
						</c:choose>						
					</c:forEach>
				</tr>
			</table>
		</section>
		<section class="calendar right">
			<table>
				<tr>
					<td colspan="6">${year}년 ${month}월</td>
					<td>
						<a href="/WEB-INF/view/calendar?c_year=${next_year}&c_month=${next_month}">▶</a>
					</td>
				</tr>
				<tr>
					<td>일</td>
					<td>월</td>
					<td>화</td>
					<td>수</td>
					<td>목</td>
					<td>금</td>
					<td>토</td>
				</tr>
				<tr>
					<c:forEach var="list" items="${next_calendar_list}" varStatus="status">
						<c:choose>
							<c:when test="${status.index%7==6}">
								<td class="sat">${list.day}</td>
							</c:when>
							<c:when test="${status.index%7==0}">
				</tr>
				<tr>
								<td class="sun">${list.day}</td>
							</c:when>
							<c:otherwise>
								<td class="weekday">${list.day}</td>
							</c:otherwise>
						</c:choose>						
					</c:forEach>
				</tr>
			</table>  		
		</section>	
	</div>
</body>
</html>