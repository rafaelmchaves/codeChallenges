package javaquestions;

public interface InterfaceA {

	void test(String teste);

	default void hi() { System.out.println("A"); }
}
