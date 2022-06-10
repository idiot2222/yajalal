package me.bogeun.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
// 이거 yml은 아직 지원하지 않는다고 함.
@PropertySources(
    {
        @PropertySource("classpath:application-api.properties"),
        @PropertySource("classpath:application-jpa.properties")
    }
)
public class PropertyConfig {
}
