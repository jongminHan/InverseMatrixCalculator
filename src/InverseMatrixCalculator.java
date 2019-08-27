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

public class InverseMatrixCalculator {

	protected Shell shell;
	private Text textRow;
	private Text textCol;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			InverseMatrixCalculator window = new InverseMatrixCalculator();
			window.open();
		} 
		catch (Exception e) {
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
		
		Label lblEnterTheRow = new Label(shell, SWT.NONE);
		lblEnterTheRow.setBounds(114, 106, 140, 15);
		lblEnterTheRow.setText("Enter the number of row");
		
		Label lblEnterTheCol = new Label(shell, SWT.NONE);
		lblEnterTheCol.setBounds(114, 157, 163, 15);
		lblEnterTheCol.setText("Enter the number of column");
		
		textRow = new Text(shell, SWT.BORDER); // 행의 개수를 입력
		textRow.setBounds(317, 106, 76, 21);
		
		textCol = new Text(shell, SWT.BORDER); // 열의 개수를 입력
		textCol.setBounds(317, 157, 76, 21);
		
		Button btnOk = new Button(shell, SWT.NONE); // 버튼이 눌리면 주어진 행, 열의 개수에 따라 비어있는 매트릭스 생성
		btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				int row = Integer.parseInt(textRow.getText());
				int col = Integer.parseInt(textCol.getText());
				
				System.out.println("Row:" + row);
				System.out.println("Column:" + col);
			}
		});
		btnOk.setBounds(449, 157, 75, 25);
		btnOk.setText("OK");
	}
}