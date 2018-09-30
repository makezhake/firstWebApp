package com.mute.webapp.firstWebApp.batch;

import java.util.Date;

import org.springframework.batch.item.ItemProcessor;

public class TestProcesser implements ItemProcessor<BatchBO,BatchBO>  {
	
	 @Override
	    public BatchBO process(final BatchBO bo) throws Exception {
		 BatchBO result = new BatchBO();
		 result.setColumnA(bo.getColumnA()+new Date().toGMTString());
		 result.setColumnB(bo.getColumnB()+Math.random());
	       

	        return result;
	    }

}
