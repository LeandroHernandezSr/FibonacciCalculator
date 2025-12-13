package com.test.fibonacci.infrastructure.dtos;

import com.test.fibonacci.infrastructure.entrypoints.dtos.ApiResponseDto;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ApiResponseDtoTest {

    @Test
    void constructorWithDataAndMessage_shouldCreateSuccessResponse() {
        // given
        String data = "test-data";
        String message = "Operation finished succesfully";

        // when
        ApiResponseDto<String> response = new ApiResponseDto<>(data, message);

        // then
        assertTrue(response.success());
        assertEquals(message, response.message());
        assertEquals(data, response.data());
        assertNull(response.errors());
        assertNotNull(response.timeStamp());
    }

    @Test
    void constructorWithErrorsAndMessage_shouldCreateErrorResponse() {
        // given
        List<String> errors = List.of("Error 1", "Error 2");
        String message = "Validation failed";

        // when
        ApiResponseDto<Object> response = new ApiResponseDto<>(errors, message);

        // then
        assertFalse(response.success());
        assertEquals(message, response.message());
        assertNull(response.data());
        assertEquals(errors, response.errors());
        assertNotNull(response.timeStamp());
    }

    @Test
    void okFactoryMethod_shouldCreateSuccessResponseWithDefaultMessage() {
        // given
        Integer data = 42;

        // when
        ApiResponseDto<Integer> response = ApiResponseDto.ok(data);

        // then
        assertTrue(response.success());
        assertEquals("OK", response.message());
        assertEquals(data, response.data());
        assertNull(response.errors());
        assertNotNull(response.timeStamp());
    }

    @Test
    void okFactoryMethodWithMessage_shouldCreateSuccessResponse() {
        // given
        Integer data = 21;
        String message = "Custom success message";

        // when
        ApiResponseDto<Integer> response = ApiResponseDto.ok(data, message);

        // then
        assertTrue(response.success());
        assertEquals(message, response.message());
        assertEquals(data, response.data());
        assertNull(response.errors());
        assertNotNull(response.timeStamp());
    }

    @Test
    void errorFactoryMethod_shouldCreateErrorResponse() {
        // given
        List<String> errors = List.of("Invalid value");
        String message = "Bad request";

        // when
        ApiResponseDto<Object> response = ApiResponseDto.error(errors, message);

        // then
        assertFalse(response.success());
        assertEquals(message, response.message());
        assertNull(response.data());
        assertEquals(errors, response.errors());
        assertNotNull(response.timeStamp());
    }

    @Test
    void timestamp_shouldBeCloseToNow() {
        // given
        Instant before = Instant.now();

        // when
        ApiResponseDto<String> response = ApiResponseDto.ok("data");

        Instant after = Instant.now();

        // then
        assertTrue(
                !response.timeStamp().isBefore(before) &&
                        !response.timeStamp().isAfter(after)
        );
    }
}
