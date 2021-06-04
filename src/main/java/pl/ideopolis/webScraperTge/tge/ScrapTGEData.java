package pl.ideopolis.webScraperTge.tge;

import org.jsoup.nodes.Document;
import pl.ideopolis.webScraperTge.tge.dataModel.TgePodsumowanieRdbDTO;
import pl.ideopolis.webScraperTge.tge.dataModel.TgeRdbDTO;

import java.util.List;

public class ScrapTGEData {

    public static List<TgeRdbDTO> extractRdb(Document document){
        System.out.println("ScrapTGEData - extractRdb");
        ExtractTgeRdbDTO extractTgeRdbDTO = new ExtractTgeRdbDTO(document);
        return extractTgeRdbDTO.getTgeRdbDTOList();
    }

    public static TgePodsumowanieRdbDTO extractPodsumowanieRdb(Document document){
        System.out.println("ScrapTGEData - extractPodsumowanieRdb");
        ExtractTgePodsumowanieRdbDTO extractTgePodsumowanieRdbDTO = new ExtractTgePodsumowanieRdbDTO(document);
        return extractTgePodsumowanieRdbDTO.getTgePodsumowanieRdbDTO();
    }
}
