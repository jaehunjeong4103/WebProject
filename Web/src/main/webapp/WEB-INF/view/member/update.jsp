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
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<header>
			<div id="arrow_body">
				<button onclick="history.back()"><image src="../../images/direction-arrow.png" alt="화살표" id="arrow"/></button>
				<div id="title">회원수정</div>
			</div>
		</header>

		<form action="update" method="post">
			<section>
				<input type="text" placeholder="아이디를 입력해주세요" class="input_text id" name="ID" value="${member.id}" readonly>
				
			  </input>
				<input type="text" placeholder="비밀번호를 입력해주세요" class="input_text password" name="PASSWORD" value="${member.password}">
			  <input type="text" placeholder="이름을 입력해주세요" class="input_text name" name="NAME" value="${member.name}">
				<input type="text" placeholder="전화번호를 입력해주세요" class="input_text phone" name="PHONE" value="${member.phone}">
				<input type="text" placeholder="이메일을 입력해주세요" class="input_text email" name="EMAIL" value="${member.email}">
			  	
			  	<c:choose>
			  		<c:when test="${member.gender == 'male'}">
			  		<input style="scale:2" type="radio" name="GENDER" id="male" value="male" checked="checked">
			    	<label for="male">남자</label>
			    	<input style="scale:2" type="radio" name="GENDER" id="female" value="female">
			    	<label for="female">여자</label>
			  		</c:when>
			  		<c:when test="${member.gender == 'female'}">
			  		<input style="scale:2" type="radio" name="GENDER" id="male" value="male">
			    	<label for="male">남자</label>
			    	<input style="scale:2" type="radio" name="GENDER" id="female" value="female" checked="checked">
			    	<label for="female">여자</label>
			  		</c:when>
			  	</c:choose>
			  	
		    	<input type="submit" value="수정하기" id="register_button" class="button">
			</section>
		</form>
		
		<script>
			let id = document.querySelector(".id");
			let password = document.querySelector(".password");
			let name = document.querySelector(".name");
			let phone = document.querySelector(".phone");
			let email = document.querySelector(".email");
			let button = document.querySelector("#register_button");
			button.disabled = true;
				
			id.addEventListener('keyup', activeEvent);
			password.addEventListener('keyup', activeEvent);
			name.addEventListener('keyup', activeEvent);
			phone.addEventListener('keyup', activeEvent);
			email.addEventListener('keyup', activeEvent);
				
			function activeEvent() {
				if(id.value == '' || password.value == '' || name.value == '' || phone.value == '' || email.value == ''){
					button.disabled = true;
				}else
					button.disabled = false;
				}
				
		</script>
	</body>
</html>