package pl.ideopolis.webScraperTge.tge.dataModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class RdbDTO {

    private final static Logger log = LoggerFactory.getLogger(RdbDTO.class);

    private List<RdbTableDTO> tableDTOs;
    private RdbSummaryDTO summaryDTO;
    private List<RdbTable> tables;
    private RdbSummary summary;

    public RdbDTO (){
        log.trace("No parameter constructor.");
    }

    public List<RdbTableDTO> getTableDTOs() {
        return tableDTOs;
    }

    public RdbSummaryDTO getSummaryDTO() {
        return summaryDTO;
    }

    public List<RdbTable> getTables() {
        return tables;
    }

    public RdbSummary getSummary() {
        return summary;
    }

    public void setTableDTOs(List<RdbTableDTO> tableDTOs) {
        this.tableDTOs = tableDTOs;
        tableDTOsToTables();
    }

    public void setSummaryDTO(RdbSummaryDTO summaryDTO) {
        this.summaryDTO = summaryDTO;
        summaryDTOtoSummary();
    }

    private void tableDTOsToTables(){
        tables = new ArrayList<>();
        for (RdbTableDTO dto: tableDTOs) {
            tables.add(dto.toRdb());
        }
    }

    private void summaryDTOtoSummary(){
        summary = summaryDTO.toRdb();
    }

}
