package com.capgemini.poc_chain_of_responsabilities.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import com.capgemini.poc_chain_of_responsabilities.domain.annotations.Rule;
import com.capgemini.poc_chain_of_responsabilities.domain.rules.AbstractRule;


public class RuleRegistry {

    Map<String, AbstractRule> rules;

    public RuleRegistry() {
        rules = new HashMap<>();
        ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(false);
        provider.addIncludeFilter(new AnnotationTypeFilter(Rule.class));
        Set<BeanDefinition> beanDefs = provider
                .findCandidateComponents("com.capgemini.poc_chain_of_responsabilities.domain.rules");
        for (BeanDefinition bd : beanDefs) {
            if (bd instanceof AnnotatedBeanDefinition) {
                Map<String, Object> annotAttributeMap = ((AnnotatedBeanDefinition) bd)
                        .getMetadata()
                        .getAnnotationAttributes(Rule.class.getCanonicalName());
                rules.put(annotAttributeMap.get("name").toString(), null);
            }
        }
    }

    public Map<String, AbstractRule> getRules() {
        return rules;
    }
}
