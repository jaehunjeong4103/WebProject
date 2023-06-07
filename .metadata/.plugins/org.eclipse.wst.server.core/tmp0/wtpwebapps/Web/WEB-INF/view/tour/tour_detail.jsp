<%@page import="javax.swing.text.Document"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>

<head>
  <link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin="crossorigin">
	<link href="https://fonts.googleapis.com/css2?family=Gowun+Dodum&family=Song+Myung&display=swap" rel="stylesheet">
	<link href="../../css/main_form.css?after" type="text/css" rel="stylesheet" />
	<link href="../../css/detail.css?after" type="text/css" rel="stylesheet" />
	<link href="../../css/review.css?after" type="text/css" rel="stylesheet" />
	<link href="../../css/reservation.css?after" type="text/css" rel="stylesheet" />
	<link href="../../css/calendar.css?after" type="text/css" rel="stylesheet" />
  <title>관광 세부페이지</title>
</head>
<body>
  <header>
    <section id="head">
      <div id="head_title"><a href="../main">YC</a></div>
      <nav id="menu_bar">
        <ul>
          <li class="menu"><a href = "tour_list" id="tour">관광</a></li>
          <li class="menu"><a href = "../main" id="festival">축제</a></li>
          <li class="menu"><a href = "../main" id="experience">체험</a></li>
          <li class="menu"><a href = "../stay/stay_list" id="stay">숙박</a></li>
          <li class="menu"><a href = "main" id="food">식당</a></li>
        </ul>
      </nav>
      <div id="member">
        
	     <c:choose>
	        <c:when test="${logIn_id=='admin'}">
	          <a href="../admin_insert" class="member" id="reg">입력</a>
						<a href="../member/logOut" class="member">로그아웃</a>
					</c:when>
	        <c:when test="${empty logIn}">
	          <a href="../member/register" class="member" id="reg">회원가입</a>
						<a href="../member/logIn" class="member">로그인</a>
					</c:when>
	        <c:otherwise>
	          <a href="../member/update" class="member" id="reg">회원수정</a>
	          <a href="../member/logOut" class="member">로그아웃</a>
	        </c:otherwise>
	      </c:choose>
        
      </div>
    </section>
  </header>
  
  <div id="detail_body">
      <div id="detail_head">
        <section id="bodyLeft">
          <div>관광지</div>
          <div>관광 > 관광지 > ${t.name}</div>
          
        </section>
        <section id="bodyRight">

        </section>
      </div>
			
      <div id="detail_content">
        <div id="detail_title">${t.name}</div>
        <div id="detail_img_map">
	        <div id="detail_img" style="background-image: url('${t.image_path}' ); background-size: cover; background-position: center;"></div>
	        <div id="detail_map"> 
	        	<iframe src="${t.map_path}" width="414" height="300" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade" overflow="hidden"></iframe>
					</div>
				</div>
        <div id="detail_text">
        	<p>주소 : ${t.address}</p><br>
	        <p>전화번호 : ${t.phone}</p><br>
	        <p>운영시간</p>
	        <p>${t.op_cl}</p><br>
	        <p>내용</p>
	        <p>${t.content}</p>
	      </div>
	      
	      <div class="write_button">
	      	
	      	<c:choose>
		        <c:when test="${empty logIn}">
			        <a href="/view/member/logIn" value="리뷰 작성하기" class="review">리뷰 작성하기</a>	          
						</c:when>
		        <c:otherwise>
		        	<a href="/view/review/review" value="리뷰 작성하기" class="review">리뷰 작성하기</a>
		        </c:otherwise>
	      	</c:choose>
	      
	      </div>   
        <div id="review_box">
					<c:forEach var="r" items="${review_list}">
						<div id="review">
							<div id="review_member_id">
								${r.member_id}<br>
								<div id="review_star">
									<c:forEach begin="1" end="${r.star}">
										<div class="star yellow">★</div>
									</c:forEach>
									<c:forEach begin="1" end="${5 - r.star}">
										<div class="star silver">★</div>
									</c:forEach>	
								</div>	
							</div>		
							<div id="review_content" style="white-space:pre-line;">${r.content}</div>
							<div id="review_regdate"><fmt:formatDate value="${r.date_d}" pattern="yy.MM.dd"/> <fmt:formatDate value="${r.date_t}" pattern="HH:mm"/></div>
						</div>
					</c:forEach> 
       </div>

      </div>

  </div>
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