package book01.chapter02;

/**
 * @ClassName: JavaVMStackSOF
 * @Description: 虚拟机栈和本地方法栈
 * @VM_args 
 * -Xss128k -Xoss128k
 * @-Xss128k 虚拟机栈
 * @-Xoss128k 本地方法栈(这个参数好像不起作用，配置和不配置一样的效果，是因为不区分虚拟机栈和本地方法栈么？)
 * @date 2015年2月3日 下午9:04:00
 */
public class JavaVMStackSOF {
	private int stackLength = 1;

	public void stackLeak() {
		stackLength++;
		stackLeak();
		System.out.println("+1");
	}
	public static void main(String[] args) {
		JavaVMStackSOF oom = new JavaVMStackSOF();
		try {
			oom.stackLeak();
		} catch (Throwable e) {
			System.out.println("Stack Length: " + oom.stackLength);
			e.printStackTrace();
		}
	}
}


// Demo result:

//Stack Length: 995
//java.lang.StackOverflowError
//	at book01.chapter02.JavaVMStackSOF.stackLeak(JavaVMStackSOF.java:13)
//	at book01.chapter02.JavaVMStackSOF.stackLeak(JavaVMStackSOF.java:14)
	

