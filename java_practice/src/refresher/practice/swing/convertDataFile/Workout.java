package refresher.practice.swing.convertDataFile;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;



class Workout{
	//============= Constructor =============//
	//Empty constructor that sets all data types to default values
	Workout()
	{
		//System.out.println("Workout");
		len = 0;
		events = new WorkoutEvent[MAXEVENTS];
	}

	//============= Accessors =============//
	public WorkoutDate getDate()
	{
		//System.out.println("WorkoutDate.getDate");
		return date;
	}

	public WorkoutEvent [] getEvents()
	{
		//System.out.println("Workout.getEvents");

		for (int i=0; i<events.length; i++)
		{
			events[i].getEvent();
		}
		return events;
	}

	public String getWeather()
	{
		//System.out.println("Workout.getWeather");
		return weather;
	}

	public int getTemp()
	{
		//System.out.println("Workout.getTemp");
		return temp;
	}

	public String getSummary()
	{
		//System.out.println("Workout.getSummary");
		return summary;
	}

	public int getPu()
	{
		//System.out.println("Workout.getPu");
		return pushUps;
	}

	public int getSu()
	{
		//System.out.println("Workout.getSu");
		return sitUps;
	}

	//============= Mutators =============//
	public void setDate(int m,int d,int y)
	{
		//System.out.println("Workout.setDate");
		try
		{
			date = new WorkoutDate(m,d,y);
		}
		catch(IllegalArgumentException e)
		{
			throw e;
		}
	}//~public void setDate(int ...

	public void setWeather(String w)
	{
		//System.out.println("Workout.setWeather");
		weather = w;
	}

	public void setTemp(int tmp)
	{
		//System.out.println("Workout.setTemp");
		temp = tmp;
	}

	public void setEvent(String e, double d, String t)
	{
		//System.out.println("Workout.setEvent");
		if(len <= MAXEVENTS)
		{
			event = new WorkoutEvent(e,d,t);
			events[len] = event.getEvent();
			len++;
		}
	}

	public void setSummary(String s)
	{
		//System.out.println("Workout.setSummary");
		summary = s;
	}

	public void setPu(int p)
	{
		//System.out.println("Workout.setPu");
		pushUps = p;
	}

	public void setSu(int s)
	{
		//System.out.println("Workout.setSu");
		sitUps = s;
	}

	//Reads one record from input stream
	public void readData(StringTokenizer t)
		throws    IOException
	{
		//System.out.println("Workout.readData");

		int month = Integer.parseInt(t.nextToken());
		int day = Integer.parseInt(t.nextToken());
		int year = Integer.parseInt(t.nextToken());
		setDate(month,day,year);
		setTemp(Integer.parseInt(t.nextToken()));
		setWeather(t.nextToken());

		for (int i=0; i<MAXEVENTS; i++)
		{
			setEvent(t.nextToken(),
					Double.parseDouble(t.nextToken()),
					t.nextToken());
		}

		setSummary(t.nextToken());
		setPu(Integer.parseInt(t.nextToken()));
		setSu(Integer.parseInt(t.nextToken()));
	}//~IOException...

	public void printData (PrintWriter fout)
	{
		//System.out.println("Workout.print");
		fout.print
			(getDate().getMonth() + "|" +
			getDate().getDay() + "|" +
			getDate().getYear() + "|" +
			getTemp() + "|" +
			getWeather() + "|" +
			"0" + "|" +
			"0" + "|");

		for (int i=0; i<MAXEVENTS; i++)
		{
			fout.print
				(events[i].getName() + "|" +
				events[i].getDistance() + "|" +
				events[i].getTime().getTime().toString() + "|" +
				"*" + "|");
		}

		fout.print
			(getSummary() + "|" +
			getPu() + "|" +
			getSu() + "|");

	}//~public void print (Print...

	//Private types
	private WorkoutDate date;
	private WorkoutEvent [] events;
	private WorkoutEvent event;
	private final int MAXEVENTS = 3;
	private int len;
	private String weather;
	private int temp;
	private String summary;
	private int sitUps;
	private int pushUps;
}//~class Workout...	??



