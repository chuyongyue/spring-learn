package com.peerfintech.datastructure.adjtable;

// 弧节点
public class ArcNode {
    int adjvex;    // 该弧所指向的顶点的位置
    ArcNode nextarc; // 指向下一个弧
    int val;   // 弧的信息，正常是一个类，本次使用int代替
}
