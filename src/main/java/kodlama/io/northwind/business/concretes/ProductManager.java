package kodlama.io.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.northwind.business.abstracts.ProductService;
import kodlama.io.northwind.core.utilities.results.DataResult;
import kodlama.io.northwind.core.utilities.results.Result;
import kodlama.io.northwind.core.utilities.results.SuccessDataResult;
import kodlama.io.northwind.core.utilities.results.SuccessResult;
import kodlama.io.northwind.dataAccess.abstracts.ProductDao;
import kodlama.io.northwind.entities.concretes.Product;

@Service
public class ProductManager implements ProductService{

	private ProductDao productDao;
	
	@Autowired
	public ProductManager(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}

	@Override
	public DataResult<List<Product>> getAll() {
		
		return new SuccessDataResult<List<Product>>(this.productDao.findAll(),"Data listelendi");
		
	}

	@Override
	public Result add(Product product) {
		this.productDao.save(product);
		return new SuccessResult("Ürün eklendi");
	}

	@Override
	public Result delete(Product product) {
		this.productDao.delete(product);
		return new SuccessResult("Ürün silindi");
	}

	@Override
	public Result update(Product product) {
		
		return null;
	}

}
