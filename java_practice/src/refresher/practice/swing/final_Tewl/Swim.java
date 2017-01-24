package refresher.practice.swing.final_Tewl;

import java.io.PrintStream;
import java.util.StringTokenizer;


/**
Instantiates Swim class
*/
public class Swim extends Equipment
{
    Swim()
    {
		goggleSize = "*";    
	}

    /**
    Returns goggle size.
    
    @param none
    
    @return Goggle size in String format
    */
    public String getGoggleSize()
    {
        return goggleSize;
    }

    /**
    Sets goggle size
    
    @param gSize Goggle size in String format
    
    @return void
    */
    public void setGoggleSize(String gSize)
    {
        goggleSize = gSize;
    }

    /**
    Reads data from stream passed in.
    
    @param t StringTokenizer
    
    @return void
    */
    public void readData(StringTokenizer t)
    {
        setGoggleSize(t.nextToken());
    }

    /**
    Prints data to stream passed in.
    
    @param f PrintStream
    
    @return void
    */
    public void print(PrintStream f)
    {
        f.print("equipswim" + "|");
        f.print(goggleSize + "|");
    }

    private String goggleSize = "*";
}//~class Swim extends Equip...





