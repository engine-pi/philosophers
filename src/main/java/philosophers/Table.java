package philosophers;

import java.util.List;

import pi.Controller;
import pi.Scene;
import pi.actor.Circle;
import pi.actor.Image;
import pi.actor.Line;
import pi.graphics.geom.Vector;

/**
 * Ein runder Tisch an dem die Philosphen essen.
 */
public class Table
{
    /**
     * Verwaltet alle Gabeln.
     */
    private Fork[] forks;

    /**
     * Das Teller eines Philosophen.
     */
    private Circle[] plates;

    private Image[] philosopherImages;

    /**
     * @param philosophers die Philosophen, die am Tisch sitzen und essen.
     */
    public Table(Scene scene, List<Philosopher> philosophers)
    {
        // Ein großer Kreis als runder Tisch.
        scene.add(new Circle(8).center(0, 0).color("braun"));

        // Anzahl an essenden Philosophen
        int count = philosophers.size();

        forks = new Fork[count];
        plates = new Circle[count];
        philosopherImages = new Image[count];

        double rotation = 360.0 / count;

        double halfRoation = rotation / 2;

        for (int i = 0; i < count; i++)
        {
            Philosopher philosopher = philosophers.get(i);
            double currentRotation = i * rotation;
            double lineRotation = currentRotation + halfRoation;
            // Gabeln
            Line line = (Line) new Line(
                    Vector.ofAngle(lineRotation).multiply(2),
                    Vector.ofAngle(lineRotation).multiply(3)).strokeWidth(0.2)
                        .color("black");
            scene.add(line);
            forks[i] = new Fork(i, line);

            // Teller
            plates[i] = (Circle) new Circle(1).color(philosopher.color())
                .center(Vector.ofAngle(currentRotation).multiply(3));

            String philospherName = philosopher.name();

            // Bild des Philosophen i
            philosopherImages[i] = (Image) new Image(
                    "philosophers/" + philospherName + ".png").pixelPerMeter(30)
                        .center(Vector.ofAngle(currentRotation).multiply(9))
                        .label(philospherName, philosopher.lifeTime());
        }

        // Die Gabeln zuordnen
        for (int i = 0; i < count; i++)
        {
            Philosopher philosopher = philosophers.get(i);
            philosopher.forks(forks[(i + count - 1) % count], forks[i]);
        }

        scene.add(plates);
        scene.add(philosopherImages);

        scene.addFrameListener(deltaTime -> {
            for (int i = 0; i < count; i++)
            {
                // ..............._
                // ..___ ___ . __| | ___
                // ./ __/ _ \ / _` |/ _ \
                // | (_| (_) | (_| | .__/
                // .\___\___/ \__,_|\___|

                // Ergänzen: Hungert der Philosoph, so wird sein Bild etwas
                // durchsichtig.
                // z.B. image.opacity(0.5)
                // Falls er nicht hungert, ist sein Bild nicht durchsichtig, z.
                // B. image.opacity(1)
            }
        });
    }

    public static void main(String[] args)
    {
        Controller.instantMode(false);
        Controller.start(new DiningPhilosophers(5), 800, 800);
    }
}
