package com.hugoalexandremf.restapidemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;

@JsonTest
public class APIControllerJsonTests {

     @Autowired
     private JacksonTester<String> json;

     @Test
     public void cashCardSerializationTest() throws IOException {
          /*CashCard cashCard = new CashCard(99L, 123.45);
          assertThat(json.write(cashCard)).isStrictlyEqualToJson("expected.json");
          assertThat(json.write(cashCard)).hasJsonPathNumberValue("@.id");
          assertThat(json.write(cashCard)).extractingJsonPathNumberValue("@.id")
                  .isEqualTo(99);
          assertThat(json.write(cashCard)).hasJsonPathNumberValue("@.amount");
          assertThat(json.write(cashCard)).extractingJsonPathNumberValue("@.amount")
                  .isEqualTo(123.45);*/
     }
}
