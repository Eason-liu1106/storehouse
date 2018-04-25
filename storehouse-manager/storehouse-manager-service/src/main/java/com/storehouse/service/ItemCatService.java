package com.storehouse.service;

import java.util.List;

import com.storehouse.common.pojo.EUTreeNode;


public interface ItemCatService {
	public List<EUTreeNode> getCatList(long parentId);
}
