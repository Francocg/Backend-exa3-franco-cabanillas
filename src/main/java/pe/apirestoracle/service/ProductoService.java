package pe.apirestoracle.service;

import java.util.List;
import java.util.Map;

import pe.apirestoracle.entity.Producto;


public interface ProductoService {

	int create(Producto p);
	List<Map<String, Object>> readAll();
	
}
