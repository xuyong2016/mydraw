package com.simon;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.plaf.basic.BasicTreeUI.MouseInputHandler;

public class MyDraw extends JFrame implements MouseListener,
		MouseMotionListener {

	private BufferedImage image;
	private Graphics graph;
	private int x;
	private int y;
	private int x2;
	private int y2;
	private int x3;
	private int y3;

	@Override
	public void mouseDragged(MouseEvent e) {
		x2 = e.getX();
		y2 = e.getY();
		graph.drawLine(x, y, x2, y2);
		x = x2;
		y = y2;
		repaint();

	}

	@Override
	public void mouseMoved(MouseEvent e) {

	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		graph.drawArc(x, y, 60, 60, 0, 360);
		repaint();

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		x3 = e.getX();
		y3 = e.getY();
		graph.drawArc(x3, y3, 60, 60, 0, 360);
		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	public MyDraw() throws HeadlessException {
		super();
		init();

	}

	@Override
	public void paint(Graphics g) {

		super.paint(g);
		g.drawImage(image, 0, 0, null);
	}

	private void init() {
		setBounds(100, 100, 600, 600);
		setTitle("»­Í¼");
		getContentPane().setBackground(Color.BLACK);
		addMouseListener(this);
		addMouseMotionListener(this);
		image = new BufferedImage(600, 600, BufferedImage.TYPE_INT_ARGB);
		graph = image.getGraphics();
		graph.setColor(Color.BLUE);

	}

	public static void main(String[] args) {
		MyDraw mydraw = new MyDraw();
		mydraw.setVisible(true);

	}

}
