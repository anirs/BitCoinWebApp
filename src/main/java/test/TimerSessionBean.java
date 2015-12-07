package test;
import java.util.Date;

import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.ejb.TimerService;


@Singleton
public class TimerSessionBean  {
  
	@Resource
    TimerService timerService;
	
//    @Schedule(second="*/10", minute="*",hour="*", persistent=false)
/*    public void doWork(){
        System.out.println("timer: "+new Date());
    }*/
    
}	