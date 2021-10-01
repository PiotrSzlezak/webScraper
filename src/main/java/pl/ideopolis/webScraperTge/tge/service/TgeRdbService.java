package pl.ideopolis.webScraperTge.tge.service;

import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ideopolis.webScraperTge.tge.PrepareURL;
import pl.ideopolis.webScraperTge.tge.ScrapData;
import pl.ideopolis.webScraperTge.tge.dataModel.RdbSummary;
import pl.ideopolis.webScraperTge.tge.dataModel.RdbSummaryDTO;
import pl.ideopolis.webScraperTge.tge.dataModel.RdbTable;
import pl.ideopolis.webScraperTge.tge.dataModel.RdbTableDTO;
import pl.ideopolis.webScraperTge.tge.repository.RdbRepository;
import pl.ideopolis.webScraperTge.tge.repository.RdbSummaryRepository;
import pl.ideopolis.webScraperTge.utils.webScrapUtil.LoadDocument;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TgeRdbService {

    private final static Logger log = LoggerFactory.getLogger(TgeRdbService.class);

    private final LoadDocument loadDocument;
    private final PrepareURL prepareURL;
    private final RdbRepository rdbRepo;
    private final RdbSummaryRepository rdbSummaryRepo;
    private String url;
    private Document doc;

    @Autowired
    public TgeRdbService(RdbRepository rdbRepository, RdbSummaryRepository rdbSummaryRepository) {
        log.trace("Constructor.");
        this.loadDocument = new LoadDocument();
        this.prepareURL = new PrepareURL();
        this.rdbRepo = rdbRepository;
        this.rdbSummaryRepo = rdbSummaryRepository;
    }

    public Document downloadTodaysDocument() throws IOException {
        String url = prepareURL.getUrlForToday();
        return loadDocument.setUrl(url).configure().connect().getDoc();
    }

    public List<RdbTableDTO> getTodaysTGETableDTO() throws IOException {
        log.trace("getTodaysTGETableDTO method with no parameters.");
        url = prepareURL.getUrlForToday();
        doc = loadDocument(url);
        return ScrapData.extractRdb(doc);
    }

    public List<RdbTableDTO> getTodaysTGETableDTO(Document doc) {
        log.trace("getTodaysTGETableDTO method with Document parameter.");
        return ScrapData.extractRdb(doc);
    }

    public RdbSummaryDTO getTodaysTGESummaryDTO() throws IOException {
        log.trace("getTodaysTGESummaryDTO method with no parameters.");
        url = prepareURL.getUrlForToday();
        doc = loadDocument(url);
        return ScrapData.extractPodsumowanieRdb(doc);
    }

    public RdbSummaryDTO getTodaysTGESummaryDTO(Document doc) {
        log.trace("getTodaysTGESummaryDTO method with Document parameter.");
        return ScrapData.extractPodsumowanieRdb(doc);
    }

    public List<RdbTableDTO> getTGETableFromGivenDateDTO(String date) throws IOException {
        log.trace("getTGETableFromGivenDateDTO method.");
        doc = loadDocument(prepareURL.specifyDate(date).geUrlForAnyDate());
        return ScrapData.extractRdb(doc);
    }

    public RdbSummaryDTO getTGESummaryFromGivenDateDTO(String date) throws IOException {
        log.trace("getTGESummaryFromGivenDateDTO method.");
        doc = loadDocument(prepareURL.specifyDate(date).geUrlForAnyDate());
        return ScrapData.extractPodsumowanieRdb(doc);
    }

    private Document loadDocument(String url) throws IOException {
        log.trace("loadDocument method.");
        return loadDocument.setUrl(url).configure().connect().getDoc();
    }

    public String dtosToString(List<RdbTableDTO> list) {
        log.trace("dtosToString method.");
        String listAsString = "";
        for (RdbTableDTO dto : list) {
            listAsString = listAsString + dto.toString() + "\n";
        }
        return listAsString;
    }

    @Transactional
    public List<RdbTable> saveTgeRdb(List<RdbTableDTO> dtos) {
        log.trace("saveTgeRdb method.");
        List<RdbTable> rdbTables = rdbDTOsToRdbs(dtos);
        return rdbRepo.saveAll(rdbTables);
    }

    public RdbSummary saveTgeRdbSummary(RdbSummaryDTO summaryDTO) {
        log.trace("saveTgeRdbSummary method.");
        return rdbSummaryRepo.save(summaryDTO.toRdb());
    }

    private List<RdbTable> rdbDTOsToRdbs(List<RdbTableDTO> dtos) {
        List<RdbTable> rdbTables = new ArrayList<>();
        for (RdbTableDTO dto : dtos) {
            rdbTables.add(dto.toRdb());
        }
        return rdbTables;
    }

}
