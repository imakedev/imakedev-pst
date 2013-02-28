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
import th.co.aoe.imake.pst.managers.PstJobService;
import th.co.aoe.imake.pst.xstream.common.Pagging;
import th.co.aoe.imake.pst.xstream.common.VResultMessage;

public class PstJobResource  extends BaseResource {
 

	private static final Logger logger = Logger.getLogger(ServiceConstant.LOG_APPENDER);
	private static String[] ignore={"pstConcrete"};  
	
	private PSTCommonService pstCommonService;
	private PstJobService pstJobService; 
	private com.thoughtworks.xstream.XStream xstream; 
	public PstJobResource() {
		super();
		logger.debug("into constructor PstJobResource");
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
			xstream.processAnnotations(th.co.aoe.imake.pst.xstream.PstJob.class);// or xstream.autodetectAnnotations(true); (Auto-detect  Annotations)
			th.co.aoe.imake.pst.xstream.PstJob xbpsTerm = new th.co.aoe.imake.pst.xstream.PstJob();
			Object ntcCalendarObj = xstream.fromXML(in);
			if (ntcCalendarObj != null) {
				//String className=ntcCalendarObj.getClass().toString();
				/*if("th.co.aoe.imake.pst.xstream.ProductReport".equals(className)){
					
				}else if(){
					
				}*/
				xbpsTerm = (th.co.aoe.imake.pst.xstream.PstJob) ntcCalendarObj;
				if (xbpsTerm != null) { 
					if (xbpsTerm.getServiceName() != null
							&& !xbpsTerm.getServiceName().equals("")) {
						logger.debug(" BPS servicename = "
								+ xbpsTerm.getServiceName());
						String serviceName = xbpsTerm.getServiceName();
						th.co.aoe.imake.pst.hibernate.bean.PstJob bpsTerm = new th.co.aoe.imake.pst.hibernate.bean.PstJob();
						BeanUtils.copyProperties(xbpsTerm,bpsTerm,ignore); 
						if(xbpsTerm.getPstConcrete()!=null && xbpsTerm.getPstConcrete().getPconcreteId()!=null &&  xbpsTerm.getPstConcrete().getPconcreteId().intValue()!=-1){
							th.co.aoe.imake.pst.hibernate.bean.PstConcrete pstConcrete = new th.co.aoe.imake.pst.hibernate.bean.PstConcrete();
							BeanUtils.copyProperties(xbpsTerm.getPstConcrete(),pstConcrete); 
							bpsTerm.setPstConcrete(pstConcrete);
						}
						if(serviceName.equals(ServiceConstant.PST_JOB_FIND_BY_ID)){
							Object obj= pstCommonService.findById(bpsTerm.getClass(), xbpsTerm.getPjId());
							if(obj!=null){
								th.co.aoe.imake.pst.hibernate.bean.PstJob pstJob = (th.co.aoe.imake.pst.hibernate.bean.PstJob)obj;
								BeanUtils.copyProperties(pstJob, xbpsTerm,ignore) ;
								if(pstJob.getPstConcrete()!=null && pstJob.getPstConcrete().getPconcreteId()!=null ){
									th.co.aoe.imake.pst.xstream.PstConcrete pstConcrete = new th.co.aoe.imake.pst.xstream.PstConcrete();
									BeanUtils.copyProperties(pstJob.getPstConcrete(),pstConcrete); 
									xbpsTerm.setPstConcrete(pstConcrete);
								}
							}
						//logger.debug(" object return ="+ntcCalendarReturn);
						VResultMessage vresultMessage = new VResultMessage();
							if(xbpsTerm!=null){
								List<th.co.aoe.imake.pst.xstream.PstJob> xntcCalendars = new ArrayList<th.co.aoe.imake.pst.xstream.PstJob>(1);
								xbpsTerm.setPagging(null);							 
								xntcCalendars.add(xbpsTerm);
								vresultMessage.setResultListObj(xntcCalendars);
							}
							return getRepresentation(entity, vresultMessage, xstream);
						}else if(serviceName.equals(ServiceConstant.PST_JOB_SAVE)){
							java.sql.Timestamp timeStampStartDate = new java.sql.Timestamp(new Date().getTime());
							Long pjId=0l;
							pjId=(Long) (pstCommonService.save(bpsTerm));
							xbpsTerm.setPjId(pjId);
							return returnUpdateRecord(entity,xbpsTerm,pjId.intValue());
						} else if(serviceName.equals(ServiceConstant.PST_JOB_UPDATE)){
							java.sql.Timestamp timeStampStartDate = new java.sql.Timestamp(new Date().getTime());
							int updateRecord=pstCommonService.update(bpsTerm);
							return returnUpdateRecord(entity,xbpsTerm,updateRecord);
							
						}
						else if(serviceName.equals(ServiceConstant.PST_JOB_ITEMS_DELETE)){
							/*int updateRecord=missAccountService.deleteMissAccount(bpsTerm);
							returnUpdateRecord(entity,xbpsTerm,updateRecord);*/
							
							String[] ids=xbpsTerm.getIds().split(",");
							//logger.debug("xbpsTerm.getMsIds()="+xbpsTerm.getMsIds());
							int updateRecord=0;
							for (int i = 0; i <ids.length; i++) {
								th.co.aoe.imake.pst.hibernate.bean.PstJob item = new th.co.aoe.imake.pst.hibernate.bean.PstJob();
								item.setPjId(Long.parseLong(ids[i]));
								updateRecord=pstCommonService.delete(item);
							}
							return returnUpdateRecord(entity,xbpsTerm,updateRecord);
						}
						else if(serviceName.equals(ServiceConstant.PST_JOB_DELETE)){
								java.sql.Timestamp timeStampStartDate = new java.sql.Timestamp(new Date().getTime());
								int updateRecord=pstCommonService.delete(bpsTerm);
								return returnUpdateRecord(entity,xbpsTerm,updateRecord);
						}else if(serviceName.equals(ServiceConstant.PST_JOB_SEARCH)){
							Pagging page = xbpsTerm.getPagging(); 
							List result = (List) pstJobService.searchPstJob(bpsTerm,xbpsTerm.getPrpNo(), page);
							if (result != null && result.size() == 2) {
								java.util.ArrayList<th.co.aoe.imake.pst.hibernate.bean.PstJob> ntcCalendars = (java.util.ArrayList<th.co.aoe.imake.pst.hibernate.bean.PstJob>) result
										.get(0);
								String faqs_size = (String) result.get(1);
								VResultMessage vresultMessage = new VResultMessage();
								List<th.co.aoe.imake.pst.xstream.PstJob> xntcCalendars = new ArrayList<th.co.aoe.imake.pst.xstream.PstJob>();
								if (faqs_size != null && !faqs_size.equals(""))
									vresultMessage.setMaxRow(faqs_size);
								if (ntcCalendars != null && ntcCalendars.size() > 0) {
									xntcCalendars = getxPstJobObject(ntcCalendars);
								}
								vresultMessage.setResultListObj(xntcCalendars);
								return getRepresentation(entity, vresultMessage, xstream);
							}
						}else if(serviceName.equals(ServiceConstant.PST_JOB_LIST_MASTER)){
							 
							List pstBreakDownList= getxPstBreakDownObject(pstCommonService.listObject(" select pstBreakDown from PstBreakDown pstBreakDown "));
							List pstEmployeeList= getxPstEmployeeObject(pstCommonService.listObject(" select pstEmployee from PstEmployee pstEmployee "));
							 
							List pstCostList= getxPstCostObject(pstCommonService.listObject(" select pstCost from PstCost pstCost "));
							
							VResultMessage vresultMessage = new VResultMessage();
							xbpsTerm.setPstBreakDownList(pstBreakDownList);
							xbpsTerm.setPstEmployeeList(pstEmployeeList);
							xbpsTerm.setPstCostList(pstCostList); 
							List<th.co.aoe.imake.pst.xstream.PstJob> xntcCalendars = new ArrayList<th.co.aoe.imake.pst.xstream.PstJob>();
							xntcCalendars.add(xbpsTerm);
							//logger.error("xbpsTerm-"+xbpsTerm);
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
	private Representation returnUpdateRecord(Representation entity,th.co.aoe.imake.pst.xstream.PstJob xbpsTerm,int updateRecord){
		VResultMessage vresultMessage = new VResultMessage();
		List<th.co.aoe.imake.pst.xstream.PstJob> xbpsTerms = new ArrayList<th.co.aoe.imake.pst.xstream.PstJob>(1);
		xbpsTerm.setUpdateRecord(updateRecord);
		xbpsTerms.add(xbpsTerm);
		vresultMessage.setResultListObj(xbpsTerms);
		//export(entity, vresultMessage, xstream);	
		return getRepresentation(entity, vresultMessage, xstream);
	}
	private List<th.co.aoe.imake.pst.xstream.PstJob> getxPstJobObject(
			java.util.ArrayList<th.co.aoe.imake.pst.hibernate.bean.PstJob> ntcCalendars) {
		List<th.co.aoe.imake.pst.xstream.PstJob> xntcCalendars = new ArrayList<th.co.aoe.imake.pst.xstream.PstJob>(
				ntcCalendars.size());
		for (th.co.aoe.imake.pst.hibernate.bean.PstJob missManual : ntcCalendars) {
			th.co.aoe.imake.pst.xstream.PstJob xmissManual =new th.co.aoe.imake.pst.xstream.PstJob ();
			BeanUtils.copyProperties(missManual, xmissManual,ignore);
			if(missManual.getPstConcrete()!=null && missManual.getPstConcrete().getPconcreteId()!=null ){
				th.co.aoe.imake.pst.xstream.PstConcrete pstConcrete = new th.co.aoe.imake.pst.xstream.PstConcrete();
				BeanUtils.copyProperties(missManual.getPstConcrete(),pstConcrete); 
				xmissManual.setPstConcrete(pstConcrete);
			}
			xmissManual.setPagging(null);
			xntcCalendars.add(xmissManual);
		}
		return xntcCalendars;
	} 
	@Override
	protected Representation get(Variant variant) throws ResourceException {
		// TODO Auto-generated method stub
		System.out.println("sss");
		th.co.aoe.imake.pst.xstream.PstJob  xbpsTerm =new th.co.aoe.imake.pst.xstream.PstJob();
		th.co.aoe.imake.pst.hibernate.bean.PstJob pstJob =new  th.co.aoe.imake.pst.hibernate.bean.PstJob();
		xbpsTerm.setPjId(1l);
		Object obj= pstCommonService.findById(pstJob.getClass(), xbpsTerm.getPjId());
		if(obj!=null){
			 pstJob = (th.co.aoe.imake.pst.hibernate.bean.PstJob)obj;
			BeanUtils.copyProperties(pstJob, xbpsTerm,ignore) ;
		}
	//logger.debug(" object return ="+ntcCalendarReturn);
	VResultMessage vresultMessage = new VResultMessage();
		if(xbpsTerm!=null){
			List<th.co.aoe.imake.pst.xstream.PstJob> xntcCalendars = new ArrayList<th.co.aoe.imake.pst.xstream.PstJob>(1);
			xbpsTerm.setPagging(null);							 
			xntcCalendars.add(xbpsTerm);
			vresultMessage.setResultListObj(xntcCalendars);
		}
		//save
		//Long pjId=(Long) (pstCommonService.save(pstJob));
		
		//update
		/*pstJob.setPbdUid("updated");
		pstCommonService.update(pstJob);*/
		
		// delete
		//pstCommonService.delete(pstJob);
		return getRepresentation(null, vresultMessage, xstream);
		// return null;
	} 
	private List<th.co.aoe.imake.pst.xstream.PstBreakDown> getxPstBreakDownObject(
			java.util.List<th.co.aoe.imake.pst.hibernate.bean.PstBreakDown> pstBreakDowns){
		List<th.co.aoe.imake.pst.xstream.PstBreakDown> xpstBreakDowns = new ArrayList<th.co.aoe.imake.pst.xstream.PstBreakDown>(
				pstBreakDowns.size());
		for (th.co.aoe.imake.pst.hibernate.bean.PstBreakDown pstBreakDown : pstBreakDowns) {
			th.co.aoe.imake.pst.xstream.PstBreakDown xpstBreakDown =new th.co.aoe.imake.pst.xstream.PstBreakDown ();
			BeanUtils.copyProperties(pstBreakDown, xpstBreakDown);
			xpstBreakDowns.add(xpstBreakDown);
		}
		return xpstBreakDowns;
	}
	private List<th.co.aoe.imake.pst.xstream.PstEmployee> getxPstEmployeeObject(
			java.util.List<th.co.aoe.imake.pst.hibernate.bean.PstEmployee> pstEmployees){
		List<th.co.aoe.imake.pst.xstream.PstEmployee> xpstEmployees = new ArrayList<th.co.aoe.imake.pst.xstream.PstEmployee>(
				pstEmployees.size());
		for (th.co.aoe.imake.pst.hibernate.bean.PstEmployee pstEmployee : pstEmployees) {
			th.co.aoe.imake.pst.xstream.PstEmployee xpstEmployee =new th.co.aoe.imake.pst.xstream.PstEmployee (); 
			pstEmployee.setPstPosition(null);
			pstEmployee.setPstTitle(null);
			BeanUtils.copyProperties(pstEmployee, xpstEmployee);
			xpstEmployees.add(xpstEmployee);
		}
		return xpstEmployees;
	}
	private List<th.co.aoe.imake.pst.xstream.PstCost> getxPstCostObject(
			java.util.List<th.co.aoe.imake.pst.hibernate.bean.PstCost> pstCosts){
		List<th.co.aoe.imake.pst.xstream.PstCost> xpstCosts = new ArrayList<th.co.aoe.imake.pst.xstream.PstCost>(
				pstCosts.size());
		for (th.co.aoe.imake.pst.hibernate.bean.PstCost pstCost : pstCosts) {
			th.co.aoe.imake.pst.xstream.PstCost xpstCost =new th.co.aoe.imake.pst.xstream.PstCost ();
			BeanUtils.copyProperties(pstCost, xpstCost);
			xpstCosts.add(xpstCost);
		}
		return xpstCosts;
	}


	public PstJobService getPstJobService() {
		return pstJobService;
	}

	public void setPstJobService(PstJobService pstJobService) {
		this.pstJobService = pstJobService;
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
