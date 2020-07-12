package com.dunzo.assignment.cm.pojo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Consumer;

import com.dunzo.assignment.cm.utils.Constant;

public class TotalAvailableItem {

	private int hotWater;
	private int hotMilk;
	private int gingerSyrup;
	private int sugarSyrup;
	private int teaLeavesSyrup;
	private int elaichiSyrup;
	private int greenMixture;
	private int coffeeSyrup;

	private static TotalAvailableItem instance;

	private TotalAvailableItem() {

	}

	public static TotalAvailableItem getInstance() {
		if (instance == null)
			instance = new TotalAvailableItem();
		return instance;
	}

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

	public int getElaichiSyrup() {
		return elaichiSyrup;
	}

	public void setElaichiSyrup(int elaichiSyrup) {
		this.elaichiSyrup = elaichiSyrup;
	}

	public int getGreenMixture() {
		return greenMixture;
	}

	public void setGreenMixture(int greenMixture) {
		this.greenMixture = greenMixture;
	}

	public int getCoffeeSyrup() {
		return coffeeSyrup;
	}

	public void setCoffeeSyrup(int coffeeSyrup) {
		this.coffeeSyrup = coffeeSyrup;
	}

	public void addHotWater(int hotWater) {
		this.hotWater += hotWater;
	}

	public void addHotMilk(int hotMilk) {
		this.hotMilk += hotMilk;
	}

	public void addHotGingerSyrup(int gingerSyrup) {
		this.gingerSyrup += gingerSyrup;
	}

	public void addSugarSyrup(int sugarSyrup) {
		this.sugarSyrup += sugarSyrup;
	}

	public void addTeaLeavesSyrup(int teaLeavesSyrup) {
		this.teaLeavesSyrup += teaLeavesSyrup;
	}

	public void addElaichiSyrup(int elaichiSyrup) {
		this.elaichiSyrup += elaichiSyrup;
	}

	public void addGreenMixture(int greenMixture) {
		this.greenMixture += greenMixture;
	}

	public void addGingerSyrup(int gingerSyrup) {
		this.gingerSyrup += gingerSyrup;
	}

	public void addCoffeeSyrup(int coffeeSyrup) {
		this.coffeeSyrup += coffeeSyrup;
	}

	public void useHotWater(int hotWater) {
		this.hotWater -= hotWater;
	}

	public void useHotMilk(int hotMilk) {
		this.hotMilk -= hotMilk;
	}

	public void useHotGingerSyrup(int gingerSyrup) {
		this.gingerSyrup -= gingerSyrup;
	}

	public void useSugarSyrup(int sugarSyrup) {
		this.sugarSyrup -= sugarSyrup;
	}

	public void useTeaLeavesSyrup(int teaLeavesSyrup) {
		this.teaLeavesSyrup -= teaLeavesSyrup;
	}

	public void useElaichiSyrup(int elaichiSyrup) {
		this.elaichiSyrup -= elaichiSyrup;
	}

	public void useGreenMixture(int greenMixture) {
		this.greenMixture -= greenMixture;
	}

	public void useGingerSyrup(int gingerSyrup) {
		this.gingerSyrup -= gingerSyrup;
	}

	public void useCoffeeSyrup(int coffeeSyrup) {
		this.coffeeSyrup -= coffeeSyrup;
	}

	public static void setInstance(TotalAvailableItem instance) {
		TotalAvailableItem.instance = instance;
	}

	public Optional<String> isHotWaterAvailable(int hotWater) {
		if (this.hotWater == 0)
			return Optional.of(Constant.HOT_WATER + Constant.NOT_AVAILABLE);
		else if (this.hotWater < hotWater)
			return Optional.of(Constant.HOT_WATER + Constant.NOT_SUFFICIENT);
		return Optional.empty();
	}

	public Optional<String> isHotMilkAvailable(int hotMilk) {
		if (this.hotMilk == 0)
			return Optional.of(Constant.HOT_MILK + Constant.NOT_AVAILABLE);
		else if (this.hotMilk < hotMilk)
			return Optional.of(Constant.HOT_MILK + Constant.NOT_SUFFICIENT);
		return Optional.empty();
	}

