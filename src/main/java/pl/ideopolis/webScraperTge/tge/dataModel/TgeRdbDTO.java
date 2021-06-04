package pl.ideopolis.webScraperTge.tge.dataModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

public class TgeRdbDTO {

    @JsonProperty("data_dostawy")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataDostawy;

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

    public TgeRdbDTO() {
        System.out.println("TgeRdbDTO constructor");
    }

    public TgeRdbDTO(TgeRdb tgeRdb){
        this.dataDostawy = tgeRdb.getDataDostawy();
        this.poczatekPomiaru = tgeRdb.getPoczatekPomiaru();
        this.koniecPomiaru = tgeRdb.getKoniecPomiaru();
        this.kursMinPlnMWh = tgeRdb.getKursMinPlnMWh();
        this.kursMinEurMWh = tgeRdb.getKursMinEurMWh();
        this.kursMaksPlnMWh = tgeRdb.getKursMaksPlnMWh();
        this.kursMaksEurMWh = tgeRdb.getKursMaksEurMWh();
        this.ostatniKursPlnMWh = tgeRdb.getOstatniKursPlnMWh();
        this.ostatniKursEurMWh = tgeRdb.getOstatniKursEurMWh();
        this.lacznyWolumenMWh = tgeRdb.getLacznyWolumenMWh();
    }

    public void setDataDostawy(Date dataDostawy) {
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

    public Date getDataDostawy() {
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
        StringBuilder sb = new StringBuilder();
        sb.append("\n dataDostawy - ").append(dateToYearMonthDayString(dataDostawy))
                .append("\n poczatekPomiaru - ").append(poczatekPomiaru)
                .append("\n koniecPomiaru - ").append(koniecPomiaru)
                .append("\n kursMinPlnMWh - ").append(kursMinPlnMWh)
                .append("\n kursMinEurMWh - ").append(kursMinEurMWh)
                .append("\n kursMaksPlnMWh - ").append(kursMaksPlnMWh)
                .append("\n kursMaksEurMWh - ").append(kursMaksEurMWh)
                .append("\n ostatniKursPlnMWh - ").append(ostatniKursPlnMWh)
                .append("\n ostatniKursEurMWh - ").append(ostatniKursEurMWh)
                .append("\n lacznyWolumenMWh - ").append(lacznyWolumenMWh);
        return sb.toString();
    }

    private String dateToYearMonthDayString(Date date){
        final String separator = "-";
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        StringBuilder sb = new StringBuilder();
        String year,month,day;
        year = String.valueOf(calendar.get(Calendar.YEAR));
        month = String.valueOf(calendar.get(Calendar.MONTH));
        month = String.format("%2s",month).replace(' ','0');
        day = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
        day = String.format("%2s",day).replace(' ','0');
        sb.append(year).append(separator).append(month).append(separator).append(day);
        return sb.toString();
    }

}
