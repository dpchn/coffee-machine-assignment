package com.dunzo.assigment.cm.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.dunzo.assignment.cm.pojo.Beverage;
import com.dunzo.assignment.cm.pojo.Inputs;
import com.dunzo.assignment.cm.pojo.TotalAvailableItem;
import com.dunzo.assignment.cm.utils.Constant;
import com.dunzo.assignment.cm.utils.Utils;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

public class MachineService {

	private ObjectMapper mapper;

	public MachineService() {
		mapper = new ObjectMapper();
		mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
		mapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	public void startMachine() {
		try {
			ClassLoader classLoader = ClassLoader.getSystemClassLoader();
			File file = new File(classLoader.getResource(Constant.fileName).getFile());
			Inputs input = mapper.readValue(file, Inputs.class);
			List<Beverage> beverages = new ArrayList<>();
			for (Map.Entry<String, Map<String, Integer>> beverage : input.getBeverages().entrySet()) {
				Class<? extends Beverage> beverageClassType = Utils.resolveBeverageNameWIthClass(beverage.getKey());
				beverages.add(mapper.convertValue(beverage.getValue(), beverageClassType));
			}
			List<String> responses = prepareBeverages(input, beverages);
			for (String response : responses) {
				System.out.println(response);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method to request to make ready beverages
	 * @param input - List of total available items and outlets to make beverages
	 * @param beverages - list of requested beverages to make ready
	 * @return
	 */
	private List<String> prepareBeverages(Inputs input, List<Beverage> beverages) {
		List<String> responses = new ArrayList<>();
		int noOfThreads = input.getOutlets().get("count_n");
		ExecutorService executorService = Executors.newFixedThreadPool(noOfThreads);
		List<Future<?>> futures = new ArrayList<Future<?>>(noOfThreads);
		for (Beverage beverage : beverages) {
			futures.add(executorService.submit(new Runnable() {
				@Override
				public void run() {
					responses.add(beverage.makeReady(input.getTotalAvailableItem()));
				}
			}));
		}
		try {
			for (Future<?> f : futures) {
				f.get();
			}
			executorService.shutdown();
		//	TotalAvailableItem.getInstance().refillItem(input.getTotalAvailableItem(), null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responses;
	}
}
