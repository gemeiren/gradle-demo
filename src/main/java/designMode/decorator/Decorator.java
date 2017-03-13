package designMode.decorator;


public abstract class Decorator extends Face {
	protected Face face;

	public void setFace(Face face) {
		this.face = face;
	}

	@Override
	public void show() {
		if (face != null) {
			face.show();
		}
	}
}
