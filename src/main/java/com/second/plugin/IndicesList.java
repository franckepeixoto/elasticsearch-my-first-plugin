package com.second.plugin;

import java.util.ArrayList;
import java.util.Collection;

import org.elasticsearch.common.inject.Module;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.indices.IndicesModule;
import org.elasticsearch.plugins.Plugin;
import org.elasticsearch.rest.RestModule;

import com.second.handler.IndicesListHandler;
import com.second.module.IndicesListModule;

public class IndicesList extends Plugin{

	@Override
	public String description() {
		// TODO Auto-generated method stub
		return "Lista de todos os indices...";
	}

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return "ILSecondPlugin";
	}

	public void onModule(final RestModule module) {
        module.addRestAction(IndicesListHandler.class);
    }
	
	/*
	 
	 @Override 
	public Collection<Module> indexModules(Settings indexSettings) {
		// TODO Auto-generated method stub
		//return super.indexModules(indexSettings);
		final Collection<Module> list = new ArrayList<Module>();
		list.add(new IndicesListModule());//.add(IndicesListModule.class);
	    return list;
	}
	  */

	/*
	 @Override
	public Collection<Module> nodeModules() {
	

		// TODO Auto-generated method stub
		 ArrayList<Module> list = new  ArrayList<Module>();
		 list.add(new IndicesListModule());
		return list;// super.indexModules(indexSettings);
	}*/
}