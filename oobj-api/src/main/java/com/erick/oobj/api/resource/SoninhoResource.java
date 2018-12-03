package com.erick.oobj.api.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.erick.oobj.api.event.ResourceCreatedEvent;
import com.erick.oobj.api.model.SoninhoEntity;
import com.erick.oobj.api.repository.filter.SoninhoFilter;
import com.erick.oobj.api.service.SoninhoService;

public abstract class SoninhoResource<B extends SoninhoEntity, T, F extends SoninhoFilter> {

	protected abstract SoninhoService<B, T, F> getService();

	@Autowired
	private ApplicationEventPublisher publisher;

	@PostMapping
	public ResponseEntity<B> create(@Valid @RequestBody B request, HttpServletResponse response) {

		B entity = getService().save(request);

		publisher.publishEvent(new ResourceCreatedEvent(this, response, entity.getId()));

		return ResponseEntity.status(HttpStatus.CREATED).body(entity);
	}

	@GetMapping("/{id}")
	public ResponseEntity<B> findById(@PathVariable T id) {
		return getService().findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PutMapping("/{id}")
	public ResponseEntity<B> update(@PathVariable T id, @Valid @RequestBody B model) {

		return ResponseEntity.ok(getService().update(id, model));
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable T id) {
		getService().deleteById(id);
	}
	
	@GetMapping
	public List<B> find(F filter) {
		return getService().filter(filter);
	}
}
