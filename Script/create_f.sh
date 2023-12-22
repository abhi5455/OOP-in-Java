#!/bin/bash


for i in $(seq 1 $1);
do
  > "Pgm"$i$2".java"
	> "Pgm"$i"_algo.txt"
	> "Pgm"$i"_out.txt"
done
