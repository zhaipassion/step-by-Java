package com.bob.excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class WorldRead {
  public static void main(String[] args) {
    readXml("Z:/world.xlsx");
  }

  public static void readXml(String fileName) {
    Map<String, String> worldMap = new LinkedHashMap<>();
    boolean isE2007 = false; // 判断是否是excel2007格式
    if (fileName.endsWith("xlsx"))
      isE2007 = true;
    try {
      InputStream input = new FileInputStream(fileName); // 建立输入流
      Workbook wb = null;
      // 根据文件格式(2003或者2007)来初始化
      if (isE2007)
        wb = new XSSFWorkbook(input);
      else
        wb = new HSSFWorkbook(input);
      Sheet sheet = wb.getSheetAt(0); // 获得第一个表单
      Iterator<Row> rows = sheet.rowIterator(); // 获得第一个表单的迭代器
      while (rows.hasNext()) {
        Row row = rows.next(); // 获得行数据
        Iterator<Cell> cells = row.cellIterator(); // 获得第一行的迭代器
        int i = 1;
        while (cells.hasNext()) {
          Cell cell = cells.next();
          if (i == 2) {
            String value = ReadExcel001.getCellValue(cell);
            String world = value.trim();
            worldMap.put(world, world);
          }
          i++;
        }
      }
      String totalAddHead = "首字母不同：";
      String totalAddFoot = "尾字母不同：";
      String totalAddMiddle = "中间多字母：";
      String totalAddMidDif = "中间字母不同：";
      for (String world : worldMap.keySet()) {
        for (String check : worldMap.keySet()) {
          if (world.length() == (check.length() - 1)) {
            String subHead = check.substring(1, check.length());
            if (world.equals(subHead)) {
              totalAddHead += (" - " + check);
            }
            String subFoot = check.substring(0, check.length() - 1);
            if (world.equals(subFoot)) {
              totalAddFoot += (" - " + check);
            }
            int len = check.length();
            if (len > 2) {
              for (int i = 0; i < len - 2; i++) {
                String subCheck = check.substring(0, i + 1) + check.substring(i + 2, len);
                if (world.equals(subCheck)) {
                  totalAddMiddle += (" - " + check);
                }
              }
            }
          }
          if (world.length() == check.length() && !world.equals(check)) {
            int len = check.length();
            for (int i = 0; i < len - 2; i++) {
              String subWorld = world.substring(0, i + 1) + world.substring(i + 2, len);
              String subCheck = check.substring(0, i + 1) + check.substring(i + 2, len);
              if (subWorld.equals(subCheck)) {
                totalAddMidDif += (" - " + check);
              }
            }
          }
        }
        if (!totalAddHead.equals("首字母不同：")
                || !totalAddFoot.equals("尾字母不同：")
                || !totalAddMiddle.equals("中间多字母：")
                || !totalAddMidDif.equals("中间字母不同：")) {
          System.out.println(world);
        }
        if (!totalAddHead.equals("首字母不同：")) {
          System.out.println(totalAddHead);
          totalAddHead = "首字母不同：";
        }
        if (!totalAddFoot.equals("尾字母不同：")) {
          System.out.println(totalAddFoot);
          totalAddFoot = "尾字母不同：";
        }
        if (!totalAddMiddle.equals("中间多字母：")) {
          System.out.println(totalAddMiddle);
          totalAddMiddle = "中间多字母：";
        }
        if (!totalAddMidDif.equals("中间字母不同：")) {
          System.out.println(totalAddMidDif);
          totalAddMidDif = "中间字母不同：";
        }
      }
      System.out.println(worldMap.size());
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }
}




