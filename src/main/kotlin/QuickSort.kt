fun quickSort() { //main()
    val arr = arrayOf(17, 20, 1, 0, 34, 2, 8)
    val l = 0
    val r = arr.size - 1  // l and r specify the section of array to be sorted
    val result = QuickSort().sort(arr, l, r)
    println(result.contentToString())
}

class QuickSort() {

    private lateinit var sortArr: Array<Int>

    fun sort(arr: Array<Int>, l: Int, r: Int): Array<Int> {
        sortArr = arr
        if (l >= r) {
            return sortArr  //no action
        }

        var pivot = partition(sortArr, l, r)

        /*To sort both left and right sections of pivot*/
        sort(sortArr, l, pivot - 1)
        sort(sortArr, pivot + 1, r)

        return sortArr
    }

    /*we create a pivot. All elements lesser than the pivot will be moved to left of pivot and all elements
     greater than the pivot will be moved to the right of pivot*/
    fun partition(arr: Array<Int>, l: Int, r: Int): Int {
        var pivot = arr[r]
        var i = l - 1 // i is the position of last element evaluated as less than pivot

        for (j in l until r) {
            if (arr[j] < pivot) {
                i += 1
                var swap = arr[i]
                arr[i] = arr[j]
                arr[j] = swap
            }
        } //after this loop up to i are less than pivot and after i are grater than pivot

        //move the pivot in mid of the sections created by i
        var swap2 = arr[i + 1]
        arr[i + 1] = arr[r]
        arr[r] = swap2
        sortArr = arr

        return i + 1

    }
}