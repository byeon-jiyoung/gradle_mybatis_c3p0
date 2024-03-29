package kr.or.yi.gradle_mybatis_c3p0.ui.content;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import kr.or.yi.gradle_mybatis_c3p0.dto.Department;

@SuppressWarnings("serial")
public class PanelDepartment extends AbstractPanel<Department> {
	private JTextField tfDeptCode;
	private JTextField tfDeptName;
	private JTextField tfFloor;

	public PanelDepartment(String dept) {
		super(dept);
	}
	
	@Override
	protected void initComponents(String dept) {
		setBorder(new TitledBorder(null, dept + " 정보", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(0, 2, 10, 10));

		JLabel lblDeptCode = new JLabel("부서 번호");
		lblDeptCode.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblDeptCode);

		tfDeptCode = new JTextField();
		add(tfDeptCode);
		tfDeptCode.setColumns(10);

		JLabel lblDeptName = new JLabel("부서명");
		lblDeptName.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblDeptName);

		tfDeptName = new JTextField();
		tfDeptName.setColumns(10);
		add(tfDeptName);
		
		JLabel lblFloor = new JLabel("위치(층)");
		lblFloor.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblFloor);
		
		tfFloor = new JTextField();
		tfFloor.setColumns(10);
		add(tfFloor);
	}
	
	@Override
	public void setItem(Department dept) {
		tfDeptCode.setText(String.format("D%03d", dept.getDeptCode()));
		tfDeptName.setText(dept.getDeptName());
		tfFloor.setText(dept.getFloor()+"");
		tfDeptCode.setEditable(false);
	}
	
	@Override
	public Department getItem() {
		int deptNo = Integer.parseInt(tfDeptCode.getText().trim().substring(1));
		String deptName = tfDeptName.getText().trim();
		int floor = Integer.parseInt(tfFloor.getText().trim());
		return new Department(deptNo, deptName, floor);
	}
	
	@Override
	public void clearComponent(int nextNo) {
		tfDeptCode.setText(String.format("D%03d", nextNo));
		tfDeptName.setText("");
		tfFloor.setText("");
		tfDeptCode.setEditable(false);
	}

}
