package kr.or.yi.gradle_mybatis_c3p0.dao;

import java.util.List;

import kr.or.yi.gradle_mybatis_c3p0.dto.Title;

public interface TitleDao {
	List<Title> selectTitleByAll();
	int insertTitle(Title title);
	int deleteTitle(Title title);
					//책에는 int로 넘겨줬지만, 원래 겍체로 넘겨주는게 맞다.
	int updateTitle(Title title);
	Title selectTitleByCode(Title title);
}
