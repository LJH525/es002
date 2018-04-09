package com.ljh.common;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsResponse;
import org.elasticsearch.client.IndicesAdminClient;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

public class TestDemoljh {
	
	public static void main(String[] args) {
		
		try {
		//设置集群的名字
		Settings settings = Settings.builder()
				.put("cluster.name","my-application").build();
		//创建client
		TransportClient client =new PreBuiltTransportClient(settings)
					.addTransportAddress(new TransportAddress(InetAddress.getByName("node-1"),9300));
		
		//获取IndicesExistAdminClient
		IndicesAdminClient indicesadminclient = client.admin().indices();
		//判断索引是否存在
		IndicesExistsResponse rs =indicesadminclient.prepareExists("index1").get();
			 System.out.println(rs.isExists());
			 
			 //4.创建索引
		 CreateIndexResponse ciReponse=indicesadminclient.prepareCreate("index1").get();
		        System.out.println(ciReponse.isAcknowledged());
		
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
	}
}
