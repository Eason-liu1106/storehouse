package com.storehouse.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.storehouse.common.pojo.EUTreeNode;
import com.storehouse.dao.BaseDaoI;
import com.storehouse.pojo.ItemCat;
import com.storehouse.service.ItemCatService;

@Service("itemCatService")
public class ItemCatServiceImpl implements ItemCatService {

	@Autowired
	private BaseDaoI<ItemCat> itemCatDao;
	@Override
	public List<EUTreeNode> getCatList(long parentId) {

		List<EUTreeNode> resultList = new ArrayList<>();
		String  hql="from ItemCat where parent_id="+parentId;
		List<ItemCat> list=itemCatDao.find(hql);
		//把列表转换成treeNodelist
				for (ItemCat ItemCat : list) {
					EUTreeNode node = new EUTreeNode();
					node.setId(ItemCat.getId());
					node.setText(ItemCat.getName());
					node.setState(ItemCat.getIsParent()?"closed":"open");
					resultList.add(node);
				}
				//返回结果
				return resultList;
	}

}
