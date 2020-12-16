package pe.apirestoracle.daoImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import pe.apirestoracle.dao.ProductoDao;
import pe.apirestoracle.entity.Producto;

@Component
public class ProductoDaoImpl implements ProductoDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	Gson gson =new Gson();
	
	@Override
	public int create(Producto pr) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call pk_producto.sp_create_producto(?,?,?)", pr.getNomprod(),pr.getPrecio(),pr.getStock());
	}

	@Override
	public int update(Producto pr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Producto> readHola(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> readAll() {
		// TODO Auto-generated method stub
		String har ="select * from producto";
		return jdbcTemplate.queryForList(har);
	}

	@Override
	public List<GrantedAuthority> buscarProducto(int iduser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void convertitMap(Map<String, Object> map) {
		// TODO Auto-generated method stub
		
	}

	
}
