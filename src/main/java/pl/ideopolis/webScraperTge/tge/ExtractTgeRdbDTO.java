package pl.ideopolis.webScraperTge.tge;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import pl.ideopolis.webScraperTge.tge.dataModel.TgeRdbDTO;
import pl.ideopolis.webScraperTge.webScrapUtil.Table;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

class ExtractTgeRdbDTO {

    private Document document;
    private TgeRdbDTO tgeRdbDTO;
    private Table table;
    private String cssQuery = "footable_kontrakty_godzinowe";
    private int currentRow = 0;
    private int numberOfRows;
    private List tgeRdbDTOList;

    public ExtractTgeRdbDTO(Document document) {
        System.out.println("ExtractTgeRdbDTO constructor");
        this.document = document;
        this.table = new Table(document, cssQuery);
        this.tgeRdbDTO = new TgeRdbDTO();
        this.numberOfRows = table.getTbodyRows().size();
    }

    public List<TgeRdbDTO> getTgeRdbDTOList() {
        tgeRdbDTOList = new ArrayList();
        for (int i = 0; i < numberOfRows; i++) {
            collectTgeRdbData();
            tgeRdbDTOList.add(tgeRdbDTO);
            this.tgeRdbDTO = new TgeRdbDTO();
            currentRow++;
        }
        return tgeRdbDTOList;
    }

    private void collectTgeRdbData() {
        System.out.println("  collectTgeRdbData method");
        collectDataDostawy();
        collectCzasPomiaru();
        collectKursMinMWh();
        collectKursMaksMWh();
        collectOstatniKursMWh();
        collectLacznyWolumenMWh();
    }

    private void collectDataDostawy() {
        System.out.println("  collectDataDostawy method");
        final String dataDostawyAsString = extractRow(table.getTheadRows(), 0, "th", 2);
        System.out.println("   dataDostawy as String: " + dataDostawyAsString);
        final Optional<Date> dateOptional = convertStringToDate(dataDostawyAsString);
        if (dateOptional.isPresent()) {
            tgeRdbDTO.setDataDostawy(dateOptional.get());
            System.out.println("   dataDostawy: " + dateOptional.get());
        }
    }

    private Optional<Date> convertStringToDate(String dateAsString) {
        System.out.println("  convertStringToDate method");
        final String[] strings = dateAsString.split(" ");
        try {
            return Optional.of(new SimpleDateFormat("yyyy-MM-dd").parse(strings[2]));
        } catch (ParseException e) {
            System.out.println("   string could not be converted to date format.");
            e.printStackTrace();
        }
        return Optional.empty();
    }

    private void collectCzasPomiaru() {
        System.out.println("  collectCzasPomiaru method");
        final String czasPomiaruAsString = extractRow(table.getTbodyRows(), currentRow, "td", 0);
        String[] strings = convertStringToCzasPomiaru(czasPomiaruAsString);
        tgeRdbDTO.setPoczatekPomiaru(Integer.parseInt(strings[0]));
        System.out.println("   poczatekPomiaru: " + strings[0]);
        tgeRdbDTO.setKoniecPomiaru(Integer.parseInt(strings[1]));
        System.out.println("   koniecPomiaru: " + strings[1]);
    }

    private String[] convertStringToCzasPomiaru(String czasPomiaruAsString) {
        System.out.println("  convertStringToCzasPomiaru method");
        final String[] strings = czasPomiaruAsString.split("-");
        return strings;
    }

    private void collectKursMinMWh() {
        System.out.println("  collectsetKursMinMWh method");
        final String rowText = extractRow(table.getTbodyRows(), currentRow, "td", 2);
        final String[] strings = rowText.split(" ");
        System.out.println("   kursMinPlnMWH: " + strings[0]);
//        if(strings[0].equals("-")){ //todo dodać obsługę braku wartości w tabelce. Prawdopodobnie reprezentowaną przez "-"
        tgeRdbDTO.setKursMinPlnMWh(stringToBigDecimal(0, strings));
        System.out.println("   kursMinPlnMWH: " + strings[1]);
        tgeRdbDTO.setKursMinEurMWh(stringToBigDecimal(1, strings));
    }

    private BigDecimal stringToBigDecimal(int i, String[] strings) {
        BigDecimal bigDecimal;
        try {
            bigDecimal = new BigDecimal(strings[i].replace(",", "."));
        } catch (NumberFormatException e){
            bigDecimal = new BigDecimal("0");
        }
        return bigDecimal;
    }

    private void collectKursMaksMWh() {
        System.out.println("  collectKursMaksMWh method");
        final String rowText = extractRow(table.getTbodyRows(), currentRow, "td", 3);
        final String[] strings = rowText.split(" ");
        System.out.println("   kursMinPlnMWH: " + strings[0]);
        tgeRdbDTO.setKursMaksPlnMWh(stringToBigDecimal(0, strings));
        System.out.println("   kursMinPlnMWH: " + strings[1]);
        tgeRdbDTO.setKursMaksEurMWh(stringToBigDecimal(1, strings));
    }

    private String extractRow(Elements tbodyRows, int currentRow, String td, int i) {
        return tbodyRows.get(currentRow).select(td).get(i).text();
    }

    private void collectOstatniKursMWh() {
        System.out.println("  collectOstatniKursMWh method");
        final String rowText = extractRow(table.getTbodyRows(), currentRow, "td", 4);
        final String[] strings = rowText.split(" ");
        System.out.println("   kursMinPlnMWH: " + strings[0]);
        tgeRdbDTO.setOstatniKursPlnMWh(stringToBigDecimal(0, strings));
        System.out.println("   kursMinPlnMWH: " + strings[1]);
        tgeRdbDTO.setOstatniKursEurMWh(stringToBigDecimal(1, strings));
    }


    private void collectLacznyWolumenMWh() {
        System.out.println("  collectLacznyWolumenMWh method");
        final String rowText = extractRow(table.getTbodyRows(), currentRow, "td", 5);
        System.out.println("   kursMinPlnMWH: " + rowText);
        tgeRdbDTO.setLacznyWolumenMWh(new BigDecimal(rowText.replace(",", ".")));
    }

}
