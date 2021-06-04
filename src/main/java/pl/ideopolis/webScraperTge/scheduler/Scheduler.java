package pl.ideopolis.webScraperTge.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.config.ScheduledTask;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
public class Scheduler {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTask.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
//    private static final LoadPage loadPage = new LoadPage(); //todo
    private static final int TWELVE_HOURS = 12*60*60*1000;

    @Scheduled(fixedRate = TWELVE_HOURS)
    public void downloadTGEData(){
        //todo
    }

}
