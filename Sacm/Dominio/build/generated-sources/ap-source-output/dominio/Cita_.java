package dominio;

import dominio.Cliente;
import dominio.Servicioderelajacion;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-03-18T18:52:39")
@StaticMetamodel(Cita.class)
public class Cita_ { 

    public static volatile SingularAttribute<Cita, Integer> idCita;
    public static volatile SingularAttribute<Cita, Date> fecha;
    public static volatile SingularAttribute<Cita, Cliente> idCliente;
    public static volatile SingularAttribute<Cita, Date> hora;
    public static volatile SingularAttribute<Cita, Float> costoTotal;
    public static volatile SingularAttribute<Cita, Date> duracion;
    public static volatile ListAttribute<Cita, Servicioderelajacion> servicioderelajacionList;

}