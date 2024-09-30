package com.qikserve.api.unitarios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qikserve.api.repositories.item.ItemRepository;
import com.qikserve.api.services.ItemService;

@ExtendWith(MockitoExtension.class)
public class ItemServiceTest {

    @InjectMocks
    private ItemService itemService;

    @Mock
    private ItemRepository itemRepository;

    @Mock
    private RestTemplate restTemplate;

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    public void testFindItemsByLink_NullLink() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            itemService.findItemsByLink(null);
        });
        assertEquals("Link is required", thrown.getMessage());
    }

    @Test
    public void testFindItemsByLink_EmptyLink() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            itemService.findItemsByLink("");
        });
        assertEquals("Link is required", thrown.getMessage());
    }

}

