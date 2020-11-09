package pe.apirestoracle.daoImpl;
import java.util.Map;
import java.util.Map.Entry;

import oracle.jdbc.internal.OracleTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;
import pe.apirestoracle.dao.RolDao;
import pe.apirestoracle.entity.Rol;
@Component
public class RolDaoImpl implements RolDao {
@Autowired
private JdbcTemplate jdbcTemplate;
private SimpleJdbcCall simpleJdbcCall;


@Override
	public Map<String, Object> read(int id) {
		System.out.println(id); 
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)			
		.withCatalogName("pk_roles") //nombre del paquete
		.withProcedureName("sp_read_rol") //nombre del procedimiento
		.declareParameters(new SqlOutParameter("cursor_roles", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()), new SqlParameter("idrol", OracleTypes.NUMBER));
		SqlParameterSource in = new MapSqlParameterSource().addValue("idrol", id);
/*		Map<String, Object> out= simpleJdbcCall.execute(in);	
		out.forEach((rol, nomrol)->{
			System.out.println(rol+"aaa "+nomrol);
		});*/
		return simpleJdbcCall.execute(in);
	}

@Override
public Map<String, Object> readAll() {
	simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
			.withCatalogName("pk_roles") //nombre del paquete
			.withProcedureName("sp_listar_roles") //nombre del procedimiento
			.declareParameters(new SqlOutParameter("cursor_roles", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()));	
	
	return simpleJdbcCall.execute();
}

@Override
public int create(Rol r) {
	// TODO Auto-generated method stub
	return  jdbcTemplate.update("call pk_roles.sp_create_rol(?)", r.getNomrol());
}

@Override
public int update(Rol r) {
	System.out.println(r.getNomrol());
	// TODO Auto-generated method stub
	return  jdbcTemplate.update("call pk_roles.sp_update_rol(?,?)", r.getId_rol(),r.getNomrol());
}

@Override
public int delete(int id) {
	// TODO Auto-generated method stub
	return jdbcTemplate.update("call pk_roles.sp_delete_rol(?)", id);
}
@Override
public void convertitMap(Map<String, Object> map) {
	Rol rol = new Rol();
	for (Entry<String, Object> entry : map.entrySet()) {
        System.out.println("entry key : "+entry.getKey());
        System.out.println("Object value :"+entry.getValue());     
        System.out.println("Object value :"+entry.getClass().toString());     
	}
}

@Override
public int update(int id) {
	// TODO Auto-generated method stub
	return  jdbcTemplate.update("call pk_roles.sp_delete_logica_rol(?)", id);
}
}
