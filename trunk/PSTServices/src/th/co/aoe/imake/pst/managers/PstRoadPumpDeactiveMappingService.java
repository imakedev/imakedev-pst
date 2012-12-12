package th.co.aoe.imake.pst.managers;

import java.util.List;

import org.springframework.dao.DataAccessException;

import th.co.aoe.imake.pst.hibernate.bean.PstRoadPumpDeactiveMapping;
import th.co.aoe.imake.pst.xstream.common.Pagging;

public interface PstRoadPumpDeactiveMappingService {
	@SuppressWarnings("rawtypes")
	public  List searchPstRoadPumpDeactiveMapping(PstRoadPumpDeactiveMapping persistentInstance,	Pagging pagging)throws DataAccessException  ;
	
}
