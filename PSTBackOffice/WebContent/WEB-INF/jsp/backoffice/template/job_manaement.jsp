<%@ page contentType="text/html; charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/includes.jsp" %> 
<script type="text/javascript">
$(document).ready(function() {
	$('#tabs_1').tabs();
	$('#tabs_2').tabs();
	$('#tabs_3').tabs();
	$('#tabs_4').tabs();
	/* $('#tabs_3').tabs();
	$('#tabs_4').tabs(); */
	/*  $( "#accordion" ).accordion({
	      collapsible: true
	    });
	    $('.accordion .head').click(function() {
	        $(this).next().toggle();
	        return false;
	    }).next().hide(); */
	$("#pjCreatedTime" ).datepicker({
		showOn: "button",
		buttonImage: _path+"resources/images/calendar.gif",
		buttonImageOnly: true,
		dateFormat:"dd/mm/yy" ,
		changeMonth: true,
		changeYear: true
	});
});
function goBackJob(){
 
	  $.ajax({
		  type: "get",
		  url: "job/init",
		  cache: false
		 // data: { name: "John", location: "Boston" }
		}).done(function( data ) {
			if(data!=null){
				 appendContent(data);
				// $("#tabs-3").html(data);
			  }
		});
}
function doJobAction(action,mode,id){
	$("#pjRemark").val(CKEDITOR.instances["pjRemark"].getData());
	var target="job"; 
 	$.post(target+"/action/job",$("#jobForm").serialize(), function(data) {
		  // alert(data);
		  appendContent(data);
		   //appendContentWithId(data,"tabs-3");
		  // alert($("#_content").html());
		});
  }
 
</script>
<style>
legend {font-size: 14px}
</style>
<div style="${display};padding-top:10px">
 <div class="alert alert-success" style="${display}">    
    <button class="close" data-dismiss="alert"><span style="font-size: 12px">x</span></button>
    <strong>${message}</strong> 
  </div>
  </div>
