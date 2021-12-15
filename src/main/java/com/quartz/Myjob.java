package com.quartz;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
@DisallowConcurrentExecution
public class Myjob  implements Job {
    private  static int num =0;
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        num++;

        System.out.println(num+""+context);
    }
}
