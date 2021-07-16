package pl.ideopolis.webScraperTge.utils.webScrapUtil;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HtmlTable {

    private final static Logger log = LoggerFactory.getLogger(HtmlTable.class);

    private Document document;
    private Element element;
    private Elements thead;
    private Elements tbody;
    private Elements tfoot;
    private Elements theadRows;
    private Elements tbodyRows;
    private Elements tfootRows;

    private String id;
    private String theadQuery = "thead";
    private String tbodyQuery = "tbody";
    private String tfootQuery = "tfoot";

    public HtmlTable(Document document, String id) {
        log.trace("Document, String constructor.");
        this.document = document;
        this.id = id;
        extractTable(id);
        extractTableElements();
    }

    private void extractTable(String id) {
        log.trace("extractTable method.");
        this.element = document.getElementById(id);
    }

    private void extractTableElements() {
        log.trace("extractTableElements method.");
        this.thead = element.select(theadQuery);
        this.theadRows = thead.select("tr");
        this.tbody = element.select(tbodyQuery);
        this.tbodyRows = tbody.select("tr");
        this.tfoot = element.select(tfootQuery);
        this.tfootRows = tfoot.select("tr");
    }

    public Document getDocument() {
        return document;
    }

    public Element getElement() {
        return element;
    }

    public Elements getThead() {
        return thead;
    }

    public Elements getTbody() {
        return tbody;
    }

    public Elements getTfoot() {
        return tfoot;
    }

    public Elements getTheadRows() {
        return theadRows;
    }

    public Elements getTbodyRows() {
        return tbodyRows;
    }

    public Elements getTfootRows() {
        return tfootRows;
    }
}
