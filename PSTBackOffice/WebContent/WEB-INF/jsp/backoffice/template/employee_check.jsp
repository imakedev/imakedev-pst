<%@ page contentType="text/html; charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>
<fieldset style="font-family: sans-serif;padding-top:5px">
	         
           <!-- <legend  style="font-size: 13px">Criteria</legend> -->
           <!-- <div style="position:relative;right:-94%;">  </div> --> 
           
             
            <form id="candidateForm" name="candidateForm" class="well" style="border:2px solid #B3D2EE;background: #F9F9F9" action="/MISSExamBackOffice/candidate/search?_=1353519467506" method="post">
               
            <input id="mode" name="mode" type="hidden" value="">
            <input id="mcaId" name="missCandidate.mcaId" type="hidden" value="">
            <input id="mcaIdArray" name="mcaIdArray" type="hidden" value="">
            <input id="pageNo" name="paging.pageNo" type="hidden" value="1">
            <input id="pageSize" name="paging.pageSize" type="hidden" value="20"> 
            <input id="pageCount" name="pageCount" type="hidden" value="8"> 
            <div align="left">
            <strong>Employee</strong>
            </div>
            <div align="center" style="padding: 10px 60px">
            	<span style="font-size: 13px;">ประจำวัน</span> 
            	<span style="padding: 20px">
            	<input type="text" style="height: 30;"> 
            	</span>  
	    		<span style="font-size: 13px;">เลือกเบอร์รถ</span> 
            	<span style="padding: 20px"><select id="mcaStatus" name="mcaStatus">
	    					      <option value="-1">-- เลือก --</option>
	    					      <option value="1">1</option>
	    					      <option value="2">2</option>
	    		</select></span>  
            </div>
            <!-- 
            <table border="0" width="100%" style="font-size: 13px">
              				<tbody><tr>
	    					 <td align="left" width="17%" colspan="6"><strong>Candidate Search</strong></td>
	    					
	    					</tr> 
	    					<tr valign="top">
	    					 <td align="left" width="17%">&nbsp;</td>
	    					 <td align="left" width="17%">Status:</td>
	    					 <td align="left" width="17%">    	
	    					    <select id="mcaStatus" name="mcaStatus">
	    					      <option value="-1">-- Select Status --</option>
	    					      <option value="1">Used</option>
	    					      <option value="2">Available</option>
	    					    </select>	 
	    					 </td>
	    					<td align="left" width="17%">Series:</td>
	    					<td align="left" width="17%">
	    					 <select id="mcaSeries" name="mcaSeries">
	    					      <option value="-1">-- Select Series --</option>
	    					      <option value="10">MC9T</option><option value="12">EPT: Trait Detector</option><option value="13">MT: Customer Mind Test</option><option value="14">SAT: Service attitude</option><option value="15">4FT: The four factor</option><option value="17">SPP: Sales Test</option><option value="18">Leadership Assessment Series</option><option value="19">World around us</option><option value="20">Logic Test</option><option value="21">EPT Plus: Work Wheel</option><option value="22">MCLeader: Leader Test series</option><option value="23">English Test</option><option value="24">MecHT: Mechanical test</option><option value="25">MCLeader: Leader Test series</option><option value="26">MAT: Management Test series</option><option value="27">MC_TMT: Talent Management</option>
	    					      
	    					    </select>	 
	    						</td>
	    					<td align="left" width="15%">&nbsp;</td>
	    					</tr>
	    					<tr valign="top">
	    					 <td align="left" width="17%">&nbsp;</td>
	    					 <td align="left" width="17%">Username:</td>
	    					 <td align="left" width="17%">
	    					 <input id="mcaUsername" name="mcaUsername" type="text" value=""> 
	    					 </td>
	    					<td align="left" width="17%">Password:</td>
	    					<td align="left" width="17%">
	    					 <input id="mcaPassword" name="mcaPassword" type="text" value=""> 
	    					</td>
	    					<td align="left" width="15%">&nbsp;</td>
	    					</tr> 
	    					<tr valign="top">
	    					 <td align="left" width="17%">&nbsp;</td>
	    					 <td align="left" width="17%">Company Name:</td>
	    					 <td align="left" colspan="3" width="51%">     
	    					  <input id="mcaCompanyName" name="mcaCompanyName" style="width:100%" type="text" value="">	 
	    					 </td> 
	    					<td align="left" width="15%">&nbsp;</td>
	    					</tr> 
	    					</tbody></table> 
	    					-->
	    					</form> 
	    					<table border="0" width="100%" style="font-size: 13px">
	    					<tbody><tr>
	    					<td align="left" width="50%">  
	    					<a class="btn btn-info" onclick="exportCandidat()"><i class="icon-circle-arrow-up icon-white"></i>&nbsp;Manage Employee</a>&nbsp;
	    					<a class="btn btn-info" onclick="exportCandidat()"><i class="icon-circle-arrow-up icon-white"></i>&nbsp;Manage Status</a>&nbsp; 
	    					</td><td align="right" width="50%"> 
	    					<a onclick="goPrev()">Prev</a>&nbsp;|&nbsp;<span id="pageElement"><select name="candidatePageSelect" id="candidatePageSelect" onchange="goToPage()" style="width: 50px"><option value="1">1</option><option value="2">2</option><option value="3">3</option><option value="4">4</option><option value="5">5</option><option value="6">6</option><option value="7">7</option><option value="8">8</option></select></span>&nbsp;|&nbsp;<a onclick="goNext()">Next</a>&nbsp;<a class="btn btn-primary" onclick="doSearch('search','0')"><i class="icon-search icon-white"></i>&nbsp;Search</a></td>
	    					</tr>
	    					</tbody></table>  
		<table class="table table-striped table-bordered table-condensed" border="1" style="font-size: 12px">
        	<thead>
          		<tr> 
            		<th width="7%"><div class="th_class">รหัส</div></th>
            		<th width="17%"><div class="th_class">ชื่อ-นามสกุล</div></th> 
            		<th width="35%"><div class="th_class">ตำแหน่ง</div></th> 
            		<th width="20%"><div class="th_class">วันทำงานสะสม</div></th>
            		<th width="10%"><div class="th_class">เบอร์รถ</div></th> 
            		<th width="5%"><div class="th_class">สถานะการทำงาน</div></th> 
          		</tr>
        	</thead>
        	<tbody> 
          	<tr>  
            	<td>3701</td>
            	<td>นาย เนรศ แก้มแกม</td>
            	
            	<td>พนักงาน ควบคุมปั๊มฯ</td>
            	<td>26</td>
            	<td><select id="mcaStatus" name="mcaStatus">
	    					      <option value="-1">-- เลือก เบอร์รถ --</option>
	    					      <option value="1">1</option>
	    					      <option value="2">2</option>
	    		</select></td>
            	<td><select id="mcaStatus" name="mcaStatus">
	    					      <option value="-1">-- เลือก สถานะ --</option>
	    					      <option value="1">มาทำงานปกติ</option>
	    					      <option value="2">ลา</option>
	    		</select>
            	</td> 
          	</tr> 
          	<tr>  
            	<td>3701</td>
            	<td>นาย เนรศ แก้มแกม</td>
            	
            	<td>พนักงาน ควบคุมปั๊มฯ</td>
            	<td>26</td>
            	<td><select id="mcaStatus" name="mcaStatus">
	    					      <option value="-1">-- เลือก เบอร์รถ --</option>
	    					      <option value="1">1</option>
	    					      <option value="2">2</option>
	    		</select></td>
            	<td><select id="mcaStatus" name="mcaStatus">
	    					      <option value="-1">-- เลือก สถานะ --</option>
	    					      <option value="1">มาทำงานปกติ</option>
	    					      <option value="2">ลา</option>
	    		</select>
            	</td> 
          	</tr> 
          	<tr>  
            	<td>3701</td>
            	<td>นาย เนรศ แก้มแกม</td>
            	
            	<td>พนักงาน ควบคุมปั๊มฯ</td>
            	<td>26</td>
            	<td><select id="mcaStatus" name="mcaStatus">
	    					      <option value="-1">-- เลือก เบอร์รถ --</option>
	    					      <option value="1">1</option>
	    					      <option value="2">2</option>
	    		</select></td>
            	<td><select id="mcaStatus" name="mcaStatus">
	    					      <option value="-1">-- เลือก สถานะ --</option>
	    					      <option value="1">มาทำงานปกติ</option>
	    					      <option value="2">ลา</option>
	    		</select>
            	</td> 
          	</tr> 
          	<tr>  
            	<td>3701</td>
            	<td>นาย เนรศ แก้มแกม</td>
            	
            	<td>พนักงาน ควบคุมปั๊มฯ</td>
            	<td>26</td>
            	<td><select id="mcaStatus" name="mcaStatus">
	    					      <option value="-1">-- เลือก เบอร์รถ --</option>
	    					      <option value="1">1</option>
	    					      <option value="2">2</option>
	    		</select></td>
            	<td><select id="mcaStatus" name="mcaStatus">
	    					      <option value="-1">-- เลือก สถานะ --</option>
	    					      <option value="1">มาทำงานปกติ</option>
	    					      <option value="2">ลา</option>
	    		</select>
            	</td> 
          	</tr> 
          	<tr>  
            	<td>3701</td>
            	<td>นาย เนรศ แก้มแกม</td>
            	
            	<td>พนักงาน ควบคุมปั๊มฯ</td>
            	<td>26</td>
            	<td><select id="mcaStatus" name="mcaStatus">
	    					      <option value="-1">-- เลือก เบอร์รถ --</option>
	    					      <option value="1">1</option>
	    					      <option value="2">2</option>
	    		</select></td>
            	<td><select id="mcaStatus" name="mcaStatus">
	    					      <option value="-1">-- เลือก สถานะ --</option>
	    					      <option value="1">มาทำงานปกติ</option>
	    					      <option value="2">ลา</option>
	    		</select>
            	</td> 
          	</tr> 
          	<tr>  
            	<td>3701</td>
            	<td>นาย เนรศ แก้มแกม</td>
            	
            	<td>พนักงาน ควบคุมปั๊มฯ</td>
            	<td>26</td>
            	<td><select id="mcaStatus" name="mcaStatus">
	    					      <option value="-1">-- เลือก เบอร์รถ --</option>
	    					      <option value="1">1</option>
	    					      <option value="2">2</option>
	    		</select></td>
            	<td><select id="mcaStatus" name="mcaStatus">
	    					      <option value="-1">-- เลือก สถานะ --</option>
	    					      <option value="1">มาทำงานปกติ</option>
	    					      <option value="2">ลา</option>
	    		</select>
            	</td> 
          	</tr> 
          	<tr>  
            	<td>3701</td>
            	<td>นาย เนรศ แก้มแกม</td>
            	
            	<td>พนักงาน ควบคุมปั๊มฯ</td>
            	<td>26</td>
            	<td><select id="mcaStatus" name="mcaStatus">
	    					      <option value="-1">-- เลือก เบอร์รถ --</option>
	    					      <option value="1">1</option>
	    					      <option value="2">2</option>
	    		</select></td>
            	<td><select id="mcaStatus" name="mcaStatus">
	    					      <option value="-1">-- เลือก สถานะ --</option>
	    					      <option value="1">มาทำงานปกติ</option>
	    					      <option value="2">ลา</option>
	    		</select>
            	</td> 
          	</tr> 
          	<tr>  
            	<td>3701</td>
            	<td>นาย เนรศ แก้มแกม</td>
            	
            	<td>พนักงาน ควบคุมปั๊มฯ</td>
            	<td>26</td>
            	<td><select id="mcaStatus" name="mcaStatus">
	    					      <option value="-1">-- เลือก เบอร์รถ --</option>
	    					      <option value="1">1</option>
	    					      <option value="2">2</option>
	    		</select></td>
            	<td><select id="mcaStatus" name="mcaStatus">
	    					      <option value="-1">-- เลือก สถานะ --</option>
	    					      <option value="1">มาทำงานปกติ</option>
	    					      <option value="2">ลา</option>
	    		</select>
            	</td> 
          	</tr> 
          	<tr>  
            	<td>3701</td>
            	<td>นาย เนรศ แก้มแกม</td>
            	
            	<td>พนักงาน ควบคุมปั๊มฯ</td>
            	<td>26</td>
            	<td><select id="mcaStatus" name="mcaStatus">
	    					      <option value="-1">-- เลือก เบอร์รถ --</option>
	    					      <option value="1">1</option>
	    					      <option value="2">2</option>
	    		</select></td>
            	<td><select id="mcaStatus" name="mcaStatus">
	    					      <option value="-1">-- เลือก สถานะ --</option>
	    					      <option value="1">มาทำงานปกติ</option>
	    					      <option value="2">ลา</option>
	    		</select>
            	</td> 
          	</tr> 
          	<tr>  
            	<td>3701</td>
            	<td>นาย เนรศ แก้มแกม</td>
            	
            	<td>พนักงาน ควบคุมปั๊มฯ</td>
            	<td>26</td>
            	<td><select id="mcaStatus" name="mcaStatus">
	    					      <option value="-1">-- เลือก เบอร์รถ --</option>
	    					      <option value="1">1</option>
	    					      <option value="2">2</option>
	    		</select></td>
            	<td><select id="mcaStatus" name="mcaStatus">
	    					      <option value="-1">-- เลือก สถานะ --</option>
	    					      <option value="1">มาทำงานปกติ</option>
	    					      <option value="2">ลา</option>
	    		</select>
            	</td> 
          	</tr> 
          	<tr>  
            	<td>3701</td>
            	<td>นาย เนรศ แก้มแกม</td>
            	
            	<td>พนักงาน ควบคุมปั๊มฯ</td>
            	<td>26</td>
            	<td><select id="mcaStatus" name="mcaStatus">
	    					      <option value="-1">-- เลือก เบอร์รถ --</option>
	    					      <option value="1">1</option>
	    					      <option value="2">2</option>
	    		</select></td>
            	<td><select id="mcaStatus" name="mcaStatus">
	    					      <option value="-1">-- เลือก สถานะ --</option>
	    					      <option value="1">มาทำงานปกติ</option>
	    					      <option value="2">ลา</option>
	    		</select>
            	</td> 
          	</tr> 
          	<tr>  
            	<td>3701</td>
            	<td>นาย เนรศ แก้มแกม</td>
            	
            	<td>พนักงาน ควบคุมปั๊มฯ</td>
            	<td>26</td>
            	<td><select id="mcaStatus" name="mcaStatus">
	    					      <option value="-1">-- เลือก เบอร์รถ --</option>
	    					      <option value="1">1</option>
	    					      <option value="2">2</option>
	    		</select></td>
            	<td><select id="mcaStatus" name="mcaStatus">
	    					      <option value="-1">-- เลือก สถานะ --</option>
	    					      <option value="1">มาทำงานปกติ</option>
	    					      <option value="2">ลา</option>
	    		</select>
            	</td> 
          	</tr> 
          	<tr>  
            	<td>3701</td>
            	<td>นาย เนรศ แก้มแกม</td>
            	
            	<td>พนักงาน ควบคุมปั๊มฯ</td>
            	<td>26</td>
            	<td><select id="mcaStatus" name="mcaStatus">
	    					      <option value="-1">-- เลือก เบอร์รถ --</option>
	    					      <option value="1">1</option>
	    					      <option value="2">2</option>
	    		</select></td>
            	<td><select id="mcaStatus" name="mcaStatus">
	    					      <option value="-1">-- เลือก สถานะ --</option>
	    					      <option value="1">มาทำงานปกติ</option>
	    					      <option value="2">ลา</option>
	    		</select>
            	</td> 
          	</tr> 
          	<tr>  
            	<td>3701</td>
            	<td>นาย เนรศ แก้มแกม</td>
            	
            	<td>พนักงาน ควบคุมปั๊มฯ</td>
            	<td>26</td>
            	<td><select id="mcaStatus" name="mcaStatus">
	    					      <option value="-1">-- เลือก เบอร์รถ --</option>
	    					      <option value="1">1</option>
	    					      <option value="2">2</option>
	    		</select></td>
            	<td><select id="mcaStatus" name="mcaStatus">
	    					      <option value="-1">-- เลือก สถานะ --</option>
	    					      <option value="1">มาทำงานปกติ</option>
	    					      <option value="2">ลา</option>
	    		</select>
            	</td> 
          	</tr> 
          	<tr>  
            	<td>3701</td>
            	<td>นาย เนรศ แก้มแกม</td>
            	
            	<td>พนักงาน ควบคุมปั๊มฯ</td>
            	<td>26</td>
            	<td><select id="mcaStatus" name="mcaStatus">
	    					      <option value="-1">-- เลือก เบอร์รถ --</option>
	    					      <option value="1">1</option>
	    					      <option value="2">2</option>
	    		</select></td>
            	<td><select id="mcaStatus" name="mcaStatus">
	    					      <option value="-1">-- เลือก สถานะ --</option>
	    					      <option value="1">มาทำงานปกติ</option>
	    					      <option value="2">ลา</option>
	    		</select>
            	</td> 
          	</tr> 
          	<tr>  
            	<td>3701</td>
            	<td>นาย เนรศ แก้มแกม</td>
            	
            	<td>พนักงาน ควบคุมปั๊มฯ</td>
            	<td>26</td>
            	<td><select id="mcaStatus" name="mcaStatus">
	    					      <option value="-1">-- เลือก เบอร์รถ --</option>
	    					      <option value="1">1</option>
	    					      <option value="2">2</option>
	    		</select></td>
            	<td><select id="mcaStatus" name="mcaStatus">
	    					      <option value="-1">-- เลือก สถานะ --</option>
	    					      <option value="1">มาทำงานปกติ</option>
	    					      <option value="2">ลา</option>
	    		</select>
            	</td> 
          	</tr> 
          	<tr>  
            	<td>3701</td>
            	<td>นาย เนรศ แก้มแกม</td>
            	
            	<td>พนักงาน ควบคุมปั๊มฯ</td>
            	<td>26</td>
            	<td><select id="mcaStatus" name="mcaStatus">
	    					      <option value="-1">-- เลือก เบอร์รถ --</option>
	    					      <option value="1">1</option>
	    					      <option value="2">2</option>
	    		</select></td>
            	<td><select id="mcaStatus" name="mcaStatus">
	    					      <option value="-1">-- เลือก สถานะ --</option>
	    					      <option value="1">มาทำงานปกติ</option>
	    					      <option value="2">ลา</option>
	    		</select>
            	</td> 
          	</tr> 
          	<tr>  
            	<td>3701</td>
            	<td>นาย เนรศ แก้มแกม</td>
            	
            	<td>พนักงาน ควบคุมปั๊มฯ</td>
            	<td>26</td>
            	<td><select id="mcaStatus" name="mcaStatus">
	    					      <option value="-1">-- เลือก เบอร์รถ --</option>
	    					      <option value="1">1</option>
	    					      <option value="2">2</option>
	    		</select></td>
            	<td><select id="mcaStatus" name="mcaStatus">
	    					      <option value="-1">-- เลือก สถานะ --</option>
	    					      <option value="1">มาทำงานปกติ</option>
	    					      <option value="2">ลา</option>
	    		</select>
            	</td> 
          	</tr> 
          	<tr>  
            	<td>3701</td>
            	<td>นาย เนรศ แก้มแกม</td>
            	
            	<td>พนักงาน ควบคุมปั๊มฯ</td>
            	<td>26</td>
            	<td><select id="mcaStatus" name="mcaStatus">
	    					      <option value="-1">-- เลือก เบอร์รถ --</option>
	    					      <option value="1">1</option>
	    					      <option value="2">2</option>
	    		</select></td>
            	<td><select id="mcaStatus" name="mcaStatus">
	    					      <option value="-1">-- เลือก สถานะ --</option>
	    					      <option value="1">มาทำงานปกติ</option>
	    					      <option value="2">ลา</option>
	    		</select>
            	</td> 
          	</tr> 
          	<tr>  
            	<td>3701</td>
            	<td>นาย เนรศ แก้มแกม</td>
            	
            	<td>พนักงาน ควบคุมปั๊มฯ</td>
            	<td>26</td>
            	<td><select id="mcaStatus" name="mcaStatus">
	    					      <option value="-1">-- เลือก เบอร์รถ --</option>
	    					      <option value="1">1</option>
	    					      <option value="2">2</option>
	    		</select></td>
            	<td><select id="mcaStatus" name="mcaStatus">
	    					      <option value="-1">-- เลือก สถานะ --</option>
	    					      <option value="1">มาทำงานปกติ</option>
	    					      <option value="2">ลา</option>
	    		</select>
            	</td> 
          	</tr>  
        	</tbody>
      </table> 
      </fieldset> 