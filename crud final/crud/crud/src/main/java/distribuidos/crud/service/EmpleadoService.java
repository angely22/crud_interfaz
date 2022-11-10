package distribuidos.crud.service;

import distribuidos.crud.entities.Empleado;
import distribuidos.crud.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {

    //@Autowired // anotación para especificarle a springboot que acá estoy haciendo Inyección de Dependencias
    private EmpleadoRepository empleadoRepository;

    //constructor
    public EmpleadoService(EmpleadoRepository empleadoRepository) {

        this.empleadoRepository = empleadoRepository;
    }

    //método para crear a partir del POST
    public Empleado crearEmpleado(Empleado nuevoEmpleado){
        return this.empleadoRepository.save(nuevoEmpleado);
    }

    //método para visualizar a partir del GET
    public List<Empleado> getListaEmpleado(){

        return this.empleadoRepository.findAll();
    }

    //llamar uno solo
    public Empleado getLlamarEmpleados(Long id){
        return this.empleadoRepository.findById(id).orElseThrow();
    }


    //método para editar o actualizar a partir del PUT
    public Empleado actualizarEmpleado(Long id, Empleado actEmpleado){
        Empleado empleadoActual = empleadoRepository.findById(id).orElseThrow();
        empleadoActual.setNombre(actEmpleado.getNombre());
        empleadoActual.setCorreo(actEmpleado.getCorreo());
        empleadoActual.setCargo(actEmpleado.getCargo());

        return this.empleadoRepository.save(empleadoActual);
    }

    //método para eliminar
    public Empleado eliminarEmpleado(Long id){
        Empleado empleadoActual = empleadoRepository.findById(id).orElseThrow();//pero ésta, muestra lo que se borró
        this.empleadoRepository.deleteById(id);//solo con ésta linea funciona
        //crearPaciente(pacienteActual);
        return empleadoActual;//ésta tampoco es necesaria, se puede retornar un "null"
    }

}
