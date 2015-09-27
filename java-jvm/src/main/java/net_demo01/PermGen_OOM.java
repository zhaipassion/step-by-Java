package net_demo01;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PermGen_OOM {
    public static void main(String... args) {
        List<String> list = new ArrayList<String>();
        while (true) {
            String intern = UUID.randomUUID().toString().intern();
            list.add(intern);
        }
    }
}


// 运行结果：
// 没有成功呢，期望结果是：
//Exception in thread "main" java.lang.OutOfMemoryError: PermGen space
//at java.lang.String.intern(Native Method)
//at OOMTest.main(OOMTest.java:8)

// 实际结果：

// 条件：-verbose:gc -Xmn5M -Xms10M -Xmx10M -XX:MaxPermSize=128K -XX:+PrintGC
// 结果：
//[Full GC 10127K->10124K(11264K), 0.0399160 secs]
//[Full GC 10127K->10124K(11264K), 0.0399793 secs]
//Exception in thread "main" [Full GC 10126K->651K(9728K), 0.0289012 secs]
//java.lang.OutOfMemoryError: GC overhead limit exceeded
//	at java.util.Arrays.copyOfRange(Arrays.java:2694)
//	at java.lang.String.<init>(String.java:203)
//	at java.lang.Long.toUnsignedString(Long.java:250)


// 条件：-verbose:gc -Xmn5M -Xms10M -Xmx10M -XX:MaxPermSize=1M -XX:+PrintGC
// 结果：
//[Full GC 10125K->10122K(11264K), 0.0540649 secs]
//[Full GC 10125K->10122K(11264K), 0.0519387 secs]
//[Full GC 10124K->630K(9216K), 0.0175892 secs]
//Exception in thread "main" java.lang.OutOfMemoryError: GC overhead limit exceeded
//	at java.lang.Long.toUnsignedString(Long.java:242)