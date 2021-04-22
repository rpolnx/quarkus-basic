package br.com.rpolnx.quarkus_basics.scheduller;

import br.com.rpolnx.quarkus_basics.service.Dota2Service;
import io.quarkus.scheduler.Scheduled;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@Slf4j
@RequiredArgsConstructor
public class SchedulerBasicCall {
    private Long initial = System.currentTimeMillis();

    private final Dota2Service service;

    @Scheduled(cron = "{cron.interval}")
    public void listen() {
        log.info("Hello counter from start {} ms", System.currentTimeMillis() - initial);

        service.execute();
    }
}
