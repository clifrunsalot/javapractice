package refresher.practice.swing.convertDataFile;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class Maintenance
{
    Maintenance()
    {
    }

    public void setMaintDate(String s)
    {
        maintDate = s;
    }

    public void setMaintSummary(String s)
    {
        maintSummary = s;
    }

    public String getMaintDate()
    {
        return maintDate;
    }

    public String getMaintSummary()
    {
        return maintSummary;
    }

    public void readData(StringTokenizer t) throws
    IOException
    {
        setMaintDate(t.nextToken());
        setMaintSummary(t.nextToken());
    }

    public void printData(PrintWriter fout)
    {
        fout.print(getMaintDate() + "|" +
            getMaintSummary() + "|");
    }

    private String maintDate = "*";
    private String maintSummary = "*";
}//~class Maintenance...




