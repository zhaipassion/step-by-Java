package book01.chapter02;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName HeapOOM
 * @Description 堆内存溢出范例 
 * @VM_args 
 * -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * @-Xms20m 最小堆内存
 * @-Xmx20m 最大对内存
 * @-XX +HeapDumpOnOutOfMemoryError 拍快照？
 * @author HZ 
 * @date 2015年2月3日 下午9:04:31
 */
public class HeapOOM {
	static class OOMObject{
	}
	public static void main(String[] args) {
		List<OOMObject> list = new ArrayList<OOMObject>();
		while(true){
			list.add(new OOMObject());
		}
	}
}

// This demo result is:

//java.lang.OutOfMemoryError: Java heap space
//Dumping heap to java_pid21824.hprof ...
//Heap dump file created [27861852 bytes in 0.203 secs]
//Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
//	at java.util.Arrays.copyOf(Arrays.java:2245)
//	at java.util.Arrays.copyOf(Arrays.java:2219)
//	at java.util.ArrayList.grow(ArrayList.java:242)
//	at java.util.ArrayList.ensureExplicitCapacity(ArrayList.java:216)
//	at java.util.ArrayList.ensureCapacityInternal(ArrayList.java:208)
//	at java.util.ArrayList.add(ArrayList.java:440)
//	at book01.chapter02.HeapOOM.main(HeapOOM.java:16)