package com.liXingHua.simpleDemo;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class SimpleXMLParseDemo {

    public static void main(String[] args) {
        String path = System.getProperty("user.dir");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(path + File.separator + "src" + File.separator + "main" + File.separator
                    + "java" + File.separator + "com" + File.separator + "liXingHua" + File.separator + "simpleDemo"
                    + File.separator + "xmlParseDemo.xml");
            NodeList nl = doc.getElementsByTagName("name");
            System.out.println("姓名：" + nl.item(0).getFirstChild().getNodeValue());
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
