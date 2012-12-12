package th.co.aoe.imake.pst.constant;

import java.util.ResourceBundle;

public class ServiceConstant {
	public static final String hostReference = "http://10.2.0.76:10000/BPSService/RestletServlet/";
	
	public static final String LOG_APPENDER = "PSTLog";
	
	public static final String INTERFACE_RETURN_TYPE = "java.util.List";
	public static final String VOID_RETURN_TYPE = "void";
	public static final ResourceBundle bundle;
	public static String SCHEMA="";
	static{
		bundle =  ResourceBundle.getBundle( "jdbc" );	
		SCHEMA=bundle.getString("schema");
	}

	// PST_BREAK_DOWN
	public static final String PST_BREAK_DOWN_SAVE = "savePstBreakDown";
	public static final String PST_BREAK_DOWN_UPDATE = "updatePstBreakDown";
	public static final String PST_BREAK_DOWN_DELETE = "deletePstBreakDown";
	public static final String PST_BREAK_DOWN_ITEMS_DELETE ="deletePstBreakDownItems";
	public static final String PST_BREAK_DOWN_SEARCH = "searchPstBreakDown";
	public static final String PST_BREAK_DOWN_FIND_BY_ID = "findPstBreakDownById";
	
	// PST_COSTS
	public static final String PST_COST_SAVE = "savePstCost";
	public static final String PST_COST_UPDATE = "updatePstCost";
	public static final String PST_COST_DELETE = "deletePstCost";
	public static final String PST_COST_ITEMS_DELETE ="deletePstCostItems";
	public static final String PST_COST_SEARCH = "searchPstCost";
	public static final String PST_COST_FIND_BY_ID = "findPstCostById";

	// PST_ROAD_PUMP
	public static final String PST_ROAD_PUMP_SAVE = "savePstRoadPump";
	public static final String PST_ROAD_PUMP_UPDATE = "updatePstRoadPump";
	public static final String PST_ROAD_PUMP_DELETE = "deletePstRoadPump";
	public static final String PST_ROAD_PUMP_ITEMS_DELETE ="deletePstRoadPumpItems";
	public static final String PST_ROAD_PUMP_SEARCH = "searchPstRoadPump";
	public static final String PST_ROAD_PUMP_FIND_BY_ID = "findPstRoadPumpById";
	public static final String PST_ROAD_PUMP_LIST_MASTER = "listMasterPstRoadPump";
	
	// PST_ROAD_PUMP_STATUS
	public static final String PST_ROAD_PUMP_STATUS_SAVE = "savePstRoadPumpStatus";
	public static final String PST_ROAD_PUMP_STATUS_UPDATE = "updatePstRoadPumpStatus";
	public static final String PST_ROAD_PUMP_STATUS_DELETE = "deletePstRoadPumpStatus";
	public static final String PST_ROAD_PUMP_STATUS_ITEMS_DELETE ="deletePstRoadPumpStatusItems";
	public static final String PST_ROAD_PUMP_STATUS_SEARCH = "searchPstRoadPumpStatus";
	public static final String PST_ROAD_PUMP_STATUS_FIND_BY_ID = "findPstRoadPumpStatusById";
	public static final String PST_ROAD_PUMP_STATUS_LIST = "listPstRoadPumpStatus";
	
	// PST_ROAD_PUMP_DEACTIVE_MAPPING
	public static final String PST_ROAD_PUMP_DEACTIVE_MAPPING_SAVE = "savePstRoadPumpDeactiveMapping";
	public static final String PST_ROAD_PUMP_DEACTIVE_MAPPING_UPDATE = "updatePstRoadPumpDeactiveMapping";
	public static final String PST_ROAD_PUMP_DEACTIVE_MAPPING_DELETE = "deletePstRoadPumpDeactiveMapping";
	public static final String PST_ROAD_PUMP_DEACTIVE_MAPPING_ITEMS_DELETE ="deletePstRoadPumpDeactiveMappingItems";
	public static final String PST_ROAD_PUMP_DEACTIVE_MAPPING_SEARCH = "searchPstRoadPumpDeactiveMapping";
	public static final String PST_ROAD_PUMP_DEACTIVE_MAPPING_FIND_BY_ID = "findPstRoadPumpDeactiveMappingById";
	
