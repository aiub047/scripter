package com.digital.scripter.configs;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Mohammad Aiub Khan
 * Created: 1/7/2024
 */

@Getter
@Setter
public class FeatureFlag {
    private String flagName;
    private String flagDesc;
    private boolean flagEnabledState;
    private String flagDeprecationDate;

    //private List<Attribute> attributes;
    /*@Getter
    @Setter

    public static class Attribute {
        private String attributeKey;
        private String attributeType;
        private String attributeValue;
        private String attributeConstraintType;
        private String attributeConstraintValue;

    }*/
}
