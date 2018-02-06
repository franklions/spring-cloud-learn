package spring.cloud.learn.task.center.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author flsh
 * @version 1.0
 * @description
 * @date 2018/2/5
 * @since Jdk 1.8
 */
public class JobManager {
    /*
     * 随机分配
     */
    public Map<String,List<String>> allotOfRandom(List<String> users, List<String> tasks){
        Map<String,List<String>> allot=new ConcurrentHashMap<String,List<String>>(); //保存分配的信息
        if(users!=null&&users.size()>0&&tasks!=null&&tasks.size()>0){
            for(int i=0;i<tasks.size();i++){
                int r_user=new Random().nextInt(users.size());
                if(allot.containsKey(users.get(r_user))){
                    List<String> list=allot.get(users.get(r_user));
                    list.add(tasks.get(i));
                    allot.put(users.get(r_user), list);
                }else{
                    List<String> list=new ArrayList<String>();
                    list.add(tasks.get(i));
                    allot.put(users.get(r_user), list);
                }
            }
        }
        return allot;
    }
    /*
     * 平均分配
     */
    public Map<String,List<String>> allotOfAverage(List<String> users,List<String> tasks){
        Map<String,List<String>> allot=new ConcurrentHashMap<String,List<String>>(); //保存分配的信息
        if(users!=null&&users.size()>0&&tasks!=null&&tasks.size()>0){
            for(int i=0;i<tasks.size();i++){
                int j=i%users.size();
                if(allot.containsKey(users.get(j))){
                    List<String> list=allot.get(users.get(j));
                    list.add(tasks.get(i));
                    allot.put(users.get(j), list);
                }else{
                    List<String> list=new ArrayList<String>();
                    list.add(tasks.get(i));
                    allot.put(users.get(j), list);
                }
            }
        }
        return allot;
    }
    /*
     * 权重分配
     */
    public Map<String,List<String>> allotOfProportion(Map<String,String> users,List<String> tasks){
        Map<String,List<String>> allot=new ConcurrentHashMap<String,List<String>>(); //保存分配的信息
        if(users!=null&&users.size()>0&&tasks!=null&&tasks.size()>0){
            int a=0;//总权重
            for(Map.Entry<String, String> entry:users.entrySet()){
                a+=Integer.parseInt(entry.getValue());
            }
            int start=0,end=0;//起始下标 ,结束下标
            if(a>0){
                for(Map.Entry<String, String> entry:users.entrySet()){
                    List<String> allotTask=new ArrayList<String>();
                    end+=Integer.parseInt(entry.getValue());//权重累计
                    for(;start<tasks.size()*end/a;start++){
                        allotTask.add(tasks.get(start));
                    }
                    allot.put(entry.getKey(),allotTask);
                }
            }
        }
        return allot;
    }
}
