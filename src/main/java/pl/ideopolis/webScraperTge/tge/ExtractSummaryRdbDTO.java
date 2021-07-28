package pl.ideopolis.webScraperTge.tge;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.ideopolis.webScraperTge.tge.dataModel.RdbSummaryDTO;
import pl.ideopolis.webScraperTge.utils.BigDecimalConvertion;
import pl.ideopolis.webScraperTge.utils.ConvertDate;
import pl.ideopolis.webScraperTge.utils.webScrapUtil.HtmlTable;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

class ExtractSummaryRdbDTO {

    private final static Logger log = LoggerFactory.getLogger(ExtractSummaryRdbDTO.class);

    private final RdbSummaryDTO rdbSummaryDTO;
    private final HtmlTable htmlTable;
    private final String tableId = "footable_kontrakty_godzinowe";
    private final String tablePlnClass = ".table-pln";
    private final String tableEurClass = ".table-eur";

    public ExtractSummaryRdbDTO(Document document) {
        log.trace("Document constructor.");
        this.htmlTable = new HtmlTable(document, tableId);
        this.rdbSummaryDTO = new RdbSummaryDTO();
    }

    public RdbSummaryDTO getTgeSummaryRdbDTO() {
        log.trace("getTgeSummaryRdbDTO method.");
        collectDataForTgeSummaryRdb();
        return rdbSummaryDTO;
    }

    private void collectDataForTgeSummaryRdb() {
        log.info("collectDataForTgeSummaryRdb method.");
        collectDataDostawy();

        collectMinKursMinMWh();
        collectMaksKursMinMWh();

        collectMinKursMaksMWh();
        collectMaksKursMaksMWh();

        collectMinOstatniKursMWh();
        collectMaksOstatniKursMWh();

        collectSumaLacznyWolumenMWh();
    }

    private void collectDataDostawy() {
        log.trace("collectDataDostawy method.");
        final String dataDostawyAsString = extractRow(htmlTable.getTheadRows(), 0, "th", 2).text();
        final Optional<LocalDate> dateOptional = ConvertDate.convertStringToLocalDate(dataDostawyAsString, "yyyy-MM-dd");
        if (dateOptional.isPresent()) {
            rdbSummaryDTO.setDataDostawy(dateOptional.get());
        } else {
            log.error("String to date conversion was not successful. dataDostawyAsString = {}", dataDostawyAsString);
        }
    }

    private void collectMinKursMinMWh() {
        log.trace("collectMinKursMinMWh method.");
        final Element row = extractRow(htmlTable.getTfootRows(), 0, "td", 2);
        final String pln = row.select(tablePlnClass).text();
        final String eur = row.select(tableEurClass).text();
        final Optional<BigDecimal> optionalPln = BigDecimalConvertion.stringToBigDecimal(pln);
        if (optionalPln.isPresent()) {
            rdbSummaryDTO.setMinKursMinPlnMWh(optionalPln.get());
        }
        final Optional<BigDecimal> optionalEur = BigDecimalConvertion.stringToBigDecimal(eur);
        if (optionalEur.isPresent()) {
            rdbSummaryDTO.setMinKursMinEurMWh(optionalEur.get());
        }
    }

    private void collectMaksKursMinMWh() {
        log.trace("collectMaksKursMinMWh method.");
        final Element row = extractRow(htmlTable.getTfootRows(), 1, "td", 2);
        final String pln = row.select(tablePlnClass).text();
        final String eur = row.select(tableEurClass).text();
        final Optional<BigDecimal> optionalPln = BigDecimalConvertion.stringToBigDecimal(pln);
        if (optionalPln.isPresent()) {
            rdbSummaryDTO.setMaksKursMinPlnMWh(optionalPln.get());
        }
        final Optional<BigDecimal> optionalEur = BigDecimalConvertion.stringToBigDecimal(eur);
        if (optionalEur.isPresent()) {
            rdbSummaryDTO.setMaksKursMinEurMWh(optionalEur.get());
        }
    }


