package pl.ideopolis.webScraperTge.scheduler;

import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.ideopolis.webScraperTge.tge.PrepareURL;
import pl.ideopolis.webScraperTge.tge.ScrapData;
import pl.ideopolis.webScraperTge.tge.TgeRdbService;
import pl.ideopolis.webScraperTge.tge.dataModel.RdbDTO;
import pl.ideopolis.webScraperTge.tge.dataModel.SummaryRdbDTO;
import pl.ideopolis.webScraperTge.utils.ConvertDate;
import pl.ideopolis.webScraperTge.utils.SaveToFile;
import pl.ideopolis.webScraperTge.utils.SystemProperties;
import pl.ideopolis.webScraperTge.utils.jsonUtils.Json;
import pl.ideopolis.webScraperTge.utils.webScrapUtil.LoadDocument;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

@Component
public class Scheduler {

    private final static Logger log = LoggerFactory.getLogger(SaveToFile.class);

    private static final int SECOND = 1000;
    private static final int MINUTE = 60 * SECOND;
    private static final int HOUR = 60 * MINUTE;
    private static final int DAY = 24 * HOUR;
    private static final int TIME_INTERVAL_OF_TGE_DATA_DOWNLOAD = 12 * HOUR;

    private static final TgeRdbService TGE_TGE_RDB_SERVICE = new TgeRdbService();

    @Scheduled(fixedRate = TIME_INTERVAL_OF_TGE_DATA_DOWNLOAD)
    public void downloadTGEData() throws IOException {
        log.trace("downloadTGEData method.");
        log.info("Downloading TGE data. Time interval between each download = {}ms", TIME_INTERVAL_OF_TGE_DATA_DOWNLOAD);

        Document doc = TGE_TGE_RDB_SERVICE.downloadTodaysDocument();
        final List<RdbDTO> tableRdbDTOs = TGE_TGE_RDB_SERVICE.getTodaysTGETableDTO(doc);
        final SummaryRdbDTO summaryRdbDTO = TGE_TGE_RDB_SERVICE.getTodaysTGESummaryDTO(doc);
        String date = ConvertDate.convertDateToString(tableRdbDTOs.get(0).getDataDostawy(), "yyyy-MM-dd");

        saveToFile("tgeRdbDTOListjson", date, "txt", Json.toJson(tableRdbDTOs).toPrettyString());
        saveToFile("tgeSummaryRdbDTOListjson", date, "txt", Json.toJson(summaryRdbDTO).toPrettyString());
    }

    private void saveToFile(String fileName, String date, String extension, String file){
        String name = fileName+" "+date+"."+extension;
        SaveToFile.saveToFile(name, SystemProperties.getPath(), file);
    }
// TODO: dopisać brakujące testy.
// TODO: dodać obsługę bazy danych. Można zacząć od h2.
// TODO: dodać import z json do bazy danych.
// TODO: dodać export z bazy danych do csv/xlsx i json.
// TODO: --odpalić całość na drugim kompie, z linuxem
// TODO: dodać zapisywanie logów do pliku z daną częstotliwością np. dzienną, lub przy konkretnych wydarzeniach np. jak poleci wyjątek.
// TODO: --opcjonalne     dodać konwersję z json do csv/xlsx
// TODO: --opcjonalne     dodać pobieranie bezpośrednio do csv/xlsx
// TODO: dodać funkcję pobierającą pełną, dostępną historię ze strony. Wszystkie dane z ubiegłych dni.
// TODO: dodać funkcję sprawdzającą pliki na dysku/bazę danych, żeby wyznaczyć których danych brakuje. -- nie jestem pewny, czy to jest potrzebne
// TODO: dodać webowy panel kontrolny
}
