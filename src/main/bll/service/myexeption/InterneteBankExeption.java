package main.bll.service.myexeption;


import main.bll.service.util.TransferError;

public class InterneteBankExeption extends Exception {

    private TransferError error;
    public TransferError getError(){
        return error;
    }
    public InterneteBankExeption(String message, TransferError error) {
        super(message);
        this.error=error;
    }
    public InterneteBankExeption(String message) {
        super(message);
    }
}
