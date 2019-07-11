package kr.or.yi.gradle_mybatis_c3p0.ui.content;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class AbstractPanel<T> extends JPanel {
	
	public AbstractPanel(String str) {
		initComponents(str);
	}

	protected abstract void initComponents(String str); //추상클래스

	public abstract void setItem(T item); //추상클래스

	public abstract T getItem(); //추상클래스

	public abstract void clearComponent(int nextNo); //추상클래스
}
