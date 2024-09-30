package com.qikserve.api.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.qikserve.api.abstracts.AbstractService;
import com.qikserve.api.model.dto.ClientDTO;
import com.qikserve.api.model.dto.OrderDTO;
import com.qikserve.api.model.entities.Client;
import com.qikserve.api.repositories.client.ClientRepository;

@Service
public class ClientService extends AbstractService<Client, Long, ClientDTO> {

	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private OrderService orderService;
	
	public ClientDTO getClientSimpleHistory(Long id) {
		if (Objects.isNull(id)) {
			throw new IllegalArgumentException("Client ID is required");
		}
		
		Client client = this.findById(id);
		if (Objects.isNull(client)) {
			throw new IllegalArgumentException("Client not found");
		}
		
		ClientDTO clientDTO = new ClientDTO().entityToDTO(client);
		clientDTO.setOrderAmount(0);
		clientDTO.setOrderTotal(BigDecimal.ZERO);
		clientDTO.setOrderTotalDiscount(BigDecimal.ZERO);
		
		this.getClientOrderHistory(client, clientDTO);
		
		return clientDTO;
	}
	
	public void getClientOrderHistory(Client client, ClientDTO clientDTO) {
		List<OrderDTO> orderDTOList = this.orderService.findOrderWithItemsByClient(client);
		
		if (!CollectionUtils.isEmpty(orderDTOList)) {
			clientDTO.setOrderAmount(orderDTOList.size());

			for (OrderDTO orderDTO : orderDTOList) {
				clientDTO.setOrderTotal(orderDTO.getOrderItemList().stream().map(o -> o.getTotalPaid().multiply(o.getAmount())).reduce(BigDecimal.ZERO, BigDecimal::add));
				clientDTO.setOrderTotalDiscount(orderDTO.getOrderItemList().stream().map(o -> o.getUnitDiscount().multiply(o.getAmount())).reduce(BigDecimal.ZERO, BigDecimal::add));
			}
		}
	}
}
