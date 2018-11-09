package com.ljh.common;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

/**
 *官方参考文档
 * https://www.elastic.co/guide/en/elasticsearch/client/java-api/current/transport-client.html
 */
public class Test {
    public static void main(String[] args) throws UnknownHostException {
        // 设置集群的名字
        Settings settings = Settings.builder().put("cluster.name", "esljh").build();
        // 创建client
        TransportClient client = new PreBuiltTransportClient(settings)
                    .addTransportAddress(new TransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
        // 搜索数据
        GetResponse response = client.prepareGet("website", "blog", "1").execute().actionGet();
        // 输出结果
        System.out.println(response.getSourceAsString());
        // 关闭client
        client.close();
        
    }
}