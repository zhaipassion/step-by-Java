package book01.chapter03;

/**
 * @author Bob
 * @ClassName: ReferenceCountingGC
 * @Description: 验证java是不是使用引用技术算法进行数据回收：testGC()方法执行后，objA和objB会不会被GC呢？
 * @date 2015年2月4日 下午7:27:09
 */
public class ReferenceCountingGC {

    public Object instance = null;

    private static final int _1MB = 1024 * 1024;

    /**
     * 这个成员属性的唯一意义就是占点内存，以便在能在GC日志中看清楚是否有回收过
     */
    @SuppressWarnings("unused")
    private byte[] bigSize = new byte[2 * _1MB];

    public static void testGC() {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;

        // 假设在这行发生GC，objA和objB是否能被回收？
        System.gc();
    }

}
