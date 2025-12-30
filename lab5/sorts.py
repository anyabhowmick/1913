# Lab 5, list partners here!
# anya bhowmick and felicia tao


# LAB5 has a substantial written Q&A component as well. You answer these questions by updating the
# multi-line strings below to indicate your answer. It's a bit hokey, but it works.

# Question 1: Which image file you submitted covers which analysis case?
Answer1 = """
each graph is labelled on the pdf 
"""

# Question 2: For each algorithm, explain how you see it behaving in your images.
# If the algorithm's behavior differed case-by-case say this and explain how it behaved in each case.

Answer2_insertion = """
insertion grew the fastest in the backwards case in terms of number of comparisons,
but for both sorted and near sorted it was slow and comparable with merge sort 
for random, it grew the second fastest
"""

Answer2_selection = """
selection consistently had the most comparisons because it always compares every element with each other, no matter what"""

Answer2_merge = """
marge constistently had the least number of comparisons for every file 
"""


# Question 3: For each algorithm, What is the theoretical expectation. I.E. what is the expected big-O runtime behavior.
# If the algorithm's expected behavior differs case-by-case say this and explain how it is
# expected to behave case-by-case. (You should be able to find this information in the textbook.
# If not we will discuss this in class)

Answer3_insertion = """
for sorted and near sorted, there are the fewest comparisons because the while loop doesnt have to run as often
for the backwards case, the while loop had to always run because the list at index i was always more than index i+1
for random, the curve wavered because the number of comparisons changed, but it was still slower than selection"""

Answer3_selection = """
selection had to make the most comparisons for all comparisons, which makes sense because it only has for loops and no while loops,
so it runs a consistent number of times based off n (O(n^2))
"""

Answer3_merge = """
merge always had the least comparisons because """


# Question 4: For each algorithm, How did the observed behavior match the theoretical behavior? Again, if your answer
# differs case by case, say that here and explain your findings for each case.

Answer4_insertion = """
it matched because the graphs show insertion having few comparisons for sorted and near sorted, but more for random and 
the most for backwards
"""

Answer4_selection = """
it matched because the number of comparisons was consistent regardless of the order """

Answer4_merge = """
it matched that it had the least number of comparisons for every file type"""


# Question 5: Merge sort is theoretically the fastest algorithm, are there
# cases where another algorithm might be faster?

Answer5 = """
in really small lists, it might be faster to use selection sort. it would also save time because it's easier 
to write than merge sort or insertion sort """


# Question 6: If you didn't know the order of data you might want to sort,
# what algorithm might you use to sort it, and why?

Answer6 = """
I'd use merge sort because it consistently performed the best regardless of the data type 
it's long to write, but it's the most efficient and grows the slowest
"""


# Selection, Insertion, and Merge sorts -- taken from ZyBooks.
# Not too different, its still the same algorithm, they just did it using less memory than I did
# (Which leads to a slightly harder to understand piece of code)



def selection_sort(numbers):
    """sorts the values in place (without creating a new list) and returns the number of comparisons made
    finds the smallest value and swaps it with i, which ++'s from 0 to iterate through every element in numbers
    """
    comparisonCount = 0 
    for i in range(len(numbers) - 1):
        # Find index of smallest remaining element
        index_smallest = i
        for j in range(i + 1, len(numbers)):
            comparisonCount += 1
            if numbers[j] < numbers[index_smallest]:
                index_smallest = j

        # Swap numbers[i] and numbers[index_smallest]
        temp = numbers[i]
        numbers[i] = numbers[index_smallest]
        numbers[index_smallest] = temp
    return comparisonCount


def insertion_sort(numbers):
    """sorts the values in place using insertion sort and returns the number of comparisons made
    insertion sort part the list into two, the unsorted right and the sorted left 
as it moves down the list, it moves each item into the proper place on the left
    """
    comparisonCount = 0
    for i in range(1, len(numbers)):
        j = i
        # Insert numbers[i] into sorted part
        # stopping once numbers[i] in correct position
        # KLUVER NOTE - PLEASE READ - so this line is a bit tricky. Technically, if j > 0 then numbers would not be compared
        #               to make things easier you can assume that every time the list condition is checked one array element
        #               comparison occurs. That is -- you can ignore the short-circuit evaluatio of the logical and in this
        #               counting problem.
        comparisonCount += 1
        while j > 0 and numbers[j] < numbers[j - 1]:
            # Swap numbers[j] and numbers[j - 1]
            comparisonCount += 1
            temp = numbers[j]
            numbers[j] = numbers[j - 1]
            numbers[j - 1] = temp
            j = j - 1
    return comparisonCount


def merge(numbers, i, j, k):
    """Given two sorted sub-lists create one sorted list. This is done in-place, meaning we are given one list
    and expected to modify the list to be sorted. Furthermore, this operates on "sub-lists" (a specific range of the list)
    The list named numbers may contain other types of data than just numbers
    the variables i, j, and k are all indices into the numbers list
    So the part of the list to be sorted is from position i to k (inclusive) with i to j being one sorted list, and j+1 to k being another.
    this function returns the number of comparisons made when sorting the list
    """
    comparisonCount = 0
    merged_size = k - i + 1  #  Size of merged partition
    merged_numbers = []  #  Temporary list for merged numbers
    for l in range(merged_size):
        merged_numbers.append(0)

    merge_pos = 0  #  Position to insert merged number

    left_pos = i  #  Initialize left partition position
    right_pos = j + 1  #  Initialize right partition position

    #  Add smallest element from left or right partition to merged numbers
    while left_pos <= j and right_pos <= k:
        comparisonCount += 1
        if numbers[left_pos] < numbers[right_pos]:
            merged_numbers[merge_pos] = numbers[left_pos]
            left_pos = left_pos + 1
        else:
            merged_numbers[merge_pos] = numbers[right_pos]
            right_pos = right_pos + 1
        merge_pos = merge_pos + 1

    #  If left partition is not empty, add remaining elements to merged numbers
    while left_pos <= j:
        merged_numbers[merge_pos] = numbers[left_pos]
        left_pos = left_pos + 1
        merge_pos = merge_pos + 1

    #  If right partition is not empty, add remaining elements to merged numbers
    while right_pos <= k:
        merged_numbers[merge_pos] = numbers[right_pos]
        right_pos = right_pos + 1
        merge_pos = merge_pos + 1

    #  Copy merge number back to numbers
    merge_pos = 0
    while merge_pos < merged_size:
        numbers[i + merge_pos] = merged_numbers[merge_pos]
        merge_pos = merge_pos + 1

    return comparisonCount



def merge_sort_recursive(numbers, i, k):
    count = 0
    """Sort the sub-list in numbers from position i to k (inclusive)
    returns the number of comparisons made """
    if i < k:
        j = (i + k) // 2  #  Find the midpoint in the partition

        #  Recursively sort left and right partitions
        # KLUVER NOTE - PLEASE READ - you should think about these two function calls as returning a count of
        #     comparisons. Naturally the comparisons done by those function-calls will count against this function-call.
        #     make sure you're not ignoring the return values on the following two lines.
        count += merge_sort_recursive(numbers, i, j)
        count += merge_sort_recursive(numbers, j + 1, k)

        #  Merge left and right partition in sorted order
        count += merge(numbers, i, j, k)

        return count 
    else:
        return 0



def merge_sort(numbers):
    """Sort a list of numbers
    returns the number of comparisons made 
    """
    return merge_sort_recursive(numbers, 0, len(numbers) - 1)
    
