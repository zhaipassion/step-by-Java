package com.bob.io.io01_introduction;

import java.io.FileWriter;
import java.io.IOException;

/**
 * the encode table developing process:
 * <p>
 * English:        ASCII  --> English
 * Chinese :       gb2312 --> GBK --> 18030
 * international : Union code --> UTF-8
 */

/**
 * --------two kinds of steam:
 *
 * ----------------byte stream: InputStream && OutputSteam
 *
 * all the information stored in the computer is by byte, and there are a lot of
 * encode tables can be followed by. But if you stored the Chinese with the
 * encode table "GBK", but read with a another encode table "UTF-8", there would
 * be got wrong.
 *
 *
 * ----------------character stream: Reader && Writer
 *
 * can declare the encode table just as read the information, it becomes more
 * confident.
 *
 *
 * --------Tips:
 *
 * Character stream is based on byte stream, not every kind of informations can
 * be stored as character stream, such as picture, only can be stored as byte
 * stream.
 */
public class Introduction {
    public static void main(String[] args) {
        try {
            // create the file to write the information
            FileWriter fw = new FileWriter(System.getProperty("user.dir")
                    + "/src/javaThings/io_Demo/io01_introduction/TestFile.txt");
            // add info, if the file has other info, then it will be overwrite
            fw.write("Hello ");
            // append info
            fw.append("world! ");
            // write the info from RAM to file
            fw.flush();
            // the "Enter" type:  \r\n
            fw.append("\r\nI'm haizhu!");
            // before this close() method,flush operation will execute automatically.
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}