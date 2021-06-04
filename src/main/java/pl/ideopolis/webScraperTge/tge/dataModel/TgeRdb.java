package pl.ideopolis.webScraperTge.tge.dataModel;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity(name = "TgeRdb")
@Table(name = "tge_rdb")
public class TgeRdb {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "data_dostawy")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataDostawy;

    @Column(name = "poczatek_pomiaru")
    private int poczatekPomiaru;

    @Column(name = "koniec_pomiaru")
    private int koniecPomiaru;

    @Column(name = "kurs_min_pln_mwh")
    private BigDecimal kursMinPlnMWh;
    @Column(name = "kurs_min_eur_mwh")
    private BigDecimal kursMinEurMWh;

    @Column(name = "kurs_maks_pln_mwh")
    private BigDecimal kursMaksPlnMWh;
    @Column(name = "kurs_maks_eur_mwh")
    private BigDecimal kursMaksEurMWh;

    @Column(name = "ostatni_kurs_pln_mwh")
    private BigDecimal ostatniKursPlnMWh;
    @Column(name = "ostatni_kurs_eur_mwh")
    private BigDecimal ostatniKursEurMWh;

    @Column(name = "laczny_wolumen_mwh")
    private BigDecimal lacznyWolumenMWh;

    public TgeRdb() {
    }

    public TgeRdb(Date dataDostawy, int poczatekPomiaru, int koniecPomiaru, BigDecimal kursMinPlnMWh, BigDecimal kursMinEurMWh, BigDecimal kursMaksPlnMWh, BigDecimal kursMaksEurMWh, BigDecimal ostatniKursPlnMWh, BigDecimal ostatniKursEurMWh, BigDecimal lacznyWolumenMWh) {
        this.dataDostawy = dataDostawy;
        this.poczatekPomiaru = poczatekPomiaru;
        this.koniecPomiaru = koniecPomiaru;
        this.kursMinPlnMWh = kursMinPlnMWh;
        this.kursMinEurMWh = kursMinEurMWh;
        this.kursMaksPlnMWh = kursMaksPlnMWh;
        this.kursMaksEurMWh = kursMaksEurMWh;
        this.ostatniKursPlnMWh = ostatniKursPlnMWh;
        this.ostatniKursEurMWh = ostatniKursEurMWh;
        this.lacznyWolumenMWh = lacznyWolumenMWh;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getId() {
        return id;
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
}
