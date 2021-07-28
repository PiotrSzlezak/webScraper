package pl.ideopolis.webScraperTge.tge;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import pl.ideopolis.webScraperTge.utils.BigDecimalConvertion;
import pl.ideopolis.webScraperTge.utils.ConvertDate;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SummaryRdbDTO {

    private final static Logger log = LoggerFactory.getLogger(SummaryRdbDTO.class);

    @JsonProperty("data_dostawy")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dataDostawy;

    @JsonProperty("min_kurs_min_Pln_MWh")
    private BigDecimal minKursMinPlnMWh;
    @JsonProperty("maks_kurs_min_Pln_MWh")
    private BigDecimal maksKursMinPlnMWh;
    @JsonProperty("min_kurs_min_Eur_MWh")
    private BigDecimal minKursMinEurMWh;
    @JsonProperty("maks_kurs_min_Eur_MWh")
    private BigDecimal maksKursMinEurMWh;

    @JsonProperty("min_kurs_maks_Pln_MWh")
    private BigDecimal minKursMaksPlnMWh;
    @JsonProperty("maks_kurs_maks_Pln_MWh")
    private BigDecimal maksKursMaksPlnMWh;
    @JsonProperty("min_kurs_maks_Eur_MWh")
    private BigDecimal minKursMaksEurMWh;
    @JsonProperty("maks_kurs_maks_Eur_MWh")
    private BigDecimal maksKursMaksEurMWh;

    @JsonProperty("min_ostatni_ours_Pln_MWh")
    private BigDecimal minOstatniKursPlnMWh;
    @JsonProperty("maks_ostatni_kurs_Pln_MWh")
    private BigDecimal maksOstatniKursPlnMWh;
    @JsonProperty("min_ostatni_kurs_Eur_MWh")
    private BigDecimal minOstatniKursEurMWh;
    @JsonProperty("maks_ostatni_kurs_Eur_MWh")
    private BigDecimal maksOstatniKursEurMWh;

    @JsonProperty("suma_laczny_wolumen_MWh")
    private BigDecimal sumaLacznyWolumenMWh;

    public SummaryRdbDTO() {
        log.trace("No parameter constructor.");
    }

    public SummaryRdbDTO(SummaryRdb rdb) {
        log.trace("Constructor from SummaryRdb.");
        this.dataDostawy = rdb.getDataDostawy();
        this.minKursMinPlnMWh = rdb.getMinKursMinPlnMWh();
        this.maksKursMinPlnMWh = rdb.getMaksKursMinPlnMWh();
        this.minKursMinEurMWh = rdb.getMinKursMinEurMWh();
        this.maksKursMinEurMWh = rdb.getMaksKursMinEurMWh();
        this.minKursMaksPlnMWh = rdb.getMinKursMaksPlnMWh();
        this.maksKursMaksPlnMWh = rdb.getMaksKursMaksPlnMWh();
        this.minKursMaksEurMWh = rdb.getMinKursMaksEurMWh();
        this.maksKursMaksEurMWh = rdb.getMaksKursMaksEurMWh();
        this.minOstatniKursPlnMWh = rdb.getMinOstatniKursPlnMWh();
        this.maksOstatniKursPlnMWh = rdb.getMaksOstatniKursPlnMWh();
        this.minOstatniKursEurMWh = rdb.getMinOstatniKursEurMWh();
        this.maksOstatniKursEurMWh = rdb.getMaksOstatniKursEurMWh();
        this.sumaLacznyWolumenMWh = rdb.getSumaLacznyWolumenMWh();
    }


    public SummaryRdbDTO(LocalDate dataDostawy, BigDecimal minKursMinPlnMWh, BigDecimal maksKursMinPlnMWh, BigDecimal minKursMinEurMWh, BigDecimal maksKursMinEurMWh, BigDecimal minKursMaksPlnMWh, BigDecimal maksKursMaksPlnMWh, BigDecimal minKursMaksEurMWh, BigDecimal maksKursMaksEurMWh, BigDecimal minOstatniKursPlnMWh, BigDecimal maksOstatniKursPlnMWh, BigDecimal minOstatniKursEurMWh, BigDecimal maksOstatniKursEurMWh, BigDecimal sumaLacznyWolumenMWh) {
        log.trace("All parameter constructor.");
        this.dataDostawy = dataDostawy;
        this.minKursMinPlnMWh = minKursMinPlnMWh;
        this.maksKursMinPlnMWh = maksKursMinPlnMWh;
        this.minKursMinEurMWh = minKursMinEurMWh;
        this.maksKursMinEurMWh = maksKursMinEurMWh;
        this.minKursMaksPlnMWh = minKursMaksPlnMWh;
        this.maksKursMaksPlnMWh = maksKursMaksPlnMWh;
        this.minKursMaksEurMWh = minKursMaksEurMWh;
        this.maksKursMaksEurMWh = maksKursMaksEurMWh;
        this.minOstatniKursPlnMWh = minOstatniKursPlnMWh;
        this.maksOstatniKursPlnMWh = maksOstatniKursPlnMWh;
        this.minOstatniKursEurMWh = minOstatniKursEurMWh;
        this.maksOstatniKursEurMWh = maksOstatniKursEurMWh;
        this.sumaLacznyWolumenMWh = sumaLacznyWolumenMWh;
    }

    public void setDataDostawy(LocalDate dataDostawy) {
        this.dataDostawy = dataDostawy;
    }

    public void setMinKursMinPlnMWh(BigDecimal minKursMinPlnMWh) {
        this.minKursMinPlnMWh = minKursMinPlnMWh;
    }

    public void setMaksKursMinPlnMWh(BigDecimal maksKursMinPlnMWh) {
        this.maksKursMinPlnMWh = maksKursMinPlnMWh;
    }

    public void setMinKursMinEurMWh(BigDecimal minKursMinEurMWh) {
        this.minKursMinEurMWh = minKursMinEurMWh;
    }

    public void setMaksKursMinEurMWh(BigDecimal maksKursMinEurMWh) {
        this.maksKursMinEurMWh = maksKursMinEurMWh;
    }

    public void setMinKursMaksPlnMWh(BigDecimal minKursMaksPlnMWh) {
        this.minKursMaksPlnMWh = minKursMaksPlnMWh;
    }

    public void setMaksKursMaksPlnMWh(BigDecimal maksKursMaksPlnMWh) {
        this.maksKursMaksPlnMWh = maksKursMaksPlnMWh;
    }

    public void setMinKursMaksEurMWh(BigDecimal minKursMaksEurMWh) {
        this.minKursMaksEurMWh = minKursMaksEurMWh;
    }

    public void setMaksKursMaksEurMWh(BigDecimal maksKursMaksEurMWh) {
        this.maksKursMaksEurMWh = maksKursMaksEurMWh;
    }

    public void setMinOstatniKursPlnMWh(BigDecimal minOstatniKursPlnMWh) {
        this.minOstatniKursPlnMWh = minOstatniKursPlnMWh;
    }

    public void setMaksOstatniKursPlnMWh(BigDecimal maksOstatniKursPlnMWh) {
        this.maksOstatniKursPlnMWh = maksOstatniKursPlnMWh;
    }

    public void setMinOstatniKursEurMWh(BigDecimal minOstatniKursEurMWh) {
        this.minOstatniKursEurMWh = minOstatniKursEurMWh;
    }

    public void setMaksOstatniKursEurMWh(BigDecimal maksOstatniKursEurMWh) {
        this.maksOstatniKursEurMWh = maksOstatniKursEurMWh;
    }

    public void setSumaLacznyWolumenMWh(BigDecimal sumaLacznyWolumenMWh) {
        this.sumaLacznyWolumenMWh = sumaLacznyWolumenMWh;
    }


    public LocalDate getDataDostawy() {
        return dataDostawy;
    }

    public BigDecimal getMinKursMinPlnMWh() {
        return minKursMinPlnMWh;
    }

    public BigDecimal getMaksKursMinPlnMWh() {
        return maksKursMinPlnMWh;
    }

    public BigDecimal getMinKursMinEurMWh() {
        return minKursMinEurMWh;
    }

    public BigDecimal getMaksKursMinEurMWh() {
        return maksKursMinEurMWh;
    }

    public BigDecimal getMinKursMaksPlnMWh() {
        return minKursMaksPlnMWh;
    }

    public BigDecimal getMaksKursMaksPlnMWh() {
        return maksKursMaksPlnMWh;
    }

    public BigDecimal getMinKursMaksEurMWh() {
        return minKursMaksEurMWh;
    }

    public BigDecimal getMaksKursMaksEurMWh() {
        return maksKursMaksEurMWh;
    }

    public BigDecimal getMinOstatniKursPlnMWh() {
        return minOstatniKursPlnMWh;
    }

    public BigDecimal getMaksOstatniKursPlnMWh() {
        return maksOstatniKursPlnMWh;
    }

    public BigDecimal getMinOstatniKursEurMWh() {
        return minOstatniKursEurMWh;
    }

    public BigDecimal getMaksOstatniKursEurMWh() {
        return maksOstatniKursEurMWh;
    }

    public BigDecimal getSumaLacznyWolumenMWh() {
        return sumaLacznyWolumenMWh;
    }

    @Override
    public String toString() {
        log.trace("toString method.");
        StringBuilder sb = new StringBuilder();
        sb.append("dataDostawy : ").append(ConvertDate.convertDateToString(dataDostawy, "yyyy-MM-dd"))
                .append("\nminKursMinPlnMWh : ").append(BigDecimalConvertion.bigDecimalToPlainStringIfNotNull(minKursMinPlnMWh))
                .append("\nmaksKursMinPlnMWh : ").append(BigDecimalConvertion.bigDecimalToPlainStringIfNotNull(maksKursMinPlnMWh))
                .append("\nminKursMinEurMWh : ").append(BigDecimalConvertion.bigDecimalToPlainStringIfNotNull(minKursMinEurMWh))
                .append("\nmaksKursMinEurMWh : ").append(BigDecimalConvertion.bigDecimalToPlainStringIfNotNull(maksKursMinEurMWh))
                .append("\nminKursMaksPlnMWh : ").append(BigDecimalConvertion.bigDecimalToPlainStringIfNotNull(minKursMaksPlnMWh))
                .append("\nmaksKursMaksPlnMWh : ").append(BigDecimalConvertion.bigDecimalToPlainStringIfNotNull(maksKursMaksPlnMWh))
                .append("\nminKursMaksEurMWh : ").append(BigDecimalConvertion.bigDecimalToPlainStringIfNotNull(minKursMaksEurMWh))
                .append("\nmaksKursMaksEurMWh : ").append(BigDecimalConvertion.bigDecimalToPlainStringIfNotNull(maksKursMaksEurMWh))
                .append("\nminOstatniKursPlnMWh : ").append(BigDecimalConvertion.bigDecimalToPlainStringIfNotNull(minOstatniKursPlnMWh))
                .append("\nmaksOstatniKursPlnMWh : ").append(BigDecimalConvertion.bigDecimalToPlainStringIfNotNull(maksOstatniKursPlnMWh))
                .append("\nminOstatniKursEurMWh : ").append(BigDecimalConvertion.bigDecimalToPlainStringIfNotNull(minOstatniKursEurMWh))
                .append("\nmaksOstatniKursEurMWh : ").append(BigDecimalConvertion.bigDecimalToPlainStringIfNotNull(maksOstatniKursEurMWh))
                .append("\nsumaLacznyWolumenMWh : ").append(BigDecimalConvertion.bigDecimalToPlainStringIfNotNull(sumaLacznyWolumenMWh));
        return sb.toString();
    }

}
