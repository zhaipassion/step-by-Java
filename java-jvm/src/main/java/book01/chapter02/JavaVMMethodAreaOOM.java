package book01.chapter02;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @author Bob
 * @ClassName: JavaVMMethodAreaOOM
 * @Description: asd
 * @VM_args -XX:PermSize=50M -XX:MaxPermSize=50M
 * @-XX:PermSize=10M 方法区最小内存
 * @-XX:MaxPermSize=10M 方法区最大内存
 * @date 2015年2月3日 下午11:46:53
 */
public class JavaVMMethodAreaOOM {
    public static void main(String[] args) {
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                public Object intercept(Object obj, Method method,
                                        Object[] args, MethodProxy proxy) throws Throwable {
                    return proxy.invokeSuper(obj, args);
                }
            });
            enhancer.create();
        }
    }

    static class OOMObject {
    }
}

/**
 * 运行结果：
 */

// 第一次结果：

//Exception in thread "main" 
//Exception: java.lang.OutOfMemoryError thrown from the UncaughtExceptionHandler in thread "main"


// 第四次运行结果，而且只出现了一次

//Exception in thread "main" net.sf.cglib.core.CodeGenerationException: java.lang.reflect.InvocationTargetException-->null
//at net.sf.cglib.core.AbstractClassGenerator.create(AbstractClassGenerator.java:237)
//at net.sf.cglib.proxy.Enhancer.createHelper(Enhancer.java:377)
//at net.sf.cglib.proxy.Enhancer.create(Enhancer.java:285)
//at book01.chapter02.JavaVMMethodAreaOOM.main(JavaVMMethodAreaOOM.java:32)
//Caused by: java.lang.reflect.InvocationTargetException
//at sun.reflect.GeneratedMethodAccessor1.invoke(Unknown Source)
//at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
//at java.lang.reflect.Method.invoke(Method.java:606)
//at net.sf.cglib.core.ReflectUtils.defineClass(ReflectUtils.java:384)
//at net.sf.cglib.core.AbstractClassGenerator.create(AbstractClassGenerator.java:219)
//... 3 more
//Caused by: java.lang.OutOfMemoryError: PermGen space
//at java.lang.ClassLoader.defineClass1(Native Method)
//at java.lang.ClassLoader.defineClass(ClassLoader.java:800)
//... 8 more

