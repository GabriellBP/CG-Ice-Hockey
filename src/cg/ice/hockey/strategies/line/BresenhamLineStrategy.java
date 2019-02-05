package cg.ice.hockey.strategies.line;

import cg.ice.hockey.util.Point;
import cg.ice.hockey.util.Line;

public class BresenhamLineStrategy implements LineStrategy {

    @Override
    public Line generateLine(Point p1, Point p2) {
        int dx = p1.x - p2.x;
        int dy = p1.y - p2.y;
        
        int d = 2 * dy - dx;  // valor inicial de D
        
        int deltaE = 2 * dy;  // incremento de E
        int deltaNE = 2 * (dy - dx);  // incremento de NE
                
        int x = p1.x;
        int y = p1.y;
        
        Line line = new Line();
        line.addPoint(x, y);
        
        while (x < p2.x) {
            if (d <= 0) {
                /* escolhe E */
                d += deltaE;
                x++;
            } else {
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
