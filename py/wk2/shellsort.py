import random

# @author { @Override } | @since 20250318 : 19:57


def insertionsortInterleaved(array: list[int], startIndex: int, gap: int) -> int:
    swaps: int = 0
    for i in range(startIndex + gap, len(array)):
        j: int = i
        while j - gap >= startIndex and array[j] < array[j - gap]:
            swaps += 1
            array[j], array[j - 1] = array[j - 1], array[j]
            j -= gap
    return swaps 


def shellsort(array: list[int], gapValues: list[int]) -> int:
    totalSwaps: int = 0
    for i in range(0, len(gapValues)):






def main():
    testList: list[int] = [random.randint(1, 100) for _ in range(20)]
    print(f"Unsorted list: {testList}")
    print(f"Sorted List: {handleInput(testList)}")


main()
