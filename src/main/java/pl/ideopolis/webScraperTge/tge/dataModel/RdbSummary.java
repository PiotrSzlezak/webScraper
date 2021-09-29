package pl.ideopolis.webScraperTge.tge.dataModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(name = "RdbSummary")
@Table(name = "rdb_summary")
public class RdbSummary {

    private final static Logger log = LoggerFactory.getLogger(RdbSummary.class);

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "data_dostawy")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataDostawy;

    @Column(name = "min_kurs_min_Pln_MWh")
    private BigDecimal minKursMinPlnMWh;
    @Column(name = "maks_kurs_min_Pln_MWh")
    private BigDecimal maksKursMinPlnMWh;
    @Column(name = "min_kurs_min_Eur_MWh")
    private BigDecimal minKursMinEurMWh;
    @Column(name = "maks_kurs_min_Eur_MWh")
    private BigDecimal maksKursMinEurMWh;

    @Column(name = "min_kurs_maks_Pln_MWh")
    private BigDecimal minKursMaksPlnMWh;
    @Column(name = "maks_kurs_maks_Pln_MWh")
    private BigDecimal maksKursMaksPlnMWh;
    @Column(name = "min_kurs_maks_Eur_MWh")
    private BigDecimal minKursMaksEurMWh;
    @Column(name = "maks_kurs_maks_Eur_MWh")
    private BigDecimal maksKursMaksEurMWh;

    @Column(name = "min_ostatni_ours_Pln_MWh")
    private BigDecimal minOstatniKursPlnMWh;
    @Column(name = "maks_ostatni_kurs_Pln_MWh")
    private BigDecimal maksOstatniKursPlnMWh;
    @Column(name = "min_ostatni_kurs_Eur_MWh")
    private BigDecimal minOstatniKursEurMWh;
    @Column(name = "maks_ostatni_kurs_Eur_MWh")
    private BigDecimal maksOstatniKursEurMWh;

    @Column(name = "suma_laczny_wolumen_MWh")
    private BigDecimal sumaLacznyWolumenMWh;

    public RdbSummary() {
        log.trace("No parameter constructor.");
    }


    public void setId(long id) {
        this.id = id;
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


    public long getId() {
        return id;
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

}
