package src;

import model.ButtonMoveListener;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

public class ModelDefault {

	protected Shell shell;
	protected Display display;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ModelDefault window = new ModelDefault();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		display = Display.getDefault();
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
		shell.setSize(450, 300);
		shell.setText("Default");

		final Button btn = new Button(shell, SWT.BORDER);
		btn.setBounds(420, 10, 10, 10);
		btn.addMouseListener(new ButtonMoveListener());
		
		final Button btn0 = new Button(shell, SWT.NONE);
		btn0.setBounds(10, 250, 10, 10);
		btn0.addMouseListener(new ButtonMoveListener());
		
		Button btnstart = new Button(shell, SWT.NONE);
		btnstart.setBounds(10, 10, 50, 20);
		btnstart.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseUp(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseDown(MouseEvent arg0) {
				// TODO Auto-generated method stub
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						while(true){
							Model.minLeap(btn, btn0, display);
							display.asyncExec(new Runnable() {
								
								@Override
								public void run() {
									// TODO Auto-generated method stub
									Label label = new Label(shell, SWT.NONE);
									label.setBounds(btn.getLocation().x, btn.getLocation().y, 2, 2);
									label.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
								}
							});
							
							
						}
					}
				}).start();
			}
			
			@Override
			public void mouseDoubleClick(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		btnstart.addMouseListener(new ButtonMoveListener());
		
	}

}
