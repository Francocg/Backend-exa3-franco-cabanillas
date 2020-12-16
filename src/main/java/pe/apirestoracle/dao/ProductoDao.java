package pe.apirestoracle.dao;

import java.util.List;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;

import pe.apirestoracle.entity.Producto;

public interface ProductoDao {

	int create(Producto pr);
	int update(Producto pr);
	int update(int id);
	int delete(int id);
	List<Producto> readHola(int id);
	List<Map<String, Object>> read(int id);
	List<Map<String, Object>> readAll();
	List<GrantedAuthority> buscarProducto(int iduser);
	void convertitMap(Map<String, Object> map);
}
