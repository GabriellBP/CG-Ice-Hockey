package cg.ice.hockey.strategies.circle;

import cg.ice.hockey.util.Point;
import cg.ice.hockey.util.Circle;

public interface CircleStrategy {
    Circle generateCircle(Point center, int radius);
}
