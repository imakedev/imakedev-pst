package th.co.aoe.imake.pst.managers;

import java.util.List;

import org.springframework.dao.DataAccessException;

public interface PstObjectService { 
	@SuppressWarnings("rawtypes")
	public  List searchObject(String query)throws DataAccessException  ;

	public  int executeQuery(String[] query)throws DataAccessException  ;
}
