package demo002;

import java.util.*;

/**
 * 问题描述:
 * 小青蛙有一天不小心落入了一个地下迷宫,小青蛙希望用自己仅剩的体力值
 * P跳出这个地下迷宫.为了让问题简单,假设这是一个 n*m 的格子迷宫,迷宫
 * 每个位置为 0 或者 1, 0 代表这个位置有障碍物.小青蛙到达不了这个位
 * 置; 1 代表小青蛙可以到达的位置.小青蛙初始在(0,0)位置.地下迷宫的出
 * 口在(0, m - 1)(保证这两个位置都是1,并且保证一定有起点到终点可达的
 * 路径),小青蛙在迷宫中水平移动一个单位距离需要消耗 1 点体力值,向上爬
 * 一个单位距离需要消耗 3 个单位的体力值,向下移动不消耗体力值,当小青蛙
 * 的体力值等于 0 的时候还没有到达出口,小青蛙将无法逃离迷宫.现在需要你
 * 帮助小青蛙计算出能否用仅剩的体力值跳出迷宫(0, m - 1)位置).
 *
 * 输入描述:
 * 输入包括 n + 1 行:
 * 第一行为三个整数n, m(3 < = m, n <= 10), P(1 <= P <= 100)
 * 接下来的 n 行:
 * 每行 m 个 0 或者 1, 以空格分隔
 *
 * 输出描述:
 * 如果能逃离迷宫,则输出一行体力消耗最小的路径,输出格式见样例所示;
 * 如果不能逃离迷宫,则输出"Can not escape!". 测试数据保证答案唯一.
 *
 * 输入:
 * 4 4 10
 * 1 0 0 1
 * 1 1 0 1
 * 0 1 1 1
 * 0 0 1 1
 *
 * 输出:
 * [0,0],[1,0],[1,1],[2,1],[2,2],[2,3],[1,3],[0,3]
 */
public class Main {

    //坐标类
    static class Point{
        private int x;
        private int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj){
                return true;
            }

