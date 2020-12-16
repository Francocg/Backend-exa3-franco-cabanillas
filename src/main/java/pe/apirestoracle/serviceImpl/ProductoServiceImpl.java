package pe.apirestoracle.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.apirestoracle.dao.ProductoDao;
import pe.apirestoracle.entity.Producto;
import pe.apirestoracle.service.ProductoService;
@Service
public class ProductoServiceImpl implements ProductoService{
@Autowired
private ProductoDao pr;
	@Override
	public int create(Producto p) {
		// TODO Auto-generated method stub
		return pr.create(p);
	}

	@Override
	public List<Map<String, Object>> readAll() {
		// TODO Auto-generated method stub
		return pr.readAll();
	}
	

	
}
