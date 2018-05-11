package com.storehouse.service.impl;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.storehouse.common.pojo.EUDataGridResult;
import com.storehouse.common.pojo.StorehouseResult;
import com.storehouse.common.utils.DateUtil;
import com.storehouse.common.utils.IDUtils;
import com.storehouse.dao.BaseDaoI;
import com.storehouse.model.BaseModel;
import com.storehouse.model.InItemDetailModel;
import com.storehouse.model.MoveIntemModel;
import com.storehouse.model.OutItemModel;
import com.storehouse.pojo.Customers;
import com.storehouse.pojo.InItem;
import com.storehouse.pojo.InItemDetail;
import com.storehouse.pojo.ItemCat;
import com.storehouse.pojo.ItemParamItem;
import com.storehouse.pojo.Measureunits;
import com.storehouse.pojo.OutItem;
import com.storehouse.pojo.OutItemDetail;
import com.storehouse.pojo.Stores;
import com.storehouse.pojo.Suppliers;
import com.storehouse.pojo.custom.ActiveUser;
import com.storehouse.service.InItemService;
import com.storehouse.service.OutItemService;
@Service()
public class OutItemServiceImpl extends BaseServiceImpl implements OutItemService {
	@Autowired
	private BaseDaoI<InItem> inItemDao;
	@Autowired
	private BaseDaoI<InItemDetail> inItemDetailDao;
	@Autowired
	private BaseDaoI<ItemParamItem> itemParamItemDao;
	@Autowired
	private BaseDaoI<Measureunits> measureunitDao;
	@Autowired
	private BaseDaoI<Stores> storesDao;
	@Autowired
	private BaseDaoI<Suppliers> SuppliersDao;
	@Autowired
	private BaseDaoI<Customers> customersDao;
	@Autowired
	private BaseDaoI<ItemCat> itemCatDao;
	@Autowired
	private BaseDaoI<OutItem> outItemDao;
	@Autowired
	private BaseDaoI<OutItemDetail> outItemDetailDao;

	@Override
	public OutItem getOutItemById(String itemId) {
		// TODO Auto-generated method stub
		return outItemDao.get(OutItem.class, itemId);
	}

	@Override
	public InItemDetailModel getOutItemDetailById(String itemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EUDataGridResult getOutItemList(BaseModel bm) {
		// TODO Auto-generated method stub
		String  hql="from OutItem a ";
		String  totalhql="select count(*) from OutItem a";
		Map<String, Object> params=new HashMap<String, Object>();
		hql=addWhere(bm, hql, params);
		hql=addOrder(bm, hql);
		totalhql=addWhere(bm, totalhql, params);
		EUDataGridResult eUDataGridResult=new EUDataGridResult();
		
		List<OutItem> outItems= outItemDao.find(hql,params,bm.getPage(),bm.getRows());
		Long total=outItemDao.count(totalhql,params);
			
		eUDataGridResult.setRows(outItems);
		eUDataGridResult.setTotal(total);
		
		return eUDataGridResult;
	}

	@Override
	public EUDataGridResult getOutItemDetailList(BaseModel bm) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public StorehouseResult addOutItem(OutItemModel outItemModel,ActiveUser activeUser) throws Exception {
		// TODO Auto-generated method stub
		InItem inItem=inItemDao.get(InItem.class, outItemModel.getId());
		Stores stores=storesDao.get(Stores.class,outItemModel.getStoreId());
		System.out.println("物品出库所在仓库仓库名："+stores.getName());
		StorehouseResult storehouseResult=new StorehouseResult();
		if(outItemModel.getOutnum()>0 && outItemModel.getOutnum()<=inItem.getNum()){//判断出库数量大于0，保证出库的物品数量要小于当前所拥有的物品数量
			Timestamp now=DateUtil.getNow();
			OutItem outItem=new OutItem();
			OutItemDetail outItemDetail=new OutItemDetail();
			outItem.setBrand(inItem.getBrand());
			outItem.setId(IDUtils.genItemId()+"");
			Customers customer=customersDao.get(Customers.class, outItemModel.getCustomerId());
			InItemDetail s=new InItemDetail();
			outItem.setCustomerName(customer.getName());
			outItem.setItemCatName(inItem.getItemCatName());
			outItem.setNum(outItemModel.getOutnum());
			outItem.setOutStoreName(inItem.getStoreName());
			
			outItem.setOutUserName(activeUser.getUsername());
			//jk
			String hql="from InItemDetail where in_item_id="+outItemModel.getId();
			s = inItemDetailDao.get(hql);
		
			
			s.setActualnumber(inItem.getNum()-outItemModel.getOutnum());
			inItemDetailDao.update(s);
			outItemDetail.setCustomer(customer);
			outItemDetail.setDescription(outItemModel.getDescription());
			outItemDetail.setFlag(0);
			outItemDetail.setId(IDUtils.genItemId()+"");
			outItemDetail.setInItem(inItem);
			outItemDetail.setItemCat(s.getItemCat());
			outItemDetail.setOutItem(outItem);
			outItemDetail.setOutUserId(activeUser.getUserid());
			outItemDetail.setStores(s.getStores());
			outItem.setCreatedatetime(now);
			outItem.setModifydatetime(now);
			outItemDetail.setCreatedatetime(now);
			outItemDetail.setModifydatetime(now);
			outItemDao.save(outItem);
			String result=(String) outItemDetailDao.save(outItemDetail);
			
			inItem.setNum(inItem.getNum()-outItemModel.getOutnum());
			if(result.length()>0){
				System.out.println("出库仓库的现有库存（前）："+stores.getStock());
				stores.setStock((Integer.valueOf(stores.getStock())-outItemModel.getOutnum())+"");//该仓库的现有库存应该减去此时所要出库的数量
				System.out.println("出库仓库的现有库存（后）："+stores.getStock());
				storehouseResult.setMsg("出库成功");
				storehouseResult.setData("200");
			}else{
				storehouseResult.setMsg("出库失败");
				storehouseResult.setData("404");
			}
			
		}else{
			storehouseResult.setMsg("出库数量超出仓库限制，失败");
			storehouseResult.setData("404");
		}
		return storehouseResult;
	}

	@Override
	public StorehouseResult delete(Serializable ids) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	@Override
	public StorehouseResult update(OutItemModel outItemModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getOutItemIdsByStoreId(String hql) {
		// TODO Auto-generated method stub
		return outItemDao.getHql(hql);
	}

	@Override
	public List getOutItemChartByStoreId(String hql) {
		// TODO Auto-generated method stub
		return outItemDao.getHql(hql);
	}

	



}
