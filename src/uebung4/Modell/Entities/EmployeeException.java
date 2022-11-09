package uebung4.Modell.Entities;




public class EmployeeException extends Exception {
    private ExceptionType type;
    public EmployeeException(ExceptionType type,String message) {
        super(message);
        this.type = type;
    }
    public ExceptionType getExceptionTypeType() {
        return this.type;
    }

    public enum ExceptionType{
        StringIsNumeric, ExpertiseFull
    }
}
