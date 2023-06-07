<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="../css/admin.css?after" type="text/css" rel="stylesheet" />
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="admin_insert" method="post">
		<textarea rows="1" cols="70" name="group_id" placeholder="1:관광 2:축제 3:체험 4:숙소 5:방"></textarea><br>
		<textarea rows="1" cols="70" name="name" placeholder="이름을 입력해주세요"></textarea><br>
		<textarea rows="1" cols="70" name="address" placeholder="주소를 입력해주세요"></textarea><br>
		<textarea rows="1" cols="70" name="phone" placeholder="전화번호를 입력해주세요"></textarea><br>
		<textarea rows="1" cols="70" name="op_cl" placeholder="시간를 입력해주세요"></textarea><br>
		<textarea rows="3" cols="70" name="map_path" placeholder="지도 주소를 입력해주세요"></textarea><br>
		<textarea rows="3" cols="70" name="image_path" placeholder="이미지 주소를 입력해주세요"></textarea><br>
		<textarea rows="8" cols="70" name="content" placeholder="내용을 입력해주세요"></textarea><br>
		<textarea rows="1" cols="70" name="check_in" placeholder="체크인시간을 입력해주세요"></textarea><br>
		<textarea rows="1" cols="70" name="stay_name" placeholder="숙소이름를 입력해주세요(방 추가시 입력)"></textarea><br>
		<textarea rows="1" cols="70" name="max_person" placeholder="수용인원을 입력해주세요(방 추가시 입력)"></textarea><br>
		<textarea rows="1" cols="70" name="weekend_price" placeholder="주말 가격을 입력해주세요(방 추가시 입력)"></textarea><br>
		<textarea rows="1" cols="70" name="weekday_price" placeholder="평일 가격을 입력해주세요(방 추가시 입력)"></textarea><br>
		<textarea rows="8" cols="70" name="option" placeholder="옵션을 입력해주세요(방 추가시 입력)"></textarea><br>
		<!-- 
		<input type="text" name="group_id" placeholder="1:관광 2:축제 3:체험 4:숙소 5:방"><br>
		<input type="text" name="name" placeholder="이름을 입력해주세요"><br>
		<input type="text" name="address" placeholder="주소를 입력해주세요"><br>
		<input type="text" name="phone" placeholder="전화번호를 입력해주세요"><br>
		<input type="text" name="op_cl" placeholder="시간를 입력해주세요"><br>
		<input type="text" name="map_path" placeholder="지도 주소를 입력해주세요"><br>
		<input type="text" name="image_path" placeholder="이미지 주소를 입력해주세요"><br>
		<input type="text" name="content" placeholder="내용을 입력해주세요"><br>
		<input type="text" name="check_in" placeholder="체크인시간을 입력해주세요"><br>
		<input type="text" name="stay_name" placeholder="숙소이름를 입력해주세요"><br>
		<input type="text" name="max_person" placeholder="수용인원을 입력해주세요"><br>
		<input type="text" name="price" placeholder="가격을 입력해주세요" ><br>
		<input type="text" name="option" placeholder="옵션을 입력해주세요"><br>
		 -->
		<input type="submit" value="입력하기">
	</form>
</body>
</html>