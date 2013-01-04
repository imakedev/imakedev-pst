package th.co.aoe.imake.pst.hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import th.co.aoe.imake.pst.constant.ServiceConstant;
import th.co.aoe.imake.pst.hibernate.bean.PstEmployeeWorkMapping;
import th.co.aoe.imake.pst.managers.PstEmployeeWorkMappingService;
import th.co.aoe.imake.pst.xstream.common.Pagging;
@Repository
@Transactional
public class HibernatePstEmployeeWorkMapping  extends HibernateCommon implements PstEmployeeWorkMappingService {

	private static final Logger logger = Logger.getLogger(ServiceConstant.LOG_APPENDER);
	private SessionFactory sessionAnnotationFactory;
	private static String[] emp_ignore={"pstPosition","pstTitle"}; 
	public SessionFactory getSessionAnnotationFactory() {
		return sessionAnnotationFactory;
	}
	public void setSessionAnnotationFactory(SessionFactory sessionAnnotationFactory) {
		this.sessionAnnotationFactory = sessionAnnotationFactory;
	}
	private int getSize(Session session, PstEmployeeWorkMapping instance) throws Exception{
		try {
			/*String pcUid=instance.getPcUid();
			String pcName=instance.getPcName();*/
			
			Query query=null;
			
			StringBuffer sb =new StringBuffer(" select count(pstEmployee) from PstEmployeeWorkMapping as pstEmployeeWorkMapping   right join pstEmployeeWorkMapping.pstEmployee as pstEmployee ");
		//	select pstEmployee,pstEmployeeWorkMapping from  
			boolean iscriteria = false;
			
		/*	if(pcUid !=null && pcUid.trim().length()> 0){  
				//criteria.add(Expression.eq("megId", megId));	
				sb.append(iscriteria?(" and lcase(pstEmployeeWorkMapping.pcUid) like '%"+pcUid.trim().toLowerCase()+"%'"):(" where lcase(pstEmployeeWorkMapping.pcUid) like '%"+pcUid.trim().toLowerCase()+"%'"));
				  iscriteria = true;
			}
			if(pcName !=null && pcName.trim().length() > 0){  
				//criteria.add(Expression.eq("megId", megId));	
				sb.append(iscriteria?(" and lcase(pstEmployeeWorkMapping.pcName) like '%"+pcName.trim().toLowerCase()+"%'"):(" where lcase(pstEmployeeWorkMapping.pcName) like '%"+pcName.trim().toLowerCase()+"%'"));
				  iscriteria = true;
			}
			*/
			
			  query =session.createQuery(sb.toString());
			 
				 return ((Long)query.uniqueResult()).intValue(); 
		} catch (HibernateException re) {
			logger.error("HibernateException",re);
			throw re;
		} catch (Exception e) {
			logger.error("Exception",e);
			throw e;
		}
	}
	 @SuppressWarnings({ "rawtypes", "unchecked" })
	 @Transactional(readOnly=true)
	 public List searchPstEmployeeWorkMapping(PstEmployeeWorkMapping instance,Pagging pagging) throws DataAccessException {
			ArrayList  transList = new ArrayList ();
			Session session = sessionAnnotationFactory.getCurrentSession();
			try {
				/*String pcUid=instance.getPcUid();
				String pcName=instance.getPcName();*/
				Query query = null;
			
				StringBuffer sb =new StringBuffer(" select pstEmployee,pstEmployeeWorkMapping from PstEmployeeWorkMapping as pstEmployeeWorkMapping   right join pstEmployeeWorkMapping.pstEmployee as pstEmployee ");
				
				
				 // sb =new StringBuffer(" select pstEmployeeWorkMapping from PstEmployeeWorkMapping pstEmployeeWorkMapping ");
				
				boolean iscriteria = false;
				/*
				if(pcUid !=null && pcUid.trim().length()> 0){  
					//criteria.add(Expression.eq("megId", megId));	
					sb.append(iscriteria?(" and lcase(pstEmployeeWorkMapping.pcUid) like '%"+pcUid.trim().toLowerCase()+"%'"):(" where lcase(pstEmployeeWorkMapping.pcUid) like '%"+pcUid.trim().toLowerCase()+"%'"));
					  iscriteria = true;
				}
				if(pcName !=null && pcName.trim().length() > 0){  
					//criteria.add(Expression.eq("megId", megId));	
					sb.append(iscriteria?(" and lcase(pstEmployeeWorkMapping.pcName) like '%"+pcName.trim().toLowerCase()+"%'"):(" where lcase(pstEmployeeWorkMapping.pcName) like '%"+pcName.trim().toLowerCase()+"%'"));
					  iscriteria = true;
				}*/
				if(pagging.getSortBy()!=null && pagging.getSortBy().length()>0){
						sb.append( " order by "+pagging.getOrderBy()+" "+pagging.getSortBy().toLowerCase());
				}			
				 query =session.createQuery(sb.toString());
				// set pagging.
				 String size = String.valueOf(getSize(session, instance)); 
				 logger.debug(" first Result="+(pagging.getPageSize()* (pagging.getPageNo() - 1))); 
				 
				 query.setFirstResult(pagging.getPageSize() * (pagging.getPageNo() - 1));
				 query.setMaxResults(pagging.getPageSize());
				/* d
					private PstPosition pstPosition;

					//bi-directional many-to-one association to PstTitle
					@ManyToOne
					@JoinColumn(name="PT_ID",nullable=true)
					private PstTitle pstTitle*/;
				// List<th.co.aoe.imake.pst.hibernate.bean.PstEmployee> l = query.list(); 
					 List l = query.list();
				 int sizeReturn=l.size();
				System.out.println(sizeReturn);
				//Ljava.lang.Object;
				List returnList=new ArrayList(sizeReturn);
				for (int i = 0; i < sizeReturn; i++) { 
					java.lang.Object[] l1= (java.lang.Object[])l.get(i);
					th.co.aoe.imake.pst.hibernate.bean.PstEmployee employee=(th.co.aoe.imake.pst.hibernate.bean.PstEmployee)l1[0];
					th.co.aoe.imake.pst.hibernate.bean.PstEmployeeWorkMapping pstEmployeeWorkMapping=(th.co.aoe.imake.pst.hibernate.bean.PstEmployeeWorkMapping)l1[1]; 
					
					th.co.aoe.imake.pst.xstream.PstEmployeeWorkMapping xmapping=new th.co.aoe.imake.pst.xstream.PstEmployeeWorkMapping();
					 th.co.aoe.imake.pst.xstream.PstEmployee xemployee= new th.co.aoe.imake.pst.xstream.PstEmployee();
					 
						if(pstEmployeeWorkMapping!=null && pstEmployeeWorkMapping.getId()!=null){
							th.co.aoe.imake.pst.hibernate.bean.PstEmployeeWorkMappingPK pk =pstEmployeeWorkMapping.getId();
							xmapping.setPeId(pk.getPeId());
							xmapping.setPesId(pk.getPesId());
							xmapping.setPrpNo(pk.getPrpNo());
							xmapping.setPewmDateTime(pk.getPewmDateTime());
							th.co.aoe.imake.pst.hibernate.bean.PstEmployeeStatus pstEmployeeStatus=pstEmployeeWorkMapping.getPstEmployeeStatus();
							 if(pstEmployeeStatus!=null){
								 th.co.aoe.imake.pst.xstream.PstEmployeeStatus xpstEmployeeStatus = new th.co.aoe.imake.pst.xstream.PstEmployeeStatus();
								 BeanUtils.copyProperties(pstEmployeeStatus, xpstEmployeeStatus);
								 xmapping.setPstEmployeeStatus(xpstEmployeeStatus);
							 }
						}
						
					
						 
					 BeanUtils.copyProperties(employee, xemployee,emp_ignore);
					 if(employee.getPstPosition()!=null){
						 th.co.aoe.imake.pst.xstream.PstPosition xpstPosition= new th.co.aoe.imake.pst.xstream.PstPosition();
						 BeanUtils.copyProperties(employee.getPstPosition(), xpstPosition);
						 xemployee.setPstPosition(xpstPosition);
					 }
					 if(employee.getPstTitle()!=null){
						 th.co.aoe.imake.pst.xstream.PstTitle xpstTitle= new th.co.aoe.imake.pst.xstream.PstTitle();
						 BeanUtils.copyProperties(employee.getPstTitle(),xpstTitle);
						 xemployee.setPstTitle(xpstTitle);
					 }
					 xmapping.setPstEmployee(xemployee);
					 returnList.add(xmapping);
					//System.out.println(l1.length);
					//List l1=(List) l.get(i);
					//System.out.println(l1[0].getClass());
					//System.out.println(l.get(i).getClass());
					
				}
				 
				/* for (th.co.aoe.imake.pst.hibernate.bean.PstEmployee entry : l) {
					 th.co.aoe.imake.pst.xstream.PstEmployeeWorkMapping mapping=new th.co.aoe.imake.pst.xstream.PstEmployeeWorkMapping();
					 th.co.aoe.imake.pst.xstream.PstEmployee employee= new th.co.aoe.imake.pst.xstream.PstEmployee();
					 BeanUtils.copyProperties(entry, employee);
				}*/
				/* for (int i = 0; i < sizeReturn; i++) {
					
				}*/
				 
				 transList.add(returnList); 
			 	 transList.add(size); 
				return transList;
			} catch (Exception re) {
				//re.printStackTrace();
				logger.error("find by property name failed", re);
				 
			}
			return transList;
		}
	@Override
	public int setPstEmployeeWorkMapping(Long[] peIds, Long[] pesIds,
			String[] prpNos, Date pewmDateTime) {
		// TODO Auto-generated method stub
		return 0;
	}
	private List<th.co.aoe.imake.pst.xstream.PstEmployeeWorkMapping> getxPstEmployeeWorkMappingObject(
			java.util.ArrayList<th.co.aoe.imake.pst.hibernate.bean.PstEmployeeWorkMapping> ntcCalendars) {
		List<th.co.aoe.imake.pst.xstream.PstEmployeeWorkMapping> xntcCalendars = new ArrayList<th.co.aoe.imake.pst.xstream.PstEmployeeWorkMapping>(
				ntcCalendars.size());
		for (th.co.aoe.imake.pst.hibernate.bean.PstEmployeeWorkMapping missManual : ntcCalendars) {
			th.co.aoe.imake.pst.xstream.PstEmployeeWorkMapping xmissManual =new th.co.aoe.imake.pst.xstream.PstEmployeeWorkMapping ();
			BeanUtils.copyProperties(missManual, xmissManual);
			xmissManual.setPagging(null);
			xntcCalendars.add(xmissManual);
		}
		return xntcCalendars;
	} 

}
