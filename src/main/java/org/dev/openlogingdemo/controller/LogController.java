package org.dev.openlogingdemo.controller;

import org.dev.openlogging.marker.LogMarker;
import org.dev.openlogingdemo.dto.UserDTO;
import org.dev.openlogingdemo.dto.UserDTORecord;
import org.dev.openlogingdemo.service.LogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LogController {

    private final Logger logger = LoggerFactory.getLogger(LogController.class);

    private final LogService logService;
    public LogController(LogService logService) {
        this.logService = logService;
    }

    @GetMapping("/log")
    public String logMessage(String message) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername("greg");
        userDTO.setPassword("asfdf#r455a@1234");
        MDC.put("username",userDTO.getUsername());
        logger.info(LogMarker.APP_LOG,"This is my UserDTO :{}", userDTO);
        logger.info(LogMarker.APP_LOG,"This is my UserDTO ToString :{}", userDTO.toString());
        logger.info(LogMarker.APP_LOG,"This is my UserDTO Password :{}", "3453123454567435678765");
        logService.callAsync();
        MDC.clear();

        // With Records
        UserDTORecord userDTORecord = new UserDTORecord("adrian","asfdf#r455");

        MDC.put("usernames",userDTORecord.username());
        logger.info(LogMarker.APP_LOG,"This is my userDTORecord :{}", userDTORecord);
        logger.info(LogMarker.APP_LOG,"This is my userDTORecord ToString :{}", userDTORecord);
        logger.info(LogMarker.APP_LOG,"This is my userDTORecord Password :{}", "asfdf#r455");
        logger.info(LogMarker.APP_LOG,"This is my userDTORecord Raw Password :{}",userDTORecord.password());

        logService.callAsync();
        MDC.clear();

        return "Logged some messages! Check the console output.";
    }

}
