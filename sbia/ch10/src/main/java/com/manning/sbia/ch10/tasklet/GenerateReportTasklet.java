/**
 * 
 */
package com.manning.sbia.ch10.tasklet;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import com.manning.sbia.ch10.batch.BatchService;

/**
 * @author acogoluegnes
 *
 */
public class GenerateReportTasklet implements Tasklet {
	
	private BatchService batchService;

	/* (non-Javadoc)
	 * @see org.springframework.batch.core.step.tasklet.Tasklet#execute(org.springframework.batch.core.StepContribution, org.springframework.batch.core.scope.context.ChunkContext)
	 */
	@Override
	public RepeatStatus execute(StepContribution contribution,
			ChunkContext chunkContext) throws Exception {
		batchService.generateReport(chunkContext.getStepContext().getStepExecution().getJobExecution());
		return RepeatStatus.FINISHED;
	}

	public void setBatchService(BatchService batchService) {
		this.batchService = batchService;
	}
	
}
