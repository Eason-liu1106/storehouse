package com.storehouse.service.impl;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.storehouse.common.pojo.EUDataGridResult;
import com.storehouse.common.pojo.StorehouseResult;
import com.storehouse.common.utils.IDUtils;
import com.storehouse.dao.BaseDaoI;
import com.storehouse.model.InItemDetailModel;
import com.storehouse.model.StoreModel;
import com.storehouse.model.StoreName;
import com.storehouse.model.StoreNames;
import com.storehouse.pojo.Calculate;
import com.storehouse.pojo.InItem;
import com.storehouse.pojo.InItemDetail;
import com.storehouse.pojo.OutItemDetail;
import com.storehouse.pojo.Rack;
import com.storehouse.pojo.StoreType;
import com.storehouse.pojo.Stores;
import com.storehouse.pojo.custom.StoresCustom;
import com.storehouse.service.InItemService;
import com.storehouse.service.OutItemService;
import com.storehouse.service.StoresService;



@Service("storesService")
public class StoresServiceImpl  extends BaseServiceImpl implements StoresService {
	@Autowired
	private BaseDaoI<Stores> storesDao;
	@Autowired
	private BaseDaoI<StoreType> storeTypeDao;
	@Autowired
	private BaseDaoI<Rack> rackDao;
	@Autowired
	private BaseDaoI<Calculate> calculateDao;
	@Autowired
	private BaseDaoI<InItemDetail> inItemDetailDao;
	@Autowired
	private BaseDaoI<InItem> inItemDao;
	@Autowired
	private InItemService inItemService;
	
	@Override
	
	public EUDataGridResult getStoresList(StoreModel sm) {
		// TODO Auto-generated method stub
		String  hql="from Stores a";
		String  totalhql="select count(*) from Stores a";
		Map<String, Object> params=new HashMap<String, Object>();
		
		hql=addWhere(sm, hql, params);
		hql=addOrder(sm, hql);
		totalhql=addWhere(sm, totalhql, params);
		EUDataGridResult eUDataGridResult=new EUDataGridResult();
		List<Stores> stores= storesDao.find(hql,params,sm.getPage(),sm.getRows());
		Long total=storesDao.count(totalhql,params);
		List<StoresCustom> storesCustoms=new ArrayList<StoresCustom>();
		
		if (stores != null && stores.size() > 0) {// 转换模型
			for (Stores store : stores) {
				StoresCustom storesCustom=new StoresCustom();
				storesCustom.setRemainStock(Integer.valueOf(store.getBigstock())-Integer.valueOf(store.getStock()));
				ChangeModel(store, storesCustom);
				storesCustoms.add(storesCustom);
				
			}
		}				
		
		
		eUDataGridResult.setRows(storesCustoms);
		
		eUDataGridResult.setTotal(total);
		
		return eUDataGridResult;
	}
	public Stores judgeStoreName(String param){
		String hql="from Stores where name='"+param+"'";
		Stores stores=(Stores) storesDao.judgeTOrF(hql);
		return stores;
		
	}
	public StorehouseResult addStore(StoreModel sm) {
		Stores store=new Stores();
		StorehouseResult storehouseResult=new StorehouseResult();		
		BeanUtils.copyProperties(sm, store);
		if(this.judgeStoreName(store.getName())==null){
			store.setCalculate(calculateDao.get(Calculate.class, sm.getCalculateId()));
			store.setRack(rackDao.get(Rack.class,sm.getRackId()));
			store.setStoreType(storeTypeDao.get(StoreType.class, sm.getStoreTypeId()));
			store.setStock("0");
			store.setSmallstock("0");
			store.setIffull(1);		
			store.setCreatedatetime(new Timestamp(new Date().getTime()));
			store.setModifydatetime(new Timestamp(new Date().getTime()));
			store.setId(IDUtils.genItemId()+"");
			String  s=(String) storesDao.save((Stores)store);
			
			if(s.length()>0)
			{
				StoresCustom storesCustom=new StoresCustom();
				storesCustom.setRemainStock(Integer.valueOf(store.getBigstock()));
				ChangeModel(store, storesCustom);
				storehouseResult.setData(storesCustom);
				storehouseResult.setMsg("添加成功");
				storehouseResult.setStatus(200);
			}else {
				storehouseResult.setMsg("对不起添加失败,请重新添加");
				storehouseResult.setStatus(404);
			}
		}else{
			storehouseResult.setMsg("仓库名已存在，请重新添加");
			storehouseResult.setStatus(404);
		}
		
		return storehouseResult;
	}
	@Override
	public StorehouseResult update(StoreModel sm,StoreModel storeModel) {
		// TODO Auto-generated method stub
		StorehouseResult storehouseResult=new StorehouseResult();	
		Stores store=new Stores();	
		BeanUtils.copyProperties(sm, store);
		
		store.setCalculate(calculateDao.get(Calculate.class, sm.getCalculateId()));
		store.setRack(rackDao.get(Rack.class,sm.getRackId()));
		store.setStoreType(storeTypeDao.get(StoreType.class, sm.getStoreTypeId()));
		store.setModifydatetime(new Timestamp(new Date().getTime()));
		
		//System.out.println(sm.getCreatedatetime());
		if(storesDao.update((Stores) store))
		{
		StoresCustom storesCustom=new StoresCustom();
		ChangeModel(store, storesCustom);
		
		if(store.getName()!=null){
			String hql="from InItem where store_name='"+storeModel.getName()+"'";
			List<InItem> inItemList=inItemDao.getHql(hql);
			System.out.println(inItemList.size());
			System.out.println("前仓库名称："+storeModel.getName());
			System.out.println("修改过后仓库名称："+storesCustom.getName());
			InItemDetail inItemDetail=new InItemDetail();
			for(InItem inItem:inItemList){
				String hql1="from InItemDetail where in_Item_id='"+inItem.getId()+"'";
				inItemDetail=inItemDetailDao.get(hql1);
				inItem.setStoreName(storesCustom.getName());
				inItem.setRental(Integer.valueOf(inItemDetail.getTime())*Integer.valueOf(store.getCalculate().getMon()));
				inItemDetail.setRental(inItem.getRental());
				inItemDao.update(inItem);
			}
			storehouseResult.setData(storesCustom);
			storehouseResult.setMsg("修改成功");
			storehouseResult.setStatus(200);
		}
		
		}else{
			storehouseResult.setStatus(404);
			storehouseResult.setMsg("更新失败，请重试");
			
		}
		return storehouseResult;
	}
	@Override
	public StorehouseResult delete(Serializable ids) {
		// TODO Auto-generated method stub
		StorehouseResult storehouseResult=new StorehouseResult();
		
			for (String id : ((String) ids).split(",")) {
				Stores s = storesDao.get(Stores.class, id);
				if (s != null) {
					String hql="select s.inItem.id from InItemDetail s where s.stores.id="+id;
					
					List list=inItemService.getInItemIdsByStoreId(hql);
					for(int i=0;i<list.size();i++){
						inItemService.delete((String)list.get(i));
					}
					storesDao.delete(s);
					
					storehouseResult.setMsg("删除成功");
					storehouseResult.setStatus(200);
				}
				else {
					storehouseResult.setMsg("删除失败");
					storehouseResult.setStatus(404);
				}
			}
			return storehouseResult;
		
	}
	
