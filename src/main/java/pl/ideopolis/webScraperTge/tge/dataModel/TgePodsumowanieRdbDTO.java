package pl.ideopolis.webScraperTge.tge.dataModel;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

public class TgePodsumowanieRdbDTO {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataDostawy;

    private BigDecimal minKursMinPlnMWh;
    private BigDecimal maksKursMinPlnMWh;
    private BigDecimal minKursMinEurMWh;
    private BigDecimal maksKursMinEurMWh;

    private BigDecimal minKursMaksPlnMWh;
    private BigDecimal maksKursMaksPlnMWh;
    private BigDecimal minKursMaksEurMWh;
    private BigDecimal maksKursMaksEurMWh;

    private BigDecimal minOstatniKursPlnMWh;
    private BigDecimal maksOstatniKursPlnMWh;
    private BigDecimal minOstatniKursEurMWh;
    private BigDecimal maksOstatniKursEurMWh;

    private BigDecimal sumaLacznyWolumenMWh;

    public TgePodsumowanieRdbDTO() {
    }

    public TgePodsumowanieRdbDTO(Date dataDostawy, BigDecimal minKursMinPlnMWh, BigDecimal maksKursMinPlnMWh, BigDecimal minKursMinEurMWh, BigDecimal maksKursMinEurMWh, BigDecimal minKursMaksPlnMWh, BigDecimal maksKursMaksPlnMWh, BigDecimal minKursMaksEurMWh, BigDecimal maksKursMaksEurMWh, BigDecimal minOstatniKursPlnMWh, BigDecimal maksOstatniKursPlnMWh, BigDecimal minOstatniKursEurMWh, BigDecimal maksOstatniKursEurMWh, BigDecimal sumaLacznyWolumenMWh) {
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

    public void setDataDostawy(Date dataDostawy) {
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TGERynekDniaBiezacegoPodsumowanieDTO:")
                .append("\n dataDostawy - ").append(dataDostawy)
                .append("\n minKursMinPlnMWh - ").append(minKursMinPlnMWh)
                .append("\n maksKursMinPlnMWh - ").append(maksKursMinPlnMWh)
                .append("\n minKursMinEurMWh - ").append(minKursMinEurMWh)
                .append("\n maksKursMinEurMWh - ").append(maksKursMinEurMWh)
                .append("\n minKursMaksPlnMWh - ").append(minKursMaksPlnMWh)
                .append("\n maksKursMaksPlnMWh - ").append(maksKursMaksPlnMWh)
                .append("\n minKursMaksEurMWh - ").append(minKursMaksEurMWh)
                .append("\n maksKursMaksEurMWh - ").append(maksKursMaksEurMWh)
                .append("\n minOstatniKursPlnMWh - ").append(minOstatniKursPlnMWh)
                .append("\n maksOstatniKursPlnMWh - ").append(maksOstatniKursPlnMWh)
                .append("\n minOstatniKursEurMWh - ").append(minOstatniKursEurMWh)
                .append("\n maksOstatniKursEurMWh - ").append(maksOstatniKursEurMWh)
                .append("\n sumaLacznyWolumenMWh - ").append(sumaLacznyWolumenMWh);
        return sb.toString();
    }

}
