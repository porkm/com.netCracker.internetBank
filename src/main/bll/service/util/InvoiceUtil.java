package main.bll.service.util;

import main.bll.modeldto.TransferDTO;
import main.dal.api.IUnitOfWork;
import main.dal.entinties.Invoice;

import java.sql.SQLException;


public class InvoiceUtil {

    private Invoice toInvoice;
    private Invoice fromInvoice;

    private TransferDTO transferDTO;
    private IUnitOfWork unit;

    public InvoiceUtil(TransferDTO transferDTO, IUnitOfWork unit) {
        this.transferDTO = transferDTO;
        this.unit = unit;
    }

    public boolean makeTransfer() {

        fromInvoice = getInvoiceById(transferDTO.getFromInvoiceId());
        toInvoice = getInvoiceById(transferDTO.getToInvoiceId());

        if (fromInvoice.getBalance()<transferDTO.getMoney()){
            return false;
            //todo MyExeption
        }
        else
        {
            toInvoice.setBalance(toInvoice.getBalance() + transferDTO.getMoney());
            fromInvoice.setBalance(fromInvoice.getBalance() - transferDTO.getMoney());

            updateInvoice(toInvoice);
            updateInvoice(fromInvoice);
        }

        return true;


    }

    private Invoice getInvoiceById(int invoiceId) {
        Invoice invoice = null;
        try {
            invoice = unit.invoices().get(invoiceId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return invoice;
    }



    private void updateInvoice(Invoice invoice) {

        try {
            unit.invoices().update(invoice);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
