package com.dunzo.assignment.cm.pojo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

import com.dunzo.assignment.cm.utils.Constant;
import com.dunzo.assignment.cm.utils.Utils;

public class HotTeaIngredient implements Beverage {
	private int hotWater;
	private int gingerSyrup;
	private int sugarSyrup;
	private int teaLeavesSyrup;
	private int hotMilk;

	public int getHotWater() {
		return hotWater;
	}

	public void setHotWater(int hotWater) {
		this.hotWater = hotWater;
	}

	public int getGingerSyrup() {
		return gingerSyrup;
	}

	public void setGingerSyrup(int gingerSyrup) {
		this.gingerSyrup = gingerSyrup;
	}

	public int getSugarSyrup() {
		return sugarSyrup;
	}

	public void setSugarSyrup(int sugarSyrup) {
		this.sugarSyrup = sugarSyrup;
	}

	public int getTeaLeavesSyrup() {
		return teaLeavesSyrup;
	}

	public void setTeaLeavesSyrup(int teaLeavesSyrup) {
		this.teaLeavesSyrup = teaLeavesSyrup;
	}

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
			Collections.addAll(ingredients, quantity.isHotWaterAvailable(hotWater),
					quantity.isTeaLeavesSyrupAvailable(teaLeavesSyrup), quantity.isSugarSyrupAvailable(sugarSyrup),
					quantity.isHotMilkAvailable(hotMilk), quantity.isGingerSyrupAvailable(gingerSyrup));

			if (Utils.isAllItemAvailable(response, ingredients, Constant.HOT_TEA)) {
				quantity.useHotWater(hotWater);
				quantity.useHotMilk(hotMilk);
				quantity.useSugarSyrup(sugarSyrup);
				quantity.useGingerSyrup(gingerSyrup);
				quantity.useTeaLeavesSyrup(teaLeavesSyrup);
				response.set(Constant.HOT_TEA + Constant.PREPARED);
			}

		}, this);
		return response.get();
	}
}
