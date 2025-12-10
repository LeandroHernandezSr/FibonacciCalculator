package com.test.fibonacci.infrastructure.controllers;

import com.test.fibonacci.infrastructure.entrypoints.controllers.GetNumberOccurrencesOrderBy;
import com.test.fibonacci.infrastructure.entrypoints.dtos.FibonacciResponseDto;
import com.test.fibonacci.infrastructure.entrypoints.handlers.FibonacciHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
class GetNumberOccurencesOrderByTest {

    @Mock
    private FibonacciHandler handler;

    private MockMvc mockMvc;

    @BeforeEach
    void setup() {
        GetNumberOccurrencesOrderBy controller =
                new GetNumberOccurrencesOrderBy(handler);

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void testGetNumberOccurrences_ReturnsListOrdered() throws Exception {

        List<FibonacciResponseDto> list = List.of(
                new FibonacciResponseDto(5, 10),
                new FibonacciResponseDto(8, 7)
        );

        when(handler.getOccurrencesOrderBy()).thenReturn(ResponseEntity.ok(list));

        mockMvc.perform(get("/fibonacci/occurrences"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].number").value(5))
                .andExpect(jsonPath("$[0].occurrences").value(10))
                .andExpect(jsonPath("$[1].number").value(8))
                .andExpect(jsonPath("$[1].occurrences").value(7));

        verify(handler).getOccurrencesOrderBy();
        verifyNoMoreInteractions(handler);
    }
}
