package org.dstu.bpm;

import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
@ExternalTaskSubscription("check-package")
public class CheckPackageHandler implements ExternalTaskHandler {

    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {
        Map<String, Object> vars = new LinkedHashMap<>();
        vars.put("packageAvailable", false);

//        RestTemplate rt = new RestTemplate();
//        Object response = rt.getForObject("http://localhost:8082/JavaRest/rest/package/list", Object.class);
//        System.out.println(response);

        Logger.getLogger("check-package").log(Level.INFO, "Checked package availability");
        externalTaskService.complete(externalTask, vars);
    }
}