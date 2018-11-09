package com.ljh.uitl;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;

public class EsTools {
	
	//设置集群名字
	private static final String Cluster_Name = "esljh";
	//节点的Ip
	private static final String Host = "127.0.0.1";
	//链接的端口号
	private static final int Tcp_Port =9300;
	//设置Settings对象
	private static Settings setting = Settings.builder().put("cluster_name",Cluster_Name).build();
	//TransportClient 对象，用于链接Es集群
	private static volatile TransportClient client;
	
	


}
