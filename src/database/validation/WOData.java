/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package database.validation;

/**
 * Przechowuje dane z dailywo i raportu.
 */

public class WOData {
    private int clientNumber;
    private int minTime;
    private int maxTime;
    private String clientAddress;
    
    public void setClientNumber(int clientNumber)
    {
        this.clientNumber = clientNumber;
    }
    
    public void setMinTime(int minTime)
    {
        this.minTime = minTime;
    }
    
    public void setMaxTime(int maxTime)
    {
        this.maxTime = maxTime;
    }
    
    public void setClientAddress(String clientAddress)
    {
        this.clientAddress = clientAddress;
    }
    
    public int getClientNumber()
    {
        return clientNumber;
    }
    
    public int getMinTime()
    {
        return minTime;
    }
    
    public int getMaxTime()
    {
        return maxTime;
    }
    public String getClientAddress()
    {
        return clientAddress;
    }
    
    public WOData(){}
}
