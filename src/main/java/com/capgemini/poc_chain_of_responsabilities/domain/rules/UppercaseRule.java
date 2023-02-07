package com.capgemini.poc_chain_of_responsabilities.domain.rules;

import org.apache.commons.lang3.StringUtils;

import com.capgemini.poc_chain_of_responsabilities.domain.annotations.Rule;

@Rule(name="Rule007")
public class UppercaseRule extends AbstractRule{

    @Override
    public boolean isAdmissible(String myInput) {
        if (StringUtils.isAllUpperCase(myInput)) {
            return true;
        } else {
            return nextRule.isAdmissible(myInput);
        }
    }
    
}
