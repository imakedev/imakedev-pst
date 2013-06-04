package th.co.aoe.imake.pst.managers;

import java.util.List;

import org.springframework.dao.DataAccessException;

public interface PstObjectService { 
	@SuppressWarnings("rawtypes")
	public  List searchObject(String query)throws DataAccessException  ;

	public  int executeQuery(String[] query)throws DataAccessException  ;
	public  int executeQueryUpdate(String[] queryDelete,String[] queryUpdate)throws DataAccessException  ;
	//public  int executeQueryDelete(String[] query)throws DataAccessException  ;
	
}
