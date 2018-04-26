package com.example.lakshan.imagegallary;

import java.util.ArrayList;

/**
 * Created by Lakshan on 4/25/2018.
 */

class Singleton
{
    private static Singleton instance;
    private static ArrayList<String> arrayList;
    private static ArrayList<Integer> arrayList2;

    private Singleton()
    {
       this.arrayList=new ArrayList<String>()  ;
    }

    public static synchronized Singleton getInstance()
    {
        //arrayList2=arrayList1;
        if (instance == null)
            instance = new Singleton();

        return instance;
    }

    public void doSomething(String x)
    {
          arrayList.add(x);
        System.out.println("successfully added the "+x);
    }

    public ArrayList<String> getFavoriteList(){
        return arrayList;
    }

}