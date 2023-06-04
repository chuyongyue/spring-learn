package com.peerfintech.datastructure.adjmatrix;

/**
 * 弧信息
 */
public class ArcCell {
    /**
     * 顶点关系类型，对无权图，用1或者0表示相邻。对带权图则为权值。
     */
    public VRType vrType;

    /**
     * 弧相关信息
     */
    public InfoType infoType;
}
