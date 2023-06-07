<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="preconnect" href="https://fonts.googleapis.com">
		<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin="crossorigin">
		<link href="https://fonts.googleapis.com/css2?family=Gowun+Dodum&family=Song+Myung&display=swap" rel="stylesheet">
		<link href="../../css/register.css?after" type="text/css" rel="stylesheet" />
		<link href="../../css/login.css?after" type="text/css" rel="stylesheet" />
		<meta charset="UTF-8">
		<title>LogIn</title>
	</head>
	<body>
		<header>
		    <div id="arrow_body">
	 				<button onclick="history.back()"><image src="../../images/direction-arrow.png" alt="화살표" id="arrow"/></button>
		    </div>
		    <div id="title">로그인</div>
		</header>
		<form action="logIn" method="post">
			<section>
			    <input type="text" placeholder="아이디를 입력해주세요" class="input_text id" name="ID" value="${findId}">
			    <input type="password" placeholder="비밀번호를 입력해주세요" class="input_text password" name="PASSWORD">			    
			
			    <input type="submit" value="로그인" id="login_button" class="button">
			   
			
			<script>
				let id = document.querySelector(".id");
				let password = document.querySelector(".password");
				let button = document.querySelector("#login_button");
				button.disabled = true;
				
				id.addEventListener('keyup', activeEvent);
				password.addEventListener('keyup', activeEvent);
				
				function activeEvent() {
					 if(id.value == '' || password.value == ''){
					    button.disabled = true;
					 }else
						 button.disabled = false;
				}
				
			</script>
			
			</section>
		</form>
	</body>
</html>
