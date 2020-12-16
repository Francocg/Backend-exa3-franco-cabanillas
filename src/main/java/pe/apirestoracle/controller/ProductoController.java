package pe.apirestoracle.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.apirestoracle.entity.Producto;
import pe.apirestoracle.service.ProductoService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders="*")
@RequestMapping("/producto")
public class ProductoController {

	@Autowired
	private ProductoService productoservice;
	
	@GetMapping("/all")
	public List<Map<String, Object>> readAll(){
		return productoservice.readAll();
	}
	@PostMapping("/add")
	public int create(@RequestBody Producto p) {
		System.out.println("Crear: "+p.getNomprod());
		System.out.println("Crear: "+p.getPrecio());
		System.out.println("Crear: "+p.getStock());
		return productoservice.create(p);
	}
}
