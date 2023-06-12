<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin="crossorigin">
	<link href="https://fonts.googleapis.com/css2?family=Gowun+Dodum&family=Song+Myung&display=swap" rel="stylesheet">
	<link href="../../css/register.css?after" type="text/css" rel="stylesheet" />
	<link href="../../css/reservation.css?after" type="text/css" rel="stylesheet" />
	<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header>
		<div id="arrow_body">
			<button onclick="history.back()"><image src="../../images/direction-arrow.png" alt="화살표" id="arrow"/></button>
		<div id="title">예약하기</div>
	</header>		
	<div id="reservation_body">
		<form action="reservation" method="post">
			<section>
				<div class="input">
					<span>숙소 이름</span>
					<input type="text" class="input_text id" name="stay_name" value="${stay_name}" readonly>
				</div>
				<div class="input">
					<span>방 이름</span>
					<input type="text" class="input_text id" name="room_name" value="${room_name}" readonly>
				</div>
				<div class="input">
					<span>예약자명</span>
					<input type="text" placeholder="예약자명을 입력해주세요" class="input_text id" name="member_name">
				</div>
				<div class="input">
					<span>인원수</span>
					<input type="text" placeholder="인원수를 입력해주세요" class="input_text id" name="count">
				</div>				
				<div class="input">
					<span>입실일</span>
					<input type="text" class="input_text id" name="check_in" value="${check_in}" readonly>
				</div>				
				<div class="input">
					<span>퇴실일</span>
					<input type="text" class="input_text id" name="check_out" value="${check_out}" readonly>
				</div>
				<div class="input">
					<span>금액</span>
					<input type="text" class="input_text id" name="price" value="${price}" readonly>
				</div>
				<input type="hidden" value="${logIn_id}" name="member_id">
		    <input type="submit" value="예약하기" class="button">
			</section>
		</form>
	</div>	
</body>
</html>