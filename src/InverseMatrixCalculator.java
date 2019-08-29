import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class InverseMatrixCalculator
{

	protected Shell shell;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		try
		{
			InverseMatrixCalculator window = new InverseMatrixCalculator();
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
		shell.setSize(749, 379);
		shell.setText("SWT Application");

		Label lblEnterTheDimension = new Label(shell, SWT.NONE);
		lblEnterTheDimension.setBounds(114, 157, 227, 15);
		lblEnterTheDimension.setText("Enter the dimension of square matrix");

		Spinner spinner = new Spinner(shell, SWT.BORDER);
		spinner.setBounds(347, 154, 47, 22);

		Button btnOk = new Button(shell, SWT.NONE); // 버튼이 눌리면 주어진 행, 열의 개수에 따라 비어있는 매트릭스 생성
		
		btnOk.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseUp(MouseEvent e)
			{
				int dimension = spinner.getSelection();

				try
				{
					MatrixWindow matrix = new MatrixWindow(dimension);
					matrix.NewScreen(dimension);
					
				} 
				catch (Exception ex)
				{
					ex.printStackTrace();
				}
			}
		});
		btnOk.setBounds(442, 152, 75, 25);
		btnOk.setText("OK");
	}
}