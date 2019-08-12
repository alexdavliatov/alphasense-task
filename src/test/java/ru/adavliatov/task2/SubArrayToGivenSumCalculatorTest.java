package ru.adavliatov.task2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(BlockJUnit4ClassRunner.class)
public class SubArrayToGivenSumCalculatorTest {

  SubArrayToGivenSumCalculator calculator = new SubArrayToGivenSumCalculator();

  @Test
  public void shouldHandleNullString() {
    assertThat(calculator.checkExists(null, 1), equalTo(false));
  }

  @Test
  public void shouldHandleEmptyArray() {
    assertThat(calculator.checkExists(new int[]{}, 0), equalTo(true));
    assertThat(calculator.checkExists(new int[]{}, 1), equalTo(false));
  }

  @Test
  public void shouldHandleSingleElement() {
    assertThat(calculator.checkExists(new int[]{1}, 1), equalTo(true));
    assertThat(calculator.checkExists(new int[]{1}, 2), equalTo(false));
  }

  @Test
  public void shouldHandlePredefinedElements() {
    assertThat(calculator.checkExists(new int[]{1, 2, 3, 4}, 7), equalTo(true));
    assertThat(calculator.checkExists(new int[]{1, 2, 3, 4, 5}, 7), equalTo(true));
    assertThat(calculator.checkExists(new int[]{1, 2, 3, 5, 4}, 7), equalTo(false));
    assertThat(calculator.checkExists(new int[]{1, 2, 3, 5, 4}, 6), equalTo(true));
  }

  @Test
  public void shouldHandleAllArray() {
    assertThat(calculator.checkExists(new int[]{1, 2, 3, 4}, 10), equalTo(true));
  }

  @Test
  public void shouldHandleArrayTail() {
    assertThat(calculator.checkExists(new int[]{1, 2, 3, 4}, 7), equalTo(true));
  }

}
