from random import randrange


def swap(arr, i, j):
    arr[i], arr[j] = arr[j], arr[i]


def choosePivot(arr, lo, hi):
    p = randrange(lo, hi)
    swap(arr, hi, p)
    return


def partition(arr, lo, hi):
    i = lo - 1

    for j in range(lo, hi):
        if arr[j] <= arr[hi]:
            i += 1
            swap(arr, i, j)

    swap(arr, i+1, hi)
    return i+1


def qSort(arr, lo, hi):
    # if lo == hi+1:
    #     return
    # if lo > hi+1:
    #     raise "impossible value for lo/hi"

    if lo < hi:
        choosePivot(arr, lo, hi)
        p = partition(arr, lo, hi)
        qSort(arr, lo, p - 1)
        qSort(arr, p + 1, hi)


"""
# arr = [10, 3, 1]
arr = [10, 3, 1, 7, 15, 8, 5]
#                          hi
#     [3, 10, 1, 7, 15, 8, 5]
#     [3, 1, 10, 7, 15, 8, 5]
#             i            j
#     [3, 1, 5, 7, 15, 8, 10]
#     [3, 1,                ] => [1, 3]  lo = 0 hi = -1
#     [      5              ]
#     [         7, 15, 8, 10]

#     [  [ <=p ] [ >p ] [ ? ]   ]

print(arr)
qSort(arr, 0, len(arr)-1)
print(arr)
 """


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
