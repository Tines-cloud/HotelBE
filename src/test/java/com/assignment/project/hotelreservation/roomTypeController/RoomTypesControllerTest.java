package com.assignment.project.hotelreservation.roomTypeController;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import com.assignment.project.hotelreservation.controller.RoomTypeController;
import com.assignment.project.hotelreservation.model.Contract;
import com.assignment.project.hotelreservation.model.Hotel;
import com.assignment.project.hotelreservation.model.RoomType;
import com.assignment.project.hotelreservation.services.RoomTypeServices;
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

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@RunWith(MockitoJUnitRunner.class)
public class RoomTypesControllerTest {
    private MockMvc mockMvc;

    ObjectMapper objectMapper=new ObjectMapper();
    ObjectWriter objectWriter=objectMapper.writer();

    @Mock
    private RoomTypeServices roomTypeServices;

    @InjectMocks
    private RoomTypeController roomTypeController;

    Hotel hotel_1=new Hotel("hotel1","Araliya","Nuwara Eliya");
    Date date1=new Date(2022,01,01);
    Date date2=new Date(2022,12,31);

    Contract contract_1=new Contract("contract1",date1,date2,0.25);

    RoomType roomType_1=new RoomType("room1","Luxury",15.2,3,20,5,contract_1);
    RoomType roomType_2=new RoomType("room2","Semi Luxury",11.3,3,20,8,contract_1);
    RoomType roomType_3=new RoomType("room3","Standard",8.5,3,20,7,contract_1);

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        this.mockMvc= MockMvcBuilders.standaloneSetup(roomTypeController).build();
    }

    @Test
    public void getAllRoomTypes() throws Exception{
        List<RoomType> records=new ArrayList<>(Arrays.asList(roomType_1,roomType_2,roomType_3));
        Mockito.when(roomTypeServices.getAllRoomTypes()).thenReturn(records);
        mockMvc.perform(MockMvcRequestBuilders
                .get("/roomTypes")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
               // .andExpect(jsonPath("$",hasSize(3)))
               // .andExpect(jsonPath("$[2].name",is("Standard")));
    }


    @Test
    public void getRoomType() throws Exception{
        Mockito.when(roomTypeServices.getRoomType(roomType_1.getId())).thenReturn(roomType_1);
        mockMvc.perform(MockMvcRequestBuilders
                .get("/roomTypes/"+roomType_1.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void addRoomType() throws Exception{
        RoomType roomType= new RoomType("room4","Normal",7,3,15,7,contract_1);

      //  Mockito.when(roomTypeServices.addRoomType(contract_1.getId(),roomType)).thenReturn(roomType);
        //Mockito.when(roomTypeServices.addRoomType(contract_1.getId(),Mockito.any(RoomType.class))).thenReturn(roomType);
        String content=objectWriter.writeValueAsString(roomType);

        MockHttpServletRequestBuilder mockRequest=MockMvcRequestBuilders.post("/contracts/"+contract_1.getId()+"/roomTypes")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);

        mockMvc.perform(mockRequest).andExpect(status().isOk());
    }

    @Test
    public void updateRoomType() throws Exception{

        RoomType roomType= new RoomType("room1","Lake View",10,3,15,7,contract_1);

       // Mockito.when(roomTypeServices.updateRoomType(contract_1.getId(),roomType)).thenReturn(roomType);

        String updatedContent=objectWriter.writeValueAsString(roomType);

        MockHttpServletRequestBuilder mockRequest=MockMvcRequestBuilders.put("/contracts/"+contract_1.getId()+"/roomTypes")
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
                .content(updatedContent);

        mockMvc.perform(mockRequest).andExpect(status().isOk());
    }

    @Test
    public void deleteRoomType() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/roomTypes/"+roomType_1.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }


}
