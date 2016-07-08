package com.second.handler;

import java.io.IOException;
import java.util.ArrayList;

import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.admin.indices.stats.IndexStats;
import org.elasticsearch.action.admin.indices.stats.IndicesStatsRequest;
import org.elasticsearch.action.admin.indices.stats.IndicesStatsResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.json.JsonXContent;
import org.elasticsearch.rest.BaseRestHandler;
import org.elasticsearch.rest.BytesRestResponse;
import org.elasticsearch.rest.RestChannel;
import org.elasticsearch.rest.RestController;
import org.elasticsearch.rest.RestRequest;
import org.elasticsearch.rest.RestRequest.Method;
import org.elasticsearch.rest.RestStatus;

public class IndicesListHandler extends BaseRestHandler {

	@Inject
	public  IndicesListHandler(Settings settings, RestController controller, Client client) {
		super(settings, controller, client);
		// TODO Auto-generated constructor stub
		controller.registerHandler(Method.GET, "_indiceslist", this);
	}

	@Override
	protected void handleRequest(RestRequest request, RestChannel channel, Client client) throws Exception {
		// TODO Auto-generated method stub
		IndicesStatsRequest isr = new IndicesStatsRequest();
		final  XContentBuilder xcb  = JsonXContent.contentBuilder();
		IndicesStatsResponse response =client.admin().indices().stats(isr).get();
		xcb.startObject();
		xcb.field("ok","true");
		try {
			
			writeIndexList(xcb,response.getIndices());
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		xcb.field("francke","peixoto =)");
		xcb.endObject();
		
		BytesRestResponse bytesRestResponse = new BytesRestResponse(RestStatus.OK,xcb);
		channel.sendResponse(bytesRestResponse);
	}
	public XContentBuilder writeIndexList(XContentBuilder builder,java.util.Map<String, IndexStats> map) throws IOException {
		
		ArrayList<String> indices = new ArrayList<String>();
		for(IndexStats indexStats : map.values())
		{
			indices.add(indexStats.getIndex());
		}
		builder.array("indices", indices);
		
		return builder;
	}

}
