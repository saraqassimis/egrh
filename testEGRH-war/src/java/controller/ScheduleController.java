package controller;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.LazyScheduleModel;
import org.primefaces.model.ScheduleModel;

public class ScheduleController implements Serializable {  
      
    private ScheduleModel lazyEventModel;  
  
    public ScheduleController() {  
        lazyEventModel = new LazyScheduleModel() {  
              
            @Override  
            public void loadEvents(Date start, Date end) {  
                clear();  
                  
                Date random = getRandomDate(start);  
                addEvent(new DefaultScheduleEvent("Lazy Event 1", random, random));  
                  
                random = getRandomDate(start);  
                addEvent(new DefaultScheduleEvent("Lazy Event 2", random, random));  
            }     
        };  
    }  
      
    public Date getRandomDate(Date base) {  
        Calendar date = Calendar.getInstance();  
        date.setTime(base);  
        date.add(Calendar.DATE, ((int) (Math.random()*30)) + 1);    //set random day of month  
          
        return date.getTime();  
    }  
      
    public ScheduleModel getLazyEventModel() {  
        return lazyEventModel;  
    }  
}  