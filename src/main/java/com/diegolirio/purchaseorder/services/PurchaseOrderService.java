package com.diegolirio.purchaseorder.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegolirio.purchaseorder.models.PurchaseOrder;
import com.diegolirio.purchaseorder.repositories.PurchaseOrderRepositorie;

@Service
public class PurchaseOrderService {
	
	@Autowired 
	private PurchaseOrderRepositorie purchaseOrderRepositorie;

	public PurchaseOrder save(PurchaseOrder purchaseOrder) {
		return null; //this.purchaseOrderRepository.save(purchaseOrder);
	}

	public Iterable<PurchaseOrder> getAll() {
		return null; //this.purchaseOrderRepository.findAll();
	}
	
}
