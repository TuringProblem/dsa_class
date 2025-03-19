import random

# @author { @Override } | @since 20250318 : 19:57


def shellsort(array: list[int], startIndex: int, gap: int) -> list[int]:
    swaps: int = 0
    for i in range(startIndex + gap, len(array)):
        j: int = i
        while j - gap >= startIndex and array[j] < array[j - gap]:
            swaps += 1
            array[j], array[j - 1] = array[j - 1], array[j]
            j -= gap
    return array


def handleInput(array: list[int]) -> list[int]:
    indexValue: int = int(input("Please enter the starting index "))
    gapValue: int = int(input("Please enter the gap value: "))
    sorted: list[int] = shellsort(array, indexValue, gapValue)
    return sorted


def main():
    testList: list[int] = [random.randint(1, 100) for _ in range(20)]
    print(f"Unsorted list: {testList}")
    print(f"Sorted List: {handleInput(testList)}")


main()
