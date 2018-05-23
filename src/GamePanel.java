import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class GamePanel extends JPanel implements ActionListener {
	Pocker p = new Pocker();

	JButton btnExit = new JButton("�˳�");
	JButton btnNext = new JButton("����");
	JButton btnNew = new JButton("����Ϸ");
	JButton btnTest = new JButton("���԰�ť");
	// ����һ�����������洢��ǰ��Һ͵��������µ���
	ArrayList myCard = new ArrayList();
	ArrayList cptCard = new ArrayList();
	// ��ʾ�ڼ�����
	int count = 0;
	//��Һ͵��Եķ���
	int myCore = 0;
	int cptCore = 0;
	//��Һ͵����Ƶ���ʼλ��
	int myX = 100;
	int myY = 100;
	int cptX = myX;
	int cptY = myY+150;

	public GamePanel() {

		this.setLayout(new FlowLayout());

		this.add(btnExit);
		this.add(btnNext);
		this.add(btnNew);

		btnExit.addActionListener(this);
		btnNext.addActionListener(this);
		btnNew.addActionListener(this);
		//this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnExit) {
			System.exit(0);
		} else if (e.getSource() == btnNext) {
			panduan();
			
		} else if (e.getSource() == btnNew) {
			newGame();
		}

	}
	public void panduan() {
		fapai();
		repaint();
		calMyCore();
		calCptCore();
		getResult();
	}

	public void newGame() {
		myCard.clear();
		cptCard.clear();
		myCore = 0;
		cptCore = 0;
		count = 0;
		p.xipai();
		repaint();
	}
	public void calMyCore() {
		myCore = 0;
		for (int i = 0; i < myCard.size(); i++) {
			Card c = (Card) myCard.get(i);
			myCore += c.number;
		}
		if (myCore >= 21) {
			JOptionPane.showMessageDialog(this, "����Ѿ�����", "�ƾ�", JOptionPane.INFORMATION_MESSAGE);
			newGame();
		}
	}
	public void calCptCore() {
		cptCore = 0;
		for(int i=0; i<cptCard.size(); i++) {
			Card c = (Card) cptCard.get(i);
			cptCore += c.number;
		}
	}

	private void getResult() {

	}

	@Override
	public void paint(Graphics g) {
		
		g.clearRect(0, 0, this.getWidth(), this.getHeight());
		//��������дpaint()����������£��������������ʾ������
		super.paint(g);
		for (int i = 0; i < myCard.size(); i++) {
			Card c = (Card) myCard.get(i);
			g.drawImage(c.img, myX + i * 20, myY, this);
		}
		for(int i=0; i<cptCard.size(); i++) {
			Card c = (Card) cptCard.get(i);
			g.drawImage(c.img, cptX+i*20, cptY, this);
		}
		g.drawString("��ҷ�����"+myCore, myX, myY-20);
		g.drawString("���Է�����"+cptCore, cptX, cptY - 20);

	}

	private void fapai() {
		myCard.add(p.getCard(count++));
		cptCard.add(p.getCard(count++));
	}

}
