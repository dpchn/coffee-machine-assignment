package com.dunzo.assignment.cm.pojo;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("machine")
public class Inputs {

	@JsonProperty("outlets")
	Map<String, Integer> outlets;

	@JsonProperty("total_items_quantity")
	private TotalAvailableItem totalAvailableItem;

	@JsonProperty("beverages")
	private Map<String, Map<String, Integer>> beverages;

	public Map<String, Integer> getOutlets() {
		return outlets;
	}

	public void setOutlets(Map<String, Integer> outlets) {
		this.outlets = outlets;
	}

	public TotalAvailableItem getTotalAvailableItem() {
		return totalAvailableItem;
	}

	public void setTotalAvailableItem(TotalAvailableItem totalAvailableItem) {
		this.totalAvailableItem = totalAvailableItem;
	}

	public Map<String, Map<String, Integer>> getBeverages() {
		return beverages;
	}

	public void setBeverages(Map<String, Map<String, Integer>> beverages) {
		this.beverages = beverages;
	}
}
