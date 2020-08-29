package com.swheroes.api;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonView;

import com.swheroes.api.model.SwHero;

public class ResponseWrapper {

	@JsonView(RequestView.SwHeroGetList.class)
	private int count;
	@JsonView(RequestView.SwHeroGetList.class)
	private int page;
	@JsonView(RequestView.SwHeroGetList.class)
	private List<SwHero> elements;

    public ResponseWrapper(List<SwHero> elements) {
        this.setElements(elements);
    }

	public ResponseWrapper(List<SwHero> elements, int count, int page) {
		this.elements = elements;
		this.count = count;
		this.page = page;
	}

	public List<SwHero> getElements() {
		return elements;
	}

	public void setElements(List<SwHero> elements) {
		this.elements = elements;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
}
