<%@page import="javax.websocket.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	/*	String fuseId=(String)request.getAttribute("userid"); */
	
	//HttpSession session3 = request.getSession(true);
	//String sessionId = session3.getId();
	//String sessionId="user1";
	
%>

<%

	String user_id = (String)request.getAttribute("user_id");

	
%>

<%-- {

	"login_id":"<%=user_id%>",
	"requestScope":${requestScope.id}
	
}
 --%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <meta name="viewport" content="width=device-width, inital-scale=1"> -->
<link rel=stylesheet href="css/chat/bootstrap.css" >
<link rel=stylesheet href="css/chat/custom.css"> 
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="js/chat/bootstrap.js"></script>

<title>채팅 프로그램 페이지</title>

<script type="text/javascript">

var g_webSocket = null;

window.onload = function() {
	
g_webSocket = new WebSocket("ws://192.168.12.2:80/jenkim49test/startChat");
/**
 * 웹소켓 사용자 연결 성립하는 경우 호출
 */
g_webSocket.onopen = function(message) {
    addLineToChatBox("상담사님과 연결되었습니다..");
    
};
/**
 * 웹소켓 사용자 연결 해제하는 경우 호출
 */
g_webSocket.onclose = function(message) {
    addLineToChatBox("서버가 끊겼습니다.");
};


/**
 * 웹소켓 에러 발생하는 경우 호출
 */
g_webSocket.onerror = function(message) {
    addLineToChatBox("에러입니다 : 관리자에게 문의하세요");
};

/**
 * 웹소켓 메시지(From Server) 수신하는 경우 호출
 보내진 메세지와함께session을 같이 보내는방법이ㅓㅄㄴ다ㅏㅏ.,.,?
 */
g_webSocket.onmessage = function(message) {
	submitFunction(message.data);
	//$("#chatBlock").scrollTop = $("#chatBlock").scrollHeight;
};

}  
/* 
function winScroll() {
//	window.scrollTo(document.body.scrollWidth, document.body.scrollHeight);
	var chatAreaHeight = $("#chatBlock").height();
	var maxScroll = $("#chatArea").height() - chatAreaHeight;
	//$("html, body").scrollTop(maxScroll);
	//window.scrollTo(maxScroll);
	
	} */

/**
* 상태영역
*/
function addLineToChatBox(stateMSG) {
	var t = getTimeStamp();
	$("#ServerState").append(" <div class='row'><div class='col-lg-12'>  <p class='text-center text-muted small'>"+stateMSG+"<p class='text-center text-muted small'>"+t+"</p>"+"</p> </div> </div>");
	
}
function sendButton_onclick() {
    var message = $("#inputMsgBox").val();
    //submitFunction(message);
	var t = getTimeStamp();
    // 서버로 메시지 전송
    g_webSocket.send(message);
    inputMsgBox.value = "";
    inputMsgBox.focus();
    return true;
}

function getTimeStamp() {
	
	   var d = new Date();
	   var s =
	     leadingZeros(d.getFullYear(), 4) + '-' +
	     leadingZeros(d.getMonth() + 1, 2) + '-' +
	     leadingZeros(d.getDate(), 2) + ' ' +

	     leadingZeros(d.getHours(), 2) + ':' +
	     leadingZeros(d.getMinutes(), 2) + ':' +
	     leadingZeros(d.getSeconds(), 2);

	   return s;
	 }
	 
function leadingZeros(n, digits) {
	   var zero = '';
	   n = n.toString();

	   if (n.length < digits) {
	     for (i = 0; i < digits - n.length; i++)
	       zero += '0';
	   }
	   return zero + n;
	 }

	
	<%----------------------%>

	function submitFunction(msg) {
		var t = getTimeStamp();
		var string = msg;
		if (string == null) {
		        return false;
		}
		
		$("#chatBlock").scrollTop = $("#chatBlock").scrollHeight;
		$("#chatBlock").append("<hr>"+msg+"<div class='clearfix'></div>");
		 
	window.scrollTo(document.body.scrollWidth, document.body.scrollHeight);
			winScroll();
			//var chatAreaHeight = $("#chatBlock").height();
			//var maxScroll = $("#chatArea").height() - chatAreaHeight;
			//$("html, body").scrollTop(maxScroll);
	 }
	
	
