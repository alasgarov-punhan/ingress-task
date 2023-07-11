package com.alasgarov.mspost.scheduler;

import com.alasgarov.mspost.service.TestService;
import lombok.RequiredArgsConstructor;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestScheduler {
    private final TestService testService;

    @Scheduled(fixedDelayString = "PT1M")
    @SchedulerLock(name = "test", lockAtLeastFor = "PT1M", lockAtMostFor = "PT5M")
    public void test(){
        testService.test();
    }
}
