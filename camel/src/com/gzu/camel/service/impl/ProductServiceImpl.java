package com.gzu.camel.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gzu.camel.mapper.ProductMapper;
import com.gzu.camel.mapper.ProducttypeMapper;
import com.gzu.camel.mapper.ShopingcarMapper;
import com.gzu.camel.pojo.Product;
import com.gzu.camel.pojo.ProductCustom;
import com.gzu.camel.pojo.ProductSplitPageVo;
import com.gzu.camel.pojo.ProducttypeCustom;
import com.gzu.camel.pojo.ShopingcarCustom;
import com.gzu.camel.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductMapper productMapper;
	
	@Autowired
	private ProducttypeMapper producttypeMapper;
	
	@Autowired
	private ShopingcarMapper shopingcarMapper;

	/**
	 * @author asus
	 * Description:根据商品名字模糊查询
	 * @return 返回整数
	 * @throws Exception
	 */
	@Override
	public int countByProductName(String name) throws Exception {
		return productMapper.countByProductName(name);
	}

	@Override
	public List<Product> splitPage(ProductSplitPageVo productSplitPageVo) throws Exception {
		List<Product> allProduct=new ArrayList<Product>();
		allProduct=productMapper.selectSplitPage(productSplitPageVo);
		return allProduct;
	}

	@Override
	public List<ProducttypeCustom> queryProductType() throws Exception {
		return producttypeMapper.selectproducttype();
	}

	@Override
	public ProductCustom queryProductDetails(int pid) throws Exception {
		return productMapper.selectProductDetails(pid);
	}

	@Override
	public void addToCart(ShopingcarCustom shopingcarCustom) throws Exception {
		shopingcarMapper.insert(shopingcarCustom);
	}

	@Override
	public List<ShopingcarCustom> queryCar(String userid) throws Exception {
		return shopingcarMapper.selectByUserid(userid);
	}

	@Override
	public void deleteProduct(ShopingcarCustom spCustom) throws Exception {
		shopingcarMapper.deleteByPrimaryKey(spCustom);
	}

	@Override
	public ShopingcarCustom queryCarByUPid(ShopingcarCustom spCustom)
			throws Exception {
		return shopingcarMapper.selectByUPid(spCustom);
	}

	@Override
	public void updateNum(ShopingcarCustom spCustom) throws Exception {
		shopingcarMapper.updateByPrimaryKey(spCustom);
	}

	@Override
	public Map<String,List<Product>> queryProductIndex(Integer count) throws Exception {
		Integer type;
		Map<String,List<Product>> allProduct = new HashMap<String,List<Product>>();
		List<Product> Products=new ArrayList<Product>();
		List<ProducttypeCustom> allType=new ArrayList<ProducttypeCustom>();
		ProductCustom productCustom=new ProductCustom();
		ProductSplitPageVo pageVo=new ProductSplitPageVo();
		//查询分类
		allType=queryProductType();
		type=allType.size();
		//首页商品展示
		for(int i=0;i<type;i++){
			productCustom.setTypeid(allType.get(i).getTypeid());
			productCustom.setCurrentPage(0);
			productCustom.setPageSize(count);
			pageVo.setProductCustom(productCustom);
			Products=splitPage(pageVo);
			allProduct.put(allType.get(i).getTypename(), Products);
		}
		
		
		
		return allProduct;
	}

	@Override
	public List<Product> queryProductByTid(Integer tid) throws Exception {
		List<Product> Products=new ArrayList<Product>();
		Products=productMapper.slectProductByTid(tid);
		return Products;
	}

	
}
