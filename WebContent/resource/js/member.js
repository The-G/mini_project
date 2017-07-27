function logincheck(){
	if(document.frm.userid.value.length==0){
		alert("아이디를 써주세요");
		frm.userid.focus();
		return false;
	}
	if(doucument.frm.pwd.value==""){
		alert("비밀번호는 반드시 입력해야 합니다.");
		return false;
	}
	return true;
}

function idCheck(){
	if(document.frm.userid.value == ""){
		alert('아이디를 입력하여 주십시오.');
		document.frm.userid.focus();
		return;
	}
	var url = "idCheck.do?userid=" + document.frm.userid.value;
	window.open(url,"_blank_1","toolbar=no, menubar=no, scrollbars=yes, resizeable=no,width=450, height=200");
     
}

function idok(){
	opener.frm.userid.value=document.frm.userid.value;
	opener.frm.reid.value=document.frm.userid.value;
	self.close();
}

function joinCheck(){
	if(document.frm.name.value.length==0){
		alert("이름을 써주세요");
		frm.name.focus();
		return false;
	}
	if(document.frm.userid.value.length==0){
		alert("아이디를 써주세요");
		frm.userid.focus();
		return false;
	}
	if(document.frm.userid.value.length<4){
		aler("아이디는 4글자 이상이어야 합니다.");
		frm.userid.focus();
		return false;
	}
	if(document.frm.pwd.value===""){
		alert("비밀번호는 반드시 입력해야 합니다.");
		frm.pwd.focus();
		return false;
	}
	if(document.frm.pwd.value!==document.frm.pwd_check.value){
		alert("비밀번호는 일치하지 않습니다.");
		frm.pwd.focus();
		return false;
	}
	if(document.frm.reid.value.length==0){
		alert("중복체크를 하지 않았습니다.");
		frm.userid.focus();
		return false;
	}
	return true;
}


window.onload = function() {
	 
    if (getCookie("userid")) { // getCookie함수로 id라는 이름의 쿠키를 불러와서 있을경우
        document.frm.userid.value = getCookie("userid"); //input 이름이 id인곳에 getCookie("id")값을 넣어줌
        document.frm.idsave.checked = true; // 체크는 체크됨으로
    }

}

function setCookie(name, value, expiredays) //쿠키 저장함수
{
    var todayDate = new Date();
    todayDate.setDate(todayDate.getDate() + expiredays);
    document.cookie = name + "=" + escape(value) + "; path=/; expires="
            + todayDate.toGMTString() + ";"
}

function getCookie(Name) { // 쿠키 불러오는 함수
    var search = Name + "=";
    if (document.cookie.length > 0) { // if there are any cookies
        offset = document.cookie.indexOf(search);
        if (offset != -1) { // if cookie exists
            offset += search.length; // set index of beginning of value
            end = document.cookie.indexOf(";", offset); // set index of end of cookie value
            if (end == -1)
                end = document.cookie.length;
            return unescape(document.cookie.substring(offset, end));
        }
    }
}

function sendit() {
	  if (document.frm.idsave.checked == true) { // 아이디 저장을 체크 하였을때
          setCookie("userid", document.frm.userid.value, 7); //쿠키이름을 id로 아이디입력필드값을 7일동안 저장
      } else { // 아이디 저장을 체크 하지 않았을때
          setCookie("userid", document.frm.userid.value, 0); //날짜를 0으로 저장하여 쿠키삭제
      }

}
















	

	



