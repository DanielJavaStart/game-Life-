import javax.swing.JFrame;


public class Main {

	public static void main(String[] args) {
		JFrame f = new JFrame("life");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(600, 600);
        f.add(new life());
        f.setVisible(true);
	}

}
