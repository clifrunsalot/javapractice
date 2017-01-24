package refresher.practice.swing.TextFieldTest;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

class intTextDocument extends PlainDocument
{
	public void insertString(int offs, String str, AttributeSet a)
	throws BadLocationException
	{
		if ((str == null) || (getLength() >= intTextField.cols))
		 return;
		else
		{
			try
			{
				Integer.parseInt(str);
				super.insertString(offs,str,a);
			}
			catch(NumberFormatException e)
			{
			}
		}
	}
}

class intTextField extends JTextField
{
	public intTextField(int size)
	{
		super(size);
		cols = size;
	}
	
	protected Document createDefaultModel()
	{
		return new intTextDocument();
	}
	
	protected static int cols;
}

class MyFrame extends JFrame implements DocumentListener
{
	public MyFrame()
	{
		setSize(150, 150);
		setTitle("TextField Test");

		tf1 = new intTextField(2);
		tf1.getDocument().addDocumentListener(this);
		tf2 = new intTextField(3);
		tf2.getDocument().addDocumentListener(this);
		tf3 = new intTextField(4);
		tf3.getDocument().addDocumentListener(this);

		p = new JPanel();
		p.add(tf1);
		p.add(tf2);
		p.add(tf3);
		getContentPane().add(p);

		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				dispose();
				System.exit(0);
			}
		});
	}
	
	public void insertUpdate(DocumentEvent e)
	{
	}
	
	public void removeUpdate(DocumentEvent e)
	{
	}
	
	public void changedUpdate(DocumentEvent e)
	{
	}
	
	private JPanel p;
	private intTextField tf1,tf2,tf3;
}

public class TextFieldTest
{
	public static void main(String args[])
	{
		System.out.println("Starting TextFieldTest...");
		MyFrame mainFrame = new MyFrame();
		mainFrame.show();
	}
}
