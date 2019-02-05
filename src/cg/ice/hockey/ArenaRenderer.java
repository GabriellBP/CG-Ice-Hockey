package cg.ice.hockey;

import cg.ice.hockey.strategies.circle.CircleStrategy;
import cg.ice.hockey.strategies.line.LineStrategy;
import cg.ice.hockey.util.Line;
import cg.ice.hockey.util.Point;
import static com.jogamp.opengl.GL.GL_POINTS;
import com.jogamp.opengl.GL2;

public class ArenaRenderer {
    private GL2 gl;
    private LineStrategy lineStrategy;
    private CircleStrategy circleStrategy;

    public ArenaRenderer(GL2 gl, LineStrategy lineStrategy) {
        this.gl = gl;
        this.lineStrategy = lineStrategy;
//        this.circleStrategy = circleStrategy;
    }

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
        Line line = lineStrategy.generateLine(p1, p2);
        System.out.printf("drawing arena from: (x=%d, y=%d) to (x=%d, y=%d)\n", p1.x, p1.y, p2.x, p2.y);
        
        gl.glColor3ub((byte) 255, (byte) 0, (byte) 0);
        gl.glBegin(GL_POINTS);
            line.points.forEach(p -> {
                System.out.printf("x=%d, y=%d\n", p.x, p.y);
                gl.glVertex2d(p.x, p.y);
            });
        gl.glEnd();
    }
}
