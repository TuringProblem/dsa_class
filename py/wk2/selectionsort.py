import random


def selectionsort(array: list[int]) -> list[int]:
    for i in range(len(array) - 1):
        smallestIndex: int = i
        for j in range(i + 1, len(array)):
            if array[j] < array[smallestIndex]:
                smallestIndex = j

        array[i], array[smallestIndex] = array[smallestIndex], array[i]
    return array


def main():
    testArray: list[int] = [random.randint(1, 100) for _ in range(10)]
    print(
        f"Array before sorted: {testArray}\nArray after sorted: {selectionsort(testArray)}"
    )


main()
