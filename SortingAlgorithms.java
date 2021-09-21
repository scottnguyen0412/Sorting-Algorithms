package Week3.java;

import java.util.Arrays;
import java.util.Random;

public class SortingAlgorithms {
	int n;	//size of array
	int A[]; //elements need to be sorted
	SortingAlgorithms() //constructor
	{
		
	}
	SortingAlgorithms(int size)
	{
		n= size;
		A = new int[n]; // create array A in size n
	}
	void Input()
	{
		Random rd = new Random();
		for(int i = 0; i<n; i++)
			A[i] = rd.nextInt(100);	//generate random numbers from 0-99
	}
	void SelectionSort()
	{
		for(int i =0; i<n; i++) //n times
		{
			//select min element and swap with A[i]
			int min = i;
			for(int j =i; j<n; j++) // n times
			{
				if(A[j] <A[min])
				{
					min =j; // min is element 
				}
				if(min != i)
				{
					 //Swap A[i] and A[min]
					int tmp = A[i];
					A[i] = A[min];
					A[min] = tmp;
				}
				
			}
		}
	}
			
	void InsertionSort()
	{
		for(int i =0; i<A.length; i++) // for loop to check size of array
		{
			int j= i; // j to check for the ascending order of elements in the list
		
		while(j>0 && A[j-1]> A[j])
		{
			int key = A[j];
			A[j] = A[j-1];
			A[j-1] = key;
			j = j-1;
		}
		}
	}
	void BubbleSort()
	{
		for(int i =0; i<n -1; i++)
		{
			for(int j=0; j <n-i-1; ++j)
			{
				if(A[j+ 1]<A[j])
				{
					int swap = A[j];
					A[j] = A[j+1];
					A[j+1] = swap;
				}
			}
		}
	}
	
	void QuickSort(int left, int right)
	{
		if(left>= right) //base case = Dieu kien dung
		{
			return;
		}
		else
		{
			int pivot = A[(left+ right)/2];
			
			//move elements to left, right
			int up = left;
			int down = right;
			do {
				while(A[up] < pivot)
				{
					up++;
				}
				
				while(A[down]>pivot)
				{
					down--;
				}
				
				if(up <= down)
				{
					//swap B[up] and B[down]
					int tmp = A[up];
					A[up] = A[down];
					A[down] = tmp;
					up++;
					down--;
				}
			}while(up <=down);
			QuickSort(left, down); // call Quicksort for the left A
			QuickSort(up, right); //call Quicksort for the right A
		}
	}
	void merge(int l, int m, int r)	//Merge 2 sub_arrays
    {
        int n1 = m - l + 1;			//Size of left sub array
        int n2 = r - m;				//Size of right sub array
        int L[] = new int[n1];		//Create left temp arrays 
        int R[] = new int[n2];		//Create right arrays 
        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = A[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = A[m + 1 + j];
        /* Merge the temp arrays */
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) 
        {
            if (L[i] <= R[j]) 
            {
                A[k] = L[i];	//Get the element from the left array
                i++;
            }
            else {
                A[k] = R[j];	//Get the element from the right array
                j++;
            }
       
        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            A[k] = L[i];
            i++;
            k++;
        }
        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            A[k] = R[j];
            j++;
            k++;
        }
    }
    }
	void MergeSort(int left, int right)
    {
        if (left < right) {
            int m =left+ (right-left)/2;		// Find the middle point
            MergeSort(left, m);  		//Call Recursive MergeSort to Sort the left halve
            MergeSort(m + 1, right);	//Call Recursive MergeSort to Sort the right halve
            merge(left, m, right);	 		// Merge the sorted halves
        }
    }
	public static void main(String[] args) {
		SortingAlgorithms Sort = new SortingAlgorithms(10000);
		double start, end , time;
		double before, after, space;
		//Selection Sort
		System.out.println("-----------------Selection Sort-------------------");
		Sort.Input();
		//System.out.println("Before Selection: ");
		//System.out.println(Arrays.toString(Sort.A));
		
		start = System.currentTimeMillis();
		before = Runtime.getRuntime().freeMemory();
		Sort.SelectionSort();
		end = System.currentTimeMillis();
		after = Runtime.getRuntime().totalMemory();
		
		//System.out.println("After Selection: ");
		//System.out.println(Arrays.toString(Sort.A));
		time = end - start;
		//space = before- after;
		System.out.printf("Time Selection Sort: %.1f ms", time);
		System.out.printf("\nSpace: %.1f KB", (double)((after - before) / 1024));
		
		//Insertion Sort
		System.out.println("\n------------------Insertion Sort-------------------");
		Sort.Input();
		//System.out.println("Before Insertion: ");
		//System.out.println(Arrays.toString(Sort.A));
		
		start = System.currentTimeMillis();
		before = Runtime.getRuntime().freeMemory();
		Sort.InsertionSort();
		end = System.currentTimeMillis();
		after = Runtime.getRuntime().totalMemory();
		
		//System.out.println("After Insertion: ");
		//System.out.println(Arrays.toString(Sort.A));
		time = end - start;
		//space = before- after;
		System.out.printf("Time Insertion Sort: %.1f ms", time);
		System.out.printf("\nSpace: %.1f KB", (double)((after - before) / 1024));
		
		//Bubble Sort
		System.out.println("\n------------------Bubble Sort--------------------");
		Sort.Input();
		//System.out.println("Before Bubble: ");
		//System.out.println(Arrays.toString(Sort.A));
		
		start = System.currentTimeMillis();
		before = Runtime.getRuntime().freeMemory();
		Sort.BubbleSort();
		end = System.currentTimeMillis();
		after = Runtime.getRuntime().totalMemory();
		
		//System.out.println("After Bubble: ");
		//System.out.println(Arrays.toString(Sort.A));
		time = end - start;
		//space = before- after;
		System.out.printf("Time Bubble Sort: %.1f ms", time);
		System.out.printf("\nSpace: %.1f KB", (double)((after - before) / 1024));
		
		//Quick Sort
		System.out.println("\n------------------Quick Sort------------------");
		Sort.Input();
		//System.out.println("Before QuickSort: ");
		//System.out.println(Arrays.toString(Sort.A));
		
		start = System.currentTimeMillis();
		before = Runtime.getRuntime().freeMemory();
		Sort.QuickSort(0, Sort.n-1);
		end = System.currentTimeMillis();
		after = Runtime.getRuntime().totalMemory();
		
		//System.out.println("After Quicksort: ");
		//System.out.println(Arrays.toString(Sort.A));
		time = end - start;
		//space = before - after;
		System.out.printf("Time Quick Sort: %.1f ms", time);
		System.out.printf("\nSpace: %.1f KB", (double)((after - before) / 1024));
		
		
		//Merge Sort
		System.out.println("\n------------------------Merge Sort---------------------");
		Sort.Input();
		//System.out.println("Before Merge Sort: ");
		//System.out.println(Arrays.toString(Sort.A));
		
		start = System.currentTimeMillis();
		before = Runtime.getRuntime().freeMemory();
		Sort.MergeSort(1, Sort.n-1);
		end = System.currentTimeMillis();
		after = Runtime.getRuntime().totalMemory();
		
		//System.out.println("After Merge sort: ");
		//System.out.println(Arrays.toString(Sort.A));
		time = end - start;
		//space = before - after;
		System.out.printf("Time Merge Sort: %.1f ms", time);
		System.out.printf("\nSpace: %.1f KB", (double)((after - before) / 1024));
	}

}
