package pl.ideopolis.webScraperTge.tge;

import org.jsoup.nodes.Document;
import pl.ideopolis.webScraperTge.tge.dataModel.TgePodsumowanieRdbDTO;

class ExtractTgePodsumowanieRdbDTO {

    private Document document;
    private TgePodsumowanieRdbDTO tgePodsumowanieRdbDTO;

    public ExtractTgePodsumowanieRdbDTO(Document document) {
        System.out.println("ExtractTgePodsumowanieRdbDTO constructor");
        this.document = document;
    }

    public TgePodsumowanieRdbDTO getTgePodsumowanieRdbDTO() {
        return tgePodsumowanieRdbDTO;
    }
}
