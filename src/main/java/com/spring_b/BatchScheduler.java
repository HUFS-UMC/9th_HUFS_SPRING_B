package umc.demo;

import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BatchScheduler {

    public void printJob() {
        System.out.println("Executed at: " + new Date());
    }
}