package com.peerfintech.datastructure.adjorthogonallist;

/**
 * Created with IntelliJ IDEA.
 * Author: cy
 * Date: 2023/4/14
 * Time: 22:08
 * Description 弧节点
 */
public class ArcBox {
    // 该弧的尾顶点的位置
    int tailvex;
    // 该弧的头顶点的位置
    int headvex;
    // 弧头相同的弧的链域
    ArcBox hlinx;
    // 弧尾相同的弧的链域
    ArcBox tlinx;
    // 弧信息
    int value;
}