function disconnectButton_onclick() {
	    if (g_webSocket != null) {
	        g_webSocket.close();    
	    }
	}	


</script>
</head>
<body>

<%-- <c:set var="profile" value='<%=session.getAttribute("login")%>' /> --%>

	<div class="container">
	<div class="container bootstrap snippet">
    <div class="row">
        <div class="col-xs-12">
            <div class="portlet portlet-default">
                <div class="portlet-heading">
                    <div class="portlet-title">
                        <h4><i class="fa fa-circle text-green"></i><%=user_id%>님 전용 실시간 채팅방</h4>
                    </div>
                    <div class="clearfix"></div>
                </div>
                
                    <div class="portlet-widgets">
                       <div class="btn-group">
                    
                       <!--         
                            <button type="button" class="btn btn-white dropdown-toggle btn-xs" data-toggle="dropdown">
                                <i class="fa fa-circle text-green"></i> 1:1 상담 주제
                                <span class="caret"></span>
                            </button>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="#"><i class="fa fa-circle text-green"></i> 맞춤향수문의</a>
                                </li>
                                <li><a href="#"><i class="fa fa-circle text-orange"></i> 배송문의</a>
                                </li>
                                <li><a href="#"><i class="fa fa-circle text-red"></i> 기타문의</a>
                                </li>
                            </ul> -->
                            
                            	<select id="search_date" name="search_date"   class="btn btn-white dropdown-toggle btn-xs">
									<option value="week">맞춤향수문의</option>
									<option value="month">배송문의</option>
									<option value="all">기타문의</option>
								</select>
								
                            
                        </div> 
                        <span class="divider"></span>
                        <a data-toggle="colladpse" data-parent="#accordion" href="#chat">
                        <i class="fa fa-chevron-down"></i></a>
                    </div>
                  
                    
                    <div class="clearfix"></div>
                </div>
                
                
                <div id="chat" class="panel-collapse collapse in">
                
                    <div>
                    <div class="portlet-body chat-widget" style="overflow-y: auto; width: auto; height: 300px;">
                        
                        <div id="ServerState"></div>
                        <div class="row"  >
                        
                            <div class="col-lg-12">
                                <div class="media" id="chatBlock">
                                    <a class="pull-left" href="#">
                                        <img class="media-object img-circle img-chat" 
                                        src="http://bootdey.com/img/Content/avatar/avatar1.png" alt="">
                                    </a>
                  
                                    <div class="media-body" id ="chatArea">
                                        <h4 class="media-heading" >[공지]1:1대화창이 열렸습니다
                                            <span class="small pull-right" >12:23 PM</span>
                                        </h4>
                                        <p> ********모든 채팅내역은 저장되며 외부에 공개되지 않습니다 ********</p>
                                        <p>왼쪽 상단의 문의 메뉴를 선택하고 채팅을 시작하여 주십시오..</p>
                                        
                                    </div>
                                </div>
                            </div>
                        </div>
            
                    </div> 
                    </div>
                    <div class="portlet-footer">
                        <form role="form">
                            <div class="form-group">
                                <textarea class="form-control" placeholder="메시지를 입력하세요.." id ="inputMsgBox" ></textarea>
                            </div>
                            <div class="form-group">
                                <button type="button" class="btn btn-default pull-right" onClick="sendButton_onclick()" id="sendButton">전송</button>
                                <button type="button" class="btn btn-default pull-right" onClick="disconnectButton_onclick()" id="disconnectButton">연결끊기</button>
                                <div class="clearfix"></div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        
    </div>
</div>                

	
	</div>

</body>
</html>