package pl.ideopolis.webScraperTge.tge;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.ideopolis.webScraperTge.tge.dataModel.RdbTableDTO;
import pl.ideopolis.webScraperTge.utils.BigDecimalConvertion;
import pl.ideopolis.webScraperTge.utils.ConvertDate;
import pl.ideopolis.webScraperTge.utils.webScrapUtil.HtmlTable;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class ExtractRdbDTO {

    private final static Logger log = LoggerFactory.getLogger(ExtractRdbDTO.class);

    private RdbTableDTO rdbTableDTO;
    private final HtmlTable htmlTable;
    private final String tableId = "footable_kontrakty_godzinowe";
    private final String tablePlnClass = ".table-pln";
    private final String tableEurClass = ".table-eur";
    private int currentRow = 0;
    private final int numberOfRows;

    public ExtractRdbDTO(Document document) {
        log.trace("Document constructor.");
        this.htmlTable = new HtmlTable(document, tableId);
        this.rdbTableDTO = new RdbTableDTO();
        this.numberOfRows = htmlTable.getTbodyRows().size();
    }

    public List<RdbTableDTO> getTgeRdbDTOList() {
        log.trace("getTgeRdbDTOList method.");
        List tgeRdbDTOList = new ArrayList();
        for (int i = 0; i < numberOfRows; i++) {
            collectDataForTgeRdb();
            tgeRdbDTOList.add(rdbTableDTO);
            this.rdbTableDTO = new RdbTableDTO();
            currentRow++;
        }
        return tgeRdbDTOList;
    }

    private void collectDataForTgeRdb() {
        log.trace("collectDataForTgeRdb method.");
        collectDataDostawy();
        collectCzasPomiaru();
        collectKursMinMWh();
        collectKursMaksMWh();
        collectOstatniKursMWh();
        collectLacznyWolumenMWh();
    }

    private void collectDataDostawy() {
        log.trace("collectDataDostawy method.");
        final String dataDostawyAsString = extractRow(htmlTable.getTheadRows(), 0, "th", 2).text();
        final Optional<LocalDate> dateOptional = ConvertDate.convertStringToLocalDate(dataDostawyAsString, "yyyy-MM-dd");
        if (dateOptional.isPresent()) {
            rdbTableDTO.setDataDostawy(dateOptional.get());
        } else {
            log.error("String to date conversion was not successful. dataDostawyAsString = " + dataDostawyAsString);
        }
    }

    private void collectCzasPomiaru() {
        log.trace("collectCzasPomiaru method.");
        final String czasPomiaruAsString = extractRow(htmlTable.getTbodyRows(), currentRow, "td", 0).text();
        String[] strings = czasPomiaruAsString.split("-");
        rdbTableDTO.setPoczatekPomiaru(Integer.parseInt(strings[0]));
        rdbTableDTO.setKoniecPomiaru(Integer.parseInt(strings[1]));
    }

    private void collectKursMinMWh() {
        log.trace("collectKursMinMWh method.");
        final Element row = extractRow(htmlTable.getTbodyRows(), currentRow, "td", 2);
        final String pln = row.select(tablePlnClass).text();
        final String eur = row.select(tableEurClass).text();
        final Optional<BigDecimal> optionalPln = BigDecimalConvertion.stringToBigDecimal(pln);
        optionalPln.ifPresent(bigDecimal -> rdbTableDTO.setKursMinPlnMWh(bigDecimal));
        final Optional<BigDecimal> optionalEur = BigDecimalConvertion.stringToBigDecimal(eur);
        optionalEur.ifPresent(bigDecimal -> rdbTableDTO.setKursMinEurMWh(bigDecimal));
    }

    private void collectKursMaksMWh() {
        log.trace("collectKursMaksMWh method.");
        final Element row = extractRow(htmlTable.getTbodyRows(), currentRow, "td", 3);
        final String pln = row.select(tablePlnClass).text();
        final String eur = row.select(tableEurClass).text();
        final Optional<BigDecimal> optionalPln = BigDecimalConvertion.stringToBigDecimal(pln);
        optionalPln.ifPresent(bigDecimal -> rdbTableDTO.setKursMaksPlnMWh(bigDecimal));
        final Optional<BigDecimal> optionalEur = BigDecimalConvertion.stringToBigDecimal(eur);
        optionalEur.ifPresent(bigDecimal -> rdbTableDTO.setKursMaksEurMWh(bigDecimal));
    }

    private void collectOstatniKursMWh() {
        log.trace("collectOstatniKursMWh method.");
        final Element row = extractRow(htmlTable.getTbodyRows(), currentRow, "td", 4);
        final String pln = row.select(tablePlnClass).text();
        final String eur = row.select(tableEurClass).text();
        final Optional<BigDecimal> optionalPln = BigDecimalConvertion.stringToBigDecimal(pln);
        optionalPln.ifPresent(bigDecimal -> rdbTableDTO.setOstatniKursPlnMWh(bigDecimal));
        final Optional<BigDecimal> optionalEur = BigDecimalConvertion.stringToBigDecimal(eur);
        optionalEur.ifPresent(bigDecimal -> rdbTableDTO.setOstatniKursEurMWh(bigDecimal));
    }

    private void collectLacznyWolumenMWh() {
        log.trace("collectLacznyWolumenMWh method.");
        final Element row = extractRow(htmlTable.getTbodyRows(), currentRow, "td", 5);
        final Optional<BigDecimal> optionalLacznyWolumenMwh = BigDecimalConvertion.stringToBigDecimal(row.text());
        optionalLacznyWolumenMwh.ifPresent(bigDecimal -> rdbTableDTO.setLacznyWolumenMWh(bigDecimal));
    }

    private Element extractRow(Elements rows, int row, String thOrTd, int column) {
        log.trace("extractRow method.");
        return rows.get(row).select(thOrTd).get(column);
    }

}
