package test;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;





public class Test extends JFrame {

	private int object[][] =
		{  {0,0,0, 100,0,0},
		   {0,0,0, 0,100,0},	
		   {0,0,0, 0,0,100},	
		   {100,0,0, 100,0,100},	
		   {100,0,0, 100,100,0},	
		   {0,0,100, 100,0,100},	
		   {100,0,100, 100,100,100},	
		   {0,100,0, 0,100,100},	
		   {0,100,0, 100,100,0},	
		   {100,100,0, 100,100,100},	
		   {0,0,100, 0,100,100},	
		   {0,100,100, 100,100,100}	
				
		};
 
	class DrawPane extends JPanel { 
		public DrawPane() {
			super();
		}
		
		@Override
		public void paintComponent(Graphics g) {
			for (int[] line: object) {
				int[] p1 = {line[0], line[1], line[2]};
				int[] p2 = {line[3], line[4], line[5]};
				Point from = get2DFrom3D(p1);
				Point to   = get2DFrom3D(p2);
				System.out.println("From: " + from + ", To: " + to);
				g.drawLine(from.x, from.y, to.x, to.y);
			}
		}
		
		public Point get2DFrom3D(int[] xyz) {
			if (xyz.length < 3) return null;
			double __f = 50;
			double __z = 70;
			
			int x = xyz[0] + 1;
			int y = xyz[1] + 800;
			int z = xyz[2];
			
			double _x = 0;
			double _y = 0;
			
			_x = ( ( double)__f / (__z + ( z * (1/__f)))  ) * x;
			_y = ( (double)__f / (__z + ( z * (1/__f)))  ) * y;
			
			Point p = new Point((int)_x, (int)_y);
			return p;
			
		}
	}
	
	private DrawPane dp;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Test test = new Test();
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		test.setVisible(true);
	}
	
	public Test(String name) {
		super(name);
		dp = new DrawPane();
		getContentPane().add(dp, BorderLayout.CENTER);
		pack();
	}
	
	public Test() {
		this("3d Test");
	}
	

}
