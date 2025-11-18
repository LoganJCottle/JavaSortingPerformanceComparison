[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-2972f46106e565e64193e422d61a12cf1da4916b45550586e14ef0a7c637dd04.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=21603260)
# HWi4
This repository times the performance of several different sorting algorithms (all found from GeeksForGeeks) that I created for my CSCI-3302 class. The algorithms are tested on small, medium, and large arrays ranging from sizes 100 to 1,000,000.

The sorting algorithms tested are as follows: Heap Sort, Selection Sort, Radix Sort, Merge Sort, QuickSort, and the built in Arrays.sort from the Java library.

NOTE: it takes a few minutes for all the algorithms to finish (selection sort slows the program by a lot) so please be patient.

Findings: 

I found that some arrays (such as Selection sort) take quite some time when datasets increase in size. Whereas Quicksort, Heap sort, and Merge sort were the fastest sorting algorithms for large datasets. The same algorithms were also the fastest with smaller datasets; however, the sorting time difference is much smaller for the smaller datasets. These results matched my expectations for the algorithms, especially with selection sort taking marginally longer than every other algorithm I tested.

I expected the int array to be faster because it uses primitive type variable. This turned out to be accurate; as the Integer array took about twice as long to sort as the int array did.
