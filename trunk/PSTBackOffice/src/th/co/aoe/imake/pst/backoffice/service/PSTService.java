// Decompiled by DJ v3.12.12.96 Copyright 2011 Atanas Neshkov  Date: 5/27/2012 12:14:17 AM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   MissExamService.java

package th.co.aoe.imake.pst.backoffice.service;

import java.util.List;

import th.co.aoe.imake.pst.xstream.PstBreakDown;
import th.co.aoe.imake.pst.xstream.PstCost;
import th.co.aoe.imake.pst.xstream.PstRoadPump;
import th.co.aoe.imake.pst.xstream.common.VResultMessage;

/*
import th.co.aoe.imake.pst.xstream.ConsultantReport;
import th.co.aoe.imake.pst.xstream.CustomerReport;
import th.co.aoe.imake.pst.xstream.EPTNormReport;
import th.co.aoe.imake.pst.xstream.MissAccount;
import th.co.aoe.imake.pst.xstream.MissAccountGroup;
import th.co.aoe.imake.pst.xstream.MissAccountMapping;
import th.co.aoe.imake.pst.xstream.MissAccountSeriesMap;
import th.co.aoe.imake.pst.xstream.MissAttach;
import th.co.aoe.imake.pst.xstream.MissCandidate;
import th.co.aoe.imake.pst.xstream.MissCareerMaster;
import th.co.aoe.imake.pst.xstream.MissChoice;
import th.co.aoe.imake.pst.xstream.MissContact;
import th.co.aoe.imake.pst.xstream.MissDoc;
import th.co.aoe.imake.pst.xstream.MissEvaluationTemplate;
import th.co.aoe.imake.pst.xstream.MissExam;
import th.co.aoe.imake.pst.xstream.MissExamGroup;
import th.co.aoe.imake.pst.xstream.MissExamType;
import th.co.aoe.imake.pst.xstream.MissIndustryMaster;
import th.co.aoe.imake.pst.xstream.MissManual;
import th.co.aoe.imake.pst.xstream.MissQuestion;
import th.co.aoe.imake.pst.xstream.MissReactiveLog;
import th.co.aoe.imake.pst.xstream.MissSeriesAttach;
import th.co.aoe.imake.pst.xstream.MissSeriesMap;
import th.co.aoe.imake.pst.xstream.MissSery;
import th.co.aoe.imake.pst.xstream.MissSeryOrder;
import th.co.aoe.imake.pst.xstream.MissSeryProblem;
import th.co.aoe.imake.pst.xstream.MissSeryUse;
import th.co.aoe.imake.pst.xstream.MissSurveySend;
import th.co.aoe.imake.pst.xstream.MissSystemUse;
import th.co.aoe.imake.pst.xstream.MissTemplate;
import th.co.aoe.imake.pst.xstream.MissTest;
import th.co.aoe.imake.pst.xstream.MissTestResult;
import th.co.aoe.imake.pst.xstream.MissTheme;
import th.co.aoe.imake.pst.xstream.MissTodo;
import th.co.aoe.imake.pst.xstream.ProductReport;*/

public interface PSTService {
	// public findByUsername;
	// PstBreakDown
	public abstract VResultMessage searchPstBreakDown(
			PstBreakDown pstBreakDown);
	public abstract Long savePstBreakDown(PstBreakDown pstBreakDown);

	public abstract int updatePstBreakDown(PstBreakDown pstBreakDown);

	public abstract int deletePstBreakDown(PstBreakDown pstBreakDown, String service);

	public abstract PstBreakDown findPstBreakDownById(Long long1);
	
	// PstCost
	public abstract VResultMessage searchPstCost(
			PstCost pstCost);
	public abstract Long savePstCost(PstCost pstCost);

	public abstract int updatePstCost(PstCost pstCost);

	public abstract int deletePstCost(PstCost pstCost, String service);

	public abstract PstCost findPstCostById(Long long1);
	
	// PstCost
	public abstract VResultMessage searchPstRoadPump(
				PstRoadPump pstRoadPump);
	public abstract Long savePstRoadPump(PstRoadPump pstRoadPump);

	public abstract int updatePstRoadPump(PstRoadPump pstRoadPump);

