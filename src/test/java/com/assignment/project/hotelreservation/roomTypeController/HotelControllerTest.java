package com.assignment.project.hotelreservation.roomTypeController;

import com.assignment.project.hotelreservation.controller.HotelController;
import com.assignment.project.hotelreservation.model.Hotel;
import com.assignment.project.hotelreservation.services.HotelServices;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.assignment.project.hotelreservation.model.Hotel.*;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.http.codec.ServerSentEvent.builder;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(MockitoJUnitRunner.class)
public class HotelControllerTest {
    private MockMvc mockMvc;

    ObjectMapper objectMapper=new ObjectMapper();
    ObjectWriter objectWriter=objectMapper.writer();

    @Mock
    private HotelServices hotelServices;

    @InjectMocks
    private HotelController hotelController;

    Hotel hotel_1=new Hotel("hotel1","Araliya","Nuwara Eliya");
    Hotel hotel_2=new Hotel("hotel2","Shangri La","Colombo");
    Hotel hotel_3=new Hotel("hotel3","Marino","Colombo");

    @Before
    public void setUp(){

        MockitoAnnotations.initMocks(this);
        this.mockMvc= MockMvcBuilders.standaloneSetup(hotelController).build();
    }

    @Test
    public void getAllHotels() throws Exception{
        List<Hotel> hotels=new ArrayList<>(Arrays.asList(hotel_1,hotel_2,hotel_3));
        Mockito.when(hotelServices.getAllHotels()).thenReturn(hotels);
        mockMvc.perform(MockMvcRequestBuilders
                .get("/hotels")
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
                //.andExpect(jsonPath("$",hasSize(3)));
    }

    @Test
    public void getHotel() throws Exception{
        Mockito.when(hotelServices.getHotel(hotel_1.getId())).thenReturn(hotel_1);
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/hotels/"+hotel_1.getId())
                        .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
                //        .andExpect(jsonPath("$.name",is("Araliya")));
    }

    @Test
    public void addHotel() throws Exception{

        Hotel hotel= new Hotel("hotel4","Cinnamon","Colombo");

       //Mockito.when(hotelServices.addHotel(Mockito.any(Hotel.class))).thenReturn(hotel);
        //Mockito.when(hotelServices.addHotel(hotel)).thenReturn(hotel);
        String content=objectWriter.writeValueAsString(hotel);

        MockHttpServletRequestBuilder mockRequest=MockMvcRequestBuilders.post("/hotels")
                        .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
                .content(content);

        mockMvc.perform(mockRequest).andExpect(status().isOk());
    }

    @Test
    public void updateHotel() throws Exception{

        Hotel hotelUpdate= new Hotel("hotel1","Cinnamon","Colombo");

      //  Mockito.when(hotelServices.updateHotel(hotel_1.getId(),hotelUpdate)).thenReturn(hotelUpdate);

        String updatedContent=objectWriter.writeValueAsString(hotelUpdate);

        MockHttpServletRequestBuilder mockRequest=MockMvcRequestBuilders.put("/hotels/"+hotel_1.getId())
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
                .content(updatedContent);

        mockMvc.perform(mockRequest).andExpect(status().isOk());
    }

    @Test
    public void deleteHotel() throws Exception{
            mockMvc.perform(MockMvcRequestBuilders
                .delete("/hotels/"+hotel_1.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

}
