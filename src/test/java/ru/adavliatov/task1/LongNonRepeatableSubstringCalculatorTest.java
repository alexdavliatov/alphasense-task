package ru.adavliatov.task1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(BlockJUnit4ClassRunner.class)
public class LongNonRepeatableSubstringCalculatorTest {
  LongestNonRepeatableSubstringCalculator calculator = new LongestNonRepeatableSubstringCalculator();

  @Test
  public void shouldHandleNullString() {
    assertThat(calculator.calculateLength(null), equalTo(0));
  }

  @Test
  public void shouldHandleEmptyString() {
    assertThat(calculator.calculateLength(""), equalTo(0));
  }

  @Test
  public void shouldHandleSingleCharacter() {
    assertThat(calculator.calculateLength("a"), equalTo(1));
  }

  @Test
  public void shouldHandleTwoCharacter() {
    assertThat(calculator.calculateLength("aa"), equalTo(1));
    assertThat(calculator.calculateLength("ab"), equalTo(2));
  }

  @Test
  public void shouldHandleDuplicates() {
    assertThat(calculator.calculateLength("aaaaa"), equalTo(1));
  }

  @Test
  public void shouldHandlePredefinedExamples() {
    assertThat(calculator.calculateLength("abcabcbb"), equalTo(3));
    assertThat(calculator.calculateLength("bbbbb"), equalTo(1));
    assertThat(calculator.calculateLength("pwwkew"), equalTo(3));
  }

}
