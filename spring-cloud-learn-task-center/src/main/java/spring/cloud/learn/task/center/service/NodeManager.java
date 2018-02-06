package spring.cloud.learn.task.center.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import javax.xml.soap.Node;
import java.util.List;

/**
 * @author flsh
 * @version 1.0
 * @description
 * @date 2018/2/6
 * @since Jdk 1.8
 */
public class NodeManager {



    private DiscoveryClient client;

    public NodeManager(@Autowired DiscoveryClient discoveryClient){
        this.client = discoveryClient;
    }

    public List<ServiceInstance> serviceUrl(String service) {
        List<ServiceInstance> instances = this.client.getInstances(service);
        for (ServiceInstance serviceInstance:instances){
            System.out.println(serviceInstance.getHost() + ":"+serviceInstance.getPort());
        }
        return instances;
    }

    public void show(){
        List<String>  serviceIds = this.client.getServices();

        for(String serviceId : serviceIds){
            serviceUrl(serviceId);
        }
        System.out.println(serviceIds.toString());
    }
}
