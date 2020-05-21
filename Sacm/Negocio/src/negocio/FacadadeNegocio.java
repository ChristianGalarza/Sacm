/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import dominio.Cita;
import dominio.Cliente;
import dominio.Producto;
import dominio.Servicioderelajacion;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author pc
 */
public class FacadadeNegocio implements IFacadadeNegocio{

    private CitaControl citaControl;
    private CalendarControl calendarControl;
    private ServicioDeRelajacionControl serviciosControl;
    private ClienteControl clienteControl;
    private ProductoControl productoControl;

    public FacadadeNegocio() {
        this.citaControl = new CitaControl();
        this.calendarControl = new CalendarControl();
        this.serviciosControl = new ServicioDeRelajacionControl();
        this.clienteControl = new ClienteControl();
        this.productoControl = new ProductoControl();
    }

    @Override
    public List<Cita> obtenerCitas() {
        return this.citaControl.obtenerCitas();
    }
    
    @Override
    public void agregarCita(Cita cita) {
        this.citaControl.agregarCita(cita);
    }
    
    @Override
    public void actualizarCita(Cita cita) {
        this.citaControl.actualizarCita(cita);
    }

    
    @Override
    public void eliminarCita(int id) {
        this.citaControl.eliminarCita(id);
    }

    @Override
    public Cita obtenerCita(int id) {
        return this.citaControl.obtenerCita(id);
    }

    @Override
    public String formatearFecha(Date fecha) {
        return this.calendarControl.formatearFecha(fecha);
    }

    @Override
    public Calendar convertirDateToCalendar(Date date) {
        return this.calendarControl.convertirDateToCalendar(date);
    }

    @Override
    public String formatearHora(Date hora) {
        return this.calendarControl.formatearHora(hora);
    }

    @Override
    public List<Cita> obtenerCitasPorFecha(Date fecha) {
        return this.citaControl.obtenerCitasPorFecha(fecha);
    }

    @Override
    public int obtenerHora(Date hora) {
        return this.calendarControl.obtenerHora(hora);
    }

    @Override
    public int obtenerMinutos(Date hora) {
        return this.calendarControl.obtenerMinutos(hora);
    }

    @Override
    public Float calcularCostoTotalCita(List<Servicioderelajacion> listaServicios) {
        return this.citaControl.calcularCostoTotalCita(listaServicios);
    }

    @Override
    public Calendar calcularDuracionCita(List<Servicioderelajacion> listaServicios) {
        return this.calendarControl.calcularDuracionCita(listaServicios);
    }

    @Override
    public Date convertirHoras(int hora, int minuto) {
        return this.calendarControl.convertirHoras(hora, minuto);
    }

    @Override
    public List<Servicioderelajacion> obtenerServiciosDeRelajacion() {
        return this.serviciosControl.obtenerServiciosDeRelajacion();
    }

    @Override
    public List<Cliente> obtenerClientes() {
        return this.clienteControl.obtenerClientes();
    }

    @Override
    public Date sumarHora(Date horaInicio, Date duracion) {
        return this.calendarControl.sumarHora(horaInicio, duracion);
    }

    @Override
    public List<Cita> verificarCitasEmpalmadas(Cita cita) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(cita.getFecha());
        String fecha = calendar.get(Calendar.YEAR)+"-"+(calendar.get(Calendar.MONTH)+1)+"-"+(calendar.get(Calendar.DAY_OF_MONTH));
        String horaInicio = new SimpleDateFormat("HH:mm:SS").format(cita.getHora());
        String horaFin = new SimpleDateFormat("HH:mm:SS").format(cita.getHoraFin());
        /*
        String query = "SELECT c\n"
                + "FROM Cita c\n"
                + "where c.fecha = \""+fecha+"\" \n"
                + "and (((c.hora > \""+horaInicio+"\" and c.hora < \""+horaFin+"\") \n"
                + "or (c.horaFin > \""+horaInicio+"\" and c.hora < \""+horaFin+"\")) \n"
                + "or (\""+horaInicio+"\" > c.hora and c.hora < c.horaFin) \n"
                + "or (\""+horaFin+"\" > c.hora and c.hora < c.horaFin))";
        */
        String query = "SELECT c\n "
                + "FROM Cita c\n"
                + "where c.fecha = \""+fecha+"\"\n"
                + "and (((c.hora < \""+horaInicio+"\" and \""+horaInicio+"\" < c.horaFin) \n"
                + "or (c.hora < \""+horaFin+"\" and \""+horaFin+"\" < c.horaFin) \n"
                + "or (c.hora = \""+horaInicio+"\" and c.horaFin = \""+horaFin+"\"))\n"
                + "or ((c.hora > \""+horaInicio+"\" and \""+horaFin+"\" > c.hora) \n"
                + "or (c.horaFin > \""+horaInicio+"\" and \""+horaFin+"\" > c.horaFin) \n"
                + "or (c.hora = \""+horaInicio+"\" and c.horaFin = \""+horaFin+"\")))";
                
        return this.citaControl.generarQuery(query);
    }

    @Override
    public void agregarCliente(Cliente t) {
        this.clienteControl.agregarCliente(t);
    }

    @Override
    public void actualizarCliente(Cliente t) {
        this.clienteControl.actualizarCliente(t);
    }

    @Override
    public void eliminarCliente(int id) {
        this.clienteControl.eliminarCliente(id);
    }

    @Override
    public Cliente obtenerCliente(int id) {
        return this.clienteControl.obtenerCliente(id);
    }    

    @Override
    public List<Producto> obtenerProductos() {
        return this.productoControl.obtenerProductos();
    }

    @Override
    public void agregarProducto(Producto t) {
        this.productoControl.agregarProducto(t);
    }

    @Override
    public void actualizarProducto(Producto t) {
        this.productoControl.actualizarProducto(t);
    }

    @Override
    public void eliminarProducto(int id) {
        this.productoControl.eliminarProducto(id);
    }

    @Override
    public Producto obtenerProducto(int id) {
        return this.productoControl.obtenerProducto(id);
    }

    @Override
    public void agregarServicioDeRelajacion(Servicioderelajacion servicio) {
        this.serviciosControl.agregarServicioDeRelajacion(servicio);
    }

    @Override
    public void eliminarServicioDeRelajacion(Servicioderelajacion servicio) {
        this.serviciosControl.eliminarServicioDeRelajacion(servicio.getIdServicioDeRelajacion());
    }

    @Override
    public void actualizarServicioDeRelajacion(Servicioderelajacion servicio) {
        this.serviciosControl.actualizarServicioDeRelajacion(servicio);
    }
}
