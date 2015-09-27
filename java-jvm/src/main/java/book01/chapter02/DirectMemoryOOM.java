package book01.chapter02;

//import java.lang.reflect.Field;

/**
 * VM Args：-Xmx20M -XX:MaxDirectMemorySize=10M
 * 
 * @author zzm
 */
public class DirectMemoryOOM {

    // private static final into _1MB = 1024 * 1024;

    public static void main(String[] args) throws Exception {
        // FIELD UNSAFEFIELD = UNSAFE.CLASS.GETDECLAREDFIELDS()[0];
        // UNSAFEFIELD.SETACCESSIBLE(TRUE);
        // UNSAFE UNSAFE = (UNSAFE) UNSAFEFIELD.GET(NULL);
        // WHILE (TRUE) {
        // UNSAFE.ALLOCATEMEMORY(_1MB);
        // }
    }
}