<fieldset style="font-family: sans-serif;padding-top:5px">
	    <form:form id="jobForm" name="jobForm" modelAttribute="jobForm"  cssClass="well" cssStyle="border:2px solid #B3D2EE;background: #F9F9F9" action="" method="post">
	  
			<!--  <form class="well"> -->
			 <%--  <input type="hidden" value="${jobForm.pstJob.mcontactRef}" id="maId"/>
			  <input type="hidden" value="${jobForm.pstJob.mcontactType}" id="mcontactType"/> --%> 
			  <form:hidden path="mode"/>
			  <form:hidden path="pstJob.pjId" id="pjId" /> 
			  <fieldset style="font-family: sans-serif;">   
			 <!--  <pre  class="prettyprint" style="font-family: sans-serif;font-size:12px:;margin-top: 0px"> -->
			  <div align="left">
           	 <strong>Job</strong><br></br>
            	</div>
			    <table border="0" width="100%" style="font-size: 12px">
			    	<tr>
    					<td width="100%" colspan="6"></td>
    				</tr>
    				<tr valign="middle">
    					<td width="10%" align="right"><span style="font-size: 13px;padding: 5px">เลขที่งาน :</span></td>
    					<td width="20%" colspan="1"> 
    						<form:input path="pstJob.pjJobNo" id="pjJobNo" cssStyle="height: 30;width:80px"/>
    					</td> 
    					<td width="10%" align="right"><span style="font-size: 13px;padding: 5px">วันที่ :</span></td>
    					<td width="20%" colspan="1"> 
    						<form:input path="pjCreatedTime" id="pjCreatedTime"  cssStyle="height: 30;width:85px" readonly="true"/>
    					</td>
    					<td width="10%" align="right"><span style="font-size: 13px;padding: 5px">หน่วยงาน :</span></td>
    					<td width="30%" colspan="1"> 
    						<form:input path="pstJob.pjCustomerDepartment" id="pjCustomerDepartment" cssStyle="height: 30;"/>
    					</td>
    				</tr>
    				<tr valign="middle">
    					<td width="13%" align="right"><span style="font-size: 13px;padding: 5px">คอนกรีตที่ใช้ :</span></td>
    					<td width="20%" colspan="1"> 
    					<form:select path="pstJob.pstConcrete.pconcreteId" cssStyle="width:100px">
	    						      <form:option value="-1">---</form:option>
	    					      	  <form:options itemValue="pconcreteId" itemLabel="pconcreteName" items="${pstConcretes}"/> 
	    	        </form:select>
    						<%-- <form:input path="pstJob.pstConcrete.pconcreteId" id="pconcreteId" cssStyle="height: 30;width:80px"/> --%>
    					</td> 
    					<td width="10%" align="right"><span style="font-size: 13px;padding: 5px">รหัสลูกค้า :</span></td>
    					<td width="20%" colspan="1"> 
    						<form:input path="pstJob.pjCustomerNo" id="pjCustomerNo" cssStyle="height: 30;width:80px"/>
    					</td>
    					<td width="10%" align="right"><span style="font-size: 13px;padding: 5px">ชื่อลูกค้า :</span></td>
    					<td width="30%" colspan="1"> 
    						<form:input path="pstJob.pjCustomerName" id="pjCustomerName" cssStyle="height: 30;"/>
    					</td>
    				</tr>
    				<tr valign="middle">
    					<td width="10%" align="right"><span style="font-size: 13px;padding: 5px">ชื่อผู้ติดต่อ :</span></td>
    					<td width="20%" colspan="1"> 
    						<form:input path="pstJob.pjContractName" id="pjContractName" cssStyle="height: 30;width:150px"/>
    					</td> 
    					<td width="10%" align="right"><span style="font-size: 13px;padding: 5px">โทรศัพท์ :</span></td>
    					<td width="20%" colspan="1"> 
    						<form:input path="pstJob.pjContractMobileNo" id="pjContractMobileNo" cssStyle="height: 30;width:120px"/>
    					</td>
    					<td width="10%" align="right"><span style="font-size: 13px;padding: 5px"></span></td>
    					<td width="30%" colspan="1"> 
    						 
    					</td>
    				</tr>
    				<tr valign="top">
    					<td width="10%" align="right"><span style="font-size: 13px;padding: 5px">หมายเหตุ :</span></td>
    					<td width="20%" colspan="5"> 
    					<form:textarea path="pstJob.pjRemark" id="pjRemark" rows="4" cols="4"></form:textarea>
    					<script>
    					if (CKEDITOR.instances['pjRemark']) {
    			            CKEDITOR.remove(CKEDITOR.instances['pjRemark']);
    			         }
    					CKEDITOR.replace( 'pjRemark',
    						    { 
    						        //toolbar : 'Basic',
    						        toolbar : [
    						                      	{ name: 'basicstyles', groups: [ 'basicstyles', 'cleanup' ], items: [ 'Bold', 'Italic', 'Underline', 'Strike', 'Subscript', 'Superscript' ] },
    						                      	{ name: 'paragraph', groups: [ 'list', 'indent', 'blocks', 'align' ], items: [ 'NumberedList', 'BulletedList', '-', 'Outdent', 'Indent' ] },
    						                      	{ name: 'links', items: [ 'Link', 'Unlink' ] }
    						                     // 	{ name: 'others', items: [ '-' ] },
    						                      //	{ name: 'about', items: [ 'About' ] }
    						                      ],
    						        height:"100"
    						        //, width:"200"
    						      //  uiColor : '#9AB8F3'
    						    });
    					//CKEDITOR.instances['pjRemark'].resize( '100%', '50' );
    					</script>
    					</td> 
    				</tr>
    			</table> 
    			<br/>
    			<table border="0" width="100%" style="font-size: 12px">
			    	 <tr>
    					<td width="100%" colspan="6">
    					 	<div id="tabs_1">
								<ul>			 
									<li><a href="#tabs_1-1">รายการรถออกงาน:xxxxx</a></li> 
								</ul>
								<div id="tabs_1-1" >
								 <!-- <div>หมายเลขรถ <select></select> Break down/สาเหตุ<select></select></div> -->
     								Not yet Finish  
								</div>
							</div>
							
    					</td>
    				</tr>  
    				</table>
    				<table border="0" width="100%" style="font-size: 12px">
			    	 <tr>
    					<td width="100%" colspan="6">
    					 	<div id="tabs_2">
								<ul>			 
									<li><a href="#tabs_2-1">พนักงานประจำรถ:xxxxx</a></li> 
								</ul>
								<div id="tabs_2-1" >
								 <!-- <div>หมายเลขรถ <select></select> Break down/สาเหตุ<select></select></div> -->
     								Not yet Finish  
								</div>
							</div>
							
    					</td>
    				</tr>  
    				</table>
    				<table border="0" width="100%" style="font-size: 12px">
			    	 <tr>
    					<td width="100%" colspan="6">
    					 	<div id="tabs_3">
								<ul>			 
									<li><a href="#tabs_3-1">รายงานจ่ายค่าคิว หมายเลขรถ:xxxxx</a></li> 
								</ul>
								<div id="tabs_3-1" >
								 <!-- <div>หมายเลขรถ <select></select> Break down/สาเหตุ<select></select></div> -->
     								Not yet Finish  
								</div>
							</div>
							
    					</td>
    				</tr>  
    				</table>
    			 <table border="0" width="100%" style="font-size: 12px">
			    	 <tr>
    					<td width="100%" colspan="6">
    					 	<div id="tabs_4">
								<ul>			 
									<li><a href="#tabs_4-1">รายการค่าใช้จ่ายอื่นๆ</a></li> 
								</ul>
								<div id="tabs_4-1" >
								 <!-- <div>หมายเลขรถ <select></select> Break down/สาเหตุ<select></select></div> -->
     								Not yet Finish  
								</div>
							</div>
							
    					</td>
    				</tr>  
    				<tr>
    					<td width="100%" colspan="6">
    					 	<!-- <div id="accordion">
  <h3>รายการรถออกงาน:xxxxx</h3>
  <div>
    <p>Mauris mauris ante, blandit et, ultrices a, suscipit eget, quam. Integer ut neque. Vivamus nisi metus, molestie vel, gravida in, condimentum sit amet, nunc. Nam a nibh. Donec suscipit eros. Nam mi. Proin viverra leo ut odio. Curabitur malesuada. Vestibulum a velit eu ante scelerisque vulputate.</p>
  </div>
  <h3>พนักงานประจำรถ:xxxxx</h3>
  <div>
    <p>Sed non urna. Donec et ante. Phasellus eu ligula. Vestibulum sit amet purus. Vivamus hendrerit, dolor at aliquet laoreet, mauris turpis porttitor velit, faucibus interdum tellus libero ac justo. Vivamus non quam. In suscipit faucibus urna. </p>
  </div>
  <h3>รายการจ่ายค่าคิว หมายเลขรถ:xxxxx</h3>
  <div>
    <p>Nam enim risus, molestie et, porta ac, aliquam ac, risus. Quisque lobortis. Phasellus pellentesque purus in massa. Aenean in pede. Phasellus ac libero ac tellus pellentesque semper. Sed ac felis. Sed commodo, magna quis lacinia ornare, quam ante aliquam nisi, eu iaculis leo purus venenatis dui. </p>
    <ul>
      <li>List item one</li>
      <li>List item two</li>
      <li>List item three</li>
    </ul>
  </div>
  <h3>รายการค่าใช้จ่ายอื่นๆ</h3>
  <div>
    <p>Cras dictum. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Aenean lacinia mauris vel est. </p><p>Suspendisse eu nisl. Nullam ut libero. Integer dignissim consequat lectus. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. </p>
  </div>
</div> -->
							
    					</td>
    				</tr> 
    			</table>
    			</fieldset> 
			  </form:form>  
			<div align="center">
			<a class="btn btn-info"  onclick="goBackJob()"><i class="icon-chevron-left icon-white"></i>&nbsp;<span style="color: white;font-weight: bold;">Back</span></a>	
    					 <a class="btn btn-primary"  onclick="doJobAction('action','${jobForm.mode}','${jobForm.pstJob.pjId}')"><i class="icon-ok icon-white"></i>&nbsp;<span style="color: white;font-weight: bold;">Save</span></a>
			</div>
</fieldset>