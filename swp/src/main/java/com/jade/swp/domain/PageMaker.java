package com.jade.swp.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.util.UriComponentsBuilder;

public class PageMaker {

	private static final Logger logger = LoggerFactory.getLogger(PageMaker.class);

	private int displayPageNum = 10;

	private int totalCount;
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;

	private Criteria criteria;

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		calcData();
	}

	private void calcData() {
		int page = this.criteria.getPage();
		int perPageNum = this.criteria.getPerPageNum();
		logger.debug("::>> page=" + page);

		this.endPage = (int) (Math.ceil(page / (double) displayPageNum) * displayPageNum);
		logger.debug("::>> endPage=" + this.endPage);
		this.startPage = (this.endPage - displayPageNum) + 1;

		int tempEndPage = (int) (Math.ceil(this.totalCount / (double) perPageNum));
		if (endPage > tempEndPage) {
			endPage = tempEndPage;
		}
		logger.debug("::>> tempEndPage, endPage=" + tempEndPage + "," + this.endPage);

		logger.debug("::>> startPage=" + this.startPage + ", " + totalCount);
		this.prev = this.startPage != 1;
		this.next = this.endPage * perPageNum < totalCount;

	}
	
	public String makeQuery(int page) {
		return makeQuery(page, true);
	}
	
	public String makeQuery(int page, boolean needSearchParam) {
		UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.newInstance();
		 uriComponentsBuilder
				.queryParam("page", page)
				.queryParam("perPageNum", this.criteria.getPerPageNum());
		 
		 if (needSearchParam) {
			 uriComponentsBuilder
			    .queryParam("keyword", this.criteria.getKeyword())
				.queryParam("searchType", this.criteria.getSearchType());
		 }
				
		return uriComponentsBuilder.build().encode().toString();
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public Criteria getCriteria() {
		return criteria;
	}

	public void setCriteria(Criteria criteria) {
		this.criteria = criteria;
	}

}
