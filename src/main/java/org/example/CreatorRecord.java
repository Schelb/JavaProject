package org.example;

class CreatorRecords {
    public ListOfRecords createRecords(int countDocsFound, int countDocs){

        ListOfRecords result = new ListOfRecords();
        for (int i = 0; i < countDocsFound; i++) {
            double j = Math.random();
            if (j > 0.5) {
                result.addRecord(createRelevantRecord());
                result.setCountRelevantDocsFound(result.getCountRelevantDocsFound()+1);
            } else {
                result.addRecord(createIrrelevantRecord());
            }
        }
        for (int i = countDocsFound; i < countDocs; i++) {
            result.addRecord(createRelevantNotFoundRecord());
        }
        result.setCountDocs(countDocs);
        result.setCountDocsFound(countDocsFound);
        result.setCountRelevantDocs(result.getCountRelevantDocsFound()+countDocs-countDocsFound);
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
