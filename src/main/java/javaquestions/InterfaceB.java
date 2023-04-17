package javaquestions;

public interface InterfaceB {

	void test();

	default void hi() { System.out.println("B"); }
}
