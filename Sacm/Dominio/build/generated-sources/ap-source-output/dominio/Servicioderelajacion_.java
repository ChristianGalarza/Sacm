package dominio;

import dominio.Cita;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-04-21T15:26:23")
@StaticMetamodel(Servicioderelajacion.class)
public class Servicioderelajacion_ { 

    public static volatile SingularAttribute<Servicioderelajacion, Integer> idServicioDeRelajacion;
    public static volatile SingularAttribute<Servicioderelajacion, Float> costo;
    public static volatile SingularAttribute<Servicioderelajacion, Date> duracion;
    public static volatile SingularAttribute<Servicioderelajacion, String> nombre;
    public static volatile ListAttribute<Servicioderelajacion, Cita> citaList;

}