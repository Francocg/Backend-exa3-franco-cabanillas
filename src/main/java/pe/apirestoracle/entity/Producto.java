package pe.apirestoracle.entity;

public class Producto {
	private int idproducto;
	private String nomprod;
	private String precio;
	private String stock;
	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Producto(int idproducto, String nomprod, String precio, String stock) {
		super();
		this.idproducto = idproducto;
		this.nomprod = nomprod;
		this.precio = precio;
		this.stock = stock;
	}
	public int getIdproducto() {
		return idproducto;
	}
	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}
	public String getNomprod() {
		return nomprod;
	}
	public void setNomprod(String nomprod) {
		this.nomprod = nomprod;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	
}
