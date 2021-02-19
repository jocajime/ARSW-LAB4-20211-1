package edu.eci.arsw.blueprints.test.persistence.impl;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.persistence.impl.InMemoryBlueprintPersistence;
import edu.eci.arsw.blueprints.services.BlueprintsServices;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class FilterTest {


    @Test
    public void getFilterBluePrint() throws BlueprintPersistenceException, BlueprintNotFoundException {
        BlueprintsServices bs=new BlueprintsServices ();

        Point[] pts0=new Point[]{new Point(40, 40),new Point(40, 40)};
        Blueprint bp0=new Blueprint("mack", "mypaint",pts0);
        bs.addNewBlueprint (bp0);

        Point[] pts=new Point[]{new Point(40, 40)};
        Blueprint bp=new Blueprint("mack", "mypaint",pts);

        assertEquals (bp.getPoints ().size (), bs.getBlueprint ("mack","mypaint").getPoints ().size ());

    }




    @Test
    public void getFilterBluePrints() throws BlueprintPersistenceException, BlueprintNotFoundException {
        BlueprintsServices bs=new BlueprintsServices ();
        InMemoryBlueprintPersistence ibpp=new InMemoryBlueprintPersistence();

        Point[] pts0=new Point[]{new Point(40, 40),new Point(40, 40)};
        Blueprint bp0=new Blueprint("mack", "mypaint",pts0);
        bs.addNewBlueprint (bp0);

        Point[] pts1=new Point[]{new Point(40, 40)};
        Blueprint bp1=new Blueprint("mack", "mypaint",pts1);


        assertEquals (bs.getBlueprintsByAuthor ("mack").iterator ().next ().getPoints ().size (),bp1.getPoints ().size ());

    }




}
