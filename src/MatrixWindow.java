import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;

public class MatrixWindow
{
	
	protected Shell shell;
	private int mDimension;
	private Text[][] mTextMatrix;
	private int[][] mMatrix;
	
	public MatrixWindow(int dimension)
	{
		mDimension = dimension;
		mMatrix = new int[dimension][dimension];
	}
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public void NewScreen(int rowAndCol)
	{
		try
		{
			MatrixWindow window = new MatrixWindow(rowAndCol);
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
			
			for (int i = 0; i < mDimension; i++)
			{
				for (int j = 0; j < mDimension; j++)
				{
					try
					{
						mMatrix[i][j] = Integer.parseInt(mTextMatrix[i][j].getText());
					}
					catch (NumberFormatException e)
					{
						mMatrix[i][j] = 0;
					}
				}
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
		
		mTextMatrix = new Text[mDimension][mDimension];
		
		for (int i = 0; i < mDimension; i++)
		{
			for (int j = 0; j < mDimension; j++)
			{
				mTextMatrix[i][j] = new Text(shell, SWT.BORDER);
				mTextMatrix[i][j].setBounds(50 + j * 40, 52 + i * 40, 30, 30);
				System.out.println(mTextMatrix[i][j].getLocation().x + ", " + mTextMatrix[i][j].getLocation().y);
			}
		}
		
		Button getInvMatrix = new Button(shell, SWT.NONE);
		
		getInvMatrix.setText("Get inverse matrix");
		getInvMatrix.setBounds(mTextMatrix[mDimension - 1][mDimension - 1].getLocation().x + 40, mTextMatrix[mDimension - 1][mDimension - 1].getLocation().y, 130, 30);
	}
}
