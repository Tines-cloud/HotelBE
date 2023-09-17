package com.assignment.project.hotelreservation.roomTypeController;

import com.assignment.project.hotelreservation.controller.ContractController;
import com.assignment.project.hotelreservation.model.Contract;
import com.assignment.project.hotelreservation.model.Hotel;
import com.assignment.project.hotelreservation.services.ContractServices;
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

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(MockitoJUnitRunner.class)
public class ContractControllerTest {
    private MockMvc mockMvc;

    ObjectMapper objectMapper=new ObjectMapper();
    ObjectWriter objectWriter=objectMapper.writer();

    @Mock
    private ContractServices contractServices;

    @InjectMocks
    private ContractController contractController;

    Hotel hotel=new Hotel("hotel1","Araliya","Nuwara Eliya");
    Date date1=new Date(2022,01,01);
    Date date2=new Date(2022,12,31);

    Contract contract_1=new Contract("contract1",date1,date2,0.25,hotel);
    Contract contract_2=new Contract("contract2",date1,date2,0.25,hotel);
    Contract contract_3=new Contract("contract3",date1,date2,0.25,hotel);

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        this.mockMvc= MockMvcBuilders.standaloneSetup(contractController).build();
    }

    @Test
    public void getAllContracts() throws Exception{
        List<Contract> contracts=new ArrayList<>(Arrays.asList(contract_1,contract_2,contract_3));
        Mockito.when(contractServices.getAllContracts()).thenReturn(contracts);
        mockMvc.perform(MockMvcRequestBuilders
                .get("/contracts")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    public void getContract() throws Exception{
        Mockito.when(contractServices.getContract(contract_1.getId())).thenReturn(contract_1);
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/contracts/"+contract_1.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void addContract() throws Exception{

        Contract contract=new Contract("contract4",date1,date2,0.25,hotel);

        //Mockito.when(contractServices.addContract(Mockito.any(Contract.class),hotel.getId())).thenReturn(contract);
        //Mockito.when(contractServices.addContract(contract,hotel.getId())).thenReturn(contract);
        String content=objectWriter.writeValueAsString(contract);

        MockHttpServletRequestBuilder mockRequest=MockMvcRequestBuilders.post("/hotels/"+hotel.getId()+"/contracts")
                        .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
                .content(content);

        mockMvc.perform(mockRequest).andExpect(status().isOk());
    }

    @Test
    public void updateContract() throws Exception{

        Contract contractUpdate=new Contract("contract4",date1,date2,0.25,hotel);

        //Mockito.when(contractServices.updateContract(hotel.getId(),contractUpdate)).thenReturn(contractUpdate);

        String updatedContent=objectWriter.writeValueAsString(contractUpdate);

        MockHttpServletRequestBuilder mockRequest=MockMvcRequestBuilders.put("/hotels/"+hotel.getId()+"/contracts")
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
                .content(updatedContent);

        mockMvc.perform(mockRequest).andExpect(status().isOk());
    }

    @Test
    public void deleteContract() throws Exception{
            mockMvc.perform(MockMvcRequestBuilders
                .delete("/contracts/"+contract_1.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

}
