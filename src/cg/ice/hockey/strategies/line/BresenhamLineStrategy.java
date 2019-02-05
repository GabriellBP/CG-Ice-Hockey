package cg.ice.hockey.strategies.line;

import cg.ice.hockey.util.Point;
import cg.ice.hockey.util.Line;

public class BresenhamLineStrategy implements LineStrategy {

    @Override
    public Line generateLine(Point pp1, Point pp2) {
        int limit;
        Point p1, p2;
        if (pp1.x == pp2.x) {
            if (pp1.y < pp2.y) { // Norte
                limit = pp2.y;
            } else { // Sul
                limit = pp1.y;
            }
        } else {
            if (pp1.x < pp2.x) {
                limit = pp2.x;
            } else {
                limit = pp1.x;
            }
        }        
        
        if (pp1.x > pp2.x) {
            p1 = new Point(pp2.x, pp2.y);
            p2 = new Point(pp1.x, pp1.y);
            System.out.println("INVERTEU CACHORRA");
        } else {
            p1 = new Point(pp1.x, pp1.y);
            p2 = new Point(pp2.x, pp2.y);
        }


        /*
            x1 < x2 e y1 < y2 [NE]
            x1 < x2 e y1 > y2 [SE] <-
            x1 > x2 e y1 < y2 [NW] <-
            x1 > x2 e y1 > y2 [SW] <-
            
            x1 = x2 <- x em função de y
                y1 < y2 [N]
                y1 > y2 [S]
            y1 = y2
                x1 < x2 [E]
                x1 > x2 [W]
        */
        
        int dx = p2.x - p1.x;
        int dy = p2.y - p1.y;
        
        int d = 2 * dy - dx;  // valor inicial de D
        
        int deltaE = 2 * dy;  // incremento de E
        int deltaNE = 2 * (dy - dx);  // incremento de NE
                
        int x = p1.x;
        int y = p1.y;
        
        Line line = new Line();
        line.addPoint(x, y);
        
        while (x <= p2.x) {
            if (d <= 0) {
                /* escolhe E */
                d += deltaE;
                x++;
            } else {
                System.out.println("INCREMENTOU X E Y");
                /* escolhe NE */
                d += deltaNE;
                x++;
                y++;
            }
            line.addPoint(x, y);
        }
        
        return line;
    }
}
