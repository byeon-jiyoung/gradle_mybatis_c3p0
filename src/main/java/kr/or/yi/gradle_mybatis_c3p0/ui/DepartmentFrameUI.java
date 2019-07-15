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
import kr.or.yi.gradle_mybatis_c3p0.dto.Title;
import kr.or.yi.gradle_mybatis_c3p0.ui.content.AbstractPanel;
import kr.or.yi.gradle_mybatis_c3p0.ui.content.PanelDepartment;
import kr.or.yi.gradle_mybatis_c3p0.ui.content.PanelDepartment_before;
import kr.or.yi.gradle_mybatis_c3p0.ui.list.AbstractList;
import kr.or.yi.gradle_mybatis_c3p0.ui.list.DepartmentList;
import kr.or.yi.gradle_mybatis_c3p0.ui.list.DepartmentList_before;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class DepartmentFrameUI  extends AbstractFrameUI<Department> {
	private DepartmentDao dao;

	public DepartmentFrameUI(String dept) {
		super(dept);
	}

	@Override
	protected void initDao() {
		dao = new DepartmentDaoImpl();
	}

	@Override
	protected AbstractList<Department> createListPanel() {
		return new DepartmentList();
	}

	@Override
	protected AbstractPanel<Department> createContentPanel() {
		return new PanelDepartment("부서 정보");
	}
	
	@Override
	protected void clearContent() {
		pContent.clearComponent(itemList.size() == 0 ? 1 : itemList.size() + 1);
	}

	@Override
	protected List<Department> getListAll() {
		return dao.selectDepartmentByAll();
	}

	@Override
	protected int updateItem(Department item) {
		return dao.updateDepartment(item);
	}

	@Override
	protected int insertItem(Department item) {
		return dao.insertDepartment(item);
	}

	@Override
	protected int deleteItem(Department item) {
		return dao.deleteDepartment(item);
	}
}
