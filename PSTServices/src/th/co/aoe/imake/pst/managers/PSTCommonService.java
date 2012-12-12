package th.co.aoe.imake.pst.managers;

import java.io.Serializable;
import java.util.List;

public interface PSTCommonService {
	public int delete( Object persistentInstance);
	public int update( Object persistentInstance) ;
	public Object save(Object transientInstance);
	public Object findById( Class classType, Serializable id) ;
	public List listObject( String query) ;
}
