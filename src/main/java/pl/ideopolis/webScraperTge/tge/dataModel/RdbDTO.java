package pl.ideopolis.webScraperTge.tge.dataModel;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import pl.ideopolis.webScraperTge.utils.BigDecimalConvertion;
import pl.ideopolis.webScraperTge.utils.ConvertDate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class RdbDTO {

    private final static Logger log = LoggerFactory.getLogger(RdbDTO.class);

    @JsonProperty("data_dostawy")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dataDostawy;

    @JsonProperty("poczatek_pomiaru")
    private int poczatekPomiaru;
    @JsonProperty("koniec_pomiaru")
    private int koniecPomiaru;

    @JsonProperty("kurs_min_pln_mwh")
    private BigDecimal kursMinPlnMWh;
    @JsonProperty("kurs_min_eur_mwh")
    private BigDecimal kursMinEurMWh;

    @JsonProperty("kurs_maks_pln_mwh")
    private BigDecimal kursMaksPlnMWh;
    @JsonProperty("kurs_maks_eur_mwh")
    private BigDecimal kursMaksEurMWh;

    @JsonProperty("ostatni_kurs_pln_mwh")
    private BigDecimal ostatniKursPlnMWh;
    @JsonProperty("ostatni_kurs_eur_mwh")
    private BigDecimal ostatniKursEurMWh;

    @JsonProperty("laczny_wolumen_mwh")
    private BigDecimal lacznyWolumenMWh;

    public RdbDTO() {
        log.trace("No parameter constructor.");
    }

    public RdbDTO(Rdb rdb) {
        log.trace("From Rdb constructor.");
        this.dataDostawy = rdb.getDataDostawy();
        this.poczatekPomiaru = rdb.getPoczatekPomiaru();
        this.koniecPomiaru = rdb.getKoniecPomiaru();
        this.kursMinPlnMWh = rdb.getKursMinPlnMWh();
        this.kursMinEurMWh = rdb.getKursMinEurMWh();
        this.kursMaksPlnMWh = rdb.getKursMaksPlnMWh();
        this.kursMaksEurMWh = rdb.getKursMaksEurMWh();
        this.ostatniKursPlnMWh = rdb.getOstatniKursPlnMWh();
        this.ostatniKursEurMWh = rdb.getOstatniKursEurMWh();
        this.lacznyWolumenMWh = rdb.getLacznyWolumenMWh();
    }

    public void setDataDostawy(LocalDate dataDostawy) {
        this.dataDostawy = dataDostawy;
    }

    public void setPoczatekPomiaru(int poczatekPomiaru) {
        this.poczatekPomiaru = poczatekPomiaru;
    }

    public void setKoniecPomiaru(int koniecPomiaru) {
        this.koniecPomiaru = koniecPomiaru;
    }

    public void setKursMinPlnMWh(BigDecimal kursMinPlnMWh) {
        this.kursMinPlnMWh = kursMinPlnMWh;
    }

    public void setKursMinEurMWh(BigDecimal kursMinEurMWh) {
        this.kursMinEurMWh = kursMinEurMWh;
    }

    public void setKursMaksPlnMWh(BigDecimal kursMaksPlnMWh) {
        this.kursMaksPlnMWh = kursMaksPlnMWh;
    }

    public void setKursMaksEurMWh(BigDecimal kursMaksEurMWh) {
        this.kursMaksEurMWh = kursMaksEurMWh;
    }

    public void setOstatniKursPlnMWh(BigDecimal ostatniKursPlnMWh) {
        this.ostatniKursPlnMWh = ostatniKursPlnMWh;
    }

    public void setOstatniKursEurMWh(BigDecimal ostatniKursEurMWh) {
        this.ostatniKursEurMWh = ostatniKursEurMWh;
    }

    public void setLacznyWolumenMWh(BigDecimal lacznyWolumenMWh) {
        this.lacznyWolumenMWh = lacznyWolumenMWh;
    }

    public LocalDate getDataDostawy() {
        return dataDostawy;
    }

    public int getPoczatekPomiaru() {
        return poczatekPomiaru;
    }

    public int getKoniecPomiaru() {
        return koniecPomiaru;
    }

    public BigDecimal getKursMinPlnMWh() {
        return kursMinPlnMWh;
    }

    public BigDecimal getKursMinEurMWh() {
        return kursMinEurMWh;
    }

    public BigDecimal getKursMaksPlnMWh() {
        return kursMaksPlnMWh;
    }

    public BigDecimal getKursMaksEurMWh() {
        return kursMaksEurMWh;
    }

    public BigDecimal getOstatniKursPlnMWh() {
        return ostatniKursPlnMWh;
    }

    public BigDecimal getOstatniKursEurMWh() {
        return ostatniKursEurMWh;
    }

    public BigDecimal getLacznyWolumenMWh() {
        return lacznyWolumenMWh;
    }

    @Override
    public String toString() {
        log.trace("toString method.");
        StringBuilder sb = new StringBuilder();
        sb.append("dataDostawy : ").append(ConvertDate.convertDateToString(dataDostawy, "yyyy-MM-dd"))
                .append("\npoczatekPomiaru : ").append(poczatekPomiaru)
                .append("\nkoniecPomiaru : ").append(koniecPomiaru)
                .append("\nkursMinPlnMWh : ").append(BigDecimalConvertion.bigDecimalToPlainStringIfNotNull(kursMinPlnMWh))
                .append("\nkursMinEurMWh : ").append(BigDecimalConvertion.bigDecimalToPlainStringIfNotNull(kursMinEurMWh))
                .append("\nkursMaksPlnMWh : ").append(BigDecimalConvertion.bigDecimalToPlainStringIfNotNull(kursMaksPlnMWh))
                .append("\nkursMaksEurMWh : ").append(BigDecimalConvertion.bigDecimalToPlainStringIfNotNull(kursMaksEurMWh))
                .append("\nostatniKursPlnMWh : ").append(BigDecimalConvertion.bigDecimalToPlainStringIfNotNull(ostatniKursPlnMWh))
                .append("\nostatniKursEurMWh : ").append(BigDecimalConvertion.bigDecimalToPlainStringIfNotNull(ostatniKursEurMWh))
                .append("\nlacznyWolumenMWh : ").append(BigDecimalConvertion.bigDecimalToPlainStringIfNotNull(lacznyWolumenMWh));
        return sb.toString();
    }

}
