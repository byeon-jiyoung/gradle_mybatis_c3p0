package kr.or.yi.gradle_mybatis_c3p0;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.yi.gradle_mybatis_c3p0.dto.Title;
import kr.or.yi.gradle_mybatis_c3p0.ui.AbstractFrameUI;
import kr.or.yi.gradle_mybatis_c3p0.ui.DepartmentFrameUI_before;
import kr.or.yi.gradle_mybatis_c3p0.ui.TitleFrameUI;
import kr.or.yi.gradle_mybatis_c3p0.ui.TitleFrameUI_before;


@SuppressWarnings("serial")
public class ErpApplication extends JFrame implements ActionListener {
	private JPanel contentPane;
	private JButton btnTitle;
	private JButton btnDept;

	public ErpApplication() {
		initComponents();
	}
	private void initComponents() {
		setTitle("ERP 관리프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 110);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 10, 0));
		
		btnTitle = new JButton("직책관리");
		btnTitle.addActionListener(this);
		
		btnDept = new JButton("부서관리");
		btnDept.addActionListener(this);
		contentPane.add(btnDept);
		contentPane.add(btnTitle);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnDept) {
			actionPerformedBtnDept(e);
		}
		if (e.getSource() == btnTitle) {
			actionPerformedBtnTitle(e);
		}

	}

	protected void actionPerformedBtnTitle(ActionEvent e) {
		AbstractFrameUI<Title> frame = new TitleFrameUI("직책관리");
		frame.setVisible(true);
	}
	
	protected void actionPerformedBtnDept(ActionEvent e) {
		DepartmentFrameUI_before frame = new DepartmentFrameUI_before();
		frame.setVisible(true);
	}
}
