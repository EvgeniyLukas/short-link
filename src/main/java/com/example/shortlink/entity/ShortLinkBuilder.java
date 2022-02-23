package com.example.shortlink.entity;

import org.apache.commons.text.RandomStringGenerator;


public class ShortLinkBuilder {
  private final RandomStringGenerator randomStringGenerator;

  public ShortLinkBuilder() {
    this.randomStringGenerator = new RandomStringGenerator
        .Builder().filteredBy(ShortLinkBuilder::latinAndDigitTest)
        .build();
  }

  public String generate(int length) {
    return randomStringGenerator.generate(length);
  }

  private static boolean latinAndDigitTest(int var) {
    char ch = (char) var;
    String str = String.valueOf(ch);
    System.out.println("str = " + str);
    return str.matches("^[a-zA-Z0-9]+$");

  }
}
