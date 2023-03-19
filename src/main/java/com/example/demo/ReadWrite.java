package com.example.demo;

import java.io.*;
import java.util.ArrayList;

public class ReadWrite {
    public void writeFile(String file,String name) throws IOException {
        BufferedWriter writer= new BufferedWriter(new FileWriter(file));
        writer.write(name);
    }
    public String readFile(String file) throws IOException {
        BufferedReader reader= new BufferedReader(new FileReader(file));
        ArrayList<Object> list=new ArrayList<>();
        String Line;
        while((Line=reader.readLine())!=null){
            return Line;
        }

        return Line;
    }
}
