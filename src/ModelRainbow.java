package src;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

public class ModelRainbow {

	protected Shell shell;
	protected Display display;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ModelRainbow window = new ModelRainbow();
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
		shell.setText("Rainbow");
		
		final Button bb1=new Button(shell, SWT.NONE);
		final Button bb2=new Button(shell, SWT.NONE);
		final Button bb3=new Button(shell, SWT.NONE);
		final Button bb4=new Button(shell, SWT.NONE);
		final Button bb5=new Button(shell, SWT.NONE);
		final Button bb6=new Button(shell, SWT.NONE);
		final Button bb7=new Button(shell, SWT.NONE);
		
		final Button btn0 = new Button(shell, SWT.NONE);
		btn0.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				for(int i=0; i<=180; i++){
					
        			final double[] temp1 = GongJu.PolarToRect(0+i, 
        					100, 
        					btn0.getLocation().x+btn0.getSize().x/2, 
        					btn0.getLocation().y+btn0.getSize().y/2);
        			System.out.println("直角坐标："+"{"+"横坐标："+GongJu.around(temp1[0], 0)+"纵坐标："+GongJu.around(temp1[1], 0)+"}");
        			display.asyncExec(new Runnable() {
        				
        				@Override
        				public void run() {
        					// TODO Auto-generated method stub
        					bb1.setBounds((int)GongJu.around(temp1[0], 0), (int)GongJu.around(temp1[1], 0), 10, 10);
        					bb1.setVisible(false);
        					Label ll=new Label(shell, SWT.NONE);
        					ll.setBounds(bb1.getBounds().x, 
        							bb1.getBounds().y, 
        							bb1.getBounds().width, 
        							bb1.getBounds().height);
        					ll.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));	
        				}
        			});
        			
        			
        			final double[] temp2 = GongJu.PolarToRect(0+i, 
        					110, 
        					btn0.getLocation().x+btn0.getSize().x/2, 
        					btn0.getLocation().y+btn0.getSize().y/2);
        			System.out.println("直角坐标："+"{"+"横坐标："+GongJu.around(temp2[0], 0)+"纵坐标："+GongJu.around(temp2[1], 0)+"}");
        			display.asyncExec(new Runnable() {
        				
        				@Override
        				public void run() {
        					// TODO Auto-generated method stub
        					bb2.setBounds((int)GongJu.around(temp2[0], 0), (int)GongJu.around(temp2[1], 0), 10, 10);
        					bb2.setVisible(false);
        					Label ll=new Label(shell, SWT.NONE);
        					ll.setBounds(bb2.getBounds().x, 
        							bb2.getBounds().y, 
        							bb2.getBounds().width, 
        							bb2.getBounds().height);
        					ll.setBackground(SWTResourceManager.getColor(SWT.COLOR_GREEN));	
        				}
        			});
        			
        			
        			final double[] temp3 = GongJu.PolarToRect(0+i, 
        					120, 
        					btn0.getLocation().x+btn0.getSize().x/2, 
        					btn0.getLocation().y+btn0.getSize().y/2);
        			System.out.println("直角坐标："+"{"+"横坐标："+GongJu.around(temp3[0], 0)+"纵坐标："+GongJu.around(temp3[1], 0)+"}");
        			display.asyncExec(new Runnable() {
        				
        				@Override
        				public void run() {
        					// TODO Auto-generated method stub
        					bb3.setBounds((int)GongJu.around(temp3[0], 0), (int)GongJu.around(temp3[1], 0), 10, 10);
        					bb3.setVisible(false);
        					Label ll=new Label(shell, SWT.NONE);
        					ll.setBounds(bb3.getBounds().x, 
        							bb3.getBounds().y, 
        							bb3.getBounds().width, 
        							bb3.getBounds().height);
        					ll.setBackground(SWTResourceManager.getColor(SWT.COLOR_YELLOW));
        				}
        			});
        			
        			
        			final double[] temp4 = GongJu.PolarToRect(0+i, 
        					130, 
        					btn0.getLocation().x+btn0.getSize().x/2, 
        					btn0.getLocation().y+btn0.getSize().y/2);
        			System.out.println("直角坐标："+"{"+"横坐标："+GongJu.around(temp4[0], 0)+"纵坐标："+GongJu.around(temp4[1], 0)+"}");
        			display.asyncExec(new Runnable() {
        			
        				@Override
        				public void run() {
        					// TODO Auto-generated method stub
        					bb4.setBounds((int)GongJu.around(temp4[0], 0), (int)GongJu.around(temp4[1], 0), 10, 10);
        					bb4.setVisible(false);
        					Label ll=new Label(shell, SWT.NONE);
        					ll.setBounds(bb4.getBounds().x, 
        							bb4.getBounds().y, 
        							bb4.getBounds().width, 
        							bb4.getBounds().height);
        					ll.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLUE));	
        				}
        			});
        			
        			
        			final double[] temp5 = GongJu.PolarToRect(0+i, 
        					140, 
        					btn0.getLocation().x+btn0.getSize().x/2, 
        					btn0.getLocation().y+btn0.getSize().y/2);
        			System.out.println("直角坐标："+"{"+"横坐标："+GongJu.around(temp5[0], 0)+"纵坐标："+GongJu.around(temp5[1], 0)+"}");
        			display.asyncExec(new Runnable() {
        				
        				@Override
        				public void run() {
        					// TODO Auto-generated method stub
        					bb5.setBounds((int)GongJu.around(temp5[0], 0), (int)GongJu.around(temp5[1], 0), 10, 10);
        					bb5.setVisible(false);
        					Label ll=new Label(shell, SWT.NONE);
        					ll.setBounds(bb5.getBounds().x, 
        							bb5.getBounds().y, 
        							bb5.getBounds().width, 
        							bb5.getBounds().height);
        					ll.setBackground(SWTResourceManager.getColor(SWT.COLOR_MAGENTA));
        				}
        			});
        			
        			
        			final double[] temp6 = GongJu.PolarToRect(0+i, 
        					150, 
        					btn0.getLocation().x+btn0.getSize().x/2, 
        					btn0.getLocation().y+btn0.getSize().y/2);
        			System.out.println("直角坐标："+"{"+"横坐标："+GongJu.around(temp6[0], 0)+"纵坐标："+GongJu.around(temp6[1], 0)+"}");		
        			display.asyncExec(new Runnable() {
        				
        				@Override
        				public void run() {
        					// TODO Auto-generated method stub
        					bb6.setBounds((int)GongJu.around(temp6[0], 0), (int)GongJu.around(temp6[1], 0), 10, 10);
        					bb6.setVisible(false);
        					Label ll=new Label(shell, SWT.NONE);
        					ll.setBounds(bb6.getBounds().x, 
        							bb6.getBounds().y, 
        							bb6.getBounds().width, 
        							bb6.getBounds().height);
        					ll.setBackground(SWTResourceManager.getColor(SWT.COLOR_CYAN));	
        				}
        			});
        			
        			
        			final double[] temp7 = GongJu.PolarToRect(0+i, 
        					160, 
        					btn0.getLocation().x+btn0.getSize().x/2, 
        					btn0.getLocation().y+btn0.getSize().y/2);
        			System.out.println("直角坐标："+"{"+"横坐标："+GongJu.around(temp7[0], 0)+"纵坐标："+GongJu.around(temp7[1], 0)+"}");
        			display.asyncExec(new Runnable() {
        				
        				@Override
        				public void run() {
        					// TODO Auto-generated method stub
        					bb7.setBounds((int)GongJu.around(temp7[0], 0), (int)GongJu.around(temp7[1], 0), 10, 10);
        					bb7.setVisible(false);
        					Label ll=new Label(shell, SWT.NONE);
        					ll.setBounds(bb7.getBounds().x, 
        							bb7.getBounds().y, 
        							bb7.getBounds().width, 
        							bb7.getBounds().height);
        					ll.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));	
        				}
        			});
        			
				}
			}
		});
		btn0.setBounds(200, 120, 30, 30);
		btn0.addMouseListener(new ButtonMoveListener());
		}

}
