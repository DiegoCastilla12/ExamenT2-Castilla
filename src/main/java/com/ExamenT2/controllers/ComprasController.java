package com.ExamenT2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ExamenT2.models.Compra;
import com.ExamenT2.repositories.ICompraRepository;
import com.ExamenT2.repositories.IProveedorRepository;
import com.ExamenT2.repositories.IRubroRepository;
import com.ExamenT2.utils.Alert;



@Controller
@RequestMapping("/compras")
public class ComprasController {
	
	@Autowired  // El autowired es para importar todo el repository que quieras llevar al Controller
	private ICompraRepository _compraRepository;
	
	@Autowired
	private IProveedorRepository _proveedorRepository;
	
	@Autowired
	private IRubroRepository _rubroRepository;
	
	@GetMapping("/listado") 
	public String listado(Model model) { 
		List<Compra> lstCompra =  _compraRepository.findAllByOrderByNroOrdenDesc();
		model.addAttribute("lstCompra", lstCompra);  
		return "compras/listado";
	}
	
	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		model.addAttribute("rubros", _rubroRepository.findAll());
		model.addAttribute("proveedores", _proveedorRepository.findAll());
		model.addAttribute("compra",new Compra());
		return "compras/nuevo";
	}
	
	@PostMapping("/registrar")
	public String registrar(@ModelAttribute Compra compra, RedirectAttributes flash) {
		
		Compra registrado = _compraRepository.save(compra);
		
		String mensaje = String.format("Producto con código %s registrado", registrado.getNroOrden());
		flash.addFlashAttribute("alert", Alert.sweetAlertSuccess(mensaje));
		return "redirect:/compras/listado";
	}
	
	@GetMapping("/edicion/{id}")
	public String edicion(@PathVariable Integer id, Model model) {
		model.addAttribute("rubros", _rubroRepository.findAll());
		model.addAttribute("proveedores", _proveedorRepository.findAll());
		
		Compra compraEncontrada = _compraRepository.findById(id).orElseThrow();
		
		model.addAttribute("compra", compraEncontrada);
		return "compras/edicion";
	}
	
	@PostMapping("/guardar")
	public String guardar(@ModelAttribute Compra inventario, RedirectAttributes flash) {
		
		Compra registrado = _compraRepository.save(inventario);
		
		String mensaje = String.format("Inventario con codigo %s actualizado", registrado.getNroOrden());
		flash.addFlashAttribute("alert", Alert.sweetAlertSuccess(mensaje));
		return "redirect:/compras/listado";
	}
}
