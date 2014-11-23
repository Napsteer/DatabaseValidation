/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package database.scanners;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import database.validation.WOData;

/**
 *
 * @author AdministratorJa
 */
public abstract class Scanner {
    
    protected Iterator GetSheetIterator(String databaseName) throws IOException
    {
        InputStream input = new BufferedInputStream(new FileInputStream(databaseName));
        XSSFWorkbook wb = new XSSFWorkbook(input);
        XSSFSheet sheet = wb.getSheetAt(0);
        input.close();
        return sheet.rowIterator();
    }
    
    protected WOData[] GetBlankDatabase(String databaseName) throws IOException
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

    public Scanner() {
    }
}