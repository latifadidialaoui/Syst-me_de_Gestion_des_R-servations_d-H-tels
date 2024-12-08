package com.example.soap.config;

import com.example.soap.service.HotelServiceImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CxfConfig {

    private final Bus bus;

    public CxfConfig(Bus bus) {
        this.bus = bus;
    }

    @Bean
    public EndpointImpl hotelEndpoint(HotelServiceImpl hotelService) {
        EndpointImpl endpoint = new EndpointImpl(bus, hotelService);
        endpoint.publish("/hotel");
        endpoint.setWsdlLocation("http://localhost:8080/soap-api/hotel?wsdl");
        return endpoint;
    }
}