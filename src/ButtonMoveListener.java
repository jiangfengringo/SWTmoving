package src;

import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;

public class ButtonMoveListener implements MouseListener, MouseMoveListener{

	//事件源
    private Button button=null;
    
    //鼠标按下时相对Button的位置
    private int x, y;
    
    @Override
    public void mouseDown(MouseEvent e) {
    	
        //鼠标右键
        if(e.button==3){
            button=(Button)e.getSource();
            x = e.x;
            y = e.y;
            button.addMouseMoveListener(this);
        }
    }
    
    @Override
    public void mouseUp(MouseEvent e) {
    	
        if(e.button==3){
            button.removeMouseMoveListener(this);
        }
    }
    
    @Override
    public void mouseMove(MouseEvent e) {
    	
        // 当前鼠标相对父窗体的位置
        Point point = Display.getCurrent().map(button,
                button.getParent(), e.x, e.y);
        Rectangle bounds = button.getBounds();
        
        // 重新设置按钮的位置，使之跟随鼠标移动
        button.setBounds(point.x - x, point.y - y,
                bounds.width, bounds.height);
    }
    
    @Override
    public void mouseDoubleClick(MouseEvent arg0) {
    }
    
}
