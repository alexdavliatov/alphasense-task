package ru.adavliatov.task1;

import java.util.Arrays;

import com.sun.istack.internal.Nullable;

import static java.lang.Math.*;

/**
 * Assumptions:
 * 1. we deal with lowercase english characters (otherwise use map instead of array)
 */
final class LongestNonRepeatableSubstringCalculator {

  final int calculateLength(@Nullable String input) {
    if (input == null) return 0;

    int[] lastAppearIds = new int[150];
    Arrays.fill(lastAppearIds, -1);

    int longestLength = 0;
    int currentLength = 0;

    final char[] chars = input.toCharArray();
    for (int i = 0; i < input.length(); i++) {
      char c = chars[i];
      final int lastAppearId = lastAppearIds[c];
      lastAppearIds[c] = i;

      //first time OR doesn't belong to substring
      if (notInSubstring(lastAppearId, i, currentLength)) {
        currentLength += 1;
        continue;
      }

      if (shouldUpdateResult(longestLength, currentLength))
        longestLength = currentLength;

      currentLength = i - lastAppearId;
    }

    return max(longestLength, currentLength);
  }

  private boolean notInSubstring(int lastAppearAtId, int currentPosition, int currentLength) {
    return lastAppearAtId == -1 || (currentPosition - lastAppearAtId) > currentLength;
  }

  private boolean shouldUpdateResult(int longest, int current) {
    return longest < current;
  }

}
