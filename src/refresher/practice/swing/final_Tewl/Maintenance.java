package refresher.practice.swing.final_Tewl;

import java.io.IOException;
import java.io.PrintStream;
import java.util.StringTokenizer;

public class Maintenance
{
    Maintenance()
    {
		maintDate = "*";
		maintSummary = "*";
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

    public void printData(PrintStream fout)
    {
        fout.print(getMaintDate() + "|" +
            getMaintSummary() + "|");
    }

    private String maintDate = "*";
    private String maintSummary = "*";
}//~class Maintenance...





