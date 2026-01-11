/*
 * Distributed Data Processing Project | Hadoop, Java
 *
 * Author: Avoy Tejada
 *
 * Description:
 * Implements a Hadoop MapReduce job for processing advertisement data.
 * Extracts category, location, clicks, and sales to compute aggregated
 * statistics per category-location pair.
 */


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class Driver
{
    //***************************************************************
    //
    //  Method:       main
    //
    //  Description:  Configures and runs Hadoop job
    //
    //  Parameters:   String array args
    //
    //  Returns:      N/A
    //
    //***************************************************************
    public static void main(String[] args) throws Exception
    {
        if (args.length != 2)
        {
            System.err.println("Usage: Driver <input path> <output path>");
            System.exit(-1);
        }

        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "MapReduce Data Analysis");

        job.setJarByClass(Driver.class);
        job.setMapperClass(Mapper.class);
        job.setReducerClass(Reducer.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
