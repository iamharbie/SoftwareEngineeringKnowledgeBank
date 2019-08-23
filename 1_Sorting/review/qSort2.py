from random import randrange


def swap(arr, i, j):
    arr[i], arr[j] = arr[j], arr[i]


def partition(arr, lo, hi):
    i = lo - 1

    for j in range(lo, hi):
        if arr[j] <= arr[hi]:  # TODO: Check if this makes the algorithm stable
            i += 1
            swap(arr, i, j)

    swap(arr, i+1, hi)
    return i+1


def choosePivot(arr, lo, hi):
    p = randrange(lo, hi)
    swap(arr, p, hi)
    return


def qSort(arr, lo, hi):
    if lo < hi:
        choosePivot(arr, lo, hi)
        p = partition(arr, lo, hi)
        qSort(arr, lo, p-1)
        qSort(arr, p+1, hi)


if __name__ == "__main__":
    # input
    arr2D = [[], [1], [2, 2], [10, 7, 8, 2, 1, 5],
             [1, 1, 1, 1, 1, 1, 1, 1, 1], [10, 3, 1], [3, 10, 1, 7, 15, 8, 5]]
    print(arr2D)

    # process
    for arr in arr2D:
        qSort(arr, 0, len(arr)-1)

    # output
    print(arr2D)
    assert arr2D == [[], [1], [2, 2], [
        1, 2, 5, 7, 8, 10], [1, 1, 1, 1, 1, 1, 1, 1, 1], [1, 3, 10], [1, 3, 5, 7, 8, 10, 15]]


#  1 5 4 3 2
