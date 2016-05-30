package com.test;
import org.jbpm.api.Configuration;
import org.jbpm.api.ExecutionService;
import org.jbpm.api.HistoryService;
import org.jbpm.api.IdentityService;
import org.jbpm.api.ManagementService;
import org.jbpm.api.ProcessEngine;
import org.jbpm.api.RepositoryService;
import org.jbpm.api.TaskService;


public class JBPM {
	private static ProcessEngine processEngine;
    private static RepositoryService repositoryService = null;
    private static ExecutionService executionService = null;
    private static TaskService taskService = null;
  
	private static HistoryService historyService = null;
    private static ManagementService managementService = null;
    private static IdentityService identityService = null;
    public JBPM(){
    	processEngine = Configuration.getProcessEngine();
    	setProcessEngine(processEngine);
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		JBPM jb=new JBPM();
//		Execution processInstance = executionService
//		.startProcessInstanceByKey("TimerTransition");
	}
	public  ProcessEngine getProcessEngine() {
		return processEngine;
	}
	public  void setProcessEngine(ProcessEngine processEngine) {
		JBPM.processEngine = processEngine;
        System.out.println((new StringBuilder("processEngine=")).append(processEngine).toString());
        repositoryService = processEngine.getRepositoryService();
        executionService = processEngine.getExecutionService();
        taskService = processEngine.getTaskService();
        historyService = processEngine.getHistoryService();
        managementService = processEngine.getManagementService();
        identityService = processEngine.getIdentityService();
	}
	public  RepositoryService getRepositoryService() {
		return repositoryService;
	}
	public  void setRepositoryService(RepositoryService repositoryService) {
		JBPM.repositoryService = repositoryService;
	}
	public  ExecutionService getExecutionService() {
		return executionService;
	}
	public  void setExecutionService(ExecutionService executionService) {
		JBPM.executionService = executionService;
	}
	public  TaskService getTaskService() {
		return taskService;
	}
	public static void setTaskService(TaskService taskService) {
		JBPM.taskService = taskService;
	}
	public  HistoryService getHistoryService() {
		return historyService;
	}
	public  void setHistoryService(HistoryService historyService) {
		JBPM.historyService = historyService;
	}
	public  ManagementService getManagementService() {
		return managementService;
	}
	public  void setManagementService(ManagementService managementService) {
		JBPM.managementService = managementService;
	}
	public  IdentityService getIdentityService() {
		return identityService;
	}
	public  void setIdentityService(IdentityService identityService) {
		JBPM.identityService = identityService;
	}

}
