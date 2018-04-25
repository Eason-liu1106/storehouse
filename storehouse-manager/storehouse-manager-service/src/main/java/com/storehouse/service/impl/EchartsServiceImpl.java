package com.storehouse.service.impl;


import java.util.ArrayList;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.storehouse.common.pojo.EchartsResult;

import com.storehouse.model.StoreNames;

import com.storehouse.pojo.Stores;

import com.storehouse.service.EchartsService;
import com.storehouse.service.InItemService;
import com.storehouse.service.OutItemService;
import com.storehouse.service.StoresService;



@Service()
public class EchartsServiceImpl implements EchartsService {


	@Autowired
	private StoresService storesService;
	@Autowired
	private InItemService inItemService;
	@Autowired
	private OutItemService outItemService;
	@Override
	public EchartsResult getInItemChartById(String id) {
	
		

	Stores store=storesService.getStoreById(id);
	
	
	long total=0;
	List echarts=new ArrayList<>();

		
	String hql2="select date(t.createdatetime),sum(t.num) from InItem t , InItemDetail s  where t.id=s.inItem.id and s.stores.id='"+id+"' group by date(t.createdatetime)";
		echarts=inItemService.getInItemChartByStoreId(hql2);	
	
	
	List data=new ArrayList();
	List name=new ArrayList();
	String text =store.getName();
	EchartsResult e=new EchartsResult();

	for(int i=0;i<echarts.size();i++){
		
		Object[] temp= (Object[]) echarts.get(i);
		System.out.println(temp[0]);
			data.add(temp[0]);
			name.add(temp[1]);

	}
	e.setData(data);
	e.setName(name);
	e.setText(text);
	
		return e;
	}
	@Override
	public EchartsResult getOutItemChartById(String id) {
		// TODO Auto-generated method stub
		Stores store=storesService.getStoreById(id);
		
		
		long total=0;
		List echarts=new ArrayList<>();

			
		String hql2="select date(t.createdatetime),sum(t.num) from OutItem t , OutItemDetail s  where t.id=s.outItem.id and s.stores.id='"+id+"' group by date(t.createdatetime)";
			//echarts=inItemService.getInItemChartByStoreId(hql2);	
		echarts=outItemService.getOutItemChartByStoreId(hql2);
		
		List data=new ArrayList();
		List name=new ArrayList();
		String text =store.getName();
		EchartsResult e=new EchartsResult();

		for(int i=0;i<echarts.size();i++){
			
			Object[] temp= (Object[]) echarts.get(i);
		
				data.add(temp[0]);
				name.add(temp[1]);

		}
		e.setData(data);
		e.setName(name);
		e.setText(text);
		
			return e;
	}
	@Override
	public StoreNames getStoreNames(String  id,int page,int rows) {
		// TODO Auto-generated method stub
		return  storesService.getStoreNames(id, page, rows);
	}
	@Override
	public EchartsResult getMoveItemChartById(String id) {
		// TODO Auto-generated method stub
		Stores store=storesService.getStoreById(id);
		
		
		long total=0;
		List echarts=new ArrayList<>();

		//and s.stores.id='"+id+"'
		String hql2="select date(t.createdatetime),sum(t.num) from InItem t , InItemDetail s  where t.id=s.inItem.id  and s.moveStore.id='"+id+"' group by date(t.createdatetime)";
			//echarts=inItemService.getInItemChartByStoreId(hql2);	
		echarts=outItemService.getOutItemChartByStoreId(hql2);
		
		List data=new ArrayList();
		List name=new ArrayList();
		String text =store.getName();
		EchartsResult e=new EchartsResult();

		for(int i=0;i<echarts.size();i++){
			
			Object[] temp= (Object[]) echarts.get(i);
		
				data.add(temp[0]);
				name.add(temp[1]);

		}
		e.setData(data);
		e.setName(name);
		e.setText(text);
		
			return e;
	}


}
