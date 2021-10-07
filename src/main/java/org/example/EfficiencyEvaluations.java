package org.example;

public class EfficiencyEvaluations {
    //recall // полнота
    public double recall(int countRelevantDocsFound , int countRelevantDocs){
        double result=0.0;
        try{

            if(countRelevantDocs==0) throw new Exception("Общее число релевантных документов не может быть равно 0");
            if(countRelevantDocs<countRelevantDocsFound) throw new Exception("Общее число релевантных документов не может быть меньшьше количеству найденных релевантых документов");
            result= (double)countRelevantDocsFound/(double)countRelevantDocs;
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return result;
    }
    //precision // точность
    public double precision(int countRelevantDocsFound , int countDocsFound){
        double result=0.0;
        try{
            if(countDocsFound==0) throw new Exception("Общее число найденных документов не может быть равно 0");
            if(countDocsFound<countRelevantDocsFound) throw new Exception("Общее число найденных документов не может быть меньшьше количеству найденных релевантых документов");
            result= (double)countRelevantDocsFound/(double)countDocsFound;
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return result;
    }
    public double fMeasure(double precision, double recall){
        double result=0.0;
        try{
            if(precision<=0) throw new Exception("Точность не может быть меньше или равно 0");
            if(precision>1) throw new Exception("Точность не может быть больше 1");
            if(recall<=0) throw new Exception("Полнота не может быть меньше или равно 0");
            if(recall>1) throw new Exception("Полнота не может быть больше 1");
            result= 2*precision*recall/(precision+recall);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return result;
    }
}
