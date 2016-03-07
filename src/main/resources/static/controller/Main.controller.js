sap.ui.define([
	"com/penninkhof/odata/controller/BaseController",
	"sap/ui/model/Filter",
	"sap/ui/model/FilterOperator"
], function(Controller, Filter, FilterOperator) {
	"use strict";

	return Controller.extend("com.penninkhof.odata.controller.Main", {

		onSearchPressed: function(event) {
			var search = event.getParameters().query;
			this.getView().byId("table").getBinding("items").filter(
				[ new Filter([
					new Filter("Email", FilterOperator.Contains, search),
					new Filter("Naam", FilterOperator.Contains, search)
				], false)]);
		}
		
	});

});
