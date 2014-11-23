/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package database.validation;

import java.io.*;

/**
 *
 * @author AdministratorJa
 */
public class DatabaseValidation {

    public static WOData[] dailyWO;
    private static WOData[] report;
    public static DatabaseValidationUI UserInterface;
    public static ConfigFile config = ConfigFile.GetInstance();
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    
    //TODO
    //stworzyc mozliwosc zmiany kolumn i wierszy scannera
    //dodac do skanowania numery mieszkan i blokow
    
    public static void main(String[] args) throws IOException 
    {
        config.getConfiguration();
        UserInterface = new DatabaseValidationUI(dailyWO, report);
        UserInterface.setVisible(true);
    }

}
