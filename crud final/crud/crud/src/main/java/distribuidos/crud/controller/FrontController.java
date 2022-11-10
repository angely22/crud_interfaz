package distribuidos.crud.controller;

import distribuidos.crud.entities.Empleado;
import distribuidos.crud.service.EmpleadoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class FrontController {

    EmpleadoService empleadoService;
    public FrontController(EmpleadoService empleadoService){
        this.empleadoService = empleadoService;
    }

    @GetMapping("/") //ruta raíz
    public String index(){
        return "index";
    }


    @GetMapping("/empleados")
    public String empleados(Model modelP){  //uso string porque lo q visualizo en páginas web son cadenas de texto
        //se debe crear un modelo para que el backend pueda ser visualizado e el frontend
        List<Empleado> empleados = this.empleadoService.getListaEmpleado();
        modelP.addAttribute("empleados", empleados);
        return "empleados";
    }

    @GetMapping("empleados/nuevo")
    public String nuevoEmpleado(Model model){
        model.addAttribute("empleado", new Empleado());
        return "nuevo-empleado";
    }

    @GetMapping("/empleados/{id}")
    public String actualizarEmpleado(@PathVariable Long id, Model model){
        Empleado empleadoFind = this.empleadoService.getLlamarEmpleados(id);
        model.addAttribute("empleadoFind", empleadoFind);
        return "actualizar-empleado";
    }

}
