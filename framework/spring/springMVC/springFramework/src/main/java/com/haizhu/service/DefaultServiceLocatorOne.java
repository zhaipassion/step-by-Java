package com.haizhu.service;

import com.haizhu.service.impl.ClientServiceImpl;

public class DefaultServiceLocatorOne {

	private static ClientService clientService = new ClientServiceImpl();

	private DefaultServiceLocatorOne() {
	}

	public ClientService createClientServiceInstance() {
		return clientService;
	}
}