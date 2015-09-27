package net_demo01;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: OOMH_OOM 
 * @Description: 
 * @VM_args -verbose:gc -Xmn10M -Xms20M -Xmx20M -XX:+PrintGC
 * @
 * @author HZ 
 * @date 2015年2月5日 上午10:24:01
 */
public class Heap_OOM {

	public static void main(String... args) {
		List<byte[]> buffer = new ArrayList<byte[]>();
		buffer.add(new byte[10 * 1024 * 1024]);
	}

}

// 运行结果：

//[GC 7350K->5209K(19456K), 0.0143657 secs]
//[GC 13401K->10742K(19456K), 0.0151495 secs]
//[Full GC 10742K->10680K(19456K), 0.3546932 secs]
//[Full GC 18506K->16298K(19456K), 0.3966960 secs]
//[Full GC 16298K->16287K(19456K), 0.3015515 secs]
//Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
//	at java.util.Arrays.copyOf(Arrays.java:2245)



