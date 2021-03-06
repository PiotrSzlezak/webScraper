package pl.ideopolis.webScraperTge.scheduler;

import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.ideopolis.webScraperTge.tge.service.TgeRdbService;
import pl.ideopolis.webScraperTge.tge.dataModel.RdbDTO;
import pl.ideopolis.webScraperTge.tge.dataModel.SummaryRdbDTO;
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

    private static final TgeRdbService TGE_RDB_SERVICE = new TgeRdbService();

    @Scheduled(fixedRate = TIME_INTERVAL_OF_TGE_DATA_DOWNLOAD)
    public void downloadTGEData() throws IOException {
        log.trace("downloadTGEData method.");
        log.info("Downloading TGE data. Time interval between each download = {}", ConvertDate.msToDayHourMinSec(TIME_INTERVAL_OF_TGE_DATA_DOWNLOAD));

        Document doc = TGE_RDB_SERVICE.downloadTodaysDocument();
        final List<RdbDTO> tableRdbDTOs = TGE_RDB_SERVICE.getTodaysTGETableDTO(doc);
        final SummaryRdbDTO summaryRdbDTO = TGE_RDB_SERVICE.getTodaysTGESummaryDTO(doc);
        String date = ConvertDate.convertDateToString(tableRdbDTOs.get(0).getDataDostawy(), "yyyy-MM-dd");

        saveToFile("tgeRdbDTOListjson", date, "txt", Json.toJson(tableRdbDTOs).toPrettyString());
        saveToFile("tgeSummaryRdbDTOListjson", date, "txt", Json.toJson(summaryRdbDTO).toPrettyString());
    }

    private void saveToFile(String fileName, String date, String extension, String file) {
        String name = fileName + " " + date + "." + extension;
        SaveToFile.saveToFile(name, SystemProperties.getPath(), file);
    }

    // TODO: doda?? obs??ug?? bazy danych. Mo??na zacz???? od h2.
    //   TODO: doda?? import z json do bazy danych.
    //   TODO: doda?? export z bazy danych do csv/xlsx i json.
    //   TODO: --opcjonalne     doda?? konwersj?? z json do csv/xlsx
    //   TODO: --opcjonalne     doda?? pobieranie bezpo??rednio do csv/xlsx
    // TODO: doda?? zapisywanie log??w do pliku z dan?? cz??stotliwo??ci?? np. dzienn??, lub przy konkretnych wydarzeniach np. jak poleci wyj??tek.
    // TODO: --odpali?? ca??o???? na drugim kompie, z linuxem
    // TODO: doda?? zmienne w pliku konfiguracyjnym (??cierzki do plik??w, adresy stron i api)
    // TOTO: config server
    // TODO: dopisa?? brakuj??ce testy.
    // TODO: Zamykanie aplikacji z poziomu terminala. Trzeba b??dzie pu??ci?? na oddzielnym w??tku.
    // TODO: doda?? funkcj?? pobieraj??c?? pe??n??, dost??pn?? histori?? ze strony. Wszystkie dane z ubieg??ych dni.
    // TODO: doda?? funkcj?? sprawdzaj??c?? pliki na dysku/baz?? danych, ??eby wyznaczy?? kt??rych danych brakuje. -- nie jestem pewny, czy to jest potrzebne
    // TODO: doda?? webowy panel kontrolny
}
