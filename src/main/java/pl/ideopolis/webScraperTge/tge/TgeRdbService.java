package pl.ideopolis.webScraperTge.tge;

import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.ideopolis.webScraperTge.tge.dataModel.RdbDTO;
import pl.ideopolis.webScraperTge.tge.dataModel.SummaryRdbDTO;
import pl.ideopolis.webScraperTge.utils.webScrapUtil.LoadDocument;

import java.io.IOException;
import java.util.List;

@Service
public class TgeRdbService {

    private final static Logger log = LoggerFactory.getLogger(TgeRdbService.class);

    private LoadDocument loadDocument = new LoadDocument();
    private String url;
    private PrepareURL prepareURL = new PrepareURL();
    private Document doc;

    public TgeRdbService() {
        log.trace("No parameter constructor.");
    }

    public List<RdbDTO> getTodaysTGETableDTO() throws IOException {
        log.trace("getTodaysTGETableDTO method.");
        url = prepareURL.getUrlForToday();
        doc = loadDocument(url);
        final List<RdbDTO> rdbDTOS = ScrapData.extractRdb(doc);
        return rdbDTOS;
    }

    public SummaryRdbDTO getTodaysTGESummaryDTO() throws IOException {
        log.trace("getTodaysTGESummaryDTO method.");
        url = prepareURL.getUrlForToday();
        doc = loadDocument(url);
        final SummaryRdbDTO summaryRdbDTO = ScrapData.extractPodsumowanieRdb(doc);
        return summaryRdbDTO;
    }

    public List<RdbDTO> getTGETableFromGivenDateDTO(String date) throws IOException {
        log.trace("getTGETableFromGivenDateDTO method.");
        prepareURL.setDate(date);
        url = prepareURL.geUrlForAnyDate();
        doc = loadDocument(url);
        final List<RdbDTO> rdbDTOS = ScrapData.extractRdb(doc);
        return rdbDTOS;
    }

    public SummaryRdbDTO getTGESummaryFromGivenDateDTO(String date) throws IOException {
        log.trace("getTGESummaryFromGivenDateDTO method.");
        prepareURL.setDate(date);
        url = prepareURL.geUrlForAnyDate();
        doc = loadDocument(url);
        final SummaryRdbDTO summaryRdbDTO = ScrapData.extractPodsumowanieRdb(doc);
        return summaryRdbDTO;
    }

    private Document loadDocument(String url) throws IOException {
        log.trace("loadDocument method.");
        loadDocument.setUrl(url);
        loadDocument.connect();
        return loadDocument.getDoc();
    }

    public String dtosToString(List<RdbDTO> list) {
        log.trace("dtosToString method.");
        String listAsString = "";
        for (RdbDTO dto : list) {
            listAsString = listAsString + dto.toString() + "\n";
        }
        return listAsString;
    }
}
