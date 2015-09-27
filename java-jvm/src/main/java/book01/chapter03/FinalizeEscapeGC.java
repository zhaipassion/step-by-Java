package book01.chapter03;

/**
 * @author Bob
 * @ClassName: FinalizeEscapeGC
 * @Description: 一次对象自我拯救的演示
 * @date 2015年2月4日 下午7:43:18
 */
public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive() {
        System.out.println("Yes, I am still alive :)");
    }

    // 每个对象都默认继承Object类，在Object类中有finalize()方法
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Finalize method executed!");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws Throwable {
        SAVE_HOOK = new FinalizeEscapeGC();
        // 对象第一次成功拯救自己
        SAVE_HOOK = null;
        System.gc();
        // 因为finalize()方法优先级很低，所以暂停0.5秒进行等待
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("No, I am dead! ：(");
        }
        // 下面这段代码与上面完全相同，但是这次自救却失败了。
        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("No, I am dead! ：(");
        }
    }
}

// 第二次自救失败的原因：
// 这是因为任何一个对象的finalize()方法只会被系统自动调用一次，
// 如果对象面临下一次回收，它的finalize()方法不会被再次执行，
// 因此第二段代码的自救行动失败了。

// 特别说明：
// 此范例只是让你了解finalize()方法，及对象回收机制，并不鼓励在
// 实际开发中显示调用finalize()方法。


