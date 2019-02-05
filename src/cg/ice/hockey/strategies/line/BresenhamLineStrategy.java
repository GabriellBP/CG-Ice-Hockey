package cg.ice.hockey.strategies.line;

import cg.ice.hockey.util.Point;
import cg.ice.hockey.util.Line;
import static java.lang.Math.abs;

public class BresenhamLineStrategy implements LineStrategy {

    @Override
    public Line generateLine(Point p1, Point p2) {
        int dx, dy, x, y, incX, incY, abs;
        Line line = new Line();
        
        x = p1.x;
        y = p1.y;
        
        line.addPoint(x, y);
        
        dx = Math.abs(p2.x - x);
        dy = Math.abs(p2.y - y);
        abs = dx - dy;

        incX = (x < p2.x) ? 1 : -1;
        incY = (y < p2.y) ? 1 : -1;

        while ((x != p2.x) || (y != p2.y)) {  
            int p = 2 * abs;

            if (p > -dy) {
                abs = abs - dy;
                x = x + incX;
            }
            if (p < dx) {
                abs = abs + dx;
                y = y + incY;
            }
             line.addPoint(x, y);
        }
        
        return line;
    }
}
