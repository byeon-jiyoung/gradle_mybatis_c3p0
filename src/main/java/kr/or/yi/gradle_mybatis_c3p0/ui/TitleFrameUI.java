package kr.or.yi.gradle_mybatis_c3p0.ui;

import java.util.List;

import kr.or.yi.gradle_mybatis_c3p0.dao.TitleDao;
import kr.or.yi.gradle_mybatis_c3p0.dao.TitleDaoImpl;
import kr.or.yi.gradle_mybatis_c3p0.dto.Title;
import kr.or.yi.gradle_mybatis_c3p0.ui.content.AbstractPanel;
import kr.or.yi.gradle_mybatis_c3p0.ui.content.PanelTitle;
import kr.or.yi.gradle_mybatis_c3p0.ui.list.AbstractList;
import kr.or.yi.gradle_mybatis_c3p0.ui.list.TitleList;


@SuppressWarnings("serial")
public class TitleFrameUI extends AbstractFrameUI<Title> {
	private TitleDao dao;
	
	public TitleFrameUI(String title) {
		super(title);
	}
	
	@Override
	protected  void initDao() {
		dao = new TitleDaoImpl();
	}
	
	@Override
	protected AbstractList<Title> createListPanel(){
//		return new TitleList("직책 목록");
		return new TitleList();
	}
	
	@Override
	protected AbstractPanel<Title> createContentPanel(){
		return new PanelTitle("직책 정보");
	}

	@Override
	protected void clearContent() {
		pContent.clearComponent(itemList.size() == 0 ? 1 : itemList.size() + 1);
	}
	
	@Override
	public List<Title> getListAll(){
		return dao.selectTitleByAll();
	}
	
	@Override
	protected int updateItem(Title item) {
		return dao.updateTitle(item);
	}

	@Override
	protected int insertItem(Title item) {
		return dao.insertTitle(item);
	}
	
	@Override
	protected int deleteItem(Title item) {
		return dao.deleteTitle(item);
	}
}
