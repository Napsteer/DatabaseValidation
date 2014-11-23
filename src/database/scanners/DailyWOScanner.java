/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package database.scanners;

import static database.validation.DatabaseValidation.config;
import database.validation.WOData;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;

/**
 *
 * @author AdministratorJa
 */
public class DailyWOScanner extends Scanner {
    
//    @Override
//    protected Iterator GetSheetIterator(String databaseName) throws IOException
//    {
//        return super.GetSheetIterator(databaseName);
//    }
    
//    @Override
//    protected WOData[] GetBlankDatabase(String databaseName) throws IOException
//    {
//        return super.GetBlankDatabase(databaseName);
//    }
    
    public WOData[] ScanDatabase(String databaseName)
    {
        int woRowNumber = 0; //Licznik wierszy klasy WOData
        int numericCellInt; //Licznik komórek z wartością numeryczną
        WOData[] dataArray = null;
        Iterator rows = null;
        try
        {
            dataArray = GetBlankDatabase(databaseName);
            rows = GetSheetIterator(databaseName);
        }
        catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        }
        while (rows.hasNext())
            {
                numericCellInt = 0;
                XSSFRow row = (XSSFRow) rows.next();
                Iterator cells = row.cellIterator();
                while (cells.hasNext())
                {
                    XSSFCell cell = (XSSFCell) cells.next();
                    if (cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) numericCellInt++;
                }
                if (numericCellInt == 0) continue;
                XSSFCell cell;
                cell = row.getCell(config.getDailyWOMinTimeCell());
                dataArray[woRowNumber].setMinTime((int) cell.getNumericCellValue());
                cell = row.getCell(config.getDailyWOMaxTimeCell());
                dataArray[woRowNumber].setMaxTime((int) cell.getNumericCellValue());
                cell = row.getCell(config.getDailyWOClientNumberCell());
                dataArray[woRowNumber].setClientNumber((int) cell.getNumericCellValue());
                cell = row.getCell(config.getDailyWOAddressCell());
                dataArray[woRowNumber].setClientAddress(cell.getStringCellValue());
                woRowNumber++;
            }
        return dataArray;
    }

    public DailyWOScanner() {
    }
    
}
