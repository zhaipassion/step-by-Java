package book01.chapter02;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bob
 * @ClassName: RuntimeConstantPoolOOM
 * @Description: 运行时常量池导致的内存溢出异常(这是方法去溢出的一种情况)
 * @VM_args -XX:PermSize=10M -XX:MaxPermSize=10M
 * @-XX:PermSize=10M 方法区最小内存
 * @-XX:MaxPermSize=10M 方法区最大内存
 * @date 2015年2月3日 下午10:52:51
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        // 使用list保持着常量池引用，避免 Full GC 回收常量池行为
        List<String> list = new ArrayList<String>();
        // 10MB 的 PermSize 在 Integer 范围内足够产生 OOM 了
        int i = 1;
        while (true) {
            // intern() 是一个本地方法，如果常量池中包含一个等于此String对象的字符串
            // 则返回代表池中这个字符串的String对象；否则，将此String子渡船添加到常量池，
            // 并返回此String对象的引用
            list.add(String.valueOf(i++).intern());
            list.add(String.valueOf(i + 'a').intern());
            list.add(String.valueOf(i + 'b').intern());
            list.add(String.valueOf(i + 'c').intern());
            list.add(String.valueOf(i + 'd').intern());
            list.add(String.valueOf(i + 'e').intern());
            list.add(String.valueOf(i + 'f').intern());
            list.add(String.valueOf(i + 'g').intern());
            list.add(String.valueOf(i + 'h').intern());
            list.add(String.valueOf(i + 'i').intern());
            list.add(String.valueOf(i + 'j').intern());
            list.add(String.valueOf(i + 'k').intern());
            list.add(String.valueOf(i + 'l').intern());
            System.out.println(" value: " + i);
        }
    }
}

// 没有成功呢，跑了两次都是Java heap space，而不是期望的PermGen space

// Demo result:

//value: 8087431
//value: 8087432
//Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
//	at java.util.Arrays.copyOf(Arrays.java:2245)
//	at java.util.Arrays.copyOf(Arrays.java:2219)

