package kr.or.yi.gradle_mybatis_c3p0;

import java.awt.EventQueue;

import javax.swing.UIManager;

public class ErpMain {

	public static void main(String[] args) {
		try {
			// select Look and Feel
			UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
			// start application
		} catch (Exception ex) {
			ex.printStackTrace();
		} //반드시 수행하기 전에 해줘야 한다!!!!
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ErpApplication frame = new ErpApplication();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
}
