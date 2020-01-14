package gragh;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 有向带权图
 * Created by ShouJingGuo on 2018/3/27.
 */
public class Graph {

    Map<String, Vertex> vertexsMap;           //存储所有的顶点

    private class Vertex{
        private String name;        //顶点名称
        private Edge next;          //下一段弧

        Vertex(String name, Edge next){
            this.name = name;
            this.next = next;
        }
    }

    private class Edge{
        private String name;        //被指向顶点名称
        private int weight;         //弧的权值
        private Edge next;          //下一段弧

        Edge(String name, int weight, Edge next){
            this.name = name;
            this.weight = weight;
            this.next = next;
        }
    }

    Graph(){
        this.vertexsMap = new HashMap<>();
    }

    public void insertVertex(String vertexName){                //添加顶点
        Vertex vertex = new Vertex(vertexName, null);
        vertexsMap.put(vertexName, vertex);
    }

    public void insertEdge(String begin, String end, int weight){           //添加弧
        Vertex beginVertex = vertexsMap.get(begin);
        if(beginVertex == null){
            beginVertex = new Vertex(begin, null);
            vertexsMap.put(begin, beginVertex);
        }
        Edge edge = new Edge(end, weight, null);
        if(beginVertex.next == null){
            beginVertex.next = edge;
        }else{
            Edge lastEdge = beginVertex.next;
            while(lastEdge.next != null){
                lastEdge = lastEdge.next;
            }
            lastEdge.next = edge;
        }
    }

    public void print(){                    //打印图
        Set<Map.Entry<String, Vertex>> set = vertexsMap.entrySet();
        Iterator<Map.Entry<String, Vertex>> iterator = set.iterator();
        while(iterator.hasNext()){
            Map.Entry<String, Vertex> entry = iterator.next();
            Vertex vertex = entry.getValue();
            Edge edge = vertex.next;
            while(edge != null){
                System.out.println(vertex.name + " --> " + edge.name + " weight：" + edge.weight);
                edge = edge.next;
            }
        }
    }

    public void buildGraph (Graph graph) {

        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertVertex("D");
        graph.insertVertex("E");
        graph.insertVertex("F");

        graph.insertEdge("C", "A", 1);
        graph.insertEdge("F", "C", 2);
        graph.insertEdge("A", "B", 4);
        graph.insertEdge("E", "B", 2);
        graph.insertEdge("A", "D", 5);
        graph.insertEdge("D", "F", 4);
        graph.insertEdge("D", "E", 3);
        graph.print();
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.buildGraph(graph);
//        Graph graph = new Graph();
//        graph.insertVertex("A");
//        graph.insertVertex("B");
//        graph.insertVertex("C");
//        graph.insertVertex("D");
//        graph.insertVertex("E");
//        graph.insertVertex("F");
//
//        graph.insertEdge("C", "A", 1);
//        graph.insertEdge("F", "C", 2);
//        graph.insertEdge("A", "B", 4);
//        graph.insertEdge("E", "B", 2);
//        graph.insertEdge("A", "D", 5);
//        graph.insertEdge("D", "F", 4);
//        graph.insertEdge("D", "E", 3);
//
//        graph.print();
    }
}
