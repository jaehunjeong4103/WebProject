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
			<div id="title">회원가입</div>
		</header>
		<form action="register" method="post">
			<section>
				<input type="text" placeholder="아이디를 입력해주세요" class="input_text id" name="ID" value="${chkId}">
    			<a href="duplicate" id="id_check"> 아이디 중복체크</a>
			  </input>
				<input type="text" placeholder="비밀번호를 입력해주세요" class="input_text password" name="PASSWORD">
			  <input type="text" placeholder="이름을 입력해주세요" class="input_text name" name="NAME">
				<input type="text" placeholder="전화번호를 입력해주세요" class="input_text phone" name="PHONE">
				<input type="text" placeholder="이메일을 입력해주세요" class="input_text email" name="EMAIL">
			  	<input style="scale:2" type="radio" name="GENDER" id="male" value="male" checked="checked">
			    	<label for="male">남자</label>
			    <input style="scale:2" type="radio" name="GENDER" id="female" value="female">
			    	<label for="female">여자</label>
		    	<input type="submit" value="회원가입" id="register_button" class="button">
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