package org.dev.openlogingdemo.service;

import org.dev.openlogging.marker.LogMarker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class LogService {

    private final Logger logger = LoggerFactory.getLogger(LogService.class);

    @Async
    public void callAsync(){
        logger.info(LogMarker.APP_LOG,"Call Async Log Service");
    }

}
