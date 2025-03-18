def insertionsort(array: list[int]) -> list[int]:
    for i in range(1, len(array)):
        j: int = i
        while j > 0 and array[j] < array[j - 1]:
            array[j], array[j - 1] = array[j - 1], array[j]
            j -= 1

    return array


def main():
    unsortedList: list[int] = [25, 15, 10, 5, 99, 59, 69, 81, 1, 19, 88]
    print(
        f"List before sorted: {unsortedList}\nList after sorted: {insertionsort(unsortedList)}"
    )


main()
