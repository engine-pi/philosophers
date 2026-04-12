package philosophers;

import pi.Controller;
import pi.actor.Line;

// Go to file:///data/school/repos/inf/java/engine-pi/docs/manual/projects/philosophers.md

/**
 * Die Gabel zwischen zwei Philosophen.
 *
 * @author Johannes Neumeyer
 * @author Josef Friedrich
 *
 * @version 1.0
 */
class Fork
{
    /**
     * Gibt an, ob die Gabel aktuell benutzt wird.
     */
    private boolean used;

    /**
     * Die Darstellung der Gabel als Linie.
     */
    private Line line;

    /**
     * Konstruktor für Objekte der Klasse Gabel
     *
     * @param id Id der Gabel
     */
    Fork(int id, Line line)
    {
        super();
        used = false;
        this.line = line;
        this.id = id;
    }

    /* id */

    /**
     * Die ID der Gabel.
     */
    private int id;

    /**
     * Liefert die ID der Gabel.
     *
     * @return Die ID der Gabel.
     */
    int id()
    {
        return id;
    }

    /**
     * Es wird gewartet, bis die Gabel nicht mehr in Benutzung ist; dann wird
     * sie aufgenommen.
     *
     * @param color Die Farbe des Philosophen, der die Gabel aufnehmen möchte;
     *     die Gabel wird dann auf diese Farbe gesetzt.
     */
    synchronized void pickUp(String color)
    {
        while (used)
        {
            try
            {
                wait();
            }
            catch (InterruptedException e)
            {
                Thread.currentThread().interrupt();
            }
        }
        used = true;
        line.color(color);
    }

    /**
     * Es wird mit kurzen Wartepausen immer wieder versucht, eine Gabel
     * aufzunehmen. Gelingt dies nicht, wird die Methode nach maximal 100
     * Versuchen beendet.
     *
     * @param color Die Farbe des Philosophen, der die Gabel aufnehmen möchte;
     *     die Gabel wird bei erfolgreicher Aufnahme auf diese Farbe gesetzt.
     */
    synchronized boolean tryPickUp(String color)
    {
        // Ergänzen

        // ..............._
        // ..___ ___ . __| | ___
        // ./ __/ _ \ / _` |/ _ \
        // | (_| (_) | (_| | .__/
        // .\___\___/ \__,_|\___|

        return false;
    }

    /**
     * Die Gabel wird abgelegt; da sie dann keinen Besitzer mehr hat, wird ihre
     * Farbe auf "schwarz" gesetzt.
     */
    synchronized void putDown()
    {
        used = false;
        line.color("schwarz");
        notifyAll();
    }

    public static void main(String[] args)
    {
        Controller.instantMode(false);
        Controller.start(new DiningPhilosophers(5), 800, 800);
    }
}
