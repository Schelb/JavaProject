package org.example;

public class CreatorRecord {
    public Record createRelevantRecord() {
        /*       int n = 10;
        int m = 15;
        ArrayList<Record.Type> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            double j = Math.random();
            if (j > 0.5) {
                result.add(Record.Type.Relevant);
            } else {
                result.add(Record.Type.Irrelevant);
            }
        }
        for (int i = n; i < m; i++) {
            result.add(Record.Type.RelevantNotFound);
        }
        for (int i = 0; i < m; i++) {
            System.out.println(i + 1 + " " + result.get(i));

        double j = Math.random();
        if (j > 0.5) {
            record.setType(Type.Relevant);
        } else {
            record.setType(Type.Irrelevant);
        }
        return record;
        } */
        Record recordRelevant=  new Record();
        recordRelevant.setType(RecordType.Relevant);
        return recordRelevant;

    }
    public Record createIrrelevantRecord(){
        Record recordIrrelevant=  new Record();
        recordIrrelevant.setType(RecordType.Irrelevant);
        return recordIrrelevant;
    }
    public Record createRelevantNotFoundRecord(){
        Record recordRelevantNotFoundRecord=  new Record();
        recordRelevantNotFoundRecord.setType(RecordType.RelevantNotFound);
        return recordRelevantNotFoundRecord;
    }
}
