package ru.adavliatov.task2;

/**
 * Assumptions:
 * 1. int is enough for both input and sum (also partial), Otherwise, long (if applicable), BigInteger, ...
 * 2. empty array has sum = 0
 */
final class SubArrayToGivenSumCalculator {

  final boolean checkExists(int[] input, int sum) {
    if (input == null || sum < 0) return false;
    final int size = input.length;
    if (size == 0) return sum == 0;

    int currentSum = 0;
    for (int left = 0, right = -1; right < size; ) {
      if (subarrayFound(currentSum, sum)) return true;

      if (currentSum < sum) {
        if (noMoreElementsLeft(size, right)) break;

        currentSum += input[++right];
      } else if (currentSum > sum)
        currentSum -= input[left++];
    }

    return false;
  }

  private boolean subarrayFound(int currentSum, int sum) {
    return currentSum == sum;
  }

  private boolean noMoreElementsLeft(int size, int rightBoundary) {
    return size == rightBoundary + 1;
  }

}
