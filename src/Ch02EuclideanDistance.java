import java.util.*;

/**
 * Created by ts-jounghasun on 2015-12-08.
 */
public class Ch02EuclideanDistance extends Ch02Similarity {

        //        # Returns a distance-based similarity score for person1 and person2
//        def sim_distance(prefs,person1,person2):
//        # Get the list of shared_items
//                si={}
//        for item in prefs[person1]:
//        if item in prefs[person2]:
//        si[item]=1
//        # if they have no ratings in common, return 0
//        if len(si)==0: return 0
//        # Add up the squares of all the differences
//        sum_of_squares=sum([pow(prefs[person1][item]-prefs[person2][item],2)
//        for item in prefs[person1] if item in prefs[person2]])
//        return 1/(1+sum_of_squares)

//        private Map<String, Map<String, Double>> personalRate;

    public double getSimilarity (Map < String, Map < String, Double >> personalRate, String person1, String person2) {
        Map<String, Double> Si = new HashMap<String, Double>();
        double sum_of_squares = 0;
        double result = 0;
        for (Map.Entry<String, Double> item : personalRate.get(person1).entrySet()) {
            for (Map.Entry<String, Double> item2 : personalRate.get(person2).entrySet()) {
                if (item.getKey().equals(item2.getKey())) {
                    Si.put(item.getKey(), 1.0);
                    sum_of_squares += Math.pow((item.getValue() - item2.getValue()), 2);
                }
            }
        }

        if (Si.size() == 0){
            result =  0;
        }else {
            result = 1 / (1 + sum_of_squares);
        }
        return result;
    }


    public double getDistance(double[] x, double[] y) {
        double sumXY2 = 0.0;
        for(int i = 0, n = x.length; i < n; i++) {
            sumXY2 += Math.pow(x[i] - y[i], 2);
        }
        return Math.sqrt(sumXY2);
    }

}
