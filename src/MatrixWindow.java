import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class MatrixWindow
{
	
	protected Shell shell;
	private int mRow;
	private int mCol;

	
	/**
	 * @wbp.parser.entryPoint
	 */
	public void NewScreen(int row, int col)
	{
		mRow = row;
		mCol = col;
		try
		{
			MatrixWindow window = new MatrixWindow();
			window.open();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Open the window.
	 */
	public void open()
	{
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed())
		{
			if (!display.readAndDispatch())
			{
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents()
	{
		shell = new Shell();
		shell.setSize(552, 393);
		shell.setText("Matrix Window");

	}

}
