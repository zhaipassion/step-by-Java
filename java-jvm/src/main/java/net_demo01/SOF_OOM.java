package net_demo01;

/**
 * @author HZ
 * @ClassName: SOF_OOM
 * @Description: 栈溢出(StackOverflowError)，发生在方法区
 * @date 2015年2月5日 上午10:15:50
 */
public class SOF_OOM {
    // 无限递归调用
    public void stackOverFlowMethod() {
        stackOverFlowMethod();
    }

    public static void main(String... args) {
        SOF_OOM oom = new SOF_OOM();
        oom.stackOverFlowMethod();
    }
}

// Demo Result:

//Exception in thread "main" java.lang.StackOverflowError
//        at net_demo01.OOMTest.stackOverFlowMethod(OOMTest.java:6)



