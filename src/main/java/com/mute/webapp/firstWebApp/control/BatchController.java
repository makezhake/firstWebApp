package com.mute.webapp.firstWebApp.control;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BatchController {
	 @Autowired
	    JobLauncher jobLauncher;
	    @Autowired
	    Job job;
	
	@GetMapping("/batch")
    public String greeting(@RequestParam(name="jobgo", required=false, defaultValue="no") String nameA, Model model)throws Exception {
		 String name = "batch not triggered";
		
		if(nameA.equals("jobgo")) {
			//trigger the batch
			name = "batch is triggered";

			 jobLauncher.run(job, new JobParameters());
			
			
		}
		
		//   model.addAttribute("name", Math.random()+nameA+" "+nameB);
       
        model.addAttribute("name", name);
        return "batch";
    }

}
