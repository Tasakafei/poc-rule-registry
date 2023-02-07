package com.capgemini.poc_chain_of_responsabilities.domain.rules;

public abstract class AbstractRule {
    protected AbstractRule nextRule;

    public abstract boolean isAdmissible(String myInput);


}
