package pen.test.AlternatelyPrintParity;


/**
 * @Description : 打印偶数的线程
 * @Date: 2018年8月5日 下午5:32:47
 */
public class PrintEven implements Runnable {

    Num num;

    public PrintEven(Num num) {
        this.num = num;

    }

    public void run() {
        while (num.i <= 100) {
            synchronized (num) {// 必须要用同一把锁对象，这个对象是num
                if (!num.flag) {
                    try {
                        num.wait();// wait()函数必须和锁死同一个
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                } else {
                    System.out.println("偶数----" + num.i);
                    num.i++;
                    num.flag = false;
                    num.notify();
                }

            }
        }
    }

}