import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;

public class MatrixWindow
{
	
	protected Shell shell;
	private int mRow;
	private int mCol;
	private Text[][] mMatrix;
	
	public MatrixWindow(int row, int col)
	{
		mRow = row;
		mCol = col;
	}
	/**
	 * @wbp.parser.entryPoint
	 */
	public void NewScreen(int row, int col)
	{
		mRow = row;
		mCol = col;
		try
		{
			MatrixWindow window = new MatrixWindow(row, col);
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
		
		mMatrix = new Text[mRow][mCol];
		
		for (int i = 0; i < mRow; i++)
		{
			for (int j = 0; j < mCol; j++)
			{
				mMatrix[i][j] = new Text(shell, SWT.BORDER);
				mMatrix[i][j].setBounds(50 + j * 40, 52 + i * 40, 30, 30);
			}
		}
		System.out.println(mRow);
		System.out.println(mCol);
	}
}
