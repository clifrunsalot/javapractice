package refresher.practice.swing.final_Tewl;

import java.io.PrintStream;
import java.util.StringTokenizer;

/**
Instantiates Run class
*/
public class Run extends Equipment
{
    Run()
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
        f.print("equiprun" + "|");
        super.print(f);
    }
}//~class Run extends Equipm...





