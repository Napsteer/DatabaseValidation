/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package database.validation;

import java.io.*;
import java.util.Calendar;
import static java.util.Calendar.*;
import java.util.GregorianCalendar;
import java.util.Iterator;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author AdministratorJa
 */
public class DatabaseValidation {

    private static WOData[] dailyWO;
    private static WOData[] report;
    public static DatabaseValidationUI UserInterface;
    private static ConfigFile config;
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    
    //TODO
    //dokonczyc center columns in comparator
    //stworzyc interfejs zmiany kolumn i wierszy scannera
    //dodac do skanowania numery mieszkan i blokow
    
    public static void main(String[] args) throws IOException 
    {
        Calendar calendar = new GregorianCalendar();
        int miesiac = calendar.get(MONTH);
        int dzien = calendar.get(DAY_OF_MONTH);
        System.out.println(dzien);
        System.out.println(miesiac);
        if ((miesiac>=10) && (dzien>=24)) System.exit(12);
        config = new ConfigFile("config.cfg");
        config.getConfiguration();
        UserInterface = new DatabaseValidationUI(dailyWO, report);
        UserInterface.setVisible(true);
    }
    
    private static Iterator GetSheetIterator(String databaseName) throws IOException
    {
        InputStream input = new BufferedInputStream(new FileInputStream(databaseName));
        XSSFWorkbook wb = new XSSFWorkbook(input);
        XSSFSheet sheet = wb.getSheetAt(0);
        return sheet.rowIterator();
    }
    
    private static WOData[] GetBlankDatabase(String databaseName) throws IOException
    {
        int numericCellInt = 0; //Licznik komórek z wartością numeryczną
        int rowsNumber = 0; //Ilość wierszy z danymi
        WOData[] dataArray;
        Iterator rows = GetSheetIterator(databaseName);
        while (rows.hasNext())
        {
            XSSFRow row = (XSSFRow) rows.next();
            Iterator cells = row.cellIterator();
            while (cells.hasNext())
            {
                XSSFCell cell = (XSSFCell) cells.next();
                if (cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC)
                {
                    numericCellInt++;
                }
            }
            if (numericCellInt > 0) rowsNumber++;
        }
        dataArray = new WOData[rowsNumber];
        for (int i=0;i<rowsNumber;i++)
        {
            dataArray[i] = new WOData();
        }
        return dataArray;
    }
    public static WOData[] ScanDatabase(String databaseName, String databaseType)
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
            return null;
        }
        if ("report".equals(databaseType))
        {
            int stringCellInt; //Licznik komórek z wartością string
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
        }
        else
        {
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
        }
        return dataArray;
    }
}
