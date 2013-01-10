package th.co.aoe.imake.pst.hibernate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import th.co.aoe.imake.pst.constant.ServiceConstant;
import th.co.aoe.imake.pst.hibernate.bean.PstJob;
import th.co.aoe.imake.pst.managers.PstJobService;
import th.co.aoe.imake.pst.xstream.common.Pagging;

@Repository
@Transactional
public class HibernatePstJob extends HibernateCommon implements PstJobService {

	private static final Logger logger = Logger.getLogger(ServiceConstant.LOG_APPENDER);
	private static SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
	private SessionFactory sessionAnnotationFactory;
	public SessionFactory getSessionAnnotationFactory() {
		return sessionAnnotationFactory;
	}
	public void setSessionAnnotationFactory(SessionFactory sessionAnnotationFactory) {
		this.sessionAnnotationFactory = sessionAnnotationFactory;
	}
	private int getSize(Session session,String prpNo,String date, PstJob instance) throws Exception{
		try {
			
			String pjJobNo=instance.getPjJobNo();
			//Date pjCreatedTime=instance.getPjCreatedTime();
			String pjCustomerNo=instance.getPjCustomerNo();
			String pjCustomerName=instance.getPjCustomerName();
			String pjCustomerDepartment=instance.getPjCustomerDepartment();
			Long pconcreteId=(instance.getPstConcrete()!=null && instance.getPstConcrete().getPconcreteId()!=null &&
					instance.getPstConcrete().getPconcreteId().intValue()!=-1 && instance.getPstConcrete().getPconcreteId().intValue()!=0)?instance.getPstConcrete().getPconcreteId(): null;
			//instance.get
			
			
			Query query=null;
			
			StringBuffer sb =new StringBuffer(" select count(pstJob) from PstJob pstJob ");
			
			boolean iscriteria = false;
			
			if(pjJobNo !=null && pjJobNo.trim().length()> 0){  
				//criteria.add(Expression.eq("megId", megId));	
				sb.append(iscriteria?(" and lcase(pstJob.pjJobNo) like '%"+pjJobNo.trim().toLowerCase()+"%'"):(" where lcase(pstJob.pjJobNo) like '%"+pjJobNo.trim().toLowerCase()+"%'"));
				  iscriteria = true;
			}
			if(pjCustomerNo !=null && pjCustomerNo.trim().length() > 0){  
				//criteria.add(Expression.eq("megId", megId));	
				sb.append(iscriteria?(" and lcase(pstJob.pjCustomerNo) like '%"+pjCustomerNo.trim().toLowerCase()+"%'"):(" where lcase(pstJob.pjCustomerNo) like '%"+pjCustomerNo.trim().toLowerCase()+"%'"));
				  iscriteria = true;
			}
			if(pjCustomerName !=null && pjCustomerName.trim().length() > 0){  
				//criteria.add(Expression.eq("megId", megId));	
				sb.append(iscriteria?(" and lcase(pstJob.pjCustomerName) like '%"+pjCustomerName.trim().toLowerCase()+"%'"):(" where lcase(pstJob.pjCustomerName) like '%"+pjCustomerNo.trim().toLowerCase()+"%'"));
				  iscriteria = true;
			}
			if(pjCustomerDepartment !=null && pjCustomerDepartment.trim().length() > 0){  
				//criteria.add(Expression.eq("megId", megId));	
				sb.append(iscriteria?(" and lcase(pstJob.pjCustomerDepartment) like '%"+pjCustomerDepartment.trim().toLowerCase()+"%'"):(" where lcase(pstJob.pjCustomerDepartment) like '%"+pjCustomerNo.trim().toLowerCase()+"%'"));
				  iscriteria = true;
			}
			if(pconcreteId !=null){  
				//criteria.add(Expression.eq("megId", megId));	
				sb.append(iscriteria?(" and pstJob.pstConcrete.pconcreteId="+pconcreteId+""):(" where pstJob.pstConcrete.pconcreteId="+pconcreteId+""));
				  iscriteria = true;
			}
			if(date!=null){  
				//criteria.add(Expression.eq("megId", megId));	
				sb.append(iscriteria?(" and pstJob.pjCreatedTime  between '"+date+" 00:00:00' and '"+date+" 23:59:59'"):(" where pstJob.pjCreatedTime  between '"+date+" 00:00:00' and '"+date+" 23:59:59'"));
				  iscriteria = true;
			}
			if(prpNo!=null && prpNo.length()>0){  
			sb.append(iscriteria?(" and pstJob.pjId  in ( select  pstJobWork.id.pjId from PstJobWork as pstJobWork " +
					" ,  PstRoadPump as pstRoadPump where pstJobWork.id.prpId=pstRoadPump.prpId and " +
					" pstJobWork.id.pjId=pstJob.pjId and lcase(pstRoadPump.prpNo) like '%"+prpNo.trim().toLowerCase()+"%') "):
						(" where pstJob.pjId  in ( select  pstJobWork.id.pjId from PstJobWork as pstJobWork " +
					" ,  PstRoadPump as pstRoadPump where pstJobWork.id.prpId=pstRoadPump.prpId and " +
					" pstJobWork.id.pjId=pstJob.pjId and lcase(pstRoadPump.prpNo) like '%"+prpNo.trim().toLowerCase()+"%') "));
			}
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
	 public List searchPstJob(PstJob instance,String prpNo,Pagging pagging) throws DataAccessException {
			ArrayList  transList = new ArrayList ();
			Session session = sessionAnnotationFactory.getCurrentSession();
			try {
				String pjJobNo=instance.getPjJobNo();
				Date pjCreatedTime=instance.getPjCreatedTime();
				String pjCustomerNo=instance.getPjCustomerNo();
				String pjCustomerName=instance.getPjCustomerName();
				String pjCustomerDepartment=instance.getPjCustomerDepartment();
				Long pconcreteId=(instance.getPstConcrete()!=null && instance.getPstConcrete().getPconcreteId()!=null &&
						instance.getPstConcrete().getPconcreteId().intValue()!=-1 && instance.getPstConcrete().getPconcreteId().intValue()!=0)?instance.getPstConcrete().getPconcreteId(): null;
				//instance.get
				/*System.out.println(prpNo);
				System.out.println(pjCreatedTime);
				System.out.println(pjCustomerNo);
				System.out.println(pjCustomerName);
				System.out.println(pjCustomerDepartment);
				System.out.println(pconcreteId);*/
				
				Query query = null;
			/*
			 * SELECT * FROM PST_DB.PST_JOB job where 
job.pj_id in( select job_work.pj_id from PST_DB.PST_JOB_WORK job_work left join 
 PST_DB.PST_ROAD_PUMP road_pump on job_work.prp_id=road_pump.prp_id 
where job_work.pj_id=job.pj_id and road_pump.prp_no='HP0')

			 */
				StringBuffer sb =new StringBuffer(" select pstJob from PstJob pstJob ");
				
				boolean iscriteria = false;
				String date=null;
				if(pjCreatedTime!=null)
				date=format1.format(pjCreatedTime);
 
				if(pjJobNo !=null && pjJobNo.trim().length()> 0){  
					//criteria.add(Expression.eq("megId", megId));	
					sb.append(iscriteria?(" and lcase(pstJob.pjJobNo) like '%"+pjJobNo.trim().toLowerCase()+"%'"):(" where lcase(pstJob.pjJobNo) like '%"+pjJobNo.trim().toLowerCase()+"%'"));
					  iscriteria = true;
				}
				if(pjCustomerNo !=null && pjCustomerNo.trim().length() > 0){  
					//criteria.add(Expression.eq("megId", megId));	
					sb.append(iscriteria?(" and lcase(pstJob.pjCustomerNo) like '%"+pjCustomerNo.trim().toLowerCase()+"%'"):(" where lcase(pstJob.pjCustomerNo) like '%"+pjCustomerNo.trim().toLowerCase()+"%'"));
					  iscriteria = true;
				}
				if(pjCustomerName !=null && pjCustomerName.trim().length() > 0){  
					//criteria.add(Expression.eq("megId", megId));	
					sb.append(iscriteria?(" and lcase(pstJob.pjCustomerName) like '%"+pjCustomerName.trim().toLowerCase()+"%'"):(" where lcase(pstJob.pjCustomerName) like '%"+pjCustomerNo.trim().toLowerCase()+"%'"));
					  iscriteria = true;
				}
				if(pjCustomerDepartment !=null && pjCustomerDepartment.trim().length() > 0){  
					//criteria.add(Expression.eq("megId", megId));	
					sb.append(iscriteria?(" and lcase(pstJob.pjCustomerDepartment) like '%"+pjCustomerDepartment.trim().toLowerCase()+"%'"):(" where lcase(pstJob.pjCustomerDepartment) like '%"+pjCustomerNo.trim().toLowerCase()+"%'"));
					  iscriteria = true;
				}
				if(pconcreteId !=null){  
					//criteria.add(Expression.eq("megId", megId));	
					sb.append(iscriteria?(" and pstJob.pstConcrete.pconcreteId="+pconcreteId+""):(" where pstJob.pstConcrete.pconcreteId="+pconcreteId+""));
					  iscriteria = true;
				}
				if(date!=null){  
					//criteria.add(Expression.eq("megId", megId));	
					sb.append(iscriteria?(" and pstJob.pjCreatedTime  between '"+date+" 00:00:00' and '"+date+" 23:59:59'"):(" where pstJob.pjCreatedTime  between '"+date+" 00:00:00' and '"+date+" 23:59:59'"));
					  iscriteria = true;
				}
				if(prpNo!=null && prpNo.length()>0){  
					//criteria.add(Expression.eq("megId", megId));	
					/*job where 
					job.pj_id in( select job_work.pj_id from PST_DB.PST_JOB_WORK job_work left join 
					 PST_DB.PST_ROAD_PUMP road_pump on job_work.prp_id=road_pump.prp_id 
					where job_work.pj_id=job.pj_id and road_pump.prp_no='HP0')*/
					 /*query =session.createQuery("select  pstJobWork.id.pjId from PstJobWork as pstJobWork " +
							" ,  PstRoadPump as pstRoadPump where pstJobWork.id.prpId=pstRoadPump.prpId and " +
							" pstJobWork.id.pjId=1 and lcase(pstRoadPump.prpNo) like '%"+prpNo.trim().toLowerCase()+"%'  ");*/
					// List list=query.list();
					// System.out.println(list);
					/*sb.append(iscriteria?(" and pstJob.pjId  in (1,2) "):
								(" where pstJob.pjId  in (1,2) "));*/
					sb.append(iscriteria?(" and pstJob.pjId  in ( select  pstJobWork.id.pjId from PstJobWork as pstJobWork " +
							" ,  PstRoadPump as pstRoadPump where pstJobWork.id.prpId=pstRoadPump.prpId and " +
							" pstJobWork.id.pjId=pstJob.pjId and lcase(pstRoadPump.prpNo) like '%"+prpNo.trim().toLowerCase()+"%') "):
								(" where pstJob.pjId  in ( select  pstJobWork.id.pjId from PstJobWork as pstJobWork " +
							" ,  PstRoadPump as pstRoadPump where pstJobWork.id.prpId=pstRoadPump.prpId and " +
							" pstJobWork.id.pjId=pstJob.pjId and lcase(pstRoadPump.prpNo) like '%"+prpNo.trim().toLowerCase()+"%') "));
					  iscriteria = true;
				}
				
				if(pagging.getSortBy()!=null && pagging.getSortBy().length()>0){
						sb.append( " order by pstJob."+pagging.getOrderBy()+" "+pagging.getSortBy().toLowerCase());
				}			
				 query =session.createQuery(sb.toString());
				// set pagging.
				 String size = String.valueOf(getSize(session,prpNo, date,instance)); 
				 logger.debug(" first Result="+(pagging.getPageSize()* (pagging.getPageNo() - 1))); 
				 
				 query.setFirstResult(pagging.getPageSize() * (pagging.getPageNo() - 1));
				 query.setMaxResults(pagging.getPageSize());
				 
				 List l = query.list();   
				 transList.add(l); 
			 	 transList.add(size); 
				return transList;
			} catch (Exception re) {
				//re.printStackTrace();
				logger.error("find by property name failed", re);
				 
			}
			return transList;
		}

}
