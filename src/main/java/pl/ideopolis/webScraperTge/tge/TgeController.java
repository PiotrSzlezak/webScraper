package pl.ideopolis.webScraperTge.tge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping("/TGE")
public class TgeController {

    private final static Logger log = LoggerFactory.getLogger(TgeController.class);

    @Autowired
    private TgeRdbService tgeRdbService;

    @GetMapping("/getTodaysTgeRdbData")
    public String getTodaysTgeRdbData() throws IOException {
        log.trace("getTodaysTgeRdbData method.");
        log.info("Get request at \"/TGE/getTodaysTgeRdbData\" received.");
        tgeRdbService.downloadTodaysDocument();
        return null;
    }

}
