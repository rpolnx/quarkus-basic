package br.com.rpolnx.quarkus_basics.service;

import br.com.rpolnx.quarkus_basics.model.dto.dota2.StatusDTO;
import br.com.rpolnx.quarkus_basics.model.entity.Dota2Entity;
import br.com.rpolnx.quarkus_basics.rest.Dota2Api;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.Random;

@Singleton
@Slf4j
public class Dota2ServiceImpl implements Dota2Service {

    @Inject
    @RestClient
    private Dota2Api dota2Api;

    @Override
    public void execute() {
        StatusDTO status = dota2Api.getStatus();
        List<StatusDTO.ApiPath> apiPaths = status.getApiPaths();

        long randomPosition = Math.round(new Random(System.currentTimeMillis()).nextDouble() * (apiPaths.size() - 1));

        StatusDTO.ApiPath apiPath = apiPaths.get((int) randomPosition);


        Object resource = dota2Api.getResource(apiPath.getHostname());


        Dota2Entity dota2Entity = new Dota2Entity(apiPath.getHostname(), resource);

        dota2Entity.persist();

        log.info("Payload {}", status);
    }
}
