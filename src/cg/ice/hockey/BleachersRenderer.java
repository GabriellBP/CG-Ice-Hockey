package cg.ice.hockey;

import cg.ice.hockey.strategies.circle.CircleStrategy;
import cg.ice.hockey.strategies.line.LineStrategy;
import cg.ice.hockey.util.Point;

public class BleachersRenderer {
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
    
    void drawLine(Point p1, Point p2) {
        this.lineStrategy.generateLine(p1, p2);
    }
}
