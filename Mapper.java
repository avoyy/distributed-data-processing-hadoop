/*
 * Distributed Data Processing Project | Hadoop, Java
 *
 * Author: Avoy Tejada
 *
 * Description:
 * Mapper class for Hadoop MapReduce job. Reads 
 * advertisement data, extracts category, location, 
 * clicks, and sales, and emits key-value pairs.
 */

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.io.IOException;

public class Mapper extends Mapper<Object, Text, Text, Text>
{
    //***************************************************************
    //
    //  Method:       map
    //
    //  Description:  Reads input, extracts fields, and emits key-value pairs
    //
    //  Parameters:   Object key, Text value, Context context
    //
    //  Returns:      N/A
    //
    //***************************************************************
    public void map(Object key, Text value, Context context) throws IOException, InterruptedException
    {
        String line = value.toString();
        String[] tokens = line.split(",");

        if (tokens.length == 7)
        {
            String location = tokens[2].trim();
            String category = tokens[3].trim();
            int clicks = Integer.parseInt(tokens[4].trim());
            int sales = Integer.parseInt(tokens[5].trim());

            if (clicks > 0)
            {
                String outputKey = category + "," + location;
                String outputValue = sales + "," + clicks;
                context.write(new Text(outputKey), new Text(outputValue));
            }
        }
    }
}
