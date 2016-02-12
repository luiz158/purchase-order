/**
 * Classe PurchaseOrderListController responsible by views/purchaseorder/list.jsp
 */
app.controller('PurchaseOrderListController', ['PurchaseOrderService', 'DateCommon', 
                                               function(PurchaseOrderService, DateCommon) {

	var self = this;
	
	/**
	 * Load 
	 */
	var init = function() {

		self.statusList = [{status: "pending", "display": "Pendente"}, {status: "completed", "display": "Concluido"}];
		self.search = {};
		self.search.status = self.statusList[0].status;
		self.search.dateStart = DateCommon.getTodayAddUsEn(-7); 
		self.search.dateEnd = DateCommon.getTodayAddUsEn(1);  
		self.searchAdv(self.search.status,self.search.dateStart, self.search.dateEnd);
	};
 
	/**
	 * consulta avancada
	 */
	self.searchAdv = function(status, dateStart, dateEnd) {
//		PurchaseOrderService.getAll().then(function(resp) {
//		self.purchaseOrders = resp.data;
//	}, function(error) {
//		alert(JSON.stringify(error));
//	});
		PurchaseOrderService.searchAdvanced(status, dateStart, dateEnd).then(function(resp) {
			self.purchaseOrders = resp.data;
			console.log(self.purchaseOrders);
		}, function(error) {
			alert(JSON.stringify(error));
		});		
	};

	/**
	 * Exclui PO
	 */
	self.deletePO = function(po) {
		PurchaseOrderService.deletePO(po).then(function(resp) {
			self.searchAdv(self.search.status,self.search.dateStart, self.search.dateEnd);
		}, function(error) {
			alert(JSON.stringify(error));
		});
	};
	
	init();
	
}]);
