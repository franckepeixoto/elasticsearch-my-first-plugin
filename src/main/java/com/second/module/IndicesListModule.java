package com.second.module;

import org.elasticsearch.common.inject.AbstractModule;

import com.second.handler.IndicesListHandler;

public class IndicesListModule extends AbstractModule {

	@Override
	protected void configure() {
		// TODO Auto-generated method stub
		bind(IndicesListHandler.class).asEagerSingleton();
	}

}
