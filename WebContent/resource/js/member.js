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


function confirmSave(checkbox){
	  var isRemember;
	  // 로그인 정보 저장한다고 선택할 경우
	  if(checkbox.checked)  {
	    isRemember = confirm("이 PC에 로그인 정보를 저장하시겠습니까? \n\nPC방등의 공공장소에서는 개인정보가 유출될 수 있으니 주의해주십시오.");
	    if(!isRemember)
	      checkbox.checked = false;
	  }
	}


	



