/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package database.comparators;

import database.validation.WOData;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 * Klasa porównuje dwie bazy danych.
 * Zwraca wypełniony model tablicy JTable.
 */

public class Comparator {
    private int validRecord;
    private int invalidRecord;
    private int unknownRecord;
    private DefaultTableModel finalModel;
    
    public Comparator(){}
    
    public DefaultTableModel CompareDatabases(WOData[] master, WOData[] slave, JTable table)
    {
        finalModel = (DefaultTableModel) table.getModel();
        finalModel.setRowCount(master.length);
        CreateTableModel(master, slave);
        CenterColumns(table);
        return finalModel;
    }
    
    public String GetOverallStatus()
    {
        String wynik = "Porównanie zakończone. " + validRecord + " poprawnych, " + invalidRecord + " niepoprawnych, " + unknownRecord + " nie znaleniono.";
        validRecord=0;
        invalidRecord=0;
        unknownRecord=0;
        return wynik;
    }
    
    private void CreateTableModel(WOData[] master, WOData[] slave)
    {
        boolean found = false;
        for (int i=0;i<master.length;i++)
        {
            finalModel.setValueAt(master[i].getClientNumber(), i, 0);
            finalModel.setValueAt(master[i].getMinTime(), i, 1);
            finalModel.setValueAt(master[i].getMaxTime(), i, 2);
            finalModel.setValueAt(master[i].getClientAddress(), i, 3);
            for (int j=0;j<slave.length;j++)
            {
                if (slave[j].getClientNumber() == master[i].getClientNumber())
                {
                    finalModel.setValueAt(slave[j].getClientNumber(), i, 4);
                    finalModel.setValueAt(slave[j].getMinTime(), i, 5);
                    finalModel.setValueAt(slave[j].getMaxTime(), i, 6);
                    finalModel.setValueAt(slave[j].getClientAddress(), i, 7);
                    if ((slave[j].getMinTime() == master[i].getMinTime()) && (slave[j].getMaxTime() == master[i].getMaxTime()))
                    {
                        if ((slave[j].getClientAddress().equals(master[i].getClientAddress())))
                        {
                            finalModel.setValueAt("Poprawne", i, 8);
                            validRecord++;
                        }
                        else
                        {
                            finalModel.setValueAt("Błąd w adresie", i, 8);
                            if (CheckForDoubles(slave, master[i].getClientNumber(),j)==true) continue;
                            invalidRecord++;
                        }
                        found = true;
                        break;
                    }
                    else
                    {
                        if ((slave[j].getClientAddress().equals(master[i].getClientAddress())))
                        {
                            finalModel.setValueAt("Błąd w przedziale czasowym", i, 8);
                            if (CheckForDoubles(slave, master[i].getClientNumber(),j)==true) continue;
                            invalidRecord++;
                        }
                        else
                        {
                            finalModel.setValueAt("Błąd w całym zleceniu", i, 8);
                            if (CheckForDoubles(slave, master[i].getClientNumber(),j)==true) continue;
                            invalidRecord++;
                        }
                        found = true;
                        break;
                    }
                }
            }
            if (found == false)
            {
                finalModel.setValueAt("Brak w raporcie", i, 8);
                unknownRecord++;
            }
            found = false;
        }
    }
    
    private boolean CheckForDoubles(WOData[] databaseArray, int clientNumber, int indexNumber)
    {
        boolean result = false;
        for (int i=indexNumber+1; i<databaseArray.length;i++)
        {
            if (databaseArray[i].getClientNumber() == clientNumber) result = true;
        }
        return result;
    }
    
    private void CenterColumns(JTable table)
    {
        for (int i=0;i<table.getColumnCount();i++)
            {
                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
                table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }
    }
}
