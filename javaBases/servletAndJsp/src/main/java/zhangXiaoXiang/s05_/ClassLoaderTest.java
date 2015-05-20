package zhangXiaoXiang.s05_;

public class ClassLoaderTest {
	/**
	 * 各个类的不同类装载器
	 * 
	 * @param args
	 */
	@SuppressWarnings("restriction")
	public static void main(String[] args) {
		System.out.println("返回null的是由BootStrap来进行装载~");
		ClassLoader cl = System.class.getClassLoader();
		System.out.println(cl == null ? "null" : cl.getClass().getName());
		cl = javax.swing.Box.class.getClassLoader();
		System.out.println(cl == null ? "null" : cl.getClass().getName());
//		cl = sun.net.spi.nameservice.dns.DNSNameService.class.getClassLoader();
		System.out.println(cl == null ? "null" : cl.getClass().getName());
		cl = ClassLoaderTest.class.getClassLoader();
		System.out.println(cl == null ? "null" : cl.getClass().getName());
	}
}
