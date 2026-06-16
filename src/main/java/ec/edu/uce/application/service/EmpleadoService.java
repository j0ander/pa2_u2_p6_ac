package ec.edu.uce.application.service;

import ec.edu.uce.domain.model.Empleado;
import ec.edu.uce.domain.repository.EmpleadoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class EmpleadoService {
    @Inject
    private EmpleadoRepository er;
    @Inject
    private CiudadanoService ciudadanoService;
    
    @Transactional
    public void guardar(Empleado empleado) {
        /* Ciudadano cd1 = new Ciudadano("AndersonJoel2", LocalDateTime.now());
        ciudadanoService.guardar(cd1);
        cd1.setNombre("Diego");
        empleado.setCiudadano(cd1); */
        this.er.crear(empleado);
    }
}
