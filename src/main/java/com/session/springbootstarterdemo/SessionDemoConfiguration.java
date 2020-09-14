package com.session.springbootstarterdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass({SessionDemoService.class})
@EnableConfigurationProperties(CommentProperties.class)
public class SessionDemoConfiguration {

    @Autowired
    private CommentProperties commentProperties;

    @Bean
    @ConditionalOnMissingBean(SessionDemoService.class)
    public SessionDemoService sessionDemoService() {
        SessionDemoService sessionDemoService = new SessionDemoService();
        sessionDemoService.setComments(commentProperties.getComments());
        return sessionDemoService;
    }

    @Bean
    @ConditionalOnProperty(value = "session.interface", havingValue = "interface1")
    public SessionInterface sessionInterface1 () {
        return new SessionInterfaceImpl1();
    }

    @Bean
    @ConditionalOnProperty(value = "session.interface", havingValue = "interface2")
    public SessionInterface sessionInterface2 () {
        return new SessionInterfaceImpl2();
    }
}
