package test;

import javax.swing.JFrame;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;

public class Hello implements GLEventListener {
	public static void main(String[] ard) {
		final GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);
        final GLCanvas glcanvas = new GLCanvas(capabilities);
       Hello l = new Hello();
        glcanvas.addGLEventListener(l);
        glcanvas.setSize(500, 500);

        final JFrame frame = new JFrame("");
        frame.getContentPane().add(glcanvas);
        frame.setSize(frame.getContentPane().getPreferredSize());
        frame.setVisible(true);
	}
	@Override
	public void display(GLAutoDrawable arg0) {
		// TODO Auto-generated method stub
		GL2	 gl = arg0.getGL().getGL2();
 		gl.glColor3f(1f, 1f, 0f);
 		try {
			drawCircle(gl, 0.1f, 0.7f, 0.7f, 360);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void dispose(GLAutoDrawable arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(GLAutoDrawable arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
		// TODO Auto-generated method stub
		
	}
	public void drawCircle (GL2 gl ,float radius, float centerX ,float centerY , int alpha) throws InterruptedException{
		   
	    gl.glBegin(GL2.GL_LINE_LOOP);
	    for (int i =0 ; i <= alpha ;i++){
	    gl.glVertex2f(centerX,centerY);
	    double angle =Math.PI * i / 180 ;
	    double x =Math .cos(angle)* radius ;
	    double y =Math .sin(angle)* radius ;
	    gl.glVertex2f((float)x+ centerX,(float) y+centerY);
	    Thread.sleep(1000);
	    }
	    
	    gl.glEnd();
	    }
}
