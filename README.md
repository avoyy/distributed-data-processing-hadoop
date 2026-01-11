# Distributed Data Processing Project | Hadoop, Java

## Description
This project implements a Hadoop MapReduce job that processes advertisement data.
It aggregates clicks and sales by category and location, demonstrating distributed
data processing principles.

## Features
- Hadoop MapReduce implementation (Mapper, Reducer, Driver)
- Input data parsing and validation
- Aggregation of metrics per category-location pair
- Utility methods for data processing

## Files
- `Driver.java` — Configures and runs the Hadoop job
- `Mapper.java` — Parses input lines and emits key-value pairs
- `Reducer.java` — Aggregates values and computes totals
- `Utils.java` — Helper functions

## Usage
1. Compile all Java files:
   ```bash
   javac -cp $(hadoop classpath) *.java
2. Create a jar file:
   ```bash
   jar cf distributed-data-processing.jar *.class
4. Run on Hadoop:
   ```bash
   hadoop jar distributed-data-processing.jar Driver /input/path /output/path

## Example Input/Output
Input CSV: id,product,location,category,clicks,sales,other_fields
Output: category,location    total_sales,total_clicks
