package com.ljh.common;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

/**
 * �ٷ��ο��ĵ�
 * https://www.elastic.co/guide/en/elasticsearch/client/java-api/current/transport-client.html
 */
public class Test {
    public static void main(String[] args) throws UnknownHostException {
        // ���ü�Ⱥ����
        Settings settings = Settings.builder().put("cluster.name", "esljh").build();
        // ����client
        TransportClient client = new PreBuiltTransportClient(settings)
                    .addTransportAddress(new TransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
        // ��������
        GetResponse response = client.prepareGet("website", "blog", "1").execute().actionGet();
        // ������
        System.out.println(response.getSourceAsString());
        // �ر�client
        client.close();
        
    }
}