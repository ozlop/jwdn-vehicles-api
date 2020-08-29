package com.udacity.boogle.maps;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest(MapsController.class)
public class MapsControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    MockAddressRepository mockAddressRepository;

    @Test
    public void getAddress() throws Exception {
        mockMvc.perform(get("/maps?lat=1&lon=1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.address").exists())
                .andExpect(jsonPath("$.city").exists())
                .andExpect(jsonPath("$.state").exists())
                .andExpect(jsonPath("$.zip").exists());
    }
}
