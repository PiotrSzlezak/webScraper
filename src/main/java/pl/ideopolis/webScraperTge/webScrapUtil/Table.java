package pl.ideopolis.webScraperTge.webScrapUtil;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Table {

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

    public Table(Document document, String id) {
        System.out.println("Table constructor");
        this.document = document;
        this.id = id;
        System.out.println(" id = " + id);
        extractTable(id);
        extractTableElements();
    }

    private void extractTable(String id) {
        System.out.println("  extractTable method");
        this.element = document.getElementById(id);
        System.out.println(element.html());
    }

    private void extractTableElements() {
        System.out.println("  extractTableElements method");
        this.thead = element.select(theadQuery);
        System.out.println("   thead contains " + thead.size() + " elements");
        this.theadRows = thead.select("tr");
        System.out.println("   theadRows contains " + theadRows.size() + " elements");
        this.tbody = element.select(tbodyQuery);
        System.out.println("   tbody contains " + tbody.size() + " elements");
        this.tbodyRows = tbody.select("tr");
        System.out.println("   tbodyRows contains " + tbodyRows.size() + " elements");
        this.tfoot = element.select(tfootQuery);
        System.out.println("   tfoot contains " + tfoot.size() + " elements");
        this.tfootRows = tfoot.select("tr");
        System.out.println("   tfootRows contains " + tfootRows.size() + " elements");
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
