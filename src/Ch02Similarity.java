import java.util.Map;

/**
 * Created by ts-jounghasun on 2015-12-11.
 */
public abstract class Ch02Similarity {

    private Map <String ,Map <String,Double>> data;

    public Map<String, Map<String, Double>> getData() {
        return data;
    }

    public void setData(Map<String, Map<String, Double>> data) {
        this.data = data;
    }

    public void initData(Ch02DataSet obj) {
        data = obj.initDataSet();
    }

    public abstract double getSimilarity (Map <String ,Map <String,Double>> data, String person1, String person2);
}
