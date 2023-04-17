package javaquestions;

public class ClassC implements InterfaceB, InterfaceA {

	@Override
	public void test() {
		System.out.println("teste");
	}

	@Override
	public void test(String teste) {

	}

	@Override
	public void hi() {
		InterfaceA.super.hi();
	}
}
