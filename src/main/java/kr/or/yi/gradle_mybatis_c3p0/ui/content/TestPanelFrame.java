package kr.or.yi.gradle_mybatis_c3p0.ui.content;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.yi.gradle_mybatis_c3p0.dao.DepartmentDao;
import kr.or.yi.gradle_mybatis_c3p0.dao.DepartmentDaoImpl;
import kr.or.yi.gradle_mybatis_c3p0.dao.EmployeeDao;
import kr.or.yi.gradle_mybatis_c3p0.dao.EmployeeDaoImpl;
import kr.or.yi.gradle_mybatis_c3p0.dao.TitleDao;
import kr.or.yi.gradle_mybatis_c3p0.dao.TitleDaoImpl;
import kr.or.yi.gradle_mybatis_c3p0.dto.Department;
import kr.or.yi.gradle_mybatis_c3p0.dto.Employee;
import kr.or.yi.gradle_mybatis_c3p0.dto.Title;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;

public class TestPanelFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private PanelEmployee panel;
	private JButton btnSet;
	private JButton btnClear;
	private JButton btnGet;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestPanelFrame frame = new TestPanelFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TestPanelFrame() {
		initComponents();
	}
	
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//--------------------
//		EmployeeDao empDao = new EmployeeDaoImpl();
		DepartmentDao deptDao = new DepartmentDaoImpl();
		TitleDao titleDao = new TitleDaoImpl();
		//--------------------
		
		panel = new PanelEmployee();
		//--------------------
		panel.setDeptList(deptDao.selectDepartmentByAll()); //부서목록 불러오기
		panel.setTitleList(titleDao.selectTitleByAll()); //직책목록 불러오기
		//--------------------
		contentPane.add(panel, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		btnSet = new JButton("설정");
		btnSet.addActionListener(this);
		panel_1.add(btnSet);
		
		btnGet = new JButton("가져오기");
		btnGet.addActionListener(this);
		panel_1.add(btnGet);
		
		btnClear = new JButton("취소");
		btnClear.addActionListener(this);
		panel_1.add(btnClear);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGet) {
			actionPerformedBtnGet(e);
		}
		if (e.getSource() == btnClear) {
			actionPerformedBtnClear(e);
		}
		if (e.getSource() == btnSet) {
			actionPerformedBtnSet(e);
		}
	}
	
	protected void actionPerformedBtnSet(ActionEvent e) {
		Employee emp = new Employee(1234, "변지영", 5000000, new Department(1), false, new Date(), new Title(1));
		panel.setItem(emp);
	}
	
	protected void actionPerformedBtnClear(ActionEvent e) {
		EmployeeDao empDao = new EmployeeDaoImpl();
		panel.clearComponent(empDao.selectEmployeeByAll().size()+1);
	}
	
	protected void actionPerformedBtnGet(ActionEvent e) {
		Employee emp =  panel.getItem();
		JOptionPane.showMessageDialog(null, emp);
	}
}
