package org.telran.shop.en;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Service
public class ExampleServiceImpl implements ExampleService {

    private Logger log = LoggerFactory.getLogger(ExampleServiceImpl.class);

    @Override
    public void print(String text) {
        //ERROR (ERROR)
        //WARN (WARN,ERROR)
        //INFO (INFO,WARN,ERROR)
        //DEBUG (DEBUG,INFO,WARN,ERROR)
        //TRACE (TRACE,DEBUG,INFO,WARN,ERROR)
        log.error("Error message");
        log.warn("Warn message");
        log.info("Info message");
        log.debug("User data  {}", text);
        log.trace("Trace message - all logs");
    }

    //@Scheduled(fixedDelay = 5,initialDelay = 10, timeUnit = TimeUnit.SECONDS)
    @Scheduled(cron = "10 * * * * *")
    public void printSomethingBySchedule() throws InterruptedException {
        log.error("Scheduled task " + LocalDateTime.now());
        //Thread.sleep(10000);
    }
}
