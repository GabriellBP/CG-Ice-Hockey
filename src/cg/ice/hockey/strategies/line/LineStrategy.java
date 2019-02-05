package cg.ice.hockey.strategies.line;

import cg.ice.hockey.util.Line;
import cg.ice.hockey.util.Point;

public interface LineStrategy {
    Line generateLine(Point p1, Point p2);
}
