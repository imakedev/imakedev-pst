<%@ page contentType="text/html; charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="org.springframework.security.web.servletapi.*" %>
<sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_MANAGE_MISSCONSULT')" var="isManageMC"/>
<sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_MANAGE_COMPANY')" var="isManageCompany"/>
<sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_MANAGE_CANDIDATE')" var="isManageCandidate"/>
<sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_MANAGE_SEARCH_REPORT')" var="isManageSearchReport"/>
<sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_MANAGE_SERIES')" var="isManageSeries"/>
<sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_MANAGE_TEST')" var="isManageTest"/>
<sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_MANAGE_DOWNLOAD')" var="isManageDownload"/>
<sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_MANAGE_MISSCONSULT_REPORT_MANAGEMENT')" var="isManageReportManagement"/> 
<sec:authentication var="myUser" property="principal.myUser"/> 
<html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6 lt8"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7 lt8"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8 lt8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"> <!--<![endif]-->
<head>
<title>PST BackOffice</title>
 <meta charset="UTF-8" />
        <!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
<meta http-equiv="X-UA-Compatible" content="IE=7, IE=9"/>        
<c:url var="url" value="/" />
<c:url value="/logout" var="logoutUrl"/>
<link rel="icon" href="<c:url value='/resources/images/favicon.ico'/>" type="image/x-icon" />
<link rel="shortcut icon" href="<c:url value='/resources/images/favicon.ico'/>" type="image/x-icon" />   <script  src="<c:url value='/resources/js/jquery-1.8.3.min.js'/>" type="text/javascript"></script>
<script type="text/javascript" src="<c:url value='/resources/js/smoothness/jquery-ui-1.9.1.custom.min.js'/>"></script>
 <script type="text/javascript" src="<c:url value='/resources/ckeditor/ckeditor.js'/>"></script>
<script src="<c:url value='/resources/bootstrap/js/bootstrap.min.js'/>" type="text/javascript"></script>
<link href="<c:url value='/resources/css/smoothness/jquery-ui-1.9.1.custom.css'/>" type="text/css"  rel="stylesheet" /> 
<link href="<c:url value='/resources/bootstrap/css/bootstrap.min.css'/>" rel="stylesheet"  type="text/css"/> 

  <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/demo.css'/>" />
        <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/style3.css'/>" />
		<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/animate-custom.css'/>" />

 
 <style type="text/css">
 /*  fieldset { width: 100%; }
  fieldset legend { width: 100%; }
  fieldset legend div { margin: 0.3em 0.5em; }
  fieldset .field { margin: 0.5em; padding: 0.5em; }
  fieldset .field label { margin-right: 0.4em; } */
</style>
<style>
.ui-widget { font-family: Trebuchet MS, Tahoma, Verdana,
 Arial, sans-serif; font-size: 12px; }
 </style>
<style type="text/css">
/*.th_class{font-family: Tahoma;font-size: 13px;text-align: center;*/
.th_class{text-align: center;
}
a{cursor: pointer;}
</style>
<style type="text/css"> 
/* th{ font-family:Tahoma; font-size:12px; font-weight:bold;
 color: #fff;background:url(/MISSExamBackOffice/resources/images/tr_back-theme1.gif) repeat-x scroll 0 0 #80838A;padding: 5px 8px;border:1px solid #fff; 
}  */
</style> 
<c:set var="aoeTest">
  <spring:message code='navigation_home'/>
</c:set>
<script type="text/javascript">
var _path="";
var mail_toG;
var mail_subjectG;
var mail_messageG;
var mail_attachG; 
var intRegex = /^\d+$/;
//var floatRegex = /^((\d+(\.\d *)?)|((\d*\.)?\d+))$/;
var floatRegex = /^((\d+(\.\d *)?)|((\d*\.)?\d+)|(-\d+(\.\d *)?)|((-\d*\.)?\d+))$/;

