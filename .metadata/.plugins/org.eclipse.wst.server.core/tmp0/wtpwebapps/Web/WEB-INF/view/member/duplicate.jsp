<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<div id="title">아이디 중복체크</div>
		</header>
		<form action="duplicate" method="post">
		 	<input type="text" placeholder="아이디를 입력해주세요" class="input_text id" name="ID">
		 	<input type="submit" value="중복체크" id="duplicate_button" class="button">
		 </form>
		 
		 <script>
			let id = document.querySelector(".id");
			let button = document.querySelector("#duplicate_button");
			button.disabled = true;
				
			id.addEventListener('keyup', activeEvent);
				
			function activeEvent() {
				if(id.value == ''){
					button.disabled = true;
				}else
					button.disabled = false;
				}
				
		</script>
	</body>
</html>