import java.util.HashMap;
import java.util.Map;

/**
 * Created by ts-jounghasun on 2015-12-09.
 */
public class Ch02TestMain {

        public static void main (String args[]) {
            /*init data setting*/
            Map<String, Map<String, Double>> personalRate = new HashMap<String, Map<String, Double>>();
            Ch02DataSet data = new Ch02DataSet();
            personalRate = data.initDataSet();

            /*euclidean Distance*/
//            Ch02Similarity euclideanDistance = new Ch02EuclideanDistance();
//            System.out.println("sim_distance ::" + euclideanDistance.getSimilarity(personalRate, "Lisa Rose", "Gene Seymour"));

            /*pearsonCorrelation*/
            Ch02Similarity pearsonCorrelation = new Ch02PearsonCorrelation();
//            System.out.println("sim_person ::" + pearsonCorrelation.getSimilarity(personalRate, "Lisa Rose", "Gene Seymour"));

            /* ranking similarity person */
            Ch02Similarity similarity = new Ch02PearsonCorrelation();
            Ch02Ranking ranking = new Ch02Ranking();
//            ranking.getRecommendation(personalRate ,"Toby",pearsonCorrelation );

            ranking.topMatches(personalRate ,"Toby" ,3 ,pearsonCorrelation);
            
            System.out.println(data.transformData(personalRate));
        }

}
