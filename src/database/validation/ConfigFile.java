/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package database.validation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * ConfigFile przechowuje dane dotyczące ustawienia kolumn i wierszy
 * w plikach dailywo i raportu. 
 */

public class ConfigFile {
    private final File file;
    private int dailyWOClientNumberCell; // Numer kolumny z wartością int, w której jest numer klienta
    private int dailyWOMinTimeCell; // Numer kolumny z wartością int, w której jest min godzina
    private int dailyWOMaxTimeCell; // Numer kolumny z wartością int, w której jest max godzina
    private int dailyWOAddressCell; // Numer kolumny z wartością int, w której jest adres klienta
    private int reportClientNumberCell; // Numer kolumny z wartością int, w której jest numer klienta
    private int reportMinTimeCell; // Numer kolumny z wartością int, w której jest min godzina
    private int reportMaxTimeCell; // Numer kolumny z wartością int, w której jest max godzina
    private int reportAddressCell; // Numer kolumny z wartością int, w której jest adres klienta
    private static final ConfigFile instance = new ConfigFile();
    
    private ConfigFile()
    {
        file = new File("config/config.cfg");
    }
    
    public static ConfigFile GetInstance()
    {
        return instance;
    }
    
    public void getConfiguration() throws IOException
    {
        File directory = new File(file.getParent());
        directory.mkdir();
        if (file.exists())
        {
            readConfigFile(file.getPath());
        }
        else
        {
            CreateDefaultConfigFile(file.getPath());
            readConfigFile(file.getPath());
        }
    }
    
    private void readConfigFile(String filePath) throws FileNotFoundException, IOException
    {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
        int i=0;
        while((line = br.readLine()) != null)
        {
            i++;
            switch(i)
            {
                case 2:
                    dailyWOClientNumberCell = Integer.valueOf(line);
                    break;
                case 4:
                    dailyWOMinTimeCell = Integer.valueOf(line);
                    break;
                case 6:
                    dailyWOMaxTimeCell = Integer.valueOf(line);
                    break;
                case 8:
                    dailyWOAddressCell = Integer.valueOf(line);
                    break;
                case 10:
                    reportClientNumberCell = Integer.valueOf(line);
                    break;
                case 12:
                    reportMinTimeCell = Integer.valueOf(line);
                    break;
                case 14:
                    reportMaxTimeCell = Integer.valueOf(line);
                    break;
                case 16:
                    reportAddressCell = Integer.valueOf(line);
                    break;
            }
        }
        br.close();
    }
    
    private void CreateDefaultConfigFile(String filePath) throws IOException
    {
        BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
        bw.append("#dailyWOClientNumberCell\n");
        bw.append("4\n");
        bw.append("#dailyWOMinTimeCell\n");
        bw.append("1\n");
        bw.append("#dailyWOMaxTimeCell\n");
        bw.append("2\n");
        bw.append("#dailyWOAddressCell\n");
        bw.append("7\n");
        bw.append("#reportClientNumberCell\n");
        bw.append("6\n");
        bw.append("#reportMinTimeCell\n");
        bw.append("4\n");
        bw.append("#reportMaxTimeCell\n");
        bw.append("5\n");
        bw.append("#reportAddressCell\n");
        bw.append("5\n");
        bw.close();
    }
    
    public void SaveConfigFile()
    {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file.getPath()))) {
            bw.write("#dailyWOClientNumberCell\n");
            bw.append(dailyWOClientNumberCell + "\n");
            bw.append("#dailyWOMinTimeCell\n");
            bw.append(dailyWOMinTimeCell + "\n");
            bw.append("#dailyWOMaxTimeCell\n");
            bw.append(dailyWOMaxTimeCell + "\n");
            bw.append("#dailyWOAddressCell\n");
            bw.append(dailyWOAddressCell + "\n");
            bw.append("#reportClientNumberCell\n");
            bw.append(reportClientNumberCell + "\n");
            bw.append("#reportMinTimeCell\n");
            bw.append(reportMinTimeCell + "\n");
            bw.append("#reportMaxTimeCell\n");
            bw.append(reportMaxTimeCell + "\n");
            bw.append("#reportAddressCell\n");
            bw.append(reportAddressCell + "\n");
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public int getDailyWOClientNumberCell() {
        return dailyWOClientNumberCell;
    }

    public void setDailyWOClientNumberCell(int dailyWOClientNumberCell) {
        this.dailyWOClientNumberCell = dailyWOClientNumberCell;
    }

    public int getDailyWOMinTimeCell() {
        return dailyWOMinTimeCell;
    }

    public void setDailyWOMinTimeCell(int dailyWOMinTimeCell) {
        this.dailyWOMinTimeCell = dailyWOMinTimeCell;
    }

    public int getDailyWOMaxTimeCell() {
        return dailyWOMaxTimeCell;
    }

    public void setDailyWOMaxTimeCell(int dailyWOMaxTimeCell) {
        this.dailyWOMaxTimeCell = dailyWOMaxTimeCell;
    }

    public int getDailyWOAddressCell() {
        return dailyWOAddressCell;
    }

    public void setDailyWOAddressCell(int dailyWOAddressCell) {
        this.dailyWOAddressCell = dailyWOAddressCell;
    }

    public int getReportClientNumberCell() {
        return reportClientNumberCell;
    }

    public void setReportClientNumberCell(int reportClientNumberCell) {
        this.reportClientNumberCell = reportClientNumberCell;
    }

    public int getReportMinTimeCell() {
        return reportMinTimeCell;
    }

    public void setReportMinTimeCell(int reportMinTimeCell) {
        this.reportMinTimeCell = reportMinTimeCell;
    }

    public int getReportMaxTimeCell() {
        return reportMaxTimeCell;
    }

    public void setReportMaxTimeCell(int reportMaxTimeCell) {
        this.reportMaxTimeCell = reportMaxTimeCell;
    }

    public int getReportAddressCell() {
        return reportAddressCell;
    }

    public void setReportAddressCell(int reportAddressCell) {
        this.reportAddressCell = reportAddressCell;
    }
}
