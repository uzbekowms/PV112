package edu.itstep.contract.service;

import org.springframework.beans.factory.annotation.Qualifier;

public class DeliveryDetailsPrinter {

    private Sorter sorterByAddress;

    public DeliveryDetailsPrinter(Sorter sorterByAddress) {
        this.sorterByAddress = sorterByAddress;
    }

    public void printDetails() {
        sorterByAddress.sortDetails();
    }
}
