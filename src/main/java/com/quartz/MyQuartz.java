package com.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.calendar.HolidayCalendar;

import javax.xml.validation.SchemaFactory;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class MyQuartz {
    public static void main(String[] args) throws Exception {
        Scheduler defaultScheduler = StdSchedulerFactory.getDefaultScheduler();
        defaultScheduler.getContext().put("sche_name","张三");
        HolidayCalendar cal = new HolidayCalendar();
        cal.addExcludedDate(new Date());
        defaultScheduler.addCalendar("myHolidays",cal,false,false);
        TriggerBuilder<Trigger> trigger = TriggerBuilder.newTrigger();
        trigger.withIdentity("triger1","group1");
        trigger.usingJobData("triger_sex","男");
        trigger.startAt(new Date());
//        Calendar instance = Calendar.getInstance();
//        instance.set(LocalDateTime.now().getYear(),LocalDateTime.now().getMonthValue(),LocalDateTime.now().getDayOfMonth()+1);
//        trigger.endAt( instance.getTime());
//        增加工作日
//        trigger.modifiedByCalendar("myHolidays");
        SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule();
//        Trigger trigger1 = trigger.withSchedule(simpleScheduleBuilder.withIntervalInSeconds(3).repeatForever()).build();
        Trigger trigger1 = trigger.withSchedule(CronScheduleBuilder.cronSchedule("0/3 * * * * ?")).build();
        trigger1.getJobDataMap().put("triger_age","21");

        JobDetail jobDetail =JobBuilder.newJob(Myjob.class).usingJobData("job_class","一年级").withIdentity("job_n","grop_job").build();
        jobDetail.getJobDataMap().put("job_class_02","二年级");
        defaultScheduler.scheduleJob(jobDetail,trigger1);
        defaultScheduler.start();
        /**
         * 停止
         */
        Thread.sleep(10000);
        if(defaultScheduler.checkExists(jobDetail.getKey())){
            defaultScheduler.pauseJob(jobDetail.getKey());
            System.out.println("停止job");
        }
        /**
         * 激活
         */
        Thread.sleep(10000);
        if(defaultScheduler.checkExists(jobDetail.getKey())){
            defaultScheduler.resumeJob(jobDetail.getKey());
            System.out.println("激活job");
        }
        Thread.sleep(10000);
        if(defaultScheduler.checkExists(jobDetail.getKey())){
            defaultScheduler.pauseJob(jobDetail.getKey());
            System.out.println("停止job");
        }
        /**
         * 立即执行
         */
        Thread.sleep(10000);
        if(defaultScheduler.checkExists(jobDetail.getKey())){
            defaultScheduler.triggerJob(jobDetail.getKey());
            System.out.println("立即执行job--只执行一次");
        }
        /**
         * 移除
         */
        defaultScheduler.deleteJob(jobDetail.getKey());
        if(!defaultScheduler.checkExists(jobDetail.getKey())){
            System.out.println("job已经移除！");
        }
        /**
         * 执行job
         */
        defaultScheduler.scheduleJob(jobDetail,trigger1);
        System.out.println("重新执行job");
    }
}
