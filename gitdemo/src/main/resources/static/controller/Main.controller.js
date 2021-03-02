sap.ui.define(
		["sap/ui/core/mvc/Controller",
		 "jquery.sap.global",
		 "anubhav/util/service",
		 "sap/m/MessageBox"],
		function(Controller, jQuery, service, MessageBox){
	return Controller.extend("anubhav.controller.Main",{
		onInit: function(){
			var oModel = new sap.ui.model.json.JSONModel();
			oModel.setData({
				"postPayload": {
					"companyName": "",
				    "firstName": "",
				    "lastName": "",
				    "website": "",
				    "email": "",
				    "status": "A",
				    "gstNo": ""					
				},
				"vendor": {}
			});
			//Set the model object to the Entire App level
			sap.ui.getCore().setModel(oModel);
		},
		onSave: function(){
			var oModel = sap.ui.getCore().getModel();
			var payload = oModel.getProperty("/postPayload");
			service.callService("/vendor","POST", payload).then(function(){
				MessageBox.confirm("Saved Success");
			}).catch(function(){
				MessageBox.error("post failed");
			});
		},
		onLoadData: function(){
			//alert("todo: we will call our microservice to load vendors");
			var that = this;
			service.callService("/newVendor", "GET", {}).then(function(data){
				//console.log(data);
				//Get the object of the table
				var oTable = that.getView().byId("idTable");
				//Create a new ui5 model which contains data
				var oModel = sap.ui.getCore().getModel();
				oModel.setProperty("/vendor",data._embedded.vendor);
				//Set the model object to the Entire App level
				//Bind aggregation of the table
				oTable.bindRows("/vendor");
			}).catch(function(oError){
				
			});
		}
	});
});