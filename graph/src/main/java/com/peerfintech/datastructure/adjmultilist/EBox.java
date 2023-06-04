package com.peerfintech.datastructure.adjmultilist;

/**
 * Created with IntelliJ IDEA.
 * Author: cy
 * Date: 2023/4/14
 * Time: 22:36
 * Description: 边节点
 */
public class EBox {
    VisitIf mark; // 访问标记
    int ivex; // 该边的i顶点的位置
    int jvex; // 该边的j顶点的位置
    EBox ilink; // i顶点的下一条边
    EBox jlink; // j顶点的下一条边
    int value; // 边的信息
}