            if (obj == null && !(obj instanceof Point)){
                return false;
            }
            Point point = (Point)obj;
            return ((this.x == point.x) && (this.y == point.y));
        }

        @Override
        public int hashCode() {
            return this.x + this.y;
        }

        @Override
        public String toString() {
            return "[" + this.x + "," + this.y +  "]";
        }
    }

    //扩展节点类
    static class Node{
        public Point point;
        public int f;  //存储估价函数值
        public int g;  //到达当前位置实际付出的代价
        public int h;  //当前位置到目标位置所需的代价
        public Node parent = null;
        public Node child = null;
        public Node(Point point, int f, int g, int h){
            this.point = point;
            this.f = f;
            this.g = g;
            this.h = h;
        }
    }

    //最短路径的起始位置
    private Node head;

    //向上,下,左,右四个方向扩展
    private static int[][] DIR = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    //向上,下,左,右四个方向扩展,分别所需的代价
    private static int[] COST = {3, 0, 1, 1};

    //创建一个优先级队列(给扩展出的节点排序)
    private static PriorityQueue<Node> nodeQueue = new PriorityQueue<>(new Comparator<Node>() {
        @Override
        public int compare(Node o1, Node o2) {
            return o1.f - o2.f;
        }
    });

    //创建一个 Node 集合,保存已扩展的节点
    private static Map<Point, Node> pointMap = new HashMap<>();


    //计算当前节点到目标节点的曼哈顿距离
    private static int[] manhattanDistance(Node source, Node target) {
        //保存并返回曼哈顿距离
        int[] distance = new int[2];

        //计算水平距离
        int horizontalDistance = Math.abs(target.point.y - source.point.y);
        distance[0] = horizontalDistance;

        //计算垂直距离
        int verticalDistance = target.point.x - source.point.x;
        distance[1] = verticalDistance;

        return distance;
    }

    //计算估价函数
    private static void evaluate(Node source, Node target){
        //启发函数值
        int h = 0;
        //利用曼哈顿距离计算启发函数值
        int[] distance = manhattanDistance(source, target);
        //水平花费
        int horizontalCost = distance[0];
        //垂直花费
        int verticalCost = (distance[1] > 0 ? 0 : (- distance[1]) * COST[0]);

        h = horizontalCost + verticalCost;

        //估价函数值
        int f = source.g + h;
        source.f = f;
        source.h = h;
    }

    //扩展当前节点
    private static void extendedNode(Node curNode, Node target, int map[][]){
        int x = 0;
        int y = 0;
        // 1.从当前节点向上,下,左,右,四个方向扩展一步,
        // 并分别计算节点的估价函数值(若扩展出的节点不可达,则跳过);
        for (int i = 0; i < 4; i++) {
            x = curNode.point.x + DIR[i][0];
            y = curNode.point.y + DIR[i][1];
            //判断是否下标越界
            if (x < 0 || x >= map.length || y < 0 || y >= map[0].length){
                continue;
            }
            //判断当前节点是否可达
            if (map[x][y] == 0){
                continue;
            }

            Point point = new Point(x, y);
            Node newNode = new Node(point,0, curNode.g + COST[i], 0);
            evaluate(newNode, target);
            // 3.随后将扩展出的节点直接添加到优先级队列中.
            if (!pointMap.containsKey(newNode.point)) {
                nodeQueue.add(newNode);
            }
            // 2.查看优先级队列中是否包含当前扩展出的节点:
            // 1> 若存在,比较两节点的实际代价 g:
            if (pointMap.containsKey(point)) {
                //  a. 若扩展出的节点的 g 比 队列中的节点的 g 小,则将该节点的
                //     parent 指向当前扩展节点,反之,则无需修改 parent;
                if (pointMap.get(point).g  > newNode.g){
                    newNode.parent = curNode;
                    pointMap.put(point, newNode);
                }
            }else {
                // 2> 若不存在,将当前扩展出的节点的 parent 指向当前扩展节点;
                newNode.parent = curNode;
                pointMap.put(point, newNode);
            }
        }

        //若扩展周围节点后, Nodeset 为空,则表示该节点为死节点
        if (nodeQueue.isEmpty()){
            System.out.println("青蛙陷入死路,必死无疑,除非奇迹发生!");
        }
    }


    //计算最短路径
    private static void minPath(int p, int[][] map) {
        int n = map.length;
        int m = map[0].length;
        ArrayList<String> pathList = new ArrayList<>();
        Point srcPoint = new Point(0, 0);
        Point tarPoint = new Point(0, m - 1);
        //起始节点
        Node source = new Node(srcPoint, 0, 0, 0);
        Node target = new Node(tarPoint, 0, 0, 0);
        nodeQueue.add(source);
        pointMap.put(srcPoint, source);
        int sumCost = 0;
        //若存储扩展节点的队列不为空
        while (!nodeQueue.isEmpty()){
            Node curNode = nodeQueue.poll();
            //将单个路径节点加入总路径
            pathList.add(curNode.point.toString());
            //若找到目标节点则返回
            if (curNode.point.equals(target.point)){
                sumCost = curNode.g;
                break;
            }
            //扩展当前节点
            extendedNode(curNode, target, map);
        }


        if (sumCost > p){
            System.out.println("青蛙无法逃脱!体力不足!");
        }else {
            //打印路径
            int length = pathList.size();
            for (int i = 0; i < length; i++) {
                if (i != length - 1) {
                    System.out.print(pathList.get(i) + ",");
                } else {
                    System.out.println(pathList.get(i));
                }
            }
            System.out.println("消耗的总体力为:" + sumCost);
        }
        //清除数据
        nodeQueue.clear();
        pointMap.clear();
        pathList.clear();
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int indexI = 0;
        int indexJ = 0;
        while (in.hasNext()){
            //录入迷宫边界和青蛙的体力值
            int n = Integer.parseInt(in.next());
            int m = Integer.parseInt(in.next());
            int P = Integer.parseInt(in.next());
            int[][] map = new int[n][m];
            //录入迷宫信息
            for (indexI = 0; indexI < n; indexI++){
                for (indexJ = 0; indexJ < m; indexJ++){
                    map[indexI][indexJ] = Integer.parseInt(in.next());
                }
            }
            minPath(P, map);
        }
    }

}
