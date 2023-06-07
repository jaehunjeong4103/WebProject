<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   

<!DOCTYPE html>
<html>
	<head>
		<link rel="preconnect" href="https://fonts.googleapis.com">
		<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin="crossorigin">
		<link href="https://fonts.googleapis.com/css2?family=Gowun+Dodum&family=Song+Myung&display=swap" rel="stylesheet">
		<link href="../../css/register.css?after" type="text/css" rel="stylesheet" />
		<link href="../../css/review.css?after" type="text/css" rel="stylesheet" />
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<header>
			<div id="arrow_body">
					<button onclick="history.back()"><image src="../../images/direction-arrow.png" alt="화살표" id="arrow"/></button>
			<div id="title">리뷰 작성하기</div>
		</header>		
		
		<form action="review" method="post">
			<fieldset>
				<input type="radio" name="REVIEW_STAR" value="5" id="star1">
					<label for="star1">★</label>
				<input type="radio" name="REVIEW_STAR" value="4" id="star2">
					<label for="star2">★</label>
				<input type="radio" name="REVIEW_STAR" value="3" id="star3">
					<label for="star3">★</label>
				<input type="radio" name="REVIEW_STAR" value="2" id="star4">
					<label for="star4">★</label>
				<input type="radio" name="REVIEW_STAR" value="1" id="star5">
					<label for="star5">★</label>
			</fieldset>
			
			<section>
				<textarea rows="10" cols="70" class="input_text review_text" name="REVIEW_TEXT"></textarea>
		    	<input type="submit" value="리뷰작성" id="register_button" class="button">
		    	<input type="hidden" class="input_text id" name="ID" value="${logIn_id}">
		    	<input type="hidden" value="${code}" name="CODE">
		    	<input type="hidden" value="${group_id}" name="GROUP_ID">
			</section>
		</form>
		
		<script>
			let review_text = document.querySelector(".review_text");
			let button = document.querySelector("#register_button");
			button.disabled = true;

			review_text.addEventListener('keyup', activeEvent);	
				
			function activeEvent() {
				if(review_text.value == ''){
					button.disabled = true;
				}else
					button.disabled = false;
				}
		</script>
	</body>
</html>