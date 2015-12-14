import java.util.*;

/**
 * Created by ts-jounghasun on 2015-12-11.
 */
public class Ch02Ranking {

//    # Gets recommendations for a person by using a weighted average
//    # of every other user's rankings
//    def getRecommendations(prefs,person,similarity=sim_pearson):
//    totals={}
//    simSums={}
//    for other in prefs:
//            # don't compare me to myself
//            if other==person: continue
//    sim=similarity(prefs,person,other)
//    # ignore scores of zero or lower
//    if sim<=0: continue
//            for item in prefs[other]:
//            # only score movies I haven't seen yet
//            if item not in prefs[person] or prefs[person][item]==0:
//            # Similarity * Score
//    totals.setdefault(item,0)
//    totals[item]+=prefs[other][item]*sim
//    # Sum of similarities
//    simSums.setdefault(item,0)
//    simSums[item]+=sim
//    # Create the normalized list
//    rankings=[(total/simSums[item],item) for item,total in totals.items( )]
//            # Return the sorted list
//    rankings.sort( )
//            rankings.reverse( )
//            return rankings



    public double getRecommendation (Map<String,Map<String,Double>> data , String person, Ch02Similarity similarity) {
        Map <String ,Double> totals = new HashMap<>();
        Map <String ,Double> simSums = new HashMap<>();

        for (Map.Entry <String,Map <String ,Double>> item : data.entrySet()){
            if (person.equals(item.getKey())){
                continue;
            }else {
                String otherP = item.getKey();
                double sim = similarity.getSimilarity(data, person, otherP);
                if (sim <= 0 ) continue;

                Map <String ,Double> othersPrefs = item.getValue();

//                # only score movies I haven't seen yet
                for (Map.Entry<String, Double> prefs  : othersPrefs.entrySet()) {
//                    if item not in prefs[person] or prefs[person][item]==0:
                    if (!data.get(person).containsKey(prefs.getKey()) || data.get(person).get(prefs.getKey())==0) {
                        double simS = 0 ;
                        double simS2 = 0;

                        if (!totals.containsKey(prefs.getKey())){
                            totals.put(prefs.getKey() , 0d);

                            simS = totals.get(prefs.getKey());
                            simS += prefs.getValue()*sim ;
                            totals.put(prefs.getKey() , simS);
                        }else {
                            simS = totals.get(prefs.getKey());
                            simS += prefs.getValue()*sim ;
                            totals.put(prefs.getKey() , simS);
                        }

                        if(!simSums.containsKey(prefs.getKey())){
                            simSums.put(prefs.getKey(),0d);

                            simS2 = simSums.get(prefs.getKey());
                            simS2 += sim ;
                            simSums.put(prefs.getKey() , simS2);

                        }else {
                            simS2 = simSums.get(prefs.getKey());
                            simS2 += sim ;
                            simSums.put(prefs.getKey() , simS2);
                        }
                    }
                }
            }
        }

        Map <String ,Double> rankings = new HashMap<>();

        for (Map.Entry<String, Double> totalItem  : totals.entrySet()) {
            rankings.put(totalItem.getKey() ,totalItem.getValue()/simSums.get(totalItem.getKey()));
        }
        System.out.print(rankings);
        return 0;
    }


//    def topMatches(prefs,person,n=5,similarity=sim_pearson):
//    scores=[(similarity(prefs,person,other),other)
//            for other in prefs if other!=person]
    public void topMatches (Map<String,Map<String,Double>> data ,String person , int num , Ch02Similarity similarity) {

        Map <String , Double> scores = new HashMap <String , Double>();
        for (Map.Entry <String,Map <String ,Double>> item : data.entrySet()) {
            if (person.equals(item.getKey())) {
                continue;
            } else {
                String otherP = item.getKey();
                double sim = similarity.getSimilarity(data, person, otherP);
                scores.put(otherP ,sim);
            }
        }

        scores = sortByValue(scores);
        System.out.println(scores);
    }



    public static <K, V extends Comparable <? super V>> Map<K, V> sortByValue( Map<K, V> map )
    {
        List<Map.Entry<K, V>> list = new LinkedList<Map.Entry<K, V>>( map.entrySet() );
        Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
                return -(o1.getValue()).compareTo(o2.getValue());
            }
        });

        Map<K, V> result = new LinkedHashMap<K, V>();
        for (Map.Entry<K, V> entry : list)
        {
            result.put( entry.getKey(), entry.getValue() );
        }
        return result;
    }

}
