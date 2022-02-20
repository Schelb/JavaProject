package org.example;

public class EfficiencyEvaluations {
    private static  EfficiencyEvaluations instance;
    //recall // полнота
    public double getRecall(int countRelevantDocsFound , int countRelevantDocs){
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
    public double getPrecision(int countRelevantDocsFound , int countDocsFound){
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
    public double getF_Measure(double precision, double recall){
        double result=0.0;
        try{
            if(precision<0) throw new Exception("Точность не может быть меньше 0");
            if(precision>1) throw new Exception("Точность не может быть больше 1");
            if(recall<0) throw new Exception("Полнота не может быть меньше 0");
            if(recall>1) throw new Exception("Полнота не может быть больше 1");
            if(recall==0 || precision==0){
                return result=0;
            }
            result= 2*precision*recall/(precision+recall);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return result;
    }
    public Point<Double>[] elevenPointMatrix(ListOfRecords listOfRecords){
        Point<Double>[] points = new Point[listOfRecords.getCountDocsFound()];
        int relevant=0;
        for (int i=0; i<listOfRecords.getCountDocsFound();i++){
            if (listOfRecords.getRecords().get(i).getType()==RecordType.Relevant){
                relevant++;
            }
            double precision=(double)relevant/(i+1);
            double recall = (double)relevant/ (double)listOfRecords.getCountRelevantDocs();
            Point point = new Point<Double>();
            point.setX(Double.valueOf(recall));
            point.setY(Double.valueOf(precision));
            points[i] = point;
        }
        return points;
    }
    private EfficiencyEvaluations(){}
    public static EfficiencyEvaluations getInstance(){
        if (instance == null) {
            instance = new EfficiencyEvaluations();
        }
        return instance;
    }
}
