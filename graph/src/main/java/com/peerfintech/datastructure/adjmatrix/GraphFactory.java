package com.peerfintech.datastructure.adjmatrix;

import com.peerfintech.util.UseCaseUtil;

import java.util.Scanner;

/**
 * 邻接矩阵图构造
 */
public class GraphFactory {

    public static void getGraph() {
        GraphFactory graphFactory = new GraphFactory();
        MGraph graph = null;
        System.out.println("创建无向网");
        graph = graphFactory.createGraph(GraphKind.UDN);
        graph.print();
        System.out.println("创建无向图");
        graph = graphFactory.createGraph(GraphKind.UDG);
        graph.print();
        System.out.println("创建有向网");
        graph = graphFactory.createGraph(GraphKind.DN);
        graph.print();
        System.out.println("创建有向图");
        graph = graphFactory.createGraph(GraphKind.DG);
        graph.print();
    }

    public MGraph createGraph(GraphKind kind) {
        MGraph mGraph = null;
        switch (kind) {
            case DG:
                mGraph = createDG();
                break;
            case DN:
                mGraph = createDN();
                break;
            case UDG:
                mGraph = createUDG();
                break;
            case UDN:
                mGraph = createUDN();
                break;
            default:
                mGraph = null;
        }
        return mGraph;
    }

    /**
     * 构造有向图
     *
     * @return
     */
    private MGraph createDG() {
        MGraph graph = new MGraph();
        Scanner in = new Scanner(UseCaseUtil.getInput("matrixDG"));
        graph.vexNum = in.nextInt();
        graph.arcNum = in.nextInt();
        // 构造顶点向量
        for (int i = 0; i < graph.vexNum; i++) {
            graph.ves[i] = i;
        }
        // 初始化邻接矩阵
        for (int i = 0; i < graph.vexNum; i++) {
            for (int j = 0; j < graph.vexNum; j++) {
                VRType vrType = new VRType();
                vrType.value = 0;
                ArcCell arcCell = new ArcCell();
                arcCell.vrType = vrType;
                graph.adjMatrix[i][j] = arcCell;
            }
        }
        // 构造邻接矩阵
        for (int i = 0; i < graph.arcNum; i++) {
            // 输入顶点序号和权值
            int v1 = in.nextInt();
            int v2 = in.nextInt();
            graph.adjMatrix[v1][v2].vrType.value = 1;
        }
        return graph;
    }

    /**
     * 构造有向网
     *
     * @return
     */
    private MGraph createDN() {
        MGraph graph = new MGraph();
        Scanner in = new Scanner(UseCaseUtil.getInput("matrixDN"));
        graph.vexNum = in.nextInt();
        graph.arcNum = in.nextInt();
        // 构造顶点向量
        for (int i = 0; i < graph.vexNum; i++) {
            graph.ves[i] = i;
        }
        // 初始化邻接矩阵
        for (int i = 0; i < graph.vexNum; i++) {
            for (int j = 0; j < graph.vexNum; j++) {
                VRType vrType = new VRType();
                vrType.value = Integer.MAX_VALUE;
                ArcCell arcCell = new ArcCell();
                arcCell.vrType = vrType;
                graph.adjMatrix[i][j] = arcCell;
            }
        }
        // 构造邻接矩阵
        for (int i = 0; i < graph.arcNum; i++) {
            // 输入顶点序号和权值
            int v1 = in.nextInt();
            int v2 = in .nextInt();
            int val = in.nextInt();
            graph.adjMatrix[v1][v2].vrType.value = val;
        }
        return graph;
    }

    /**
     * 构造无向图
     *
     * @return
     */
    private MGraph createUDG() {
        MGraph graph = new MGraph();
        Scanner in = new Scanner(UseCaseUtil.getInput("matrixUDG"));
        graph.vexNum = in.nextInt();
        graph.arcNum = in.nextInt();
        // 构造顶点向量
        for (int i = 0; i < graph.vexNum; i++) {
            graph.ves[i] = i;
        }
        // 初始化邻接矩阵
        for (int i = 0; i < graph.vexNum; i++) {
            for (int j = 0; j < graph.vexNum; j++) {
                VRType vrType = new VRType();
                vrType.value = 0;
                ArcCell arcCell = new ArcCell();
                arcCell.vrType = vrType;
                graph.adjMatrix[i][j] = arcCell;
            }
        }
        // 构造邻接矩阵
        for (int i = 0; i < graph.arcNum; i++) {
            // 输入顶点序号和权值
            int v1 = in.nextInt();
            int v2 = in.nextInt();
            graph.adjMatrix[v1][v2].vrType.value = 1;
            // 无向图设置对称位置
            graph.adjMatrix[v2][v1] = graph.adjMatrix[v1][v2];
        }
        return graph;
    }

    /**
     * 构造无向网 边有权值
     *
     * @return
     */
    private MGraph createUDN() {
        MGraph graph = new MGraph();
        Scanner in = new Scanner(UseCaseUtil.getInput("matrixUDN"));
        graph.vexNum = in.nextInt();
        graph.arcNum = in.nextInt();
        // 构造顶点向量
        for (int i = 0; i < graph.vexNum; i++) {
            graph.ves[i] = i;
        }
        // 初始化邻接矩阵
        for (int i = 0; i < graph.vexNum; i++) {
            for (int j = 0; j < graph.vexNum; j++) {
                VRType vrType = new VRType();
                vrType.value = Integer.MAX_VALUE;
                ArcCell arcCell = new ArcCell();
                arcCell.vrType = vrType;
                graph.adjMatrix[i][j] = arcCell;
            }
        }
        // 构造邻接矩阵
        for (int i = 0; i < graph.arcNum; i++) {
            // 输入顶点序号和权值
            int v1 = in.nextInt();
            int v2 = in.nextInt();
            int val = in.nextInt();
            graph.adjMatrix[v1][v2].vrType.value = val;
            // 无向图设置对称位置
            graph.adjMatrix[v2][v1] = graph.adjMatrix[v1][v2];
        }
        return graph;
    }
}
