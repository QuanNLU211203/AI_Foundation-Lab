package lab8;

public class Test {
    public static void main(String[] args) {
        ISearchAlgo minimax = new MiniMaxSearchAlgo();
        ISearchAlgo alphaBeta = new AlphaBetaSearchAlgo(false);
        Node a = testSet2();
//        minimax.execute(a);
        alphaBeta.execute(a);
        System.out.println("--------------------");
        System.out.println(alphaBeta.bestNextMove(a, true).getLabel());
        System.out.println(alphaBeta.bestNextMove(alphaBeta.bestNextMove(a, true), false).getLabel());
    }

    public static Node testSet1(){
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E", 3);
        Node f = new Node("F", 12);
        Node g = new Node("G", 8);
        Node h = new Node("H", 2);
        Node i = new Node("I", 4);
        Node j = new Node("J", 6);
        Node k = new Node("K", 14);
        Node l = new Node("L", 5);
        Node m = new Node("M", 2);

        a.addChild(b);
        a.addChild(c);
        a.addChild(d);
        b.addChild(e);
        b.addChild(f);
        b.addChild(g);
        c.addChild(h);
        c.addChild(i);
        c.addChild(j);
        d.addChild(k);
        d.addChild(l);
        d.addChild(m);

        return a;
    }

    public static Node testSet2(){
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D", 0);
        Node e = new Node("E");
        Node f = new Node("F");
        Node g = new Node("G", -5);
        Node h = new Node("H", 3);
        Node i = new Node("I", 8);
        Node j = new Node("J");
        Node k = new Node("K");
        Node l = new Node("L", 2);
        Node m = new Node("M");
        Node n = new Node("N", 4);
        Node o = new Node("O");
        Node p = new Node("P", 9);
        Node q = new Node("Q", -6);
        Node r = new Node("R", 0);
        Node s = new Node("S", 3);
        Node t = new Node("T", 5);
        Node u = new Node("U", -7);
        Node v = new Node("V", -9);
        Node w = new Node("W", -3);
        Node x = new Node("X", -5);

        addChilds(a,b,c,d,e);
        addChilds(b,f,g);
        addChilds(c,h,i,j);
        addChilds(e,k,l,m);
        addChilds(f,n,o);
        addChilds(j,p,q,r);
        addChilds(k,s,t);
        addChilds(m,u,v);
        addChilds(o,w,x);

        return a;
    }

    public static Node testSet3(){
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");
        Node f = new Node("F");
        Node g = new Node("G");
        Node h = new Node("H");
        Node i = new Node("I");
        Node j = new Node("J");
        Node k = new Node("K");
        Node l = new Node("L");
        Node m = new Node("M");
        Node n = new Node("N");
        Node o = new Node("O");
        Node p = new Node("P");
        Node q = new Node("Q");
        Node r = new Node("R");
        Node s = new Node("S");
        Node t = new Node("T");
        Node k1 = new Node("K1", 4);
        Node k2 = new Node("K2", 9);
        Node l1 = new Node("L1", 2);
        Node m1 = new Node("M1", 1);
        Node m2 = new Node("M2", 10);
        Node n1 = new Node("N1", 0);
        Node n2 = new Node("N2", 7);
        Node o1 = new Node("O1", 4);
        Node p1 = new Node("P1", 2);
        Node q1 = new Node("Q1", 1);
        Node q2 = new Node("Q2", 8);
        Node r1 = new Node("R1", 3);
        Node s1 = new Node("S1", 7);
        Node s2 = new Node("S2", 4);
        Node t1 = new Node("T1", 3);
        Node t2 = new Node("T2", 1);

        addChilds(a,b,c,d);
        addChilds(b,e,f);
        addChilds(c,g,h);
        addChilds(d,i,j);
        addChilds(e,k,l);
        addChilds(f,m,n);
        addChilds(g,o);
        addChilds(h,p,q);
        addChilds(i,r,s);
        addChilds(j,t);
        addChilds(k,k1,k2);
        addChilds(l,l1);
        addChilds(m,m1,m2);
        addChilds(n,n1,n2);
        addChilds(o,o1);
        addChilds(p,p1);
        addChilds(q,q1,q2);
        addChilds(r,r1);
        addChilds(s,s1,s2);
        addChilds(t,t1,t2);

        return a;
    }

    public static void addChilds(Node parent, Node... childs){
        for(Node child : childs){
            parent.addChild(child);
        }
    }
}
