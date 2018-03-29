package com.evento.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.evento.model.Evento;
import com.evento.repository.EventoRepository;

@RestController
@RequestMapping("/evento")
public class EventoResources {
	
	@Autowired
	private EventoRepository er;
	
	@GetMapping(produces="application/json")
	public @ResponseBody Iterable<Evento> listaEventos() {
		Iterable<Evento> listaEvento = er.findAll();
		return listaEvento;		
	}
	
	@PostMapping
	public Evento cadastraEvento(@RequestBody @Valid Evento evento) {
		return er.save(evento);
	}
	
	@DeleteMapping
	public Evento deletaEvento(@RequestBody Evento evento) {
		er.delete(evento);
		return evento;
	}
	
	
}
