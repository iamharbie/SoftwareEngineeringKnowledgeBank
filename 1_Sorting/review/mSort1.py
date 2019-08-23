def mSort(arr):
    if len(arr) > 1:
        m = len(arr)//2
        L = arr[:m]
        R = arr[m:]

        mSort(L)
        mSort(R)

        i = j = k = 0
        while i < len(L) and j < len(R):
            if L[i] <= R[j]:  # TODO: c check < vs <= diff
                arr[k] = L[i]
                i += 1
            else:
                arr[k] = R[j]
                j += 1
            k += 1

        while i < len(L):
            arr[k] = L[i]
            i += 1
            k += 1

        while j < len(R):
            arr[k] = R[j]
            j += 1
            k += 1


if __name__ == "__main__":
    # input
    arr2D = [[], [1], [2, 2], [10, 7, 8, 2, 1, 5],
             [1, 1, 1, 1, 1, 1, 1, 1, 1], [10, 3, 1], [3, 10, 1, 7, 15, 8, 5]]
    print(arr2D)

    # process
    for arr in arr2D:
        mSort(arr)

    # output
    print(arr2D)
    assert arr2D == [[], [1], [2, 2], [
        1, 2, 5, 7, 8, 10], [1, 1, 1, 1, 1, 1, 1, 1, 1], [1, 3, 10], [1, 3, 5, 7, 8, 10, 15]]


#  1 5 4 3 2
