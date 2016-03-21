package com.diegolirio.purchaseorder.reports.mirror;

import com.diegolirio.purchaseorder.models.Customer;
import com.diegolirio.purchaseorder.models.OrdersProducts;
import com.diegolirio.purchaseorder.models.Product;
import com.diegolirio.purchaseorder.models.PurchaseOrder;

public class POReportMirror {
	
	private PO po;
	private Product product;
	private double amount;
	private double valueUnit; 

	public POReportMirror(OrdersProducts ordersProducts, Customer sender, Customer recipient) {
		PurchaseOrder purchaseOrder = ordersProducts.getOrder();
		po = new PO();
		po.setNumber(purchaseOrder.getId());
		po.setEmissionDate(purchaseOrder.getEmissionDate());
		po.setPaymentConditions(purchaseOrder.getCondicaoPagamento());
		po.setRemark(purchaseOrder.getRemark());
		po.setRepresentative(purchaseOrder.getRepresentative());
		// sender
		po.setNameSender(sender.getName());
		po.setCnpjSender(sender.getCpfCnpj());
		po.setIeSender(sender.getSignUpState());
		po.setAddressSender(purchaseOrder.getCustomerAddressSender().getPublicPlace());
		po.setAddressNumberSender(purchaseOrder.getCustomerAddressSender().getNumber());
		po.setNeighborhoodSender(purchaseOrder.getCustomerAddressSender().getNeighborhood());
		po.setCitySender(purchaseOrder.getCustomerAddressSender().getCity());
		po.setStateSender(purchaseOrder.getCustomerAddressSender().getState().getAbbreviation());
		po.setCepSender(purchaseOrder.getCustomerAddressSender().getCep());

		po.setPhoneSender(purchaseOrder.getPhoneSender());
		// recipient
		po.setNameRecipient(recipient.getName());
		po.setCnpjRecipient(recipient.getCpfCnpj());
		po.setIeRecipient(recipient.getSignUpState());
		po.setAddressRecipient(purchaseOrder.getCustomerAddressRecipient().getPublicPlace());
		po.setAddressNumberRecipient(purchaseOrder.getCustomerAddressRecipient().getNumber());
		po.setNeighborhoodRecipient(purchaseOrder.getCustomerAddressRecipient().getNeighborhood());
		po.setCityRecipient(purchaseOrder.getCustomerAddressRecipient().getCity());
		po.setStateRecipient(purchaseOrder.getCustomerAddressRecipient().getState().getAbbreviation());
		po.setCepRecipient(purchaseOrder.getCustomerAddressRecipient().getCep());
		po.setPhone1Recipient(purchaseOrder.getPhoneRecipient());
		po.setContactRecipient(purchaseOrder.getContactRecipient());
		po.setNameShippingCompany(purchaseOrder.getCustomerAddressShippingCompany().getPeople().getName());
		po.setPhoneShippingCompany(purchaseOrder.getPhoneShippingCompany());
		po.setAddressShippingCompany(purchaseOrder.getCustomerAddressShippingCompany().getPublicPlace());
		po.setAddressNumberShippingCompany(purchaseOrder.getCustomerAddressShippingCompany().getNumber());
		
		// produ
		product = ordersProducts.getProduct();
		amount = ordersProducts.getAmount();
		valueUnit = ordersProducts.getValueUnit();
	}

	public PO getPo() {
		return po;
	}

	public void setPo(PO po) {
		this.po = po;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getValueUnit() {
		return valueUnit;
	}

	public void setValueUnit(double valueUnit) {
		this.valueUnit = valueUnit;
	}

	@Override
	public String toString() {
		return "POReportMirror [po=" + po + ", product=" + product
				+ ", amount=" + amount + ", valueUnit=" + valueUnit + "]";
	}
	
	
}