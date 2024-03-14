<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="${pageContext.request.contextPath}/assets/css/mysite.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/assets/css/guestbook.css" rel="stylesheet" type="text/css">

<!-- Axios 라이브러리 포함 -->
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>

<style>

	.modal{
		display : none;
	}
	.modal .modal-content{
		width: 818px;
		border: 1px solid #000000;
		
	}

</style>

</head>

<body>
	<!-- header -->
	<jsp:include page="/WEB-INF/views/includes/header.jsp"></jsp:include>
	<!-- /header -->

	<div id="container" class="clearfix">
		<div id="aside">
			<h2>방명록</h2>
			<ul>
				<li>일반방명록</li>
				<li>ajax방명록</li>
			</ul>
		</div>
		<!-- //aside -->

		<div id="content">

			<div id="content-head" class="clearfix">
				<h3>ajax방명록</h3>
				<div id="location">
					<ul>
						<li>홈</li>
						<li>방명록</li>
						<li class="last">일반방명록</li>
					</ul>
				</div>
			</div>
			<!-- //content-head -->

			<div id="guestbook">
				<form id="guestForm" action="${pageContext.request.contextPath}/guest/addlist" method="get">
					<table id="guestAdd">
						<colgroup>
							<col style="width: 70px;">
							<col>
							<col style="width: 70px;">
							<col>
						</colgroup>
						<tbody>
							<tr>
								<th><label class="form-text" for="input-uname">이름</label></th>
								<td><input id="input-uname" type="text" name="name"></td>
								<th><label class="form-text" for="input-pass">패스워드</label></th>
								<td><input id="input-pass" type="password" name="password"></td>
							</tr>
							<tr>
								<td colspan="4"><textarea id="input-content" name="content" cols="72" rows="5"></textarea></td>
							</tr>
							<tr class="button-area">
								<td colspan="4" class="text-center"><button id="btnAdd" type="submit">등록</button></td>
							</tr>
						</tbody>

					</table>
					<!-- //guestWrite -->
					<input type="hidden" name="action" value="add">

				</form>
				
				<!-- 모달 창 컨텐츠 -->
               <div id="myModal" class="modal">
                  <div id="guestbook" class="modal-content">
                     <div class="closeBtn">×</div>
                     <div class="m-header">
                        패스워드를 입력하세요
                     </div>
                     <div class="m-body">
                        <input id="modalpw" type="password" name="" value=""><br>
                        <input id="modalno" type="text" name="no" value="">
                     </div>
                     <div class="m-footer">
                        <button class="btnDelete" type="submit">삭제</button>
                     </div>
                  </div>
               </div>
				
				<div id="guestbookListArea">
				<!--  
				<c:forEach items="${requestScope.guestList}" var="guestVo">
					<table class="guestRead">
						<colgroup>
							<col style="width: 10%;">
							<col style="width: 40%;">
							<col style="width: 40%;">
							<col style="width: 10%;">
						</colgroup>
						<tr>
							<td>${guestVo.no}</td>
							<td>${guestVo.name}</td>
							<td>${guestVo.date}</td>
							<td><a href="${pageContext.request.contextPath}/guest/deleteform?no=${guestVo.no}">[삭제]</a></td>
						</tr>
						<tr>
							<td colspan=4 class="text-left">${guestVo.content}</td>
						</tr>
					</table>
				</c:forEach>
				-->
				</div>
			</div>
			<!-- //guestbook -->

		</div>
		<!-- //content  -->
	</div>
	<!-- //container  -->

	<!-- footer.jsp를 불러오기 -->
	<jsp:include page="/WEB-INF/views/includes/footer.jsp"></jsp:include>
	<!-- //wrap -->

</body>

