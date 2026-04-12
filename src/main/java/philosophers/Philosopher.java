package philosophers;

import java.util.Random;

import pi.Controller;
import pi.annotations.Getter;
import pi.annotations.Setter;

/**
 * Ein speisender Philosoph.
 *
 * @author Johannes Neumeyer
 * @author Josef Friedrich
 *
 * @version 1.0
 */
class Philosopher extends Thread
{
    /**
     * Die Zeitangabe in ms als Grundlage für die Bestimmung zufälliger Ess- und
     * Wartezeiten.
     */
    private int waitingTime;

    /**
     * Der Zufallsgenerator.
     */
    private Random random;

    /**
     * Der Zeitpunkt, an dem der Philosoph zuletzt gegessen hat.
     */
    private long lastMeal;

    /**
     * Konstruktor für Objekte der Klasse Philosoph.
     *
     * @param color Die Farbe des Tellers.
     * @param left Die linke Gabel, die der Philosoph nutzt.
     * @param right Die rechte Gabel, die der Philosoph nutzt.
     */
    Philosopher(String name, String color, int birth, int death)
    {
        waitingTime = 50;
        this.name = name;
        this.color = color;
        this.birth = birth;
        this.death = death;
        random = new Random();
    }

    /* forks */

    /**
     * Die linke Gabel.
     */
    private Fork leftFork;

    /**
     * Die rechte Gabel.
     */
    private Fork rightFork;

    /**
     * Setzt die beiden Gabeln.
     *
     * @param left Die linke Gabel.
     * @param right Die rechte Gabel.
     */
    @Setter
    public void forks(Fork left, Fork right)
    {
        leftFork = left;
        rightFork = right;
    }

    /**
     * Der <b>Name</b> des Philosophen.
     */
    private String name;

    /**
     *
     * @return
     */
    @Getter
    public String name()
    {
        return name;
    }

    /* color */

    /**
     * Die Farbe des Tellers.
     */
    private String color;

    @Getter
    public String color()
    {
        return color;
    }

    /* lifeTime */

    /**
     * Das <b>Geburstsjahr</b> des Philosophen.
     *
     * <p>
     * Jahre vor Christi Geburt werden als Minuszahlen dargestellt.
     * </p>
     */
    private int birth;

    /**
     * Das <b>Sterbejahr</b> des Philosophen.
     *
     * <p>
     * Jahre vor Christi Geburt werden als Minuszahlen dargestellt. Dieses
     * Attribut ist nur der Vollständigkeit halber hier aufgeführt.
     * </p>
     */
    private int death;

    @Getter
    public String lifeTime()
    {
        return birth + " - " + death;
    }

    /**
     * Gibt den Zeitpunkt aus, an dem der Philosoph zuletzt gegessen hat.
     *
     * @return Der Zeitpunkt, an dem der Philosoph zuletzt gegessen hat.
     */
    @Getter
    public long lastMeal()
    {
        return lastMeal;
    }

    /**
     * Gibt das Geburtsjahr des Philosophen aus.
     *
     * @return Das Geburtsjahr des Philosophen.
     */
    @Getter
    public int birth()
    {
        return birth;
    }

    /**
     * Gibt den Zeitpunkt aus, an dem der Philosoph zuletzt gegessen hat.
     *
     * @return Der Zeitpunkt, an dem der Philosoph zuletzt gegessen hat.
     */
    public boolean isStarving()
    {
        return System.currentTimeMillis() - lastMeal > 200;
    }

    /**
     * Der Philosoph wartet eine zufällig Zeit lang.
     */
    private void waitRandomly()
    {
        try
        {
            sleep(random.nextInt(waitingTime));
        }
        catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Der Philosoph denkt.
     */
    private void think()
    {
        waitRandomly();
    }

    /**
     * Der Philosoph isst.
     */
    private void eat()
    {
        waitRandomly();
        lastMeal = System.currentTimeMillis();
    }

    /**
     * Erfülle alle Coffman-Bedingungen.
     */
    public void fullfilCoffman()
    {
        // Ergänzen

        // ..............._
        // ..___ ___ . __| | ___
        // ./ __/ _ \ / _` |/ _ \
        // | (_| (_) | (_| | .__/
        // .\___\___/ \__,_|\___|
    }

    /**
     * Verletzte die Coffman-Bedingung 4 („Zyklisches Warten”)
     */
    public void violateCoffman4()
    {

        // Ergänzen

        // ..............._
        // ..___ ___ . __| | ___
        // ./ __/ _ \ / _` |/ _ \
        // | (_| (_) | (_| | .__/
        // .\___\___/ \__,_|\___|
    }

    /**
     * Verletze die Coffman-Bedingung 2 („Halten und Warten“)
     */
    public void violateCoffman2()
    {

        // Ergänzen

        // ..............._
        // ..___ ___ . __| | ___
        // ./ __/ _ \ / _` |/ _ \
        // | (_| (_) | (_| | .__/
        // .\___\___/ \__,_|\___|
    }

    /**
     * Die Arbeitsmethode des Threads mit einer Endlosschleife: Der Philosoph
     * nimmt nach einer Zeit des Denkens die Gabeln auf, isst und legt sie dann
     * wieder ab.
     */
    @Override
    public void run()
    {
        while (true)
        {
            fullfilCoffman();
            // violateCoffman4();
            // violateCoffman2();
        }
    }

    public static void main(String[] args)
    {
        Controller.instantMode(false);
        Controller.start(new DiningPhilosophers(5), 800, 800);
    }
}
