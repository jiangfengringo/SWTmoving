package src;

import java.math.BigDecimal;

public class GongJu {
	
	/**
	 * 工具类禁止实例化
	 */
	private GongJu() {
		
	}

    /**
     * 提供精确的小数位四舍五入处理。
     * @param v 需要四舍五入的数字
     * @param scale 小数点后保留几位
     * @return 四舍五入后的结果
     */
    public static double around(double v, int scale){
    	
        if(scale<0){
            throw new IllegalArgumentException(
                "精度scale不能小于0！");
        }
        BigDecimal b = new BigDecimal(Double.toString(v));
        BigDecimal d = new BigDecimal("1");
        return b.divide(d, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
    
    /**
     * 获取两个整型数的最大公约数
     * @param 整型数a
     * @param 整型数b
     * @return 最大整型公约数
     */
  	public static int maxCommonDivisor(int a, int b){
  		
		if(a>b){
		    int temp=a;
		    a=b;
		    b=temp;
		}
  		if(a==0){
  			return 0;
  		}
		if(b%a==0)
			return a;
		else 
			return maxCommonDivisor(a,b%a);
  	}
  	
  	/**
  	 * 将直角坐标系转化成极坐标系用来描述圆的轨迹，由于对应的SWT的面板，故Y轴的正方向朝下
  	 * @param x：起点横坐标
  	 * @param y：起点纵坐标
  	 * @param x0：圆心横坐标
  	 * @param y0：圆心纵坐标
  	 * @return 起点以圆心为原点的极坐标的角度和长度
  	 */
  	public static double[] RectToPolar(double x, double y, double x0, double y0) {
  		
  		double r;// 极坐标半径  
        double B = 0;// 极坐标夹角  
        r = Math.abs(Math.hypot(x-x0, y-y0)); //返回斜边长 
        if ((y-y0) >= 0) {  
            if ((x-x0) == 0) {  
                B = 3*Math.PI/2;// 270°  
            } else {  
                B = Math.atan((x-x0)/(y-y0))+3*Math.PI/2;  
            }  
        } else if ((y-y0) < 0) {  
            if ((x-x0) == 0) {  
                B = Math.PI/2;// 90°  
            } else {  
                B = Math.atan((x-x0)/(y-y0))+Math.PI/2;  
            }  
        }
        double[] Br = new double[2];
        Br[0]=Math.toDegrees(B);
        Br[1]=r;  
        return Br;
  	}
  	
  	/**
  	 * 将描绘圆轨迹的极坐标转化为直角坐标
  	 * @param B：极坐标夹角
  	 * @param r：极坐标半径
  	 * @param x0：终点横坐标
  	 * @param y0：终点纵坐标
  	 * @return 以终点为圆心的对应的极坐标转换而来的直角坐标
  	 */
  	public static double[] PolarToRect(double B, double r, double x0, double y0) {
  		
  		double x;
  		double y;
  		x = x0+r*Math.cos(Math.toRadians(B));
  		y = y0-r*Math.sin(Math.toRadians(B));
  		double[] xy = new double[2];
  		xy[0]=x;
  		xy[1]=y;
  		return xy;
  	}
    
  	/**
  	 * 确定起点终点和单次运动距离，得到单次边速度
  	 * @param x：起点横坐标
  	 * @param y：起点纵坐标
  	 * @param x0：终点横坐标
  	 * @param y0：终点纵坐标
  	 * @param v：单次运动距离
  	 * @return 横纵坐标方向单次运动距离
  	 */
  	public static double[] getSpeedXY(double x, double y, double x0, double y0, double v) {
  		
  		double dx;
  		double dy;
  		if(Math.abs(x0-x)<0.1){
  			x0=x0+0.1;
  		}
  		dx=v*Math.cos(Math.atan((y0-y)/(x0-x)));
  		dy=v*Math.sin(Math.atan((y0-y)/(x0-x)));
  		System.out.println(Math.toDegrees(Math.atan((y0-y)/(x0-x))));
  		double[] xy = new double[2];
  		if((x0-x)>=0){
  			xy[0]=dx;
  			xy[1]=dy;
  		}else if ((x0-x)<0) {
  			xy[0]=-dx;
  			xy[1]=-dy;
  		}else {
  			System.out.println("error");
  		}
  		return xy;
  	}
  	
  	/**
  	 * 最小运动模式，当起点和终点的横纵坐标不相同时，采用每次变化为1的运动
  	 * @param x：起点横坐标
  	 * @param y：起点纵坐标
  	 * @param x0：终点横坐标
  	 * @param y0：终点纵坐标
  	 * @return 横纵坐标方向单次运动距离
  	 */
	public static double[] minLeap(double x, double y, double x0, double y0) {
		
		double[] temp=new double[2];
		if(Math.abs(x0-x)<0.5&&Math.abs(y0-y)>=0.5){
			temp[0]=0;
			temp[1]=Math.abs(y0-y)/(y0-y);
		}else if (Math.abs(x0-x)>=0.5&&Math.abs(y0-y)<0.5) {
			temp[0]=Math.abs(x0-x)/(x0-x);
			temp[1]=0;
		}else if (Math.abs(x0-x)>=0.5&&Math.abs(y0-y)>=0.5) {
			temp[0]=Math.abs(x0-x)/(x0-x);
			temp[1]=Math.abs(y0-y)/(y0-y);
		}else if(Math.abs(x0-x)<0.5&&Math.abs(y0-y)<0.5){
			temp[0]=0;
			temp[1]=0;
		}else {
			System.out.println("error");
		}
		return temp;
	}
  	
}
