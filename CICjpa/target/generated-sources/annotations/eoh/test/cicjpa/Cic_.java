package eoh.test.cicjpa;

import eoh.test.cicjpa.Entity;
import eoh.test.cicjpa.enums.CicType;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-02-11T17:08:45")
@StaticMetamodel(Cic.class)
public class Cic_ { 

    public static volatile SingularAttribute<Cic, String> subject;
    public static volatile SingularAttribute<Cic, String> sourceSystem;
    public static volatile SingularAttribute<Cic, Date> cicTimeStamp;
    public static volatile SingularAttribute<Cic, Long> id;
    public static volatile SingularAttribute<Cic, CicType> type;
    public static volatile SingularAttribute<Cic, String> body;
    public static volatile SingularAttribute<Cic, Entity> entity;

}