	public Optional<String> isGingerSyrupAvailable(int gingerSyrup) {
		if (this.gingerSyrup == 0)
			return Optional.of(Constant.GINGER_SYRUP + Constant.NOT_AVAILABLE);
		else if (this.gingerSyrup < gingerSyrup)
			return Optional.of(Constant.GINGER_SYRUP + Constant.NOT_SUFFICIENT);
		return Optional.empty();
	}

	public Optional<String> isSugarSyrupAvailable(int sugarSyrup) {
		if (this.sugarSyrup == 0)
			return Optional.of(Constant.SUGAR_SYRUP + Constant.NOT_AVAILABLE);
		else if (this.sugarSyrup < sugarSyrup)
			return Optional.of(Constant.SUGAR_SYRUP + Constant.NOT_SUFFICIENT);
		return Optional.empty();
	}

	public Optional<String> isTeaLeavesSyrupAvailable(int teaLeavesSyrup) {
		if (this.teaLeavesSyrup == 0)
			return Optional.of(Constant.TEA_LEAVES_SYRUP + Constant.NOT_AVAILABLE);
		else if (this.teaLeavesSyrup < teaLeavesSyrup)
			return Optional.of(Constant.TEA_LEAVES_SYRUP + Constant.NOT_SUFFICIENT);
		return Optional.empty();
	}

	public Optional<String> isElaichiSyrupAvailable(int elaichiSyrup) {
		if (this.elaichiSyrup == 0)
			return Optional.of(Constant.ELAICHI_SYRUP + Constant.NOT_AVAILABLE);
		else if (this.elaichiSyrup < elaichiSyrup)
			return Optional.of(Constant.ELAICHI_SYRUP + Constant.NOT_SUFFICIENT);
		return Optional.empty();
	}

	public Optional<String> isGreenMixtureAvailable(int greenMixture) {
		if (this.greenMixture == 0)
			return Optional.of(Constant.GREEN_MIXTURE + Constant.NOT_AVAILABLE);
		else if (this.greenMixture < greenMixture)
			return Optional.of(Constant.GREEN_MIXTURE + Constant.NOT_SUFFICIENT);
		return Optional.empty();
	}

	public Optional<String> isCoffeeSyrupAvailable(int coffeeSyrup) {
		if (this.coffeeSyrup == 0)
			return Optional.of(Constant.COFFEE_SYRUP + Constant.NOT_AVAILABLE);
		else if (this.coffeeSyrup < coffeeSyrup)
			return Optional.of(Constant.COFFEE_SYRUP + Constant.NOT_SUFFICIENT);
		return Optional.empty();
	}

	public synchronized void useIngredients(Consumer<Beverage> consumer, Beverage beverage) {
		consumer.accept(beverage);
	}
	
	
	
	

	public Optional<Map<String, Integer>> checkHotWater() {
		if (this.hotWater < Constant.MIN_QUANTITY_INDICATOR_FOR_HOT_WATER) {
			Map<String, Integer> ma = new HashMap<String, Integer>();
			ma.put(Constant.WATER, hotWater);
			return Optional.of(ma);
		}
		return Optional.empty();
	}

	public Optional<Map<String, Integer>> checkHotMilk() {
		if (this.hotMilk < Constant.MIN_QUANTITY_INDICATOR_FOR_HOT_MILK){
			Map<String, Integer> ma = new HashMap<String, Integer>();
			ma.put(Constant.MILK, hotMilk);
			return Optional.of(ma);
		}
		return Optional.empty();
	}

	public Optional<Map<String, Integer>> checkGingerSyrup() {
		if (this.gingerSyrup < Constant.MIN_QUANTITY_INDICATOR_FOR_GINGER_SYRUP){
			Map<String, Integer> ma = new HashMap<String, Integer>();
			ma.put(Constant.GINGER_SYRUP, gingerSyrup);
			return Optional.of(ma);
		}
		return Optional.empty();
	}

