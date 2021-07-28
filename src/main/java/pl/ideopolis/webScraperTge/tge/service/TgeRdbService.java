package pl.ideopolis.webScraperTge.tge.service;

import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.ideopolis.webScraperTge.tge.PrepareURL;
import pl.ideopolis.webScraperTge.tge.ScrapData;
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

    public Document downloadTodaysDocument() throws IOException {
        String url = prepareURL.getUrlForToday();
        return loadDocument.setUrl(url).configure().connect().getDoc();
    }

    public List<RdbDTO> getTodaysTGETableDTO() throws IOException {
        log.trace("getTodaysTGETableDTO method with no parameters.");
        url = prepareURL.getUrlForToday();
        doc = loadDocument(url);
        final List<RdbDTO> rdbDTOS = ScrapData.extractRdb(doc);
        return rdbDTOS;
    }

    public List<RdbDTO> getTodaysTGETableDTO(Document doc) throws IOException {
        log.trace("getTodaysTGETableDTO method with Document parameter.");
        final List<RdbDTO> rdbDTOS = ScrapData.extractRdb(doc);
        return rdbDTOS;
    }

    public SummaryRdbDTO getTodaysTGESummaryDTO() throws IOException {
        log.trace("getTodaysTGESummaryDTO method with no parameters.");
        url = prepareURL.getUrlForToday();
        doc = loadDocument(url);
        final SummaryRdbDTO summaryRdbDTO = ScrapData.extractPodsumowanieRdb(doc);
        return summaryRdbDTO;
    }

    public SummaryRdbDTO getTodaysTGESummaryDTO(Document doc) throws IOException {
        log.trace("getTodaysTGESummaryDTO method with Document parameter.");
        final SummaryRdbDTO summaryRdbDTO = ScrapData.extractPodsumowanieRdb(doc);
        return summaryRdbDTO;
    }

    public List<RdbDTO> getTGETableFromGivenDateDTO(String date) throws IOException {
        log.trace("getTGETableFromGivenDateDTO method.");
        doc = loadDocument(prepareURL.specifyDate(date).geUrlForAnyDate());
        final List<RdbDTO> rdbDTOS = ScrapData.extractRdb(doc);
        return rdbDTOS;
    }

    public SummaryRdbDTO getTGESummaryFromGivenDateDTO(String date) throws IOException {
        log.trace("getTGESummaryFromGivenDateDTO method.");
        doc = loadDocument(prepareURL.specifyDate(date).geUrlForAnyDate());
        final SummaryRdbDTO summaryRdbDTO = ScrapData.extractPodsumowanieRdb(doc);
        return summaryRdbDTO;
    }

    private Document loadDocument(String url) throws IOException {
        log.trace("loadDocument method.");
        return loadDocument.setUrl(url).configure().connect().getDoc();
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
