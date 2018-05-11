package com.storehouse.service.impl;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.storehouse.pojo.InItem;
import com.storehouse.pojo.InItemDetail;
import com.storehouse.pojo.ItemCat;
import com.storehouse.pojo.ItemParamItem;
import com.storehouse.pojo.Measureunits;
import com.storehouse.pojo.Stores;
import com.storehouse.pojo.Suppliers;
import com.storehouse.pojo.custom.ActiveUser;
import com.storehouse.service.InItemService;
import com.storehouse.service.StoresService;

import net.sf.ehcache.management.Store;
@Service()
public class InItemServiceImpl extends BaseServiceImpl implements InItemService {
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
	private BaseDaoI<ItemCat> itemCatDao;
	@Autowired
	private StoresService storesService;
	
	@Override
	public InItem getInItemById(String itemId) {
		// TODO Auto-generated method stub
		return (InItem) inItemDao.get(InItem.class, itemId);
	}

	@Override
	public InItemDetailModel getInItemDetailById(String itemId) {
		// TODO Auto-generated method stub
		String hql="from InItemDetail where in_item_id="+itemId;
		InItemDetailModel inItemDetailModel = new  InItemDetailModel();
		InItemDetail inItemDetail=new InItemDetail();
		InItem inItem=new InItem();
		inItem=(InItem) inItemDao.get(InItem.class, itemId);
		
		inItemDetail=inItemDetailDao.get(hql);
		BeanUtils.copyProperties(inItemDetail, inItemDetailModel);
		BeanUtils.copyProperties(inItem, inItemDetailModel);
		inItemDetailModel.setItemCatId(inItemDetail.getItemCat().getId());
		//inItemDetailModel.setNum(inItem.getNum());
		inItemDetailModel.setMeasureunitId(inItemDetail.getMeasureunits().getId());
		
		inItemDetailModel.setStoreId(inItemDetail.getStores().getId());
		
		inItemDetailModel.setSupplierId(inItemDetail.getSuppliers().getId());
	
		
		return inItemDetailModel;
	}

	@Override
	public EUDataGridResult getInItemList(BaseModel bm) {
		// TODO Auto-generated method stub
		
		String  hql="from InItem a ";
		String  totalhql="select count(*) from InItem a";
		Map<String, Object> params=new HashMap<String, Object>();
		hql=addWhere(bm, hql, params);
		hql=addOrder(bm, hql);
		totalhql=addWhere(bm, totalhql, params);
		EUDataGridResult eUDataGridResult=new EUDataGridResult();
		
		List<InItem> InItems= inItemDao.find(hql,params,bm.getPage(),bm.getRows());
		Long total=inItemDao.count(totalhql,params);
			
		eUDataGridResult.setRows(InItems);
		eUDataGridResult.setTotal(total);
		
		return eUDataGridResult;
	}

