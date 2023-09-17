package com.assignment.project.hotelreservation.roomTypeController;

import com.assignment.project.hotelreservation.DTO.HotelRooms;
import com.assignment.project.hotelreservation.DTO.RoomTypes;
import com.assignment.project.hotelreservation.controller.DTOController;
import com.assignment.project.hotelreservation.services.HotelRoomDTOServices;
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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(MockitoJUnitRunner.class)
public class DTOControllerTest {
    private MockMvc mockMvc;

    @Mock
    private HotelRoomDTOServices hotelRoomDTOServices;

    @InjectMocks
    private DTOController dtoController;

    @Before
    public void setUp(){

        MockitoAnnotations.initMocks(this);
        this.mockMvc= MockMvcBuilders.standaloneSetup(dtoController).build();
    }

    RoomTypes roomTypes_1 =new RoomTypes("luxury",25.6);
    RoomTypes roomTypes_2 =new RoomTypes("semi luxury",20.0);

    HotelRooms hotelRooms_1 =new HotelRooms("Cinnamon","Colombo",Arrays.asList(roomTypes_1, roomTypes_2));
    HotelRooms hotelRooms_2 =new HotelRooms("Galadari","Colombo",Arrays.asList(roomTypes_1, roomTypes_2));
    HotelRooms hotelRooms_3 =new HotelRooms("Araliya","Nuwara Eliya",Arrays.asList(roomTypes_1, roomTypes_2));

    @Test
    public void getAllHotelRooms() throws Exception{

        List<HotelRooms> hotelRooms=new ArrayList<>(Arrays.asList(hotelRooms_1, hotelRooms_2, hotelRooms_3));

        Date date=new Date(2022,01,01);

        Mockito.when(hotelRoomDTOServices.getOutputDetails(date,3,2,4)).thenReturn(hotelRooms);
        mockMvc.perform(MockMvcRequestBuilders
                .get("/resultFinal/"+date+"/3/2/4")
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
                //.andExpect(jsonPath("$",hasSize(3)));
    }


}
