package com.qikserve.api.unitarios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.qikserve.api.model.dto.ClientDTO;
import com.qikserve.api.model.dto.OrderDTO;
import com.qikserve.api.model.dto.OrderItemDTO;
import com.qikserve.api.model.entities.Client;
import com.qikserve.api.repositories.client.ClientRepository;
import com.qikserve.api.services.ClientService;
import com.qikserve.api.services.OrderService;

@ExtendWith(MockitoExtension.class)
public class ClientServiceTest {

    @InjectMocks
    private ClientService clientService;

    @Mock
    private ClientRepository clientRepository;

    @Mock
    private OrderService orderService;

    private Client client;

    @BeforeEach
    public void setUp() {
        client = new Client();
        client.setId(1L);
    }

    @Test
    public void testGetClientOrderHistory_WithOrders() {
        OrderDTO orderDTO = new OrderDTO();

        OrderItemDTO orderItemDTO = new OrderItemDTO();
        orderItemDTO.setTotalPaid(BigDecimal.valueOf(100));
        orderItemDTO.setAmount(BigDecimal.valueOf(2));
        orderItemDTO.setUnitDiscount(BigDecimal.valueOf(10));

        orderDTO.setOrderItemList(List.of(orderItemDTO));

        when(orderService.findOrderWithItemsByClient(client)).thenReturn(List.of(orderDTO));

        ClientDTO clientDTO = new ClientDTO();
        clientService.getClientOrderHistory(client, clientDTO);

        assertEquals(1, clientDTO.getOrderAmount());
        assertEquals(BigDecimal.valueOf(200), clientDTO.getOrderTotal());
        assertEquals(BigDecimal.valueOf(20), clientDTO.getOrderTotalDiscount());
    }

}
