package uk.co.advancingfilm.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app") // Values are set in application.properties file
public record AppProperties(String contextId) {
}
