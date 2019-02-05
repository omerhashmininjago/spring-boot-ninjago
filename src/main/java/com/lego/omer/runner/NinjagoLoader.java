package com.lego.omer.runner;

import com.google.common.collect.ImmutableSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

public final class NinjagoLoader {

    private static final Logger LOG = LoggerFactory.getLogger(NinjagoLoader.class);
    private static Set<String> legoType;

    // I wanted to demonstrate how Application Runner can be used to load data
    // This could have been replaced by an Enum for ease
    protected NinjagoLoader() {
        legoType = new HashSet<>();
        legoType.add("CLASSIC");
        legoType.add("DUPLO");
        LOG.info("Static Data Loaded");
    }

    public static Set<String> getLegoTypes() {
        return ImmutableSet.copyOf(legoType);
    }

}
