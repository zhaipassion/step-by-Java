package book01.chapter02;

/**
 * @author Bob
 * @ClassName: JavaVMStackOOM
 * @Description: 创建线程导致内存溢出异常
 * @VM_args -Xss2M
 * @-Xss2M 虚拟机栈
 * @date 2015年2月3日 下午10:33:35
 */
public class JavaVMStackOOM {
    private void dontStop() {
        while (true) {
        }
    }

    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }
}

// 这是跑了很久才出来的异常，而且跑程序过程中计算机可能卡顿出现假死
//Demo result:

//Exception in thread "main" java.lang.OutOfMemoryError: unable to create new native thread
//at java.lang.Thread.start0(Native Method)
//at java.lang.Thread.start(Thread.java:713)
//at book01.chapter02.JavaVMStackOOM.stackLeakByThread(JavaVMStackOOM.java:25)
//at book01.chapter02.JavaVMStackOOM.main(JavaVMStackOOM.java:31)



