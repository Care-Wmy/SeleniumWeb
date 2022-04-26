package com.gzl.Imooc.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ProUtil {

    public Properties Pro;
    public ProUtil(String FilePath){
       Pro =  RedProperties(FilePath);
    }

    private Properties  RedProperties(String FilePath){
        //        运用Properties函数来读取配置文件
        Properties properties = new Properties();
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(FilePath);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            properties.load(bufferedInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public String GetPorperties(String key){
       String value;
       if (Pro.containsKey(key)){
           value = Pro.getProperty(key);
           return value;
       }else {
            return "";
       }
    }

    public int  GetLines(){
        return Pro.size();
    }

    public static void main(String[] args) {
        ProUtil proUtil = new ProUtil("D:\\Study\\JavaUi\\SeleniumWeb\\Imooc\\element.properties");
        System.out.println(proUtil.GetPorperties("username"));
        /**
         String user;
         //        运用Properties函数来读取配置文件
         Properties properties = new Properties();
         try {
         //      读取配置文件
         FileInputStream fileInputStream = new FileInputStream("D:\\Study\\JavaUi\\SeleniumWeb\\Imooc\\element.properties");
         BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
         try {
         //              加载配置文件load
         properties.load(bufferedInputStream);
         //              获取配置文件的内容getProperty
         user = properties.getProperty("username");
         System.out.println(user);
         } catch (IOException e) {
         e.printStackTrace();
         }
         } catch (FileNotFoundException e) {
         e.printStackTrace();
         }


         }
         **/
    }

}