$(document).ready(function() {
	$('#tabs').tabs();
	$('#tabs > ul > li > a').css("width","70px"); 
		 
	//loadDynamicPage("employee/init");
	togle_page('employeeWorkMapping/init','employee_link');
});
function loadDynamicPage(pageId){
	//alert(pageId)

	//	var id="1";
		//$.get('ajax/search', function(data) {
	 /* 	$.get(pageId, function(data) {
			  // alert(data);
			  if(data!=null){
				  appendContent(data);
			  }
			}); */
			
			$.ajax({
				  type: "get",
				  url: pageId,
				  cache: false
				 // data: { name: "John", location: "Boston" }
				}).done(function( data ) {
					if(data!=null){
						  appendContent(data);
					  }
				});
}
function togle_page(pageId,id_active){ 
	//    $("#"+id_before).removeClass("active"); 
     
	$("ul[class=nav] > li").removeClass("active");
	/* $("ul[class=nav] > li").each(function(){
	        $(this).keypress(function(event) {
	  	 	  if ( event.which == 13 ) {
	 	 	     event.preventDefault();
	 	 	    	doAction('search','0');
	 	 	   }
	 	 });
	 }); */
	    $("#"+id_active).addClass("active");
		loadDynamicPage(pageId);
}
function appendContentWithId(data,contentId){
	if(data.indexOf("j_username")!=-1 || data.indexOf("loginform")!=-1){
		//alert("to home") 
		  /* window.location.href="<c:url value='/j_spring_security_logout'/>"; */
		  window.location.href="<c:url value='/logout'/>";
		 //$("#_content").html(data);
	  }else{
		/*   var _url_template=window.location.href;
		  if(_url_template.indexOf("template")!=-1){ 
			  window.location.href="<c:url value='/'/>";
		  }else{ */
			  $("#"+contentId).html(data);
		 // }
	  }
	
}
function appendContent(data){
	//alert(data)
	appendContentWithId(data,"_content");
	
}
function doSendMailToApprove(mail_todo_idG,mail_todo_refG){
	loadDynamicPage("getmailToApprove/"+mail_todo_idG+"/"+mail_todo_refG);
	/* //alert(action)
	var checked="1";
	// alert(document.getElementById("mail_attach").checked);
	if(!document.getElementById("mail_attach").checked)
		checked="0";
	   var data_to_server= { 
			  mail_todo_id:mail_todo_idG,
			  mail_todo_ref:mail_todo_refG,
			  mail_to: mail_toG.val(),
			  mail_subject: mail_subjectG.val(),
			  mail_message:mail_messageG.val(),
			  mail_attach:checked
				};
	$.post("sendmailToApprove",data_to_server, function(data) {
		  //alert(data);
		    appendContent(data);
		  // alert($("#_content").html());
		}); */
  }
