# Refactoring my skills

This repository contains the source code related to my studies of Algorithms, Data Structures, Java, etc. I'm currently working to refactor my skills, and my goal here is to become a better professional, by reviewing the basic Computer Science that I learnt at the University (a long long time ago, in a galaxy far far away ... ).

The repository contains 3 sections:

-   `assignments`: contains the programming assignments solved on platforms such as [HackerRank](https://www.hackerrank.com), [HackerEarth](https://www.hackerearth.com), etc.
-   `tools`: contains scripts to run the assignments in a similar way that they run on the platforms.
-   `training`: contains code related to tutorials, articles, tests, etc.


## Running the assignments code

I'm building my code using Java, so I built a small script to build, run and the assignment code, using an input/output file to check the result.

For instance, suppose that you want to run the code at `assignments/hackerrank/the-coin-change-problem`. You can run the following commands:

```sh
cd assignments/hackerrank/the-coin-change-problem
../../../tools/runner-java.sh input1.txt output1.txt
```

You should see the following output:

```
Cleaning ...
----------------------------------------
Cleaned!

Compiling ...
----------------------------------------
Code compiled!

Running ...
----------------------------------------
4

Checking output ...
----------------------------------------
Test passed!
```
