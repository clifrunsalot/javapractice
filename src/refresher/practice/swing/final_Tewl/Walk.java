package refresher.practice.swing.final_Tewl;

import java.io.PrintStream;
import java.util.StringTokenizer;

/**
Instantiates the Walk class.
*/
public class Walk extends Equipment
{
    Walk()
    {
    }

    /**
    Reads data from stream passed in.
    
    @param t StringTokenizer
    
    @return void
    */
    public void readData(StringTokenizer t)
    {
        super.readData(t);
    }

    /**
    Prints data to stream passed in.
    
    @param f PrintStream
    
    @return void
    */
    public void print(PrintStream f)
    {
        f.print("equipwalk" + "|");
        super.print(f);
    }
}//~class Walk extends Equip...





