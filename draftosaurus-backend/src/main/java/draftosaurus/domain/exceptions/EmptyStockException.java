package draftosaurus.domain.exceptions;

public class EmptyStockException extends RuntimeException  {
    public EmptyStockException(String errorMessage) {
        super(errorMessage);
    }
}
