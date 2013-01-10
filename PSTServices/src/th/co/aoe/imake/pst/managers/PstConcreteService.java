package th.co.aoe.imake.pst.managers;

import java.util.List;

import org.springframework.dao.DataAccessException;

public interface PstConcreteService {
	@SuppressWarnings("rawtypes")
	public  List listPstConcretes()throws DataAccessException  ;
}
