package org.generation.ecommerce.service;


import java.util.List;

import org.generation.ecommerce.model.Producto;
import org.generation.ecommerce.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {
	private final ProductoRepository productoRepository;
	@Autowired
	public ProductoService(ProductoRepository productoRepository) {
		this.productoRepository = productoRepository;
	}//constructor
	
	public List<Producto> getAllProductos() {
		return productoRepository.findAll();
	}//getAllProductos

	public Producto getProducto(Long id) {
		return productoRepository.findById(id).orElseThrow(
	   ()-> new IllegalArgumentException("El Producto con el id [" + id
	   		+ "] no existe")
				);
	}//getProducto

	public Producto deleteProducto(Long id) {
		Producto tmp=null;
		if (productoRepository.existsById(id)) {
			tmp=productoRepository.findById(id).get();
			productoRepository.deleteById(id);
		}//if
		return tmp;
	}//deleteProducto

	public Producto addProducto(Producto producto) {
		Producto tmp=null;
		if (productoRepository.findByNombre(producto.getNombre()).isEmpty()) {
			tmp = productoRepository.save(producto);
		} else {
			System.out.println("Ya existe el producto con el nombre ["
					+ producto.getNombre() + "]");
		}//if
		return tmp;
	}//addProducto

	public Producto updateProducto(Long id, String nombre, String descripcion, 
			String imagen, Double precio) {
		Producto tmp=null;
			if (productoRepository.existsById(id)) {//found
				tmp=productoRepository.findById(id).get();
				if(nombre!=null) tmp.setNombre(nombre);
				if(descripcion!=null) tmp.setDescripcion(descripcion);
				if(imagen!=null) tmp.setImagen(imagen);
				if(precio!=null) tmp.setPrecio(precio);
				productoRepository.save(tmp);
			}else {
				System.out.println("Update - El producto con el id [" + id
						+ "] no existe");
			}//else //if
		return tmp;
	}//updateProducto

}//class ProductoService