	// PST_EMPLOYEE_STATUS
	public static final String PST_EMPLOYEE_STATUS_SAVE = "savePstEmployeeStatus";
	public static final String PST_EMPLOYEE_STATUS_UPDATE = "updatePstEmployeeStatus";
	public static final String PST_EMPLOYEE_STATUS_DELETE = "deletePstEmployeeStatus";
	public static final String PST_EMPLOYEE_STATUS_ITEMS_DELETE ="deletePstEmployeeStatusItems";
	public static final String PST_EMPLOYEE_STATUS_SEARCH = "searchPstEmployeeStatus";
	public static final String PST_EMPLOYEE_STATUS_FIND_BY_ID = "findPstEmployeeStatusById";
	
	// PST_EMPLOYEE
	public static final String PST_EMPLOYEE_SAVE = "savePstEmployee";
	public static final String PST_EMPLOYEE_UPDATE = "updatePstEmployee";
	public static final String PST_EMPLOYEE_DELETE = "deletePstEmployee";
	public static final String PST_EMPLOYEE_ITEMS_DELETE ="deletePstEmployeeItems";
	public static final String PST_EMPLOYEE_SEARCH = "searchPstEmployee";
	public static final String PST_EMPLOYEE_FIND_BY_ID = "findPstEmployeeById";
		
	// PST_EMPLOYEE_WORK_MAPPING
	public static final String PST_EMPLOYEE_WORK_MAPPING_SAVE = "savePstEmployeeWorkMapping";
	public static final String PST_EMPLOYEE_WORK_MAPPING_UPDATE = "updatePstEmployeeWorkMapping";
	public static final String PST_EMPLOYEE_WORK_MAPPING_DELETE = "deletePstEmployeeWorkMapping";
	public static final String PST_EMPLOYEE_WORK_MAPPING_ITEMS_DELETE ="deletePstEmployeeWorkMappingItems";
	public static final String PST_EMPLOYEE_WORK_MAPPING_SEARCH = "searchPstEmployeeWorkMapping";
	public static final String PST_EMPLOYEE_WORK_MAPPING_FIND_BY_ID = "findPstEmployeeWorkMappingById";
		
	// role_contact
		public static final String ROLE_CONTACT_SAVE = "saveRoleContact";
		public static final String ROLE_CONTACT_UPDATE = "updateRoleContact";
		public static final String ROLE_CONTACT_DELETE = "deleteRoleContact";
		public static final String ROLE_CONTACT_SEARCH = "searchRoleContact";
		public static final String ROLE_CONTACT_FIND_BY_ID = "findRoleContactById"; 
		public static final String ROLE_CONTACT_ITEMS_DELETE ="deleteRoleContactItems";
		public static final String ROLE_CONTACT_LIST_BY_MA_ID ="listRoleContactByMaId";
		
		
		// role_mapping
		public static final String ROLE_MAPPING_SAVE = "saveRoleMapping";
		public static final String ROLE_MAPPING_UPDATE = "updateRoleMapping";
		public static final String ROLE_MAPPING_DELETE = "deleteRoleMapping";
		public static final String ROLE_MAPPING_SEARCH = "searchRoleMapping";
		public static final String ROLE_MAPPING_FIND_BY_ID = "findRoleMappingById"; 
		public static final String ROLE_MAPPING_ITEMS_DELETE ="deleteRoleMappingItems";
		public static final String ROLE_MAPPING_LIST_BY_RC_ID ="listRoleMappingByRcId";
		
		// role_type
		public static final String ROLE_TYPE_SAVE = "saveRoleType";
		public static final String ROLE_TYPE_UPDATE = "updateRoleType";
		public static final String ROLE_TYPE_DELETE = "deleteRoleType";
		public static final String ROLE_TYPE_SEARCH = "searchRoleType";
		public static final String ROLE_TYPE_FIND_BY_ID = "findRoleTypeById"; 
		public static final String ROLE_TYPE_ITEMS_DELETE ="deleteRoleTypeItems";
		public static final String ROLE_TYPE_LIST_BY_RC_ID ="listRoleTypeByRcId";
		public static final String ROLE_TYPE_LIST ="listRoleTypes";
		
}