	public void ChangeModel(Stores store, StoresCustom storesCustom)
	{
		BeanUtils.copyProperties(store, storesCustom);
		storesCustom.setCalculateName(store.getCalculate().getName());
		storesCustom.setCalculateId(store.getCalculate().getId());
		storesCustom.setRackName(store.getRack().getName());
		storesCustom.setRackId(store.getRack().getId());
		storesCustom.setStoreTypeName(store.getStoreType().getName());
		storesCustom.setStoreTypeId(store.getStoreType().getId());
		
	}
	@Override
	public StoreNames getStoreNames(String id,int page,int rows) {
		// TODO Auto-generated method stub
		StoreNames names=new StoreNames();
		String hql=null;
		if(id!=null)
		{
			hql="select name,id from Stores where id="+id;
		}
		else{
			 hql="select name,id from Stores";
		}
		List<StoreName> list=new ArrayList<>();
		
		list =storesDao.findObjects(hql,page,rows);
		
		
		long total=storesDao.count("select count(*) from Stores");
		names.setData(list);
		names.setTotal(total);
		return names;
		
	}
	@Override
	public Stores getStoreById(String id) {
		// TODO Auto-generated method stub
		return storesDao.get(Stores.class, id);
	}
	
	@Override
	public StoreModel getStoreModelById(String id) {
		// TODO Auto-generated method stub
		String hql="from Stores where id="+id;
		StoreModel storeModel = new  StoreModel();
		Stores stores=new Stores();
		
		stores=storesDao.get(hql);
		BeanUtils.copyProperties(stores, storeModel);
		storeModel.setCalculateId(stores.getCalculate().getId());
		storeModel.setStoreTypeId(stores.getStoreType().getId());
		storeModel.setRackId(stores.getRack().getId());
		
		return storeModel;
	}
	
}
