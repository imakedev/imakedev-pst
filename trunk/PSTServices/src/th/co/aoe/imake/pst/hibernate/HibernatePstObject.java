package th.co.aoe.imake.pst.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import th.co.aoe.imake.pst.managers.PstObjectService;
@Repository
@Transactional
public class HibernatePstObject extends HibernateCommon implements PstObjectService {

//	private static final Logger logger = Logger.getLogger(ServiceConstant.LOG_APPENDER);
	private SessionFactory sessionAnnotationFactory;
	public SessionFactory getSessionAnnotationFactory() {
		return sessionAnnotationFactory;
	}
	public void setSessionAnnotationFactory(SessionFactory sessionAnnotationFactory) {
		this.sessionAnnotationFactory = sessionAnnotationFactory;
	}
	@SuppressWarnings("rawtypes")
	@Override
	public List searchObject(String query) throws DataAccessException {
		// TODO Auto-generated method stub
		try{ 
		    List result= this.sessionAnnotationFactory
				.getCurrentSession()
				.createSQLQuery(query).list();
		    if(result!=null && result.size()>0){ 
		    	return result;
		    	//	Object obj[] =(Object[])result.get(i); 
		    }
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} 
		return null;
	}
	@Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor={RuntimeException.class})
	@Override
	public int executeQuery(String[] str) throws DataAccessException {
		// TODO Auto-generated method stub
		Session session=sessionAnnotationFactory.getCurrentSession();
		int returnId=0;
		Query	query=null;
		try{ 
			for (int i = 0; i < str.length; i++) {
				query= session.createSQLQuery(str[i]);
				 returnId=returnId+query.executeUpdate();
			} 
				 
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if (session != null) {
				session = null;
			} 
		}
				return returnId;
	}
	@Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor={RuntimeException.class})
	@Override
	public int executeQueryUpdate(String[] queryDelete,String[] queryUpdate) throws DataAccessException {
		// TODO Auto-generated method stub
	/*	Session session=sessionAnnotationFactory.getCurrentSession();
		StringBuffer sb =new StringBuffer();
		Query  queryHQL=null;*/
		int returnRecord=execute(queryDelete, "delete");
		 returnRecord=returnRecord+execute(queryUpdate, "update");
		 //System.out.println(returnRecord);
		/*for (int i = 0; i < queryDelete.length; i++) {
			String [] queryArray=queryDelete[i].split("_"); 
			sb.setLength(0);
			sb.append(" select count(pstCheckingMapping) from PstCheckingMapping pstCheckingMapping " +
					" where  pstCheckingMapping.id.pcmType='"+queryArray[0]+"' and pstCheckingMapping.id.pcmRefTypeNo="+queryArray[1]+
					" and pstCheckingMapping.id.pdId="+queryArray[2]+" and  pstCheckingMapping.id.pwtId="+queryArray[3]); 
			
			queryHQL=session.createQuery(sb.toString());
			 if(((Long)queryHQL.uniqueResult()).intValue()==0){
				 //save
				 th.co.aoe.imake.pst.hibernate.bean.PstCheckingMapping mapping= new th.co.aoe.imake.pst.hibernate.bean.PstCheckingMapping();
				 th.co.aoe.imake.pst.hibernate.bean.PstCheckingMappingPK pk=new th.co.aoe.imake.pst.hibernate.bean.PstCheckingMappingPK();
				 pk.setPcmType(queryArray[0]);
				 pk.setPcmRefTypeNo(Long.valueOf(queryArray[1]));
				 pk.setPdId(Long.valueOf(queryArray[2]));
				 pk.setPwtId(Long.valueOf(queryArray[3]));
				 mapping.setId(pk);
				 session.save(mapping);
			 }
		}
		*/
		return returnRecord;
	}
	@Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor={RuntimeException.class})
	private int execute(String[] query,String mode) throws DataAccessException {
		// TODO Auto-generated method stub
		//System.out.println("query size="+query.length);
		Session session=sessionAnnotationFactory.getCurrentSession();
		StringBuffer sb =new StringBuffer();
		Query  queryHQL=null;
		int returnRecord=0;
		for (int i = 0; i < query.length; i++) {
			String [] queryArray=query[i].split("_"); 
			sb.setLength(0);
			sb.append(" select count(pstCheckingMapping) from PstCheckingMapping pstCheckingMapping " +
					" where  pstCheckingMapping.id.pcmType='"+queryArray[0]+"' and pstCheckingMapping.id.pcmRefTypeNo="+queryArray[1]+
					" and pstCheckingMapping.id.pdId="+queryArray[2]+" and  pstCheckingMapping.id.pwtId="+queryArray[3]); 
			//System.out.println("pcmType->"+queryArray[0]+",pcmRefTypeNo->"+queryArray[1]+",pdId->"+queryArray[2]+",pwtId->"+queryArray[3]);
			queryHQL=session.createQuery(sb.toString());
			 if(mode.equals("update")){
				 if(((Long)queryHQL.uniqueResult()).intValue()==0){
					 //save
					 th.co.aoe.imake.pst.hibernate.bean.PstCheckingMapping mapping= new th.co.aoe.imake.pst.hibernate.bean.PstCheckingMapping();
					 th.co.aoe.imake.pst.hibernate.bean.PstCheckingMappingPK pk=new th.co.aoe.imake.pst.hibernate.bean.PstCheckingMappingPK();
					 pk.setPcmType(queryArray[0]);
					 pk.setPcmRefTypeNo(Long.valueOf(queryArray[1]));
					 pk.setPdId(Long.valueOf(queryArray[2]));
					 pk.setPwtId(Long.valueOf(queryArray[3]));
					 mapping.setId(pk);
						 session.save(mapping);
					 returnRecord++;
				 }
			 }else{ //delete
				 if(((Long)queryHQL.uniqueResult()).intValue()>0){
					 //save
					 th.co.aoe.imake.pst.hibernate.bean.PstCheckingMapping mapping= new th.co.aoe.imake.pst.hibernate.bean.PstCheckingMapping();
					 th.co.aoe.imake.pst.hibernate.bean.PstCheckingMappingPK pk=new th.co.aoe.imake.pst.hibernate.bean.PstCheckingMappingPK();
					 pk.setPcmType(queryArray[0]);
					 pk.setPcmRefTypeNo(Long.valueOf(queryArray[1]));
					 pk.setPdId(Long.valueOf(queryArray[2]));
					 pk.setPwtId(Long.valueOf(queryArray[3]));
					 mapping.setId(pk);
						 session.delete(mapping);
						 returnRecord++;
				 }
			 }
			 /*if(((Long)queryHQL.uniqueResult()).intValue()==0){
				 //save
				 th.co.aoe.imake.pst.hibernate.bean.PstCheckingMapping mapping= new th.co.aoe.imake.pst.hibernate.bean.PstCheckingMapping();
				 th.co.aoe.imake.pst.hibernate.bean.PstCheckingMappingPK pk=new th.co.aoe.imake.pst.hibernate.bean.PstCheckingMappingPK();
				 pk.setPcmType(queryArray[0]);
				 pk.setPcmRefTypeNo(Long.valueOf(queryArray[1]));
				 pk.setPdId(Long.valueOf(queryArray[2]));
				 pk.setPwtId(Long.valueOf(queryArray[3]));
				 mapping.setId(pk);
				 if(mode.equals("update"))
					 session.save(mapping);
				 else
					 session.delete(mapping);
				 returnRecord++;
			 }*/
		}
		
		return returnRecord;
	}
	/*@Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor={RuntimeException.class})
	@Override
	public int executeQueryDelete(String[] query) throws DataAccessException {
		// TODO Auto-generated method stub
		Session session=sessionAnnotationFactory.getCurrentSession();
		StringBuffer sb =new StringBuffer();
		Query  queryHQL=null;
		for (int i = 0; i < query.length; i++) {
			String [] queryArray=query[i].split("_"); 
			sb.setLength(0);
			sb.append(" select count(pstCheckingMapping) from PstCheckingMapping pstCheckingMapping " +
					" where  pstCheckingMapping.id.pcmType='"+queryArray[0]+"' and pstCheckingMapping.id.pcmRefTypeNo="+queryArray[1]+
					" and pstCheckingMapping.id.pdId="+queryArray[2]+" and  pstCheckingMapping.id.pwtId="+queryArray[3]); 
			
			queryHQL=session.createQuery(sb.toString());
			 if(((Long)queryHQL.uniqueResult()).intValue()==0){
				 //delete
				 th.co.aoe.imake.pst.hibernate.bean.PstCheckingMapping mapping= new th.co.aoe.imake.pst.hibernate.bean.PstCheckingMapping();
				 th.co.aoe.imake.pst.hibernate.bean.PstCheckingMappingPK pk=new th.co.aoe.imake.pst.hibernate.bean.PstCheckingMappingPK();
				 pk.setPcmType(queryArray[0]);
				 pk.setPcmRefTypeNo(Long.valueOf(queryArray[1]));
				 pk.setPdId(Long.valueOf(queryArray[2]));
				 pk.setPwtId(Long.valueOf(queryArray[3]));
				 mapping.setId(pk);
				 session.delete(mapping);
			 }
		}
		
		return 0;
	}*/
	 

}
