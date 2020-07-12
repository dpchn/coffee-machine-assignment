package com.dunzo.assignment.cm.pojo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

import com.dunzo.assignment.cm.utils.Constant;
import com.dunzo.assignment.cm.utils.Utils;

public class CoffeeIngredients implements Beverage {
	private int hotWater;
	private int hotMilk;
	private int sugarSyrup;
	//private int coffeeSyrup;
	private int teaLeavesSyrup;
	private int gingerSyrup;

	public int getHotWater() {
		return hotWater;
	}

	public void setHotWater(int hotWater) {
		this.hotWater = hotWater;
	}

	public int getHotMilk() {
		return hotMilk;
	}

	public void setHotMilk(int hotMilk) {
		this.hotMilk = hotMilk;
	}

	public int getSugarSyrup() {
		return sugarSyrup;
	}

	public void setSugarSyrup(int sugarSyrup) {
		this.sugarSyrup = sugarSyrup;
	}

	
	/*
	 * public int getCoffeeSyrup() { return coffeeSyrup; }
	 * 
	 * public void setCoffeeSyrup(int coffeeSyrup) { this.coffeeSyrup = coffeeSyrup;
	 * }
	 */


	public int getTeaLeavesSyrup() {
		return teaLeavesSyrup;
	}

	public void setTeaLeavesSyrup(int teaLeavesSyrup) {
		this.teaLeavesSyrup = teaLeavesSyrup;
	}
	
	public int getGingerSyrup() {
		return gingerSyrup;
	}

	public void setGingerSyrup(int gingerSyrup) {
		this.gingerSyrup = gingerSyrup;
	}

	public String makeReady(TotalAvailableItem quantity) {
		AtomicReference<String> response = new AtomicReference("");
		quantity.useIngredients(beverage -> {
			List<Optional<String>> ingredients = new ArrayList<Optional<String>>();
			Collections.addAll(ingredients, quantity.isHotWaterAvailable(hotWater),
					quantity.isTeaLeavesSyrupAvailable(teaLeavesSyrup), quantity.isSugarSyrupAvailable(sugarSyrup),
					quantity.isHotMilkAvailable(hotMilk), quantity.isGingerSyrupAvailable(gingerSyrup));

			if (Utils.isAllItemAvailable(response, ingredients, Constant.HOT_COFFEE)) {
				quantity.useHotWater(hotWater);
				quantity.useHotMilk(hotMilk);
				quantity.useSugarSyrup(sugarSyrup);
				quantity.useTeaLeavesSyrup(teaLeavesSyrup);
				quantity.useGingerSyrup(gingerSyrup);
				response.set(Constant.HOT_COFFEE + Constant.PREPARED);
			}

		}, this);
		return response.get();
	}

}
