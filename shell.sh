#!/bin/sh

# Step 1: Create directories on hadoop
hadoop dfs -mkdir /mahout_data
hadoop dfs -mkdir /mahout_seq
hadoop dfs -mkdir /centroids
hadoop dfs -mkdir /clustered_data


# Step 2:Copy now your text folder to hdfs folder

hadoop dfs -copyFromLocal /home/ritika/Desktop/papers  /mahout_data
hadoop dfs -copyFromLocal /home/ritika/Desktop/centroids  /centroids

# Step 3: Convert text files in the hadoop folder to sequence format:

mahout seqdirectory  \
-i  /mahout_data  \
-o  /mahout-seq  \
-xm sequential

# Step 4: Convert sequence format to sparse vector format

mahout seq2sparse \
   -i  /mahout_seq/  \
-o   /mahout_seq/finalvectors

# Step 5: Create k-means cluster now:

mahout kmeans -i /mahout_seq/finalvectors/tfidf-vectors/  \
-c /centroids  \
-o /clustered_data   \
-dm org.apache.mahout.common.distance.CosineDistanceMeasure  \
-cl   -x  10  -k  5


# Step 6: Print file names vs clusters using mahout seqdumper

mahout seqdumper  \
-i /clustered_data/clusteredPoints/part-m-00000 > tmp.txt

