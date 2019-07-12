package kr.or.yi.gradle_mybatis_c3p0.ui.content;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import kr.or.yi.gradle_mybatis_c3p0.dto.Title;

@SuppressWarnings("serial")
public class PanelTitle_before extends JPanel {
	private JTextField tfTitleCode;
	private JTextField tfTitleName;

	public PanelTitle_before() {
		initComponents();
	}

	private void initComponents() {
		setBorder(new TitledBorder(null, "직책 정보", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(0, 2, 10, 10));

		JLabel lblTitleNo = new JLabel("직책 번호");
		lblTitleNo.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblTitleNo);

		tfTitleCode = new JTextField();
		add(tfTitleCode);
		tfTitleCode.setColumns(10);

		JLabel lblTitleName = new JLabel("직책명");
		lblTitleName.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblTitleName);

		tfTitleName = new JTextField();
		tfTitleName.setColumns(10);
		add(tfTitleName);
	}

	public void setItem(Title Title) {
		tfTitleCode.setText(String.format("T%03d", Title.getTitleCode()));
		tfTitleName.setText(Title.getTitleName());
		tfTitleCode.setEditable(false);
	}

	public Title getItem() {
		int titleNo = Integer.parseInt(tfTitleCode.getText().trim().substring(1));
		String titleName = tfTitleName.getText().trim();
		return new Title(titleNo, titleName);
	}

	public void clearComponent(int nextNo) {
		tfTitleCode.setText(String.format("T%03d", nextNo));
		tfTitleName.setText("");
		tfTitleCode.setEditable(false);
	}

	public JTextField getTfNo() {
		return tfTitleCode;
	}

	public void setComponentAllEditable(boolean isEditable) {
		tfTitleCode.setEditable(isEditable);
		tfTitleName.setEditable(isEditable);
	}

}
