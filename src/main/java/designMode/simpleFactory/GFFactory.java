package designMode.simpleFactory;

//神灯为我们创建女朋友的工厂
public class GFFactory {
	public static BaseGF createGF(GFType gFType) {
		switch (gFType) {
		case SI_CHUAN:
			return new SiChuanGF();
		case SHAN_DONG:
		default:
			return new ShanDongGF();
		}
	}
}
