package refresher.practice.swing.final_Tewl;

import java.io.PrintStream;
import java.util.StringTokenizer;


/**
Instantiates Equipment class.
*/
public class Equipment
{
    Equipment()
    {
		shoeModel = "*";
		shoeSize = "*";
    }

    /**
    Returns shoe model.
    
    @param none
    
    @return Shoe model in String format
    */
    public String getShoeModel()
    {
        return shoeModel;
    }

    /**
    Returns shoe size.
    
    @param none
    
    @return Shoe size in String format
    */
    public String getShoeSize()
    {
        return shoeSize;
    }

    /**
    Sets shoe model.
    
    @param model Shoe model in String format
    
    @return Shoe model in String format
    */
    public void setShoeModel(String model)
    {
        shoeModel = model;
    }

    /**
    Sets shoe size.
    
    @param size Shoe size in String format
    
    @return void
    */
    public void setShoeSize(String size)
    {
        shoeSize = size;
    }

    /**
    Reads data from stream passed in.
    
    @param t StringTokenizer
    
    @return void
    */
    public void readData(StringTokenizer t)
    {
        setShoeSize(t.nextToken());
        setShoeModel(t.nextToken());
    }

    /**
    Prints data to stream passed in.
    
    @param f PrintStream
    
    @return void
    */
    public void print(PrintStream f)
    {
        f.print(shoeSize + "|");
        f.print(shoeModel + "|");
    }

    /**
    Shoe model
    */
    protected String shoeModel = "*";
    
    /**
    Shoe size
    */
    protected String shoeSize = "*";
    
}//~class Equipment...





