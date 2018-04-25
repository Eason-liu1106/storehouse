package com.storehouse.model;

import java.util.Date;




public class StoreModel extends BaseModel{

	// 自己添加的属性
	
		private String storeTypeId;
		private String calculateId;
		private String rackId;
		private String description;
		private String bigstock;
		private String smallstock;
		private Integer iffull;
		private String stock;
		private Integer remainStock;
		
		
		public Integer getRemainStock() {
			return remainStock;
		}
		public void setRemainStock(Integer remainStock) {
			this.remainStock = remainStock;
		}
		public String getStock() {
			return stock;
		}
		public void setStock(String stock) {
			this.stock = stock;
		}
		public Integer getIffull() {
			return iffull;
		}
		public void setIffull(Integer iffull) {
			this.iffull = iffull;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getStoreTypeId() {
			return storeTypeId;
		}
		public void setStoreTypeId(String storeTypeId) {
			this.storeTypeId = storeTypeId;
		}
		public String getCalculateId() {
			return calculateId;
		}
		public void setCalculateId(String calculateId) {
			this.calculateId = calculateId;
		}
		public String getRackId() {
			return rackId;
		}
		public void setRackId(String rackId) {
			this.rackId = rackId;
		}
		public String getBigstock() {
			return bigstock;
		}
		public void setBigstock(String bigstock) {
			this.bigstock = bigstock;
		}
		public String getSmallstock() {
			return smallstock;
		}
		public void setSmallstock(String smallstock) {
			this.smallstock = smallstock;
		}
		
		
}
