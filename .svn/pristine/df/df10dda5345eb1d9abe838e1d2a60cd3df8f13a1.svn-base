package com.yyy.dailycode.export.wordexport;

/** 错误码，对应该错误的抽象类型 */
public class ExceptionID {
	
	/** 资源类 */
	public static final String RESOURCE_ERROR = "10001";
	public static final String RESOURCE_CANNOT_BE_FOUND = "10002";
	public static final String URL_CANNOT_BE_CREATED = "10003";
	public static final String THREAD_OPERATION_ERROR = "10004";
	public static final String RESOURCE_CANNOT_BE_INSTANCED = "10005";
	public static final String INVALID_TRANSFORMER = "10006";
	public static final String EXECUTE_COMMAND_ERROR = "10007";		
	
	/** 系统级异常 */
	public static final String INPUT_ERROR = "10102";
	public static final String OUTPUT_ERROR = "10103";
	public static final String AUTHORITY_ERROR = "10104";
	public static final String DB_ERROR = "10105";
	public static final String NULL_OBJECT = "10106";				//对象为空，在需要该对象时，该对象为空则要抛此类异常
	public static final String PROCESS_STATE_ERROR = "10107";
	public static final String CONTEXT_MISSING_ERROR = "10108";
	public static final String TYPE_CHECK_ERROR = "10109";
	public static final String JPDL_PARSE_ERROR = "10110";
	public static final String SUSPEND_OPERATION_ERROR = "10111";
	public static final String JNDI_ERROR = "10112";
	public static final String TYPE_NOT_MATCH = "10113";
	public static final String VALUE_NOT_MATCH = "10124";
	public static final String QUERY_ERROR = "10114";
	public static final String ACTIVITY_QUERY_ERROR = "10115";
	public static final String NULL_TASK = "10116";
	public static final String INVALID_CLASSNAME = "10117";
	public static final String INVALID_TRANSACTION = "10118";
	public static final String FILE_OPERATION_ERROR = "10119";
	public static final String FILE_EXISTS_ERROR = "10120";
	public static final String RESUME_OPERATION_ERROR = "10121";
	
	
	/** 流程流转异常 */
	public static final String PROCESS_ERROR = "11001";
	public static final String DEPLOYMENT_ERROR = "11002";
	public static final String IMAGE_QUERY_ERROR = "11003";
	public static final String PROCESS_TRACK_ERROR = "11004";
	public static final String DECISION_ACTIVITY_ERROR = "11101";
	public static final String DECISION_HANDLER_ERROR = "11102";
	public static final String JAVA_ACTIVITY_ERROR = "11103";
	public static final String JOIN_ACTIVITY_ERROR = "11104";
	public static final String COMPLETE_TASK_ERROR = "11105";
	public static final String TASK_COMMIT_ERROR = "12001";
	public static final String RETRIEVE_TASK_ERROR = "12002";
	public static final String TASK_ASSIGNED_ERROR = "12003";
	public static final String PAGE_ERROR = "12004";
	public static final String TASK_CANDIDATE_ERROR = "12005";
	public static final String OPERATION_ERROR = "12006";
	public static final String TASK_ACTIVE_ERROR = "12007";
	public static final String EXECUTION_EXISTS = "12008";
	public static final String EXECUTE_ACTIVITY_ERROR = "12009";

	
	/** 其他异常 */
	public static final String PROCESS_DEFINITION_ERROR = "15001";
	public static final String TASK_REMINDER_ERROR = "15002";
	public static final String METHOD_ERROR = "15003";
	public static final String INVALID_NAMING = "15004";
	
