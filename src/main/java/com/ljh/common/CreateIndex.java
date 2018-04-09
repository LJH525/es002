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

public class CreateIndex {
	
	public static void main(String args[]){
		TransportClient client =null;
		try {
		//���ü�Ⱥ������
		Settings setting =Settings.builder().put("cluster.name","esljh").build();
		//�����ͻ��˵�����
		client = new PreBuiltTransportClient(setting)
			.addTransportAddress(new TransportAddress(InetAddress.getByName("127.0.0.1"),9300));
		//��ȡindicesAdminClient����
		IndicesAdminClient indicesAdminClient = client.admin().indices();
		//�ж������Ƿ����
		IndicesExistsResponse reponse = indicesAdminClient.prepareExists("index1").get();
		System.out.println(reponse.isExists());
		//��������
		CreateIndexResponse index = indicesAdminClient.prepareCreate("ljh001").get();
		System.out.println(index.isAcknowledged());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}finally{
			if(client!=null)client.close();
		}

	}
}
