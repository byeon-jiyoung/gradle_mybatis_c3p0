package kr.or.yi.gradle_mybatis_c3p0.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import kr.or.yi.gradle_mybatis_c3p0.dao.DepartmentDao;
import kr.or.yi.gradle_mybatis_c3p0.dao.DepartmentDaoImpl;
import kr.or.yi.gradle_mybatis_c3p0.dto.Department;
import kr.or.yi.gradle_mybatis_c3p0.ui.content.AbstractPanel;
import kr.or.yi.gradle_mybatis_c3p0.ui.content.PanelDepartment_before;
import kr.or.yi.gradle_mybatis_c3p0.ui.list.AbstractList;
import kr.or.yi.gradle_mybatis_c3p0.ui.list.DepartmentList_before;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public abstract class AbstractFrameUI<T> extends JFrame implements ActionListener {
	private JButton btnAdd;
	protected AbstractPanel<T> pContent;
	protected List<T> itemList;
	protected AbstractList<T> pList;
	private JButton btnCancel;

	private JPopupMenu popupMenu;
	private JMenuItem mntmUpdate;
	private JMenuItem mntmDelete;
	
	public AbstractFrameUI(String str) {
		initDao();
		initComponents(str);
	}

	protected abstract void initDao();
	
	private void initComponents(String str) {
		setTitle(str);
		setBounds(200, 100, 450, 450);
		JPanel pMain = new JPanel();
		getContentPane().add(pMain, BorderLayout.CENTER);
		pMain.setLayout(new BorderLayout(0, 0));

		pContent = creatContentPanel();
		
		clearContent();
		pMain.add(pContent, BorderLayout.CENTER);

		JPanel pBtns = new JPanel();
		pMain.add(pBtns, BorderLayout.SOUTH);

		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		pBtns.add(btnAdd);

		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		pBtns.add(btnCancel);

		pList = createListPanel();
		reloadList();
		
		getContentPane().add(pList, BorderLayout.SOUTH);
		
		//pContent.clearComponent(1);
		
		popupMenu = new JPopupMenu();
		addPopup(pList, popupMenu);
		
		mntmUpdate = new JMenuItem("수정");
		mntmUpdate.addActionListener(this);
		popupMenu.add(mntmUpdate);
		
		mntmDelete = new JMenuItem("삭제");
		mntmDelete.addActionListener(this);
		popupMenu.add(mntmDelete);
		
		pList.setPopupMenu(popupMenu);
		
		reloadList();
		clearContent();
	}

	protected abstract AbstractList<T> createListPanel();

	protected abstract AbstractPanel<T> creatContentPanel();

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmDelete) {
			actionPerformedMntmDelete(e);
		}
		if (e.getSource() == mntmUpdate) {
			actionPerformedMntmUpdate(e);
		}
		if (e.getSource() == btnCancel) {
			actionPerformedBtnCancel(e);
		}
		if (e.getSource() == btnAdd) {
			if(e.getActionCommand().equals("추가")) {
				actionPerformedBtnAdd(e);
			}
			if(e.getActionCommand().equals("수정")) {
				actionPerformedBtnUpdate(e);
			}
		}
	}
	
	protected abstract void clearContent();

	protected void reloadList() {
		itemList = getListAll();
		pList.setItemList(itemList);
		pList.reloadData();
	}
	
	protected abstract List<T> getListAll();

	protected void refreshUI(T item, int res) {
		String msg = res==1?"성공":"실패";
		JOptionPane.showMessageDialog(null, item + msg);
		reloadList();
		clearContent();
	}
	
	private void actionPerformedBtnUpdate(ActionEvent e) {
		T updateDept = pContent.getItem();
//		int res = dao.updateDepartment(updateDept);
		int res = updateItem(updateDept);
		refreshUI(updateDept, res);
		btnAdd.setText("추가");
	}
	
	protected abstract int updateItem(T item);
	
	protected void actionPerformedBtnAdd(ActionEvent e) {
		T insertDept = pContent.getItem();
		//JOptionPane.showMessageDialog(null, insertDept);
		
//		int res = dao.insertDepartment(insertDept);
		int res = insertItem(insertDept);
		refreshUI(insertDept, res);
	}
	
	protected abstract int insertItem(T item);

	protected void actionPerformedBtnCancel(ActionEvent e) {
		clearContent();
	}

	
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	
	protected void actionPerformedMntmUpdate(ActionEvent e) {
		T upDept = pList.getSelectedItem();
		//JOptionPane.showMessageDialog(null, upDept);
		
		pContent.setItem(upDept);
		btnAdd.setText("수정");
	}
	
	protected void actionPerformedMntmDelete(ActionEvent e) {
		T delDept = pList.getSelectedItem();
		//JOptionPane.showMessageDialog(null, delDept);
		
		int res = deleteItem(delDept);
		refreshUI(delDept, res);
	}
	
	protected abstract int deleteItem(T item);
}
