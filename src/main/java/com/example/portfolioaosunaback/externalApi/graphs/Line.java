package com.example.portfolioaosunaback.externalApi.graphs;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Line {

    private String curve;

    private String productName;

    private String seriesDescription;

    private String units;

    private List<Point> periodAndValue;

    public String getCurve() {
        return curve;
    }

    public void setCurve(String curve) {
        this.curve = curve;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSeriesDescription() {
        return seriesDescription;
    }

    public void setSeriesDescription(String seriesDescription) {
        this.seriesDescription = seriesDescription;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public List<Point> getPeriodAndValue() {
        return periodAndValue;
    }

    public void setPeriodAndValue(List<Point> periodAndValue) {
        this.periodAndValue = periodAndValue;
    }





}
