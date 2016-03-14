package com.bob.excel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 将<url>http://www.stats.gov.cn/tjsj/tjbz/xzqhdm/</url>的行政区域数据，导入到数据库相关表中
 * 1、先将数据拷贝到excel文件中
 * 2、将文件中的数据写入数据库
 *
 * @author Bob
 * @created 2015年8月27日 上午11:31:25
 */
public class OrgReadAndWrite {

    public static void main(String[] args) {
        String path = Class.class.getClass().getResource("/").getPath() + "com/bob/excel/org.xlsx";
        readXml(path);
    }

    public static void readXml(String fileName) {
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
            String srcProvince = "";
            String srcProvinceName = "";
            String srcProvinceUUID = "";
            Integer srcProvinceCode = 0;
            String srcCity = "";
            String srcCityName = "";
            String srcCityUUID = "";
            Integer srcCityCode = 0;
            String srcArea = "";
            String srcAreaName = "";
            String srcAreaUUID = "";
            Integer srcAreaCode = 0;

            String pId = "";
            String id = "";
            String code = "";
            String fullName = "";

            getCon();
            insert("0134419BD3444C2185A9B3E0878D9026", null, "1", "中国", "中国");
            while (rows.hasNext()) {
                Row row = rows.next(); // 获得行数据
                Iterator<Cell> cells = row.cellIterator(); // 获得第一行的迭代器
                String rootId = "0134419BD3444C2185A9B3E0878D9026";
                String rootName = "中国";
                String rootCode = "1";

                Cell cell = cells.next();
                String value = ReadExcel001.getCellValue(cell);
                // 名称
                String name = value.substring(6).replace(" ", "").replace("　", "").trim();
                // 编码
                String zipCode = value.substring(0, 6);
                // 省
                String province = zipCode.substring(0, 2);
                // 市
                String city = zipCode.substring(2, 4);
                // 县
                String area = zipCode.substring(4, 6);

                if (!province.equals(srcProvince)) {
                    srcProvinceUUID = UUIDUtil();
                    srcProvinceName = name;
                    srcProvinceCode += 1;
                    srcCityCode = 0;
                    srcAreaCode = 0;
                    srcProvince = province;

                    pId = rootId;
                    id = srcProvinceUUID;
                    code = rootCode + "." + srcProvinceCode;
                    fullName = rootName + "->" + srcProvinceName;

                } else if (!city.equals(srcCity)) {
                    if (name.equals("县")) {
                        srcCity = city;
                        continue;
                    }
                    if (name.equals("市辖区") && area.equals("01")) {
                        continue;
                    }
                    if (name.equals("市辖区") && city.equals("01") && area.equals("00")) {
                        name = srcProvinceName;
                    }
                    srcCityUUID = UUIDUtil();
                    srcCityName = name;
                    srcCityCode += 1;
                    srcAreaCode = 0;
                    srcCity = city;

                    pId = srcProvinceUUID;
                    id = srcCityUUID;
                    code = rootCode + "." + srcProvinceCode + "." + srcCityCode;
                    fullName = rootName + "->" + srcProvinceName + "->" + srcCityName;

                } else if (!area.equals(srcArea)) {
                    srcAreaUUID = UUIDUtil();
                    srcAreaName = name;
                    srcAreaCode += 1;
                    srcArea = area;

                    pId = srcCityUUID;
                    id = srcAreaUUID;
                    code = rootCode + "." + srcProvinceCode + "." + srcCityCode + "." + srcAreaCode;
                    fullName = rootName + "->" + srcProvinceName + "->" + srcCityName + "->" + srcAreaName;
                }

                System.out.println(pId + "->" + id + " => " + code + "-" + fullName);
                insert(id, pId, code, name, fullName);
            }
            closeCon();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String UUIDUtil() {
        String uuid = UUID.randomUUID().toString().replace("-", "").toUpperCase();
        return uuid;
    }

    public static final String DBDRIVER = "com.mysql.jdbc.Driver";
    // 连接地址是由各个数据库生产商单独提供的，所以需要单独记住
    public static final String DBURL = "jdbc:mysql://localhost:3306/nMall";
    // 连接数据库的用户名
    public static final String DBUSER = "nMall";
    // 连接数据库的密码
    public static final String DBPASS = "nMall";

    static Connection con = null; // 表示数据库的连接对象
    static PreparedStatement pstmt = null; // 表示数据库更新操作
    static String sql = "INSERT INTO nmall.organization" + "(id,parent_id,code,name,full_name,create_time,create_user)"
            + "VALUES(?,?,?,?,?,?,?)";

    public static void getCon() {
        try {
            Class.forName(DBDRIVER); // 1、使用CLASS 类加载驱动程序
            con = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
            pstmt = con.prepareStatement(sql);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void insert(String id, String pId, String code, String name, String fullName) {
        try {
            pstmt.setString(1, id);
            pstmt.setString(2, pId);
            pstmt.setString(3, code);
            pstmt.setString(4, name);
            pstmt.setString(5, fullName);
            pstmt.setDate(6, new java.sql.Date(0));
            pstmt.setString(7, "AUTO");
            pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void closeCon() {
        try {
            pstmt.close();
            con.close(); // 4、关闭数据库
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}