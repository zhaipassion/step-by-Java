/**
 * 参考毕向东视频：
 * 此类不是IO的子类，直接继承自Object，但是IO的成员，因为它具备读和写功能，
 * 内部封装了一个数据，通过指针对数组中的元素操作。可以通过getFilePointer
 * 获取指针位置，同时可以通过seek设定指针的位置。此类之所以能够完成读写的功能，
 * 是因为内部封装了字节输出流和字节输出流。
 * 通过构造函数可以看出，此类只能操作文件，并且只有四种模式："r","rw","rws","rwd"
 *
 * @author Bob
 */
/**
 * @author Bob
 *
 */
package com.bob.io.io09_RandomAccessFile;