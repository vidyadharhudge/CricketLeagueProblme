import com.bl.cricketleague.CricketLeague;
import com.bl.cricketleague.exception.CricketLeagueException;
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
    public void givenStateCensusData_WhenWithWrongFile_ThenShouldThrowException()
    {
        try {
            CricketLeague.readFile(WRONG_CSV_FILE_PATH);
        } catch ( CricketLeagueException e) {
            Assert.assertEquals(CricketLeagueException.ExceptionType.FILE_NOT_FOUND,e.type); }
    }

    /* T.C 1.3 :Given IPL Censes Csv Type Is Incorrect Then Returns Custom Exception */
    @Test
    public void givenStateCensusData_WhenWithWrongType_ThenShouldThrowException()
    {
        try {
            CricketLeague.readFile(WRONG_CSV_FILE_TYPE); }
        catch (CricketLeagueException e) {
            Assert.assertEquals(CricketLeagueException.ExceptionType.FILE_NOT_FOUND,e.type); }
    }
}
