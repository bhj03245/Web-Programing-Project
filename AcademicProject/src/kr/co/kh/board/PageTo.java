package kr.co.kh.board;

import java.io.Serializable;
import java.util.ArrayList;

public class PageTo implements Serializable {
	private ArrayList<BoardDTO> list;
	private int curPage; //���� ������ ��ȣ
	private int perPage; //�������� ������ ���ڵ� ����
	private int totalCount; //��ü ���ڵ� ����
	
	public PageTo() {
		 this.perPage = 5;
	}
	
	public PageTo(ArrayList<BoardDTO> list, int curPage, int perPage, int totalCount) {
		super();
		this.list = list;
		this.curPage = curPage;
		this.perPage = perPage;
		this.totalCount = totalCount;
	}
	
	public ArrayList<BoardDTO> getList() {
		return list;
	}
	public void setList(ArrayList<BoardDTO> list) {
		this.list = list;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getPerPage() {
		return perPage;
	}
	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	@Override
	public String toString() {
		return "PageTo [list=" + list + ", curPage=" + curPage + ", perPage=" + perPage + ", totalCount=" + totalCount
				+ "]";
	}
}
