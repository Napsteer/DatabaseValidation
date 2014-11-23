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
public class ReportScanner extends Scanner{
    
    public  WOData[] ScanDatabase(String databaseName)
    {
        int woRowNumber = 0; //Licznik wierszy klasy WOData
        int numericCellInt; //Licznik komórek z wartością numeryczną
        int stringCellInt; //Licznik komórek z wartością string
        WOData[] dataArray;
        Iterator rows;
        try
        {
            dataArray = GetBlankDatabase(databaseName);
            rows = GetSheetIterator(databaseName);
        }
        catch(IOException ex)
        {
            System.out.println(ex.getMessage());
            return null;
        }
            while (rows.hasNext())
            {
                numericCellInt = 0;
                stringCellInt = 0;
                XSSFRow row = (XSSFRow) rows.next();
                Iterator cells = row.cellIterator();
                while (cells.hasNext())
                {
                    XSSFCell cell = (XSSFCell) cells.next();
                    if (cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC)
                    {
                        numericCellInt++;
                        if (numericCellInt == config.getReportMinTimeCell())
                        {
                            dataArray[woRowNumber].setMinTime((int) cell.getNumericCellValue());
                        }
                        if (numericCellInt == config.getReportMaxTimeCell())
                        {
                            dataArray[woRowNumber].setMaxTime((int) cell.getNumericCellValue());
                        }
                        if (numericCellInt == config.getReportClientNumberCell())
                        {
                            dataArray[woRowNumber].setClientNumber((int) cell.getNumericCellValue());
                        }
                    }
                    if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING)
                    {
                        stringCellInt++;
                        if ((stringCellInt == config.getReportAddressCell()) && (numericCellInt > 0))
                        {
                            dataArray[woRowNumber].setClientAddress(cell.getStringCellValue());
                        }
                    }
                    if ((numericCellInt >= config.getReportClientNumberCell()) && (stringCellInt >=config.getReportAddressCell()))
                    {
                        woRowNumber++;
                        break;
                    }
                }
            }
            return dataArray;
    }

    public ReportScanner() {
    }
    
}
