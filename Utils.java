/*
 * Distributed Data Processing Project | Hadoop, Java
 *
 * Author: Avoy Tejada
 *
 * Description:
 * Utility class with helper methods for data processing.
 */

public class Utils
{
    //***************************************************************
    //
    //  Method:       calculateSuccessRate
    //
    //  Description:  Computes success rate given sales and clicks
    //
    //  Parameters:   int sales, int clicks
    //
    //  Returns:      double
    //
    //***************************************************************
    public static double calculateSuccessRate(int sales, int clicks)
    {
        return clicks > 0 ? ((double) sales / clicks) * 100 : 0;
    }
}