	public static String[][] exceptionIds = { { INPUT_ERROR, "INPUT_ERROR", "输入不正确" },	
	{ OUTPUT_ERROR, "OUTPUT_ERROR", "输出不正确" }, { DB_ERROR, "DB_ERROR", "数据库操作错误" },
	{ AUTHORITY_ERROR, "AUTHORITY_ERROR", "权限错误" }, {NULL_OBJECT, "NULL_OBJECT", "对象为空"},
	{ DEPLOYMENT_ERROR, "DEPLOYMENT_ERROR", "流程发布出现异常"}, { PROCESS_TRACK_ERROR, "PROCESS_TRACK_ERROR", "流程轨迹查询异常" },
	{ IMAGE_QUERY_ERROR, "IMAGE_QUERY_ERROR", "流程图查询异常" }, { RESOURCE_ERROR, "RESOURCE_ERROR", "资源错误" },
	{ RESOURCE_CANNOT_BE_FOUND, "RESOURCE_CANNOT_BE_FOUND", "资源无法找到" }, { JNDI_ERROR, "JNDI_ERROR", "JNDI错误" },
	{ DECISION_ACTIVITY_ERROR, "DECISION_ACTIVITY_ERROR", "decision节点异常"}, 
	{ DECISION_HANDLER_ERROR, "DECISION_HANDLER_ERROR", "decision节点处理程序异常"},
	{ PROCESS_STATE_ERROR, "PROCESS_STATE_ERROR", "流程状态异常" },
	{ CONTEXT_MISSING_ERROR, "CONTEXT_MISSING_ERROR", "运行上下文缺失" },
	{ JAVA_ACTIVITY_ERROR, "JAVA_ACTIVITY_ERROR", "java节点异常" },
	{ JOIN_ACTIVITY_ERROR, "JOIN_ACTIVITY_ERROR", "join节点异常" },
	{ COMPLETE_TASK_ERROR, "COMPLETE_TASK_ERROR", "提交任务异常" },
	{ TYPE_CHECK_ERROR, "TYPE_CHECK_ERROR", "类型检查异常" },
	{ PROCESS_DEFINITION_ERROR, "PROCESS_DEFINITION_ERROR", "流程定义文件异常" },
	{ JPDL_PARSE_ERROR, "JPDL_PARSE_ERROR", "流程定义解析错误" },
	{ RETRIEVE_TASK_ERROR, "RETRIEVE_TASK_ERROR", "取回任务失败"},
	{ TYPE_NOT_MATCH, "TYPE_NOT_MATCH", "类型匹配错误"},
	{ QUERY_ERROR, "QUERY_ERROR", "查询条件有误"},
	{ ACTIVITY_QUERY_ERROR, "ACTIVITY_QUERY_ERROR", "活动信息记录未查到"},
	{ NULL_TASK, "NULL_TASK", "未找到相应的任务"},
	{ INVALID_CLASSNAME, "INVALID_CLASSNAME", "无效的类名"},
	{ URL_CANNOT_BE_CREATED, "URL_CANNOT_BE_CREATED", "没有找到相符的url"},
	{ INVALID_TRANSACTION, "INVALID_TRANSACTION", "无效的数据库事务对象"},
	{ THREAD_OPERATION_ERROR, "THREAD_OPERATION_ERROR", "线程操作有误"},
	{ RESOURCE_CANNOT_BE_INSTANCED, "RESOURCE_CANNOT_BE_INSTANCED", "资源无法被实例化"},
	{ METHOD_ERROR, "METHOD_ERROR", "方法操作执行有误"},
	{ INVALID_TRANSFORMER, "INVALID_TRANSFORMER", "无效的转化对象"},
	{ FILE_OPERATION_ERROR, "FILE_OPERATION_ERROR", "文件加载失败"},
	{ TASK_ASSIGNED_ERROR, "TASK_ASSIGNED_ERROR", "任务已拥有执行者"},
	{ EXECUTE_COMMAND_ERROR, "EXECUTE_COMMAND_ERROR", "执行命令捕获异常"},
	{ FILE_EXISTS_ERROR, "FILE_EXISTS_ERROR", "未找到相应的文件"},
	{ SUSPEND_OPERATION_ERROR, "SUSPEND_OPERATION_ERROR", "无效的挂起操作"},
	{ RESUME_OPERATION_ERROR, "RESUME_OPERATION_ERROR", "无效的解挂操作"},
	{ PAGE_ERROR, "PAGE_ERROR", "无效的分页操作"},
	{ TASK_CANDIDATE_ERROR, "TASK_CANDIDATE_ERROR", "任务尚有候选者，不能指派执行者"},
	{ INVALID_NAMING, "INVALID_NAMING", "无效的命名"},
	{ OPERATION_ERROR, "OPERATION_ERROR", "无效的操作"},
	{ TASK_ACTIVE_ERROR, "TASK_ACTIVE_ERROR", "当前任务不是活动节点"},
	{ VALUE_NOT_MATCH, "VALUE_NOT_MATCH", "所得值与参照值不统一"},
	{ EXECUTION_EXISTS, "EXECUTION_EXISTS", "存在流程执行"},
	{ EXECUTE_ACTIVITY_ERROR, "EXECUTE_ACTIVITY_ERROR", "活动事件执行异常"},
	
	};

}
