package com.dunzo.assigment.cm.application;

import com.dunzo.assigment.cm.service.MachineService;
import com.dunzo.assignment.cm.pojo.TotalAvailableItem;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CoffeeMachine {

	ObjectMapper objectMapper;
	public static void main(String[] args) {
		new MachineService().startMachine();
	}
}
