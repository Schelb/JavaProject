package org.example;

import java.util.ArrayList;

class CreatorRecords {
    public ArrayList<Record> creatRecords(int n, int m){
        ArrayList<Record> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            double j = Math.random();
            if (j > 0.5) {
                result.add(createRelevantRecord());
            } else {
                result.add(createIrrelevantRecord());
            }
        }
        for (int i = n; i < m; i++) {
            result.add(createRelevantNotFoundRecord());
        }
        return result;
    }
    private Record createRelevantRecord() {
        Record recordRelevant=  new Record();
        recordRelevant.setType(RecordType.Relevant);
        return recordRelevant;

    }
    private Record createIrrelevantRecord(){
        Record recordIrrelevant=  new Record();
        recordIrrelevant.setType(RecordType.Irrelevant);
        return recordIrrelevant;
    }
    private Record createRelevantNotFoundRecord(){
        Record recordRelevantNotFoundRecord=  new Record();
        recordRelevantNotFoundRecord.setType(RecordType.RelevantNotFound);
        return recordRelevantNotFoundRecord;
    }
}
