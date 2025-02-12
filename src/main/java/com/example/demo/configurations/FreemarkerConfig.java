package com.example.demo.configurations;

import freemarker.template.Configuration;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class FreemarkerConfig {
    private final Configuration configuration;
    private final PageVisitTag pageVisitTag;

    public FreemarkerConfig(Configuration configuration, PageVisitTag pageVisitTag) {
        this.configuration = configuration;
        this.pageVisitTag = pageVisitTag;
    }

    @Bean
    public Configuration configureCustomTags() {
        configuration.setSharedVariable("pageVisit", pageVisitTag);
        return configuration;
    }
}
