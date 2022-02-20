package org.example;

import java.util.ArrayList;

public class ListOfRecords extends Records{
    private  ArrayList<Record> records;
    public ListOfRecords(){
        records = new ArrayList<>();
    }
    public ListOfRecords(ArrayList<Record> rds){
        records=rds;
    }
    public void setRecords(ArrayList<Record> records) {
        this.records = records;
    }
    public ArrayList<Record> getRecords() {
        return records;
    }
    public void addRecord(Record record){
        records.add(record);
    }

    @Override
    public String toString() {
        return "ListOfRecords{" +
                "countDocs= " + this.getCountDocs() + "\n"+
                "countDocsFound= " + this.getCountDocsFound() +"\n"+
                "countRelevantDocs= " + this.getCountRelevantDocs() + "\n"+
                "countRelevantDocsFound= " + this.getCountRelevantDocsFound() + "\n"+
                '}';
    }

    @Override
    public void print() {
        StringBuilder s = new StringBuilder();
        s.append("countDocs= " + this.getCountDocs() + "\n");
        s.append("countDocsFound= " + this.getCountDocsFound() + "\n");
        s.append("countRelevantDocs= " + this.getCountRelevantDocs() + "\n");
        s.append("countRelevantDocsFound= " + this.getCountRelevantDocsFound() + "\n");
        s.append("Docks: \n");
        for (Record rec :
                records) {
            s.append(rec.getType() + "\n");
        }
        System.out.println(s.toString());
    }
}
