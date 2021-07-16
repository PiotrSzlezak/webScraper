package pl.ideopolis.webScraperTge.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.ideopolis.webScraperTge.tge.TgeRdbService;
import pl.ideopolis.webScraperTge.tge.dataModel.RdbDTO;
import pl.ideopolis.webScraperTge.tge.dataModel.SummaryRdbDTO;
import pl.ideopolis.webScraperTge.utils.ConvertDate;
import pl.ideopolis.webScraperTge.utils.SaveToFile;
import pl.ideopolis.webScraperTge.utils.jsonUtils.Json;

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
    private static final int TIME_INTERVAL_OF_TGE_DATA_DOWNLOAD = 10 * SECOND;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    private static final TgeRdbService TGE_TGE_RDB_SERVICE = new TgeRdbService();
    private static final String path = "D:\\tge data\\";

    @Scheduled(fixedRate = TIME_INTERVAL_OF_TGE_DATA_DOWNLOAD)
    public void downloadTGEData() throws IOException {
        log.trace("downloadTGEData method.");
        log.info("Downloading TGE data. Time interval between each download = {}ms", TIME_INTERVAL_OF_TGE_DATA_DOWNLOAD);
        String date;
        final List<RdbDTO> todaysTGETableDTO = TGE_TGE_RDB_SERVICE.getTodaysTGETableDTO();
        final String todaysTGETableAsString = TGE_TGE_RDB_SERVICE.dtosToString(todaysTGETableDTO);
        date = ConvertDate.convertDateToString(todaysTGETableDTO.get(0).getDataDostawy(), "yyyy-MM-dd");
        String fileName = "tgeRdbDTOList " + date + ".txt";
        SaveToFile.saveToFile(fileName, path, todaysTGETableAsString);
        fileName = "tgeRdbDTOListjson " + date + ".txt";
        SaveToFile.saveToFile(fileName, path, Json.toJson(todaysTGETableDTO).toPrettyString());

        final SummaryRdbDTO todaysTGESummaryDTO = TGE_TGE_RDB_SERVICE.getTodaysTGESummaryDTO();
        final String todaysTGESummaryAsString = todaysTGESummaryDTO.toString();
        date = ConvertDate.convertDateToString(todaysTGESummaryDTO.getDataDostawy(), "yyyy-MM-dd");
        fileName = "tgeSummaryRdbDTOList " + date + ".txt";
        SaveToFile.saveToFile(fileName, path, todaysTGESummaryAsString);
        fileName = "tgeSummaryRdbDTOListjson " + date + ".txt";
        SaveToFile.saveToFile(fileName, path, Json.toJson(todaysTGESummaryDTO).toPrettyString());
    }
// TODO: optimize to not download same page multiple times
// TODO: dopisać brakujące testy.
// TODO: dodać obsługę bazy danych. Można zacząć od h2.
// TODO: dodać import z json do bazy danych.
// TODO: dodać export z bazy danych do csv/xlsx i json.
// TODO: --done--odpalić całość na drugim kompie, z linuxem
// TODO: dodać zapisywanie logów do pliku z daną częstotliwością np. dzienną, lub przy konkretnych wydarzeniach np. jak poleci wyjątek.
// TODO: --opcjonalne     dodać konwersję z json do csv/xlsx
// TODO: --opcjonalne     dodać pobieranie bezpośrednio do csv/xlsx
// TODO: dodać funkcję pobierającą pełną, dostępną historię ze strony. Wszystkie dane z ubiegłych dni.
// TODO: dodać funkcję sprawdzającą pliki na dysku/bazę danych, żeby wyznaczyć których danych brakuje. -- nie jestem pewny, czy to jest potrzebne
// TODO: dodać webowy panel kontrolny
}
