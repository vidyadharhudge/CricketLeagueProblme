import com.bl.cricketleague.CricketLeague;
import com.bl.cricketleague.exception.CricketLeagueException;
import com.bl.cricketleague.model.IplMostRuns;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static com.bl.cricketleague.FilePaths.*;

public class CricketLeagueTest {
    CricketLeague cricketLeague;

    @Before
    public void setup() {
        cricketLeague = new CricketLeague();
    }

    /* Tc 1.1 :Given The Ipl Most Run Csv File, Check To Ensure The Number Of Record Matches */
    @Test
    public void givenFilePath_WhenNoOfRecordMatches_ThenReturnTrue() {
        int noOfRecords = cricketLeague.readFile(IPL_MOST_RUN_SHEET);
        Assert.assertEquals(100, noOfRecords);
    }

    /* T.C 1.2 :Given IPL Censes Csv File Is Incorrect Then Returns Custom Exception */
    @Test
    public void givenCricketLeagueData_WhenWithWrongFile_ThenShouldThrowException()
    {
        try {
            cricketLeague.readFile(WRONG_CSV_FILE_PATH);
        } catch ( CricketLeagueException e) {
            Assert.assertEquals(CricketLeagueException.ExceptionType.FILE_NOT_FOUND,e.type); }
    }

    /* T.C 1.3 :Given IPL Censes Csv Type Is Incorrect Then Returns Custom Exception */
    @Test
    public void givenCricketLeagueData_WhenWithWrongType_ThenShouldThrowException()
    {
        try {
            cricketLeague.readFile(WRONG_CSV_FILE_TYPE); }
        catch (CricketLeagueException e) {
            Assert.assertEquals(CricketLeagueException.ExceptionType.FILE_NOT_FOUND,e.type); }
    }

    /* T.C 1.4 :Given IPL Censes Csv file Is Correct But With Wrong Delimiter Should Rhrow Custom Exception */
    @Test
    public void givenCricketLeagueData_WhenWithWrongDelimiter_ThenShouldThrowException()
    {
        try {
            cricketLeague.readFile(WRONG_DELIMITER_FILE); }
        catch (CricketLeagueException e) {
            Assert.assertEquals(CricketLeagueException.ExceptionType.WRONG_DELIMITER,e.type); }
    }

    /* T.C 1.5 :Given IPL Censes Csv file Is Correct But With Wrong Header Should Rhrow Custom Exception */
    @Test
    public void givenCricketLeagueData_WhenWithWrongHeader_ThenShouldThrowException()
    {
        try {
            cricketLeague.readFile(WRONG_DELIMITER_FILE); }
        catch (CricketLeagueException e) {
            Assert.assertEquals(CricketLeagueException.ExceptionType.WRONG_DELIMITER,e.type); }
    }

    /* TC 1.6 : Given Cricket Census Data when sorted should return sorted data BY Avrage Wise*/
    @Test
    public void givenCricketLeagueData_whenSorted_shouldReturnSortedDataAvrage()
    {
            cricketLeague.readFile(IPL_MOST_RUN_SHEET);
            String sortedCensusData = cricketLeague.getAvrageWiseSorted();
            IplMostRuns[] censusCsv = new Gson().fromJson(sortedCensusData,IplMostRuns[].class);
            double runs=censusCsv[0].Avg;
            String name=censusCsv[0].getPLAYER();
            Assert.assertEquals("MS Dhoni",name);
    }

    /* TC 2 : Given Cricket League Data when sorted should return sorted data By Strike Rate*/
    @Test
    public void givenCricketLeagueData_whenSorted_shouldReturnSortedStrikeRate()
    {
        cricketLeague.readFile(IPL_MOST_RUN_SHEET);
        String sortedCensusData = cricketLeague.getSortedWiseStrikeRate();
        IplMostRuns[] censusCsv = new Gson().fromJson(sortedCensusData,IplMostRuns[].class);
        double runs=censusCsv[0].SR;
        String name=censusCsv[0].getPLAYER();
        Assert.assertEquals("Ishant Sharma",name);
    }

    /* TC 3.1 : Given Cricket League Data when sorted should return sorted data By Sixes*/
    @Test
    public void givenCricketLeagueData_whenSorted_shouldReturnSortedSixes()
    {
        cricketLeague.readFile(IPL_MOST_RUN_SHEET);
        String sortedCensusData = cricketLeague.getSortedWiseSixes();
        IplMostRuns[] censusCsv = new Gson().fromJson(sortedCensusData,IplMostRuns[].class);
        double runs=censusCsv[0].sixs;
        String name=censusCsv[0].getPLAYER();
        Assert.assertEquals("Andre Russell",name);
    }

    /* TC 3.2 : Given Cricket League Data when sorted should return sorted data By fours*/
    @Test
    public void givenCricketLeagueData_whenSorted_shouldReturnSortedFours()
    {
        cricketLeague.readFile(IPL_MOST_RUN_SHEET);
        String sortedCensusData = cricketLeague.getSortedWiseFours();
        IplMostRuns[] censusCsv = new Gson().fromJson(sortedCensusData,IplMostRuns[].class);
        double runs=censusCsv[0].fours;
        String name=censusCsv[0].getPLAYER();
        Assert.assertEquals("Shikhar Dhawan",name);
    }

    /* TC 4 : Given Cricket League Data when sorted should return sorted data By SR With 4s And 6s*/
    @Test
    public void givenCricketLeagueData_whenSorted_shouldReturnSortedStrikeRateWithSixesAndFours()
    {
        cricketLeague.readFile(IPL_MOST_RUN_SHEET);
        String sortedCensusData = cricketLeague. getSortedStrikeRate6s4s();
        IplMostRuns[] censusCsv = new Gson().fromJson(sortedCensusData,IplMostRuns[].class);
        double runs=censusCsv[0].SR;
        String name=censusCsv[0].getPLAYER();
        Assert.assertEquals("Ishant Sharma",name);
    }

    /* TC 5 : Given Cricket League Data when sorted should return sorted data By Avg With Best SR*/
    @Test
    public void givenCricketLeagueData_whenSorted_shouldReturnSortedAvrageWithBestSR()
    {
        cricketLeague.readFile(IPL_MOST_RUN_SHEET);
        String sortedCensusData = cricketLeague.getSortedWiseAvrageWithBestSR();
        IplMostRuns[] censusCsv = new Gson().fromJson(sortedCensusData,IplMostRuns[].class);
        double runs=censusCsv[0].Avg;
        String name=censusCsv[0].getPLAYER();
        Assert.assertEquals("MS Dhoni",name);
    }

    /* TC 6 : Given Cricket League Data when sorted should return sorted data By Runs With Best Avg*/
    @Test
    public void givenCricketLeagueData_whenSorted_shouldReturnSortedRunsWithBestAvg()
    {
        cricketLeague.readFile(IPL_MOST_RUN_SHEET);
        String sortedCensusData = cricketLeague.getSortedWiseRunsWithBestAvrage();
        IplMostRuns[] censusCsv = new Gson().fromJson(sortedCensusData,IplMostRuns[].class);
        double runs=censusCsv[0].Runs;
        String name=censusCsv[0].getPLAYER();
        Assert.assertEquals("David Warner",name);
    }
}




