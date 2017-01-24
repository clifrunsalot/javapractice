package refresher.practice.swing.convertDataFile;

import java.io.PrintWriter;
import java.util.StringTokenizer;

class Swim extends Equipment
{
    Swim()
    {
    }

    public String getGoggleSize()
    {
        return goggleSize;
    }

    public void setGoggleSize(String gSize)
    {
        goggleSize = gSize;
    }

    public void readData(StringTokenizer t)
    {
        setGoggleSize(t.nextToken());
    }

    public void print(PrintWriter f)
    {
        f.print("equipswim" + "|");
        f.print(goggleSize + "|");
    }

    private String goggleSize = "*";
}//~class Swim extends Equip...




