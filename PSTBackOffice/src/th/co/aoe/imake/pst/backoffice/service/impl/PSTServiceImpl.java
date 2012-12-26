// Decompiled by DJ v3.12.12.96 Copyright 2011 Atanas Neshkov  Date: 5/27/2012 12:14:40 AM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   MissExamServiceImpl.java

package th.co.aoe.imake.pst.backoffice.service.impl;

import java.util.List;

import th.co.aoe.imake.pst.backoffice.service.PSTService;
import th.co.aoe.imake.pst.constant.ServiceConstant;
import th.co.aoe.imake.pst.xstream.PstBreakDown;
import th.co.aoe.imake.pst.xstream.PstCost;
import th.co.aoe.imake.pst.xstream.PstEmployee;
import th.co.aoe.imake.pst.xstream.PstEmployeeStatus;
import th.co.aoe.imake.pst.xstream.PstPosition;
import th.co.aoe.imake.pst.xstream.PstRoadPump;
import th.co.aoe.imake.pst.xstream.PstRoadPumpStatus;
import th.co.aoe.imake.pst.xstream.PstTitle;
import th.co.aoe.imake.pst.xstream.common.VResultMessage;

// Referenced classes of package th.co.aoe.imake.pst.exam.service.impl:
//            PostCommon

public class PSTServiceImpl extends PostCommon
    implements PSTService
{

    public PSTServiceImpl()
    {
    }
/*
    public Long saveMissExamGroup(MissExamGroup missExamGroup)
    {
        missExamGroup.setServiceName("saveMissExamGroup");
        VResultMessage resultMessage = postMessage(missExamGroup, missExamGroup.getClass().getName(), "missExamGroup", true);
        missExamGroup = (MissExamGroup)resultMessage.getResultListObj().get(0);
        return missExamGroup.getMegId();
    }

    public int updateMissExamGroup(MissExamGroup missExamGroup)
    {
        missExamGroup.setServiceName("updateMissExamGroup");
        VResultMessage resultMessage = postMessage(missExamGroup, missExamGroup.getClass().getName(), "missExamGroup", true);
        missExamGroup = (MissExamGroup)resultMessage.getResultListObj().get(0);
        return missExamGroup.getUpdateRecord().intValue();
    }

    public int deleteMissExamGroup(MissExamGroup missExamGroup)
    {
        missExamGroup.setServiceName("deleteMissExamGroup");
        VResultMessage resultMessage = postMessage(missExamGroup, missExamGroup.getClass().getName(), "missExamGroup", true);
        missExamGroup = (MissExamGroup)resultMessage.getResultListObj().get(0);
        return missExamGroup.getUpdateRecord().intValue();
    }

    public MissExamGroup findMissExamGroupById(Long megId)
    {
        MissExamGroup missExamGroup = new MissExamGroup();
        missExamGroup.setMegId(megId);
        missExamGroup.setServiceName("findMissExamGroupById");
        VResultMessage resultMessage = postMessage(missExamGroup, missExamGroup.getClass().getName(), "missExamGroup", true);
        return (MissExamGroup)resultMessage.getResultListObj().get(0);
    }

    public VResultMessage searchMissExamGroup(MissExamGroup missExamGroup)
    {
        missExamGroup.setServiceName("searchMissExamGroup");
        return postMessage(missExamGroup, missExamGroup.getClass().getName(), "missExamGroup", true);
    }

    public Long saveMissAccount(MissAccount missAccount)
    {
        missAccount.setServiceName("saveMissAccount");
        VResultMessage resultMessage = postMessage(missAccount, missAccount.getClass().getName(), "missAccount", true);
        missAccount = (MissAccount)resultMessage.getResultListObj().get(0);
        return missAccount.getMaId();
    }

    public int updateMissAccount(MissAccount missAccount)
    {
        missAccount.setServiceName("updateMissAccount");
        VResultMessage resultMessage = postMessage(missAccount, missAccount.getClass().getName(), "missAccount", true);
        missAccount = (MissAccount)resultMessage.getResultListObj().get(0);
        return missAccount.getUpdateRecord().intValue();
    }

    public int deleteMissAccount(MissAccount missAccount, String service)
    {
        missAccount.setServiceName(service);
        VResultMessage resultMessage = postMessage(missAccount, missAccount.getClass().getName(), "missAccount", true);
        missAccount = (MissAccount)resultMessage.getResultListObj().get(0);
        return missAccount.getUpdateRecord().intValue();
    }

    public MissAccount findMissAccountById(Long megId)
    {
        MissAccount missAccount = new MissAccount();
        missAccount.setMaId(megId);
        missAccount.setServiceName("findMissAccountById");
        VResultMessage resultMessage = postMessage(missAccount, missAccount.getClass().getName(), "missAccount", true);
        return (MissAccount)resultMessage.getResultListObj().get(0);
    }

    public VResultMessage searchMissAccount(MissAccount missAccount)
    {
        missAccount.setServiceName("searchMissAccount");
        return postMessage(missAccount, missAccount.getClass().getName(), "missAccount", true);
    }

    public Long saveMissAccountSeriesMap(MissAccountSeriesMap missAccountSeriesMap)
    {
        missAccountSeriesMap.setServiceName("saveMissAccountSeriesMap");
        VResultMessage resultMessage = postMessage(missAccountSeriesMap, missAccountSeriesMap.getClass().getName(), "missAccountSeriesMap", true);
        missAccountSeriesMap = (MissAccountSeriesMap)resultMessage.getResultListObj().get(0);
        return Long.valueOf(missAccountSeriesMap.getUpdateRecord());
    }

    public int updateMissAccountSeriesMap(MissAccountSeriesMap missAccountSeriesMap)
    {
        missAccountSeriesMap.setServiceName("updateMissAccountSeriesMap");
        VResultMessage resultMessage = postMessage(missAccountSeriesMap, missAccountSeriesMap.getClass().getName(), "missAccountSeriesMap", true);
        missAccountSeriesMap = (MissAccountSeriesMap)resultMessage.getResultListObj().get(0);
        return missAccountSeriesMap.getUpdateRecord().intValue();
    }

    public int deleteMissAccountSeriesMap(MissAccountSeriesMap missAccountSeriesMap)
    {
        missAccountSeriesMap.setServiceName("deleteMissAccountSeriesMap");
        VResultMessage resultMessage = postMessage(missAccountSeriesMap, missAccountSeriesMap.getClass().getName(), "missAccountSeriesMap", true);
        missAccountSeriesMap = (MissAccountSeriesMap)resultMessage.getResultListObj().get(0);
        return missAccountSeriesMap.getUpdateRecord().intValue();
    }

    public MissAccountSeriesMap findMissAccountSeriesMapById(Long megId)
    {
        return null;
    }

    public VResultMessage searchMissAccountSeriesMap(MissAccountSeriesMap missAccountSeriesMap)
    {
        missAccountSeriesMap.setServiceName("searchMissAccountSeriesMap");
        return postMessage(missAccountSeriesMap, missAccountSeriesMap.getClass().getName(), "missAccountSeriesMap", true);
    }

    public MissCandidate saveMissCandidate(MissCandidate missCandidate)
    {
        missCandidate.setServiceName("saveMissCandidate");
        VResultMessage resultMessage = postMessage(missCandidate, missCandidate.getClass().getName(), "missCandidate", true);
        missCandidate = (MissCandidate)resultMessage.getResultListObj().get(0);
        //return missCandidate.getMcaId(); 
        return missCandidate;
    }

    public int updateMissCandidate(MissCandidate missCandidate)
    {
        missCandidate.setServiceName("updateMissCandidate");
        VResultMessage resultMessage = postMessage(missCandidate, missCandidate.getClass().getName(), "missCandidate", true);
        missCandidate = (MissCandidate)resultMessage.getResultListObj().get(0);
        return missCandidate.getUpdateRecord().intValue();
    }

    public int deleteMissCandidate(MissCandidate missCandidate, String service)
    {
        missCandidate.setServiceName(service);
        VResultMessage resultMessage = postMessage(missCandidate, missCandidate.getClass().getName(), "missCandidate", true);
        missCandidate = (MissCandidate)resultMessage.getResultListObj().get(0);
        return missCandidate.getUpdateRecord().intValue();
    }

    public MissCandidate findMissCandidateById(Long megId)
    {
        MissCandidate missCandidate = new MissCandidate();
        missCandidate.setMcaId(megId);
        missCandidate.setServiceName(ServiceConstant.MISS_CANDIDATE_FIND_BY_ID);
        VResultMessage resultMessage = postMessage(missCandidate, missCandidate.getClass().getName(), "missCandidate", true);
        return (MissCandidate)resultMessage.getResultListObj().get(0);
    }

    public VResultMessage searchMissCandidate(MissCandidate missCandidate)
    {
        missCandidate.setServiceName("searchMissCandidate");
        return postMessage(missCandidate, missCandidate.getClass().getName(), "missCandidate", true);
    }
    public VResultMessage exportMissCandidate(MissCandidate missCandidate)
    {
        missCandidate.setServiceName(ServiceConstant.MISS_CANDIDATE_EXPORT);
        return postMessage(missCandidate, missCandidate.getClass().getName(), "missCandidate", true);
    }

    public Long saveMissChoice(MissChoice missChoice)
    {
        missChoice.setServiceName("saveMissChoice");
        VResultMessage resultMessage = postMessage(missChoice, missChoice.getClass().getName(), "missChoice", true);
        missChoice = (MissChoice)resultMessage.getResultListObj().get(0);
        return 1l;
    //    return missChoice.getMcId();
    }

    public int updateMissChoice(MissChoice missChoice)
    {
        missChoice.setServiceName("updateMissChoice");
        VResultMessage resultMessage = postMessage(missChoice, missChoice.getClass().getName(), "missChoice", true);
        missChoice = (MissChoice)resultMessage.getResultListObj().get(0);
        return missChoice.getUpdateRecord().intValue();
    }

    public int deleteMissChoice(MissChoice missChoice)
    {
        missChoice.setServiceName("deleteMissChoice");
        VResultMessage resultMessage = postMessage(missChoice, missChoice.getClass().getName(), "missChoice", true);
        missChoice = (MissChoice)resultMessage.getResultListObj().get(0);
        return missChoice.getUpdateRecord().intValue();
    }

    public MissChoice findMissChoiceById(Long megId)
    {
        MissChoice missChoice = new MissChoice();
       // missChoice.setMcId(megId);
        missChoice.setServiceName("findMissChoiceById");
        VResultMessage resultMessage = postMessage(missChoice, missChoice.getClass().getName(), "missChoice", true);
        return (MissChoice)resultMessage.getResultListObj().get(0);
    }

    public VResultMessage searchMissChoice(MissChoice missChoice)
    {
        missChoice.setServiceName("searchMissChoice");
        return postMessage(missChoice, missChoice.getClass().getName(), "missChoice", true);
    }

    public Long saveMissEvaluationTemplate(MissEvaluationTemplate missEvaluationTemplate)
    {
        missEvaluationTemplate.setServiceName("saveMissEvaluationTemplate");
        VResultMessage resultMessage = postMessage(missEvaluationTemplate, missEvaluationTemplate.getClass().getName(), "missEvaluationTemplate", true);
        missEvaluationTemplate = (MissEvaluationTemplate)resultMessage.getResultListObj().get(0);
       // return missEvaluationTemplate.getMetId();
        return 0l;
    }

    public int updateMissEvaluationTemplate(MissEvaluationTemplate missEvaluationTemplate)
    {
        missEvaluationTemplate.setServiceName("updateMissEvaluationTemplate");
        VResultMessage resultMessage = postMessage(missEvaluationTemplate, missEvaluationTemplate.getClass().getName(), "missEvaluationTemplate", true);
        missEvaluationTemplate = (MissEvaluationTemplate)resultMessage.getResultListObj().get(0);
        return missEvaluationTemplate.getUpdateRecord().intValue();
    }

    public int deleteMissEvaluationTemplate(MissEvaluationTemplate missEvaluationTemplate)
    {
        missEvaluationTemplate.setServiceName("deleteMissEvaluationTemplate");
        VResultMessage resultMessage = postMessage(missEvaluationTemplate, missEvaluationTemplate.getClass().getName(), "missEvaluationTemplate", true);
        missEvaluationTemplate = (MissEvaluationTemplate)resultMessage.getResultListObj().get(0);
        return missEvaluationTemplate.getUpdateRecord().intValue();
    }

    public MissEvaluationTemplate findMissEvaluationTemplateById(Long megId)
    {
        MissEvaluationTemplate missEvaluationTemplate = new MissEvaluationTemplate();
       // missEvaluationTemplate.setMetId(megId);
        missEvaluationTemplate.setServiceName("findMissEvaluationTemplateById");
        VResultMessage resultMessage = postMessage(missEvaluationTemplate, missEvaluationTemplate.getClass().getName(), "missEvaluationTemplate", true);
        return (MissEvaluationTemplate)resultMessage.getResultListObj().get(0);
    }

    public VResultMessage searchMissEvaluationTemplate(MissEvaluationTemplate missEvaluationTemplate)
    {
        missEvaluationTemplate.setServiceName("searchMissEvaluationTemplate");
        return postMessage(missEvaluationTemplate, missEvaluationTemplate.getClass().getName(), "missEvaluationTemplate", true);
    }

    public Long saveMissExam(MissExam missExam)
    {
        missExam.setServiceName("saveMissExam");
        VResultMessage resultMessage = postMessage(missExam, missExam.getClass().getName(), "missExam", true);
        missExam = (MissExam)resultMessage.getResultListObj().get(0);
        return missExam.getMeId();
    }

    public int updateMissExam(MissExam missExam)
    {
        missExam.setServiceName("updateMissExam");
        VResultMessage resultMessage = postMessage(missExam, missExam.getClass().getName(), "missExam", true);
       // System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx="+resultMessage);
        missExam = (MissExam)resultMessage.getResultListObj().get(0);
        return missExam.getUpdateRecord().intValue();
    }
	@Override
	public int copyMissExam(MissExam missExam) {
		// TODO Auto-generated method stub
			missExam.setServiceName(ServiceConstant.MISS_EXAM_COPY);
	        VResultMessage resultMessage = postMessage(missExam, missExam.getClass().getName(), "missExam", true);
	        missExam = (MissExam)resultMessage.getResultListObj().get(0);
	        return missExam.getUpdateRecord().intValue();
	} 
	@Override
	public int createEmptyMissExam(MissExam missExam) {
		// TODO Auto-generated method stub
			missExam.setServiceName(ServiceConstant.MISS_EXAM_CREATE_EMPTY);
	        VResultMessage resultMessage = postMessage(missExam, missExam.getClass().getName(), "missExam", true);
	        missExam = (MissExam)resultMessage.getResultListObj().get(0);
	        return missExam.getUpdateRecord().intValue();
	}
    public int deleteMissExam(MissExam missExam, String service)
    
    {
        missExam.setServiceName(service);
        VResultMessage resultMessage = postMessage(missExam, missExam.getClass().getName(), "missExam", true);
        missExam = (MissExam)resultMessage.getResultListObj().get(0);
        return missExam.getUpdateRecord().intValue();
    }

    public MissExam findMissExamById(Long megId)
    {
        MissExam missExam = new MissExam();
        missExam.setMeId(megId);
        missExam.setServiceName("findMissExamById");
        VResultMessage resultMessage = postMessage(missExam, missExam.getClass().getName(), "missExam", true);
        return (MissExam)resultMessage.getResultListObj().get(0);
    }

    public VResultMessage searchMissExam(MissExam missExam)
    {
        missExam.setServiceName("searchMissExam");
        return postMessage(missExam, missExam.getClass().getName(), "missExam", true);
    }

    public List listMissExam()
    {
        MissExam missExam = new MissExam();
        missExam.setServiceName("listMissExam");
        VResultMessage resultMessage = postMessage(missExam, missExam.getClass().getName(), "missExam", true);
        return resultMessage.getResultListObj();
    }

    public List listMissSery()
    {
        MissSery missSery = new MissSery();
        missSery.setServiceName("listMissSeries");
        VResultMessage resultMessage = postMessage(missSery, missSery.getClass().getName(), "missSery", true);
        return resultMessage.getResultListObj();
    }

    public Long saveMissExamType(MissExamType missExamType)
    {
        missExamType.setServiceName("saveMissExamType");
        VResultMessage resultMessage = postMessage(missExamType, missExamType.getClass().getName(), "missExamType", true);
        missExamType = (MissExamType)resultMessage.getResultListObj().get(0);
        return missExamType.getMetId();
    }

    public int updateMissExamType(MissExamType missExamType)
    {
        missExamType.setServiceName("updateMissExamType");
        VResultMessage resultMessage = postMessage(missExamType, missExamType.getClass().getName(), "missExamType", true);
      
        missExamType = (MissExamType)resultMessage.getResultListObj().get(0);
        return missExamType.getUpdateRecord().intValue();
    }

    public int deleteMissExamType(MissExamType missExamType)
    {
        missExamType.setServiceName("deleteMissExamType");
        VResultMessage resultMessage = postMessage(missExamType, missExamType.getClass().getName(), "missExamType", true);
        missExamType = (MissExamType)resultMessage.getResultListObj().get(0);
        return missExamType.getUpdateRecord().intValue();
    }

    public MissExamType findMissExamTypeById(Long megId)
    {
        MissExamType missExamType = new MissExamType();
        missExamType.setMetId(megId);
        missExamType.setServiceName("findMissExamTypeById");
        VResultMessage resultMessage = postMessage(missExamType, missExamType.getClass().getName(), "missExamType", true);
        return (MissExamType)resultMessage.getResultListObj().get(0);
    }

    public VResultMessage searchMissExamType(MissExamType missExamType)
    {
        missExamType.setServiceName("searchMissExamType");
        return postMessage(missExamType, missExamType.getClass().getName(), "missExamType", true);
    }

    public Long saveMissQuestion(MissQuestion missQuestion)
    {
        //missQuestion.setServiceName("saveMissQuestion");
    	missQuestion.setServiceName(ServiceConstant.MISS_QUESTION_SAVE);//);
        VResultMessage resultMessage = postMessage(missQuestion, missQuestion.getClass().getName(), "missQuestion", true);
        missQuestion = (MissQuestion)resultMessage.getResultListObj().get(0);
        return missQuestion.getMqId();
    }

    public int updateMissQuestion(MissQuestion missQuestion,String service)
    {
        //missQuestion.setServiceName("updateMissQuestion");
    	missQuestion.setServiceName(service);
        VResultMessage resultMessage = postMessage(missQuestion, missQuestion.getClass().getName(), "missQuestion", true);
        missQuestion = (MissQuestion)resultMessage.getResultListObj().get(0);
        return missQuestion.getUpdateRecord().intValue();
    }

    public int deleteMissQuestion(MissQuestion missQuestion)
    {
        missQuestion.setServiceName("deleteMissQuestion");
        VResultMessage resultMessage = postMessage(missQuestion, missQuestion.getClass().getName(), "missQuestion", true);
        missQuestion = (MissQuestion)resultMessage.getResultListObj().get(0);
        return missQuestion.getUpdateRecord().intValue();
    }

    public MissQuestion findMissQuestionById(Long megId)
    {
        MissQuestion missQuestion = new MissQuestion();
        missQuestion.setMqId(megId);
        missQuestion.setServiceName("findMissQuestionById");
        VResultMessage resultMessage = postMessage(missQuestion, missQuestion.getClass().getName(), "missQuestion", true);
        return (MissQuestion)resultMessage.getResultListObj().get(0);
    }

    public VResultMessage searchMissQuestion(MissQuestion missQuestion)
    {
        missQuestion.setServiceName("searchMissQuestion");
        return postMessage(missQuestion, missQuestion.getClass().getName(), "missQuestion", true);
    }
    
    public   List listMissQuestions(Long meId){
    	
    	 MissExam missExam = new MissExam();
    	 missExam.setMeId(meId);
    	 
    	 MissQuestion missQuestion =new MissQuestion();
    	 missQuestion.setServiceName(ServiceConstant.MISS_QUESTION_LIST);
         missQuestion.setMissExam(missExam);
         VResultMessage resultMessage = postMessage(missQuestion, missQuestion.getClass().getName(), "missQuestion", true);
         return resultMessage.getResultListObj();
    }

    public int getQuestionOrdered(Long meId)
    {
    	 MissExam missExam = new MissExam();
    	 missExam.setMeId(meId);
    	 
    	 MissQuestion missQuestion =new MissQuestion();
    	 missQuestion.setServiceName(ServiceConstant.MISS_QUESTION_GET_ORDERED);
         missQuestion.setMissExam(missExam);
        VResultMessage resultMessage = postMessage(missQuestion, missQuestion.getClass().getName(), "missQuestion", true);
        missQuestion = (MissQuestion)resultMessage.getResultListObj().get(0);
        return missQuestion.getUpdateRecord().intValue();
    }
    public int setOrderItems(Long meId)
    {
   	 MissExam missExam = new MissExam();
   	 missExam.setMeId(meId);
   	 
   	 MissQuestion missQuestion =new MissQuestion();
   	 missQuestion.setServiceName(ServiceConstant.MISS_QUESTION_SET_ORDERED_ITEMS);
        missQuestion.setMissExam(missExam);
       VResultMessage resultMessage = postMessage(missQuestion, missQuestion.getClass().getName(), "missQuestion", true);
       missQuestion = (MissQuestion)resultMessage.getResultListObj().get(0);
       return missQuestion.getUpdateRecord().intValue();
   }
    
    public Long saveMissSeriesMap(MissSeriesMap missSeriesMap)
    {
        return null;
    }

    public int updateMissSeriesMap(MissSeriesMap missSeriesMap)
    {
        missSeriesMap.setServiceName("updateMissSeriesMap");
        VResultMessage resultMessage = postMessage(missSeriesMap, missSeriesMap.getClass().getName(), "missSeriesMap", true);
        missSeriesMap = (MissSeriesMap)resultMessage.getResultListObj().get(0);
        return missSeriesMap.getUpdateRecord().intValue();
    }

    public int deleteMissSeriesMap(MissSeriesMap missSeriesMap)
    {
        missSeriesMap.setServiceName("deleteMissSeriesMap");
        VResultMessage resultMessage = postMessage(missSeriesMap, missSeriesMap.getClass().getName(), "missSeriesMap", true);
        missSeriesMap = (MissSeriesMap)resultMessage.getResultListObj().get(0);
        return missSeriesMap.getUpdateRecord().intValue();
    }

    public MissSeriesMap findMissSeriesMapById(Long megId)
    {
        MissSeriesMap missSeriesMap = new MissSeriesMap();
        missSeriesMap.setMsId(megId);
        missSeriesMap.setServiceName("findMissSeriesMapById");
        VResultMessage resultMessage = postMessage(missSeriesMap, missSeriesMap.getClass().getName(), "missSeriesMap", true);
        return (MissSeriesMap)resultMessage.getResultListObj().get(0);
    }

    public VResultMessage searchMissSeriesMap(MissSeriesMap missSeriesMap)
    {
        missSeriesMap.setServiceName("searchMissSeriesMap");
        return postMessage(missSeriesMap, missSeriesMap.getClass().getName(), "missSeriesMap", true);
    }

    public Long saveMissSery(MissSery missSery)
    {
        missSery.setServiceName("saveMissSery");
        VResultMessage resultMessage = postMessage(missSery, missSery.getClass().getName(), "missSery", true);
        missSery = (MissSery)resultMessage.getResultListObj().get(0);
        return Long.valueOf(missSery.getUpdateRecord());
        //return missSery.getMsId();
    }

    public int updateMissSery(MissSery missSery)
    {
        missSery.setServiceName("updateMissSery");
        VResultMessage resultMessage = postMessage(missSery, missSery.getClass().getName(), "missSery", true);
        missSery = (MissSery)resultMessage.getResultListObj().get(0);
        return missSery.getUpdateRecord().intValue();
    }

    public int deleteMissSery(MissSery missSery, String service)
    {
        missSery.setServiceName(service);
        VResultMessage resultMessage = postMessage(missSery, missSery.getClass().getName(), "missSery", true);
        missSery = (MissSery)resultMessage.getResultListObj().get(0);
        return missSery.getUpdateRecord().intValue();
    }

    public MissSery findMissSeryById(Long megId)
    {
        MissSery missSery = new MissSery();
        missSery.setMsId(megId);
        missSery.setServiceName("findMissSeryById");
        VResultMessage resultMessage = postMessage(missSery, missSery.getClass().getName(), "missSery", true);
        return (MissSery)resultMessage.getResultListObj().get(0);
    }

    public VResultMessage searchMissSery(MissSery missSery)
    {
        missSery.setServiceName("searchMissSery");
        return postMessage(missSery, missSery.getClass().getName(), "missSery", true);
    }

    public Long saveMissSurveySend(MissSurveySend missSurveySend)
    {
        missSurveySend.setServiceName("saveMissSurveySend");
        VResultMessage resultMessage = postMessage(missSurveySend, missSurveySend.getClass().getName(), "missSurveySend", true);
        missSurveySend = (MissSurveySend)resultMessage.getResultListObj().get(0);
        return missSurveySend.getMssId();
    }

    public int updateMissSurveySend(MissSurveySend missSurveySend)
    {
        missSurveySend.setServiceName("updateMissSurveySend");
        VResultMessage resultMessage = postMessage(missSurveySend, missSurveySend.getClass().getName(), "missSurveySend", true);
        missSurveySend = (MissSurveySend)resultMessage.getResultListObj().get(0);
        return missSurveySend.getUpdateRecord().intValue();
    }

    public int deleteMissSurveySend(MissSurveySend missSurveySend)
    {
        missSurveySend.setServiceName("deleteMissSurveySend");
        VResultMessage resultMessage = postMessage(missSurveySend, missSurveySend.getClass().getName(), "missSurveySend", true);
        missSurveySend = (MissSurveySend)resultMessage.getResultListObj().get(0);
        return missSurveySend.getUpdateRecord().intValue();
    }

    public MissSurveySend findMissSurveySendById(Long megId)
    {
        MissSurveySend missSurveySend = new MissSurveySend();
        missSurveySend.setMssId(megId);
        missSurveySend.setServiceName("findMissSurveySendById");
        VResultMessage resultMessage = postMessage(missSurveySend, missSurveySend.getClass().getName(), "missSurveySend", true);
        return (MissSurveySend)resultMessage.getResultListObj().get(0);
    }

    public VResultMessage searchMissSurveySend(MissSurveySend missSurveySend)
    {
        missSurveySend.setServiceName("searchMissSurveySend");
        return postMessage(missSurveySend, missSurveySend.getClass().getName(), "missSurveySend", true);
    }

    public Long saveMissTemplate(MissTemplate missTemplate)
    {
        missTemplate.setServiceName("saveMissTemplate");
        VResultMessage resultMessage = postMessage(missTemplate, missTemplate.getClass().getName(), "missTemplate", true);
        missTemplate = (MissTemplate)resultMessage.getResultListObj().get(0);
        return missTemplate.getMtId();
    }

    public int updateMissTemplate(MissTemplate missTemplate)
    {
        missTemplate.setServiceName("updateMissTemplate");
        VResultMessage resultMessage = postMessage(missTemplate, missTemplate.getClass().getName(), "missTemplate", true);
        missTemplate = (MissTemplate)resultMessage.getResultListObj().get(0);
        return missTemplate.getUpdateRecord().intValue();
    }

    public int deleteMissTemplate(MissTemplate missTemplate)
    {
        missTemplate.setServiceName("deleteMissTemplate");
        VResultMessage resultMessage = postMessage(missTemplate, missTemplate.getClass().getName(), "missTemplate", true);
        missTemplate = (MissTemplate)resultMessage.getResultListObj().get(0);
        return missTemplate.getUpdateRecord().intValue();
    }

    public MissTemplate findMissTemplateById(Long megId)
    {
        MissTemplate missTemplate = new MissTemplate();
        missTemplate.setMtId(megId);
        missTemplate.setServiceName("findMissTemplateById");
        VResultMessage resultMessage = postMessage(missTemplate, missTemplate.getClass().getName(), "missTemplate", true);
        return (MissTemplate)resultMessage.getResultListObj().get(0);
    }

    public VResultMessage searchMissTemplate(MissTemplate missTemplate)
    {
        missTemplate.setServiceName("searchMissTemplate");
        return postMessage(missTemplate, missTemplate.getClass().getName(), "missTemplate", true);
    }

    public Long saveMissTest(MissTest missTest)
    {
        missTest.setServiceName("saveMissTest");
        VResultMessage resultMessage = postMessage(missTest, missTest.getClass().getName(), "missTest", true);
        missTest = (MissTest)resultMessage.getResultListObj().get(0);
        return 1l;
        //  return missTest.getMtestId();
    }

    public int updateMissTest(MissTest missTest)
    {
        missTest.setServiceName("updateMissTest");
        VResultMessage resultMessage = postMessage(missTest, missTest.getClass().getName(), "missTest", true);
        missTest = (MissTest)resultMessage.getResultListObj().get(0);
        return missTest.getUpdateRecord().intValue();
    }

    public int deleteMissTest(MissTest missTest)
    {
        missTest.setServiceName("deleteMissTest");
        VResultMessage resultMessage = postMessage(missTest, missTest.getClass().getName(), "missTest", true);
        missTest = (MissTest)resultMessage.getResultListObj().get(0);
        return missTest.getUpdateRecord().intValue();
    }

    public MissTest findMissTestById(Long megId)
    {
        MissTest missTest = new MissTest();
       // missTest.setMtestId(megId);
        missTest.setServiceName("findMissTestById");
        VResultMessage resultMessage = postMessage(missTest, missTest.getClass().getName(), "missTest", true);
        return (MissTest)resultMessage.getResultListObj().get(0);
    }

    public VResultMessage searchMissTest(MissTest missTest)
    {
        missTest.setServiceName("searchMissTest");
        return postMessage(missTest, missTest.getClass().getName(), "missTest", true);
    }

    public Long saveMissTestResult(MissTestResult missTestResult)
    {
        missTestResult.setServiceName("saveMissTestResult");
        VResultMessage resultMessage = postMessage(missTestResult, missTestResult.getClass().getName(), "missTestResult", true);
        missTestResult = (MissTestResult)resultMessage.getResultListObj().get(0);
        return missTestResult.getMtrId();
    }

    public int updateMissTestResult(MissTestResult missTestResult)
    {
        missTestResult.setServiceName("updateMissTestResult");
        VResultMessage resultMessage = postMessage(missTestResult, missTestResult.getClass().getName(), "missTestResult", true);
        missTestResult = (MissTestResult)resultMessage.getResultListObj().get(0);
        return missTestResult.getUpdateRecord().intValue();
    }

    public int deleteMissTestResult(MissTestResult missTestResult)
    {
        missTestResult.setServiceName("deleteMissTestResult");
        VResultMessage resultMessage = postMessage(missTestResult, missTestResult.getClass().getName(), "missTestResult", true);
        missTestResult = (MissTestResult)resultMessage.getResultListObj().get(0);
        return missTestResult.getUpdateRecord().intValue();
    }

    public MissTestResult findMissTestResultById(Long megId)
    {
        MissTestResult missTestResult = new MissTestResult();
        missTestResult.setMtrId(megId);
        missTestResult.setServiceName("findMissTestResultById");
        VResultMessage resultMessage = postMessage(missTestResult, missTestResult.getClass().getName(), "missTestResult", true);
        return (MissTestResult)resultMessage.getResultListObj().get(0);
    }

    public VResultMessage searchMissTestResult(MissTestResult missTestResult)
    {
        missTestResult.setServiceName(ServiceConstant.MISS_TEST_RESULT_SEARCH);
        return postMessage(missTestResult, missTestResult.getClass().getName(), "missTestResult", true);
    }

    public Long saveMissTodo(MissTodo missTodo)
    {
        missTodo.setServiceName("saveMissTodo");
        VResultMessage resultMessage = postMessage(missTodo, missTodo.getClass().getName(), "missTodo", true);
        missTodo = (MissTodo)resultMessage.getResultListObj().get(0);
        return missTodo.getMtodoId();
    }

    public int updateMissTodo(MissTodo missTodo)
    {
        missTodo.setServiceName("updateMissTodo");
        VResultMessage resultMessage = postMessage(missTodo, missTodo.getClass().getName(), "missTodo", true);
        missTodo = (MissTodo)resultMessage.getResultListObj().get(0);
        return missTodo.getUpdateRecord().intValue();
    }

    public int deleteMissTodo(MissTodo missTodo)
    {
        missTodo.setServiceName("deleteMissTodo");
        VResultMessage resultMessage = postMessage(missTodo, missTodo.getClass().getName(), "missTodo", true);
        missTodo = (MissTodo)resultMessage.getResultListObj().get(0);
        return missTodo.getUpdateRecord().intValue();
    }

    public MissTodo findMissTodoById(Long megId)
    {
        MissTodo missTodo = new MissTodo();
        missTodo.setMtodoId(megId);
        missTodo.setServiceName("findMissTodoById");
        VResultMessage resultMessage = postMessage(missTodo, missTodo.getClass().getName(), "missTodo", true);
        return (MissTodo)resultMessage.getResultListObj().get(0);
    }

    public VResultMessage searchMissTodo(MissTodo missTodo)
    {
        missTodo.setServiceName("searchMissTodo");
        return postMessage(missTodo, missTodo.getClass().getName(), "missTodo", true);
    }
 
     
    public Long saveMissAttach(MissAttach missAttach)
    {
        missAttach.setServiceName("saveMissAttach");
        VResultMessage resultMessage = postMessage(missAttach, missAttach.getClass().getName(), "missAttach", true);
        missAttach = (MissAttach)resultMessage.getResultListObj().get(0);
        return missAttach.getMatId();
    }

    public int updateMissAttach(MissAttach missAttach)
    {
        missAttach.setServiceName(ServiceConstant.MISS_ATTACH_UPDATE);
        VResultMessage resultMessage = postMessage(missAttach, missAttach.getClass().getName(), "missAttach", true);
        missAttach = (MissAttach)resultMessage.getResultListObj().get(0);
        return missAttach.getUpdateRecord().intValue();
    }

    public int deleteMissAttach(MissAttach missAttach)
    {
        missAttach.setServiceName("deleteMissAttach");
        VResultMessage resultMessage = postMessage(missAttach, missAttach.getClass().getName(), "missAttach", true);
        missAttach = (MissAttach)resultMessage.getResultListObj().get(0);
        return missAttach.getUpdateRecord().intValue();
    }

    public MissAttach findMissAttachById(String matModule,Long matRef,String hotlink)
    {
        MissAttach missAttach = new MissAttach();
        missAttach.setMatModule(matModule);
        missAttach.setMatHotlink(hotlink);
        missAttach.setMatRef(matRef);
        missAttach.setServiceName("findMissAttachById");
        VResultMessage resultMessage = postMessage(missAttach, missAttach.getClass().getName(), "missAttach", true);
        return (MissAttach)resultMessage.getResultListObj().get(0);
    }

    public VResultMessage searchMissAttach(MissAttach missAttach)
    {
        missAttach.setServiceName("searchMissAttach");
        return postMessage(missAttach, missAttach.getClass().getName(), "missAttach", true);
    }
    
	@Override
	public Long saveMissContact(MissContact missContact) {
		// TODO Auto-generated method stub
		missContact.setServiceName(ServiceConstant.MISS_CONTACT_SAVE);
	    VResultMessage resultMessage = postMessage(missContact, missContact.getClass().getName(), "missContact", true);
	    missContact = (MissContact)resultMessage.getResultListObj().get(0);
	    return missContact.getMcontactId();
	}

	@Override
	public int updateMissContact(MissContact missContact) {
		// TODO Auto-generated method stub
		missContact.setServiceName(ServiceConstant.MISS_CONTACT_UPDATE);
        VResultMessage resultMessage = postMessage(missContact, missContact.getClass().getName(), "missContact", true);
        missContact = (MissContact)resultMessage.getResultListObj().get(0);
        return missContact.getUpdateRecord().intValue();
	}

	@Override
	public int deleteMissContact(MissContact missContact,String service) {
		// TODO Auto-generated method stub
		missContact.setServiceName(service);
        VResultMessage resultMessage = postMessage(missContact, missContact.getClass().getName(), "missContact", true);
        missContact = (MissContact)resultMessage.getResultListObj().get(0);
        return missContact.getUpdateRecord().intValue();
	}

	@Override
	public MissContact findMissContactById(Long long1) {
		// TODO Auto-generated method stub
		 MissContact missContact = new MissContact();
	        missContact.setMcontactId(long1);
	        missContact.setServiceName(ServiceConstant.MISS_CONTACT_FIND_BY_ID);
	        VResultMessage resultMessage = postMessage(missContact, missContact.getClass().getName(), "missContact", true);
	        return (MissContact)resultMessage.getResultListObj().get(0);
	}
	@Override
	public th.co.aoe.imake.pst.xstream.MissContact findMissContactByUsername(String username) {
		// TODO Auto-generated method stub
		 MissContact missContact = new MissContact();
	        missContact.setMcontactUsername(username);
	        missContact.setServiceName(ServiceConstant.MISS_CONTACT_FIND_BY_USERNAME);
	        VResultMessage resultMessage = postMessage(missContact, missContact.getClass().getName(), "missContact", true);
	        return (MissContact)resultMessage.getResultListObj().get(0);
	}
	

	@Override
	public VResultMessage searchMissContact(MissContact missContact) {
		// TODO Auto-generated method stub
		missContact.setServiceName(ServiceConstant.MISS_CONTACT_SEARCH);
        return postMessage(missContact, missContact.getClass().getName(), "missContact", true);
	}
	 
	public List listContacts(Long long1,String mcontactType)
	    {
		 
	        MissContact missContact = new MissContact();
	        missContact.setMcontactRef(long1);
	        missContact.setMcontactType(mcontactType);
	        missContact.setServiceName(ServiceConstant.MISS_CONTACT_LIST);
	        VResultMessage resultMessage = postMessage(missContact, missContact.getClass().getName(), "missContact", true);
	        return resultMessage.getResultListObj();
	    }
	@Override
	public Long saveMissManual(MissManual missManual) {
		// TODO Auto-generated method stub
		missManual.setServiceName(ServiceConstant.MISS_MANUAL_SAVE);
	    VResultMessage resultMessage = postMessage(missManual, missManual.getClass().getName(), "missManual", true);
	    missManual = (MissManual)resultMessage.getResultListObj().get(0);
	    return missManual.getMmId();
	}

	@Override
	public int updateMissManual(MissManual missManual) {
		// TODO Auto-generated method stub
		missManual.setServiceName(ServiceConstant.MISS_MANUAL_UPDATE);
        VResultMessage resultMessage = postMessage(missManual, missManual.getClass().getName(), "missManual", true);
        missManual = (MissManual)resultMessage.getResultListObj().get(0);
        return missManual.getUpdateRecord().intValue();
	}

	@Override
	public int deleteMissManual(MissManual missManual,String service) {
		// TODO Auto-generated method stub
		missManual.setServiceName(service);
        VResultMessage resultMessage = postMessage(missManual, missManual.getClass().getName(), "missManual", true);
        missManual = (MissManual)resultMessage.getResultListObj().get(0);
        return missManual.getUpdateRecord().intValue();
	}

	@Override
	public MissManual findMissManualById(Long long1) {
		// TODO Auto-generated method stub
		 MissManual missManual = new MissManual();
	        missManual.setMmId(long1);
	        missManual.setServiceName(ServiceConstant.MISS_MANUAL_FIND_BY_ID);
	        VResultMessage resultMessage = postMessage(missManual, missManual.getClass().getName(), "missManual", true);
	        if(resultMessage!=null && resultMessage.getResultListObj()!=null && resultMessage.getResultListObj().size()>0)
	        	return (MissManual)resultMessage.getResultListObj().get(0);
	        return null;
	}

	@Override
	public VResultMessage searchMissManual(MissManual missManual) {
		// TODO Auto-generated method stub
		missManual.setServiceName(ServiceConstant.MISS_MANUAL_SEARCH);
        return postMessage(missManual, missManual.getClass().getName(), "missManual", true);
	}
	@Override
	public int updateMissAccountLogo(MissAccount missAccount) {
		// TODO Auto-generated method stub
		missAccount.setServiceName(ServiceConstant.MISS_ACCOUNT_UPDATE_LOGO);
	    VResultMessage resultMessage = postMessage(missAccount, missAccount.getClass().getName(), "missAccount", true);
	    missAccount = (MissAccount)resultMessage.getResultListObj().get(0);
	    return missAccount.getUpdateRecord().intValue();
	}

	@Override
	public int updateMissCandidatePhoto(MissCandidate missCandidate) {
		// TODO Auto-generated method stub
		missCandidate.setServiceName(ServiceConstant.MISS_CANDIDATE_UPDATE_PHOTO);
	    VResultMessage resultMessage = postMessage(missCandidate, missCandidate.getClass().getName(), "missCandidate", true);
	    missCandidate = (MissCandidate)resultMessage.getResultListObj().get(0);
	    return missCandidate.getUpdateRecord().intValue();
	}

	@Override
	public int updateMissContactPhoto(MissContact missContact) {
		// TODO Auto-generated method stub
		missContact.setServiceName(ServiceConstant.MISS_CONTACT_UPDATE_PHOTO);
	    VResultMessage resultMessage = postMessage(missContact, missContact.getClass().getName(), "missContact", true);
	    missContact = (MissContact)resultMessage.getResultListObj().get(0);
	    return missContact.getUpdateRecord().intValue();
	}

	@Override
	public MissAccount refillMissAccount(MissAccount missAccount) {
		// TODO Auto-generated method stub
		missAccount.setServiceName(ServiceConstant.MISS_ACCOUNT_REFILL);
	    VResultMessage resultMessage = postMessage(missAccount, missAccount.getClass().getName(), "missAccount", true);
        return (MissAccount)resultMessage.getResultListObj().get(0);
	}
    public static void main(String args[])
    {
    	

        MissExamServiceImpl main = new MissExamServiceImpl();
   	 List<MissQuestion> misses=ReadWriteWorkbook_bk.setQuestion();
        List<MissQuestion> missQuestions = main.listMissQuestions(36l);
        //main.searchMissChoice(missChoice)
        System.out.println(missQuestions.get(0).getMissChoicesUpdate());
      
        // update question 
        for (MissQuestion miss : misses) {
        	MissQuestion missQuestion =missQuestions.get(miss.getMqId().intValue()-1);
        	missQuestion.setMqNameTh1(miss.getMqNameTh1());
        	 main.updateMissQuestion(missQuestion, "updateMissQuestion");
		}
        main.testMissQuestion();
		
        MissQuestion missQuestion =missQuestions.get(0);
        missQuestion.setMqNameTh1(misses.get(0).getMqNameTh1());
        main.updateMissQuestion(missQuestion, "updateMissQuestion");
   
        System.out.println(missQuestion.getMqNameTh1());
        System.out.println(missQuestions.size());
        //main.testMissQuestion();
       MissAccount account=main.findMissAccountById(7l);
       System.out.println(account.getMissAccountSeriesMapList());
        //main.findProductReport("0","2012"); //0=year,1=all
      //  MissAccount missAccount = missExamService.findMissAccountById(Long.valueOf(Long.parseLong(maId)));
        System.out.println(IMakeDevUtils.calculatePage(3, 7));
        DateTime dt = new DateTime();
        System.out.println(dt.getDayOfMonth());
        System.out.println(dt.dayOfMonth().getAsShortText(Locale.US));
        System.out.println(dt.monthOfYear().getAsShortText(Locale.CANADA));
        System.out.println(dt.year().get());
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        System.out.println(format.format(dt.toDate()));
        Calendar c = Calendar.getInstance();
        c.setTime(dt.toDate());
        c.add(5, 1);
        java.util.Date dt2 = c.getTime();
        System.out.println("xxxxxxxxxxxxxxxxxxxxx");
        DateTime dt22 = new DateTime(dt2);
        System.out.println(dt22.getDayOfMonth());
        System.out.println(dt22.dayOfMonth().getAsShortText(Locale.US));
        System.out.println(dt22.monthOfYear().getAsShortText(Locale.CANADA));
        System.out.println(dt22.year().get());
        System.out.println(format.format(dt22.toDate()));
    }

    private void testMissAccount()
    {
        MissAccount missAccount = findMissAccountById(new Long(1L));
        System.out.println(missAccount);
        missAccount.setMaAddress((new StringBuilder(String.valueOf(missAccount.getMaAddress()))).append(" update record").toString());
        updateMissAccount(missAccount);
        MissAccount missAccountSave = new MissAccount();
        BeanUtils.copyProperties(missAccount, missAccountSave);
        missAccountSave.setMaId(null);
        saveMissAccount(missAccountSave);
        MissAccount missAccountSearch = new MissAccount();
        missAccountSearch.setMaName("search");
        VResultMessage vresult = searchMissAccount(missAccountSearch);
        System.out.println(vresult);
        MissAccount missAccountDelete = new MissAccount();
        missAccountDelete.setMaId(new Long(1L));
    }

    private void testMissAccountSeriesMap()
    {
        MissAccountSeriesMap missAccountSeriesMap = findMissAccountSeriesMapById(new Long(1L));
        System.out.println(missAccountSeriesMap);
        missAccountSeriesMap.setMasmOrderUnit(Long.valueOf(missAccountSeriesMap.getMasmOrderUnit().longValue() + 1L));
        updateMissAccountSeriesMap(missAccountSeriesMap);
        MissAccountSeriesMap missAccountSeriesMapSave = new MissAccountSeriesMap();
        BeanUtils.copyProperties(missAccountSeriesMap, missAccountSeriesMapSave);
        missAccountSeriesMapSave.setMaId(null);
        saveMissAccountSeriesMap(missAccountSeriesMapSave);
        MissAccountSeriesMap missAccountSeriesMapSearch = new MissAccountSeriesMap();
        missAccountSeriesMapSearch.setMasmStatus("1");
        VResultMessage vresult = searchMissAccountSeriesMap(missAccountSeriesMapSearch);
        System.out.println(vresult);
        MissAccountSeriesMap missAccountSeriesMapDelete = new MissAccountSeriesMap();
        missAccountSeriesMapDelete.setMaId(new Long(1L));
        deleteMissAccountSeriesMap(missAccountSeriesMapDelete);
    }

    private void testMissCandidate()
    {
        MissCandidate missCandidate = findMissCandidateById(new Long(1L));
        System.out.println(missCandidate);
        missCandidate.setMcaDepartment((new StringBuilder(String.valueOf(missCandidate.getMcaDepartment()))).append(" update").toString());
        updateMissCandidate(missCandidate);
        MissCandidate missCandidateSave = new MissCandidate();
        BeanUtils.copyProperties(missCandidate, missCandidateSave);
        missCandidateSave.setMcaId(null);
        saveMissCandidate(missCandidateSave);
        MissCandidate missCandidateSearch = new MissCandidate();
        VResultMessage vresult = searchMissCandidate(missCandidateSearch);
        System.out.println(vresult);
        MissCandidate missCandidateDelete = new MissCandidate();
    }

    private void testMissChoice()
    {
        MissChoice missChoice = findMissChoiceById(new Long(1L));
        System.out.println(missChoice);
        updateMissChoice(missChoice);
        MissChoice missChoiceSave = new MissChoice();
        saveMissChoice(missChoiceSave);
        MissChoice missChoiceSearch = new MissChoice();
        VResultMessage vresult = searchMissChoice(missChoiceSearch);
        System.out.println(vresult);
        MissChoice missChoiceDelete = new MissChoice();
        deleteMissChoice(missChoiceDelete);
    }

    private void testMissEvaluationTemplate()
    {
        MissEvaluationTemplate missEvaluationTemplate = findMissEvaluationTemplateById(new Long(1L));
        System.out.println(missEvaluationTemplate);
        updateMissEvaluationTemplate(missEvaluationTemplate);
        MissEvaluationTemplate missEvaluationTemplateSave = new MissEvaluationTemplate();
        saveMissEvaluationTemplate(missEvaluationTemplateSave);
        MissEvaluationTemplate missEvaluationTemplateSearch = new MissEvaluationTemplate();
        VResultMessage vresult = searchMissEvaluationTemplate(missEvaluationTemplateSearch);
        System.out.println(vresult);
        MissEvaluationTemplate missEvaluationTemplateDelete = new MissEvaluationTemplate();
        deleteMissEvaluationTemplate(missEvaluationTemplateDelete);
    }

    private void testMissExam()
    {
        MissExam missExam = findMissExamById(new Long(1L));
        System.out.println(missExam);
        updateMissExam(missExam);
        MissExam missExamSave = new MissExam();
        saveMissExam(missExamSave);
        MissExam missExamSearch = new MissExam();
        VResultMessage vresult = searchMissExam(missExamSearch);
        System.out.println(vresult);
        MissExam missExamDelete = new MissExam();
    }

    private void testMissExamGroup()
    {
        MissExamGroup missExamGroupSearch = new MissExamGroup();
        VResultMessage vresult = searchMissExamGroup(missExamGroupSearch);
        System.out.println(vresult.getResultListObj());
    }

    private void testMissExamType()
    {
        MissExamType missExamType = findMissExamTypeById(new Long(1L));
        System.out.println(missExamType);
        updateMissExamType(missExamType);
        MissExamType missExamTypeSave = new MissExamType();
        saveMissExamType(missExamTypeSave);
        MissExamType missExamTypeSearch = new MissExamType();
        VResultMessage vresult = searchMissExamType(missExamTypeSearch);
        System.out.println(vresult);
        MissExamType missExamTypeDelete = new MissExamType();
        deleteMissExamType(missExamTypeDelete);
    }

    private void testMissQuestion()
    {
        MissQuestion missQuestion = findMissQuestionById(new Long(1L));
        System.out.println(missQuestion);
        //updateMissQuestion(missQuestion);
        MissQuestion missQuestionSave = new MissQuestion();
        //saveMissQuestion(missQuestionSave);
        MissQuestion missQuestionSearch = new MissQuestion();
        VResultMessage vresult = searchMissQuestion(missQuestionSearch);
        System.out.println(vresult);
        MissQuestion missQuestionDelete = new MissQuestion();
        deleteMissQuestion(missQuestionDelete);
    	 MissQuestion missQuestion = new MissQuestion(); 
         missQuestion.setServiceName(ServiceConstant.MISS_QUESTION_SETUP_TEST);
         
         VResultMessage resultMessage = postMessage(missQuestion, missQuestion.getClass().getName(), "missQuestion", true);
          
    }

    private void testMissSeriesMap()
    {
        MissSeriesMap missSeriesMap = findMissSeriesMapById(new Long(1L));
        System.out.println(missSeriesMap);
        updateMissSeriesMap(missSeriesMap);
        MissSeriesMap missSeriesMapSave = new MissSeriesMap();
        saveMissSeriesMap(missSeriesMapSave);
        MissSeriesMap missSeriesMapSearch = new MissSeriesMap();
        VResultMessage vresult = searchMissSeriesMap(missSeriesMapSearch);
        System.out.println(vresult);
        MissSeriesMap missSeriesMapDelete = new MissSeriesMap();
        deleteMissSeriesMap(missSeriesMapDelete);
    }

    private void testMissSery()
    {
        MissSery missSery = findMissSeryById(new Long(1L));
        System.out.println(missSery);
        updateMissSery(missSery);
        MissSery missSerySave = new MissSery();
        saveMissSery(missSerySave);
        MissSery missSerySearch = new MissSery();
        VResultMessage vresult = searchMissSery(missSerySearch);
        System.out.println(vresult);
        MissSery missSeryDelete = new MissSery();
        deleteMissSery(missSeryDelete, "");
    }

    private void testMissSurveySend()
    {
        MissSurveySend missSurveySend = findMissSurveySendById(new Long(1L));
        System.out.println(missSurveySend);
        updateMissSurveySend(missSurveySend);
        MissSurveySend missSurveySendSave = new MissSurveySend();
        saveMissSurveySend(missSurveySendSave);
        MissSurveySend missSurveySendSearch = new MissSurveySend();
        VResultMessage vresult = searchMissSurveySend(missSurveySendSearch);
        System.out.println(vresult);
        MissSurveySend missSurveySendDelete = new MissSurveySend();
        deleteMissSurveySend(missSurveySendDelete);
    }

    private void testMissTemplate()
    {
        MissTemplate missTemplate = findMissTemplateById(new Long(1L));
        System.out.println(missTemplate);
        updateMissTemplate(missTemplate);
        MissTemplate missTemplateSave = new MissTemplate();
        saveMissTemplate(missTemplateSave);
        MissTemplate missTemplateSearch = new MissTemplate();
        VResultMessage vresult = searchMissTemplate(missTemplateSearch);
        System.out.println(vresult);
        MissTemplate missTemplateDelete = new MissTemplate();
        deleteMissTemplate(missTemplateDelete);
    }

    private void testMissTest()
    {
        MissTest missTest = findMissTestById(new Long(1L));
        System.out.println(missTest);
        updateMissTest(missTest);
        MissTest missTestSave = new MissTest();
        saveMissTest(missTestSave);
        MissTest missTestSearch = new MissTest();
        VResultMessage vresult = searchMissTest(missTestSearch);
        System.out.println(vresult);
        MissTest missTestDelete = new MissTest();
        deleteMissTest(missTestDelete);
    }

    private void testMissTestResult()
    {
        MissTestResult missTestResult = findMissTestResultById(new Long(1L));
        System.out.println(missTestResult);
        updateMissTestResult(missTestResult);
        MissTestResult missTestResultSave = new MissTestResult();
        saveMissTestResult(missTestResultSave);
        MissTestResult missTestResultSearch = new MissTestResult();
        VResultMessage vresult = searchMissTestResult(missTestResultSearch);
        System.out.println(vresult);
        MissTestResult missTestResultDelete = new MissTestResult();
        deleteMissTestResult(missTestResultDelete);
    }

    private void testMissTodo()
    {
        MissTodo missTodoSearch = new MissTodo();
        Pagging paging = new Pagging();
        paging.setPageNo(2);
        paging.setPageSize(2);
        missTodoSearch.setPagging(paging);
        VResultMessage vresult = searchMissTodo(missTodoSearch);
        System.out.println((new StringBuilder("xx")).append(vresult.getResultListObj()).toString());
    }

	@Override
	public int updateMissSeriesAttach(MissSeriesAttach missSeriesAttach) {
		// TODO Auto-generated method stub
		  missSeriesAttach.setServiceName(ServiceConstant.MISS_SERIES_ATTACH_UPDATE);
	        VResultMessage resultMessage = postMessage(missSeriesAttach, missSeriesAttach.getClass().getName(), "missSeriesAttach", true);
	        missSeriesAttach = (MissSeriesAttach)resultMessage.getResultListObj().get(0);
	        return missSeriesAttach.getUpdateRecord().intValue();
	}

	@Override
	public int deleteMissSeriesAttach(MissSeriesAttach missSeriesAttach) {
		// TODO Auto-generated method stub
		  missSeriesAttach.setServiceName(ServiceConstant.MISS_SERIES_ATTACH_DELETE);
	        VResultMessage resultMessage = postMessage(missSeriesAttach, missSeriesAttach.getClass().getName(), "missSeriesAttach", true);
	        missSeriesAttach = (MissSeriesAttach)resultMessage.getResultListObj().get(0);
	        return missSeriesAttach.getUpdateRecord().intValue();
	}

	@Override
	public MissSeriesAttach findMissSeriesAttachSearch(String matModule,
			Long matRef1, Long matRef2, String hotlink) {
		// TODO Auto-generated method stub
		    MissSeriesAttach missSeriesAttach = new MissSeriesAttach();
	        missSeriesAttach.setMsatModule(matModule);
	        missSeriesAttach.setMsatHotlink(hotlink);
	        missSeriesAttach.setMsatRef1(matRef1);
	        missSeriesAttach.setMsatRef2(matRef2);
	        missSeriesAttach.setServiceName(ServiceConstant.MISS_SERIES_ATTACH_SEARCH);
	        VResultMessage resultMessage = postMessage(missSeriesAttach, missSeriesAttach.getClass().getName(), "missSeriesAttach", true);
	        if(resultMessage!=null && resultMessage.getResultListObj()!=null && resultMessage.getResultListObj().size()>0)
	        	return (MissSeriesAttach)resultMessage.getResultListObj().get(0);
	        else
	        	return null;
	}
  
	
	@Override
	public Long saveRoleContact(RoleContact roleContact) {
		// TODO Auto-generated method stub
		roleContact.setServiceName(ServiceConstant.ROLE_CONTACT_SAVE);
	    VResultMessage resultMessage = postMessage(roleContact, roleContact.getClass().getName(), "roleContact", true);
	    roleContact = (RoleContact)resultMessage.getResultListObj().get(0);
	    return roleContact.getRcId();
	}

	@Override
	public int updateRoleContact(RoleContact roleContact) {
		// TODO Auto-generated method stub
		roleContact.setServiceName(ServiceConstant.ROLE_CONTACT_UPDATE);
        VResultMessage resultMessage = postMessage(roleContact, roleContact.getClass().getName(), "roleContact", true);
        roleContact = (RoleContact)resultMessage.getResultListObj().get(0);
        return roleContact.getUpdateRecord().intValue();
	}

	@Override
	public int deleteRoleContact(RoleContact roleContact, String service) {
		// TODO Auto-generated method stub
		roleContact.setServiceName(service);
        VResultMessage resultMessage = postMessage(roleContact, roleContact.getClass().getName(), "roleContact", true);
        roleContact = (RoleContact)resultMessage.getResultListObj().get(0);
        return roleContact.getUpdateRecord().intValue();
	}

	@Override
	public RoleContact findRoleContactById(Long rcId) {
		// TODO Auto-generated method stub
		RoleContact roleContact = new RoleContact();
		roleContact.setRcId(rcId);
		roleContact.setServiceName(ServiceConstant.ROLE_CONTACT_FIND_BY_ID);
	        VResultMessage resultMessage = postMessage(roleContact, roleContact.getClass().getName(), "roleContact", true);
	        if(resultMessage!=null && resultMessage.getResultListObj()!=null && resultMessage.getResultListObj().size()>0)
	        	return (RoleContact)resultMessage.getResultListObj().get(0);
	        return null;
	}

	@Override
	public VResultMessage searchRoleContact(RoleContact roleContact) {
		// TODO Auto-generated method stub
		roleContact.setServiceName(ServiceConstant.ROLE_CONTACT_SEARCH);
        return postMessage(roleContact, roleContact.getClass().getName(), "roleContact", true);
	}

	@Override
	public Long saveRoleMapping(RoleMapping roleMapping) {
		// TODO Auto-generated method stub
		roleMapping.setServiceName(ServiceConstant.ROLE_MAPPING_SAVE);
	    VResultMessage resultMessage = postMessage(roleMapping, roleMapping.getClass().getName(), "roleMapping", true);
	    roleMapping = (RoleMapping)resultMessage.getResultListObj().get(0);
	    return roleMapping.getRcId();
	}

	@Override
	public int updateRoleMapping(RoleMapping roleMapping) {
		// TODO Auto-generated method stub
		roleMapping.setServiceName(ServiceConstant.ROLE_MAPPING_UPDATE);
        VResultMessage resultMessage = postMessage(roleMapping, roleMapping.getClass().getName(), "roleMapping", true);
        roleMapping = (RoleMapping)resultMessage.getResultListObj().get(0);
        return roleMapping.getUpdateRecord().intValue();
	}

	@Override
	public int deleteRoleMapping(RoleMapping roleMapping, String service) {
		// TODO Auto-generated method stub
		roleMapping.setServiceName(service);
        VResultMessage resultMessage = postMessage(roleMapping, roleMapping.getClass().getName(), "roleMapping", true);
        roleMapping = (RoleMapping)resultMessage.getResultListObj().get(0);
        return roleMapping.getUpdateRecord().intValue();
	}

	@Override
	public RoleMapping findRoleMappingById(Long rcId) {
		// TODO Auto-generated method stub
		RoleMapping roleMapping = new RoleMapping();
		roleMapping.setRcId(rcId);
		roleMapping.setServiceName(ServiceConstant.ROLE_MAPPING_FIND_BY_ID);
	        VResultMessage resultMessage = postMessage(roleMapping, roleMapping.getClass().getName(), "roleMapping", true);
	        if(resultMessage!=null && resultMessage.getResultListObj()!=null && resultMessage.getResultListObj().size()>0)
	        	return (RoleMapping)resultMessage.getResultListObj().get(0);
	        return null;
	}

	@Override
	public VResultMessage searchRoleMapping(RoleMapping roleMapping) {
		// TODO Auto-generated method stub
		roleMapping.setServiceName(ServiceConstant.ROLE_MAPPING_SEARCH);
        return postMessage(roleMapping, roleMapping.getClass().getName(), "roleMapping", true);
	}


	@Override
	public Long saveRoleType(RoleType roleType) {
		// TODO Auto-generated method stub
		roleType.setServiceName(ServiceConstant.ROLE_TYPE_SAVE);
	    VResultMessage resultMessage = postMessage(roleType, roleType.getClass().getName(), "roleType", true);
	    roleType = (RoleType)resultMessage.getResultListObj().get(0);
	    return roleType.getRtId();
	}

	@Override
	public int updateRoleType(RoleType roleType) {
		// TODO Auto-generated method stub
		roleType.setServiceName(ServiceConstant.ROLE_TYPE_UPDATE);
        VResultMessage resultMessage = postMessage(roleType, roleType.getClass().getName(), "roleType", true);
        roleType = (RoleType)resultMessage.getResultListObj().get(0);
        return roleType.getUpdateRecord().intValue();
	}

	@Override
	public int deleteRoleType(RoleType roleType, String service) {
		// TODO Auto-generated method stub
		roleType.setServiceName(service);
        VResultMessage resultMessage = postMessage(roleType, roleType.getClass().getName(), "roleType", true);
        roleType = (RoleType)resultMessage.getResultListObj().get(0);
        return roleType.getUpdateRecord().intValue();
	}

	@Override
	public RoleType findRoleTypeById(Long rtId) {
		// TODO Auto-generated method stub
		RoleType roleType = new RoleType();
		roleType.setRtId(rtId);
		roleType.setServiceName(ServiceConstant.ROLE_TYPE_FIND_BY_ID);
	        VResultMessage resultMessage = postMessage(roleType, roleType.getClass().getName(), "roleType", true);
	        if(resultMessage!=null && resultMessage.getResultListObj()!=null && resultMessage.getResultListObj().size()>0)
	        	return (RoleType)resultMessage.getResultListObj().get(0);
	        return null;
	}

	@Override
	public VResultMessage searchRoleType(RoleType roleType) {
		// TODO Auto-generated method stub
		roleType.setServiceName(ServiceConstant.ROLE_TYPE_SEARCH);
        return postMessage(roleType, roleType.getClass().getName(), "roleType", true);
	}

	@Override
	public List listRoleTypeByRcId(Long rcId) {
		// TODO Auto-generated method stub
		 RoleType roleType = new RoleType();
		 roleType.setRcId(rcId);
		 roleType.setServiceName(ServiceConstant.ROLE_TYPE_LIST_BY_RC_ID);
	        VResultMessage resultMessage = postMessage(roleType, roleType.getClass().getName(), "roleType", true);
	       return resultMessage.getResultListObj();
	}

	@Override
	public List listRoleContactBymaId(Long maId) {
		// TODO Auto-generated method stub
		 RoleContact roleContact = new RoleContact();
		 roleContact.setMaId(maId);
		 roleContact.setServiceName(ServiceConstant.ROLE_CONTACT_LIST_BY_MA_ID);
	        VResultMessage resultMessage = postMessage(roleContact, roleContact.getClass().getName(), "roleContact", true);
	       return resultMessage.getResultListObj();
	}

	@Override
	public List listRoleMappingByrcId(Long rcId) {
		// TODO Auto-generated method stub
		 RoleMapping roleMapping = new RoleMapping();
			 roleMapping.setRcId(rcId);
			 roleMapping.setServiceName(ServiceConstant.ROLE_MAPPING_LIST_BY_RC_ID);
		        VResultMessage resultMessage = postMessage(roleMapping, roleMapping.getClass().getName(), "roleMapping", true);
		       return resultMessage.getResultListObj();
	}

	@Override
	public List listRoleTypes(Long maId) {
		// TODO Auto-generated method stub
		 RoleType roleType = new RoleType();
		 roleType.setMaId(maId);
		 roleType.setServiceName(ServiceConstant.ROLE_TYPE_LIST);
	        VResultMessage resultMessage = postMessage(roleType, roleType.getClass().getName(), "roleType", true);
	      
	       return resultMessage.getResultListObj();
	}

	@Override
	public int updateStatusMissTestResult(Long mtrId, String column, String value) {
		// TODO Auto-generated method stub
		MissTestResult missTestResult =new MissTestResult();
		missTestResult.setMtrId(mtrId);
		missTestResult.setColumn(column);
		missTestResult.setValue(value);
		missTestResult.setServiceName(ServiceConstant.MISS_TEST_RESULT_UPDATE_STATUS);
        VResultMessage resultMessage = postMessage(missTestResult, missTestResult.getClass().getName(), "missTestResult", true);
        missTestResult = (MissTestResult)resultMessage.getResultListObj().get(0);
        return missTestResult.getUpdateRecord().intValue();
	}
	@Override
	public int updateStatusMissTestResult(String mtrIds, String column, String value) {
		// TODO Auto-generated method stub
		MissTestResult missTestResult =new MissTestResult();
		missTestResult.setMtrIds(mtrIds);
		missTestResult.setColumn(column);
		missTestResult.setValue(value);
		missTestResult.setServiceName(ServiceConstant.MISS_TEST_RESULT_UPDATE_STATUS_LIST);
        VResultMessage resultMessage = postMessage(missTestResult, missTestResult.getClass().getName(), "missTestResult", true);
        missTestResult = (MissTestResult)resultMessage.getResultListObj().get(0);
        return missTestResult.getUpdateRecord().intValue();
	}
	@Override
	public List listMissTheme(MissTheme missTheme) {
		// TODO Auto-generated method stub
		missTheme.setServiceName(ServiceConstant.MISS_THEME_LIST);
	    VResultMessage resultMessage = postMessage(missTheme, missTheme.getClass().getName(), "missTheme", true);
	    return resultMessage.getResultListObj();
	}
	@Override
	public MissTheme findMissThemeById(Long maId,Long mtId) {
		// TODO Auto-generated method stub
		MissTheme missTheme = new MissTheme();
		missTheme.setMtId(mtId);
		missTheme.setMaId(maId);
		missTheme.setServiceName(ServiceConstant.MISS_THEME_FIND_BY_ID);
	        VResultMessage resultMessage = postMessage(missTheme, missTheme.getClass().getName(), "missTheme", true);
	        if(resultMessage!=null && resultMessage.getResultListObj()!=null && resultMessage.getResultListObj().size()>0)
	        	return (MissTheme)resultMessage.getResultListObj().get(0);
	        else
	        	return null;
	}

	@Override
	public List<MissCareerMaster> listMissCareerMaster() {
		// TODO Auto-generated method stub
		MissCareerMaster missCareerMaster =new MissCareerMaster();
		missCareerMaster.setServiceName(ServiceConstant.CAREER_MASTER_LIST);
		VResultMessage resultMessage = postMessage(missCareerMaster, missCareerMaster
				.getClass().getName(), "missCareerMaster", true);
		List<MissCareerMaster> missCareerMasters=null;
		if(resultMessage!=null && resultMessage.getResultListObj()!=null && resultMessage.getResultListObj().size()>0){
			missCareerMasters=resultMessage.getResultListObj();
		} 
		return missCareerMasters;
	}

	@Override
	public List<MissIndustryMaster> listMissIndustryMaster() {
		// TODO Auto-generated method stub
		MissIndustryMaster missIndustryMaster =new MissIndustryMaster();
		missIndustryMaster.setServiceName(ServiceConstant.INDUSTRY_MASTER_LIST);
		VResultMessage resultMessage = postMessage(missIndustryMaster, missIndustryMaster
				.getClass().getName(), "missIndustryMaster", true);
		List<MissIndustryMaster> missIndustryMasters=null;
		if(resultMessage!=null && resultMessage.getResultListObj()!=null && resultMessage.getResultListObj().size()>0){
			missIndustryMasters=resultMessage.getResultListObj();
		} 
		return missIndustryMasters;
	}

	@Override
	public int saveMissSystemUse(MissSystemUse missSystemUse) {
		// TODO Auto-generated method stub
		missSystemUse.setServiceName(ServiceConstant.MISS_SYSTEM_USE_SAVE);
	    VResultMessage resultMessage = postMessage(missSystemUse, missSystemUse.getClass().getName(), "missSystemUse", true);
	    missSystemUse = (MissSystemUse)resultMessage.getResultListObj().get(0);
	    return missSystemUse.getUpdateRecord().intValue();
	}

	@Override
	public List searchMissSystemUse(MissSystemUse missSystemUse) {
		// TODO Auto-generated method stub
		missSystemUse.setServiceName(ServiceConstant.MISS_SYSTEM_USE_SEARCH);
	    VResultMessage resultMessage = postMessage(missSystemUse, missSystemUse.getClass().getName(), "missSystemUse", true);
	    return resultMessage.getResultListObj();
	}

	@Override
	public Long saveMissSeryUse(MissSeryUse missSeryUse) {
		// TODO Auto-generated method stub
		missSeryUse.setServiceName(ServiceConstant.MISS_SERY_USE_SAVE);
	    VResultMessage resultMessage = postMessage(missSeryUse, missSeryUse.getClass().getName(), "missSeryUse", true);
	    missSeryUse = (MissSeryUse)resultMessage.getResultListObj().get(0);
	    return missSeryUse.getMsId();
	}

	@Override
	public List searchMissSeryUse(MissSeryUse missSeryUse) {
		// TODO Auto-generated method stub
		missSeryUse.setServiceName(ServiceConstant.MISS_SERY_USE_SEARCH);
	    VResultMessage resultMessage = postMessage(missSeryUse, missSeryUse.getClass().getName(), "missSeryUse", true);
	    return resultMessage.getResultListObj();
	}

	@Override
	public Long saveMissSeryProblem(MissSeryProblem missSeryProblem) {
		// TODO Auto-generated method stub
		missSeryProblem.setServiceName(ServiceConstant.MISS_SERY_PROBLEM_SAVE);
	    VResultMessage resultMessage = postMessage(missSeryProblem, missSeryProblem.getClass().getName(), "missSeryProblem", true);
	    missSeryProblem = (MissSeryProblem)resultMessage.getResultListObj().get(0);
	    return missSeryProblem.getMcaId();
	}

	@Override
	public List searchMissSeryProblem(MissSeryProblem missSeryProblem) {
		// TODO Auto-generated method stub
		missSeryProblem.setServiceName(ServiceConstant.MISS_SERY_PROBLEM_SEARCH);
	    VResultMessage resultMessage = postMessage(missSeryProblem, missSeryProblem.getClass().getName(), "missSeryProblem", true);
	    return resultMessage.getResultListObj();
	}

	@Override
	public Long saveMissSeryOrder(MissSeryOrder missSeryOrder) {
		// TODO Auto-generated method stub
		missSeryOrder.setServiceName(ServiceConstant.MISS_SERY_ORDER_SAVE);
	    VResultMessage resultMessage = postMessage(missSeryOrder, missSeryOrder.getClass().getName(), "missSeryOrder", true);
	    missSeryOrder = (MissSeryOrder)resultMessage.getResultListObj().get(0);
	    return missSeryOrder.getMsId();
	}

	@Override
	public List searchMissSeryOrder(MissSeryOrder missSeryOrder) {
		// TODO Auto-generated method stub
		missSeryOrder.setServiceName(ServiceConstant.MISS_SERY_ORDER_SEARCH);
	    VResultMessage resultMessage = postMessage(missSeryOrder, missSeryOrder.getClass().getName(), "missSeryOrder", true);
	    return resultMessage.getResultListObj();
	}

	@Override
	public Long saveMissReactiveLog(MissReactiveLog missReactiveLog) {
		// TODO Auto-generated method stub
		missReactiveLog.setServiceName(ServiceConstant.MISS_REACTIVE_LOG_SAVE);
	    VResultMessage resultMessage = postMessage(missReactiveLog, missReactiveLog.getClass().getName(), "missReactiveLog", true);
	    missReactiveLog = (MissReactiveLog)resultMessage.getResultListObj().get(0);
	    return missReactiveLog.getMcaId();
	}

	@Override
	public List searchMissReactiveLog(MissReactiveLog missReactiveLog) {
		// TODO Auto-generated method stub
		missReactiveLog.setServiceName(ServiceConstant.MISS_REACTIVE_LOG_SEARCH);
	    VResultMessage resultMessage = postMessage(missReactiveLog, missReactiveLog.getClass().getName(), "missReactiveLog", true);
	    return resultMessage.getResultListObj();
	}

	@Override
	public List searchMissAccountGroup(MissAccountGroup missAccountGroup) {
		// TODO Auto-generated method stub
		missAccountGroup.setServiceName(ServiceConstant.MISS_ACCOUNT_GROUP_SAVE);
	    VResultMessage resultMessage = postMessage(missAccountGroup, missAccountGroup.getClass().getName(), "missAccountGroup", true);
	    return resultMessage.getResultListObj();
	}

	@Override
	public List searchMissAccountMapping(MissAccountMapping missAccountMapping) {
		// TODO Auto-generated method stub
		missAccountMapping.setServiceName(ServiceConstant.MISS_ACCOUNT_MAPPING_SEARCH);
	    VResultMessage resultMessage = postMessage(missAccountMapping, missAccountMapping.getClass().getName(), "missAccountMapping", true);
	    return resultMessage.getResultListObj();
	}

	@Override
	//public ProductReport findProductReport(String mode, String year) {
	public ProductReport findProductReport(ProductReport productReport) {
		// TODO Auto-generated method stub
		ProductReport productReport = new ProductReport();
		productReport.setMode(mode);
		productReport.setYear(year);
		productReport.setServiceName(ServiceConstant.PRODUCT_REPORT_FIND);
	        VResultMessage resultMessage = postMessage(productReport, productReport.getClass().getName(), "productReport", true);
	        if(resultMessage!=null && resultMessage.getResultListObj()!=null && resultMessage.getResultListObj().size()>0)
	        	return (ProductReport)resultMessage.getResultListObj().get(0);
	        else
	        	return null;
	}

	@Override
	//public  ServiceReport findServiceReport(String month, String year) {
	public  ServiceReport findServiceReport(ServiceReport serviceReport) {
		// TODO Auto-generated method stub
		ProductReport productReport = new ProductReport();
		productReport.setMode(month);
		productReport.setYear(year);
		serviceReport.setServiceName(ServiceConstant.SERVICE_REPORT_FIND);
	        VResultMessage resultMessage = postMessage(serviceReport, serviceReport.getClass().getName(), "serviceReport", true);
	        if(resultMessage!=null && resultMessage.getResultListObj()!=null && resultMessage.getResultListObj().size()>0)
	        	return (ServiceReport)resultMessage.getResultListObj().get(0);
	        else
	        	return null;
	}

	@Override
	public EPTNormReport findEPTNormReport(EPTNormReport eptNormReport) {
		// TODO Auto-generated method stub
		eptNormReport.setServiceName(ServiceConstant.EPT_NORM_REPORT_FIND);
        VResultMessage resultMessage = postMessage(eptNormReport, eptNormReport.getClass().getName(), "eptNormReport", true);
        if(resultMessage!=null && resultMessage.getResultListObj()!=null && resultMessage.getResultListObj().size()>0)
        	return (EPTNormReport)resultMessage.getResultListObj().get(0);
        else
        	return null;
	}

	@Override
	public EPTNormReport findCompanies(EPTNormReport eptNormReport) {
		// TODO Auto-generated method stub
		eptNormReport.setServiceName(ServiceConstant.EPT_NORM_REPORT_GET_COMPANIES);
        VResultMessage resultMessage = postMessage(eptNormReport, eptNormReport.getClass().getName(), "eptNormReport", true);
        if(resultMessage!=null && resultMessage.getResultListObj()!=null && resultMessage.getResultListObj().size()>0)
        	return (EPTNormReport)resultMessage.getResultListObj().get(0);
        else
        	return null;
	}

	@Override
	public CustomerReport findCustomerReport(CustomerReport customerReport) {
		// TODO Auto-generated method stub
		customerReport.setServiceName(ServiceConstant.CUSTOMER_REPORT_FIND);
        VResultMessage resultMessage = postMessage(customerReport, customerReport.getClass().getName(), "customerReport", true);
        if(resultMessage!=null && resultMessage.getResultListObj()!=null && resultMessage.getResultListObj().size()>0)
        	return (CustomerReport)resultMessage.getResultListObj().get(0);
        else
        	return null;
	}

	@Override
	public CustomerReport findGroups(CustomerReport customerReport) {
		// TODO Auto-generated method stub
		customerReport.setServiceName(ServiceConstant.CUSTOMER_REPORT_GET_GROUPS);
        VResultMessage resultMessage = postMessage(customerReport, customerReport.getClass().getName(), "customerReport", true);
        if(resultMessage!=null && resultMessage.getResultListObj()!=null && resultMessage.getResultListObj().size()>0)
        	return (CustomerReport)resultMessage.getResultListObj().get(0);
        else
        	return null;
	}

	@Override
	public ConsultantReport findConsultantReport(
			ConsultantReport consultantReport) {
		// TODO Auto-generated method stub
		consultantReport.setServiceName(ServiceConstant.CONSULTANT_REPORT_FIND);
        VResultMessage resultMessage = postMessage(consultantReport, consultantReport.getClass().getName(), "consultantReport", true);
        if(resultMessage!=null && resultMessage.getResultListObj()!=null && resultMessage.getResultListObj().size()>0)
        	return (ConsultantReport)resultMessage.getResultListObj().get(0);
        else
        	return null;
	}

	@Override
	public ConsultantReport findSales(ConsultantReport consultantReport) {
		// TODO Auto-generated method stub
		consultantReport.setServiceName(ServiceConstant.CONSULTANT_REPORT_GET_SALES);
        VResultMessage resultMessage = postMessage(consultantReport, consultantReport.getClass().getName(), "consultantReport", true);
        if(resultMessage!=null && resultMessage.getResultListObj()!=null && resultMessage.getResultListObj().size()>0)
        	return (ConsultantReport)resultMessage.getResultListObj().get(0);
        else
        	return null;
	}

	@Override
	public int sendSurvey(MissSurveySend missSurveySend) {
		// TODO Auto-generated method stub
		missSurveySend.setServiceName(ServiceConstant.MISS_SURVEY_SEND);
	    VResultMessage resultMessage = postMessage(missSurveySend, missSurveySend.getClass().getName(), "missSurveySend", true);
	    missSurveySend = (MissSurveySend)resultMessage.getResultListObj().get(0);
	    return missSurveySend.getUpdateRecord().intValue();
	}

	@Override
	public int countMissContactByUsername(String username,Long id) {
		// TODO Auto-generated method stub
		 MissContact missContact = new MissContact();
		 missContact.setMcontactUsername(username);
		 missContact.setMcontactId(id);
		 missContact.setServiceName(ServiceConstant.MISS_CONTACT_COUNT_BY_USERNAME);
	    VResultMessage resultMessage = postMessage(missContact, missContact.getClass().getName(), "missContact", true);
	    missContact = (MissContact)resultMessage.getResultListObj().get(0);
	    return missContact.getUpdateRecord().intValue();
	}

	@Override
	public MissCandidate findMissCandidateByCitizendIdAndEmail(
			String citizendId, String email) {
		// TODO Auto-generated method stub
		MissCandidate missCandidate = new MissCandidate();
		missCandidate.setMcaCitizenId(citizendId);
		missCandidate.setMcaEmail(email);
		missCandidate.setServiceName(ServiceConstant.MISS_CONTACT_FIND_BY_CITIZENID_AND_EMAIL);
	    VResultMessage resultMessage = postMessage(missCandidate, missCandidate.getClass().getName(), "missCandidate", true);
	    if(resultMessage!=null && resultMessage.getResultListObj()!=null){
	    	  missCandidate = (MissCandidate)resultMessage.getResultListObj().get(0);
	    } 
	  
	    return missCandidate;
		
	}

	@Override
	public Long saveMissDoc(MissDoc missDoc) {
		// TODO Auto-generated method stub
		missDoc.setServiceName(ServiceConstant.MISS_DOC_SAVE);
	    VResultMessage resultMessage = postMessage(missDoc, missDoc.getClass().getName(), "missDoc", true);
	    missDoc = (MissDoc)resultMessage.getResultListObj().get(0);
	    return missDoc.getMdId();
	}

	@Override
	public int updateMissDoc(MissDoc missDoc) {
		// TODO Auto-generated method stub
		missDoc.setServiceName(ServiceConstant.MISS_DOC_UPDATE);
        VResultMessage resultMessage = postMessage(missDoc, missDoc.getClass().getName(), "missDoc", true);
        missDoc = (MissDoc)resultMessage.getResultListObj().get(0);
        return missDoc.getUpdateRecord().intValue();
	}

	@Override
	public int deleteMissDoc(MissDoc missDoc) {
		// TODO Auto-generated method stub
		missDoc.setServiceName(ServiceConstant.MISS_DOC_DELETE);
        VResultMessage resultMessage = postMessage(missDoc, missDoc.getClass().getName(), "missDoc", true);
        missDoc = (MissDoc)resultMessage.getResultListObj().get(0);
        return missDoc.getUpdateRecord().intValue();
	}

	@Override
	public MissDoc findMissDocById(Long mdId) {
		// TODO Auto-generated method stub
		 MissDoc missDoc = new MissDoc();
	        missDoc.setMdId(mdId);
	        missDoc.setServiceName(ServiceConstant.MISS_DOC_FIND_BY_ID);
	        VResultMessage resultMessage = postMessage(missDoc, missDoc.getClass().getName(), "missDoc", true);
	        if(resultMessage!=null && resultMessage.getResultListObj()!=null && resultMessage.getResultListObj().size()>0)
	        	return (MissDoc)resultMessage.getResultListObj().get(0);
	        return null;
	}

	@Override
	public VResultMessage searchMissDoc(MissDoc missDoc) {
		// TODO Auto-generated method stub
		missDoc.setServiceName(ServiceConstant.MISS_DOC_SEARCH);
        return postMessage(missDoc, missDoc.getClass().getName(), "missDoc", true);
	} */

	@Override
	public VResultMessage searchPstBreakDown(PstBreakDown pstBreakDown) {
		// TODO Auto-generated method stub
		pstBreakDown.setServiceName(ServiceConstant.PST_BREAK_DOWN_SEARCH);
	    return postMessage(pstBreakDown, pstBreakDown.getClass().getName(), "pstBreakDown", true);
	}

	 public Long savePstBreakDown(PstBreakDown pstBreakDown)
	    {
		 pstBreakDown.setServiceName(ServiceConstant.PST_BREAK_DOWN_SAVE);
	        VResultMessage resultMessage = postMessage(pstBreakDown, pstBreakDown.getClass().getName(), "pstBreakDown", true);
	        pstBreakDown = (PstBreakDown)resultMessage.getResultListObj().get(0);
	        return pstBreakDown.getPbdId();
	    }

	    public int updatePstBreakDown(PstBreakDown pstBreakDown)
	    {
	    	pstBreakDown.setServiceName(ServiceConstant.PST_BREAK_DOWN_UPDATE);
	        VResultMessage resultMessage = postMessage(pstBreakDown, pstBreakDown.getClass().getName(), "pstBreakDown", true);
	        pstBreakDown = (PstBreakDown)resultMessage.getResultListObj().get(0);
	        return pstBreakDown.getUpdateRecord().intValue();
	    }

	    public int deletePstBreakDown(PstBreakDown pstBreakDown, String service)
	    {
	    	pstBreakDown.setServiceName(service);
	        VResultMessage resultMessage = postMessage(pstBreakDown, pstBreakDown.getClass().getName(), "pstBreakDown", true);
	        pstBreakDown = (PstBreakDown)resultMessage.getResultListObj().get(0);
	        return pstBreakDown.getUpdateRecord().intValue();
	    }

	    public PstBreakDown findPstBreakDownById(Long pbdId)
	    {
	    	PstBreakDown pstBreakDown = new PstBreakDown();
	    	pstBreakDown.setPbdId(pbdId);
	    	pstBreakDown.setServiceName(ServiceConstant.PST_BREAK_DOWN_FIND_BY_ID);
	        VResultMessage resultMessage = postMessage(pstBreakDown, pstBreakDown.getClass().getName(), "pstBreakDown", true);
	        return (PstBreakDown)resultMessage.getResultListObj().get(0);
	    }

		@Override
		public VResultMessage searchPstCost(PstCost pstCost) {
			// TODO Auto-generated method stub
			pstCost.setServiceName(ServiceConstant.PST_COST_SEARCH);
		    return postMessage(pstCost, pstCost.getClass().getName(), "pstCost", true);
		}

		@Override
		public Long savePstCost(PstCost pstCost) {
			// TODO Auto-generated method stub
			pstCost.setServiceName(ServiceConstant.PST_COST_SAVE);
		        VResultMessage resultMessage = postMessage(pstCost, pstCost.getClass().getName(), "pstCost", true);
		        pstCost = (PstCost)resultMessage.getResultListObj().get(0);
		        return pstCost.getPcId();
		}

		@Override
		public int updatePstCost(PstCost pstCost) {
			// TODO Auto-generated method stub
			pstCost.setServiceName(ServiceConstant.PST_COST_UPDATE);
	        VResultMessage resultMessage = postMessage(pstCost, pstCost.getClass().getName(), "pstCost", true);
	        pstCost = (PstCost)resultMessage.getResultListObj().get(0);
	        return pstCost.getUpdateRecord().intValue();
		}

		@Override
		public int deletePstCost(PstCost pstCost, String service) {
			// TODO Auto-generated method stub
			pstCost.setServiceName(service);
	        VResultMessage resultMessage = postMessage(pstCost, pstCost.getClass().getName(), "pstCost", true);
	        pstCost = (PstCost)resultMessage.getResultListObj().get(0);
	        return pstCost.getUpdateRecord().intValue();
		}

		@Override
		public PstCost findPstCostById(Long long1) {
			// TODO Auto-generated method stub
			PstCost pstCost = new PstCost();
	    	pstCost.setPcId(long1);
	    	pstCost.setServiceName(ServiceConstant.PST_COST_FIND_BY_ID);
	        VResultMessage resultMessage = postMessage(pstCost, pstCost.getClass().getName(), "pstCost", true);
	        return (PstCost)resultMessage.getResultListObj().get(0);
		}

		@Override
		public VResultMessage searchPstRoadPump(PstRoadPump pstRoadPump) {
			// TODO Auto-generated method stub
			pstRoadPump.setServiceName(ServiceConstant.PST_ROAD_PUMP_SEARCH);
		    return postMessage(pstRoadPump, pstRoadPump.getClass().getName(), "pstRoadPump", true);
		}

		@Override
		public Long savePstRoadPump(PstRoadPump pstRoadPump) {
			// TODO Auto-generated method stub
			pstRoadPump.setServiceName(ServiceConstant.PST_ROAD_PUMP_SAVE);
		        VResultMessage resultMessage = postMessage(pstRoadPump, pstRoadPump.getClass().getName(), "pstRoadPump", true);
		        pstRoadPump = (PstRoadPump)resultMessage.getResultListObj().get(0);
		        return pstRoadPump.getPrpId();
		}

		@Override
		public int updatePstRoadPump(PstRoadPump pstRoadPump) {
			// TODO Auto-generated method stub
			pstRoadPump.setServiceName(ServiceConstant.PST_ROAD_PUMP_UPDATE);
	        VResultMessage resultMessage = postMessage(pstRoadPump, pstRoadPump.getClass().getName(), "pstRoadPump", true);
	        pstRoadPump = (PstRoadPump)resultMessage.getResultListObj().get(0);
	        return pstRoadPump.getUpdateRecord().intValue();
		}

		@Override
		public int deletePstRoadPump(PstRoadPump pstRoadPump, String service) {
			// TODO Auto-generated method stub
			pstRoadPump.setServiceName(service);
	        VResultMessage resultMessage = postMessage(pstRoadPump, pstRoadPump.getClass().getName(), "pstRoadPump", true);
	        pstRoadPump = (PstRoadPump)resultMessage.getResultListObj().get(0);
	        return pstRoadPump.getUpdateRecord().intValue();
		}

		@Override
		public PstRoadPump findPstRoadPumpById(Long long1) {
			// TODO Auto-generated method stub
			PstRoadPump pstRoadPump = new PstRoadPump();
	    	pstRoadPump.setPrpId(long1);
	    	pstRoadPump.setServiceName(ServiceConstant.PST_ROAD_PUMP_FIND_BY_ID);
	        VResultMessage resultMessage = postMessage(pstRoadPump, pstRoadPump.getClass().getName(), "pstRoadPump", true);
	        return (PstRoadPump)resultMessage.getResultListObj().get(0);
		}

		@Override
		public List listPstRoadPumpStatuses() {
			// TODO Auto-generated method stub
			PstRoadPumpStatus pstRoadPumpStatus = new PstRoadPumpStatus();
			pstRoadPumpStatus.setServiceName(ServiceConstant.PST_ROAD_PUMP_STATUS_LIST);
		        VResultMessage resultMessage = postMessage(pstRoadPumpStatus, pstRoadPumpStatus.getClass().getName(), "pstRoadPumpStatus", true);
		        return resultMessage.getResultListObj();
		}

		@Override
		public PstRoadPump listPstRoadPumpMaster() {
			// TODO Auto-generated method stub
			PstRoadPump pstRoadPump = new PstRoadPump(); 
	    	pstRoadPump.setServiceName(ServiceConstant.PST_ROAD_PUMP_LIST_MASTER);
	        VResultMessage resultMessage = postMessage(pstRoadPump, pstRoadPump.getClass().getName(), "pstRoadPump", true);
	        return (PstRoadPump)resultMessage.getResultListObj().get(0);
		}

		@Override
		public VResultMessage searchPstEmployeeStatus(
				PstEmployeeStatus pstEmployeeStatus) {
			// TODO Auto-generated method stub
			pstEmployeeStatus.setServiceName(ServiceConstant.PST_EMPLOYEE_STATUS_SEARCH);
		    return postMessage(pstEmployeeStatus, pstEmployeeStatus.getClass().getName(), "pstEmployeeStatus", true);
		}

		@Override
		public Long savePstEmployeeStatus(PstEmployeeStatus pstEmployeeStatus) {
			// TODO Auto-generated method stub
			pstEmployeeStatus.setServiceName(ServiceConstant.PST_EMPLOYEE_STATUS_SAVE);
		        VResultMessage resultMessage = postMessage(pstEmployeeStatus, pstEmployeeStatus.getClass().getName(), "pstEmployeeStatus", true);
		        pstEmployeeStatus = (PstEmployeeStatus)resultMessage.getResultListObj().get(0);
		        return pstEmployeeStatus.getPesId();
		}

		@Override
		public int updatePstEmployeeStatus(PstEmployeeStatus pstEmployeeStatus) {
			// TODO Auto-generated method stub
			pstEmployeeStatus.setServiceName(ServiceConstant.PST_EMPLOYEE_STATUS_UPDATE);
	        VResultMessage resultMessage = postMessage(pstEmployeeStatus, pstEmployeeStatus.getClass().getName(), "pstEmployeeStatus", true);
	        pstEmployeeStatus = (PstEmployeeStatus)resultMessage.getResultListObj().get(0);
	        return pstEmployeeStatus.getUpdateRecord().intValue();
		}

		@Override
		public int deletePstEmployeeStatus(PstEmployeeStatus pstEmployeeStatus,
				String service) {
			// TODO Auto-generated method stub
			pstEmployeeStatus.setServiceName(service);
	        VResultMessage resultMessage = postMessage(pstEmployeeStatus, pstEmployeeStatus.getClass().getName(), "pstEmployeeStatus", true);
	        pstEmployeeStatus = (PstEmployeeStatus)resultMessage.getResultListObj().get(0);
	        return pstEmployeeStatus.getUpdateRecord().intValue();
		}

		@Override
		public PstEmployeeStatus findPstEmployeeStatusById(Long long1) {
			// TODO Auto-generated method stub
			PstEmployeeStatus pstEmployeeStatus = new PstEmployeeStatus();
			pstEmployeeStatus.setPesId(long1);
			pstEmployeeStatus.setServiceName(ServiceConstant.PST_EMPLOYEE_STATUS_FIND_BY_ID);
	        VResultMessage resultMessage = postMessage(pstEmployeeStatus, pstEmployeeStatus.getClass().getName(), "pstEmployeeStatus", true);
	        return (PstEmployeeStatus)resultMessage.getResultListObj().get(0);
		}

		@Override
		public VResultMessage searchPstEmployee(PstEmployee pstEmployee) {
			// TODO Auto-generated method stub
			pstEmployee.setServiceName(ServiceConstant.PST_EMPLOYEE_SEARCH);
		    return postMessage(pstEmployee, pstEmployee.getClass().getName(), "pstEmployee", true);
		}

		@Override
		public Long savePstEmployee(PstEmployee pstEmployee) {
			// TODO Auto-generated method stub
			pstEmployee.setServiceName(ServiceConstant.PST_EMPLOYEE_SAVE);
	        VResultMessage resultMessage = postMessage(pstEmployee, pstEmployee.getClass().getName(), "pstEmployee", true);
	        pstEmployee = (PstEmployee)resultMessage.getResultListObj().get(0);
	        return pstEmployee.getPeId();
		}

		@Override
		public int updatePstEmployee(PstEmployee pstEmployee) {
			// TODO Auto-generated method stub
			pstEmployee.setServiceName(ServiceConstant.PST_EMPLOYEE_UPDATE);
	        VResultMessage resultMessage = postMessage(pstEmployee, pstEmployee.getClass().getName(), "pstEmployee", true);
	        pstEmployee = (PstEmployee)resultMessage.getResultListObj().get(0);
	        return pstEmployee.getUpdateRecord().intValue();
		}

		@Override
		public int deletePstEmployee(PstEmployee pstEmployee, String service) {
			// TODO Auto-generated method stub
			pstEmployee.setServiceName(service);
	        VResultMessage resultMessage = postMessage(pstEmployee, pstEmployee.getClass().getName(), "pstEmployee", true);
	        pstEmployee = (PstEmployee)resultMessage.getResultListObj().get(0);
	        return pstEmployee.getUpdateRecord().intValue();
		}

		@Override
		public PstEmployee findPstEmployeeById(Long long1) {
			// TODO Auto-generated method stub
			PstEmployee pstEmployee = new PstEmployee();
			pstEmployee.setPeId(long1);
			pstEmployee.setServiceName(ServiceConstant.PST_EMPLOYEE_FIND_BY_ID);
	        VResultMessage resultMessage = postMessage(pstEmployee, pstEmployee.getClass().getName(), "pstEmployee", true);
	        return (PstEmployee)resultMessage.getResultListObj().get(0);
		}

		@Override
		public List listPstPositions() {
			// TODO Auto-generated method stub
			PstPosition pstPosition = new PstPosition();
			pstPosition.setServiceName(ServiceConstant.PST_POSITION_LIST);
		        VResultMessage resultMessage = postMessage(pstPosition, pstPosition.getClass().getName(), "pstPosition", true);
		        return resultMessage.getResultListObj();
		}

		@Override
		public List listPstTitles() {
			// TODO Auto-generated method stub
			PstTitle pstTitle = new PstTitle();
			pstTitle.setServiceName(ServiceConstant.PST_TITLE_LIST);
		        VResultMessage resultMessage = postMessage(pstTitle, pstTitle.getClass().getName(), "pstTitle", true);
		        return resultMessage.getResultListObj();
		}

}
