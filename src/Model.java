package src;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;

public class Model {
	
	/**
	 * 工具类禁止实例化
	 */
	private Model() {
		
	}

	/**
	 * 圆圈运动
	 * @param btn：运动按钮控件
	 * @param btn0：基准按钮控件
	 * @param display：所在显示框
	 * @param l：单次运动弧长距离
	 */
	public static void circle(final Button btn, final Button btn0, Display display, final double l) {
		
		display.syncExec(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				double[] tempBr=new double[2];
				tempBr=GongJu.RectToPolar(btn.getLocation().x, 
						btn.getLocation().y, 
						btn0.getLocation().x, 
						btn0.getLocation().y);
				double dB=Math.toDegrees(l/tempBr[1]);
				double[] tempXY=new double[2];
				tempXY=GongJu.PolarToRect(tempBr[0]+dB, 
						tempBr[1], 
						btn0.getLocation().x, 
						btn0.getLocation().y);
				btn.setLocation((int)GongJu.around(tempXY[0], 0), 
						(int)GongJu.around(tempXY[1], 0));
			}
		});
		
	}
	
	/**
	 * 直线运动
	 * @param btn：运动按钮控件
	 * @param btn0：基准按钮控件
	 * @param display：所在显示框
	 * @param v：单次运动距离
	 */
	public static void straight(final Button btn, final Button btn0, Display display, final double v) {
		
		display.syncExec(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				double[] tempXY=new double[2];
				tempXY=GongJu.getSpeedXY(btn.getLocation().x, 
						btn.getLocation().y, 
						btn0.getLocation().x, 
						btn0.getLocation().y, 
						v);
				btn.setLocation(btn.getLocation().x+(int)GongJu.around(tempXY[0], 0), 
						btn.getLocation().y+(int)GongJu.around(tempXY[1], 0));
			}
		});
	}
	
	/**
	 * 最小位移运动（每次横纵坐标皆改变1）
	 * @param btn：运动按钮控件
	 * @param btn0：基准按钮控件
	 * @param display：所在显示框
	 */
	public static void minLeap(final Button btn, final Button btn0, Display display) {
		display.syncExec(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				double[] tempXY=new double[2];
				tempXY=GongJu.minLeap(btn.getLocation().x, 
						btn.getLocation().y, 
						btn0.getLocation().x, 
						btn0.getLocation().y);
				btn.setLocation(btn.getLocation().x+(int)GongJu.around(tempXY[0], 0), 
						btn.getLocation().y+(int)GongJu.around(tempXY[1], 0));
			}
		});
	}
	
	/**
	 * 绝对直线运动（保证每次运动轨迹点必在与基准点的直线上）
	 * @param btn：运动按钮控件
	 * @param btn0：基准按钮控件
	 * @param display：所在显示框
	 */
	public static void absStraight(final Button btn, final Button btn0, Display display) {
		display.syncExec(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				int mcd=GongJu.maxCommonDivisor(Math.abs(btn0.getLocation().x-btn.getLocation().x), 
						Math.abs(btn0.getLocation().y-btn.getLocation().y));
				int[] tempXY=new int[2];
				if(mcd==0){
					if(Math.abs(btn0.getLocation().x-btn.getLocation().x)==0
							&&Math.abs(btn0.getLocation().y-btn.getLocation().y)!=0){
						tempXY[0]=0;
						tempXY[1]=(btn0.getLocation().y-btn.getLocation().y)
								/Math.abs(btn0.getLocation().y-btn.getLocation().y);
					}else if (Math.abs(btn0.getLocation().x-btn.getLocation().x)!=0
							&&Math.abs(btn0.getLocation().y-btn.getLocation().y)==0) {
						tempXY[0]=(btn0.getLocation().x-btn.getLocation().x)
								/Math.abs(btn0.getLocation().x-btn.getLocation().x);
						tempXY[1]=0;
					}else {
						tempXY[0]=0;
						tempXY[1]=0;
					}
				}else {
					tempXY[0]=(btn0.getLocation().x-btn.getLocation().x)/mcd;
					tempXY[1]=(btn0.getLocation().y-btn.getLocation().y)/mcd;
				}
				btn.setLocation(btn.getLocation().x+tempXY[0], 
						btn.getLocation().y+tempXY[1]);
			}
		});
	}
	
}
