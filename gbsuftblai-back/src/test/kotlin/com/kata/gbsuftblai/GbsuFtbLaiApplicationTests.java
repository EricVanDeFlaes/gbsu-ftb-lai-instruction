package com.kata.gbsuftblai;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.kata.gbsuftblai.beans.ResultDto;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GbsuFtbLaiApplicationTests {
    
    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void contextLoads() {
    }
    
    @ParameterizedTest
    @CsvFileSource(resources = "/data_for_test.csv", numLinesToSkip = 1)
    public void testConvertNumber(String input, String expected) {

        ResponseEntity<ResultDto> result = testRestTemplate.getForEntity("/gbsu-ftb-lai/"+input, ResultDto.class);
        assertNotNull(result);
        assertEquals(result.getStatusCode(), HttpStatus.OK);
        assertEquals(result.getBody().getResult(), expected);
    }
}
