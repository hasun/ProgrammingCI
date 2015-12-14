import java.util.HashMap;
import java.util.Map;

/**
 * Created by ts-jounghasun on 2015-12-09.
 */
public class Ch02DataSet {

    //        # A dictionary of movie critics and their ratings of a small
//        # set of movies
//                critics={'Lisa Rose': {'Lady in the Water': 2.5, 'Snakes on a Plane': 3.5,
//                'Just My Luck': 3.0, 'Superman Returns': 3.5, 'You, Me and Dupree': 2.5,
//                'The Night Listener': 3.0},
//        'Gene Seymour': {'Lady in the Water': 3.0, 'Snakes on a Plane': 3.5,
//                'Just My Luck': 1.5, 'Superman Returns': 5.0, 'The Night Listener': 3.0,
//                'You, Me and Dupree': 3.5},
//        'Michael Phillips': {'Lady in the Water': 2.5, 'Snakes on a Plane': 3.0,
//                'Superman Returns': 3.5, 'The Night Listener': 4.0},
//        'Claudia Puig': {'Snakes on a Plane': 3.5, 'Just My Luck': 3.0,
//                'The Night Listener': 4.5, 'Superman Returns': 4.0,
//                'You, Me and Dupree': 2.5},
//        'Mick LaSalle': {'Lady in the Water': 3.0, 'Snakes on a Plane': 4.0,
//                'Just My Luck': 2.0, 'Superman Returns': 3.0, 'The Night Listener': 3.0,
//                'You, Me and Dupree': 2.0},
//        'Jack Matthews': {'Lady in the Water': 3.0, 'Snakes on a Plane': 4.0,
//                'The Night Listener': 3.0, 'Superman Returns': 5.0, 'You, Me and Dupree': 3.5},
//        'Toby': {'Snakes on a Plane':4.5,'You, Me and Dupree':1.0,'Superman Returns':4.0}}
    public Map<String, Map<String, Double>> initDataSet (){
        Map<String, Map<String, Double>> personalRate = new HashMap<String, Map<String, Double>>();

        Map<String, Double> Lisa = new HashMap<String, Double>();
        Lisa.put("Lady in the Water", 2.5);
        Lisa.put("Snakes on a Plane", 3.5);
        Lisa.put("Just My Luck", 3.0);
        Lisa.put("Superman Returns", 3.5);
        Lisa.put("You, Me and Dupree", 2.5);
        Lisa.put("The Night Listener", 3.0);
        personalRate.put("Lisa Rose", Lisa);

        Map<String, Double> GeneSeymour = new HashMap<String, Double>();
        GeneSeymour.put("Lady in the Water", 3.0);
        GeneSeymour.put("Snakes on a Plane", 3.5);
        GeneSeymour.put("Just My Luck", 1.5);
        GeneSeymour.put("Superman Returns", 5.0);
        GeneSeymour.put("You, Me and Dupree", 3.5);
        GeneSeymour.put("The Night Listener", 3.0);

        personalRate.put("Gene Seymour", GeneSeymour);


        Map<String, Double> MichaelPhillips = new HashMap<String, Double>();
        MichaelPhillips.put("Lady in the Water", 2.5);
        MichaelPhillips.put("Snakes on a Plane", 3.0);
        MichaelPhillips.put("Superman Returns", 3.5);
        MichaelPhillips.put("The Night Listener", 4.0);

        personalRate.put("Michael Phillips", MichaelPhillips);

        Map<String, Double> ClaudiaPuig = new HashMap<String, Double>();
        ClaudiaPuig.put("Snakes on a Plane", 3.5);
        ClaudiaPuig.put("Just My Luck", 3.0);
        ClaudiaPuig.put("Superman Returns", 4.0);
        ClaudiaPuig.put("The Night Listener", 4.5);
        ClaudiaPuig.put("You, Me and Dupree", 2.5);

        personalRate.put("Claudia Puig", ClaudiaPuig);

        Map<String, Double> MickLaSalle = new HashMap<String, Double>();
        MickLaSalle.put("Lady in the Water", 3.0);
        MickLaSalle.put("Snakes on a Plane", 4.0);
        MickLaSalle.put("Just My Luck", 2.0);
        MickLaSalle.put("Superman Returns", 3.0);
        MickLaSalle.put("The Night Listener", 3.0);
        MickLaSalle.put("You, Me and Dupree", 2.0);

        personalRate.put("Mick LaSalle", MickLaSalle);

        Map<String, Double> JackMatthews = new HashMap<String, Double>();
        JackMatthews.put("Lady in the Water", 3.0);
        JackMatthews.put("Snakes on a Plane", 4.0);
        JackMatthews.put("Superman Returns", 5.0);
        JackMatthews.put("The Night Listener", 3.0);
        JackMatthews.put("You, Me and Dupree", 3.5);

        personalRate.put("Jack Matthews", JackMatthews);

        Map<String, Double> Toby = new HashMap<String, Double>();
        Toby.put("Snakes on a Plane", 4.5);
        Toby.put("Superman Returns", 4.0);
        Toby.put("You, Me and Dupree", 1.0);

        personalRate.put("Toby", Toby);

        return personalRate;
//            this.personalRate = personalRate;
    }
}
