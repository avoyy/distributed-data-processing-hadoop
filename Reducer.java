/*
 * Distributed Data Processing Project | Hadoop, Java
 *
 * Author: Avoy Tejada
 *
 * Description:
 * Reducer class for Hadoop MapReduce job. Computes 
 * the average success rate for each category by location.
 * statistics per category-location pair.
 */

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import java.io.IOException;

public class Reducer extends Reducer<Text, Text, Text, Text>
{
    //***************************************************************
    //
    //  Method:       reduce
    //
    //  Description:  Computes average success rate for each category-location pair
    //
    //  Parameters:   Text key, Iterable<Text> values, Context context
    //
    //  Returns:      N/A
    //
    //***************************************************************
    public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException
    {
        double totalSuccessRate = 0;
        int count = 0;

        for (Text val : values)
        {
            String[] data = val.toString().split(",");
            int sales = Integer.parseInt(data[0].trim());
            int clicks = Integer.parseInt(data[1].trim());

            double successRate = ((double) sales / clicks) * 100;
            totalSuccessRate += successRate;
            count++;
        }

        double avgSuccessRate = count > 0 ? totalSuccessRate / count : 0;
        context.write(key, new Text(String.format("%.2f%%", avgSuccessRate)));
    }
}
