package koorsach;

public class IntervalException extends Exception {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setText(String text) {
        this.message = message;
    }


    public IntervalException (String message)
    {
        this.message=message;
    }


}

