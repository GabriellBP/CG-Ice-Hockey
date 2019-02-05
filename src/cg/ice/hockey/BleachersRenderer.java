package cg.ice.hockey;

import cg.ice.hockey.strategies.circle.CircleStrategy;
import cg.ice.hockey.strategies.line.LineStrategy;
import cg.ice.hockey.util.Line;
import cg.ice.hockey.util.Point;
import static com.jogamp.opengl.GL.GL_POINTS;
import com.jogamp.opengl.GL2;
import java.util.ArrayList;

public class BleachersRenderer {
    private GL2 gl;
    private LineStrategy lineStrategy;    
    private ArrayList<Line> bleachers = new ArrayList();

    public BleachersRenderer(GL2 gl, LineStrategy lineStrategy) {
        this.gl = gl;
        this.lineStrategy = lineStrategy;
    }  

    public void setLineStrategy(LineStrategy lineStrategy) {
        this.lineStrategy = lineStrategy;
    }
    
    public void addBleacher(Point p1, Point p2) {
        this.bleachers.add(this.lineStrategy.generateLine(p1, p2));
    }
    
    void drawBleachrs() {
        gl.glColor3ub((byte) 0, (byte) 0, (byte) 255);
        this.bleachers.forEach(bleach -> {
            gl.glBegin(GL_POINTS);
                bleach.points.forEach(p -> {
                    gl.glVertex2d(p.x, p.y);
                });
            gl.glEnd();
        });
    }
}
