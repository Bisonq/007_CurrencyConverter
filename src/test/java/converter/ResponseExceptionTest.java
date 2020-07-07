package converter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResponseExceptionTest {

    @Test
    @DisplayName("Exception should return correct message contains http code")
    void test1() {
        ResponseException responseException = new ResponseException(404);

        //when
        String message = responseException.getMessage();

        //then
        assertEquals("Client Application Error - 404", message);
    }
}