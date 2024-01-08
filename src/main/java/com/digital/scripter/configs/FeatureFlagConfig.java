package com.digital.scripter.configs;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Mohammad Aiub Khan
 * Created: 1/7/2024
 */

@Getter
@Setter
@ToString
public class FeatureFlagConfig {

    @JsonProperty("appName")
    private String appName;

    @JsonProperty("featureFlagDetails")
    private List<FeatureFlag> featureFlagDetails;

    @Getter
    @Setter
    public static class FeatureFlag {
        @JsonProperty("title")
        private String title;

        @JsonProperty("flagName")
        private String flagName;

        @JsonProperty("flagDesc")
        private String flagDesc;

        @JsonProperty("flagEnabledState")
        private boolean flagEnabledState;

        @JsonProperty("flagDeprecationDate")
        private String flagDeprecationDate;
    }
}