	@Override
	public StorehouseResult addInItem(InItemDetailModel inItemDetailModel, InItem inItem, String itemParam,ActiveUser activeUser,Stores stores,String time) throws Exception {
		
		StorehouseResult storehouseResult=new StorehouseResult();
		if(inItem.getNum()>0 && inItem.getNum()<=Integer.valueOf(stores.getBigstock()) && 
		   (Integer.valueOf(stores.getStock())+inItem.getNum())<=Integer.valueOf(stores.getBigstock())){//添加物品入库时，保证所添加的物品数量大于零
																										//保证添加的数量不超过该仓库的最大库存限制
																										//保证添加的数量与该仓库已占库存的数量相加后不超过最大库存限制
			System.out.println("添加月金额"+stores.getCalculate().getMon());
			int finRental=Integer.valueOf(time)*Integer.valueOf(stores.getCalculate().getMon());
			Timestamp now=DateUtil.getNow();
			InItemDetail inItemDetail=new InItemDetail();
			inItem.setId(IDUtils.genItemId()+"");
			inItem.setCreatedatetime(now);
			inItem.setModifydatetime(now);
			inItem.setInUserName(activeUser.getUsername());		
			inItem.setRental(finRental);
			inItemDao.save(inItem);
			inItemDetail.setInItem(inItem);
			ItemParamItem itemParamItem=new ItemParamItem();
			itemParamItem.setId(IDUtils.genItemId()+"");
			itemParamItem.setParamData(itemParam);
			itemParamItem.setCreatedatetime(now);
			itemParamItem.setModifydatetime(now);
			itemParamItemDao.save(itemParamItem);
			inItemDetail.setItemCat(itemCatDao.get(ItemCat.class, inItemDetailModel.getItemCatId()));
			inItemDetail.setMeasureunits(measureunitDao.get(Measureunits.class,inItemDetailModel.getMeasureunitId()));
			inItemDetail.setStores(storesDao.get(Stores.class, inItemDetailModel.getStoreId()));
			inItemDetail.setSuppliers(SuppliersDao.get(Suppliers.class, inItemDetailModel.getSupplierId()));
			inItemDetail.setItemParamItem(itemParamItem);
			inItemDetail.setCreatedatetime(now);
			inItemDetail.setModifydatetime(now);
			BeanUtils.copyProperties(inItemDetailModel, inItemDetail);
			inItemDetail.setId(IDUtils.genItemId()+"");
			inItemDetail.setInUserId(activeUser.getUserid());
			inItemDetail.setActualnumber(inItem.getNum());
			inItemDetail.setFlag(1);
			
			inItemDetail.setRental(finRental);
			String s=(String) inItemDetailDao.save(inItemDetail);
			if(s.length()>0)
			{
				if(stores.getStock()==null){
					stores.setStock(inItem.getNum()+"");
				}else{
					stores.setStock((Integer.valueOf(stores.getStock())+inItem.getNum())+"");
				}
				storehouseResult.setMsg("添加成功");
				storehouseResult.setStatus(200);
		
			}else {
				storehouseResult.setMsg("对不起添加失败,请重新添加");
				storehouseResult.setStatus(404);
			}
			
		}else{
			storehouseResult.setMsg("所添加库存数量超出限制，失败");
			storehouseResult.setStatus(404);
		}
		return storehouseResult;
	}

