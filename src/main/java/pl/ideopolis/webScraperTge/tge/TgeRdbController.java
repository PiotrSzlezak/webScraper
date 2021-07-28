package pl.ideopolis.webScraperTge.tge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/tge")
public class TgeRdbController {

    private final static Logger log = LoggerFactory.getLogger(TgeRdbController.class);

    @Autowired
    private TgeRdbService tgeRdbService;

    @GetMapping("/todays_table")
    public String getTodaysTGETable() throws IOException {
        log.trace("getTodaysTGETable method.");
        return tgeRdbService.dtosToString(tgeRdbService.getTodaysTGETableDTO());
    }

    @GetMapping("/todays_summary")
    public String getTodaysTGESummary() throws IOException {
        log.trace("getTodaysTGESummary method.");
        return tgeRdbService.getTodaysTGESummaryDTO().toString();
    }

    @GetMapping("/table_from_given_date")
    public String getTGETableFromGivenDate(@RequestParam(required = true) String date) throws IOException { //@RequestParam(required = true) required is TRUE by default.
        log.trace("getTGETableFromGivenDate method.");
        return tgeRdbService.dtosToString(tgeRdbService.getTGETableFromGivenDateDTO(date));
    }

    @GetMapping("/summary_from_given_date")
    public String getTGESummaryFromGivenDate(@RequestParam(required = true) String date) throws IOException {
        log.trace("getTGESummaryFromGivenDate method.");
        return tgeRdbService.getTGESummaryFromGivenDateDTO(date).toString();
    }

}
