<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   

<!DOCTYPE html>

<head>
  <link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin="crossorigin">
	<link href="https://fonts.googleapis.com/css2?family=Gowun+Dodum&family=Song+Myung&display=swap" rel="stylesheet">
	<link href="../css/main_form.css?after" type="text/css" rel="stylesheet" />
  <title>메인페이지</title>
</head>
<body>
  <header>
    <section id="head">
      <div id="head_title"><a href="main">YC</a></div>
      <nav id="menu_bar">
        <ul>
          <li class="menu"><a href = "tour/tour_list" id="tour">관광</a></li>
          <li class="menu"><a href = "main" id="festival">축제</a></li>
          <li class="menu"><a href = "main" id="experience">체험</a></li>
          <li class="menu"><a href = "stay/stay_list" id="stay">숙박</a></li>
          <li class="menu"><a href = "main" id="food">식당</a></li>
        </ul>
      </nav>
      <div id="member">
        
	      <c:choose>
	        <c:when test="${logIn_id=='admin'}">
	          <a href="admin_insert" class="member" id="reg">입력</a>
						<a href="member/logOut" class="member">로그아웃</a>
					</c:when>
	        <c:when test="${empty logIn}">
	          <a href="member/register" class="member" id="reg">회원가입</a>
						<a href="member/logIn" class="member">로그인</a>
					</c:when>
	        <c:otherwise>
	          <a href="member/update" class="member" id="reg">회원수정</a>
	          <a href="member/logOut" class="member">로그아웃</a>
	        </c:otherwise>
	      </c:choose>
        
      </div>
    </section>
  </header>
  <section id="main_body">
    <div id="main_page_body">
    </div>
  </section>
  <footer>
    <div id="contact">
			<h2><strong>Contact</strong></h2>
			<p> - Name : JEONG JAE HUN <br>
			<p> - E-mail : jeong@naver.com(fake) <br>
			<p> - Home : 대구광역시 동구 신암동 한국디지털직업전문학교 <br>
			<p> - Mobile : 010-0000-0000 <br>
		</div>
  </footer>
</body>
</html>