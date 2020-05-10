package com.bl.cricketleague.model;

import com.opencsv.bean.CsvBindByName;

public class IplMostWickets
{
    @CsvBindByName(column = "POS")
    public String POS;
    @CsvBindByName(column = "PLAYER")
    public String PLAYER;
    @CsvBindByName(column = "Mat")
    public String Mat;
    @CsvBindByName(column = "Inns")
    public String Inns;
    @CsvBindByName(column = "Ov")
    public String Ov;
    @CsvBindByName(column = "Runs")
    public String Runs;
    @CsvBindByName(column = "Wkts")
    public double Wkts;
    @CsvBindByName(column = "BBI")
    public String BBI;
    @CsvBindByName(column = "Avg")
    public double Avg;
    @CsvBindByName(column = "Econ")
    public double Econ;
    @CsvBindByName(column = "SR")
    public double SR;
    @CsvBindByName(column = "4w")
    public int FourWickets;
    @CsvBindByName(column = "5w")
    public int FiveWickets;

    public String getPOS() {
        return POS;
    }

    public void setPOS(String POS) {
        this.POS = POS;
    }

    public String getPLAYER() {
        return PLAYER;
    }

    public void setPLAYER(String PLAYER) {
        this.PLAYER = PLAYER;
    }

    public String getMat() {
        return Mat;
    }

    public void setMat(String mat) {
        Mat = mat;
    }

    public String getInns() {
        return Inns;
    }

    public void setInns(String inns) {
        Inns = inns;
    }

    public String getOv() {
        return Ov;
    }

    public void setOv(String ov) {
        Ov = ov;
    }

    public String getRuns() {
        return Runs;
    }

    public void setRuns(String runs) {
        Runs = runs;
    }

    public double getWkts() {
        return Wkts;
    }

    public void setWkts(double wkts) {
        Wkts = wkts;
    }

    public String getBBI() {
        return BBI;
    }

    public void setBBI(String BBI) {
        this.BBI = BBI;
    }

    public double getAvg() {
        return Avg;
    }

    public void setAvg(double avg) {
        Avg = avg;
    }

    public double getEcon() {
        return Econ;
    }

    public void setEcon(double econ) {
        Econ = econ;
    }

    public double getSR() {
        return SR;
    }

    public void setSR(double SR) {
        this.SR = SR;
    }

    public int getFourWickets() {
        return FourWickets;
    }

    public void setFourWickets(int fourWickets) {
        FourWickets = fourWickets;
    }

    public int getFiveWickets() {
        return FiveWickets;
    }

    public void setFiveWickets(int fiveWickets) {
        FiveWickets = fiveWickets;
    }

    @Override
    public String toString() {
        return "IplMostWickets{" +
                "POS='" + POS + '\'' +
                ", PLAYER='" + PLAYER + '\'' +
                ", Mat='" + Mat + '\'' +
                ", Inns='" + Inns + '\'' +
                ", Ov='" + Ov + '\'' +
                ", Runs='" + Runs + '\'' +
                ", Wkts='" + Wkts + '\'' +
                ", BBI='" + BBI + '\'' +
                ", Avg='" + Avg + '\'' +
                ", Econ='" + Econ + '\'' +
                ", SR='" + SR + '\'' +
                ", FourWickets='" + FourWickets + '\'' +
                ", FiveWickets='" + FiveWickets + '\'' +
                '}';
    }
}
