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

    public TransferError makeTransfer() throws SQLException {

        fromInvoice = unit.invoices().get(transferDTO.getFromInvoiceId());
        toInvoice = unit.invoices().get(transferDTO.getToInvoiceId());
        if (toInvoice==null){
            return TransferError.NOINVOICES;
        }


        if (fromInvoice.getBalance()<transferDTO.getMoney()){
            return TransferError.NOMONEY;
            //todo MyExeption
        }
            else
            {
                toInvoice.setBalance(toInvoice.getBalance() + transferDTO.getMoney());
                fromInvoice.setBalance(fromInvoice.getBalance() - transferDTO.getMoney());

                updateInvoice(toInvoice);
                updateInvoice(fromInvoice);
            }

        return TransferError.OK;


    }


    private void updateInvoice(Invoice invoice) {

        try {
            unit.invoices().update(invoice);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}

