package javaBase.file;

import java.io.File;
import java.io.FilenameFilter;


/**
 * @Description : https://blog.csdn.net/qq_26787115/article/details/51866130
 * @Date: 2018年5月12日 下午3:28:36
 */
public class HelloJJAVA {
	/*public static void main(String[] args) {
        // 创建File对象,不存在也没事
        File file = new File("a.txt");
        //目录 文件名
        File file2 = new File("E:\\isblog\\Demo","a.txt");

        //封装什么就打印什么
        System.out.println(file);
    }*/
	/*public static void main(String[] args) {
        // 创建File对象
        File file = new File("a.txt");

        try {
            //创建  在自己项目的路径下
            file.createNewFile();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }*/
	
	//判断文件是否存在且不存在就去创建文件了
	/*public static void main(String[] args) {
        // 创建File对象  在自己项目的路径下
        File file = new File("a.txt");
        // 判断是否存在，不存在则创建
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }*/
	
	/*public static void main(String[] args) {
        // 创建File对象  在自己项目的路径下  mkdir只能创建一级目录，而mkdirs可以创建多级文件夹目录
        File file = new File("liuguilin");
        file.mkdir();
    }*/
	
	/*public static void main(String[] args) {
        File file = new File("liuguilin");
        //是否为文件
        System.out.println(file.isFile());
        //是否为文件夹
        System.out.println(file.isDirectory());
    }*/

	/*public static void main(String[] args) {
        File file = new File("liuguilin");
        // 判断文件是否存在
        if (file.exists()) {
            // 再去判断文件还是文件夹
            if (file.isFile()) {
                System.out.println("文件");
            } else if (file.isDirectory()) {
                System.out.println("文件夹");
            }
        } else {
            try {
                file.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }*/
	
	/*public static void main(String[] args) {
        File file = new File("liuguilin.txt");
        File file2 = new File("haha.txt");
        // 项目路径下+文件名
        System.out.println("路径：" + file.getPath());
        // 全路径
        System.out.println("绝对路径：" + file.getAbsolutePath());
        // 最后一次修改时间
        System.out.println("时间：" + file.lastModified());
        // 绝对路径中的文件父目录,如果是相对路径，返回的为空
        System.out.println("父目录：" + file.getParent());
        // 把内容拷贝到另一个文本中并且删除自身
        System.out.println(file.renameTo(file2));
    }
	*/
	
	/* public static void main(String[] args) {
	        File[] listRoots = File.listRoots();
	        for (File f : listRoots) {
	            // 打印磁盘目录
	            System.out.println(f);
	        }
	  }*/
	
/*	 public static void main(String[] args) {
		    //必须封装了一个目录，该目录还必须存在
		        File f = new File("c:\\");
		        String[] list = f.list();
		        for (String fi : list) {
		            System.out.println(fi);
		        }
		    }
	*/
	
	public static void main(String[] args) {
        File f = new File("e:\\");
        String[] list = f.list(new FilenameFilter() {
            // 过滤
            @Override
            public boolean accept(File dir, String name) {
                // 只返回txt后缀的文件
                return name.endsWith(".txt");
            }
        });
        for (String fi : list) {
            // 过滤
            System.out.println(fi);
        }
    }
	
	
	
	
}
