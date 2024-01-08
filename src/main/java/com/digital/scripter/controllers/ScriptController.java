package com.digital.scripter.controllers;

import com.digital.scripter.beans.FlagPair;
import com.digital.scripter.configs.FeatureFlagConfig;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mohammad Aiub Khan
 * Created: 1/6/2024
 */
@RestController
@RequestMapping("/scripts")
public class ScriptController {
    //https://www.baeldung.com/jackson-yaml
    private final ObjectMapper yamlObjectMapper;


    public ScriptController(ObjectMapper yamlObjectMapper) {
        this.yamlObjectMapper = yamlObjectMapper;
    }

    @RequestMapping("/greet")
    public ResponseEntity<String> greetings() {
        return new ResponseEntity<>("Welcome", HttpStatus.OK);
    }

    @RequestMapping("/convert")
    public ResponseEntity<String> convert() throws Exception {
        String yamlFilePath = "src/main/resources/input.yml";
        FeatureFlagConfig ffc = yamlObjectMapper.readValue(new File(yamlFilePath), FeatureFlagConfig.class);

        Map<String, FlagPair<String, Boolean>> flags = new HashMap<>();
        for (FeatureFlagConfig.FeatureFlag featureFlag : ffc.getFeatureFlagDetails()) {
            flags.put(featureFlag.getFlagName().toLowerCase(), new FlagPair<>(featureFlag.getFlagName(), featureFlag.isFlagEnabledState()));
        }


        StringBuilder sb = new StringBuilder("flags:");
        sb.append("<br/>");
        StringBuilder sb2 = new StringBuilder("values:");
        sb2.append("<br/>");

        flags.keySet().forEach(k -> {
            sb.append("&emsp;").append(k.toLowerCase()).append(":");
            sb.append("<br/>&emsp;&emsp;&emsp;name: ").append(k).append("<br/>");

            sb2.append("&emsp;").append(k.toLowerCase()).append(":");
            sb2.append("<br/>&emsp;&emsp;&emsp;enabled: '").append(flags.get(k).getSecond()).append("'<br/>");
        });

        sb.append("<br/>").append(sb2);


        return new ResponseEntity<>(sb.toString(), HttpStatus.OK);
    }

}
