package javaBase.withor;

import java.util.Timer;
import java.util.TimerTask;

/** 
 * @Description: 静态变量的控制修改
 * @date 2016年2月26日  上午10:45:02
 */
public class TestStatic {

	static int intStatic=1;
	
	public static void main(String[] args) {
		try {
				new Thread(new Runnable() {
					@Override
					public void run() {
						//每1秒输出static值
						while(true){
							intStaticPrint();
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
				}).start();
				
				System.out.println("第二个线程");
				timer1();
				
				System.out.println("第三个线程");
				timer2();
				
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected static void intStaticPrint() {
		System.out.println("intStatic值："+intStatic);
	}
	
	 /**
	 * @Description 定时器1
	 * @date 2016年2月26日  上午11:26:51
	 */
	public static void timer1() {
		 
		 System.out.println("启动定时器1");
	        Timer timer = new Timer();
	        timer.schedule(new TimerTask() {
	            public void run() {
	            	intStatic=123456;
	                System.out.println("-------设定要指定任务--------");
	            }
	        }, 10000);// 设定指定的时间time,此处为10000毫秒后
	    }
	 
	 /**
		 * @Description 定时器2
		 * @date 2016年2月26日  上午11:26:51
		 */
	public static void timer2() {

		System.out.println("启动定时器2");
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			public void run() {
				intStatic=789;
				System.out.println("-------第二次设定要指定任务--------");
			}
		}, 12000);// 设定指定的时间time,此处为12000毫秒
	}
	 
}