function openMailDialog(todo_id,todo_ref){
	$("#mail_todo_id").val(todo_id);
	$("#mail_todo_ref").val(todo_ref);
	$( "#dialog-modal" ).dialog({
		/* height: 140, */
		modal: true,
		buttons: {
			"Ok": function() { 
				$( this ).dialog( "close" );  
				doSendMailToApprove(todo_id,todo_ref); 
				 
			},
			"Close": function() { 
				$( this ).dialog( "close" );				 
			}
		}
	});
}
</script>
</head> 
<body>
   <div class="container">
            <!-- Codrops top bar 252525 -->
            <%--
            <div class="codrops-top" style="background-image: url(http://localhost:8080/pst/resources/css/smoothness/images/ui-bg_highlight-soft_75_cccccc_1x100.png)">
            	<span style="float:left;padding:5px 230px">
             		<img src="<c:url value='/resources/images/logo.jpg'/>" />
             	</span>
                  <!-- <br/><br/> -->
              <!-- 
                <a href="">
                    <strong>&laquo; Previous Demo: </strong>Responsive Content Navigator
                </a>
             -->
                <span class="right">
             <!-- 
                    <a href=" http://tympanus.net/codrops/2012/03/27/login-and-registration-form-with-html5-and-css3/">
                        <strong>Back to the Codrops Article</strong>
                    </a>
                 -->
                </span>
               <div class="clr"></div>
               
            </div>
             --%><!--/ Codrops top bar --> 
            <!--   position: fixed;
  right: 0;
  left: 0;
  z-index: 1030;
  margin-bottom: 0; -->
      <!-- <div class="row-fluid"  style="position:fixed;z-index: 1030;background-image: url(http://localhost:8080/pst/resources/css/smoothness/images/ui-bg_highlight-soft_75_cccccc_1x100.png)"> -->
      <div class="row-fluid"  style="position:fixed;z-index: 1030;background-image: url(<c:url value='/resources/css/smoothness/images/ui-bg_highlight-soft_75_cccccc_1x100.png'/>)">
     
     	<div class="span11 offset1">
     	<span style="float:left;"> 
            <table border="0" width="100%">
            <tr><td>
            <img src="<c:url value='/resources/images/logo.jpg'/>" />  
            </td>
            <td><span style="padding: 10px"></span> 
            </td>
            <td>
             <div class="navbar" style="float:right;position: relative;top: 8px">
              <div class="navbar-inner">
                <div class="container">
                 <!--  <a class="btn btn-navbar" data-toggle="collapse" data-target=".navbar-responsive-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                  </a> --> 
                 <!--  <a class="brand" href="#">Title</a> -->
                  <div class="nav-collapse collapse navbar-responsive-collapse">
                    <ul class="nav"> 
                      <li id="employee_link"><a onclick="togle_page('employeeWorkMapping/init','employee_link')">Employee</a></li>
                      <li  id="job_link"><a onclick="togle_page('job/init','job_link')">Job</a></li>
                      <li id="breakdown_link"><a onclick="togle_page('breakdown/init','breakdown_link')">Break down</a></li>
                      <li id="costs_link"><a onclick="togle_page('costs/init','costs_link')">Costs</a></li>
                    <!--   <li id="roadpump_link"><a onclick="togle_page('roadpump/init','roadpump_link')">Road pump</a></li> -->
                       <li class="dropdown" id="roadpump_link"> 
                      	<a href="#" class="dropdown-toggle" data-toggle="dropdown">Road pump<b class="caret"></b></a>
                      	<ul class="dropdown-menu">
                          <li><a href="javascript:void(0);"  onclick="togle_page('roadpump/init','roadpump_link')" style="text-align: left;">จัดการ Road pump</a></li>
                          <li><a href="javascript:void(0);" onclick="togle_page('model/init','roadpump_link')"  style="text-align: left;">จัดการ รุ่นรถ/รุ่นปั๊ม</a></li>
                          <li><a href="javascript:void(0);" onclick="togle_page('brand/init','roadpump_link')"  style="text-align: left;">จัดการ ยี่ห้อรถ/ยี่ห้อปั๊ม</a></li>
                          <li><a href="javascript:void(0);" onclick="togle_page('roadPumpStatus/init','roadpump_link')"  style="text-align: left;">จัดการ สถานะ Road pump</a></li>
                          <li><a href="javascript:void(0);" onclick="togle_page('roadPumpType/init','roadpump_link')"  style="text-align: left;">จัดการ ประเภท Road pump</a></li>
                         </ul>
                      </li>
                      <!--  <li id="maintenance_link"><a onclick="togle_page('maintenance/init','maintenance_link')">Maintenance</a></li> -->
                      <li class="dropdown" id="maintenance_link"> 
                      	<a href="#" class="dropdown-toggle" data-toggle="dropdown">Maintenance<b class="caret"></b></a>
                      	<ul class="dropdown-menu">
                          <!-- <li><a href="javascript:void(0);"  onclick="togle_page('maintenance/page/maintenance_roadpump_search','maintenance_link')" style="text-align: left;">ตรวจสภาพรถ</a></li>
                          <li><a href="javascript:void(0);" onclick="togle_page('maintenance/page/maintenance_dept_search','maintenance_link')"  style="text-align: left;">จัดการแผนก</a></li>
                          <li><a href="javascript:void(0);" onclick="togle_page('maintenance/page/maintenance_jobtype_search','maintenance_link')"  style="text-align: left;">จัดการประเภทงาน</a></li>
                          <li><a href="javascript:void(0);" onclick="togle_page('maintenance/page/maintenance_check_search','maintenance_link')"  style="text-align: left;">จัดการตรวจเช็ค</a></li> -->
                          <li><a href="javascript:void(0);"  onclick="togle_page('maintenance/page/maintenance_roadpump_search','maintenance_link')" style="text-align: left;">ตรวจสภาพรถ</a></li>
                          <li><a href="javascript:void(0);" onclick="togle_page('department/init','maintenance_link')"  style="text-align: left;">จัดการแผนก</a></li>
                          <li><a href="javascript:void(0);" onclick="togle_page('workType/init','maintenance_link')"  style="text-align: left;">จัดการประเภทงาน</a></li>
                          <li><a href="javascript:void(0);" onclick="togle_page('maintenance/page/maintenance_check_search','maintenance_link')"  style="text-align: left;">จัดการตรวจเช็ค</a></li>
                         </ul>
                      </li>
                     <!--  <li  id="report_link"><a onclick="togle_page('report/init','report_link')">Report</a></li> -->
                     <li class="dropdown" id="report_link"> 
                      	<a href="#" class="dropdown-toggle" data-toggle="dropdown">Report<b class="caret"></b></a>
                      	<ul class="dropdown-menu">
                      	 <!--  <li><a  href="javascript:void(0);"  onclick="togle_page('report/page/report1','report_link')"  style="text-align: left;">สรุปบันทึกการขาด ลา มาสาย พนง.</a></li>
                          <li><a  href="javascript:void(0);" style="text-align: left;">ค่าคิวรถออกงานประจำวัน</a></li>
                          <li><a  href="javascript:void(0);" style="text-align: left;">รายงานการออกงานประจำวัน</a></li>
                          <li><a  href="javascript:void(0);" style="text-align: left;">สถิติเบรคดาวน์ประจำเดือน</a></li>
                          <li><a  href="javascript:void(0);" style="text-align: left;">รายงานสรุปค่าคิวออกงานประจำเดือน</a></li> -->
                           <li><a  href="javascript:void(0);"  onclick="togle_page('report/page/report1','report_link')"  style="text-align: left;">สรุปค่าแรงพนักงานรายวัน</a></li>
                          <li><a  href="javascript:void(0);"  onclick="togle_page('report/page/report2','report_link')"  style="text-align: left;">สรุปค่าคิวรถออกงานประจำเดือน</a></li>
                          <li><a  href="javascript:void(0);" onclick="togle_page('report/page/report3','report_link')"  style="text-align: left;">รายงานการออกงานประจำวัน</a></li>
                          <li><a  href="javascript:void(0);" onclick="togle_page('report/page/report4','report_link')"  style="text-align: left;">สถิติเบรคดาวน์ประจำเดือน</a></li>
                         <!--  <li><a  href="javascript:void(0);" style="text-align: left;">รายงานสรุปค่าคิวออกงานประจำเดือน</a></li> -->
                          
                         </ul>
                      </li>
                     <%--  <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">นาย สมชาย รักงาน<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                          <li><a href="<c:url value='/logout'/>">Log out</a></li>
                        </ul>
                      </li> --%>
                       <li class="dropdown" id="user_link"> 
                      	<a href="#" class="dropdown-toggle" data-toggle="dropdown">${myUser.fullName}<b class="caret"></b></a>
                      	<ul class="dropdown-menu">
                      	   <li><a href="javascript:void(0);" onclick="togle_page('user/init','user_link')" style="text-align: left;">จัดการ User</a></li>
                      	   <li><a href="<c:url value='/logout'/>"  style="text-align: left;">Log out</a></li>
                         </ul>
                      </li>
                    </ul> 
                   <!--  <ul class="nav pull-right">
                      <li><a href="#">Link</a></li>
                      <li class="divider-vertical"></li>
                      <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                          <li><a href="#">Action</a></li>
                          <li><a href="#">Another action</a></li>
                          <li><a href="#">Something else here</a></li>
                          <li class="divider"></li>
                          <li><a href="#">Separated link</a></li>
                        </ul>
                      </li>
                    </ul> -->
                  </div><!-- /.nav-collapse -->
                </div>
              </div><!-- /navbar-inner -->
            </div>
            </td>
            </tr> 
            </table>
         </span>
             	 
        <!-- /navbar -->
         <!--  </div>   -->
         <!--  <span style="float:right;position: relative;top: 30px"> -->
             		<!-- นาย สมชาย รักงาน <a  href="">Log out</a> -->
             		
             		<!-- <div class="btn-group">
  <a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
    นาย สมชาย รักงาน
    <span class="caret"></span>
  </a>
  <ul class="dropdown-menu">
    <li class="dropdown">ss</li>
    <li class="dropdown">ssdd</li>
    dropdown menu links
  </ul>
 
</div> -->
          <!--  </span> -->
     	</div>
     </div>
     <div class="row-fluid" style="margin-top: 63px"> 
     	<div id="_content" class="span8 offset2">
      	
      	</div>
    </div> 
  </div>  
</body>
</html>


