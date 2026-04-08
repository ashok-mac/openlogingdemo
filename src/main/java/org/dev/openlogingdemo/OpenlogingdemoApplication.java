package org.dev.openlogingdemo;

import org.dev.openlogging.marker.LogMarker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OpenlogingdemoApplication {

    private static Logger logger = LoggerFactory.getLogger(OpenlogingdemoApplication.class);

    public static void main(String[] args) {

        logger.info(LogMarker.SYS_LOG,"SLF4J LoggerFactory Implementation is : {}", LoggerFactory.getILoggerFactory().getClass().getName());

        SpringApplication.run(OpenlogingdemoApplication.class, args);
    }

}
