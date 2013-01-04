package th.co.aoe.imake.pst.rest.resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.restlet.representation.Representation;
import org.restlet.representation.Variant;
import org.restlet.resource.ResourceException;
import org.springframework.beans.BeanUtils;

import th.co.aoe.imake.pst.constant.ServiceConstant;
import th.co.aoe.imake.pst.managers.PSTCommonService;
import th.co.aoe.imake.pst.managers.PstEmployeeStatusService;
import th.co.aoe.imake.pst.xstream.common.Pagging;
import th.co.aoe.imake.pst.xstream.common.VResultMessage;

public class PstEmployeeStatusResource  extends BaseResource {

	private static final Logger logger = Logger.getLogger(ServiceConstant.LOG_APPENDER);  
	private PSTCommonService pstCommonService;
	private PstEmployeeStatusService pstEmployeeStatusService; 
	private com.thoughtworks.xstream.XStream xstream; 
	public PstEmployeeStatusResource() {
		super();
		logger.debug("into constructor PstEmployeeStatusResource");
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doInit() throws ResourceException {
		// TODO Auto-generated method stub
		super.doInit();
		logger.debug("into doInit");
	}
	
	@Override
	protected Representation post(Representation entity, Variant variant)
			throws ResourceException {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		logger.debug("into Post PSTCommonResource 2");
		InputStream in = null;
		try {
			in = entity.getStream();
			xstream.processAnnotations(th.co.aoe.imake.pst.xstream.PstEmployeeStatus.class);// or xstream.autodetectAnnotations(true); (Auto-detect  Annotations)
			th.co.aoe.imake.pst.xstream.PstEmployeeStatus xbpsTerm = new th.co.aoe.imake.pst.xstream.PstEmployeeStatus();
			Object ntcCalendarObj = xstream.fromXML(in);
			if (ntcCalendarObj != null) {
				xbpsTerm = (th.co.aoe.imake.pst.xstream.PstEmployeeStatus) ntcCalendarObj;
				if (xbpsTerm != null) { 
					if (xbpsTerm.getServiceName() != null
							&& !xbpsTerm.getServiceName().equals("")) {
						logger.debug(" BPS servicename = "
								+ xbpsTerm.getServiceName());
						String serviceName = xbpsTerm.getServiceName();
						th.co.aoe.imake.pst.hibernate.bean.PstEmployeeStatus bpsTerm = new th.co.aoe.imake.pst.hibernate.bean.PstEmployeeStatus();
						BeanUtils.copyProperties(xbpsTerm,bpsTerm); 
						if(serviceName.equals(ServiceConstant.PST_EMPLOYEE_STATUS_FIND_BY_ID)){
							Object obj= pstCommonService.findById(bpsTerm.getClass(), xbpsTerm.getPesId());
							if(obj!=null){
								th.co.aoe.imake.pst.hibernate.bean.PstEmployeeStatus pstEmployeeStatus = (th.co.aoe.imake.pst.hibernate.bean.PstEmployeeStatus)obj;
								BeanUtils.copyProperties(pstEmployeeStatus, xbpsTerm) ;
							}
						//logger.debug(" object return ="+ntcCalendarReturn);
						VResultMessage vresultMessage = new VResultMessage();
							if(xbpsTerm!=null){
								List<th.co.aoe.imake.pst.xstream.PstEmployeeStatus> xntcCalendars = new ArrayList<th.co.aoe.imake.pst.xstream.PstEmployeeStatus>(1);
								xbpsTerm.setPagging(null);							 
								xntcCalendars.add(xbpsTerm);
								vresultMessage.setResultListObj(xntcCalendars);
							}
							return getRepresentation(entity, vresultMessage, xstream);
						}else if(serviceName.equals(ServiceConstant.PST_EMPLOYEE_STATUS_SAVE)){
							java.sql.Timestamp timeStampStartDate = new java.sql.Timestamp(new Date().getTime());
							Long pesId=0l;
							pesId=(Long) (pstCommonService.save(bpsTerm));
							xbpsTerm.setPesId(pesId);
							return returnUpdateRecord(entity,xbpsTerm,pesId.intValue());
						} else if(serviceName.equals(ServiceConstant.PST_EMPLOYEE_STATUS_UPDATE)){
							java.sql.Timestamp timeStampStartDate = new java.sql.Timestamp(new Date().getTime());
							int updateRecord=pstCommonService.update(bpsTerm);
							return returnUpdateRecord(entity,xbpsTerm,updateRecord);
							
						}
						else if(serviceName.equals(ServiceConstant.PST_EMPLOYEE_STATUS_ITEMS_DELETE)){
							/*int updateRecord=missAccountService.deleteMissAccount(bpsTerm);
							returnUpdateRecord(entity,xbpsTerm,updateRecord);*/
							
							String[] ids=xbpsTerm.getIds().split(",");
							//logger.debug("xbpsTerm.getMsIds()="+xbpsTerm.getMsIds());
							int updateRecord=0;
							for (int i = 0; i <ids.length; i++) {
								th.co.aoe.imake.pst.hibernate.bean.PstEmployeeStatus item = new th.co.aoe.imake.pst.hibernate.bean.PstEmployeeStatus();
								item.setPesId(Long.parseLong(ids[i]));
								updateRecord=pstCommonService.delete(item);
							}
							return returnUpdateRecord(entity,xbpsTerm,updateRecord);
						}
						else if(serviceName.equals(ServiceConstant.PST_EMPLOYEE_STATUS_DELETE)){
								java.sql.Timestamp timeStampStartDate = new java.sql.Timestamp(new Date().getTime());
								int updateRecord=pstCommonService.delete(bpsTerm);
								return returnUpdateRecord(entity,xbpsTerm,updateRecord);
						}else if(serviceName.equals(ServiceConstant.PST_EMPLOYEE_STATUS_SEARCH)){
							Pagging page = xbpsTerm.getPagging(); 
							
							List result = (List) pstEmployeeStatusService.searchPstEmployeeStatus(bpsTerm, page);
							if (result != null && result.size() == 2) {
								java.util.ArrayList<th.co.aoe.imake.pst.hibernate.bean.PstEmployeeStatus> ntcCalendars = (java.util.ArrayList<th.co.aoe.imake.pst.hibernate.bean.PstEmployeeStatus>) result
										.get(0);
								String faqs_size = (String) result.get(1);
								VResultMessage vresultMessage = new VResultMessage();
								List<th.co.aoe.imake.pst.xstream.PstEmployeeStatus> xntcCalendars = new ArrayList<th.co.aoe.imake.pst.xstream.PstEmployeeStatus>();
								if (faqs_size != null && !faqs_size.equals(""))
									vresultMessage.setMaxRow(faqs_size);
								if (ntcCalendars != null && ntcCalendars.size() > 0) {
									xntcCalendars = getxPstEmployeeStatusObject(ntcCalendars);
								}
								vresultMessage.setResultListObj(xntcCalendars);
								return getRepresentation(entity, vresultMessage, xstream);
							}
						}else if(serviceName.equals(ServiceConstant.PST_EMPLOYEE_STATUS_LIST)){
							List result = pstEmployeeStatusService.listPstEmployeeStatuses();
							java.util.ArrayList<th.co.aoe.imake.pst.hibernate.bean.PstEmployeeStatus> ntcCalendars = (java.util.ArrayList<th.co.aoe.imake.pst.hibernate.bean.PstEmployeeStatus>) result;
									
							VResultMessage vresultMessage = new VResultMessage();
							List<th.co.aoe.imake.pst.xstream.PstEmployeeStatus> xntcCalendars = new ArrayList<th.co.aoe.imake.pst.xstream.PstEmployeeStatus>();
							if (ntcCalendars != null && ntcCalendars.size() > 0) {
								xntcCalendars = getxPstEmployeeStatusObject(ntcCalendars);
							}
							vresultMessage.setResultListObj(xntcCalendars);
							return getRepresentation(entity, vresultMessage, xstream);
						}
					} else {
					}
				}

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			logger.debug(" into Finally Call");
			try {
				if (in != null)
					in.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	
	}
	private Representation returnUpdateRecord(Representation entity,th.co.aoe.imake.pst.xstream.PstEmployeeStatus xbpsTerm,int updateRecord){
		VResultMessage vresultMessage = new VResultMessage();
		List<th.co.aoe.imake.pst.xstream.PstEmployeeStatus> xbpsTerms = new ArrayList<th.co.aoe.imake.pst.xstream.PstEmployeeStatus>(1);
		xbpsTerm.setUpdateRecord(updateRecord);
		xbpsTerms.add(xbpsTerm);
		vresultMessage.setResultListObj(xbpsTerms);
		//export(entity, vresultMessage, xstream);	
		return getRepresentation(entity, vresultMessage, xstream);
	}
	private List<th.co.aoe.imake.pst.xstream.PstEmployeeStatus> getxPstEmployeeStatusObject(
			java.util.ArrayList<th.co.aoe.imake.pst.hibernate.bean.PstEmployeeStatus> ntcCalendars) {
		List<th.co.aoe.imake.pst.xstream.PstEmployeeStatus> xntcCalendars = new ArrayList<th.co.aoe.imake.pst.xstream.PstEmployeeStatus>(
				ntcCalendars.size());
		for (th.co.aoe.imake.pst.hibernate.bean.PstEmployeeStatus missManual : ntcCalendars) {
			th.co.aoe.imake.pst.xstream.PstEmployeeStatus xmissManual =new th.co.aoe.imake.pst.xstream.PstEmployeeStatus ();
			BeanUtils.copyProperties(missManual, xmissManual);
			xmissManual.setPagging(null);
			xntcCalendars.add(xmissManual);
		}
		return xntcCalendars;
	} 
	@Override
	protected Representation get(Variant variant) throws ResourceException {
		// TODO Auto-generated method stub
		System.out.println("sss");
		th.co.aoe.imake.pst.xstream.PstEmployeeStatus  xbpsTerm =new th.co.aoe.imake.pst.xstream.PstEmployeeStatus();
		th.co.aoe.imake.pst.hibernate.bean.PstEmployeeStatus pstEmployeeStatus =new  th.co.aoe.imake.pst.hibernate.bean.PstEmployeeStatus();
		xbpsTerm.setPesId(1l);
		Object obj= pstCommonService.findById(pstEmployeeStatus.getClass(), xbpsTerm.getPesId());
		if(obj!=null){
			 pstEmployeeStatus = (th.co.aoe.imake.pst.hibernate.bean.PstEmployeeStatus)obj;
			BeanUtils.copyProperties(pstEmployeeStatus, xbpsTerm) ;
		}
	//logger.debug(" object return ="+ntcCalendarReturn);
	VResultMessage vresultMessage = new VResultMessage();
		if(xbpsTerm!=null){
			List<th.co.aoe.imake.pst.xstream.PstEmployeeStatus> xntcCalendars = new ArrayList<th.co.aoe.imake.pst.xstream.PstEmployeeStatus>(1);
			xbpsTerm.setPagging(null);							 
			xntcCalendars.add(xbpsTerm);
			vresultMessage.setResultListObj(xntcCalendars);
		}
		//save
		//Long pesId=(Long) (pstCommonService.save(pstEmployeeStatus));
		
		//update
		/*pstEmployeeStatus.setPbdUid("updated");
		pstCommonService.update(pstEmployeeStatus);*/
		
		// delete
		//pstCommonService.delete(pstEmployeeStatus);
		return getRepresentation(null, vresultMessage, xstream);
		// return null;
	} 
	


	

	public PstEmployeeStatusService getPstEmployeeStatusService() {
		return pstEmployeeStatusService;
	}

	public void setPstEmployeeStatusService(PstEmployeeStatusService pstEmployeeStatusService) {
		this.pstEmployeeStatusService = pstEmployeeStatusService;
	}

	public PSTCommonService getPstCommonService() {
		return pstCommonService;
	}

	public void setPstCommonService(PSTCommonService pstCommonService) {
		this.pstCommonService = pstCommonService;
	}

	public com.thoughtworks.xstream.XStream getXstream() {
		return xstream;
	}

	public void setXstream(com.thoughtworks.xstream.XStream xstream) {
		this.xstream = xstream;
	}

	
}
