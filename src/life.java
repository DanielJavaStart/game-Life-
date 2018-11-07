import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;


public class life extends JPanel implements  MouseListener,MouseMotionListener,ActionListener {
int[][]world= new int[100][100];
int generation=0,x,y,call=6;
Timer t= new Timer(50,this);
boolean start = true;

public life(){
	t.start();
	create();
	addMouseListener(this);
	addMouseMotionListener(this);
}
public void create(){
	for(int i=5;i<96;i++){
		for(int j=5;j<96;j++){
		if(new Random().nextInt(225)==4 && call>0){
			world[i][j]=1;
			world[i-1][j-1]=1;
			world[i+1][j+1]=1;
			world[i-1][j-2]=1;
			world[i+1][j+2]=1;

			world[i-1][j-3]=1;
			world[i+1][j+3]=1;
			world[i][j+4]=1;
			
			call--;
		}
		}
	}
}
@Override
public void mouseMoved(MouseEvent e) {
	

}

@Override
public void mouseClicked(MouseEvent e) {
	
	int Mx = e.getX();
	int My = e.getY();
	if(Mx>0 && Mx<5  && My>0 && My<5){
		start = true;
		
	}
	x=0;y=0;
	for(int i=0;i<100;i++){
		for(int j=0;j<100;j++){
		if(Mx>=x && Mx<=x+5 && My>=y && My<=y+5){
			world[i][j]=1;
			
		}
		x+=5;
		}
		y+=5;
		x=0;
	}
}

@Override
public void mousePressed(MouseEvent e) {
	
	
}

@Override
public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseDragged(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
public void check(){
	for(int i=0;i<100;i++){
		for(int j=0;j<100;j++){
			if(start){
			if(world[i][j]==0  && i>=2 && i<=98 && j>=2 && j<=98){
				int ch=0;
				if(world[i-1][j+1]==1 ){
					ch+=1;
				}
				if(world[i][j+1]==1){
					ch+=1;
				}
				if(world[i+1][j+1]==1 ){
					ch+=1;
				}
				if(world[i+1][j]==1 ){
					ch+=1;
				}
				if(world[i-1][j-1]==1 ){
					ch+=1;
				}
				if( world[i][j-1]==1){
					ch+=1;
				}
				if(world[i-1][j]==1 ){
					ch+=1;
				}
				
				if(ch==3){
					world[i][j]=1;
				}
			}
			if(world[i][j]==2  && i>=2 && i<=98 && j>=2 && j<=98){
				int ch=0;
				if(world[i-1][j+1]==1 ){
					ch+=1;
				}
				if(world[i][j+1]==1){
					ch+=1;
				}
				if(world[i+1][j+1]==1 ){
					ch+=1;
				}
				if(world[i+1][j]==1 ){
					ch+=1;
				}
				if(world[i-1][j-1]==1 ){
					ch+=1;
				}
				if( world[i][j-1]==1){
					ch+=1;
				}
				if(world[i-1][j]==1 ){
					ch+=1;
				}
				
				if(ch==3){
					world[i][j]=1;
				}
			}
			
			}
		}
	}
}
public void checkDeath(){
	for(int i=0;i<100;i++){
		for(int j=0;j<100;j++){
			if(start){
if(world[i][j]==1 && i>=1 && i<=98 && j>=1 && j<=98){
	int ch=0;
	if(world[i-1][j+1]==1 ){
		ch+=1;
	}
	if(world[i][j+1]==1){
		ch+=1;
	}
	if(world[i+1][j+1]==1 ){
		ch+=1;
	}
	if(world[i+1][j]==1 ){
		ch+=1;
	}
	if(world[i-1][j-1]==1 ){
		ch+=1;
	}
	if( world[i][j-1]==1){
		ch+=1;
	}
	if(world[i-1][j]==1 ){
		ch+=1;
	}
	
	if(ch<2){
		world[i][j]=2;
	}
	if(ch>3){
		world[i][j]=2;
	}
	if(ch>=2 && ch<=3){
		world[i][j]=1;
	}
}
			}
			}
		}
	}
public void paint(Graphics g){
	x=0;y=0;
	for(int i=0;i<100;i++){
		for(int j=0;j<100;j++){
		if(world[i][j]==1){
			g.setColor(Color.blue);
			g.fillRect(x, y, 5, 5);
		}
		if(world[i][j]==0){
			g.setColor(Color.white);
			g.fillRect(x, y, 5, 5);
		}
		if(world[i][j]==2){
			g.setColor(Color.green);
			g.fillRect(x, y, 5, 5);
		}
		x+=5;
		}
		y+=5;
		x=0;
	}
	Font B = new Font("Arial",2,20);
	g.setFont(B);
	g.setColor(Color.black);
	g.drawString(generation+"", 50, 500);
}
@Override
public void actionPerformed(ActionEvent e) {
	repaint();
	
	check();
	checkDeath();
	if(start)generation++;
}
}
