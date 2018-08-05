package pen.test.AlternatelyPrintParity;


/**
 * @Description : 多线程技术: 两个线程交替打印奇数和偶数
 * https://www.cnblogs.com/study-everyday/p/6292738.html
 * @Date: 2018年8月5日 下午5:35:37
 */
public class Main {
    public static void main(String[] args) {

        Num num = new Num();

        PrintOdd printOdd = new PrintOdd(num);
        PrintEven printEven = new PrintEven(num);

        Thread thread1 = new Thread(printOdd);
        Thread thread2 = new Thread(printEven);

        thread1.start();
        thread2.start();
    }
}
