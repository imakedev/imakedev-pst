// Decompiled by DJ v3.12.12.96 Copyright 2011 Atanas Neshkov  Date: 5/27/2012 12:14:17 AM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   MissExamService.java

package th.co.aoe.imake.pst.backoffice.service;

import java.util.List;

import th.co.aoe.imake.pst.xstream.PstBreakDown;
import th.co.aoe.imake.pst.xstream.PstCost;
import th.co.aoe.imake.pst.xstream.PstEmployee;
import th.co.aoe.imake.pst.xstream.PstEmployeeStatus;
import th.co.aoe.imake.pst.xstream.PstEmployeeWorkMapping;
import th.co.aoe.imake.pst.xstream.PstJob;
import th.co.aoe.imake.pst.xstream.PstJobEmployee;
import th.co.aoe.imake.pst.xstream.PstJobPay;
import th.co.aoe.imake.pst.xstream.PstJobPayExt;
import th.co.aoe.imake.pst.xstream.PstJobWork;
import th.co.aoe.imake.pst.xstream.PstRoadPump;
import th.co.aoe.imake.pst.xstream.common.VResultMessage;


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
	
	// PstRoadPump
	public abstract VResultMessage searchPstRoadPump(
				PstRoadPump pstRoadPump);
	public abstract Long savePstRoadPump(PstRoadPump pstRoadPump);

	public abstract int updatePstRoadPump(PstRoadPump pstRoadPump);

	public abstract int deletePstRoadPump(PstRoadPump pstRoadPump, String service);

	public abstract PstRoadPump findPstRoadPumpById(Long long1);
	
	public abstract List listPstRoadPumpStatuses();
	public abstract PstRoadPump listPstRoadPumpMaster();
	
	// PstEmployeeStatus
	public abstract VResultMessage searchPstEmployeeStatus(
					PstEmployeeStatus pstEmployeeStatus);
	public abstract Long savePstEmployeeStatus(PstEmployeeStatus pstEmployeeStatus);

	public abstract int updatePstEmployeeStatus(PstEmployeeStatus pstEmployeeStatus);

	public abstract int deletePstEmployeeStatus(PstEmployeeStatus pstEmployeeStatus, String service);

	public abstract PstEmployeeStatus findPstEmployeeStatusById(Long long1);
	
	
	// PstEmployee
	public abstract VResultMessage searchPstEmployee(
					PstEmployee pstEmployee);
	public abstract Long savePstEmployee(PstEmployee pstEmployee);

	public abstract int updatePstEmployee(PstEmployee pstEmployee);

	public abstract int deletePstEmployee(PstEmployee pstEmployee, String service);

	public abstract PstEmployee findPstEmployeeById(Long long1); 
	
	public abstract List listPstPositions();
	public abstract List listPstTitles();
	
	// PstEmployeeWorkMapping
	public abstract VResultMessage searchPstEmployeeWorkMapping(
			PstEmployeeWorkMapping pstEmployeeWorkMapping);
	public abstract int setPstEmployeeWorkMapping(PstEmployeeWorkMapping pstEmployeeWorkMapping);
	public abstract List listPstEmployeeStatuses();
	public abstract List listPstRoadPumpNo();
	
	public abstract List listPstConcretes();
	public abstract VResultMessage searchPstJob(
			PstJob pstJob);
	public abstract Long savePstJob(PstJob pstJob);

	public abstract int updatePstJob(PstJob pstJob);

	public abstract int deletePstJob(PstJob pstJob, String service);

	public abstract PstJob findPstJobById(Long long1);
	public abstract PstJob listJobMaster(); 
	
	public abstract List listPstJobWorks(Long pjId,Long prpId);
	public abstract Long savePstJobWork(PstJobWork pstJobWork); 
	public abstract int deletePstJobWork(PstJobWork pstJobWork, String service);
	
	public abstract List listPstJobEmployees( Long pjId, Long peId);
	public abstract Long savePstJobEmployee(PstJobEmployee pstJobEmployee); 
	public abstract int deletePstJobEmployee(PstJobEmployee pstJobEmployee, String service);
	
	public abstract List listPstJobPays(Long pjId,Long pcId);
	public abstract Long savePstJobPay(PstJobPay pstJobPay); 
	public abstract int deletePstJobPay(PstJobPay pstJobPay, String service);
	
	public abstract List listPstJobPayExts( Long pjId,Long pjpeNo);
	public abstract Long savePstJobPayExt(PstJobPayExt pstJobPayExt); 
	public abstract int deletePstJobPayExt(PstJobPayExt pstJobPayExt, String service);
	public List searchObject(String query);
	public int executeQuery(String[] query);
	
}
