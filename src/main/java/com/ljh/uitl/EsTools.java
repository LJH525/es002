package com.ljh.uitl;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;

public class EsTools {
	
	//���ü�Ⱥ������
	private static final String Cluster_Name = "esljh";
	//�ڵ������
	private static final String Host = "127.0.0.1";
	//���ӵĶ˿ں�
	private static final int Tcp_Port =9300;
	//����Settings����
	private static Settings setting = Settings.builder().put("cluster_name",Cluster_Name).build();
	//TransportClient ������������ES��Ⱥ
	private static volatile TransportClient client;
	
	


}