    private void collectMinKursMaksMWh() {
        log.trace("collectMinKursMaksMWh method.");
        final Element row = extractRow(htmlTable.getTfootRows(), 0, "td", 3);
        final String pln = row.select(tablePlnClass).text();
        final String eur = row.select(tableEurClass).text();
        final Optional<BigDecimal> optionalPln = BigDecimalConvertion.stringToBigDecimal(pln);
        if (optionalPln.isPresent()) {
            rdbSummaryDTO.setMinKursMaksPlnMWh(optionalPln.get());
        }
        final Optional<BigDecimal> optionalEur = BigDecimalConvertion.stringToBigDecimal(eur);
        if (optionalEur.isPresent()) {
            rdbSummaryDTO.setMinKursMaksEurMWh(optionalEur.get());
        }
    }

    private void collectMaksKursMaksMWh() {
        log.trace("collectMaksKursMaksMWh method.");
        final Element row = extractRow(htmlTable.getTfootRows(), 1, "td", 3);
        final String pln = row.select(tablePlnClass).text();
        final String eur = row.select(tableEurClass).text();
        final Optional<BigDecimal> optionalPln = BigDecimalConvertion.stringToBigDecimal(pln);
        if (optionalPln.isPresent()) {
            rdbSummaryDTO.setMaksKursMaksPlnMWh(optionalPln.get());
        }
        final Optional<BigDecimal> optionalEur = BigDecimalConvertion.stringToBigDecimal(eur);
        if (optionalEur.isPresent()) {
            rdbSummaryDTO.setMaksKursMaksEurMWh(optionalEur.get());
        }
    }


    private void collectMinOstatniKursMWh() {
        log.trace("collectMinOstatniKursMWh method.");
        final Element row = extractRow(htmlTable.getTfootRows(), 0, "td", 4);
        final String pln = row.select(tablePlnClass).text();
        final String eur = row.select(tableEurClass).text();
        final Optional<BigDecimal> optionalPln = BigDecimalConvertion.stringToBigDecimal(pln);
        if (optionalPln.isPresent()) {
            rdbSummaryDTO.setMinOstatniKursPlnMWh(optionalPln.get());
        }
        final Optional<BigDecimal> optionalEur = BigDecimalConvertion.stringToBigDecimal(eur);
        if (optionalEur.isPresent()) {
            rdbSummaryDTO.setMinOstatniKursEurMWh(optionalEur.get());
        }
    }

    private void collectMaksOstatniKursMWh() {
        log.trace("collectMaksOstatniKursMWh method.");
        final Element row = extractRow(htmlTable.getTfootRows(), 1, "td", 4);
        final String pln = row.select(tablePlnClass).text();
        final String eur = row.select(tableEurClass).text();
        final Optional<BigDecimal> optionalPln = BigDecimalConvertion.stringToBigDecimal(pln);
        if (optionalPln.isPresent()) {
            rdbSummaryDTO.setMaksOstatniKursPlnMWh(optionalPln.get());
        }
        final Optional<BigDecimal> optionalEur = BigDecimalConvertion.stringToBigDecimal(eur);
        if (optionalEur.isPresent()) {
            rdbSummaryDTO.setMaksOstatniKursEurMWh(optionalEur.get());
        }
    }


    private void collectSumaLacznyWolumenMWh() {
        log.trace("collectSumaLacznyWolumenMWh method.");
        final Element row = extractRow(htmlTable.getTfootRows(), 2, "td", 5);
        final String mwh = row.text();
        final Optional<BigDecimal> optionalLacznyWolumenMwh = BigDecimalConvertion.stringToBigDecimal(mwh);
        if (optionalLacznyWolumenMwh.isPresent()) {
            rdbSummaryDTO.setSumaLacznyWolumenMWh(optionalLacznyWolumenMwh.get());
        }
    }

    private Element extractRow(Elements rows, int row, String thOrTd, int column) {
        log.trace("extractRow method.");
        return rows.get(row).select(thOrTd).get(column);
    }

}
