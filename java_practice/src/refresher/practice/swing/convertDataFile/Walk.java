package refresher.practice.swing.convertDataFile;

import java.io.PrintWriter;
import java.util.StringTokenizer;

class Walk extends Equipment
{
    Walk()
    {
    }

    public void readData(StringTokenizer t)
    {
        super.readData(t);
    }

    public void print(PrintWriter f)
    {
        f.print("equipwalk" + "|");
        super.print(f);
    }
}//~class Walk extends Equip...




