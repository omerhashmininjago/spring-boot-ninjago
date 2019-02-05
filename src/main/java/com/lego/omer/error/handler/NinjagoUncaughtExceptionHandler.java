package com.lego.omer.error.handler;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NinjagoUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(NinjagoUncaughtExceptionHandler.class);

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        LOG.error("Uncaught exception occurred; thread {} :: exception {}", t.getName(), ExceptionUtils.getRootCauseMessage(e), e);
    }
}
