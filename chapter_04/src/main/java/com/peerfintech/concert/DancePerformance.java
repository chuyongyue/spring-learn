package com.peerfintech.concert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Description
 * @Author cy
 * @Date 2023/1/4 16:13
 **/
public class DancePerformance implements Performance{
    @Override
    public void perform() throws IOException {
        System.out.println("dance performance");
        InputStream input = new FileInputStream("src/readme.txt");
        input.close(); // 关闭流
    }
}

