package com.bob.properties.pro02_PropertiesFile;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

/**
 * @author Bob
 * @ClassName: PptF01_ReadInfoFromFile
 * @Description: property文件测试
 * @date 2014年1月7日 下午10:11:08
 * @Tips 属性文件中可以使用“空格”、“冒号”、“等号” 连接 key 和 value，如果都有，按照最前面的作为分隔符
 */
public class PF01_ReadInfoFromFile {
    public static void main(String[] args) {
        String filePath = System.getProperty("user.dir")
                + "/src/main/java/com/haizhu/properties_Demo/pro02_PropertiesFile/NumberAndName.properties";

        myReadPropertiesMethod(filePath);
        System.out
                .println("\n\n------------------------------分割线---------------------------\n\n");
        LoadOfPropertiesMethod(filePath);
        System.out
                .println("\n\n------------------------------分割线---------------------------\n\n");
        readStringPropertyInfo();
    }

    public static void LoadOfPropertiesMethod(String filePath) {
        FileReader fr = null;
        Properties ppt = new Properties();
        try {
            fr = new FileReader(filePath);
            /**
             * Load(FileInputStream fis) is also well.
             */
            ppt.load(fr);
            System.out.println("直接打印：");
            System.out.println(ppt.toString() + "\n");
            System.out.println("list()方法：");
            ppt.list(System.out);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void myReadPropertiesMethod(String filePath) {
        FileReader fr = null;
        BufferedReader br = null;
        Properties ppt = new Properties();
        try {
            fr = new FileReader(filePath);
            br = new BufferedReader(fr);
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] keyAndValue = line.split("=");
                ppt.setProperty(keyAndValue[0], keyAndValue[1]);
            }
            System.out.println("直接打印：");
            System.out.println(ppt.toString() + "\n");
            System.out.println("list()方法：");
            ppt.list(System.out);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void readStringPropertyInfo() {
        String proInfo = "性别=性别:男=男性,女=女性\n民族=民族:汉=汉族";
        HashMap<String, String> domainMap = new HashMap<String, String>();
        HashMap<String, HashMap<String, String>> dictMap = new HashMap<String, HashMap<String, String>>();
        Properties ppt = new Properties();
        BufferedReader bf;
        try {
            bf = new BufferedReader(new InputStreamReader(
                    new ByteArrayInputStream(proInfo.getBytes()), "utf-8"));
            ppt.load(bf);
            for (Enumeration<?> names = ppt.propertyNames(); names
                    .hasMoreElements(); ) {
                String name = names.nextElement().toString();
                String val = ppt.getProperty(name);
                String[] keyAndVal = val.split(":");
                domainMap.put(name, keyAndVal[0]);
                String[] valMaps = keyAndVal[1].split(",");
                if (dictMap.get(name) == null) {
                    dictMap.put(name, new HashMap<String, String>());
                }
                HashMap<String, String> tempMap = dictMap.get(name);
                for (int i = 0; i < valMaps.length; i++) {
                    String[] valMap = valMaps[i].split("=");
                    tempMap.put(valMap[0], valMap[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
