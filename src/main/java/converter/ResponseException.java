package converter;

class ResponseException extends RuntimeException {

    ResponseException(int code) {
        super("Client Application Error - " + code);
    }
}