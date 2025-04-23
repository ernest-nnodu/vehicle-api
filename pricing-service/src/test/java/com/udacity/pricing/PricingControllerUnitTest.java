package com.udacity.pricing;

import com.udacity.pricing.api.PricingController;
import com.udacity.pricing.domain.price.Price;
import com.udacity.pricing.service.PricingService;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PricingController.class)
public class PricingControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getPrice() throws Exception {
        try(MockedStatic<PricingService> serviceMock = mockStatic(PricingService.class)) {
         Price mockPrice = new Price("USD", new BigDecimal(5000), 1L);

         serviceMock.when(() -> PricingService.getPrice(1L))
                 .thenReturn(mockPrice);

         mockMvc.perform(get("/services/price?vehicleId=1"))
                 .andExpect(status().isOk());

         serviceMock.verify(() -> PricingService.getPrice(1L), times(1));
        }
    }
}
