package distribuidos.crud.controller;

import distribuidos.crud.entities.Empleado;
import distribuidos.crud.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
public class EmpleadoController {

    //@Autowired
    EmpleadoService empleadoService;

    //constructor
    public EmpleadoController(EmpleadoService empleadoService) {

        this.empleadoService = empleadoService;
    }

    /*
    @GetMapping("/empleados")
    public List<Empleado> listaPacientes(){
        return this.empleadoService.getListaEmpleado();
    }

    @GetMapping("/empleados/{id}")
    public Empleado LlamarEmpleados(@PathVariable Long id){
        return this.empleadoService.getLlamarEmpleados(id);
    }*/


    @PostMapping("/empleados")
    public RedirectView crearEmpleado(@ModelAttribute Empleado crearEm, Model model){
        model.addAttribute((crearEm));
        this.empleadoService.crearEmpleado(crearEm);
        return new RedirectView("/empleados");
    }

    @PutMapping("/empleados/{id}")
    public RedirectView actualizarEmpleado(@PathVariable Long id, Empleado actEmpleado){
        this.empleadoService.actualizarEmpleado(id, actEmpleado);
        return new RedirectView("/empleados");
    }


    @DeleteMapping("/empleados/{id}")
    public RedirectView eliminarEmpleado(@PathVariable(value = "id") Long id){
        this.empleadoService.eliminarEmpleado(id);
        return new RedirectView("/empleados");

    }

}
