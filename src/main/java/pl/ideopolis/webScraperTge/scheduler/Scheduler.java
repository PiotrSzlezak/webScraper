package pl.ideopolis.webScraperTge.scheduler;

import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.ideopolis.webScraperTge.tge.service.TgeRdbService;
import pl.ideopolis.webScraperTge.tge.dataModel.RdbDTO;
import pl.ideopolis.webScraperTge.tge.dataModel.RdbSummaryDTO;
import pl.ideopolis.webScraperTge.utils.ConvertDate;
import pl.ideopolis.webScraperTge.utils.SaveToFile;
import pl.ideopolis.webScraperTge.utils.SystemProperties;
import pl.ideopolis.webScraperTge.utils.jsonUtils.Json;

import java.io.IOException;
import java.util.List;

@Component
public class Scheduler {

    private final static Logger log = LoggerFactory.getLogger(SaveToFile.class);

    private static final int SECOND = 1000;
    private static final int MINUTE = 60 * SECOND;
    private static final int HOUR = 60 * MINUTE;
    private static final int DAY = 24 * HOUR;
    private static final int TIME_INTERVAL_OF_TGE_DATA_DOWNLOAD = 12 * HOUR;

    private final TgeRdbService tgeRdbService;

    public Scheduler(TgeRdbService service){
        this.tgeRdbService = service;
    }

    @Scheduled(fixedRate = TIME_INTERVAL_OF_TGE_DATA_DOWNLOAD)
    public void downloadTGEData() throws IOException {
        log.trace("downloadTGEData method.");
        log.info("Downloading TGE data. Time interval between each download = {}", ConvertDate.msToDayHourMinSec(TIME_INTERVAL_OF_TGE_DATA_DOWNLOAD));

        Document doc = tgeRdbService.downloadTodaysDocument();
        final List<RdbDTO> tableRdbDTOs = tgeRdbService.getTodaysTGETableDTO(doc);
        final RdbSummaryDTO rdbSummaryDTO = tgeRdbService.getTodaysTGESummaryDTO(doc);
        String date = ConvertDate.convertDateToString(tableRdbDTOs.get(0).getDataDostawy(), "yyyy-MM-dd");

        saveToFile("tgeRdbDTOListjson", date, "txt", Json.toJson(tableRdbDTOs).toPrettyString());
        saveToFile("tgeSummaryRdbDTOListjson", date, "txt", Json.toJson(rdbSummaryDTO).toPrettyString());
    }

    private void saveToFile(String fileName, String date, String extension, String file) {
        String name = fileName + " " + date + "." + extension;
        SaveToFile.saveToFile(name, SystemProperties.getPath(), file);
    }

    // TODO: dodać obsługę bazy danych. Można zacząć od h2.
    //   TODO: dodać import z json do bazy danych.
    //   TODO: dodać export z bazy danych do csv/xlsx i json.
    //   TODO: --opcjonalne     dodać konwersję z json do csv/xlsx
    //   TODO: --opcjonalne     dodać pobieranie bezpośrednio do csv/xlsx
    // TODO: dodać zapisywanie logów do pliku z daną częstotliwością np. dzienną, lub przy konkretnych wydarzeniach np. jak poleci wyjątek.
    // TODO: --odpalić całość na drugim kompie, z linuxem
    // TODO: dodać zmienne w pliku konfiguracyjnym (ścierzki do plików, adresy stron i api)
    // TOTO: config server
    // TODO: dopisać brakujące testy.
    // TODO: Zamykanie aplikacji z poziomu terminala. Trzeba będzie puścić na oddzielnym wątku.
    // TODO: dodać funkcję pobierającą pełną, dostępną historię ze strony. Wszystkie dane z ubiegłych dni.
    // TODO: dodać funkcję sprawdzającą pliki na dysku/bazę danych, żeby wyznaczyć których danych brakuje. -- nie jestem pewny, czy to jest potrzebne
    // TODO: dodać webowy panel kontrolny
}
