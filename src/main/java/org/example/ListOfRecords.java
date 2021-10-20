package org.example;

import java.util.ArrayList;
import java.util.List;

public class ListOfRecords {
    public  List<Record> records;
    public ListOfRecords(){
        records = new ArrayList<>();
    }
    public ListOfRecords(ArrayList<Record> rds){
        records = new ArrayList<>();
        records=rds;
    }
}
