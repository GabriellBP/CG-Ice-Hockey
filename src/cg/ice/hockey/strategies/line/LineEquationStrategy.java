package cg.ice.hockey.strategies.line;

import cg.ice.hockey.util.Line;
import cg.ice.hockey.util.Point;
import static java.lang.Math.abs;
import static java.lang.Math.floor;

public class LineEquationStrategy implements LineStrategy {

    @Override
    public Line generateLine(Point p1, Point p2) {
        if (p1.x > p2.x) {
            Point aux = p1; p1 = p2; p2 = aux;
            System.out.println("INVERTEU CACHORRA");
        }
        
        boolean inverted = abs(p2.y - p1.y) > abs(p2.x - p1.x);
        if (inverted) {
            int aux = p1.x; p1.x = p1.y; p1.y = aux;
            aux = p2.x; p2.x = p2.y; p2.y = aux;
        }
        
        Line line = new Line();
        double m = (p2.y - p1.y) / ((p2.x - p1.x) * 1.0);
        int x, y;
        
        line.addPoint(p1.x, p1.y);
        for (x = p1.x; x <= p2.x; x++) {
            y = (int) floor(p1.y + m * (x - p1.x));
//            System.out.printf("m=%f => x=%d, y=%d\n", m, x, y);
            if (inverted) {
                line.addPoint(y, x);
            } else {
                line.addPoint(x, y);
            }
        }
        
        return line;
    }
}
