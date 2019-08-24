"""
################### qSort() ###################
    #             => [10, 7, 8, 2, 1, 5]
    #                                 p
    #                       p
    # partition() => [2, 1, 5, 10, 7, 8]
    # qSort()     => [2, 1]
    # qSort()     =>          [10, 7, 8]
###############################################
################# partition() #################
        # for():
        #            [10, 7, 8, 2, 1, 5]
        # swap =>      i        j
        #            [2, 7, 8, 10, 1, 5]
        # swap =>        i         j
        #            [2, 1, 8, 10, 7, 5]
    #  swap    =>          i+1        p
    #                [2, 1, 5, 10, 7, 8]
    # return   =>           p
###############################################
 """


def swap(arr, i, j):
    arr[i], arr[j] = arr[j], arr[i]


def partition(arr, lo, hi):
    # assumption: arr[hi] == pivot
    i = lo - 1

    for j in range(lo, hi):
        if arr[j] <= arr[hi]:
            i += 1
            swap(arr, i, j)

    swap(arr, i+1, hi)
    return i+1


def qSort(arr, lo, hi):
    if lo < hi:
        p = partition(arr, lo, hi)
        qSort(arr, lo, p-1)
        qSort(arr, p+1, hi)


if __name__ == "__main__":
    # input
    arr2D = [[], [1], [2, 2], [10, 7, 8, 2, 1, 5], [1, 1, 1, 1, 1, 1, 1, 1, 1]]
    print(arr2D)

    # process
    for arr in arr2D:
        qSort(arr, 0, len(arr)-1)

    # output
    print(arr2D)
    assert arr2D == [[], [1], [2, 2], [
        1, 2, 5, 7, 8, 10], [1, 1, 1, 1, 1, 1, 1, 1, 1]]
