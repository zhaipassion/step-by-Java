package com.haizhu.service.impl;

import com.haizhu.service.ClientService;

public class ClientServiceImpl implements ClientService {
	private static ClientService clientService = new ClientServiceImpl();

	public ClientServiceImpl() {
	}

	public static ClientService createInstance() {
		return clientService;
	}

}
