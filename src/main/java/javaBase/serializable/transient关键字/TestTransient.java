package javaBase.serializable.transient关键字;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;


/**
 * @Description : http://www.cnblogs.com/liuling/archive/2013/05/05/transient.html
 * Java transient关键字使用小结
 * @Date: 2017年7月28日 下午4:50:46
 */
public class TestTransient implements Serializable {

    private static final long serialVersionUID = -5836283489677344417L;
    private transient int classValue = 10;
    private transient Date date = new Date();
    private transient static int staticValue = 10;

    public static void main(String[] args) throws Exception {
        TestTransient m = new TestTransient();
        m.classValue = 11;
        TestTransient.staticValue = 11;
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(
                new File("0xjh000")));
        out.writeObject(m);

        out.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream(
                new File("0xjh000")));
        TestTransient m1 = (TestTransient) in.readObject();
        in.close();

        System.out.println(m1.classValue);
        System.out.println(m1.staticValue);
        System.out.println((m1.date == null ? "date is null"
                : "date is not null"));
    }

}
