def mSort(arr):
    if len(arr) > 1:
        m = len(arr)//2
        L = arr[:m]
        print(L)
        R = arr[m:]  # TODO: mid + 1?
        mSort(L)
        mSort(R)

        i = j = k = 0

        while i < len(L) and j < len(R):
            if L[i] <= R[j]:  # todo: this should be <=, right?
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
        # print(arr)


arr = [10, 8, 3, 27]
print(arr)
mSort(arr)
print(arr)
