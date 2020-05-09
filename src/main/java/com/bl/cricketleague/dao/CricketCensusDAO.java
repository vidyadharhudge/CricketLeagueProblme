package com.bl.cricketleague.dao;

import com.bl.cricketleague.model.IplMostRuns;
import com.opencsv.bean.CsvBindByName;

public class CricketCensusDAO
{
    public String POS;
    public String PLAYER;
    public String Mat;
    public String Inns;
    public String NO;
    public double Runs;
    public String HS;
    public double Avg;
    public String BF;
    public double SR;
    public String hundred;
    public String fifty;
    public  String fours;
    public String sixs;
    public CricketCensusDAO(IplMostRuns iplMostRuns)
    {
        POS=iplMostRuns.POS;
        PLAYER=iplMostRuns.PLAYER;
        Mat=iplMostRuns.Mat;
        Inns=iplMostRuns.Inns;
        NO=iplMostRuns.NO;
        Runs=iplMostRuns.Runs;
        HS=iplMostRuns.HS;
        Avg=iplMostRuns.Avg;
        BF=iplMostRuns.BF;
        hundred=iplMostRuns.hundred;
        fifty=iplMostRuns.fifty;
        fours=iplMostRuns.fours;
        sixs=iplMostRuns.sixs;
        SR=iplMostRuns.SR;
    }
}