	public Optional<Map<String, Integer>> checkSugerSyrup() {
		if (this.sugarSyrup < Constant.MIN_QUANTITY_INDICATOR_FOR_SUGAR_SYRUP){
			Map<String, Integer> ma = new HashMap<String, Integer>();
			ma.put(Constant.SUGAR_SYRUP, sugarSyrup);
			return Optional.of(ma);
		}
		return Optional.empty();
	}

	public Optional<Map<String, Integer>> checkTeaLeaves() {
		if (this.teaLeavesSyrup < Constant.MIN_QUANTITY_INDICATOR_FOR_TEA_LEAVES_SYRUP){
			Map<String, Integer> ma = new HashMap<String, Integer>();
			ma.put(Constant.TEA_LEAVES_SYRUP, teaLeavesSyrup);
			return Optional.of(ma);
		}
		return Optional.empty();
	}

	public Optional<Map<String, Integer>> checkElaichi() {
		if (this.elaichiSyrup < Constant.MIN_QUANTITY_INDICATOR_FOR_ELAICHI_SYRUP){
			Map<String, Integer> ma = new HashMap<String, Integer>();
			ma.put(Constant.ELAICHI_SYRUP, elaichiSyrup);
			return Optional.of(ma);
		}
		return Optional.empty();
	}

	public Optional<Map<String, Integer>> checkGreeMixture() {
		if (this.greenMixture < Constant.MIN_QUANTITY_INDICATOR_FOR_GREEN_MIXTURE){
			Map<String, Integer> ma = new HashMap<String, Integer>();
			ma.put(Constant.GREEN_MIXTURE, greenMixture);
			return Optional.of(ma);
		}
		return Optional.empty();
	}

	public Optional<Map<String, Integer>> checkCoffeeSyrup() {
		if (this.coffeeSyrup < Constant.MIN_QUANTITY_INDICATOR_FOR_COFFEE_SYRUP){
			Map<String, Integer> ma = new HashMap<String, Integer>();
			ma.put(Constant.COFFEE_SYRUP, coffeeSyrup);
			return Optional.of(ma);
		}
		return Optional.empty();
	}

	
	
	/**
	 * Method to check mini quantity and refill further if needed
	 * @param items
	 * @param refillItem
	 */
	public void refillItem(TotalAvailableItem items, TotalAvailableItem refillItem) {
		List<Optional<Map<String, Integer>>> ingredients = new ArrayList<Optional<Map<String,Integer>>>();
		Collections.addAll(ingredients, items.checkHotWater(), items.checkHotMilk(),
				items.checkCoffeeSyrup(), items.checkElaichi(),
				items.checkGingerSyrup(), items.checkGreeMixture(),
				items.checkTeaLeaves(), items.checkSugerSyrup());
		for (Optional<Map<String, Integer>> re : ingredients) {
			if(re.isPresent()) {
				for (Entry<String, Integer> entry : re.get().entrySet()) {
					if (entry.getKey().equals(Constant.WATER))
						addHotWater(refillItem.getHotWater());
					if (entry.getKey().equals(Constant.MILK))
						addHotMilk(refillItem.getHotMilk());
					if (entry.getKey().equals(Constant.COFFEE_SYRUP))
						addCoffeeSyrup(refillItem.getCoffeeSyrup());
					if (entry.getKey().equals(Constant.GINGER_SYRUP))
						addGingerSyrup(refillItem.getGingerSyrup());
					if (entry.getKey().equals(Constant.ELAICHI_SYRUP))
						addElaichiSyrup(refillItem.getElaichiSyrup());
					if (entry.getKey().equals(Constant.GREEN_MIXTURE))
						addGreenMixture(refillItem.getGreenMixture());
					if (entry.getKey().equals(Constant.TEA_LEAVES_SYRUP))
						addTeaLeavesSyrup(refillItem.getTeaLeavesSyrup());
					if (entry.getKey().equals(Constant.SUGAR_SYRUP))
						addSugarSyrup(refillItem.getSugarSyrup());
				}
			}
		}
	}
}
