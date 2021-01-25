fun binarySearch() { //main()

    val arr = arrayOf(-2, 0, 2, 4, 7, 10, 16, 20)
    val target = 10
    val binarySearch = BinarySearch(arr, target)
    val result = binarySearch.search()
    println(result)

}

class BinarySearch(val arr: Array<Int>, val target: Int) {

    var leftIndex = 0
    var rightIndex = arr.count() - 1

    fun search(): Int {

        while (leftIndex <= rightIndex) {
            var midPos = (leftIndex + rightIndex) / 2
            if (arr[midPos] == target)
                return midPos
            else if (target < arr[midPos])
                rightIndex = midPos - 1
            else
                leftIndex = midPos + 1
        }

        return -1 //not found
    }

}