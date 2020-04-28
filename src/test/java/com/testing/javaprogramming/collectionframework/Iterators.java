package com.testing.javaprogramming.collectionframework;

import org.testng.annotations.Test;

import java.util.*;

public class Iterators {
    public ArrayList<Integer> addDataList() {
        ArrayList data = new ArrayList<Integer>();
        data.add(5);
        data.add(15);
        data.add(25);
        data.add(35);
        data.add(45);
        return data;
    }

    @Test
    public void iterateData() {
        ArrayList<Integer> mydata = addDataList();
        Iterator iterator = mydata.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            int num = (Integer) obj;
            System.out.println(num);
        }
    }

    public HashMap<String,String> addDataMap(){
        HashMap<String,String> data = new HashMap<>();
        data.put("name","saravana");
        data.put("laptop","asus");
        data.put("mobile","honor");
        data.put("tv","lg");
        data.put("mouse","logitech");
        return data;
    }

    @Test
    public void iterateDataMap(){
        HashMap<String,String> myGadgetData = addDataMap();
        Iterator iterator =myGadgetData.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String,String> obj = (Map.Entry)iterator.next();
            System.out.println(obj);
        }
    }

    public HashMap<String,ArrayList<String>> addDataMapArrayList(){
        HashMap<String,ArrayList<String>> data = new HashMap<>();
        ArrayList<String> names = new ArrayList<>();
        names.add("saravana");names.add("prasath");names.add("raja");names.add("ramesh");names.add("sakthi");
        ArrayList<String> courses = new ArrayList<>();
        courses.add("mca");courses.add("bca");courses.add("mba");courses.add("msc");courses.add("mcom");
        ArrayList<String> city = new ArrayList<>();
        city.add("apk");city.add("mdu");city.add("chennai");city.add("mumbai");city.add("kovai");city.add("trichy");
        data.put("names",names);
        data.put("cources",courses);
        data.put("city",city);
        return data;
    }

    @Test
    public void iterateMapArrayList(){
        HashMap<String,ArrayList<String>> data = addDataMapArrayList();
        Iterator iterator = data.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String,String> obj = (Map.Entry<String, String>) iterator.next();
            System.out.println(obj);
            System.out.println(obj.getKey());

        }
    }


}
