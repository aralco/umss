package bo.edu.umss.algorithms.competitions.contest11;

//UVA - 10209 - Is This Integration ?
//https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=1150

//http://lbv-pc.blogspot.com/2012/11/is-this-integration.html
//http://www.questtosolve.com/browse.php?vol=102
//https://revisionmaths.com/advanced-level-maths-revision/pure-maths/trigonometry/radians
//http://minstrel-uva.blogspot.com/2011/10/acm-10209.html
//https://www.universoformulas.com/matematicas/geometria/area-triangulo-isosceles/
//https://www.universoformulas.com/matematicas/geometria/triangulo-rectangulo/
//https://www.universoformulas.com/matematicas/trigonometria/resolucion-triangulos/
//https://www.rapidtables.com/math/trigonometry/sin.html
//https://www.rapidtables.com/math/trigonometry/arctan.html
//https://www.rapidtables.com/math/trigonometry/arccos.html
//https://es.planetcalc.com/1421/
//https://es.wikipedia.org/wiki/Segmento_circular
//https://www.codecogs.com/library/maths/geometry/pure/triangles-and-circles.php
//https://revisionmaths.com/gcse-maths-revision/shape-and-space/circle-theorems
//https://www.mathopenref.com/chord.html
//https://www.mathopenref.com/circlecentral.html
//https://www.mathopenref.com/arcsectorarea.html
//https://es.wikihow.com/calcular-el-%C3%A1rea-y-el-per%C3%ADmetro
//https://es.wikihow.com/hallar-la-longitud-de-un-arco
//http://www.dmae.upct.es/~pepemar/mateprimero/trigonometria/circulo/arcoycuerda.htm
//https://www.vitutor.net/2/1/22.html
//https://miprofe.com/longitud-de-un-arco-de-circunferencia/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_A_IsThisIntegration {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input=bufferedReader.readLine())!=null) {
            double a = Double.parseDouble(input);
            calculateArea(a);
        }
    }

    static void calculateArea(double a) {
        double xAreas;//x
        double yAreas;//4y
        double zAreas;//4z
        zAreas = a*a*(4-2.0/3*Math.PI-Math.sqrt(3));
        yAreas = 4*a*a-Math.PI*a*a-2*zAreas;
        xAreas = a*a - yAreas - zAreas;
        System.out.printf("%.3f %.3f %.3f %n", xAreas, yAreas, zAreas);
    }
}
