package com.peerfintech.datastructure.adjmatrix;

/**
 * Created with IntelliJ IDEA.
 * Author: cy
 * Date: 2023/4/15
 * Time: 1:06
 * Description: 邻接矩阵 遍历
 */
public class Main {
    public static void main(String[] args) {
        GraphFactory.getGraph();
        GraphFactory graphFactory = new GraphFactory();
        GraphTraversal graphTraversal = new GraphTraversal();
        graphTraversal.DFSTraverse(graphFactory.createGraph(GraphKind.UDN), GraphKind.UDN);
        graphTraversal.BFSTraverse(graphFactory.createGraph(GraphKind.UDN), GraphKind.UDN);
        graphTraversal.DFSTraverse(graphFactory.createGraph(GraphKind.UDG), GraphKind.UDG);
        graphTraversal.BFSTraverse(graphFactory.createGraph(GraphKind.UDG), GraphKind.UDG);
        graphTraversal.DFSTraverse(graphFactory.createGraph(GraphKind.DN), GraphKind.DN);
        graphTraversal.BFSTraverse(graphFactory.createGraph(GraphKind.DN), GraphKind.DN);
        graphTraversal.DFSTraverse(graphFactory.createGraph(GraphKind.DG), GraphKind.DG);
        graphTraversal.BFSTraverse(graphFactory.createGraph(GraphKind.DG), GraphKind.DG);
    }
}