<script>
//DOM tree가 생성되었을 때
document.addEventListener("DOMContentLoaded", function(){
	let guestList=[];
	//리스트 요청 데이터만 받기
	axios({
		method: 'get', // put, post, delete
		url: '/mysite6/api/guestbooks',
		headers: {"Content-Type" : "application/json; charset=utf-8"}, //전송타입
		//params: guestVo, //get방식 파라미터로 값이 전달
		//data: guestVo, //put, post, delete 방식 자동으로 JSON으로 변환 전달
		
		responseType: 'json' //수신타입
	})
	.then(function (response) {
		console.log(response.data); //수신데이타
		
		for(let i=0; i<response.data.length; i++){
			let guestVo = response.data[i];
			render(guestVo, "up");
		}
	})
	.catch(function (error) {
		console.log(error);
	});
	
	//등록버튼 클릭했을 때
	let guestForm = document.querySelector("#guestForm");
	console.log("guestForm");
	
	guestForm.addEventListener("submit", function(event){
		console.log("글쓰기클릭");
		event.preventDefault();
		
		let guestName = document.querySelector("#input-uname");
		let guestPw = document.querySelector("#input-pass")
		let guestContent = document.querySelector("#input-content");
	
		let name = guestName.value
		let password = guestPw.value
		let content = guestContent.value

		let guestVo ={
			name: name,
			password : password,
			content : content
		};
		guestList.push(guestVo);
		console.log(guestList);
		
		axios({
			method: 'post', // put, post, delete
			url: '/mysite6/api/guestbooks',
			headers: {"Content-Type" : "application/json; charset=utf-8"}, //전송타입
			params: guestVo, //get방식 파라미터로 값이 전달
			//data: guestVo, //put, post, delete 방식 자동으로 JSON으로 변환 전달
			
			responseType: 'json' //수신타입
		})
		.then(function (response) {
			console.log(response.data); //수신데이타
			let guestVo = response.data;
			
			render(guestVo, "down");
			
		})
		.catch(function (error) {
			console.log(error);
		});
		

		
		
	});//guestForm.addEventListener
	//모달창 호출 버튼을 클릭했을때
	let guestbookListArea = document.querySelector("#guestbookListArea");
	
	guestbookListArea.addEventListener("click", function(){
		
		if(event.target.tagName == "BUTTON"){
			console.log("모달창보이기");
			
			let modal = document.querySelector(".modal");
			modal.style.display = "block";
			
			//hidden의 value -> no값 입력
			let noTag = document.querySelector('[name="no"]');
			noTag.value = event.target.dataset.no;
			console.log(event.target.dataset.no);
			
		}
	});
	//모달창에 삭제 버튼을 클릭했을때 (진짜 삭제)	
	let btnDelete = document.querySelector(".btnDelete");
	console.log(btnDelete);
	
	btnDelete.addEventListener("click", function(){
		console.log("클릭");
		
		//데이터 모으기
		let modalpw = document.querySelector("#modalpw");
		let modalno = document.querySelector("#modalno");
		
		let modalVo = {};
		
		guestVo ={
			password: modalpw.value,
			no: modalno.value
		};
		console.log(guestVo);
		
		axios({
			method: 'post', // put, post, delete
			url: '/mysite6/api/guestbooks/delete',
			headers: {"Content-Type" : "application/json; charset=utf-8"}, //전송타입
			params: guestVo, //get방식 파라미터로 값이 전달
			//data: guestVo, //put, post, delete 방식 자동으로 JSON으로 변환 전달
			
			responseType: 'json' //수신타입
		})
		.then(function (response) {
			console.log(response.data); //수신데이타
			let guestVo = response.data;
			
		})
		.catch(function (error) {
			console.log(error);
		});
	})
	
});




function render(guestVo, dir){
	console.log("render()");
	console.log(guestVo);
	
	let guestbookListArea = document.querySelector("#guestbookListArea");
	console.log(guestbookListArea);
		
		
	
	let str = '';
	str += '<table class="guestRead">';
	str += '	<colgroup>';
	str += '		<col style="width: 10%;">';
	str += '		<col style="width: 40%;">';
	str += '		<col style="width: 40%;">';
	str += '		<col style="width: 10%;">';
	str += '	</colgroup>';
	str += '<tr>';
	str += '	<td>'+guestVo.no+'</td>';
	str += '	<td>'+guestVo.name+'</td>';
	str += '	<td>'+guestVo.date+'</td>';
	str += '	<td><button class="btnModal" type="button" data-no= "'+ guestVo.no +'">[삭제]</button></td>';
	str += '</tr>';
	str += '<tr>';
	str += '<td colspan=4 class="text-left">'+guestVo.content+'</td>';
	str += '</tr>';
	str += '</table>';
	
	if(dir=="down"){
		guestbookListArea.insertAdjacentHTML("beforeend",str);
	}else if(dir == "up"){
		guestbookListArea.insertAdjacentHTML("afterbegin",str);
	}
	
	
}
</script>



</html>