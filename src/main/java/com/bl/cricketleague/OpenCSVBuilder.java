package com.bl.cricketleague;
import com.bl.cricketleague.exception.CSVBuilderException;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.BufferedReader;
import java.util.List;

public class OpenCSVBuilder implements ICSVBuilder
{
    @Override
    public List<ICSVBuilder> getCSVFileList(BufferedReader reader, Class csvClass)  {
        return this.getCSVToBean(reader, csvClass).parse();
    }

    private CsvToBean getCSVToBean(BufferedReader reader, Class csvClass) {
        try {
            CsvToBeanBuilder<ICSVBuilder> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(csvClass);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<ICSVBuilder> csvToBean = csvToBeanBuilder.build();
            return csvToBean;
        } catch (IllegalStateException e) {
            throw new CSVBuilderException(e.getMessage(),
                    CSVBuilderException.ExceptionType.UNABLE_TO_PARSE);
        }
    }
}

