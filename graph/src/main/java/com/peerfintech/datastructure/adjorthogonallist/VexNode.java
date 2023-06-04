package com.peerfintech.datastructure.adjorthogonallist;

/**
 * Created with IntelliJ IDEA.
 * Author: cy
 * Date: 2023/4/14
 * Time: 22:14
 * Description: 顶点节点
 */
public class VexNode {
    // 顶点的值
    int data;
    // 指向该顶点第一条入弧
    ArcBox firstin;
    // 指向该顶点第一条出弧
    ArcBox firstout;
}
