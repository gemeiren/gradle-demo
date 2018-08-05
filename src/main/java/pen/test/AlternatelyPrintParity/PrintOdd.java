package pen.test.AlternatelyPrintParity;


/**
 * @Description :打印奇数的线程 
 * @Date: 2018年8月5日 下午5:32:58
 */
public class PrintOdd implements Runnable {
    Num num;

    public PrintOdd(Num num) {
        this.num = num;

    }

    public void run() {
        while (num.i <= 100) {
            synchronized (num) {
                if (num.flag) {
                    try {
                        num.wait();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                } else {
                    System.out.println("奇数----" + num.i);
                    num.i++;
                    num.flag = true;
                    num.notify();
                }

            }
        }
    }
}
