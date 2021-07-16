package pl.ideopolis.webScraperTge.tge;

import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.ideopolis.webScraperTge.tge.dataModel.RdbDTO;
import pl.ideopolis.webScraperTge.tge.dataModel.SummaryRdbDTO;

import java.util.List;

public class ScrapData {

    private final static Logger log = LoggerFactory.getLogger(ScrapData.class);

    public static List<RdbDTO> extractRdb(Document document) {
        log.trace("extractRdb method.");
        ExtractRdbDTO extractRdbDTO = new ExtractRdbDTO(document);
        return extractRdbDTO.getTgeRdbDTOList();
    }

    public static SummaryRdbDTO extractPodsumowanieRdb(Document document) {
        log.trace("extractPodsumowanieRdb method.");
        ExtractSummaryRdbDTO extractSummaryRdbDTO = new ExtractSummaryRdbDTO(document);
        return extractSummaryRdbDTO.getTgeSummaryRdbDTO();
    }
}
