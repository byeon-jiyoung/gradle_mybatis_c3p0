package kr.or.yi.gradle_mybatis_c3p0.dao;

import java.util.List;

import kr.or.yi.gradle_mybatis_c3p0.dto.Title;

public interface TitleDao {
	List<Title> selectTitleByAll();
}
