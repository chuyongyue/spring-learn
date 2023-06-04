package com.peerfintech.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * Author: cy
 * Date: 2023/4/14
 * Time: 23:05
 * Description:测试用例工具，从文件中读取测试用例，基于行读取
 */
public class UseCaseUtil {
    public static InputStream getInput(String fileName) {
        try {
            URL url = UseCaseUtil.class.getClassLoader().getResource("usecase");
            if (url != null) {
                return new FileInputStream(url.getPath() + "/" + fileName);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return System.in;
    }
}
