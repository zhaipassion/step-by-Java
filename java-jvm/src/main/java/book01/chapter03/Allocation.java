package book01.chapter03;

/**
 * @ClassName: Allocation 
 * @Description: VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * @author HZ 
 * @date 2015年2月4日 下午9:00:50
 */
public class Allocation {

	private static final int _1MB = 1024 * 1024;

	@SuppressWarnings("unused")
	public static void testAllocation() {
		byte[] allocation1, allocation2, allocation3, allocation4;
		allocation1 = new byte[2 * _1MB];
		allocation2 = new byte[2 * _1MB];
		allocation3 = new byte[2 * _1MB];
		allocation4 = new byte[4 * _1MB]; // 出现一次Minor GC
	}

	public static void main(String[] args) {
		testAllocation();
	}
}


// Demo result:

//Heap
//PSYoungGen      total 9216K, used 6980K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
// eden space 8192K, 85% used [0x00000000ff600000,0x00000000ffcd11c8,0x00000000ffe00000)
// from space 1024K, 0% used [0x00000000fff00000,0x00000000fff00000,0x0000000100000000)
// to   space 1024K, 0% used [0x00000000ffe00000,0x00000000ffe00000,0x00000000fff00000)
//ParOldGen       total 10240K, used 4096K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
// object space 10240K, 40% used [0x00000000fec00000,0x00000000ff000010,0x00000000ff600000)
//PSPermGen       total 21504K, used 2505K [0x00000000f9a00000, 0x00000000faf00000, 0x00000000fec00000)
// object space 21504K, 11% used [0x00000000f9a00000,0x00000000f9c727a8,0x00000000faf00000)
