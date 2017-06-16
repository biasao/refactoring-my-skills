# Refactoring my skills

This repository contains the source code related to my studies of Algorithms, Data Structures, Java, etc. I'm currently working to refactor my skills, and my goal here is to become a better professional, by reviewing the basic Computer Science that I learnt at the University (a long long time ago, in a galaxy far far away ... ).

The repository contains 3 sections:

-   `assignments`: contains the programming assignments solved on platforms such as [HackerRank](https://www.hackerrank.com), [HackerEarth](https://www.hackerearth.com), etc.
-   `tools`: contains scripts to run the assignments in a similar way that they run on the platforms.
-   `training`: contains code related to tutorials, articles, tests, etc.


## Running the assignments code

I'm building my code using Java, so I built a small script to build, run and the assignment code, using an input/output file to check the result.


### Running assignments with input and output file

For instance, suppose that you want to run the code at `assignments/hackerrank/algorithms/dynamic-programming/the-coin-change-problem`. You can run the following commands:

```sh
cd assignments/hackerrank/the-coin-change-problem
../../../tools/runner-with-input input1.txt output1.txt
```

You should see the following output:

```
╰─$ ../../../tools/runner-java input1.txt output1.txt
Compiling Solution.java ...
----------------------------------------
Code compiled!

Running Solution ...
----------------------------------------
4

real	0m0.142s
user	0m0.126s
sys	0m0.037s

Checking output ...
----------------------------------------
Test passed!
```


### Running assignments with output file only

For method only assignments, you might want to run your solution using a programmatic input. For instance, suppose that you want to run the code at `assignments/hackerrank/data-structures/trees/preorder-traversal`. You can run the following commands:

```sh
╰─$ runner-java-no-input output.txt                                       1 ↵
Compiling Solution.java ...
----------------------------------------
Code compiled!

Running Solution ...
----------------------------------------
3 5 1 4 2 6

real   	0m0.171s
user   	0m0.117s
sys    	0m0.028s

Checking output ...
----------------------------------------
Test passed!
```

## Running assignments using docker
It is also possible to perform the assignments using docker containers. Currently docker-compose supports openjdk 7,8 and 9. The two runners -- `runner-with-input` and `runner-java-no-input` -- are included into the PATH. Hence you may perform the tests like this:

```
sudo docker-compose run --rm jdk-8 bash -c "
        cd /assignments/hackerrank/algorithms/strings/anagram;
        runner-with-input input1.txt output1.txt
        "
```

This is a one-timer execution, after that container will be destroyed -- `--rm` takes care of that. If you want to interact within the container, you may connect to it like this:

`sudo docker-compose run jdk-8 /bin/bash`

All the assignments are mapped to a volume at `/assignments`.

### Using JShell for Read–eval–print loop (REPL)
Java 9 features a REPL for statements interpretation called `jshell`. Using this tool it is possible to test code snippets rapidly without creating a project. The `docker-compose` offers basic support for `jshell`:

`docker-compose run --rm jshell`

It is also possible to load a java classes upon `jshell` opening, by setting the path to them:

`docker-compose run --rm jshell jshell assignments/hackerrank/algorithms/strings/anagram/*`

Once loaded it is possible to `/list` them and use or execute any piece of code: 
