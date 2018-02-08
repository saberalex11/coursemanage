package com.ly.controller.infoManage;

import com.ly.bean.Product;
import com.ly.service.ProductService;
import com.ly.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductManageController {

    @Autowired
    private ProductService productService;

    @RequestMapping("queryProduct")
    public R queryProduct(String prodcutName,Integer page,Integer limit,Integer stockStart,Integer stockEnd){
       return productService.queryProduct(prodcutName,page,limit,stockStart,stockEnd);
    }

    @RequestMapping("addProduct")
    public R addProduct(Product product){
         productService.addSelective(product);
         return R.ok();
    }

    @RequestMapping("deleteProduct")
    public R deleteProduct(int productId){
        productService.deleteByPrimaryKey(productId);
        return R.ok();
    }

    @RequestMapping("queryProductbyId")
    public R queryProductbyId(int productId){
        Product product = productService.queryByPrimaryKey(productId);
        return R.ok().put("data",product);
    }

    @RequestMapping("saveProduct")
    public R saveProduct(Product product){
        productService.updateByPrimaryKeySelective(product);
        return R.ok();
    }

    @RequestMapping("queryAllProduct")
    public List<Product> queryAllProduct(){
        return productService.queryAll(null);
    }
}
