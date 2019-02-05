package cg.ice.hockey.strategies.circle;

import cg.ice.hockey.util.Point;
import javafx.scene.shape.Circle;

public interface CircleStrategy {
    Circle generateCircle(Point center, float radius);
}
