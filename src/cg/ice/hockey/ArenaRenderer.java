package cg.ice.hockey;

import cg.ice.hockey.strategies.circle.CircleStrategy;
import cg.ice.hockey.strategies.line.LineStrategy;
import cg.ice.hockey.util.Circle;
import cg.ice.hockey.util.Line;
import cg.ice.hockey.util.Point;
import static com.jogamp.opengl.GL.GL_POINTS;
import com.jogamp.opengl.GL2;
import java.util.ArrayList;

public class ArenaRenderer {
    private GL2 gl;
    private LineStrategy lineStrategy;
    private CircleStrategy circleStrategy;

    public ArenaRenderer(GL2 gl, LineStrategy lineStrategy, CircleStrategy circleStrategy) {
        this.gl = gl;
        this.lineStrategy = lineStrategy;
        this.circleStrategy = circleStrategy;
    }

    public void setLineStrategy(LineStrategy lineStrategy) {
        this.lineStrategy = lineStrategy;
    }

    public void setCircleStrategy(CircleStrategy circleStrategy) {
        this.circleStrategy = circleStrategy;
    }
    
    public void drawArena(Point p1, Point p2) {
        int width = p2.x - p1.x, height = p2.y - p1.y;
        
        int radiusCorner = (int) (width * 0.28), radiusZones = (int) (width * 0.17), radiusGoalZone = (int) (width * 0.09);
        int goalAreaHeight = (int) (height * 0.07), goalLineMargin = (int) (width * 0.066), midAreaHeight = (int) (height * 0.35);
        
        
        Circle tlCorner = circleStrategy.generateQuadrant(new Point(p1.x + radiusCorner, p1.y + radiusCorner), radiusCorner, 3);
        Circle trCorner = circleStrategy.generateQuadrant(new Point(p2.x - radiusCorner, p1.y + radiusCorner), radiusCorner, 4);
        Circle brCorner = circleStrategy.generateQuadrant(new Point(p2.x - radiusCorner, p2.y - radiusCorner), radiusCorner, 1);
        Circle blCorner = circleStrategy.generateQuadrant(new Point(p1.x + radiusCorner, p2.y - radiusCorner), radiusCorner, 2);
        
        Circle topGoalZone = circleStrategy.generateCircle(new Point (p1.x + width / 2, p1.y + goalAreaHeight), radiusGoalZone, new int[]{1, 2});
        Circle bottomGoalZone = circleStrategy.generateCircle(new Point (p1.x + width / 2, p2.y - goalAreaHeight), radiusGoalZone, new int[]{3, 4});
        Circle centerZone = circleStrategy.generateCircle(new Point (p1.x + width / 2, p1.y + height / 2), (int) (width * 0.16));
//        Circle tlZone = circleStrategy.generateCircle(new Point(p1.x + width / 4, p1.y + goalAreaHeight))
        
        ArrayList<Circle> circles = new ArrayList();
        circles.add(tlCorner);
        circles.add(trCorner);
        circles.add(brCorner);
        circles.add(blCorner);
        circles.add(topGoalZone);
        circles.add(bottomGoalZone);
        circles.add(centerZone);
        
        Line topSide = lineStrategy.generateLine(new Point(p1.x + radiusCorner, p1.y), new Point(p2.x - radiusCorner, p1.y));
        Line rightSide = lineStrategy.generateLine(new Point(p2.x, p1.y + radiusCorner), new Point(p2.x, p2.y - radiusCorner));
        Line bottomSide = lineStrategy.generateLine(new Point(p1.x + radiusCorner, p2.y), new Point(p2.x - radiusCorner, p2.y));
        Line leftSide = lineStrategy.generateLine(new Point(p1.x, p1.y + radiusCorner), new Point(p1.x, p2.y - radiusCorner));
        
        Line topGoalLine = lineStrategy.generateLine(new Point(p1.x + goalLineMargin, p1.y + goalAreaHeight), new Point(p2.x - goalLineMargin, p1.y + goalAreaHeight));
        Line bottomGoalLine = lineStrategy.generateLine(new Point(p1.x + goalLineMargin, p2.y - goalAreaHeight), new Point(p2.x - goalLineMargin, p2.y - goalAreaHeight));
        
        Line topMidAreaLine = lineStrategy.generateLine(new Point(p1.x, p1.y + midAreaHeight), new Point(p2.x, p1.y + midAreaHeight));
        Line bottomMidAreaLine = lineStrategy.generateLine(new Point(p1.x, p2.y - midAreaHeight), new Point(p2.x, p2.y - midAreaHeight));
        
        ArrayList<Line> lines = new ArrayList();
        lines.add(topSide);
        lines.add(rightSide);
        lines.add(bottomSide);
        lines.add(leftSide);
        lines.add(topGoalLine);
        lines.add(bottomGoalLine);
        lines.add(topMidAreaLine);
        lines.add(bottomMidAreaLine);
        
        gl.glColor3ub((byte) 0, (byte) 0, (byte) 0);
        circles.forEach(circle -> {
            circle.points.forEach(p -> {
                gl.glBegin(GL_POINTS);
                    gl.glVertex2d(p.x, p.y);
                gl.glEnd();
            });
        });
        
        lines.forEach(line -> {
            line.points.forEach(p -> {
                gl.glBegin(GL_POINTS);
                    gl.glVertex2d(p.x, p.y);
                gl.glEnd();
            });
        });
    }
}
