package cg.ice.hockey.strategies.line;

import cg.ice.hockey.util.Line;
import cg.ice.hockey.util.Point;
import java.awt.Color;

public interface LineStrategy {
    Line generateLine(Point p1, Point p2, int thickness, Color color);
    
    Line generateLine(Point p1, Point p2, int thickness);
}
