# Distributed Data Processing Project (Hadoop MapReduce)

Process large datasets by aggregating advertisement metrics using Hadoop and Java.

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

**Input CSV line:**
```
123,ProductA,New York,Clothing,50,200,...
```

**Mapper output (key-value pair):**
```
Clothing,New York    200,50
```

**Reducer output (aggregated totals for same category-location):**
```
Clothing,New York    totalSales=1234, totalClicks=456
```
