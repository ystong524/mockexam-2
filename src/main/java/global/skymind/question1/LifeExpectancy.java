package global.skymind.question1;

/*
 * Before you start, you should:
 * 1. Put the CSV file into your resources folder

 * Here, the hints of what you should do is given below:

 * Step 1: Read the CSV file.
 * Step 2: Specify the transform process:
 *          (a) convert "status" into categorical - "developing" and "developed"
 *          (b) convert "status" to one-hot
 * Step 3: Put each instances into the List<List<Writable>>.
 * Step 4: Execute the transform process.
 * Step 5: Perform shuffling of dataset with seed number provided. Hint: There is only 1 target.
 * Step 6: Split the dataset using train fraction provided and assign the large fraction as trainAndVal
 *         while the another as test split.
 * Step 7: Define feature scaling. Try to experiment with both feature scaling methods.
 * Step 8: Perform scaling only on trainAndVal
 * Step 9: Perform K-fold cross validation. Take k=5.
 * Step 10: Write the model config in the static method and return it in the main method.
 *          Hint: use the following input parameters provided - seed and learning rate
 * Step 11: Perform training
 * Step 12: Perform evaluation on trainAndVal and test set

 * Location of each step is marked using the following annotation:
   /*
    * Your code here
    */

import org.datavec.api.records.reader.impl.collection.CollectionRecordReader;
import org.datavec.api.transform.TransformProcess;
import org.datavec.api.transform.filter.FilterInvalidValues;
import org.datavec.api.transform.schema.Schema;
import org.datavec.api.writable.Writable;
import org.nd4j.linalg.dataset.ViewIterator;

import java.util.ArrayList;
import java.util.List;

public class LifeExpectancy {

    private static int seed = 12345;
    private static double lr = 0.001;
    private static int epoch = 10;
    private static double trainPerc = 0.7;
    private static List<List<Writable>> transformed;

    public static void main(String[] args) {

        /*
         * Your code here
         */

        //define schema
        Schema schema = new Schema.Builder()
                .addColumnsDouble("country")
                .addColumnInteger("year")
                .addColumnString("status")
                .addColumnDouble("life-exp")
                .addColumnsInteger("adult-mortality","infant-death")
                .addColumnsDouble("alcohol","perc-expenditure")
                .addColumnsInteger("hepa-b","measles")
                .addColumnDouble("bmi")
                .addColumnsInteger("under-5-deaths","polio")
                .addColumnDouble("total-expenditure")
                .addColumnInteger("diphtheria")
                .addColumnsDouble("hiv-aids","gdp")
                .addColumnInteger("population")
                .addColumnsDouble("thinness-1_19","thinness-5_9","income-composition","schooling")
                .build();

        TransformProcess tp = new TransformProcess.Builder(schema)
                .removeColumns("country")
                /*
                 * Your code here
                 */
                .filter(new FilterInvalidValues())
                .build();

        List<List<Writable>> original = new ArrayList<>();

        /*
         * Your code here
         */

        /*
         * Your code here
         */

        System.out.println("Schema before transformed: \n" + tp.getInitialSchema());
        System.out.println("Schema after transformed: \n" + tp.getFinalSchema());

        System.out.println("Size before transformed: " + original.size());
        System.out.println("Size after transformed: " + transformed.size());
        System.out.println("Columns before transformed: " + tp.getInitialSchema().numColumns());
        System.out.println("Columns after transformed: " + tp.getFinalSchema().numColumns());

        CollectionRecordReader crr = new CollectionRecordReader(transformed);

        /*
         * Your code here
         */

        /*
         * Your code here
         */

        /*
         * Your code here
         */

        /*
         * Your code here
         */

        ViewIterator testIter = new ViewIterator(test, test.numExamples());
        testIter.setPreProcessor(scaler);

        /*
         * Your code here
         */

        /*
         * Your code here
         */

        MultiLayerNetwork model = new MultiLayerNetwork(config);

        InMemoryStatsStorage storage = new InMemoryStatsStorage();
        UIServer server = UIServer.getInstance();
        server.attach(storage);
        model.setListeners(new StatsListener(storage,1),new ScoreIterationListener(10));

        model.init();
        /*
         * Your code here
         */
        System.out.println(model.summary());

        /*
         * Your code here
         */
        System.out.println("Train & Validation evaluation\n"+evalTrain.stats());
        System.out.println("Test evaluation\n"+evalTest.stats());

    }

    private static MultiLayerConfiguration getConfig(int seedNum, double learningRate, int nFeatures, int nClass){

        /*
          Specifications:
          1. use Adam
          2. use Xavier
          3. use 1 hidden layer with 100 neurons
          4. use MSE as loss function
         */

        /*
         * Your code here
         */

        return null; //edit here too
    }

}