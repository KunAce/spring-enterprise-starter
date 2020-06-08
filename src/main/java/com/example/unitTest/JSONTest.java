package com.example.unitTest;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@JsonTest
public class JSONTest {
    @Autowired
    JacksonTester<Book> jacksonTester;
    @Test
    public void testSerialize() throws IOException {
        Book book = new Book();
        book.setAuthor("Derek");
        book.setName("JavaBook");
        book.setId(1);
        Assertions.assertThat(jacksonTester.write(book))
                .isEqualToJson("book.json");
        Assertions.assertThat(jacksonTester.write(book))
                .hasJsonPathStringValue("@.name");
        Assertions.assertThat(jacksonTester.write(book))
                .extractingJsonPathStringValue("@.name")
                .isEqualTo("JavaBook");
    }
    @Test
    public void testDeserialize() throws Exception {
        String content = "{\"id\":1,\"name\":\"JavaBook\",\"author\":\"Derek\"}";
        Assertions.assertThat(jacksonTester.parseObject(content).getName())
                .isEqualTo("JavaBook");
    }
}
