# @author { @Override } | @date 20250318 @ 14:15


def binarySearch(array: list[int], target: int) -> int:
    low: int = 0
    high: int = len(array) - 1
    while low <= high:
        m: int = low + (high - low) // 2
        if array[m] == target:
            return m
        elif array[m] < target:
            low = m + 1
        else:
            high = m - 1
    return -1  # Target not found


def main():

    # Won't work because it is NOT IN ORDER!
    myList: list[int] = [55, 80, 69, 88, 15, 66]
    print(f"Array before search: {myList}")
    print(f"Key searched: {binarySearch(myList, 88)}")

    # Will work because is in order
    sortedList: list[int] = [15, 25, 35, 45, 55, 65, 99, 101, 155]
    print(f"Array before search: {sortedList}")
    print(f"index[{binarySearch(sortedList, 55)}]")


main()
