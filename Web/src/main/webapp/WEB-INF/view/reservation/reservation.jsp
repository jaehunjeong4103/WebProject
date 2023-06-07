<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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
			<button onclick="history.back()"><image src="../../images/direction-arrow.png" alt="ȭ��ǥ" id="arrow"/></button>
		<div id="title">�����ϱ�</div>
	</header>		
	<div id="reservation_body">
		<form action="reservation" method="post">
			<section>
				<div class="input">
					<span>���� �̸�</span>
					<input type="text" class="input_text id" name="stay_name" value="${stay_name}" readonly>
				</div>
				<div class="input">
					<span>�� �̸�</span>
					<input type="text" class="input_text id" name="room_name" value="${room_name}" readonly>
				</div>
				<div class="input">
					<span>�����ڸ�</span>
					<input type="text" placeholder="�����ڸ��� �Է����ּ���" class="input_text id" name="member_name">
				</div>
				<div class="input">
					<span>�ο���</span>
					<input type="text" placeholder="�ο����� �Է����ּ���" class="input_text id" name="count">
				</div>				
				<div class="input">
					<span>���೯¥</span>
					<input type="text" class="input_text id" name="res_date" value="${res_date}" readonly>
				</div>				
				<div class="input">
					<span>�ݾ�</span>
					<input type="text" class="input_text id" name="price" value="240000" readonly>
				</div>
				<input type="hidden" value="${logIn_id}" name="member_id">
		    <input type="submit" value="�����ϱ�" class="button">
			</section>
		</form>
	</div>	
</body>
</html>