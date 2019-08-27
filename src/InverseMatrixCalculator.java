import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;

public class InverseMatrixCalculator {

	protected Shell shell;
	private Text text;
	private Text text_1;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			InverseMatrixCalculator window = new InverseMatrixCalculator();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(749, 379);
		shell.setText("SWT Application");
		
		Label lblEnterTheNumber = new Label(shell, SWT.NONE);
		lblEnterTheNumber.setBounds(114, 106, 140, 15);
		lblEnterTheNumber.setText("Enter the number of row");
		
		Label lblEnterTheNumber_1 = new Label(shell, SWT.NONE);
		lblEnterTheNumber_1.setBounds(114, 157, 163, 15);
		lblEnterTheNumber_1.setText("Enter the number of column");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(317, 106, 76, 21);
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(317, 157, 76, 21);
		
		Button btnOk = new Button(shell, SWT.NONE);
		btnOk.setBounds(449, 157, 75, 25);
		btnOk.setText("OK");

	}
}