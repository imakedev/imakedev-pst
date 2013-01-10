package th.co.aoe.imake.pst.backoffice.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import th.co.aoe.imake.pst.backoffice.form.JobForm;
import th.co.aoe.imake.pst.backoffice.service.PSTService;
import th.co.aoe.imake.pst.backoffice.utils.IMakeDevUtils;
import th.co.aoe.imake.pst.constant.ServiceConstant;
import th.co.aoe.imake.pst.xstream.PstJob;
import th.co.aoe.imake.pst.xstream.common.VResultMessage;

@Controller
@RequestMapping(value={"/job"}) 
@SessionAttributes(value={"jobForm"})
public class JobController {
	 @Autowired
	 private PSTService pstService;
	 private static final Logger logger = LoggerFactory.getLogger(ServiceConstant.LOG_APPENDER);
	 private static SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
	 @RequestMapping(value={"/init"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
	 public String init(Model model)
	    {
	      
		 JobForm jobForm = null;
	      /*  if(model.containsAttribute("jobForm"))
	        	jobForm = (JobForm)model.asMap().get("jobForm");
	        else*/
		 jobForm = new JobForm();
	        
		 jobForm.getPaging().setPageSize(IMakeDevUtils.PAGE_SIZE);
		 jobForm.getPstJob().setPagging(jobForm.getPaging());
	        VResultMessage vresultMessage = pstService.searchPstJob(jobForm.getPstJob());
	        logger.debug("vresultMessage="+vresultMessage);
	        logger.debug("getResultListObj="+vresultMessage.getResultListObj());
	        model.addAttribute("pstJobs", vresultMessage.getResultListObj());
	        jobForm.getPaging().setPageSize(IMakeDevUtils.PAGE_SIZE);
	        jobForm.setPageCount(IMakeDevUtils.calculatePage(jobForm.getPaging().getPageSize(), Integer.parseInt(vresultMessage.getMaxRow())));
	        model.addAttribute("jobForm", jobForm);
	        model.addAttribute("message", ""); 
	        model.addAttribute("pstConcretes", pstService.listPstConcretes());
	        model.addAttribute("pstRoadPumpNos", pstService.listPstRoadPumpNo());
	        
			 return "backoffice/template/job_search";
	    }
	 @RequestMapping(value={"/search"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
	    public String doSearch(HttpServletRequest request, @ModelAttribute(value="jobForm") JobForm jobForm, BindingResult result, Model model)
	    {
	        String mode = jobForm.getMode();
	        if(jobForm != null && jobForm.getPjCreatedTime() != null
	        		&& jobForm.getPjCreatedTime().length()>0)
				try {
					jobForm.getPstJob().setPjCreatedTime(format1.parse(jobForm.getPjCreatedTime()));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        if(mode != null && mode.equals(IMakeDevUtils.MODE_DELETE_ITEMS))
	        {
	        	jobForm.getPstJob().setIds(jobForm.getPjIdArray());
	        	pstService.deletePstJob(jobForm.getPstJob(), ServiceConstant.PST_JOB_ITEMS_DELETE);
	        	jobForm.getPaging().setPageNo(1);
	        } else
	        if(mode != null && mode.equals(IMakeDevUtils.MODE_DELETE)){
	        	pstService.deletePstJob(jobForm.getPstJob(),  ServiceConstant.PST_JOB_DELETE);
	        	jobForm.getPaging().setPageNo(1);
	        }
	        else
	        if(mode != null && mode.equals(IMakeDevUtils.MODE_DO_BACK))
	        {
	            if(model.containsAttribute("jobForm"))
	            	jobForm = (JobForm)model.asMap().get("jobForm");
	            else
	            	jobForm = new JobForm();
	        }
	        jobForm.getPaging().setPageSize(IMakeDevUtils.PAGE_SIZE);
	        jobForm.getPstJob().setPagging(jobForm.getPaging());
	        VResultMessage vresultMessage = pstService.searchPstJob(jobForm.getPstJob());
	       
	        jobForm.setPageCount(IMakeDevUtils.calculatePage(jobForm.getPaging().getPageSize(), Integer.parseInt(vresultMessage.getMaxRow())));
	        model.addAttribute("pstJobs", vresultMessage.getResultListObj());
	        model.addAttribute("jobForm", jobForm);
	        model.addAttribute("message", ""); 
	        model.addAttribute("pstConcretes", pstService.listPstConcretes());
	        model.addAttribute("pstRoadPumpNos", pstService.listPstRoadPumpNo());
	        return "backoffice/template/job_search";
	    }
	  @RequestMapping(value={"/item/{maId}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
	    public String getItem(@PathVariable String maId, Model model)
	    {
		  JobForm jobForm = null;
	        if(model.containsAttribute("jobForm"))
	        	jobForm = (JobForm)model.asMap().get("jobForm");
	        else
	        	jobForm = new JobForm();
	        jobForm.setMode(IMakeDevUtils.MODE_EDIT);
	        PstJob pstJob = pstService.findPstJobById(Long.parseLong(maId));
	        if(pstJob != null && pstJob.getPjCreatedTime() != null)    
					jobForm.setPjCreatedTime(format1.format(pstJob.getPjCreatedTime()));
				
	        jobForm.setPstJob(pstJob);
	        model.addAttribute("jobForm", jobForm);
	        model.addAttribute("display", "display: none");
	        model.addAttribute("pstConcretes", pstService.listPstConcretes());
	        model.addAttribute("pstRoadPumpNos", pstService.listPstRoadPumpNo());
	        return "backoffice/template/job_manaement";
	    }
	  @RequestMapping(value={"/action/{section}"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
	    public String doAction(HttpServletRequest request, @PathVariable String section, @ModelAttribute(value="jobForm") JobForm jobForm, BindingResult result, Model model)
	    {
	        String mode = jobForm.getMode();
	        String message = "";
	        String  message_class="";
	        Long id = null;
	        if(jobForm != null && jobForm.getPjCreatedTime() != null
	        		&& jobForm.getPjCreatedTime().length()>0)
				try {
					jobForm.getPstJob().setPjCreatedTime(format1.parse(jobForm.getPjCreatedTime()));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        /*if(jobForm != null && jobForm.getPstJob() != null
	        		&& jobForm.getPstJob().getPstConcrete()!=null && jobForm.getPstJob().getPstConcrete().getPconcreteId()!=null)
				try {
					jobForm.getPstJob().setPjCreatedTime(format1.parse(jobForm.getPjCreatedTime()));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
	       if(mode != null)
	            if(mode.equals(IMakeDevUtils.MODE_NEW))
	            {
	                id = pstService.savePstJob(jobForm.getPstJob());
	                jobForm.getPstJob().setPjId(id);
	                jobForm.setMode(IMakeDevUtils.MODE_EDIT);
	                message = "Save success !";
	                message_class="success";
	            } else
	            if(mode.equals(IMakeDevUtils.MODE_EDIT))
	            {
	            	pstService.updatePstJob(jobForm.getPstJob());
	                id = jobForm.getPstJob().getPjId();
	                message = "Update success !";
	                message_class="success";
	            }
	        /*PstJob pstJob = pstService.findPstJobById(id);
	        jobForm.setPstJob(pstJob);
	        model.addAttribute("message", message);
	        model.addAttribute("display", "display: block");
	        model.addAttribute("jobForm", jobForm);*/
	       // JobForm jobForm = null; 
	       jobForm = new JobForm(); 
	       jobForm.getPaging().setPageSize(IMakeDevUtils.PAGE_SIZE);
	       jobForm.getPstJob().setPagging(jobForm.getPaging());
		        VResultMessage vresultMessage = pstService.searchPstJob(jobForm.getPstJob());
		        logger.debug("vresultMessage="+vresultMessage);
		        logger.debug("getResultListObj="+vresultMessage.getResultListObj());
		        model.addAttribute("pstJobs", vresultMessage.getResultListObj());
		        jobForm.getPaging().setPageSize(IMakeDevUtils.PAGE_SIZE);
		        jobForm.setPageCount(IMakeDevUtils.calculatePage(jobForm.getPaging().getPageSize(), Integer.parseInt(vresultMessage.getMaxRow())));
		        model.addAttribute("jobForm", jobForm);
		        model.addAttribute("message", message); 
		        model.addAttribute("message_class", message_class);
		        return "backoffice/template/job_search";
		        
	        // return "backoffice/template/job_manaement";
	    }
	  @RequestMapping(value={"/new"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
	    public String getNewForm(Model model)
	    {
		  JobForm jobForm = new JobForm(); 
		  jobForm.setMode(IMakeDevUtils.MODE_NEW);
		  model.addAttribute("jobForm", jobForm);
	        model.addAttribute("display", "display: none");   
	        model.addAttribute("pstConcretes", pstService.listPstConcretes());
	        model.addAttribute("pstRoadPumpNos", pstService.listPstRoadPumpNo());
	        return "backoffice/template/job_manaement";
	    }
}
