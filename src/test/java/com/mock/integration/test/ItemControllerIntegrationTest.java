package com.mock.integration.test;


import com.mock.model.Item;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ItemControllerIntegrationTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void testItemControllerIntegration() throws JSONException {

        String response=testRestTemplate.getForObject("/listItems", String.class);

        System.out.println(response);
        JSONAssert.assertEquals("[{\"itemId\":\"490\"},{\"itemId\":\"491\"},{\"itemId\":\"492\"},{\"itemId\":\"493\"}]",response,false);

    }


}
