package com.example.demo2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggingController {
    private static final Logger logger = LogManager.getLogger(LoggingController.class);

    @GetMapping("/log")
    public String logExample() {
        logger.info("InfoExample");
        logger.debug("DebugExample");
        logger.error("ErrorExample", new Exception("ExceptionExample"));

        return "Logging is finished";
    }

}
