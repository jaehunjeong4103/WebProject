	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
  <link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin="crossorigin">
	<link href="https://fonts.googleapis.com/css2?family=Gowun+Dodum&family=Song+Myung&display=swap" rel="stylesheet">
	<link href="../../css/main_form.css?after" type="text/css" rel="stylesheet" />
	<link href="../../css/detail.css?after" type="text/css" rel="stylesheet" />
	<link href="../../css/review.css?after" type="text/css" rel="stylesheet" />
	<link href="../../css/reservation.css?after" type="text/css" rel="stylesheet" />
	<link href="../../css/calendar.css?after" type="text/css" rel="stylesheet" />
  
  <title>숙소 세부페이지</title>
</head>
 
<body>
  <header>
    <section id="head">
      <div id="head_title"><a href="../main">YC</a></div>
      <nav id="menu_bar">
        <ul>
          <li class="menu"><a href = "../tour/tour_list" id="tour">관광</a></li>
          <li class="menu"><a href = "../main" id="festival">축제</a></li>
          <li class="menu"><a href = "../main" id="experience">체험</a></li>
          <li class="menu"><a href = "stay_list" id="stay">숙박</a></li>
          <li class="menu"><a href = "../main" id="food">식당</a></li>
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
				<div>숙박</div>
				<div>숙박 > 숙박 > ${stay.name}</div>
			</section>      
		</div>
			
		<div id="detail_content">
			<div id="detail_title">${stay.name}</div>
			<div id="detail_img_map">
				<div id="detail_img" style="background-image: url('${stay.image_path}' ); background-size: cover; background-position: center;"></div>
				<div id="detail_map"> 
					<iframe src="${stay.map_path}" width="414" height="300" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade" overflow="hidden"></iframe>
				</div>
			</div>
		</div>

		<div id ="reservation">
		
		  	<div id="date_count">
		  		<div id="start_day">
		  			<span>입실일 : </span>
		  			<input type="text" name="s_day" id="s_d" class="choose_day" placeholder="입실일을 선택해주세요">	 
		  			<c:set var="cid"/>
		  		</div>
		  		
		  		<div id="end_day">
		  			<span>퇴실일 : </span>
		  			<input type="text" name="e_day" id="e_d" class="choose_day" placeholder="퇴실일을 선택해주세요">
		  			<c:set var="cod"/>
		  		</div>
		  		<!-- <div id="end_day">3박 4일</div> -->
		  		<!-- <input type="submit" style="width: 50px; height: 28px; font-size: 18px; line-height: 28px;" value="검색"> -->
		  	</div>

	  	
	  	<div id="calendar">	  		 
	  		<section class="calendar left">
					<table>
						<tr>
							<td>
								<a href="stay_detail?id=${stay_id}&c_year=${pre_year}&c_month=${pre_month}">◀</a>
							</td>
							<td colspan="6">${year}년<c:if test="${month <10}">0</c:if>${month}월</td>
						</tr>
						<tr>
							<td>일</td>
							<td>월</td>
							<td>화</td>
							<td>수</td>
							<td>목</td>
							<td>금</td>
							<td>토</td>
						</tr>
						<tr>
							<c:forEach var="list" items="${calendar_list}" varStatus="status">
								<c:choose>
									<c:when test="${status.index%7==6}">
										<td class="sat">
											<button class="cal_button" data-s_year="${year}" data-s_month="${month}" data-s_day="${list.day}">${list.day}</button>
										</td>
									</c:when>
									<c:when test="${status.index%7==0}">
						</tr>
						<tr>
										<td class="sun">
											<button class="cal_button" data-s_year="${year}" data-s_month="${month}" data-s_day="${list.day}">${list.day}</button>
										</td>
									</c:when>
									<c:otherwise>
										<td class="weekday">
											<button class="cal_button" data-s_year="${year}" data-s_month="${month}" data-s_day="${list.day}">${list.day}</button>
										</td>
									</c:otherwise>
								</c:choose>						
							</c:forEach>
						</tr>
					</table>
				</section>
				 
				<section class="calendar right">
					<table>
						<tr>
							<td colspan="6">${next_year}년<c:if test="${next_month <10}">0</c:if>${next_month}월</td>
							<td>
								<a href="stay_detail?id=${stay_id}&c_year=${next_year}&c_month=${next_month}">▶</a>
							</td>
						</tr>
						<tr>
							<td>일</td>
							<td>월</td>
							<td>화</td>
							<td>수</td>
							<td>목</td>
							<td>금</td>
							<td>토</td>
						</tr>
						<tr>
							<c:forEach var="list" items="${next_calendar_list}" varStatus="status">
								<c:choose>
									<c:when test="${status.index%7==6}">
										<td class="sat">
											<button class="cal_button" data-s_year="${next_year}" data-s_month="${next_month}" data-s_day="${list.day}">${list.day}</button>
										</td>
									</c:when>
									<c:when test="${status.index%7==0}">
						</tr>
						<tr>
										<td class="sun">
											<button class="cal_button" data-s_year="${next_year}" data-s_month="${next_month}" data-s_day="${list.day}">${list.day}</button>
										</td>
									</c:when>
									<c:otherwise>
										<td class="weekday">
											<button class="cal_button" data-s_year="${next_year}" data-s_month="${next_month}" data-s_day="${list.day}">${list.day}</button>
										</td>
									</c:otherwise>
								</c:choose>						
							</c:forEach>
						</tr>
					</table>
				</section>		 
	  	</div>
			
	  </div>
 
	  <div id="room_box">
	  	<div id="room_list_head">
				<div class="room_name">이름</div>
				<div class="room_max">최대인원</div>
				<div class="room_price">가격</div>
				<div class="room_facilities">편의시설</div>
				<div class="room_reservation">예약</div>
			</div>
			<c:forEach var="r" items="${room_list}">
				<div id="room_list">
					<div class="room_name">${r.name}</div>
					<div class="room_max">${r.max_person}인실</div>
					<div class="room_price">
						<p>주말 <fmt:formatNumber value="${r.weekend_price}" pattern="#,###"/>
						<p>평일 <fmt:formatNumber value="${r.weekday_price}" pattern="#,###"/>
					</div>
					<div class="room_facilities">${r.option}</div>
					<div class="room_reservation">
						<c:choose>
			        <c:when test="${empty logIn}">
				        <a href="/view/member/logIn" value="reservation" class="reserbation">예약하기</a>	          
							</c:when>
			        <c:otherwise>
			        	<form action="/view/reservation/reservation" method="get">
			        		<input type="hidden" class="weekend_count" name="weekend_count" value="">
			        		<input type="hidden" class="weekday_count" name="weekday_count" value=""> 
			        		<input type="hidden" name="stay_name" value="${stay.name}">
			        		<input type="hidden" name="room_name" value="${r.name}">
			        		<input type="hidden" class="check_in" name="check_in" value="" >
			        		<input type="hidden" class="check_out" name="check_out" value="">
			        		<input type="submit" value="예약하기" id="res_button">
			        	</form>
			        	 
			        </c:otherwise>
		      	</c:choose>
					</div>
				</div>
			</c:forEach>
	  </div>
<script src="../../js/calendar.js"></script>
		<div class="write_button1">
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
						${r.member_id}
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