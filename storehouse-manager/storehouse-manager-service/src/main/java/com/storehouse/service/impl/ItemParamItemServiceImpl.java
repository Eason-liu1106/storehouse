package com.storehouse.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.storehouse.common.utils.JsonUtils;
import com.storehouse.dao.BaseDaoI;
import com.storehouse.pojo.Calculate;
import com.storehouse.pojo.ItemParamItem;
import com.storehouse.service.ItemParamItemService;



/**
 * 展示商品规格参数
 * <p>Title: ItemParamItemServiceImpl</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.com</p> 
 * @author	入云龙
 * @date	2015年9月5日下午4:08:50
 * @version 1.0
 */
@Service
public class ItemParamItemServiceImpl implements ItemParamItemService {

	@Autowired
	private BaseDaoI<ItemParamItem> itemParamItemDao;
	
	@Override
	public String getItemParamByItemId(String itemId) {
		//根据商品id查询规格参数
	
		String hql="from ItemParamItem where id="+itemId;
		//执行查询
		List<ItemParamItem> list = itemParamItemDao.find(hql);
		if (list == null || list.size() == 0) {
			return "";
		}
		//取规格参数信息
		ItemParamItem itemParamItem = list.get(0);
		String paramData = itemParamItem.getParamData();
		//生成html
		// 把规格参数json数据转换成java对象
		List<Map> jsonList = JsonUtils.jsonToList(paramData, Map.class);
		StringBuffer sb = new StringBuffer();
		sb.append("<table cellpadding=\"0\" cellspacing=\"1\" width=\"100%\" border=\"1\" class=\"Ptable\">\n");
		sb.append("    <tbody>\n");
		for(Map m1:jsonList) {
			sb.append("        <tr>\n");
			sb.append("            <th class=\"tdTitle\" colspan=\"2\">"+m1.get("group")+"</th>\n");
			sb.append("        </tr>\n");
			List<Map> list2 = (List<Map>) m1.get("params");
			for(Map m2:list2) {
				sb.append("        <tr>\n");
				sb.append("            <td class=\"tdTitle\">"+m2.get("k")+"</td>\n");
				sb.append("            <td>"+m2.get("v")+"</td>\n");
				sb.append("        </tr>\n");
			}
		}
		sb.append("    </tbody>\n");
		sb.append("</table>");
		return sb.toString();
	}

}
