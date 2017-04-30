package designMode.factoryAndImplement;

/**
 * @Description : http://github.thinkingbar.com/thinking_in_java_chapter09/
 * @Date: 2017年4月30日 下午5:24:24
 * 
 * 使用了工厂模式，我们现在有一个产品的模具，可以生产2种型号，分配给两家工厂生产。
 * 现在我想要实现的功能是：我指定一家工厂，你就自动给我出产品。 所以在工厂和产品之 
 * 间加了一层GetProduct接口，这样消费者只要指定工厂就可以了。
 * 
 */
public class Factory2  implements GetProduct {
	public ProductModel getProduct() {
		return new Product2();
	}
}
