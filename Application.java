/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author Milan
 */
public class Application {
    
    public static void main(String[] args) {
        
        Vertex h1 = new Vertex("h1");
        Vertex h2 = new Vertex("h2");
        Vertex a1 = new Vertex("a1");
        Vertex cz1 = new Vertex("cz1");
        Vertex cz2 = new Vertex("cz2");
        Vertex nj1 = new Vertex("nj1");
        Vertex nj2 = new Vertex("nj2");
        Vertex nj3 = new Vertex("nj3");
        Vertex b1 = new Vertex("b1");
        
        Vertex s1 = new Vertex("s1");
        Vertex i1 = new Vertex("i1");
        Vertex i2 = new Vertex("i2");
        Vertex i3 = new Vertex("i3");
        Vertex i4 = new Vertex("i4");
        Vertex f1 = new Vertex("f1");
        Vertex f2 = new Vertex("f2");
        Vertex f3 = new Vertex("f3");
        Vertex f4 = new Vertex("f4");
        
        Vertex f5 = new Vertex("f5");
        Vertex sh1 = new Vertex("sh1");
        Vertex sh2 = new Vertex("sh2");
        Vertex sh3 = new Vertex("sh3");
        Vertex sh4 = new Vertex("sh4");
        Vertex sh5 = new Vertex("sh5");
        Vertex sh6 = new Vertex("sh6");
        Vertex p1 = new Vertex("p1");
        Vertex p2 = new Vertex("p2");
        
        h1.setAdjacencies(new Edge[] {new Edge(h2, 2), new Edge(a1, 5), new Edge(cz2, 9), new Edge(cz1, 7), new Edge(i3, 6)});
        h2.setAdjacencies(new Edge[] {new Edge(a1, 3), new Edge(cz2, 6), new Edge(nj3, 9), new Edge(i4, 11), new Edge(h1, 2)});
        a1.setAdjacencies(new Edge[] {new Edge(cz1, 7), new Edge(cz2, 4), new Edge(nj1, 1), new Edge(i4, 5), new Edge(h1, 5), new Edge(h2, 3)});
        cz1.setAdjacencies(new Edge[] {new Edge(cz2, 1), new Edge(nj2, 3), new Edge(nj3, 5), new Edge(b1, 9), new Edge(h1, 7), new Edge(a1, 7)});
        cz2.setAdjacencies(new Edge[] {new Edge(i3, 10), new Edge(nj1, 4), new Edge(nj2, 4), new Edge(h1, 9), new Edge(h2, 6),  new Edge(a1, 4), new Edge(cz1, 1)});
        nj1.setAdjacencies(new Edge[] {new Edge(nj2, 1), new Edge(nj3, 4), new Edge(b1, 2), new Edge(f4, 5), new Edge(a1, 1), new Edge(cz2, 4)});
        nj2.setAdjacencies(new Edge[] {new Edge(b1, 7), new Edge(f3, 10), new Edge(f1, 8), new Edge(f5, 5), new Edge(cz1, 3), new Edge(cz2, 4), new Edge(nj1, 1), new Edge(nj3, 2)});
        nj3.setAdjacencies(new Edge[] {new Edge(f1, 15), new Edge(f2, 9), new Edge(s1, 5), new Edge(nj2, 2), new Edge(h2, 9), new Edge(cz1, 5), new Edge(nj1, 4)});
        b1.setAdjacencies(new Edge[] {new Edge(f4, 1), new Edge(f3, 7), new Edge(f5, 9), new Edge(s1, 10), new Edge(cz1, 9), new Edge(nj1, 2), new Edge(nj2, 7)});
        
        s1.setAdjacencies(new Edge[] {new Edge(i1, 3), new Edge(i2, 5), new Edge(f5, 2), new Edge(nj3, 5), new Edge(b1, 10)});
        i1.setAdjacencies(new Edge[] {new Edge(i3, 5), new Edge(i2, 4), new Edge(i4, 8), new Edge(f1, 12), new Edge(s1, 3)});
        i2.setAdjacencies(new Edge[] {new Edge(i4, 2), new Edge(f2, 8), new Edge(f3, 11), new Edge(f5, 5), new Edge(s1, 5), new Edge(i1, 4)});
        i3.setAdjacencies(new Edge[] {new Edge(sh6, 13), new Edge(f5, 4), new Edge(f2, 6), new Edge(h1, 6), new Edge(cz2, 10), new Edge(i1, 5)});
        i4.setAdjacencies(new Edge[] {new Edge(sh6, 7), new Edge(sh5, 12), new Edge(sh3, 14), new Edge(h2, 11), new Edge(a1, 5), new Edge(i1, 8), new Edge(i2, 2)});
        f1.setAdjacencies(new Edge[] {new Edge(sh5, 3), new Edge(sh6, 5), new Edge(nj2, 8), new Edge(nj3, 15), new Edge(i1, 12), new Edge(f2, 2), new Edge(f4, 7), new Edge(f5, 4)});
        f2.setAdjacencies(new Edge[] {new Edge(f4, 7), new Edge(f3, 1), new Edge(f1, 2), new Edge(nj3, 9), new Edge(i2, 8), new Edge(i3, 6)});
        f3.setAdjacencies(new Edge[] {new Edge(sh4, 15), new Edge(nj2, 10), new Edge(b1, 7), new Edge(i2, 11), new Edge(f2, 1)});
        f4.setAdjacencies(new Edge[] {new Edge(f1, 7), new Edge(nj1, 5), new Edge(b1, 1), new Edge(f2, 7)});
        
        f5.setAdjacencies(new Edge[] {new Edge(f1, 4), new Edge(sh6, 11), new Edge(nj2, 5), new Edge(b1, 9), new Edge(s1, 2), new Edge(i2, 5), new Edge(i3, 4)});
        sh1.setAdjacencies(new Edge[] {new Edge(p1, 6), new Edge(p2, 12), new Edge(sh2, 3), new Edge(sh3, 6)});
        sh2.setAdjacencies(new Edge[] {new Edge(sh1, 3), new Edge(sh4, 5), new Edge(p1, 7), new Edge(sh3, 4)});
        sh3.setAdjacencies(new Edge[] {new Edge(sh2, 4), new Edge(sh1, 6), new Edge(p1, 5), new Edge(p2, 7), new Edge(i4, 14)});
        sh4.setAdjacencies(new Edge[] {new Edge(sh5, 5), new Edge(sh6, 2), new Edge(p1, 4), new Edge(f3, 15), new Edge(sh2, 5)});
        sh5.setAdjacencies(new Edge[] {new Edge(sh6, 3), new Edge(p2, 11), new Edge(p1, 13), new Edge(i4, 12), new Edge(f1, 3), new Edge(sh4, 5)});
        sh6.setAdjacencies(new Edge[] {new Edge(p2, 7), new Edge(p1, 9), new Edge(i3, 13), new Edge(i4, 7), new Edge(f1, 5), new Edge(f5, 11), new Edge(sh4, 2), new Edge(sh5, 3)});
        p1.setAdjacencies(new Edge[] {new Edge(p2, 3), new Edge(sh1, 6), new Edge(sh2, 7), new Edge(sh3, 5), new Edge(sh4, 4), new Edge(sh5, 13), new Edge(sh6, 9)});
        p2.setAdjacencies(new Edge[] {new Edge(sh1, 12), new Edge(sh3, 7), new Edge(sh5, 11), new Edge(sh6, 7), new Edge(p2, 3)});
        
        Vertex[] vertices = {h1, h2, a1, cz1, cz2, nj1, nj2, nj3, b1, s1, i1, i2, i3, i4, f1, f2, f3, f4, f5, sh1, sh2, sh3, sh4, sh5, sh6, p1, p2};
        
        DijkstraRouter.computeRoutingPath(h2, p2, vertices);
        
    }
}
