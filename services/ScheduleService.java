package com.bitcamp.services;

import com.bitcamp.domains.ScheduleBean;

public class ScheduleService { 
   private ScheduleBean[] schedulers;
   private int count;
   
   public ScheduleService() {
	   schedulers = new ScheduleBean[0];
	   count = 0;
   }
}
