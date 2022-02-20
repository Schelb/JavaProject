package org.example;

public class Record implements Printable {
    private RecordType type;
    public RecordType  getType(){
        return this.type;
    }
    public void setType(RecordType typeIn){
        this.type= typeIn;
    }

    @Override
    public void print() {
        System.out.print("\t"+ type + "\t");
    }
}
