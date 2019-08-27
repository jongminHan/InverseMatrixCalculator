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
		} catch (Exception e)
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

		Label lblEnterTheRow = new Label(shell, SWT.NONE);
		lblEnterTheRow.setBounds(114, 106, 140, 15);
		lblEnterTheRow.setText("Enter the number of row");

		Label lblEnterTheCol = new Label(shell, SWT.NONE);
		lblEnterTheCol.setBounds(114, 157, 163, 15);
		lblEnterTheCol.setText("Enter the number of column");

		Spinner spinnerRow = new Spinner(shell, SWT.BORDER);
		spinnerRow.setBounds(317, 106, 47, 22);

		Spinner spinnerCol = new Spinner(shell, SWT.BORDER);
		spinnerCol.setBounds(317, 157, 47, 22);

		Button btnOk = new Button(shell, SWT.NONE); // 버튼이 눌리면 주어진 행, 열의 개수에 따라 비어있는 매트릭스 생성
		btnOk.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseUp(MouseEvent e)
			{
				int row = spinnerRow.getSelection();
				int col = spinnerCol.getSelection();

				try
				{
					MatrixWindow matrix = new MatrixWindow();
					matrix.open();
					
				} catch (Exception ex)
				{
					ex.printStackTrace();
				}
			}
		});
		btnOk.setBounds(449, 157, 75, 25);
		btnOk.setText("OK");
	}
}