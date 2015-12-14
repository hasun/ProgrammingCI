import java.util.HashMap;
import java.util.Map;

/**
 * Created by ts-jounghasun on 2015-12-09.
 */
public class Ch02PearsonCorrelation extends Ch02Similarity {

//    # Returns the Pearson correlation coefficient for p1 and p2
//    def sim_pearson(prefs,p1,p2):
//            # Get the list of mutually rated items
//            si={}
//    for item in prefs[p1]:
//            if item in prefs[p2]: si[item]=1
//            # Find the number of elements
//            n=len(si)
//    # if they are no ratings in common, return 0
//            if n==0: return 0
//            # Add up all the preferences
//            sum1=sum([prefs[p1][it] for it in si])
//    sum2=sum([prefs[p2][it] for it in si])
//    # Sum up the squares
//    sum1Sq=sum([pow(prefs[p1][it],2) for it in si])
//    sum2Sq=sum([pow(prefs[p2][it],2) for it in si])
//            # Sum up the products
//    pSum=sum([prefs[p1][it]*prefs[p2][it] for it in si])
//    # Calculate Pearson score
//            num=pSum-(sum1*sum2/n)
//    den=sqrt((sum1Sq-pow(sum1,2)/n)*(sum2Sq-pow(sum2,2)/n))
//            if den==0: return 0
//    r=num/den

    public double getSimilarity (Map < String, Map < String, Double >> personalRate, String person1, String person2) {

        Map<String, Double> Si = new HashMap<String, Double>();
        double result = 0;

        double sumP1 = 0;
        double sumP2 = 0;
        double sumP1Sq = 0 ;
        double sumP2Sq = 0 ;
        double pSum = 0;
        double pScore = 0 ;
        double num = 0;
        double den = 0 ;

        for (Map.Entry<String, Double> item : personalRate.get(person1).entrySet()) {
            for (Map.Entry<String, Double> item2 : personalRate.get(person2).entrySet()) {
                if (item.getKey().equals(item2.getKey())) {
                    Si.put(item.getKey(), 1.0);
                }
            }
        }

        for ( Map.Entry<String,Double> matchedItem : Si.entrySet()) {
            sumP1 += personalRate.get(person1).get(matchedItem.getKey());
            sumP2 += personalRate.get(person2).get(matchedItem.getKey());

            sumP1Sq += Math.pow(personalRate.get(person1).get(matchedItem.getKey()), 2);
            sumP2Sq += Math.pow(personalRate.get(person2).get(matchedItem.getKey()), 2);

            pSum += (personalRate.get(person1).get(matchedItem.getKey())*personalRate.get(person2).get(matchedItem.getKey()));
        }

        num = pSum-(sumP1*sumP2/Si.size());
        den = Math.sqrt((sumP1Sq - Math.pow(sumP1 ,2)/Si.size())*(sumP2Sq - Math.pow(sumP2, 2)/Si.size()));

        if (den==0) result = 0;
        else result = num/den;

        return result;

    }

}
