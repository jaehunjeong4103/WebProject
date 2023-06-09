<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>   
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>

<head>
  <link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin="crossorigin">
	<link href="https://fonts.googleapis.com/css2?family=Gowun+Dodum&family=Song+Myung&display=swap" rel="stylesheet">
	<link href="../../css/main_form.css?after" type="text/css" rel="stylesheet" />
  <link href="../../css/list.css?after" type="text/css" rel="stylesheet" />  
  <link rel="shortcut icon" href="#">
  <title>숙박 메인페이지</title>
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
  
	<div id="tour_body">
		<div id="list_head">     
			<section id="bodyLeft">
				<div>숙박</div>
				<div>숙박 > 숙박</div>
			</section>       
			<form>
				<section id="bodyRight">
					<select name="f" class="search">
						<option ${(param.f == "name")?"selected":""} value="name">이름</option>
						<option ${(param.f == "address")?"selected":""} value="address">주소</option>
					</select>
						<input type="text" class="text" name="q" value="${param.q}">
						<input type="submit" class="button" style="width: 50px; height: 28px; font-size: 18px; line-height: 28px;" value="검색">
				</section>
			</form>       
		</div>
		
		<div id="list_item">
			<c:forEach var="s" items="${stay_list}">
				<a href="stay_detail?id=${s.id}&n=${s.name}">
					<div class="list">
						<div id="img" style="background-image: url('${s.image_path}' ); background-size: cover; background-position: center;"></div>
						<div id="text">
							<p>이름 : ${s.name}</p>
							<p>주소 : ${s.address}</p>
						</div>
					</div>
				</a>
			</c:forEach>
		</div>
		
		<c:set var="page" value="${(param.p == null) ? 1: param.p}" />
		<c:set var="startNum" value="${page-(page-1)%5}"/>
		<c:set var="lastNum" value="${fn:substringBefore(Math.ceil(count/5), '.') }"/>
			
		<div class="page"><span>${(empty param.p)?1:param.p }</span> / ${lastNum} pages</div>
			
    <div id="pager">
      <div>
        <c:if test = "${startNum > 1}">
					<a href="?p=${startNum - 1}&f=&q=" class="btn btn-prev"></a>
				</c:if>
				<c:if test = "${startNum <= 1}">
					<span class="btn btn-prev" onclick="alert('이전 페이지가 없습니다.');"></span>
				</c:if>
      </div>
      <ul class="-list-">
	    	<c:forEach var="i" begin="0" end="4">
		    	<c:if test="${(startNum+i) <= lastNum }">
		      	<li><a class="${(page==(startNum+i))?'black':'gray'} " href="?p=${startNum+i}&f=${param.f }&q=${param.q}" >${startNum+i}</a></li>
		  		</c:if>		
	    	</c:forEach>
     	</ul>
      <div>
        <c:if test="${startNum + 4 < lastNum}">
					<a href="?p=${startNum + 5}&f=&q=" class="btn btn-next"></a>
				</c:if>
				<c:if test="${startNum+4 >= lastNum}">
					<span class="btn btn-next" onclick="alert('다음 페이지가 없습니다.');"></span>
				</c:if>			
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