	public abstract int deletePstRoadPump(PstRoadPump pstRoadPump, String service);

	public abstract PstRoadPump findPstRoadPumpById(Long long1);
	
	public abstract List listPstRoadPumpStatuses();
	public abstract PstRoadPump listPstRoadPumpMaster();
	/*	public abstract Long saveMissExamGroup(MissExamGroup missexamgroup);

	public abstract int deleteMissExamGroup(MissExamGroup missexamgroup);

	public abstract MissExamGroup findMissExamGroupById(Long long1);

	public abstract VResultMessage searchMissExamGroup(
			MissExamGroup missexamgroup);

	public abstract Long saveMissAccount(MissAccount missaccount);

	public abstract int updateMissAccount(MissAccount missaccount);

	public abstract int updateMissAccountLogo(MissAccount transientInstance);

	public abstract int deleteMissAccount(MissAccount missaccount, String s);

	public abstract MissAccount findMissAccountById(Long long1);

	public abstract VResultMessage searchMissAccount(MissAccount missaccount);

	public abstract MissAccount refillMissAccount(MissAccount missaccount);

	public abstract Long saveMissAccountSeriesMap(
			MissAccountSeriesMap missaccountseriesmap);

	public abstract int updateMissAccountSeriesMap(
			MissAccountSeriesMap missaccountseriesmap);

	public abstract int deleteMissAccountSeriesMap(
			MissAccountSeriesMap missaccountseriesmap);

	public abstract MissAccountSeriesMap findMissAccountSeriesMapById(Long long1);

	public abstract VResultMessage searchMissAccountSeriesMap(
			MissAccountSeriesMap missaccountseriesmap);

	public abstract MissCandidate saveMissCandidate(MissCandidate misscandidate);

	public abstract int updateMissCandidate(MissCandidate misscandidate);

	public abstract int updateMissCandidatePhoto(MissCandidate transientInstance);

	public abstract int deleteMissCandidate(MissCandidate misscandidate,
			String s);

	public abstract MissCandidate findMissCandidateById(Long long1);
	
	public abstract MissCandidate findMissCandidateByCitizendIdAndEmail(
			String citizendId, String email);
	

	public abstract VResultMessage searchMissCandidate(
			MissCandidate misscandidate);

	public abstract Long saveMissChoice(MissChoice misschoice);

	public abstract int updateMissChoice(MissChoice misschoice);

	public abstract int deleteMissChoice(MissChoice misschoice);

	public abstract MissChoice findMissChoiceById(Long long1);

	public abstract VResultMessage searchMissChoice(MissChoice misschoice);

	public abstract Long saveMissEvaluationTemplate(
			MissEvaluationTemplate missevaluationtemplate);

	public abstract int updateMissEvaluationTemplate(
			MissEvaluationTemplate missevaluationtemplate);

	public abstract int deleteMissEvaluationTemplate(
			MissEvaluationTemplate missevaluationtemplate);

	public abstract MissEvaluationTemplate findMissEvaluationTemplateById(
			Long long1);

	public abstract VResultMessage searchMissEvaluationTemplate(
			MissEvaluationTemplate missevaluationtemplate);

	public abstract Long saveMissExam(MissExam missexam);

	public abstract int updateMissExam(MissExam missexam);

	public abstract int deleteMissExam(MissExam missexam, String s);

	public abstract MissExam findMissExamById(Long long1);

	public abstract VResultMessage searchMissExam(MissExam missexam);

	public abstract int copyMissExam(MissExam missexam);

	public abstract int createEmptyMissExam(MissExam missexam);

	public abstract List listMissExam();

	public abstract Long saveMissExamType(MissExamType missexamtype);

	public abstract int updateMissExamType(MissExamType missexamtype);

	public abstract int deleteMissExamType(MissExamType missexamtype);

	public abstract MissExamType findMissExamTypeById(Long long1);

	public abstract VResultMessage searchMissExamType(MissExamType missexamtype);

	public abstract Long saveMissQuestion(MissQuestion missquestion);

	public abstract int updateMissQuestion(MissQuestion missquestion,
			String service);

	public abstract int deleteMissQuestion(MissQuestion missquestion);

	public abstract int setOrderItems(Long meId);

	public abstract MissQuestion findMissQuestionById(Long long1);

	public abstract VResultMessage searchMissQuestion(MissQuestion missquestion);

	public abstract List listMissQuestions(Long meId);

	public abstract Long saveMissSeriesMap(MissSeriesMap missseriesmap);

	public abstract int updateMissSeriesMap(MissSeriesMap missseriesmap);

	public abstract int deleteMissSeriesMap(MissSeriesMap missseriesmap);

	public abstract MissSeriesMap findMissSeriesMapById(Long long1);

	public abstract VResultMessage searchMissSeriesMap(
			MissSeriesMap missseriesmap);

	public abstract Long saveMissSery(MissSery misssery);

	public abstract int updateMissSery(MissSery misssery);

	public abstract int deleteMissSery(MissSery misssery, String s);

	public abstract MissSery findMissSeryById(Long long1);

	public abstract VResultMessage searchMissSery(MissSery misssery);

	public abstract List listMissSery();

	public abstract Long saveMissSurveySend(MissSurveySend misssurveysend);

	public abstract int updateMissSurveySend(MissSurveySend misssurveysend);

	public abstract int deleteMissSurveySend(MissSurveySend misssurveysend);

	public abstract MissSurveySend findMissSurveySendById(Long long1);

	public abstract VResultMessage searchMissSurveySend(
			MissSurveySend misssurveysend);

	public abstract Long saveMissTemplate(MissTemplate misstemplate);

	public abstract int updateMissTemplate(MissTemplate misstemplate);

	public abstract int deleteMissTemplate(MissTemplate misstemplate);

	public abstract MissTemplate findMissTemplateById(Long long1);

	public abstract VResultMessage searchMissTemplate(MissTemplate misstemplate);

	public abstract Long saveMissTest(MissTest misstest);

	public abstract int updateMissTest(MissTest misstest);

	public abstract int deleteMissTest(MissTest misstest);

	public abstract MissTest findMissTestById(Long long1);

	public abstract VResultMessage searchMissTest(MissTest misstest);

	public abstract Long saveMissTestResult(MissTestResult misstestresult);

	public abstract int updateMissTestResult(MissTestResult misstestresult);

	public abstract int deleteMissTestResult(MissTestResult misstestresult);

	public abstract MissTestResult findMissTestResultById(Long long1);

	public abstract VResultMessage searchMissTestResult(
			MissTestResult misstestresult);

	public abstract Long saveMissTodo(MissTodo misstodo);

	public abstract int updateMissTodo(MissTodo misstodo);

	public abstract int deleteMissTodo(MissTodo misstodo);

	public abstract MissTodo findMissTodoById(Long long1);

	public abstract VResultMessage searchMissTodo(MissTodo misstodo);

	// public abstract int updateMissTodoStatus(MissTodo misstodo);

	public abstract Long saveMissAttach(MissAttach missAttach);

	public abstract int updateMissAttach(MissAttach missAttach);

	public abstract int deleteMissAttach(MissAttach missAttach);

	public abstract MissAttach findMissAttachById(String matModule,
			Long matRef, String hotlink);

	public abstract VResultMessage searchMissAttach(MissAttach missAttach);

	public abstract Long saveMissContact(MissContact missContact);

	public abstract int updateMissContact(MissContact missContact);

	public abstract int updateMissContactPhoto(MissContact transientInstance);

	public abstract int deleteMissContact(MissContact missContact,
			String service);

	public abstract MissContact findMissContactById(Long long1);

	public abstract MissContact findMissContactByUsername(String username);
	
	public abstract int countMissContactByUsername(String username,Long id); 

	public abstract VResultMessage searchMissContact(MissContact missContact);

	public abstract List listContacts(Long long1, String mcontactType);

	public abstract Long saveMissManual(MissManual missManual);

	public abstract int updateMissManual(MissManual missManual);

	public abstract int deleteMissManual(MissManual missManual, String service);

	public abstract MissManual findMissManualById(Long long1);

	public abstract VResultMessage searchMissManual(MissManual missManual);
	
	public abstract Long saveMissDoc(MissDoc missDoc);
	public abstract int updateMissDoc(MissDoc missDoc) ;
	public abstract int deleteMissDoc(MissDoc missDoc) ;	
	public abstract MissDoc findMissDocById(Long mdId)  ;
	public abstract  VResultMessage searchMissDoc(MissDoc missDoc)  ;
	
	

	public abstract int updateMissSeriesAttach(MissSeriesAttach missSeriesAttach);

	public abstract int deleteMissSeriesAttach(MissSeriesAttach missSeriesAttach);

	public abstract MissSeriesAttach findMissSeriesAttachSearch(
			String matModule, Long matRef1, Long matRef2, String hotlink);

	// Add
	
	 * Service.java RService.java RService.java
	 
	public abstract Long saveRoleContact(RoleContact roleContact);

	public abstract int updateRoleContact(RoleContact roleContact);

	public abstract int deleteRoleContact(RoleContact roleContact,
			String service);

	public abstract RoleContact findRoleContactById(Long rcId);

	public abstract VResultMessage searchRoleContact(RoleContact roleContact);

	public abstract List listRoleContactBymaId(Long maId);

	public abstract Long saveRoleMapping(RoleMapping roleMapping);

	public abstract int updateRoleMapping(RoleMapping roleMapping);

	public abstract int deleteRoleMapping(RoleMapping roleMapping,
			String service);

	public abstract RoleMapping findRoleMappingById(Long rcId);

	public abstract VResultMessage searchRoleMapping(RoleMapping roleContact);

	public abstract List listRoleMappingByrcId(Long rcId);

	public abstract Long saveRoleType(RoleType roleType);

	public abstract int updateRoleType(RoleType roleType);

	public abstract int deleteRoleType(RoleType roleType, String service);

	public abstract RoleType findRoleTypeById(Long rcId);

	public abstract VResultMessage searchRoleType(RoleType roleContact);

	public abstract List listRoleTypeByRcId(Long rcId);

	public abstract List listRoleTypes(Long maId);

	public abstract int getQuestionOrdered(Long meId);

	public abstract int updateStatusMissTestResult(Long mtrId, String column,
			String value);
	public abstract int updateStatusMissTestResult(String mtrIds, String column, String value);
	public abstract List listMissTheme(MissTheme missTheme);

	public abstract MissTheme findMissThemeById(Long maId, Long mtId);

	public abstract List<MissCareerMaster> listMissCareerMaster();

	public abstract List<MissIndustryMaster> listMissIndustryMaster();

	// Report management
	public abstract int saveMissSystemUse(MissSystemUse transientInstance);

	public abstract List searchMissSystemUse(MissSystemUse persistentInstance);

	public Long saveMissSeryUse(MissSeryUse transientInstance);

	public abstract List searchMissSeryUse(MissSeryUse persistentInstance);

	public abstract Long saveMissSeryProblem(MissSeryProblem transientInstance);

	public abstract List searchMissSeryProblem(
			MissSeryProblem persistentInstance);

	public abstract Long saveMissSeryOrder(MissSeryOrder transientInstance);

	public abstract List searchMissSeryOrder(MissSeryOrder persistentInstance);

	public abstract Long saveMissReactiveLog(MissReactiveLog transientInstance);

	public abstract List searchMissReactiveLog(
			MissReactiveLog persistentInstance);

	

	public abstract List searchMissAccountMapping(
			MissAccountMapping persistentInstance);
	
	public abstract int sendSurvey(MissSurveySend misssurveysend);
	
	 public abstract VResultMessage exportMissCandidate(MissCandidate missCandidate);
	    
	
//	public abstract ProductReport findProductReport(String mode,String year);
	public abstract EPTNormReport findEPTNormReport(EPTNormReport eptNormReport);
	public abstract EPTNormReport findCompanies(EPTNormReport eptNormReport); 
	public abstract CustomerReport findCustomerReport(CustomerReport customerReport)  ;
	public abstract CustomerReport findGroups(CustomerReport customerReport); 
	public abstract ProductReport findProductReport(ProductReport productReport);
	public abstract ServiceReport findServiceReport(ServiceReport serviceReport);
	public abstract ConsultantReport findConsultantReport(ConsultantReport consultantReport);
	public abstract ConsultantReport findSales(ConsultantReport consultantReport);*/
}
