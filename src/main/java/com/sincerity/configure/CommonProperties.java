package com.sincerity.configure;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(CommonProperties.PREFIX)
public class CommonProperties {

    public static final String PREFIX = "sincerity.common";

    /**
     * Word 模板路径
     */
    private String wordTemplatePath;
}