	@Override
	public StorehouseResult update(InItemDetailModel inItemDetailModel,InItem inItem, String itemParam) {
		// TODO Auto-generated method stub
		Stores stores=storesService.getStoreById(inItemDetailModel.getStoreId());
		System.out.println("修改月金额"+stores.getCalculate().getMon());
		System.out.println("修改租期："+inItemDetailModel.getTime());
		int finRental=Integer.valueOf(inItemDetailModel.getTime())*Integer.valueOf(stores.getCalculate().getMon());
		Timestamp now=DateUtil.getNow();
		StorehouseResult storehouseResult=new StorehouseResult();
		InItemDetail inItemDetail=new InItemDetail();
		ItemParamItem itemParamItem=new ItemParamItem();
		itemParamItem.setParamData(itemParam);
		itemParamItem.setId(IDUtils.genItemId()+"");		
		itemParamItem.setCreatedatetime(now);
		itemParamItem.setModifydatetime(now);
		itemParamItemDao.save(itemParamItem);
		inItemDetail.setItemParamItem(itemParamItem);
		
		String hql=" from InItemDetail where in_item_id='"+inItem.getId()+"'";
		inItemDetail=inItemDetailDao.get(hql);
		inItemDetailModel.setId(inItemDetail.getId());
//		System.out.println("后"+inItemDetailModel.getId());
		BeanUtils.copyProperties(inItemDetailModel, inItemDetail);
//		inItemDetailModel.setInUserId(null);
//		inItemDetail.setInUserId(inItemDetailModel.getInUserId());
		InItem inItem2=inItemDao.get(InItem.class, inItem.getId());
		BeanUtils.copyProperties(inItem, inItem2);
		System.out.println("inItemDetail的id:"+inItemDetail.getId());
		inItem2.setRental(finRental);
		inItem2.setCreatedatetime(inItemDetail.getCreatedatetime());
		inItem2.setModifydatetime(now);
		
		inItemDetail.setInItem(inItem);
		inItemDetail.setItemCat(itemCatDao.get(ItemCat.class, inItemDetailModel.getItemCatId()));
		inItemDetail.setMeasureunits(measureunitDao.get(Measureunits.class,inItemDetailModel.getMeasureunitId()));
		inItemDetail.setStores(storesDao.get(Stores.class, inItemDetailModel.getStoreId()));
		inItemDetail.setSuppliers(SuppliersDao.get(Suppliers.class, inItemDetailModel.getSupplierId()));
		inItemDetail.setRental(finRental);
		inItemDetail.setActualnumber(inItem.getNum());
		inItemDetail.setFlag(1);
		inItemDetail.setModifydatetime(now);
		boolean result=inItemDetailDao.update(inItemDetail);
		if(result==true)
		{
//			storehouseResult.setData(inItemDetail);
			storehouseResult.setMsg("修改成功");
			storehouseResult.setStatus(200);		
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
			
			String hql="from InItemDetail where in_item_id="+id;
			InItem inItem=inItemDao.get(InItem.class, id);
			Stores stores=storesService.judgeStoreName(inItem.getStoreName());
			if(stores!=null){
				System.out.println("删除入库物品时仓库的现有库存(前）："+stores.getStock());
				stores.setStock((Integer.valueOf(stores.getStock())-inItem.getNum())+"");
				System.out.println("删除入库物品时仓库的现有库存(后）："+stores.getStock());
			}
			
			InItemDetail s = inItemDetailDao.get(hql);
			if (s != null&&inItem!=null) {
				inItemDetailDao.delete(s);
				inItemDao.delete(inItem);
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

	@Override
	public EUDataGridResult getInItemDetailList(BaseModel bm) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		String  hql="from InItemDetail a ";
		String  totalhql="select count(*) from InItemDetail a";
		Map<String, Object> params=new HashMap<String, Object>();
		hql=addWhere(bm, hql, params);
		hql=addOrder(bm, hql);
		totalhql=addWhere(bm, totalhql, params);
		EUDataGridResult eUDataGridResult=new EUDataGridResult();
		
		List<InItemDetail> InItemDetails= inItemDetailDao.find(hql,params,bm.getPage(),bm.getRows());
		Long total=inItemDetailDao.count(totalhql,params);
			
		eUDataGridResult.setRows(InItemDetails);
		eUDataGridResult.setTotal(total);
		
		return eUDataGridResult;
	}

	@Override
	public StorehouseResult moveInItem(MoveIntemModel moveInItemModel,ActiveUser activeUser,InItemDetailModel inItemDetailModel) {
		// TODO Auto-generated method stub
		StorehouseResult storehouseResult=new StorehouseResult();
		Stores stores=storesService.getStoreById(moveInItemModel.getMoveStoreId());//物品锁要移入的库
		Stores curStores=storesService.getStoreById(moveInItemModel.getStoreId());
		String hql="from InItemDetail where flag = 1 and in_item_id="+ moveInItemModel.getId();
//		InItemDetail iidm=inItemDetailDao.get(hql);
		
		if(moveInItemModel.getMovenum()>0 && //物品移库时，保证移库数量大于0
		   moveInItemModel.getMovenum()<=inItemDetailModel.getNum() &&//保证移库数量不超出当前所在此仓库的物品数量 
		   moveInItemModel.getMovenum()<=Integer.valueOf(stores.getBigstock()) && //保证移库数量不超出将要移入的那家仓库的最大库存限制
		   moveInItemModel.getMovenum()<=Integer.valueOf(curStores.getStock())){//保证移库数量不超出目前仓库的现有库存
			System.out.println("移库月金额"+stores.getCalculate().getMon());
			System.out.println("移库租期"+inItemDetailModel.getTime());
//			System.out.println("itemDetailId"+iidm.getId());
			
			int finRental=Integer.valueOf(inItemDetailModel.getTime())*Integer.valueOf(stores.getCalculate().getMon());
		
			if(moveInItemModel.getMoveStoreId()==moveInItemModel.getStoreId())
			{
				storehouseResult.setMsg("不能移动到同一个仓库");
				storehouseResult.setStatus(404);
				return storehouseResult;
			}
			Timestamp now=DateUtil.getNow();
			InItem inItem=new InItem();
			InItem parentInItem =new InItem();
			InItemDetail inItemDetail=new InItemDetail();
			parentInItem =inItemDao.get(InItem.class, moveInItemModel.getId());
			BeanUtils.copyProperties(parentInItem, inItem);
			inItem.setNum(moveInItemModel.getMovenum());
			inItem.setStoreName(storesDao.get(Stores.class, moveInItemModel.getMoveStoreId()).getName()  );
			inItem.setId(IDUtils.genItemId()+"");
			inItem.setRental(finRental);
			inItem.setCreatedatetime(now);
			inItem.setModifydatetime(now);
			inItemDao.save(inItem);		
			
			InItemDetail s = inItemDetailDao.get(hql);
			s.setActualnumber(parentInItem.getNum()-moveInItemModel.getMovenum());
			s.setMoveStore(storesDao.get(Stores.class, moveInItemModel.getMoveStoreId()));//???
//			s.setStores(storesDao.get(Stores.class,moveInItemModel.getStoreId()));//不成功
			BeanUtils.copyProperties(s, inItemDetail);
			inItemDetail.setStores(s.getMoveStore());
			inItemDetail.setInItem(inItem);
			inItemDetail.setActualnumber(moveInItemModel.getMovenum());
			inItemDetail.setDescription(moveInItemModel.getDescription());
			inItemDetail.setId(IDUtils.genItemId()+"");
			parentInItem.setNum(parentInItem.getNum()-moveInItemModel.getMovenum());
			parentInItem.setModifydatetime(now);
			s.setModifydatetime(now);
			inItemDetail.setCreatedatetime(now);
			inItemDetail.setModifydatetime(now);
			inItemDetail.setBrand(inItem.getBrand());
			inItemDetail.setRental(finRental);
			String result=(String) inItemDetailDao.save(inItemDetail);	
			inItemDetail.setParentInItem(parentInItem);
			inItemDetail.setFlag(1); 
			if(result.length()>0){
				if(stores.getStock()==null){//判断将物品移入的那个库中现有库存是否为空，若为空则将所移数量全部赋予它，不为空则使其相加
					stores.setStock(moveInItemModel.getMovenum()+"");//把当前所移的数量赋予即将移入的那个库中的现有库存
				}else if(stores.getStock()!=null && (Integer.valueOf(stores.getStock())+moveInItemModel.getMovenum())<=Integer.valueOf(stores.getBigstock())){
					//判断如果移入的数量与此要移入的仓库现有库存相加不超出此仓库的最大库存时才可以使两者相加
					stores.setStock((Integer.valueOf(stores.getStock())+moveInItemModel.getMovenum())+"");
				}else{
					storehouseResult.setMsg("数量不符合限制，移库失败");
					storehouseResult.setStatus(404);
				}
				if(curStores.getStock()!=null){//使当前仓库的现有库存减去要移走的数量，并赋予其自身
					curStores.setStock((Integer.valueOf(curStores.getStock())-moveInItemModel.getMovenum())+"");
				}
				storehouseResult.setMsg("移库成功！");
				storehouseResult.setStatus(200);
			}else{
				storehouseResult.setMsg("移库失败");
				storehouseResult.setStatus(404);
			}
		}else{
			storehouseResult.setMsg("数量不符合限制，移库失败");
			storehouseResult.setStatus(404);
		}
		return storehouseResult;
	}

	@Override
	public List getInItemIdsByStoreId(String hql) {
		// TODO Auto-generated method stub
		
		return inItemDao.getHql(hql);
	}

	@Override
	public List getInItemChartByStoreId(String hql) {
		// TODO Auto-generated method stub
		return inItemDao.getHql(hql);
	}



}
