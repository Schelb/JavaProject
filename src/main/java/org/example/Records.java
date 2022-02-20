package org.example;

public class Records implements Printable{
    private int countDocs;
    private int countDocsFound;
    private int countRelevantDocs;
    private int countRelevantDocsFound;

    public void setCountDocs(int countDocs) {this.countDocs = countDocs;}
    public int getCountDocs() {return countDocs;}
    public void setCountDocsFound(int countDocsFound) {
        this.countDocsFound = countDocsFound;
    }
    public int getCountDocsFound() {
        return countDocsFound;
    }
    public void setCountRelevantDocs(int countRelevantDocs) {
        this.countRelevantDocs = countRelevantDocs;
    }
    public int getCountRelevantDocs() {
        return countRelevantDocs;
    }
    public void setCountRelevantDocsFound(int countRelevantDocsFound) {this.countRelevantDocsFound = countRelevantDocsFound;}
    public int getCountRelevantDocsFound() {
        return countRelevantDocsFound;
    }

    @Override
    public void print() {
        StringBuilder s= new StringBuilder();
        s.append("countDocs= "+countDocs+"\n");
        s.append("countDocsFound= "+countDocsFound+"\n");
        s.append("countRelevantDocs= "+countRelevantDocs+"\n");
        s.append("countRelevantDocsFound= "+countRelevantDocsFound+"\n");
        s.append("Docks: \n");
        System.out.println(s.toString());
    }
}
