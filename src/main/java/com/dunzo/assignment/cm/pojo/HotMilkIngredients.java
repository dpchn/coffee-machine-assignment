package com.dunzo.assignment.cm.pojo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

import com.dunzo.assignment.cm.utils.Constant;
import com.dunzo.assignment.cm.utils.Utils;

public class HotMilkIngredients implements Beverage {
	private int hotMilk;

	public int getHotMilk() {
		return hotMilk;
	}

	public void setHotMilk(int hotMilk) {
		this.hotMilk = hotMilk;
	}

	public String makeReady(TotalAvailableItem quantity) {
		AtomicReference<String> response = new AtomicReference("");
		quantity.useIngredients(beverage -> {
			List<Optional<String>> ingredients = new ArrayList<Optional<String>>();
			Collections.addAll(ingredients, quantity.isHotMilkAvailable(hotMilk));

			if (Utils.isAllItemAvailable(response, ingredients, Constant.HOT_MILK)) {
				quantity.useHotMilk(hotMilk);
				response.set(Constant.HOT_MILK + Constant.PREPARED);
			}

		}, this);
		return response.get();
	}
}
