package ch10sortsearch;

/**
 * 10.4 줄당 하나의 문자열이 들어 있는 20GB짜리 파일이 있다고 하자.
 *      이 파일을 정렬하려면 어떻게 해야 하겠는지 설명하라.
 * 
 * (4E) ---> (5E) None
 * 9.4 If you have a 2 GB file with one string per line, 
 *     which sorting algorithm would you use to sort the file and why?
 * 
 * (6E)
 * 10.6 Sort Big File: Imagine you have a 20 GB file with one string per line. 
 *                     Explain how you would sort the file.
 *                     
 *                     Hints: 
 *                     #207
 */
public class SortingSearching04 {
    // a size limit of 20 GB
    // --> it suggests that they don't want you to bring all the data into memory.
    //
    // We only bring part of data into memory.
    // We'll divide the file into chunks, which are x MB
    // , where x is the amount of memory we have available
    //
    // --> Each chunks is sorted separately and then saved back to the file system.
    //
    // Once all the chunks are sorted,
    // --> we merge the chunks, one by one
    //
    // ==> known as "External sort"

    // http://www.geeksforgeeks.org/external-sorting
    // - can handle massive amout of data
    // - is required when the data being sorted do not fit into the main memory (usually RAM) and instead they must reside in the slower external memory (usually a hard drive)
    // - typically uses a hybrid sort-merge strategy
    //   - in the sorting phase, chunks of data small enough to fit in main memory are read, sorted, and written out to a temporary file.
    //   - in the merge phase, the sorted sub-files are combined into a single larger file.
    //
    // a run : part of file that is small enough to fit in main memory
    // 
    // - MergeSort ---> Merge K Sorted Arrays
    //   - http://www.geeksforgeeks.org/merge-sort/
    //   - http://www.geeksforgeeks.org/merge-k-sorted-arrays/ 

    //TODO: External Sort
    //TODO: MergeSort
    //TODO: Merger K Sorted Array or N-way merge
}
