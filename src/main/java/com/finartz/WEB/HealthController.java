package com.finartz.WEB;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * HealthController
 */
@RestController
public class HealthController {

    @RequestMapping(value = "/health", method = RequestMethod.GET)
    public Map<String, String> health(){


        HashMap<String, String> health = new HashMap<>();


        health.put("status", "ok");


        return health;
    }

}
