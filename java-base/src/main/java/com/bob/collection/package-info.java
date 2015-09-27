/**
 * java.util.Collection:集合
 * |- ArrayList：     数组结构             - 查询快，增删慢；线程不同步，效率高；默认初始化10个元素，超过时延长50%
 * |- List - |- LinkedList：  链表数据结构     - 查询慢，增删快
 * |         |- Vector：              数组结构             - 被ArrayList取代了；同步，数据安全；默认也是10个元素，超过时延长100%
 * Collection-|
 * |
 * |- Set  - |- HashSet：           哈希表（结构） - 存储的时候，先比较哈希值（hashCode），不相同直接存储，相同的话再进行equals比较，并顺延存储；按照hashCode排序
 * |- TreeSet：           二叉树结构         - 按照字母排序
 * <p>
 * <p>
 * <p>
 * |- HashTable：     哈希表结构     - JDK1.0，线程同步，不可以为null键和null值
 * Map    -|- HashMap：           哈希表结构     - 非同步，允许null
 * |- TreeMap：          二叉树结构      - 可以用于给map集合中的键值排序
 * <p>
 * <p>
 * List:有序，可以重复
 * Set:无序，不可重复
 * <p>
 * java.util.Iterator:迭代器
 * 用于取出集合中的元素，只有三个重要的方法：hasNext(),next(),iterator()
 *
 * @author Bob
 */
package com.bob.collection;