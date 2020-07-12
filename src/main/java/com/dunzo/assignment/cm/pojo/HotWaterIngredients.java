package com.dunzo.assignment.cm.pojo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

import com.dunzo.assignment.cm.utils.Constant;
import com.dunzo.assignment.cm.utils.Utils;

public class HotWaterIngredients implements Beverage {
	private int hotWater;

	public int getHotWater() {
		return hotWater;
	}

	public void setHotWater(int hotWater) {
		this.hotWater = hotWater;
	}

	public String makeReady(TotalAvailableItem quantity) {
		AtomicReference<String> response = new AtomicReference("");
		quantity.useIngredients(beverage -> {
			List<Optional<String>> ingredients = new ArrayList<Optional<String>>();
			Collections.addAll(ingredients, quantity.isHotWaterAvailable(hotWater));

			if (Utils.isAllItemAvailable(response, ingredients, Constant.HOT_WATER)) {
				quantity.useHotWater(hotWater);
				response.set(Constant.HOT_WATER + Constant.PREPARED);
			}

		}, this);
		return response.get();
	}
}
