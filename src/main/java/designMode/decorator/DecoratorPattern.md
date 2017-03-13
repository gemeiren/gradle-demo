* 上次说到，有了妹子，并且过上了幸福的生活([找女朋友之简单工厂模式，工厂模式，抽象工厂模式
](http://www.jianshu.com/p/3f824a91d73b)).
* 今天我们就要出去逛街了(shopping是必不可少的么-_-)，可是她化妆画了好久还没好.
* 这时候我看到她的那些个瓶瓶罐罐，灵机一动.
* "诶，你在这化妆的流程倒让我想起了一种设计模式，要不要听听"
* "你给老子滚..."
* "听听么...装饰模式耶"在她怒目的注视下，我就开始BB了...

######  用代码来化妆就是: 
```
// 先来一个抽象的脸(piapia, "别抽脸...")
public abstract class Face {
      // 化妆不就是要展示出来么，那就show一个
      public abstract void show();
}

```
```
// 在来个女朋友类
public class GirlFriend extends Face {
      @Override
      public void show() {
            System.out.println("I am the yunnan girl.");
      }
}
```
```
// 这个类就是化妆品的抽象类(也就是装饰的抽象类)
public abstract class Decorator implements Face {
      protected Face face;

      public void setFace(Face face) {
            this.face = face;
      }

      @Override
      public void show() {
            // 对脸化妆，化完之后展示出来
            if (face != null) {
                  face.show();
            }
      }
}
```
```
// 粉底(忽略什么化妆品，什么顺序啥的...我也不懂)
public class FenDiDecorator extends Decorator {
      @Override
      public void show() {
            // 先执行父类的职责，要不之前的妆就白画了
            super.show();
            System.out.println("With fendi.");
      }
}
```
```
// 画眼线
public class YanXianDecorator extends Decorator {
      @Override
      public void show() {
            super.show();
            System.out.println("With BBShuang.");
      }
}
```
```
// 其他化妆品
public class OtherDecorator extends Decorator {
      @Override
      public void show() {
            super.show();
            System.out.println("With other huazhuangpin.");
      }
}
```
```
// 开始化妆
public class DecoratorMain {
      public static void main(String[] args) {
            Face girlFriendFace = new GirlFriend();
            Decorator fenDiFace = new FenDiDecorator();
            Decorator yanXianFace = new YanXianDecorator();
            Decorator otherFace = new OtherDecorator();
            
            // 给画粉底的类，设定一个Face
            fenDiFace.setFace(girlFriendFace);
            // 给画眼线的类，设定一个滑过粉底的Face
            yanXianFace.setFace(fenDiFace);
            otherFace.setFace(yanXianFace);
            // 都画完之后展示出来
            otherFace.show();
      }
}

// 化完妆是这样滴...
I am the yunnan girl.
With fendi.
With BBShuang.
With other huazhuangpin.
```
> 
装饰模式: 动态地给一个对象添加一些额外的职责，就能增加功能来说，装饰者模式比生成子类更为灵活.

![装饰模式类图.png](http://upload-images.jianshu.io/upload_images/590988-263f04a1301a11a3.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

* 我还在滔滔不绝的说着，只听到
* "哎呀，太墨迹了，不画了"
* 我: "别啊，你这还没画完啊，那还不如不画呢"
* "就这样，咋地"
* 我: "等会儿哦，亲..."

```
// 来个卸妆的装饰类
public class XieZhuangDecorator extends Decorator {
      @Override
      public void show() {
            super.show();
            System.out.println("Xie zhuang.");
      }
}
```
```
public class DecoratorMain {
      public static void main(String[] args) {
            Face girlFriend = new GirlFriend();
            Decorator fenDiFace = new FenDiDecorator();
            Decorator yanXianFace = new YanXianDecorator();
            Decorator otherFace = new OtherDecorator();
            
            fenDiFace.setFace(girlFriend);
            yanXianFace.setFace(fenDiFace);
            otherFace.setFace(yanXianFace);

            // 只需要在最后的步骤上，加上一个(装饰)就行了
            Decorator xieZhuangFace = new XieZhuangDecorator();
            xieZhuangFace.setFace(otherFace);
            xieZhuangFace.show();

      }
}

// 最后的状态是卸妆了，之前的代码一点没变. 
I am the yunnan girl.
With fendi.
With BBShuang.
With other huazhuangpin.
Xie zhuang.
```

* "你看，这个模式不错吧，想改就改"
* "更何况，还是素颜好看...嘿嘿嘿..."
* "诶诶诶，打人不打脸...-_-"

###### 就这样，我和我的云南妹子过着幸福的生活.

> 
写在最后: 欢迎大家提出问题或者意见，谢谢


