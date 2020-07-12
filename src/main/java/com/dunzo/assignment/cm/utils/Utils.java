package com.dunzo.assignment.cm.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

import com.dunzo.assignment.cm.pojo.Beverage;
import com.dunzo.assignment.cm.pojo.BlackTeaIngredient;
import com.dunzo.assignment.cm.pojo.CoffeeIngredients;
import com.dunzo.assignment.cm.pojo.ElaichiTeaIngredients;
import com.dunzo.assignment.cm.pojo.GingerTeaIngredients;
import com.dunzo.assignment.cm.pojo.GreenTeaIngredient;
import com.dunzo.assignment.cm.pojo.HotMilkIngredients;
import com.dunzo.assignment.cm.pojo.HotTeaIngredient;
import com.dunzo.assignment.cm.pojo.HotWaterIngredients;
import com.dunzo.assignment.cm.pojo.TotalAvailableItem;

public class Utils {

	/**
	 * Method to check availability of ingredients 
	 * @param message
	 * @param ingredients
	 * @param beverage
	 * @return
	 */
	public static boolean isAllItemAvailable(AtomicReference<String> message, List<Optional<String>> ingredients,
			String beverage) {
		for (Optional<String> item : ingredients) {
			if (item.isPresent()) {
				synchronized (TotalAvailableItem.class) {
					message.set(beverage + Constant.NOT_PREPARED + item.get());
					return false;
				}
			}
		}
		return true;
	}
	
	public static Class<? extends Beverage> resolveBeverageNameWIthClass(String key) {
		return beverageClassMapping.get(key);
	}
	
	
	/**
	 * Class mapped with JSON key to identify beverages
	 */
	private static Map<String, Class<? extends Beverage>> beverageClassMapping = null;
	static {
		beverageClassMapping = new HashMap<String, Class<? extends Beverage>>();
		beverageClassMapping.put(Constant.HOT_COFFEE, CoffeeIngredients.class);
		beverageClassMapping.put(Constant.BLACK_TEA, BlackTeaIngredient.class);
		beverageClassMapping.put(Constant.ELAICHI_TEA, ElaichiTeaIngredients.class);
		beverageClassMapping.put(Constant.GREEN_TEA, GreenTeaIngredient.class);
		beverageClassMapping.put(Constant.GINGER_TEA, GingerTeaIngredients.class);
		beverageClassMapping.put(Constant.HOT_TEA, HotTeaIngredient.class);
		beverageClassMapping.put(Constant.HOT_MILK, HotMilkIngredients.class);
		beverageClassMapping.put(Constant.HOT_WATER, HotWaterIngredients.class);
	}
}
