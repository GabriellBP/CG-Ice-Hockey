package cg.ice.hockey;

import cg.ice.hockey.strategies.circle.CircleStrategy;
import cg.ice.hockey.strategies.line.LineStrategy;
import cg.ice.hockey.util.Line;
import cg.ice.hockey.util.Point;

public class ArenaRenderer {
    private LineStrategy lineStrategy;
    private CircleStrategy circleStrategy;

    public LineStrategy getLineStrategy() {
        return lineStrategy;
    }

    public void setLineStrategy(LineStrategy lineStrategy) {
        this.lineStrategy = lineStrategy;
    }

    public CircleStrategy getCircleStrategy() {
        return circleStrategy;
    }

    public void setCircleStrategy(CircleStrategy circleStrategy) {
        this.circleStrategy = circleStrategy;
    }
    
    public void drawArena(Point p1, Point p2) {
        Point tr = new Point(p2.x, p1.y);
        
        Line top = lineStrategy.generateLine(p1, tr);
    }
}
